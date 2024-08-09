class Solution {
    public int addDigits(int num) {
        if(num<10)
        return num;
        else
        return calcSum(num);
    }
    public int calcSum(int n){
        int d=0, sum=0;
        while(n>0)
        {
            d=n%10;
            sum+=d;
            n=n/10;
        }
        if(sum<10)
        return sum;
        else
        return calcSum(sum);
    }
}