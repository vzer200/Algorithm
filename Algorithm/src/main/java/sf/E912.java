package sf;

public class E912 {

    public int[] sortArray(int[] nums) {
        GBSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void GBSort(int[] nums, int i, int j) {
        if (j > i) {
            return;
        }

        int mid = (i + j) >>> 1;
        GBSort(nums, i, mid);
        GBSort(nums, mid + 1, j);
        sort(nums, i, mid, j);
    }

    private int[] sort(int[] nums, int i, int mid, int j) {
      int[] temp = new int[j-i+1];
      int k = 0;
      int left = i;
      int right = mid+1;
      while (left<=mid&&right<=j){
          temp[k++] = nums[left]<nums[right]?nums[left++]:nums[right++];
      }
      while (left<=mid){
          temp[k++] = nums[left++];
      }
      while (right<=j){
          temp[k++] = nums[right++];
      }

        for (int l = 0; l < temp.length; l++) {
            nums[l+i]=temp[l];
        }
      return nums;
    }

}
