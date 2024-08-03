package sf;

import java.util.LinkedList;
import java.util.Map;

public class E42 {
    //接雨水
    public int trap(int[] height) {

        LinkedList<date> stack = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            date right = new date(height[i], i);
            //单调栈逻辑
            while(!stack.isEmpty()&&stack.peek().height<right.height){
                date pop = stack.pop();
                //计算雨水的逻辑
                date left = stack.peek();
                if (left!=null){
                    int min = Math.min(left.height, right.height);
                    int length = right.i-left.i-1;
                    sum += length*(min-pop.height);

                }
            }
            //表示站为空或者已经大于需要push的元素
            stack.push(right);

        }
        return sum;
    }

    static class date{
        int height;
        int i ;


        public date() {
        }

        public date(int height, int i) {
            this.height = height;
            this.i = i;
        }

        /**
         * 获取
         * @return height
         */
        public int getHeight() {
            return height;
        }

        /**
         * 设置
         * @param height
         */
        public void setHeight(int height) {
            this.height = height;
        }
        /**
         * 获取
         * @return i
         */
        public int getI() {
            return i;
        }

        /**
         * 设置
         * @param i
         */
        public void setI(int i) {
            this.i = i;
        }

        public String toString() {
            return "date{height = " + height + ", i = " + i + "}";
        }
    }


}
