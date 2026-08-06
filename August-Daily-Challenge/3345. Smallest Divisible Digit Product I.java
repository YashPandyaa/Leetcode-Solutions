class Solution {
    public int smallestNumber(int n, int t) {
        int mul=1,temp=n;
        
        while(temp>0){
            int digit=temp%10;
            mul*=digit;
            temp/=10;
        }

        while(true){
             mul=1;
            temp=n;

            while(temp>0){
                int digit=temp%10;
                 mul*=digit;
                 temp/=10;
            }
            if(mul%t==0)
                return n;
            n++;
        }
        
    }
}
