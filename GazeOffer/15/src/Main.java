public class Main {
    class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;
            int mask = 1;
            for(int i = 0; i < 32; i++){
                if((n & mask)!=0){
                    res++;
                }
                mask <<= 1;
            }
            return res;
        }
    }

    class Solution_2{
        public int hanmingWeight(int n){
            int res = 0;
            while(n != 0){
                res++;
                n = n & (n-1);
            }
            return res;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Main().new Solution();
        System.out.println(solution.hammingWeight(11111111111111111111111111111101));
    }
}
