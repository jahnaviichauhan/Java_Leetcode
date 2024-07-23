class Solution {
    public int removeElement(int[] nums, int val) {
        int i, k=0, temp;
        int n=nums.length;

        for(i=0; i<n;i++)
        {
            if(nums[i]==val)
            {
                k++;
                }
            }
        
        for(i=0; i<n-k;i++)
        {
            if(nums[i]==val)
            {
               for(int j=n-1; j>=0; j--)
               {
                if(nums[j]!=val)
                {
                temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                }
               }
            }
        }

        return (n-k);
    }
}