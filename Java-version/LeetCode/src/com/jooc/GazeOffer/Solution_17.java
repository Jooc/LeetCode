package com.jooc.GazeOffer;

import com.jooc.Solution;

public class Solution_17 implements Solution {
    @Override
    public void main() {
        Solution solution = new Solution();
        System.out.println(solution.printNumbers(2));
    }

    class Solution_FullPermutation {
        StringBuilder builder;
        char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int n;

        public String printNumbers(int n){
            this.n = n;
            builder = new StringBuilder();
            num = new char[n];
            dfs(0);
            builder.deleteCharAt(builder.length() - 1);
            return builder.toString();
        }

        private void dfs(int x){
            if(x == n){
                builder.append(String.valueOf(num) + ",");
                return;
            }else{
                for(char i : loop){
                    num[x] = i;
                    dfs(x + 1);
                }
            }
        }
    }

    class Solution_CustomedFullPermutation {
        StringBuilder builder;
        char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int n, nine = 0 , count = 0, start;

        public String printNumbers(int n){
            this.n = n;
            builder = new StringBuilder();
            num = new char[n];
            start = n - 1;

            dfs(0);
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
            return builder.toString();
        }

        private void dfs(int x){
            if(x == n){
                String s = String.valueOf(num).substring(start);
                if(!s.equals("0")) builder.append(s + ", ");
                if(n - start == nine) start--;
                return;
            }else{
                for(char i : loop){
                    if(i == '9') nine++;
                    num[x] = i;
                    dfs(x + 1);
                }
            }
            nine--;
        }
    }


    class Solution {
        int[] res;
        int nine = 0, count = 0, start, n;
        char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        public int[] printNumbers(int n) {
            this.n = n;
            res = new int[(int) Math.pow(10, n) - 1];
            num = new char[n];
            start = n - 1;
            dfs(0);
            return res;
        }

        void dfs(int x) {
            if (x == n) {
                String s = String.valueOf(num).substring(start);
                if(!s.equals("0")) res[count++] = Integer.parseInt(s);
                if(n - start == nine) start--;
                return;
            }
            for(char i : loop){
                if(i == '9') nine++;
                num[x] = i;
                dfs(x + 1);
            }
            nine--;
        }
    }

}
