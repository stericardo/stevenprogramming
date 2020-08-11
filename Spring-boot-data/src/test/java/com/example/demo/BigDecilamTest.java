package com.example.demo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecilamTest {

    @Test
    public void numberTest(){
        BigDecimal g = new BigDecimal("12.23566");
        BigDecimal result = g.setScale(2, RoundingMode.HALF_UP);
   //     System.out.println(result);

        MathContext mc = new MathContext(120, RoundingMode.HALF_UP);

        BigDecimal defaultV = new BigDecimal("0.00", mc);
        BigDecimal defaultV2 = defaultV.setScale(2);

        System.out.println(defaultV.equals(defaultV2));


    }
}
