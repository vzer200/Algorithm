package BS;

import java.util.Scanner;

//设计一个游戏角色的装备系统，系统可以包含合成装备以及独立装备，这里的合成装备，可以继续包含独立装备以及合成装备。 战力系数是装备在系统里面的嵌套合成数，装备的战力系数越高，表示战力越高，请计算出整个系统里面装备的战力和。 提示：战力 = 装备战力 * 嵌套合成数
//示例1：
//输入：equipmentList = [[1,1],2,[1,1]]
//输出：10 战力
//解释：因为装备中有四个嵌套合成数为 2 ，战力为1的装备 ；和一个嵌套合成数为 1 ，战力为2的装备。
//
//示例2：
//输入：equipmentList = [1,[4,[6]]]
//输出：27
//解释：一个嵌套合成数为 1 ，战力为1的装备；一个嵌套合成数为 2 ，战力为4的装备，一个嵌套合成数为 3 ，战力为6的装备。所以，1 + 4*2 + 6*3 = 27。
public class B4399_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().trim();
        int totalPower = Total(input);
        System.out.println(totalPower);
    }

    // 计算总战力
    public static int Total(String input) {
        int depth = 0;
        int totalPower = 0;
        int number = 0;
        boolean hasNumber = false;

        for (char ch : input.toCharArray()) {
            if (ch == '[') {
                depth++;
            } else if (ch == ']') {
                if (hasNumber) {
                    totalPower += number * depth;
                    number = 0;
                    hasNumber = false;
                }
                depth--;
            } else if (ch == ',') {
                if (hasNumber) {
                    totalPower += number * depth;
                    number = 0;
                    hasNumber = false;
                }
            } else if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
                hasNumber = true;
            }
        }


        if (hasNumber) {
            totalPower += number * depth;
        }

        return totalPower;
    }


}
