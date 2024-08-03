package BS;

import java.util.Scanner;

public class ZJ_07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        boolean blockComment = false;

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                // 如果我们处于块注释中
                if (blockComment) {
                    if (line.startsWith("*/", i)) {
                        blockComment = false;
                        i++; // 跳过关闭块注释的字符
                    }
                } else {
                    // 检查块注释的开始
                    if (line.startsWith("/*", i)) {
                        blockComment = true;
                        i++; // 跳过开头字符
                    }
                    // 检查行注释的开始
                    else if (line.startsWith("//", i)) {
                        break; // 忽略该行剩余部分
                    }
                    // 检查有效的“new Node()”实例创建
                    else if (i == 0 || !Character.isJavaIdentifierPart(line.charAt(i - 1))) { // 确保前面不是标识符的一部分
                        if (line.startsWith("new Node(", i) || line.startsWith("new Node[", i)) {
                            count++; // 计数有效的对象创建
                            i += "new Node".length(); // 跳过“new Node”
                        }
                    }
                }
            }
        }

        System.out.println(count-1);
    }

}
