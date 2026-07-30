class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int count=0;

        if(n<=8) count=n;
        else if(n<16) count=8+(n-8)*2;
        else if(n<24) count=24+(n-16)*3;
        else count=48+(n-24)*4;

        return count;
    }
}
