class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        int len=0;
        while(true){
            if(len<strs[0].length()){
                boolean alwell=true;
                char ch=strs[0].charAt(len);

                for(int i=1;i<strs.length;i++){
                    if(len>=strs[i].length()||strs[i].charAt(len)!=ch){
                        alwell=false;
                        break;
                    }
                }
                if(alwell)len++; 
                
                else break;
            }
            else break;
        }
        return strs[0].substring(0,len);
    }
}
