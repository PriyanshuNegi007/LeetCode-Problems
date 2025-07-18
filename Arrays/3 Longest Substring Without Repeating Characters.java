class Solution {
    public int lengthOfLongestSubstrings(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength=0;
        int left=0;
        for(int right=0;right< s.length();right++){
            //if character already exists shrink window from left
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            //Add current char and update max length
            set.add(s.charAt(right));
            maxLength= Math.max(maxLength,right-left+1);
        }
      return maxLength;  
    }

    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        int[] hashset = new int[128];

        while(j < s.length()){
            char singleChar = s.charAt(j);
            hashset[singleChar]++; //hashset[ASCII value]++ -> hs[a]++ = hs[97]++ =  0 + 1
            while(hashset[singleChar] > 1){ // if char appears more than once
                char leftChar = s.charAt(i);
                hashset[leftChar]--;
                i++;  // Slide the window
            }
            max= Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}
