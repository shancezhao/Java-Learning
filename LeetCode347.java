/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode_PocketGems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zhaos 
 * Given a non-empty array of integers, return the k most frequent
 * elements. For example, Given [1,1,1,2,2,3] and k = 2, return [1,2].
 */
public class LeetCode347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        int m = 1;
        Map<Integer, Integer> cnum = new HashMap<Integer, Integer>();
        List<Integer> top = new ArrayList<Integer>();
        List<Integer>[] topget = new List[nums.length + 1];
        List<Integer> minL = new ArrayList<Integer>();
        //     if (k < nums.length) {
        for (int i : nums) {
            cnum.put(i, cnum.getOrDefault(i, 0) + 1);
        }
        for (int key : cnum.keySet()) {
            int frequency = cnum.get(key);
            if (topget[frequency] == null) {
                topget[frequency] = new ArrayList<>();
            }
            topget[frequency].add(key);
        }
        for (int j = topget.length - 1; j >= 0 && top.size() < k; j--) {
            if (topget[j] != null) {
                top.addAll(topget[j]);
            }
        }
        return top;
    }
}
