class Solution {
    //Brute Force
    boolean isAnagram(String first, String second){
        if(first.length() != second.length()){
            return false;
        }
        char[] x = first.toCharArray();
        char[] y = second.toCharArray();

        Arrays.sort(x);
        Arrays.sort(y);

        return Arrays.equals(x,y); //If same return true, else false
    }

    public List<List<String>> groupAnagramsBruteForce(String[] strs) {
        List<List<String>> bigList = new ArrayList<>();
        for(String word: strs){
            boolean added = false; //Flag to check weather its on the list
            for(List<String> smallList: bigList){
                if(isAnagram(smallList.get(0),word)){
                    smallList.add(word);
                    added = true;
                    break;
                }
            }
            if(!added){
                List<String> newSmallList = new ArrayList<>();
                newSmallList.add(word);
                bigList.add(newSmallList);
            }
        }
        return bigList;
    }
    //Approach -2
    public List<List<String>> groupAnagramsOld(String[] strs){
        Map<String,List<String>> map = new HashMap<>();
        for(String word: strs){
            char[] w = word.toCharArray();
            Arrays.sort(w);
            String key = new String(w);
            map.computeIfAbsent(key, k-> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
    //Approach -3
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map = new HashMap<>();
        for(String word:strs){
            int[] countArray = new int[26];
            for(char c: word.toCharArray()){
                countArray[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int k: countArray){
                sb.append(k).append('#'); // Looks like- 1#1#1#1#
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k->new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
