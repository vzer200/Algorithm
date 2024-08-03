package sf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class E34 {
    public int[] searchRange(int[] a, int target) {
        //left方法查找左边界 遇到相等的值仍然向左搜索 所以是start = mid-1
        //right就是end = mid+1
        if (a.length == 0 || a[0] > target || a[a.length - 1] < target) {
            return new int[] {-1,-1};
        }
        int lm = left(a,target);
        int rm = right(a,target);
        return new int[] {lm,rm};

    }

    private int left(int[] a, int target) {

        int start = 0;
        int end = a.length-1;
        while (start<=end){
            int mid = (start+end) >>> 1;
            if (a[mid]<target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        if (a[start] == target) {
            return start;
        } else {
            return -1;
        }
    }

    private int right(int[] a, int target) {

        int start = 0;
        int end = a.length-1;
        while (start<=end){
            int mid = (start+end) >>> 1;
            if (a[mid]>target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        if (a[end] == target) {
            return end;
        } else {
            return -1;
        }
    }



    //10 01 10 11 00 01
    //01 01 10 00 11 10



}
