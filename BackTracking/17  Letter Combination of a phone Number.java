class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<String>();
        }else{
            return helper(digits);
        }
    }
  
    public List<String> helper(String digits) {
        String [] keys= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        //Base Case
        if(digits.length() == 0){
            List<String> list = new ArrayList<>();
            list.add(""); //Traverable
            return list;
        }

        List<String> newList = new ArrayList<>();

        char first = digits.charAt(0); //'2'
        int index = first-'0';     //Ascii values '2'-'0'=2  (eg 50-48)
        String str = keys[index];  // "abc"

        for(int i = 0; i < str.length(); i++){
            List<String> oldList = helper(digits.substring(1));
            for(int j = 0; j < oldList.size(); j++){
                newList.add(str.charAt(i) + oldList.get(j));
            }
        }
        return newList;
    }
}
