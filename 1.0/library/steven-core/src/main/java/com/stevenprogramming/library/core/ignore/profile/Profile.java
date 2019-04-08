package com.stevenprogramming.library.core.ignore.profile;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 
 * @author Vincent Mimoun-Prat
 *
 */
public class Profile  {
    private static final String CSV_HEADERS = "Name, Call Count, Total Time (ms), Average Time (ms), Min Time (ms), Max Time (ms), Delta Time (ms), Delta Ratio (%)\n";

    private static final String FORMAT_STRING = "%-" + Profiler.THEORETICAL_MAX_NAME_LENGTH + "."
            + Profiler.THEORETICAL_MAX_NAME_LENGTH
            + "s: %3d calls, total %5d ms, avg %5d ms, min %5d ms, max %5d ms, delta %5d ms (%d%%)";

    private static final String CSV_FORMAT_STRING = "%s,%d,%d,%d,%d,%d,%d,%d\n";

    private String name;
    private long startTime;
    private long callCount;
    private long totalTime;
    private long minTime;
    private long maxTime;

    public Profile(String name) {
        this.name = name;
        this.callCount = 0;
        this.totalTime = 0;
        this.startTime = 0;
        this.minTime = Long.MAX_VALUE;
        this.maxTime = Long.MIN_VALUE;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        final long elapsed = (System.currentTimeMillis() - startTime);
        if (elapsed < minTime) minTime = elapsed;
        if (elapsed > maxTime) maxTime = elapsed;
        totalTime += elapsed;
        callCount++;
    }

    private String getFormattedStats(String format) {
        final long avgTime = callCount == 0 ? 0 : (long) totalTime / callCount;
        final long delta = maxTime - minTime;
        final double deltaRatio = avgTime == 0 ? 0 : 100.0 * ((double) 0.5 * delta / (double) avgTime);

        return String
                .format(format, name, callCount, totalTime, avgTime, minTime, maxTime, delta, (int) deltaRatio);
    }

    @Override
    public String toString() {
        return getFormattedStats(FORMAT_STRING);
    }

    public static void writeCsvHeader(OutputStream os) throws IOException {
        os.write(CSV_HEADERS.getBytes());
    }

    public void writeCsvLine(OutputStream os) throws IOException {
        os.write(getFormattedStats(CSV_FORMAT_STRING).getBytes());
    }
}

