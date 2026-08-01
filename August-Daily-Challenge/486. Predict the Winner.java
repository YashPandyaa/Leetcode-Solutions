class Solution {
    public boolean predictTheWinner(int[] nums) {
        int player1MaxAdv= currplayerAdv(nums,0,nums.length-1);
        if(player1MaxAdv>=0) return true;
        else return false;
        
    }

    private int currplayerAdv(int[] nums,int left,int right){

        if(left==right) return nums[left];

        int chooseLeft=nums[left]-currplayerAdv(nums,left+1,right);

        int chooseRight=nums[right]-currplayerAdv(nums,left,right-1);

        return Math.max(chooseLeft,chooseRight);

 }
}
