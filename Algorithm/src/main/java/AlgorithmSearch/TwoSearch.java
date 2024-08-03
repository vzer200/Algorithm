package AlgorithmSearch;

public class TwoSearch {


    /**
     * <h3>二分查找基础版</h3>
     *
     * <ol>
     *     <li>i, j, m 指针都可能是查找目标</li>
     *     <li>因为 1. i > j 时表示区域内没有要找的了</li>
     *     <li>每次改变 i, j 边界时, m 已经比较过不是目标, 因此分别 m+1 m-1</li>
     *     <li>向左查找, 比较次数少, 向右查找, 比较次数多</li>
     * </ol>
     *
     * @param a      待查找的升序数组
     * @param target 待查找的目标值
     * @return <p>找到则返回索引</p>
     * <p>找不到返回 -1</p>
     */


    public static int binarySearchBasic(int[] a, int target) {

        int i = 0;
        int j = a.length - 1;

        while (i <= j) {
            int m = (i + j) / 2;//如果将其放在while循环体之外，程序无法正常运行
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;

            } else {
                return m;
            }
        }
        return -1;
    }

     /*
        1 [2,3,4,5] 5  右侧没找到更差
        int i = 0, j = a.length - 1;    2
        return -1;                      1
        元素个数                循环次数
        4-7                    3        floor(log_2(4)) = 2+1
        8-15                   4        floor(log_2(8)) = 3+1
        16-31                  5        floor(log_2(16)) = 4+1
        32-63                  6        floor(log_2(32)) = 5+1
        ...                    ...

        循环次数L  = floor(log_2(n)) + 1

        i <= j                   L+1
        int m = (i + j) >>> 1;   L
        target < a[m]            L
        a[m] < target            L
        i = m + 1;               L

        (floor(log_2(n)) + 1) * 5 + 4

        (3) * 5 + 4 = 19*t
        (10 + 1) * 5 + 4 = 59*t
     */

    /*
        问题1: 为什么是 i<=j 意味着区间内有未比较的元素, 而不是 i<j ?
           i==j 意味着 i,j 它们指向的元素也会参与比较
           i<j 只意味着 m 指向的元素参与比较
        问题2: (i + j) / 2 有没有问题?
        问题3: 都写成小于号有啥好处?
     */

    /**
     * <h3>二分查找改动版</h3>
     *
     * <ol>
     *     <li>i, m 指针可能是查找目标</li>
     *     <li>j 指针不可能是查找目标</li>
     *     <li>因为 1. 2. i >= j 时表示区域内没有要找的了</li>
     *     <li>改变 i 边界时, m 已经比较过不是目标, 因此需要 i=m+1</li>
     *     <li>改变 j 边界时, m 已经比较过不是目标, 同时因为 2. 所以 j=m</li>
     * </ol>
     *
     * @param a      待查找的升序数组
     * @param target 待查找的目标值
     * @return <p>找到则返回索引</p>
     * <p>找不到返回 -1</p>
     */


    //找最左侧的target重复元素
    public static int binarySearchLeftmost1(int[] a, int target) {

        int i = 0;
        int j = a.length - 1;
        int candidate = -1;
        while (i <= j) {

            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                candidate = m;
                j = m - 1;
            }

        }

        return candidate;

    }


    public static int binarySearchRightmost1(int[] a, int target) {

        int i = 0;
        int j = a.length - 1;
        int candidate = -1;
        while (i <= j) {

            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                candidate = m;
                i = m + 1;
            }


        }

        return candidate;

    }


}


