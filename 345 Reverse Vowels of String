class Solution {
    boolean isVowels(char ch){
        return "aeiouAEIOU".indexOf(ch)>=0;
    }
    public String reverseVowels(String s) {
        int i=0;
        int j = s.length()-1;
        char arr[]= s.toCharArray(); //string converts into char[(Mutable)]
        while(i<=j){
            if(!isVowels(arr[i])){
                i++;
            }
            else if(!isVowels(arr[j])){
                j--;
            }
            else{
                //it means vowel so swap
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        //Convert char[] into string
        return new String(arr); 
    }
    
}
