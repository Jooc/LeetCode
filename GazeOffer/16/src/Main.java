public class Main {

    class Solution{
        public double myPow(double x, int n){
            if(x == 0) return 0;
            double res = 1.0;
            long b = n;

            if(b < 0){
                x = 1 / x;
                b = -b;
            }

            while(b > 0){
                if((b & 1) == 1) res *= x;
                x *= x;
                n >>= 1;
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Main(). new Solution();

        System.out.println(solution.myPow(2.0, 10));
    }
}
