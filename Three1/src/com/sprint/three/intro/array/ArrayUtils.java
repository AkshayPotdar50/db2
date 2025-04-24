package com.sprint.three.intro.array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayUtils {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 5, 0, 0, 1, 2, 2};
        String[] words = {"cat", "dog", "tac", "god", "act"};

        System.out.println("Mode: " + findMode(nums));
        System.out.println("Least frequent element"+LeastFrequentElement(nums));
        System.out.println("Frequency Map: " + frequencyMap(nums));
        System.out.println("Range: " + findRange(nums));
        System.out.println("Average: " + average(nums));
        System.out.println("Top 3 Elements: " + topKElements(nums, 3));
        System.out.println("Move Zeros Right: " + Arrays.toString(moveZerosRight(nums)));
        System.out.println("Move Zeros Left: " + Arrays.toString(moveZerosLeft(nums)));
        System.out.println("Duplicates: " + findDuplicates(nums));
        System.out.println("Is Sorted: " + isSorted(nums));
        System.out.println("First Non-Repeating: " + firstNonRepeating(nums));

        System.out.println("Longest String: " + longestString(words));
        System.out.println("Sorted Strings: " + Arrays.toString(sortStrings(words)));
        System.out.println("Grouped Anagrams: " + groupAnagrams(words));
    }

    // 1. Mode of array
    public static List<Integer> findMode(int[] arr) {
        Map<Integer, Long> freqMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long maxFreq = Collections.max(freqMap.values());
        long minFreq=Collections.min(freqMap.values());
        return freqMap.entrySet().stream()
                .filter(e -> e.getValue() == maxFreq)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }



    public static List<Integer> LeastFrequentElement(int[] arr){
        Map<Integer, Long> freqMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long minFreq=Collections.min(freqMap.values());
        return freqMap.entrySet().stream()
                .filter(e -> e.getValue() == minFreq)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }



    // 2. Frequency of elements
    public static Map<Integer, Integer> frequencyMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);
        return map;
    }

    public static Map<Integer, Long> frequencyMapStream(int[] arr) {
        return Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    // 3. Range of array
    public static int findRange(int[] arr) {
        int max = Arrays.stream(arr).max().orElse(0);
        int min = Arrays.stream(arr).min().orElse(0);
        return max - min;
    }

    // 4. Average of array
    public static double average(int[] arr) {
        return Arrays.stream(arr).average().orElse(0.0);
    }

    // 5. Second and third largest
    public static List<Integer> topKElements(int[] arr, int k) {
        return Arrays.stream(arr).boxed()
                .distinct()
                .sorted(Collections.reverseOrder())
                .limit(k)
                .collect(Collectors.toList());
    }

    // 6. Union of arrays
    public static int[] union(int[] a, int[] b) {
        return IntStream.concat(Arrays.stream(a), Arrays.stream(b))
                .distinct()
                .toArray();
    }

    // 7. Intersection of arrays
    public static int[] intersection(int[] a, int[] b) {
        Set<Integer> setA = Arrays.stream(a).boxed().collect(Collectors.toSet());
        return Arrays.stream(b).filter(setA::contains).distinct().toArray();
    }

    // 8. Move zeros to the right
    public static int[] moveZerosRight(int[] arr) {
        int[] result = new int[arr.length];
        int index = 0;
        for (int num : arr) if (num != 0) result[index++] = num;
        return result;
    }

    // 9. Move zeros to the left
    public static int[] moveZerosLeft(int[] arr) {
        int[] result = new int[arr.length];
        int index = result.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) if (arr[i] != 0) result[index--] = arr[i];
        return result;
    }

    // 10. Find duplicates
    public static Set<Integer> findDuplicates(int[] arr) {
        Set<Integer> seen = new HashSet<>(), dupes = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num)) dupes.add(num);
        }
        return dupes;
    }

    // 11. Are arrays equal
    public static boolean arraysEqual(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    // 12. Rotate array
    public static int[] rotateRight(int[] arr, int k) {
        int n = arr.length;
        k %= n;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) result[(i + k) % n] = arr[i];
        return result;
    }

    // 13. Find missing number
    public static int findMissing(int[] arr, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = Arrays.stream(arr).sum();
        return expectedSum - actualSum;
    }

    // 14. Is array sorted
    public static boolean isSorted(int[] arr) {
        return IntStream.range(0, arr.length - 1).allMatch(i -> arr[i] <= arr[i + 1]);
    }

    // 15. First repeating element
    public static int firstRepeating(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num)) return num;
        }
        return -1;
    }

    // 16. First non-repeating element
    public static int firstNonRepeating(int[] arr) {
        Map<Integer, Integer> freq = frequencyMap(arr);
        for (int num : arr) {
            if (freq.get(num) == 1) return num;
        }
        return -1;
    }

    // 17. Sort 0s, 1s, 2s
    public static void sort012(int[] arr) {
        int[] count = new int[3];
        for (int num : arr) count[num]++;
        int i = 0;
        for (int j = 0; j < 3; j++) {
            while (count[j]-- > 0) arr[i++] = j;
        }
    }

    // 18. Longest subarray with sum k (naive)
    public static int longestSubarraySumK(int[] arr, int k) {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

    // 19. Reverse array
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }

    // 20. Merge two sorted arrays
    public static int[] mergeSorted(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) merged[k++] = a[i++];
            else merged[k++] = b[j++];
        }
        while (i < a.length) merged[k++] = a[i++];
        while (j < b.length) merged[k++] = b[j++];
        return merged;
    }

    // 21. Common elements in 3 arrays
    public static List<Integer> commonInThree(int[] a, int[] b, int[] c) {
        Set<Integer> set1 = Arrays.stream(a).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(b).boxed().collect(Collectors.toSet());
        Set<Integer> set3 = Arrays.stream(c).boxed().collect(Collectors.toSet());
        set1.retainAll(set2);
        set1.retainAll(set3);
        return new ArrayList<>(set1);
    }

    // 22. Subarrays with given sum (naive)
    public static List<List<Integer>> subarraysWithSumK(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            List<Integer> temp = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                temp.add(arr[j]);
                if (sum == k) result.add(new ArrayList<>(temp));
            }
        }
        return result;
    }

    // 23. Minimum difference
    public static int minDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }
        return minDiff;
    }

    // 24. Longest string in array of strings
    public static String longestString(String[] arr) {
        return Arrays.stream(arr).max(Comparator.comparingInt(String::length)).orElse("");
    }

    // 25. Sort array of strings alphabetically
    public static String[] sortStrings(String[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    // 26. Group anagrams
    public static Map<String, List<String>> groupAnagrams(String[] arr) {
        return Arrays.stream(arr)
                .collect(Collectors.groupingBy(s -> {
                    char[] chars = s.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }));
    }
}

