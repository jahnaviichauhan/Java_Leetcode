class Solution {
    public boolean isPalindrome(int x) {
        long sum=0;
        int n=x;
while(n>0){
    int d=n%10;
    sum= d+ (sum*10);
    n=n/10;
}
if(sum==x)
return true;
else
return false;
    }
}