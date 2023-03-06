package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_85 implements Solution {
    @Override
    public void main() {
//        System.out.println(solve("172.16.254.1"));
        System.out.println(solve("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }

    public String solve(String IP) {
        // write code here

        if (IP.contains(".")) {
            String[] letters = IP.split("\\.");
            if (letters.length != 4) return "Neither";
            for (int i = 0; i < 4; i++) {
                if (letters[i].length() == 0 || letters[i].length() > 3)
                    return "Neither";
                for (char ch : letters[i].toCharArray()) {
                    if (ch < '0' || ch > '9')
                        return "Neither";
                }
                if ((letters[i].length() > 1 && letters[i].charAt(0) == '0') || Integer.parseInt(letters[i]) > 255) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else {
            String[] letters = IP.split(":", -1);
            if (letters.length != 8) return "Neither";
            for (int i = 0; i < 8; i++) {
                if (letters[i].length() == 0 || letters[i].length() > 4) {
                    return "Neither";
                }
                for (char ch : letters[i].toCharArray()) {
                    if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F')))
                        return "Neither";
                }
            }
            return "IPv6";
        }
    }
}
