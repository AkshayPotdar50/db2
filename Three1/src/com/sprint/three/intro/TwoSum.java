package com.sprint.three.intro;

import java.util.HashMap;

public class TwoSum {

    //this kind of approach will be used if array is not sorted or we dont want to sort
    public static int[] findTwoSum(int[] nums, int target){
        HashMap<Integer, Integer> map= new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int complement=target- nums[i];

            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
