class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Define a custom comparator
        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        };

        // Sort the array using the custom comparator
        Arrays.sort(strNums, customComparator);

        // Handle the case where the largest number is 0
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Build the largest number by concatenating the sorted strings
        StringBuilder largestNumber = new StringBuilder();
        for (String num : strNums) {
            largestNumber.append(num);
        }

        return largestNumber.toString();
    }
}