class Solution {
    public int findGCD(int[] nums) {
        int max = nums[0], min = nums[0];
        for (int x : nums) {
            max = Math.max(max, x);
            min = Math.min(min, x);
        }
        while (min != 0) {
            int temp = min;
            min = max % min;
            max = temp;
        }
        return max;
    }
}
