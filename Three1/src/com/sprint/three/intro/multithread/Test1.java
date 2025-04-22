package com.sprint.three.intro.multithread;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        String s1="rahul dravid";

        String output=s1.chars().mapToObj(c->(char)c).collect(Collectors.toCollection(LinkedHashSet::new))
                .stream().map(String::valueOf).collect(Collectors.joining());

        System.out.println(output);

        //if string contains both capital and small

       // String output2=s1.chars().mapToObj(c->(char)c).collect(Collectors.toMap(c->Character.toLowerCase(c)))



        countVowelsAndConsonants("Java is Awesome!");
        System.out.println(removeDuplicates("banana"));
        System.out.println(areAnagrams("listen", "silent"));
        System.out.println(firstNonRepeatingChar("swiss"));
        System.out.println(countCharOccurrences("java"));
        System.out.println(isOnlyDigits("1234"));
        System.out.println(capitalizeWords("java is awesome"));
        System.out.println(findLongestWord("The quick brown fox jumps"));
        System.out.println(areRotations("abcde", "cdeab"));
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(compressString("aaabbcddd"));
        System.out.println(hasAllUniqueChars("abcde"));
        System.out.println(strstr("hello", "ll"));
        System.out.println(splitWords("Split this string manually"));
        System.out.println(removeWhitespaces("remove all white spaces"));
        System.out.println(stringToInt("  -12345"));
        System.out.println(countWords("Count how many words here"));
        System.out.println(replaceChar("replace me", 'e', '*'));
    }

    //*Reverse a string* without using built-in reverse methods.
    public static String reverseString(String str){
        char[] charArray=str.toCharArray();
        int left=0;
        int right=charArray.length-1;

        while(left < right){
            char temp=charArray[left];
            charArray[left]=charArray[right];
            charArray[right]=temp;

            left++;
            right--;

        }
        return new String(charArray);
    }

    //*Check if a string is a palindrome* (same forwards and backwards).
    public static boolean isPalindrome(String str){
        int left=0;
        int right=str.length()-1;
        while(left <right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }




    public static boolean isPalindrome2(String str){
        str=str.replaceAll("[a-zA-Z0-9]", " ");
        return str.equals(new StringBuilder(str).reverse().toString());
    }





    public static boolean isPalindrome3(String str){
        str=str.replaceAll("[a-zA-Z0-9]", " ");
        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i) !=str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }




    // 4. Count vowels and consonants
    public static void countVowelsAndConsonants(String input) {
        int vowels = 0, consonants = 0;
        input = input.toLowerCase().replaceAll("[^a-z]", "");
        for (char c : input.toCharArray()) {
            if ("aeiou".indexOf(c) != -1)
                vowels++;
            else
                consonants++;
        }
        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
    }



    // 5. Remove duplicate characters
    public static String removeDuplicates(String input) {
        Set<Character> seen = new LinkedHashSet<>();
        for (char c : input.toCharArray()) {
            seen.add(c);
        }
        return seen.stream().map(String::valueOf).collect(Collectors.joining());
    }




    // 6. Check anagram
    public static boolean areAnagrams(String s1, String s2) {
        return sortString(s1).equals(sortString(s2));
    }

    private static String sortString(String s) {
        return s.chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }




    // 7. First non-repeating character
    public static Character firstNonRepeatingChar(String input) {
        Map<Character, Long> count = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        return count.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
    }




    // 8. Count occurrences of characters
    public static Map<Character, Long> countCharOccurrences(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }





    // 9. Check if only digits
    public static boolean isOnlyDigits(String input) {
        return input.matches("\\d+");
    }




    // 10. Capitalize first letter of each word
    public static String capitalizeWords(String input) {
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty())
                result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }
        return result.toString().trim();
    }





    // 11. Find longest word
    public static String findLongestWord(String sentence) {
        String[] words = sentence.split(" ");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length())
                longest = word;
        }
        return longest;
    }




    // 12. Check string rotation
    public static boolean areRotations(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }




    // 13. Longest common prefix
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




    // 14. Compress a string
    public static String compressString(String input) {
        if (input == null || input.isEmpty()) return input;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char prev = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == prev) {
                count++;
            } else {
                sb.append(prev).append(count);
                prev = current;
                count = 1;
            }
        }
        sb.append(prev).append(count);
        return sb.toString();
    }





    // 15. Unique characters check
    public static boolean hasAllUniqueChars(String input) {
        Set<Character> seen = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!seen.add(c)) return false;
        }
        return true;
    }





    // 16. Implement strstr()
    public static int strstr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }






    // 17. Split string into words (no split())
    public static List<String> splitWords(String input) {
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c == ' ') {
                if (word.length() > 0) {
                    words.add(word.toString());
                    word.setLength(0);
                }
            } else {
                word.append(c);
            }
        }
        if (word.length() > 0) words.add(word.toString());
        return words;
    }





    // 18. Remove whitespaces
    public static String removeWhitespaces(String input) {
        return input.replaceAll("\\s", "");
    }






    // 19. Convert string to int manually
    public static int stringToInt(String str) {
        int num = 0, i = 0, sign = 1;
        str = str.trim();
        if (str.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        for (; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') throw new NumberFormatException();
            num = num * 10 + (str.charAt(i) - '0');
        }
        return sign * num;
    }





    // 20. Count words
    public static int countWords(String input) {
        return splitWords(input).size();
    }

    // 21. Replace all occurrences
    public static String replaceChar(String input, char oldChar, char newChar) {
        return input.replace(oldChar, newChar);
    }




}
