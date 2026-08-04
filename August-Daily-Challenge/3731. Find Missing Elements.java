class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        Arrays.sort(nums);
        int min=nums[0];
        int max=nums[nums.length-1];

        List<Integer> find = new ArrayList<>();
        for (int num : nums) {
            find.add(num);
        }
            
        List<Integer> ans=new ArrayList<>();

        for(int i=min;i<=max;i++){
            if(find.contains(i)){
                continue;
            }
            else{
                ans.add(i);
            }
        }
        return ans;
    }
}
