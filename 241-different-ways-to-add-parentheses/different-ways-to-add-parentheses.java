class Solution {
private Map<String, List<Integer>> memo = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String expression) {
        // Check if the result is already in the memoization map
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }
        
        List<Integer> result = new ArrayList<>();
        
        // Traverse through the expression to find operators
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            // If the current character is an operator
            if (ch == '+' || ch == '-' || ch == '*') {
                // Split the expression into two parts: left and right around the operator
                String leftExpr = expression.substring(0, i);
                String rightExpr = expression.substring(i + 1);
                
                // Recursively calculate all possible results for left and right parts
                List<Integer> leftResults = diffWaysToCompute(leftExpr);
                List<Integer> rightResults = diffWaysToCompute(rightExpr);
                
                // Combine results from left and right using the current operator
                for (int left : leftResults) {
                    for (int right : rightResults) {
                        int computedResult = 0;
                        if (ch == '+') {
                            computedResult = left + right;
                        } else if (ch == '-') {
                            computedResult = left - right;
                        } else if (ch == '*') {
                            computedResult = left * right;
                        }
                        result.add(computedResult);
                    }
                }
            }
        }
        
        // If there were no operators in the expression, it means it's a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        
        // Store the result in the memo map to avoid recomputation
        memo.put(expression, result);
        return result;
    }

    
}