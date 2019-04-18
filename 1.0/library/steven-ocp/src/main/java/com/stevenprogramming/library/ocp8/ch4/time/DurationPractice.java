package com.stevenprogramming.library.ocp8.ch4.time;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationPractice
{

    public static void durationFirstExample(){
        LocalTime localTime1 = LocalTime.of( 12,00,10 );
        LocalTime localTime2 = LocalTime.of( 13,12,20 );
        System.out.println("Time 1 = " + localTime1 + " Time 2= " +localTime2);

        /*
        LocalTime implements Temporal, TemporalAdjuster, Comparable <LocalTime>
        ChronoUnit.MINUTES.between receive a temporal
         */

        long timeDiff = ChronoUnit.MINUTES.between( localTime1, localTime2 );

        /*
                Duration implements TemporalAmount, Comparable<Duration>
         */
        Duration duration = Duration.ofMinutes( timeDiff );
        System.out.println( duration );
        // localTime1.plus receives: TemporalAmount
        LocalTime differenceLocalTime = localTime1.plus(duration);

        System.out.println( differenceLocalTime );
        // As we could see response was 13:12:10, losing some seconds

        timeDiff = ChronoUnit.SECONDS.between( localTime1, localTime2 );
        duration = Duration.ofSeconds( timeDiff );
        System.out.println( "******* PT1H12M10S" );
        System.out.println( duration );
        differenceLocalTime = localTime1.plus(duration);
        System.out.println( differenceLocalTime );
        // Here we can see exact value of time because of ChronoUnit.SECONDS

        duration = Duration.ofSeconds( 70 );
        System.out.println( "******** Response PT1M10S " );
        System.out.println( duration );

        duration = Duration.ofSeconds( 60 );
        System.out.println( "******** Response PT1M" );
        System.out.println( duration );

        duration = Duration.ofSeconds( 59 );
        System.out.println( "******** Response PT59S" );
        System.out.println( duration );

        duration = Duration.ofMinutes( 59 );
        System.out.println( "******** Response PT59M" );
        System.out.println( duration );

        duration = Duration.ofMinutes( 3500 );
        System.out.println( "******** Response PT58H20M" );
        System.out.println( duration );


    }
    public static void main(String[] args){
        durationFirstExample();
    }

}
