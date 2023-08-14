package com.example.mavenproject.controller;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author :Aurora
 * @version:
 * @date : 2023/8/8 10:47
 * @desc:
 */
public class Leecode {

    public static void main(String[] args) {
        int [] arr = {2,3,1,22,45,4};
        int[] ints = twoSum(arr, 6);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
        ArrayList<String> list = new ArrayList<>();
        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
