package de.meida.themes.generics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); // raw type
        list.add("aaa");
        /*list.add(42);
        list.add(new Date());
*/
        for (String o : list) {
            System.out.println(o.toUpperCase());
        }
    }

}
