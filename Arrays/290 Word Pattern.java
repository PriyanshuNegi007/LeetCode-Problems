class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if(strs.length != pattern.length()){
            return false;
        }
        //Declare 2 HashMap
        Map<Character,String> map1 = new HashMap<>();
        Map<String,Character> map2 = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++){
            char singleChar = pattern.charAt(i);
            String word = strs[i];
            
            // a exists in map1 ?
            if(map1.containsKey(singleChar)){
                String mapWord = map1.get(singleChar); // a(key) --> dog
                if(!mapWord.equals(word)){
                    return false; // Invalid Pattern
                }
            }else{
                //If key not found
                map1.put(singleChar,word); //a key -->dog
            }

            //Now do same for map2
            if(map2.containsKey(word)){
                char pt = map2.get(word);
                if(pt != singleChar){
                    return false;
                }
            } else{
                //If key not found
                map2.put(word,singleChar); //a key -->dog
            }
        }
        return true;
    }
}
