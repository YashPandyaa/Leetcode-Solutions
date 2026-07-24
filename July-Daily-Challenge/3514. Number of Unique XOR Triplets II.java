class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        boolean[] pairseen=new boolean[2048];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pairseen[nums[i]^nums[j]]=true;
            }
        }

        boolean[] tripleseen=new boolean[2048];
        int count=0;

        for(int s=0;s<2048;s++){
            if(!pairseen[s]) continue;

            for(int k=0;k<n;k++){
                int val=s^nums[k];
                if(!tripleseen[val]){
                    tripleseen[val]=true;
                    count++;
                }
            }
        }
        return count;
    }
}
