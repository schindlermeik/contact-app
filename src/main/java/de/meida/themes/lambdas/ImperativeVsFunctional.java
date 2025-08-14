package de.meida.themes.lambdas;

import de.meida.app.Contact;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ImperativeVsFunctional {

    public static void main(String[] args) {
  /*      List<Integer> values= List.of(1, 5, 7, 12, 15);

        // imerativ
        int sum = 0;
        for (Integer value : values) {
            System.out.println(value);
        }
        System.out.println(sum);
        sum = 0;
        sum = values.stream().reduce(0, Integer::sum);
        System.out.print(sum);
        values.forEach(v -> System.out.println(v));

       *//* values.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });*//*

        //Syntax vn lambdas
        */
       /* Runnable runnable = () -> System.out.println("ich werde im Runnable aufgerufen");
        Consumer<String> consumer =    System.out::println;//s -> System.out.println(s); object methoden referenz
        Comparator<Integer> comparator =  ImperativeVsFunctional::vergleice;//(v1, v2) -> v1.compareTo(v2);
        System.out.println(comparator.compare(5, 7));

        Predicate<String> predictate = s -> {
            System.out.println(s);
          return s.equals("Susi");
        };

        Supplier<Contact> supplier = () -> new Contact("Susi", null, null);



        createContact(() -> new Contact("Susi", null, null));
        createContact(new Contact("Susi", null, null));*/
        Comparator<Contact> comp = (v1, v2) -> v1.getName().compareTo(v2.getName());
      /*  System.out.println(comp.
                compare(new Contact(null, "Susi", null, null),
                        new Contact(null, "Susi", null, null)));*/
        exampleSort();
    }

    public static int vergleice(int a, int b) {
        return 0;
    }

    public static void createContact(Supplier<Contact> contactSupplier){
            // validierung
            // repository.create(contactSuplier.get());
    }

    public static void createContact(Contact contact){
            // validierung
            //repository.create(contsct);
    }


    public static void exampleSort() {

        List<Contact> contacts = new ArrayList<>(List.of(
                new Contact("Ada", null, null),
                new Contact("Linus", null, null),
                new Contact("Brendan", null, null),
                new Contact("Ada", null, null)
        ));

        contacts.sort(((v1, v2) -> v1.getName().compareTo(v2.getName())));
        //contacts.sort(Comparator.comparing(Contact::getName)); //thenComparingInt(Person::age));
        contacts.forEach(System.out::println);

        System.out.println(contacts.get(1));;
    }


}


