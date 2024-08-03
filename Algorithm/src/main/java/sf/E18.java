package sf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class E18 {
    //四数之和

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2};
        List<List<Integer>> listList = fourSum(nums, 8);
        System.out.println(listList);
    }

    public static List<List<Integer>> fourSum2(int[] nums, int target) {

        List<List<Integer>> listList = new ArrayList<>();
        //将数组进行排序
        Arrays.sort(nums);


        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > target && nums[k] > 0) {
                return listList;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }


            for (int i = k + 1; i < nums.length; i++) {


                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[k] + nums[i] + nums[left] + nums[right];

                    if (sum > target) {
                        //表示数据过大
                        right--;
                    } else if (sum < target) {
                        //表示数据过小
                        left++;
                    } else {

                        listList.add(Arrays.asList(nums[k], nums[i], nums[left], nums[right]));
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;

                        right--;
                        left++;
                    }

                }


            }
        }


        return listList;
    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //三数之和 固定一个数 不就成了两数之和
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        reverse(4, 0, nums.length-1, target, nums, new LinkedList<>(), result);

        return result;
    }
    public static void twoSum(int left, int right, int[] numbers, long target,LinkedList<Integer> stack, List<List<Integer>> result) {
        //双指针
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                //找到目标
                ArrayList<Integer> list = new ArrayList<>(stack);
                list.add(numbers[left]);
                list.add(numbers[right]);
                result.add(list);
                left++;
                right--;
                while(left<right&&numbers[left]==numbers[left-1]){
                    left++;
                }
                while(left<right&&numbers[right]==numbers[right+1]){
                    right--;
                }

            }

        }

    }


    public static void reverse(int n, int i, int j, long target, int[] nums, LinkedList<Integer> stack, List<List<Integer>> result) {

        if (n == 2) {
            twoSum(i,j,nums, target,stack,result);
            return;
        }


        for (int x = i; x < j-(n-2); x++) {
            if (x > i && nums[x] == nums[x - 1]) {
                continue;
            }
            //固定一个数字i
            stack.push(nums[x]);
            reverse(n - 1, x + 1, j, target - nums[x], nums, stack, result);
            stack.pop();
        }

    }

}
