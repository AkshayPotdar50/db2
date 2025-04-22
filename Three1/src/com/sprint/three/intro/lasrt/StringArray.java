package com.sprint.three.intro.lasrt;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringArray {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "apple", "orange", "banana", "kiwi", "kiwi", "kiwi"};


        Map<String, Long> wordFreq = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));



        String mostRepeated = Arrays.stream(words)
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(Function.identity(), Collectors.counting()),
                        map -> map.entrySet().stream()
                                .max(Map.Entry.comparingByValue())
                                .map(Map.Entry::getKey)
                                .orElse(null)
                ));


        Set<String> seen = new HashSet<>();
        Set<String> duplicates = Arrays.stream(words)
                .filter(word -> !seen.add(word))
                .collect(Collectors.toSet());


        //sort alphabetically
        String[] sorted = Arrays.stream(words)
                .sorted()
                .toArray(String[]::new);


        

    }
}
