package sf;

import java.util.*;

public class E15 {

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> listList = threeSum(nums);
        System.out.println(listList);
    }

    //三数之和
    public static List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> listList = new ArrayList<>();
        //将数组进行排序
        Arrays.sort(nums);


        for (int i = 0; i < nums.length; i++) {

            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return listList;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    //表示数据过大
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    //表示数据过小
                    left++;
                } else {

                    listList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }

            }


        }

        return listList;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //三数之和 固定一个数 不就成了两数之和
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        reverse(3, 0, nums.length - 1, 0, nums, new LinkedList<>(), result);

        return result;
    }

    public static void twoSum(int left, int right, int[] numbers, int target, LinkedList<Integer> stack, List<List<Integer>> result) {
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
                while (left < right && numbers[left] == numbers[left - 1]) {
                    left++;
                }
                while (left < right && numbers[right] == numbers[right + 1]) {
                    right--;
                }

            }

        }

    }


    public static void reverse(int n, int i, int j, int target, int[] nums, LinkedList<Integer> stack, List<List<Integer>> result) {

        if (n == 2) {
            twoSum(i, j, nums, target, stack, result);
            return;
        }

        for (int x = i; x < j; x++) {
            if (x > i && nums[x] == nums[x - 1]) {
                continue;
            }
            //固定一个数字i
            stack.push(nums[x]);
            reverse(n - 1, x + 1, j, target - nums[x], nums, stack, result);
            stack.pop();
        }

    }


    public List<List<Integer>> threeSum3(int[] nums) {

        //三数之和 分而治之 两数之和 再 固定一个数
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // n 数字总数 i j左右边界
        reverse2(3, 0, nums.length - 1, 0, nums, result, new LinkedList<>());

        return result;
    }


    public void reverse2(int n, int left, int right, int target, int[] numbers, List<List<Integer>> result, LinkedList<Integer> stack) {

        if (n == 2) {
            twoSum2(left, right, numbers, target, result, stack);
            return;
        }

        //回溯的话

        for (int i = left; i < right; i++) {
            if (i > left && numbers[i] == numbers[i - 1]) {
                continue;
            }

            stack.push(numbers[i]);
            //回溯这里都是 循环 i 的值+1 进行回溯
            reverse2(n - 1, i + 1, right, target - numbers[i], numbers, result, stack);
            stack.pop();
        }

    }

    public void twoSum2(int left, int right, int[] numbers, int target, List<List<Integer>> result, LinkedList<Integer> stack) {
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
                //继续找
                left++;
                right--;
                //去重
                while (left < right && numbers[left] == numbers[left - 1]) {
                    left++;
                }
                while (left < right && numbers[right] == numbers[right + 1]) {
                    right--;
                }
            }

        }


    }


    public List<List<Integer>> threeSum4(int[] nums) {
        //结果集合
        //一定要先排序 要是无序数组 两数之和的双指针法就无效了
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
       LinkedList<Integer> res =new LinkedList<>();
        reverse(3, 0, nums.length - 1, nums, 0, result,res);
        return result;
    }


    public void reverse(int n,int left,int right,int[] nums,int target,List<List<Integer>> result,LinkedList<Integer> res){
        if (n==2){
            twoSum4(left,right,nums,target,res,result);
            return;
        }

        for (int i = left; i < right; i++) {
            //去重
            if (i>1&&nums[i] == nums[i-1]){
                continue;
            }

            res.push(nums[i]);
            reverse(n-1,i+1,right,nums,target-nums[i],result,res);
            res.pop();
        }


    }
    public void twoSum4(int left, int right, int[] nums, int target, LinkedList<Integer> res,List<List<Integer>> result) {
        while (left < right) {
            if (nums[left] + nums[right] < target) left++;
            else if (nums[left] + nums[right] > target) right--;
            else {
                ArrayList<Integer> list = new ArrayList<>(res);
                //找到结果
                //捕获结果集合
                list.add(nums[left]);
                list.add(nums[right]);
                result.add(list);
                //继续寻找
                left++;
                right--;
                //去重
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }

            }
        }

    }











}
