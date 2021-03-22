import java.util.HashSet;
import java.util.Set;

public class Main {

    /**
     * Time = O(N)
     * Space = O(N)
     */
    class Solution_Set {
        public int findRepeatNumber(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(Integer i : nums){
                if(set.contains(i)){
                    return i;
                }
                set.add(i);
            }
            return -1;
        }
    }

    /**
     * Time = O(N)
     * Space = O(1)
     */
    class Solution_exchange{
        public int findRepeatNumber(int[] nums){
            int i = 0;
            while(i < nums.length){
                if(nums[i] == i){
                    i++;
                    continue;
                }

                if(nums[nums[i]] == nums[i])
                    return nums[i];

                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
