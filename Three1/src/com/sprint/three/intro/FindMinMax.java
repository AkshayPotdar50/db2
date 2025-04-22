package com.sprint.three.intro;

public class FindMinMax {

    public static void findMinMax(int[] arr){
        if(arr.length ==0)return;

        int min=arr[0], max=arr[0];
        for(int num:arr){
            if( num <min) min=num;
            if(num>max) max=num;
        }
        System.out.println("maximum: "+max);
        System.out.println("Minimum: "+min);
    }

    public static double calculateAverage(int[] arr){
        int sum=0;
        for(int num:arr) sum+=num;
        return (double)sum/arr.length;
    }

    public static void main(String[] args) {
        int[] arr={5, 2, 8, 1, 3, 10};
        findMinMax(arr);
    }

}
