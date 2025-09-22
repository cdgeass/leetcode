public class Debug {

    public static class Solution {
        public String multiply(String num1, String num2) {
            char[] nums1 = num1.toCharArray();
            char[] nums2 = num2.toCharArray();

            char[] result = new char[nums1.length * nums2.length];
            for (int i = nums1.length - 1; i >= 0; i--) {
                int a = nums1[i] - '0';

                int t = 0;
                for (int j = nums2.length - 1; j >= 0; j--) {
                    int b = nums2[j] - '0';

                    int v = a * b + t;
                    if (v >= 10) {
                        t = v / 10;
                        v = v % 10;
                    } else {
                        t = 0;
                    }

                    int index = (nums1.length - 1 - i) + (nums2.length - 1 - j);
                    v = result[index] == '\u0000' ? v : result[index] - '0' + v;
                    if (v >= 10) {
                        t += 1;
                        v -= 10;
                    }
                    result[index] = (char) ('0' + v);
                }

                int index = (nums1.length - 1 - i) + nums2.length;
                if (t > 0) {
                    result[index] = (char) ('0' + t);
                }
            }

            StringBuilder sb = new StringBuilder();
            int i = result.length - 1;
            for (; i >= 0; i--) {
                if (result[i] != '\u0000' && result[i] != '0') {
                    break;
                }
            }
            for (int j = i; j >= 0; j--) {
                sb.append(result[j]);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("123", "456"));
        /*
         * 456
         * 123
         * ---
         * 1368
         * 912
         * 10488
         */
    }
}
