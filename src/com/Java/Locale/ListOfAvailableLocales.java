/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java.Locale;

/**
 *
 * @author Vinit
 */
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ListOfAvailableLocales {

    public static void main(String[] args) {
        //printAvailableLocales();
        showLangInfo();
    }

    public static void printAvailableLocales() {
        Locale list[] = SimpleDateFormat.getAvailableLocales();

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].toString() + "\t\t" + list[i].getDisplayName());
        }
    }

    public static void showLangInfo() {
        /*
            stackoverflow.com/questions/17292575/how-to-get-all-java-supported-locales
        */
        Locale loc = new Locale("ta", "IN"); // ta_IN, si_LK
        System.out.printf("Name: %s%n"
                + "Country: %s; %s - %s%n"
                + "Language: %s; %s - %s%n"
                + "Script: %s - %s%n",
                loc.getDisplayName(Locale.ENGLISH),
                loc.getCountry(), loc.getISO3Country(), loc.getDisplayCountry(Locale.ENGLISH),
                loc.getLanguage(), loc.getISO3Language(), loc.getDisplayLanguage(Locale.ENGLISH),
                loc.getScript(), loc.getDisplayScript(Locale.ENGLISH));
    }

}
