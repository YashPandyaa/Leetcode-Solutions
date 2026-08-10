class Solution {
    public List<String> letterCombinations(String digits) {
        String []map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        List<String> ans=new ArrayList<>(); 
        if(digits.length()==0)return ans;      
        ans.add("");
        
        for(int i=0;i<digits.length();i++){
            char ch=digits.charAt(i);
            int n=ch-'0';
            String letter=map[n];

            List<String> temp=new ArrayList<>(); 

            for(String s:ans){
                for(int j=0;j<letter.length();j++){
                    temp.add(s+letter.charAt(j));
                }
            }
                ans=temp;
        }
        return ans;
    }
}
