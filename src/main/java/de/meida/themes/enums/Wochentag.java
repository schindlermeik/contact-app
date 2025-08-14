package de.meida.themes.enums;

import java.util.Date;

public enum Wochentag implements Comparable<Wochentag> {
    MONTAG(1, 0),
    MONTAG_NACHMITTAG(2, 0),
    DIENSTAG(3, 4),
    MITTWOCH(4, 4);

    Wochentag(int sort, int arbeitsZeiten) {
        this.sort = sort;
        this.arbeitsZeiten = arbeitsZeiten;
    }

    private int sort;
    private int arbeitsZeiten;

    public int getSort() {
        return sort;
    }

    public int getArbeitzeiten() {
        return arbeitsZeiten;
    }


    public static void main(String[] args) {

        Wochentag heute = Wochentag.MITTWOCH;


        System.out.println(heute);
        System.out.println(heute.ordinal());
    }


}
