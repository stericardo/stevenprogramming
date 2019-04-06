package com.stevenprogramming.library.ocp8.ch4.time;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.zone.ZoneRules;

public class ZonePractice
{

    public static void getZoneAndPrint(String zoneIdString)
    {
        LocalDateTime localDateTime = LocalDateTime.now();
        //ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.from( Temporal ))
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of( zoneIdString ));
        System.out.println( zonedDateTime );

        ZoneId zoneId = ZoneId.of( zoneIdString);
        ZoneRules zoneRules = zoneId.getRules();
        boolean result= zoneRules.isDaylightSavings( zonedDateTime.toInstant(  ) );
        System.out.println( result );

    }

    public static void getTimeZoneFromNowAndPlusTemporalAdjuster(String zoneIdString){
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of( zoneIdString ));

        DayOfWeek dayOfWeek = DayOfWeek.THURSDAY;
        TemporalAdjuster temporalAdjuster = TemporalAdjusters.next( dayOfWeek );

        ZonedDateTime zonedDateTimeAdjust = zonedDateTime.with( temporalAdjuster );
        System.out.println( zonedDateTimeAdjust );

    }

    public static void main( String[] args )
    {
        getZoneAndPrint("US/Pacific");
        getTimeZoneFromNowAndPlusTemporalAdjuster("US/Pacific");
    }

}