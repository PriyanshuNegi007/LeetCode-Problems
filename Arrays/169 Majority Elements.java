class Solution {
    public int majorityElementBruteForce(int[] nums) {
        int n = nums.length/2;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i:nums){
            map.put(i , map.getOrDefault(i,0)+1);
            if(map.get(i) > n){
                return i;
            }
        }
        return 0;
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for(int i:nums){
            if(count == 0){
                candidate = i;
            }
            if(candidate == i){
                count = count + 1;
            }else{
                count = count-1;
            }
        }
        return candidate;
    }
}
