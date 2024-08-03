package sf;

import java.util.*;

public class E01 {


//map自动去重，第三个案例两个重复的数
       //他妈的b两个数的和

       public static void main(String[] args) {
           int[] nums = {2,7,11,15};
           int[] ans = twoSum2(nums, 9);
           System.out.println(Arrays.toString(ans));
       }
        public static int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> m1 = new HashMap<>();
            LinkedHashMap<Integer,Integer> m2 = new LinkedHashMap<>();

            int v;
            //创造Map集合m1用于放nums中遍历过的元素
            int in = 0;
            for(int i : nums){
                m1.put(i,in);//第一个位置放元素值，第二位置索引
                v = target - i ;
                m2.put(v,in);//m2记录target减去当前元素，代表所需要的值
                in++;
            }

            int[] ans = new int[nums.length];
            int index = 0;
           for (Integer key :m2.keySet()){//key代表v
               Integer value2 = m2.get(key);
               Integer value = m1.get(key);
               if (m1.containsKey(key)&& !Objects.equals(value, value2)){
                   ans[index++] = m2.get(key);

               }

           }
           int y = 0;
            for (int i = ans.length-1; ans[i] == 0; i--) {
                y+=1;
            }
            int [] answer = new int[ans.length-y];
            System.arraycopy(ans,0,answer,0,answer.length);
           return answer;


           /* for (Integer key : m1.keySet()) {
                Integer value = m1.get(key);
                System.out.println(key + "：" + value);
            }

            for (Integer key : m2.keySet()) {
                Integer value = m2.get(key);
                System.out.println(key + "：" + value);
            }
           return new int[]{0, 0};*/



        }


           public static int[] twoSum2(int[] nums, int target) {
               Map<Integer, Integer> idx = new HashMap<>(); // 创建一个空哈希表
               for (int j = 0; ; j++) { // 枚举 j
                   int x = nums[j];
                   // 在左边找 nums[i]，满足 nums[i]+x=target
                   if (idx.containsKey(target - x)) // 找到了
                       return new int[]{idx.get(target - x), j}; // 返回两个数的下标
                   idx.put(x, j); // 保存 nums[j] 和 j
               }
           }


       public static int[] twoSum3(int[] nums, int target) {

           Map<Integer,Integer> map = new HashMap<>();
           for (int i = 0; i < nums.length; i++) {
               if (map.containsKey(target-nums[i])){
                   //从map集合中找这个数
                   Integer res = map.get(target - nums[i]);
                   return new int[]{res,i};
               }
               map.put(nums[i],i);

           }
           return null;
       }

















    public static int[] twoSum4(int[] nums, int target) {
           //索引存value 值存key
           Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                //如果找到了这个值
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }


}
