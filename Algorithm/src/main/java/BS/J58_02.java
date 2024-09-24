package BS;

public class J58_02 {
    public int StringSplit (String str) {
        // write code here
        int total = 0;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'b') {
                total++;
            }
        }
        int res = Integer.MIN_VALUE;
        int left = 0;
        int right = total;
        for (int i = 1; i < n; i++) {
            if (str.charAt(i - 1) == 'a') {
                left++;
            } else {
                right--;
            }
            int currentScore = left + right;
            res = Math.max(res, currentScore);
        }
        return res;
    }
}
