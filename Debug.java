import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Debug {

    public static class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            backtracking(candidates, 0, target, new ArrayList<>());
            return result;
        }

        private void backtracking(int[] cadidates, int index, int target, List<Integer> list) {
            if (index >= cadidates.length) {
                return;
            }

            for (int i = index; i < cadidates.length; i++) {
                List<Integer> tempList = new ArrayList<>(list);

                int v = cadidates[i];

                if (v == target) {
                    tempList.add(v);
                    result.add(tempList);
                } else if (v < target) {
                    int temp = target;

                    while (v <= temp) {
                        tempList.add(v);

                        temp -= v;
                        if (temp < 0) {
                            break;
                        } else if (temp == 0) {
                            result.add(tempList);
                        } else {
                            List<Integer> subList = new ArrayList<>(tempList);
                            backtracking(cadidates, i + 1, temp, subList);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[] { 2, 3, 5 }, 8));
    }
}
