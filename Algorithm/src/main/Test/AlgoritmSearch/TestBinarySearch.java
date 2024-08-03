package AlgoritmSearch;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static AlgorithmSearch.TwoSearch.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestBinarySearch {


        @Test
        @DisplayName("测试 binarySearchBasic")
        public void test1() {
            int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
            assertEquals(0, binarySearchBasic(a, 7));
            assertEquals(1, binarySearchBasic(a, 13));
            assertEquals(2, binarySearchBasic(a, 21));
            assertEquals(3, binarySearchBasic(a, 30));
            assertEquals(4, binarySearchBasic(a, 38));
            assertEquals(5, binarySearchBasic(a, 44));
            assertEquals(6, binarySearchBasic(a, 52));
            assertEquals(7, binarySearchBasic(a, 53));

            assertEquals(-1, binarySearchBasic(a, 0));
            assertEquals(-1, binarySearchBasic(a, 15));
            assertEquals(-1, binarySearchBasic(a, 60));
    }

    @Test
    @DisplayName("测试 binarySearchBasic")
    public void test() {

        int[] a = {2, 5, 8};
        int target = 4;
        int i = Arrays.binarySearch(a, target);
        if (i < 0) {
            //没有查询到target，将target插入到数组
            //i是插入点-1再加上负号，先求插入点
            int index = Math.abs(i + 1);//index为插入点
            //如何将4正确的插入到数组a中，因为java数组不会自动扩容，所以我们需要手动复制新数组扩容原来老数组
            int[] b = new int[a.length + 1];
            //数组b为数组a的数组长度加1的数组
            //第一步将插入点之前的数据拷贝到数组b中
            System.arraycopy(a,0,b,0,index);
            //第二步将插入点数据放入数组b中
            b[index] =target;
            //第三步，将插入点后的数组拷贝到数组b中
            System.arraycopy(a,index,b,index+1,a.length-index);
            //注意第三步的b数组的拷贝位置应该为index+1 而不是index
            System.out.println(Arrays.toString(b));

        }

    }


    @Test
    @DisplayName("测试 binarySearchLeftmost 返回 -1")
    public void test6() {
        int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
        assertEquals(0, binarySearchLeftmost1(a, 1));
        assertEquals(1, binarySearchLeftmost1(a, 2));
        assertEquals(2, binarySearchLeftmost1(a, 4));
        assertEquals(5, binarySearchLeftmost1(a, 5));
        assertEquals(6, binarySearchLeftmost1(a, 6));
        assertEquals(7, binarySearchLeftmost1(a, 7));

        assertEquals(-1, binarySearchLeftmost1(a, 0));
        assertEquals(-1, binarySearchLeftmost1(a, 3));
        assertEquals(-1, binarySearchLeftmost1(a, 8));
    }

    @Test
    @DisplayName("测试 binarySearchRightmost 返回 -1")
    public void test7() {
        int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
        assertEquals(0, binarySearchRightmost1(a, 1));
        assertEquals(1, binarySearchRightmost1(a, 2));
        assertEquals(4, binarySearchRightmost1(a, 4));
        assertEquals(5, binarySearchRightmost1(a, 5));
        assertEquals(6, binarySearchRightmost1(a, 6));
        assertEquals(7, binarySearchRightmost1(a, 7));

        assertEquals(-1, binarySearchRightmost1(a, 0));
        assertEquals(-1, binarySearchRightmost1(a, 3));
        assertEquals(-1, binarySearchRightmost1(a, 8));
    }

}
