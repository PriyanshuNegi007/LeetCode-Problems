class Solution {
    public char findTheDifference(String s, String t) {
        char r=0;
        for(char e: s.toCharArray()){
            //r= (char)(r^e);  XOR operator cancels out same numbers 1^1 =0
            r ^=e;
        }
        for(char e: t.toCharArray()){
            //r= (char)(r^e);
            r^=e;
        }
        return r;
    }
}
