package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.ArrayList;

public class Solution_74 implements Solution {
    @Override
    public void main() {
        System.out.println(restoreIpAddresses("010010"));
    }

    public ArrayList<String> restoreIpAddresses_0(String s) {
        // write code here
        int n = s.length();
        ArrayList<String> res = new ArrayList<>();
        if (n < 4) return res;

        for (int i = 1; i <= 3 && i < n - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < n - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < n; k++) {
                    if (n - k >= 4) continue;
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k);
                    if (Integer.parseInt(s1) > 255 || Integer.parseInt(s2) > 255 || Integer.parseInt(s3) > 255 || Integer.parseInt(s4) > 255) {
                        continue;
                    }
                    if ((s1.length() != 1 && s1.charAt(0) == '0') || (s2.length() != 1 && s2.charAt(0) == '0') || (s3.length() != 1 && s3.charAt(0) == '0') || (s4.length() != 1 && s4.charAt(0) == '0')) {
                        continue;
                    }

                    res.add(s1 + '.' + s2 + '.' + s3 + '.' + s4);
                }
            }
        }
        return res;
    }

    private String IPs = "";

    private void dfs(String s, ArrayList<String> res, int step, int index) {
        StringBuilder cur = new StringBuilder();
        if (step == 4) {
            if (index != s.length()) {
                return;
            }
            res.add(IPs);
        } else {
            for (int i = index; i < index + 3 && i < s.length(); i++) {
                cur.append(s.charAt(i));
                int num = Integer.parseInt(cur.toString());
                String temp = IPs;
                if (num <= 255 && (cur.length() == 1 || cur.charAt(0) != '0')) {
                    if (step - 3 != 0)
                        IPs += cur + ".";
                    else
                        IPs += cur;
                    dfs(s, res, step + 1, i + 1);
                    IPs = temp;
                }
            }
        }
    }

    public ArrayList<String> restoreIpAddresses(String s) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        dfs(s, res, 0, 0);
        return res;
    }
}
