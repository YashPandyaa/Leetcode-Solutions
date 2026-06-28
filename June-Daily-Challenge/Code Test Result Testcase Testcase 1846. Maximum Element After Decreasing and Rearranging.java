class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;

        arr[0]=1;
        for(int i=1;i<n;i++){
            if(Math.abs(arr[i-1]-arr[i])<=1) continue;
            else arr[i]=arr[i-1]+1;
        }
        return arr[n-1];
        
    }
}
