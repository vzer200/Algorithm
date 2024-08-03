package sf;

import java.util.LinkedList;

public class E11 {
    //盛水最多的容器
    public static int maxArea(int[] height) {

        int i = 0;
        int j = height.length-1;
        int max =0;
        int size=0;
        while(i<j){
            if (height[i]>height[j]){
                 size = height[j] * (j-i);
                j--;
            }else {
                 size = height[i] * (j-i);
                i++;
            }
            max = Math.max(size,max);

        }
        return max;
    }

    public static int reverse(int[] height, int i, int j, int max,LinkedList<Integer> stack) {
        if (i < j) {
            int min = Math.min(height[i], height[j]);//找到矮的那根挡板
            int size = min * (j - i);
            max = Math.max(size, max);
        } else {
            return 0;
        }

        for (int x = i; x < j; x++) {
            stack.push(i);//固定一个数
            reverse(height, i + 1, j, max,stack);
            stack.pop();
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height =
                {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public static int maxArea1(int[] height) {

        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int length = right - left;
            int high = Math.min(height[right], height[left]);
            int x = length * high;
            max = Math.max(max, x);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }


}
