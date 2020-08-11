package com.example.demo;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.Temporal;

public class DatesTest {

    @Test
    public void dateTest(){
        OffsetDateTime dateTime = OffsetDateTime.now();
        //System.out.println(dateTime);

        OffsetDateTime dateTime2 = OffsetDateTime.now(ZoneId.systemDefault());
        //System.out.println("NOW ***** " + dateTime2);

        OffsetDateTime dateTime3 = dateTime2.withOffsetSameLocal(ZoneOffset.UTC);
        //System.out.println("Time 3>>>>>   " + dateTime3);

        OffsetDateTime dateTime4  = OffsetDateTime.of(dateTime3.getYear(), dateTime3.getMonthValue(),
                dateTime3.getDayOfMonth()+1, 0,0,0,0, ZoneOffset.UTC );
        Temporal temporal = dateTime4.adjustInto(dateTime3);
        //System.out.println("Time 3>>>>>   " + dateTime3);
        //System.out.println(dateTime4);
        //System.out.println(temporal);

        //System.out.println(dateTime3.toInstant().atOffset( ZoneOffset.UTC ));

        Instant i =LocalDateTime.now().toInstant(ZoneOffset.UTC);
        OffsetDateTime  o = i.atOffset(ZoneOffset.ofHours(-6));
        //System.out.println("utc  : " + i);
       // System.out.println("Here : " + o);

        //OffsetDateTime  o2 = o.wi(ZoneOffset.ofHours(-6));

        OffsetDateTime dateCurrent = OffsetDateTime.now().withHour(18).withMinute(0).withSecond(0).withNano(0);
        System.out.println("JOSE ORIGIN: " +dateCurrent);

        OffsetDateTime utc = dateCurrent.withOffsetSameInstant(ZoneOffset.UTC);
        System.out.println("JOSE UTC: " + utc);

        OffsetDateTime dateTime5 = OffsetDateTime.now().withHour(18);
        System.out.println("Steven Origin ***** " + dateTime5);

        OffsetDateTime dateTime6 = dateTime5.withOffsetSameInstant(ZoneOffset.UTC);
        System.out.println("Steven UTC >>>>>  " + dateTime6);



    }
}
