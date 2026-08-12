class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();

        int i = 0, j = 0, result = 0, repeat = 0;

        while (j < n) {

            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

            if (mp.get(nums[j]) == k + 1) {
                repeat++;
            }

            while (repeat > 0) {
                mp.put(nums[i], mp.get(nums[i]) - 1);

                if (mp.get(nums[i]) == k) {
                    repeat--;
                }

                i++;
            }

            result = Math.max(result, j - i + 1);

            j++;
        }

        return result;
    }
}
