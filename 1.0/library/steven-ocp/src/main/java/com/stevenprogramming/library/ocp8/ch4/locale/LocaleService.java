package com.stevenprogramming.library.ocp8.ch4.locale;

import java.util.Locale;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Mar 26 2019
 * @version 1.0
 */
public class LocaleService
{
    private void printValues(Locale locale){
        System.out.println("\n\n\t\t Printing ");
        System.out.println("Country: " + locale.getCountry());
        System.out.println("getDisplayCountry: " + locale.getDisplayCountry());
        System.out.println("getDisplayCountry: " + locale.getDisplayCountry(locale));
        System.out.println("Country getISO3Language: " + locale.getISO3Language());
        System.out.println("Country getLanguage: " + locale.getLanguage());
        System.out.println("Country getDisplayLanguage: " + locale.getDisplayLanguage());
    }
    private void createLocate(){
        Locale locale = new Locale("it" );
        printValues(locale);
        locale = new Locale("es", "CR");
        printValues(locale);
        locale = new Locale("it" );
        printValues(locale);
        locale = new Locale("ES", "CR");
        printValues(locale);
        locale = new Locale("eS", "CR");
        printValues(locale);
        locale = new Locale("eS", "cr");
        printValues(locale);
        locale = new Locale.Builder().setLanguage("en").setRegion("US").build();
        printValues(locale);
        locale = new Locale.Builder().setLanguage("en").setRegion("CR").build();
        printValues(locale);
        locale = new Locale.Builder().setLanguage("eN").setRegion("cr").build();
        printValues(locale);
        locale = new Locale.Builder().setLanguage("dA").setRegion("dK").build();
        printValues(locale);
        locale = new Locale.Builder().build();
        printValues(locale);
        Locale defaultLocale = Locale.getDefault();
        System.out.println(defaultLocale.getDisplayVariant());
        System.out.println(defaultLocale.getDisplayVariant(Locale.US));
        System.out.println((new Locale("en", "US", "WIN_TX_Austin")).getDisplayVariant());


    }
    public static void main(String[] args){
        LocaleService localeService = new LocaleService();
        localeService.createLocate();
    }
}
