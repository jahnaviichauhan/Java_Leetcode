class Solution {
    public int[] sortArray(int[] nums) {
         if (nums == null || nums.length <= 1) {
            return nums;
        }
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }
        
        int middle = (leftStart + rightEnd) / 2;
        mergeSort(nums, temp, leftStart, middle);
        mergeSort(nums, temp, middle + 1, rightEnd);
        merge(nums, temp, leftStart, rightEnd);
    }

    private void merge(int[] nums, int[] temp, int leftStart, int rightEnd) {
        int middle = (leftStart + rightEnd) / 2;
        int leftEnd = middle;
        int rightStart = middle + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }

        System.arraycopy(nums, left, temp, index, leftEnd - left + 1);
        System.arraycopy(nums, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, nums, leftStart, size);
    }
}