class Solution {
    public String fractionAddition(String expression) {
        int numerator = 0;
        int denominator = 1;
        int i = 0, n = expression.length();
        
        while (i < n) {
            // Read the sign
            int sign = 1;
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign = expression.charAt(i) == '-' ? -1 : 1;
                i++;
            }
            
            // Read the numerator
            int num = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                num = num * 10 + (expression.charAt(i) - '0');
                i++;
            }
            
            // Skip the '/'
            i++;
            
            // Read the denominator
            int den = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                den = den * 10 + (expression.charAt(i) - '0');
                i++;
            }
            
            // Update the result
            numerator = numerator * den + sign * num * denominator;
            denominator *= den;
            
            // Reduce the fraction
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        
        return numerator + "/" + denominator;
    }
    
    // Function to find the greatest common divisor
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}