public class Main {
    // DP - 343
    class Solution_DP{
        public int integerBreak(int n){
            int[] dp = new int[n + 1];
            dp[0] = 0; dp[1] = 1;

            for(int i = 2; i <= n; i++){
                int max = 0;
                for(int j = i - 1; j > 0; j--){
                    max = Math.max(max, Math.max(j*(i-j), j*dp[i-j]));
                }
                dp[i] = max;
            }

            return dp[n];
        }
    }



    // Math exclusion
    class Solution {
        public int cuttingRope(int n) {
            if(n <= 3) return n - 1;
            int a = n / 3;
            int b = n % 3;

            if(b == 0) return (int)Math.pow(3, a);
            if(b == 1) return (int)(Math.pow(3, a - 1) * 4);
            return (int)Math.pow(3, a) * 2;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
