package com.stevenprogramming.library.ocp8.ch4.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimePractice
{
    public static void printNowLocalDateTime(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of( localDate, localTime );
        System.out.println(localDateTime);

        LocalDateTime localDateTimeSimple = LocalDateTime.now();
        System.out.println(localDateTime);
    }

    public static void printCertDate(){
        LocalDate eclipse1 = LocalDate.of( 2017, 8, 21 );
        LocalDate eclipse2 = LocalDate.parse( "2017-08-21" );
        System.out.println(eclipse1 + " " + eclipse2);
    }

    public static void printCertTime(){
        LocalTime eclipse1 = LocalTime.of( 9, 6, 43 );
        LocalTime eclipse2 = LocalTime.parse( "10:19:36" );
        System.out.println(eclipse1 + " " + eclipse2);
    }

    public static void printFormatDate(){
        String eclipseTime = "2017-08-15 12:20:20";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm:ss" );
        LocalDateTime eclipseDateTime = LocalDateTime.parse( eclipseTime, dateTimeFormatter );
        System.out.println(eclipseDateTime + ":::" + eclipseDateTime.getDayOfWeek() + ":::" + eclipseDateTime.getDayOfMonth() + ":::" + eclipseDateTime.getDayOfYear());

        LocalDateTime eclipseDateTimePlus =eclipseDateTime.plusHours( 2 );
        System.out.println(eclipseDateTimePlus + ":::" + eclipseDateTimePlus.getDayOfWeek() + ":::" + eclipseDateTimePlus.getDayOfMonth() + ":::" + eclipseDateTimePlus.getDayOfYear());

        eclipseDateTimePlus =eclipseDateTime.plusDays( 2 );
        System.out.println(eclipseDateTimePlus + ":::" + eclipseDateTimePlus.getDayOfWeek() + ":::" + eclipseDateTimePlus.getDayOfMonth() + ":::" + eclipseDateTimePlus.getDayOfYear());

        Duration durationResult = Duration.between( eclipseDateTime, eclipseDateTimePlus );
        System.out.println(durationResult.toDays());

    }

    public static void main(String[] args){
        printNowLocalDateTime();
        printCertDate();
        printCertTime();
        printFormatDate();
    }
}
