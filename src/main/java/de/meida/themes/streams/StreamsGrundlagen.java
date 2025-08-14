package de.meida.themes.streams;

import java.util.Arrays;
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

        int[] a = {1,2,3};
    }

    public static int summiereUndMulitpliziereAlleGeradenZahlen(List<Integer> list ){
        int sum = 0;
        for (Integer i : list) {
            if(i % 2 == 0){
              sum  +=  i * i;
            }
        }
        return sum;
    }

    public static int summiereUndMulitpliziereAlleGeradenZahlenWithStreams(List<Integer> list ){

        return list.stream()
                .mapToInt(Integer::intValue)
                .filter( x -> x % 2 == 0 )
                .map( x -> x * x)
                .sum();
               // .reduce(0, Integer::sum);

        // List(1,2,3)
        //3, 2, 1
    }
}
