class Solution {
    public int mySqrt(int x) {
        
        if(x==0) return 0;

        int left=1,right=x,result=1;

        while(left<=right){
            int mid=left+(right-left)/2;

            long sqrt=(long)mid*mid;

            if(sqrt==x) return mid;

            if(sqrt<x){
                result=mid;
                left=mid+1;
            }
            else{
            right=mid-1;
            }
        }
        return result;
    }
}
