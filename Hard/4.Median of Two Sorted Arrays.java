class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sort=new int[nums1.length+nums2.length];
        double median=0;
        int k=0;
        
        for(int i=0;i<nums1.length;i++){
            sort[k++]=nums1[i];
        }
        
        for(int i=0;i<nums2.length;i++){
            sort[k++]=nums2[i];
        }
        Arrays.sort(sort);
           
        if(sort.length%2!=0){
            median=sort[sort.length/2];
        }
        else{
            median=(sort[(sort.length/2)-1]+sort[(sort.length/2)])/2.0;
        }
        return median;
    }
}
