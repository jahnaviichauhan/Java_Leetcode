class Solution {
    public int romanToInt(String s) {
        int l = s.length();
        int sum=0;
        for(int i=0; i<l; i++)
        {
            char current = s.charAt(i);
            if (current == 'I') {
                if (i + 1 < l && s.charAt(i + 1) == 'V') {
                    sum += 4;
                    i++;
                } else if (i + 1 < l && s.charAt(i + 1) == 'X') {
                    sum += 9;
                    i++;
                } else {
                    sum += 1;
                }
            } else if (current == 'X') {
                if (i + 1 < l && s.charAt(i + 1) == 'L') {
                    sum += 40;
                    i++;
                } else if (i + 1 < l && s.charAt(i + 1) == 'C') {
                    sum += 90;
                    i++;
                } else {
                    sum += 10;
                }
            } else if (current == 'C') {
                if (i + 1 < l && s.charAt(i + 1) == 'D') {
                    sum += 400;
                    i++;
                } else if (i + 1 < l && s.charAt(i + 1) == 'M') {
                    sum += 900;
                    i++;
                } else {
                    sum += 100;
                }
            } else if (current == 'V') {
                sum += 5;
            } else if (current == 'L') {
                sum += 50;
            } else if (current == 'D') {
                sum += 500;
            } else if (current == 'M') {
                sum += 1000;
            } else {
                return 0;
            }
        }
        return sum;
    }
}