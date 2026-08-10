class Solution {
    public boolean isMatch(String s, String p) {
        boolean [][]dp=new boolean[s.length()+1][p.length()+1];
        int mr=dp.length-1;
        int mc=dp[0].length-1;

        for(int i=0;i<=mr;i++){
            for(int j=0;j<=mc;j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                }
                else if(i==0){
                    char chp=p.charAt(j-1);

                    if(chp=='*'){
                        dp[i][j]=dp[i][j-2];
                    }
                }
                else if(j==0){
                    dp[i][j]=false;
                }
                else{
                    char chp=p.charAt(j-1);
                    char chs=s.charAt(i-1);
                    if(chp=='*'){
                        dp[i][j]=dp[i][j-2];

                        char chpm1=p.charAt(j-2);
                        if(chpm1=='.'||chpm1==chs){
                        dp[i][j]=dp[i][j] || dp[i-1][j];
                        }

                    }
                    else if(chp=='.'){
                        dp[i][j]=dp[i-1][j-1];
                    }
                    else if(chp==chs){
                        dp[i][j]=dp[i-1][j-1];
                    }
                    else{
                        dp[i][j]=false;    
                    }
                }
            }
        }

        return dp[mr][mc];
    }
}
