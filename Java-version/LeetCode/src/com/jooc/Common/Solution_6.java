package com.jooc.Common;

import com.jooc.Solution;

public class Solution_6 implements Solution {
    @Override
    public void main() {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("AB", 1));
    }

    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }

        int row = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            builders[row].append(c);
            if (row == 0 || row == numRows - 1)
                flag = -flag;
            row += flag;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder builder : builders) {
            res.append(builder);
        }
        return res.toString();
    }
}
