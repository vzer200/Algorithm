package array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer> {
    private int size;//逻辑大小

    private int capacity=8;//容量
    private int[] array = {};


    /**
     * 向最后位置 [size] 添加元素
     *
     * @param element 待添加元素
     */

    public void addLast(int element) {
//        array[size] = element;
//        size++;
        add(size, element);
    }

    /**
     * 向 [0 .. size] 位置添加元素
     *
     * @param index   索引位置
     * @param element 待添加元素
     */


    public void add(int index , int element){
        //检查容量
        checkAndG();


        if (index>0 && index < size){
            System.arraycopy(array,index,array,index+1,size-index);

        }
        array[index] = element;
        size++;

    }

    private void checkAndG() {
        if (size == 0){
            array = new int[capacity];
        }
        else if (capacity == size){
            //进行扩容, java扩容成原来的1.5倍
            capacity += capacity>>>1;
            int[] newArray = new int[capacity];
            System.arraycopy(array,0,newArray,0,size);
            array = newArray;

        }
    }


    /**
     * 查询元素
     *
     * @param index 索引位置, 在 [0..size) 区间内
     * @return 该索引位置的元素
     */

    public int get(int index){
        return array[index];
    }





    /**
     * 遍历方法1
     *
     * @param consumer 遍历要执行的操作, 入参: 每个元素
     */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            // 提供 array[i]
            // 返回 void
            consumer.accept(array[i]);
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            int i = 0;

            @Override
            public boolean hasNext() {

                return i < size;
            }

            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }

    /**
     * 遍历方法3 - stream 遍历
     *
     * @return stream 流
     */
    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }





    public int remove(int index){
        int removed = array[index];
        if (index<size-1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            size--;
        }
        return removed;
    }


}
