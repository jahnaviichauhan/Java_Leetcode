class Solution {
    public int search(int[] nums, int target) {
        int numsSize=nums.length;
int mid=numsSize/2, i;
if(nums[mid]>target){
    for(i=0;i<mid;i++){
        if(nums[i]==target)
        return i;
    }
}
else{
    for(i=mid;i<numsSize;i++){
        if(nums[i]==target)
        return i;
    }
    }
    return -1;
}
    }