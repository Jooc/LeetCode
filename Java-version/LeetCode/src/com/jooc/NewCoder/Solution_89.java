package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.Interval;

import java.util.ArrayList;
import java.util.Comparator;

public class Solution_89 implements Solution {
    @Override
    public void main() {
        ArrayList<Interval> target = new ArrayList<>();
//        target.add(new Interval(10, 30));
//        target.add(new Interval(20, 60));
//        target.add(new Interval(80, 100));
//        target.add(new Interval(1500, 180));
        target.add(new Interval(1, 4));
        target.add(new Interval(0, 2));
        System.out.println(merge(target));
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int n = intervals.size();
        if (n <= 1) return intervals;

        intervals.sort((o1, o2) -> {
            if (o1.start != o2.start) return o1.start - o2.start;
            return o1.end - o2.end;
        });

        ArrayList<Interval> res = new ArrayList<>();
        res.add(intervals.get(0));
        int resLen = 1;
        for(int i = 1; i < n; i++){
            if(res.get(resLen-1).end >= intervals.get(i).start){
                Interval temp = new Interval(res.get(resLen-1).start, Math.max(res.get(resLen-1).end, intervals.get(i).end));
                res.remove(resLen-1);
                res.add(temp);
            }else{
                res.add(intervals.get(i));
                resLen++;
            }
        }
        return res;
    }
}
