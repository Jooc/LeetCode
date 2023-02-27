package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.*;

public class Solution_54 implements Solution {
    @Override
    public void main() {
        System.out.println(threeSum(new int[]{-2,0,0,2,2}));
    }

    public ArrayList<ArrayList<Integer>> threeSum_0(int[] num) {
        Set<ArrayList<Integer>> resSet = new HashSet<>();
        Map<Integer, Set<Integer>> indices = new HashMap<>();
        int n = num.length;

        for (int i = 0; i < n; i++) {
            if(!indices.containsKey(num[i])) {
                Set<Integer> newSet = new HashSet<>();
                newSet.add(i);
                indices.put(num[i], newSet);
            }else {
                indices.get(num[i]).add(i);
            }
        }
//        System.out.println(indices.toString());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || num[j] < num[i]) continue;
                int k = -(num[i] + num[j]);
                if(indices.containsKey(k)) {
                    for (int idx : indices.get(k)) {
                        if (idx != i && idx != j && num[j] <= -(num[i] + num[j])) {
                            ArrayList<Integer> singleRes = new ArrayList<>();
                            singleRes.add(num[i]);
                            singleRes.add(num[j]);
                            singleRes.add(-(num[i] + num[j]));
                            resSet.add(singleRes);
                        }
                    }
                }
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(resSet);
        res.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for(int i =0 ; i < o1.size() && i < o2.size(); i++){
                    if(!Objects.equals(o1.get(i), o2.get(i)))
                        return o1.get(i).compareTo(o2.get(i));
                }
                return 0;
            }
        });

        return res;
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = num.length;
        if(n < 3) return res;
        Arrays.sort(num);
        for(int i = 0; i < n - 2; i++){
            if(i != 0 && num[i] == num[i-1]) continue;
            int left = i + 1;
            int right = n - 1;
            int target = -num[i];
            while(left < right){
                if(num[left] + num[right] == target){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(num[i]);
                    temp.add(num[left]);
                    temp.add(num[right]);
                    res.add(temp);
                    while(left + 1 < right && num[left] == num[left+1]) left++;
                    while(right - 1 > left && num[right] == num[right-1]) right--;
                    left++;
                    right--;
                }else if(num[left] + num[right] > target)
                    right--;
                else
                    left++;
            }
        }
        return res;
    }
}
