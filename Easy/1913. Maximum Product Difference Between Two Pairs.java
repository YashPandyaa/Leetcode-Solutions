class Solution {
    public int maxProductDifference(int[] nums) {
        int n=nums.length;

        // for (int i = 0; i < nums.length - 1; i++) {
        //     for (int j = 0; j < nums.length - i - 1; j++) {
        //         if (nums[j] > nums[j + 1]) {
        //             int temp = nums[j];
        //             nums[j] = nums[j + 1];
        //             nums[j + 1] = temp;
        //         }
        //     }
        // }
        Arrays.sort(nums);

        return (nums[n-1]*nums[n-2])-(nums[0]*nums[1]);
    }
}
