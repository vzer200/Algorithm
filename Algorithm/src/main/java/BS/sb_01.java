package BS;

public class sb_01 {

    public static String formatDuration(int seconds) {
        // 如果输入秒数为0，返回"now"
        if (seconds == 0) {
            return "now";
        }

        // 定义每个时间单位的秒数
        int secondsInMinute = 60;
        int secondsInHour = 3600;
        int secondsInDay = 86400;
        int secondsInYear = 31536000;

        // 计算年、天、小时、分钟和秒
        int years = seconds / secondsInYear;
        seconds %= secondsInYear;
        int days = seconds / secondsInDay;
        seconds %= secondsInDay;
        int hours = seconds / secondsInHour;
        seconds %= secondsInHour;
        int minutes = seconds / secondsInMinute;
        seconds %= secondsInMinute;

        // 存储时间单位和对应的值
        String[] timeUnits = {"year", "day", "hour", "minute", "second"};
        int[] timeValues = {years, days, hours, minutes, seconds};

        // 用于存储非零时间部分
        StringBuilder result = new StringBuilder();

        // 统计非零时间部分的数量
        int nonZeroCount = 0;
        for (int value : timeValues) {
            if (value > 0) {
                nonZeroCount++;
            }
        }

        // 构建时间字符串
        int currentIndex = 0;
        for (int i = 0; i < timeUnits.length; i++) {
            if (timeValues[i] > 0) {
                result.append(timeValues[i]).append(" ").append(timeUnits[i]);
                // 根据值选择单数或复数形式
                if (timeValues[i] > 1) {
                    result.append("s");
                }
                currentIndex++;
                // 如果这是倒数第二部分，添加"and"
                if (currentIndex == nonZeroCount - 1) {
                    result.append(" and ");
                } else if (currentIndex < nonZeroCount) {
                    result.append(", ");
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(formatDuration(62)); // 输出: "1 minute and 2 seconds"
        System.out.println(formatDuration(3662)); // 输出: "1 hour, 1 minute and 2 seconds"
        System.out.println(formatDuration(0)); // 输出: "now"
    }
}
