class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;

        for (String sub : patterns) {
            if (word.contains(sub)) {
                count++;
            }
        }

        return count;
    }
}
