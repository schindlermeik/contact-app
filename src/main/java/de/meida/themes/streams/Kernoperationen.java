package de.meida.themes.streams;

import java.util.List;
import java.util.stream.Stream;

public class Kernoperationen {

    public static void main(String[] args) {
        // streams win lazy in der ausführung

        List<Integer> integers = List.of(25, 17, 43, 42);

        Stream<Integer> stream = integers.stream().filter(x-> x % 4 == 0);
        // ganz viel dazwische
        int sum  = stream.reduce(0, Integer::sum);

        // intermediate operationen
        /*
            filter
            map
            distinct
            sorted
            skip
            limit
            peek -> debugging
         */


        // terminierenden Operationen
        /*
         reduce
         count
         collect
         findfirst
         anyMatch  //bool
         allMatch  //bool
         neneMatch  // bool
         */

    }
}
