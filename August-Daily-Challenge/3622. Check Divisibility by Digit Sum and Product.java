class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0,pro=1,t=n;

        while(t>0){
            int dig=t%10;
            sum=sum+dig;
            pro=pro*dig;
            t=t/10;
        }
        int ans=sum+pro;

        if(n%ans==0) return true;
        else return false;
        
    }
}
