class Solution {
    public int maxProduct(int n) {
        String s=String.valueOf(n);
        int[] arr=new int[s.length()];

        for(int i=0;i<s.length();i++){
            arr[i]=s.charAt(i)-'0';
        }        
         Arrays.sort(arr);
         return arr[s.length()-1]*arr[s.length()-2];
    }
}
