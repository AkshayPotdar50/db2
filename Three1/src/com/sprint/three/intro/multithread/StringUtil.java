package com.sprint.three.intro.multithread;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringUtil {

    // Record for structured result
    public record VowelConsonantCount(int vowels, int consonants) {}

    public static VowelConsonantCount countVowelsAndConsonants(String input) {
        int vowels = 0, consonants = 0;
        input = input.toLowerCase().strip().replaceAll("[^a-z]", "");
        for (char c : input.toCharArray()) {
            switch (c) {
                case 'a', 'e', 'i', 'o', 'u' -> vowels++;
                default -> consonants++;
            }
        }
        return new VowelConsonantCount(vowels, consonants);
    }

    public static String removeDuplicates(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static boolean areAnagrams(String s1, String s2) {
        return s1.chars().sorted().boxed().toList().equals(s2.chars().sorted().boxed().toList());
    }

    public static Character firstNonRepeatingChar(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);
    }

    public static Map<Character, Long> countCharOccurrences(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static boolean isOnlyDigits(String input) {
        return input.strip().matches("\\d+");
    }

    public static String capitalizeWords(String input) {
        return Pattern.compile("\\s+")
                .splitAsStream(input.strip())
                .map(word -> word.isEmpty() ? word : Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));
    }

    public static String findLongestWord(String sentence) {
        return Pattern.compile("\\s+")
                .splitAsStream(sentence.strip())
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }

    public static boolean areRotations(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

    public static String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) return "";
        String prefix = strings[0];
        for (int i = 1; i < strings.length; i++) {
            while (!strings[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static String compressString(String input) {
        if (input == null || input.isEmpty()) return input;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char prev = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == prev) count++;
            else {
                sb.append(prev).append(count);
                prev = input.charAt(i);
                count = 1;
            }
        }
        sb.append(prev).append(count);
        return sb.toString();
    }

    public static boolean hasAllUniqueChars(String input) {
        return input.chars().mapToObj(c -> (char) c).allMatch(new HashSet<>()::add);
    }

    public static int strstr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static List<String> splitWords(String input) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isWhitespace(c)) {
                if (sb.length() > 0) {
                    words.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) words.add(sb.toString());
        return words;
    }

    public static String removeWhitespaces(String input) {
        return input.replaceAll("\\s", "");
    }

    public static int stringToInt(String str) {
        int num = 0, i = 0, sign = 1;
        str = str.strip();
        if (str.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        for (; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) throw new NumberFormatException();
            num = num * 10 + (str.charAt(i) - '0');
        }
        return sign * num;
    }

    public static int countWords(String input) {
        return (int) Pattern.compile("\\s+").splitAsStream(input.strip()).filter(w -> !w.isBlank()).count();
    }

    public static String replaceChar(String input, char oldChar, char newChar) {
        return input.replace(oldChar, newChar);
    }
}

