class Solution {
    public int findMinDifference(List<String> timePoints) {
      List<Integer> minutesList = new ArrayList<>();
        
        // Convert each time point to minutes and add to the list
        for (String time : timePoints) {
            String[] timeParts = time.split(":");
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);
            int totalMinutes = hours * 60 + minutes;
            minutesList.add(totalMinutes);
        }
        
        // Sort the list of time points in minutes
        Collections.sort(minutesList);
        
        // Initialize the minimum difference as the maximum possible (1440 minutes in a day)
        int minDifference = Integer.MAX_VALUE;
        
        // Compute the differences between consecutive time points
        for (int i = 1; i < minutesList.size(); i++) {
            minDifference = Math.min(minDifference, minutesList.get(i) - minutesList.get(i - 1));
        }
        
        // Compute the circular difference (between the last and the first time point)
        int circularDifference = 1440 + minutesList.get(0) - minutesList.get(minutesList.size() - 1);
        minDifference = Math.min(minDifference, circularDifference);
        
        return minDifference;   
    }
}