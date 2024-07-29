class Solution {
    public int searchInsert(int[] nums, int target) {
        int n= nums.length;
        for(int i=0; i<n; i++)
        {
            if(nums[i]<target)
            continue;
            else if(nums[i]==target || nums[i]>target)
            return i;
            else
            return 0;

        }
        return n;
    }
}