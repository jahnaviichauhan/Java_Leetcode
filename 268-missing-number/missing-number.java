class Solution {
    public int missingNumber(int[] nums) {
        int n= nums.length;
        int i;

        for (i = 1; i < n; ++i) {
            int key = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }

        for(i=0; i<n; i++){
            if(nums[i]==i)
            continue;
            else
            {
            return i;
            }
        }
        return i;
    }
}