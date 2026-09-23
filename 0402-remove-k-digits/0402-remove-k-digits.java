class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> digits = new Stack<>();
        for(char ch: num.toCharArray()){
            while(k>0 && !digits.isEmpty() && digits.peek()>ch){
                digits.pop();
                k--;
            }
            digits.push(ch);
        }
        while(k>0 && !digits.isEmpty()){
            digits.pop();
            k--;
        }
        StringBuilder res = new StringBuilder();
        while(!digits.isEmpty()){
            res.append(digits.pop());
        }
        res.reverse();
        int start = 0;
        while(start< res.length() && res.charAt(start)=='0'){
            start++;
        }
        if(start==res.length()){
            return "0";
        }
        return res.substring(start);

    }
}