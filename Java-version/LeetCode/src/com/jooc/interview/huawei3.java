package com.jooc.interview;
// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class huawei3 {
    public static void main(String[] args) {
    // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
    // please finish the function body here.
    // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        List<Integer> goods = new ArrayList<Integer>();
        List<Integer> trunks = new ArrayList<Integer>();

        for(int i = 0; i < m; i++){
            goods.add(in.nextInt());
        }

        for(int i = 0; i < n; i++){
            trunks.add(in.nextInt());
        }

        Collections.sort(goods);
        Collections.sort(trunks);

        int res = 0;
        for(int good: goods){
            int miniTrunkIdx = -1;
            for(int i = 0; i < trunks.size(); i++){
                if(trunks.get(i) >= good){
                    if(miniTrunkIdx == -1 || trunks.get(miniTrunkIdx) > trunks.get(i)){
                        miniTrunkIdx = i;
                    }
                }
            }

            if(miniTrunkIdx != -1){
                res ++;
                trunks.remove(miniTrunkIdx);
                continue;
            }

            if(x > 0){
                miniTrunkIdx = -1;
                for(int i = 0; i < trunks.size(); i++){
                    if(trunks.get(i) + y >= good){
                        if(miniTrunkIdx == -1 || trunks.get(miniTrunkIdx) > trunks.get(i)){
                            miniTrunkIdx = i;
                        }
                    }
                }
                if(miniTrunkIdx != -1){
                    res ++;
                    trunks.remove(miniTrunkIdx);
                    x--;
                }
            }
        }

        System.out.println(res);
    }
}
