package de.meida.themes.streams;

import java.util.List;
import java.util.stream.Stream;

public class StreamsGrundlagen {

    public static void main(String[] args) {
        List<Integer> values= List.of(1, 4, 5, 7, 12, 15);

       Stream<Integer> str = values
               .stream().filter(var -> var % 2 == 0);
       // intermediate Methoden aufrufen

  // terminierende Methode to List

        List<Integer> list = str.toList();  // terminierende Methode to List

        // der stream ist tod;

        long count = str.count();
    }
}
