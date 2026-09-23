class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> digit = new Stack<>();
        for(char ch : num.toCharArray()){
            while(k>0 && !digit.isEmpty() && digit.peek()>ch){
                digit.pop();
                k--;
            }
            digit.push(ch);
        }
        while(k>0 && !digit.isEmpty()){
            digit.pop();
            k--;
        }
        StringBuilder res = new StringBuilder();
        while(!digit.isEmpty()){
            res.append(digit.pop());
        }
        res.reverse();
        int srt =0;
        while(srt< res.length() && res.charAt(srt)=='0'){
            srt++;
        }
        if(srt==res.length()){
            return "0";
        }
        return res.substring(srt);

    }
}