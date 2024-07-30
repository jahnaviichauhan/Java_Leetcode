class Solution {
    public int lengthOfLastWord(String s) {
        
        int count=0;
        String news= s.trim();
        int l= news.length();

        for(int i=l-1; i>=0; i--)
        {
            if(news.charAt(i)!=' ')
            count++;
            else
            break;

        }
        return count;
    }
}