package BS;

import java.util.ArrayList;
import java.util.List;

public class BD_01 {
    private static final String[] numToChar = {
            "", "a", "b", "c", "d", "e", "f", "g", "h", "i",
            "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z"
    };

    // 字典映射数字到字母


    public static List<String> decodeWays(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }
        backtrack(digits, 0, "", results);
        return results;
    }

    private static void backtrack(String digits, int index, String path, List<String> results) {
        // 如果我们遍历到末尾，收集到一种解码方式
        if (index == digits.length()) {
            results.add(path);
            return;
        }

        // 选择一位数字
        int num1 = Character.getNumericValue(digits.charAt(index));
        if (num1 > 0 && num1 <= 26) {
            backtrack(digits, index + 1, path + numToChar[num1], results);
        }

        // 选择两位数字
        if (index + 1 < digits.length()) {
            int num2 = Integer.parseInt(digits.substring(index, index + 2));
            if (num2 > 0 && num2 <= 26) {
                backtrack(digits, index + 2, path + numToChar[num2], results);
            }
        }
    }

    public static void main(String[] args) {
        String encodedString = "123";
        List<String> decodedWays = decodeWays(encodedString);
        System.out.println(decodedWays); // 输出所有可能的解码方式
    }
}