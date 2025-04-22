package com.sprint.three.intro;

import java.util.HashMap;

public class HeighestFreqElement {

    public static int mostFreqElement(int[] arr){
        HashMap<Integer, Integer> freqmap= new HashMap<>();
        int maxCount=0;
        int maxElemet=arr[0];

        for(int num :arr){
            freqmap.put(num, freqmap.getOrDefault(num, 0)+1);
            if(freqmap.get(num)>maxCount){
                maxCount=freqmap.get(num);
                maxElemet=num;
            }

        }
        return maxElemet;
    }
    //mode of array means need to find element with heighest frequency
    public static void main(String[] args) {
        int[] arr={1, 3, 2, 3, 3, 2, 1, 4, 3};
        System.out.println("most frequent element: "+mostFreqElement(arr));

    }

    /*2. Identify the most repeated element in an array
This is the same as the previous problem, where we find the element with the highest frequency.*/
}
