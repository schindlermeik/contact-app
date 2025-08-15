package de.meida.themes.streams;

import de.meida.app.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
        example();

    }

    public static void example() {

        List<Contact> contacts = new ArrayList<>(List.of(
                new Contact(1L, "Ada", null, null),
                new Contact(2L, "Linus", null, null),
                new Contact(3L, "Brendan", null, null),
                new Contact(4L, "Ada", null, null)
        ));
        Map <Boolean,List<Contact>> filtered = contacts.stream()
                //.filter(x -> x.getName().startsWith("A"))
                .collect(Collectors.partitioningBy(x -> x.getId() <= 2) );
        System.out.println(filtered);

    }
}
