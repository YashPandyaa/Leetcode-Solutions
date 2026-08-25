class Solution {
    public int missingMultiple(int[] nums, int k) {
        
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int i = 1;
        while (set.contains(i * k)) i++;

        return i * k;
    }
}
