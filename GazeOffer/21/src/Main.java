import java.util.Arrays;

public class Main {
    class Solution{
        public int[] exchange(int[] nums) {
            int len = nums.length;
            if(len <= 1) return nums;

            int left = 0, right = len - 1;

            while(left < right){
                while(nums[left] % 2 != 0 && left < len-1)
                    left++;
                while(nums[right] % 2 == 0 && right > 0)
                    right--;

                if(left >= right) break;

                swap(nums, left, right);
            }

            return nums;
        }

        private void swap(int[] nums, int x, int y){
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Main().new Solution();
        System.out.println(Arrays.toString(solution.exchange(new int[] {1,3,5})));
    }
}
