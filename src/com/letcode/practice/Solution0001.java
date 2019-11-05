package com.letcode.practice;

import java.util.HashMap;

/*
给定一个整数数组nums和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class Solution0001 {
    public int[] twoSum1(int[] nums,int target){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int difference = target - nums[i];
            if(map.get(difference)!=null){
                return new int[]{i,map.get(difference)};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("没有满足结果的两个整数");
    }

    public static void main(String[] args) {
        Solution0001 solution = new Solution0001();
        int[] result = solution.twoSum2(new int[]{2, 7, 11, 15},9);
        System.out.println(result[0]+" "+result[1]);
    }
}