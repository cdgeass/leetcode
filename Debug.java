import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Debug {

    public static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            if (nums.length < 4) {
                return Collections.emptyList();
            }
            Arrays.sort(nums);

            List<List<Integer>> result = new ArrayList<>();

            int len = nums.length;
            for (int i = 0; i <= len - 4; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                for (int j = i + 1; j <= len - 3; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }

                    int t = target - (nums[i] + nums[j]);
                    if (t < 0) {
                        break;
                    }

                    int m = j + 1, n = len - 1;
                    while (m < n) {
                        int temp = nums[m] + nums[n];
                        if (temp < t) {
                            m++;
                        } else if (temp > t) {
                            n--;
                        } else {
                            result.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));

                            while (m < n && nums[m] == nums[m + 1]) {
                                m++;
                            }
                            m++;

                            while (m < n && nums[n] == nums[n - 1]) {
                                n--;
                            }
                            n--;
                        }
                    }
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
    }
}
