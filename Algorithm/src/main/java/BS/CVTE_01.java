package BS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CVTE_01 {
    public static class Stats {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int total = 0;
        int count = 0;

        synchronized void update(int temp) {
            min = Math.min(min, temp);
            max = Math.max(max, temp);
            total += temp;
            count++;
        }

        double getAverage() {
            return count == 0 ? 0 : (double) total / count;
        }

        @Override
        public String toString() {
            return "Min: " + min + ", Max: " + max + ", Avg: " + getAverage();
        }
    }

    public Map<String, Stats> analyze(String filePath) {
        Map<String, Stats> results = new ConcurrentHashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String data = line;
                executor.submit(() -> {
                    String[] parts = data.split(",");
                    if (parts.length == 2) {
                        String region = parts[0].trim();
                        int temp;
                        try {
                            temp = Integer.parseInt(parts[1].trim());
                        } catch (NumberFormatException e) {
                            return; // 忽略格式错误的行
                        }

                        results.computeIfAbsent(region, k -> new Stats()).update(temp);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // 等待所有任务完成
        }

        return results;
    }

    public static void main(String[] args) {
        CVTE_01 analyzer = new CVTE_01();
        Map<String, Stats> stats = analyzer.analyze("path/to/temperature_data.txt");

        // 输出每个地区的统计结果
        stats.forEach((region, stat) -> {
            System.out.println(region + " -> " + stat);
        });
    }
}
