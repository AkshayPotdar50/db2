package com.sprint.three.intro.lasrt;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayMode {
    public static void main(String[] args) {

        int[] element1={2, 1, 3, 4, 4, 1, 4, 333, 33, 3, 333, 2, 2, 2, 8, 222};

        //1.frequency of each element
        Map<Integer, Long> frequencyMap = Arrays.stream(element1)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));



       /* Integer firstUnique = Arrays.stream(element1)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);*/

    }

    private static void mostRepeatedElement(){
        int[] element={2, 1, 3, 4, 4, 1, 4, 333, 33, 3, 333, 2, 2, 2, 8, 222};

        Function<Map<Integer, Long>, Integer> maxValuesKey =map->
                map.entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                        .map(Map.Entry::getKey)
                        .orElse(Integer.MAX_VALUE);


        Integer maxDuplicateValue= Arrays.stream(element)
        .boxed()
        .collect(Collectors.collectingAndThen(
                Collectors.groupingBy(Function.identity(), Collectors.counting()),
                maxValuesKey
        ));
    }
}
