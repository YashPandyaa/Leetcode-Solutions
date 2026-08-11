class Solution {
    public int missingInteger(int[] nums) {

        int ans = 0;
        boolean stopped = false;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i + 1] - nums[i] == 1) {
                ans += nums[i];
            } 
            else {
                ans += nums[i];
                stopped = true;
                break;
            }
        }

        if (!stopped) {
            ans += nums[nums.length - 1];
        }

        while (true) {
            boolean found = false;
            
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == ans) {
                    found = true;
                    break;
                }
            }

            if (found) {
                ans++;
            } 
            else {
                return ans;
            }
        }
    }
}
