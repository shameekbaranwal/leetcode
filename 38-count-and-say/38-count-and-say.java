class Solution {
    public String countAndSay(int n) {
        return solve(n,"1");  
    }
    public String solve(int n, String s){
        if(n==1) return s;
        String res = "";
        int count = 1;
        for(int i=0;i<s.length();i++){
            if((i+1)<s.length() && s.charAt(i)==s.charAt(i+1)){  // we are checking if the next character is same, if it is then we will increase the count 
                count++;
            }
            else{
                res+=count+""+s.charAt(i);  // if the next character is not the same then we will add the count then the character of which the count is, as the way if saying "11" is "two 1" i.e., "21" i.e., first the count then the character 
                count = 1;  // after that character we again set our count to 1 for the next character
            }
        }
        return solve(n-1,res);
    }
}