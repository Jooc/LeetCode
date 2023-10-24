package com.jooc;

import com.jooc.Common.*;
import com.jooc.Competition.S338;
import com.jooc.Competition.S339;
import com.jooc.Competition.WeeklyCompetition_337;
import com.jooc.GazeOffer.Solution_10;
//import com.jooc.NewCoder.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

class Animal{
    public Animal(){
        System.out.println("Animal");
    }
}

class Cat extends Animal{
    {
        System.out.println("Cat block");
    }

    public Cat(){
        System.out.println("Cat");
    }
}

public class Main {

    public static void main(String[] args) {
        Integer fst = 1;
        Integer snd = new Integer(1);
        System.out.println(fst == snd);
        System.out.println(new Integer(1) == snd);
        System.out.println(fst == Integer.valueOf(1));
        Integer trd = 256;
        System.out.println(trd == Integer.valueOf(256));
//        Solution solution = new Solution_78_1();
//        solution.main();
    }
}

/**
 * // TO-REVIEW
 * <p>
 * 35 - 应用HashMap，复制复杂链表
 * 38 - dfs 回溯，剪枝
 * 51 - 归并排序的深入应用
 * 56-2 - 绝妙的位运算
 * 59-1 - 滑动窗口 + 双端队列 找窗口最大值
 * 62 - 动态规划解约瑟夫环
 * 65 - 位运算实现加法
 **/

