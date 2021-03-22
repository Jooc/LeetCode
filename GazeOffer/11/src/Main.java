public class Main {
    class Solution {
        public int minArray(int[] numbers) {
            int low = 0, high = numbers.length - 1;
            while(low < high){
                int mid = low + (high - low) / 2;
                if(numbers[mid] < numbers[high]){
                    high = mid;
                }
                else if(numbers[mid] > numbers[high]){
                    low = mid + 1;
                }
                else {
                    high--;
                }
            }
            return numbers[low];
        }
    }

    public static void main(String[] args) {
        int[] target = {2,2,2,0,1};
        Solution solution = new Main().new Solution();
        System.out.println(solution.minArray(target));
    }
}
