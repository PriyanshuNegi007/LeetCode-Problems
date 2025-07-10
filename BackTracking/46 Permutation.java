class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        backtrack(resultList, new ArrayList<>(), nums);
        return resultList;
        
    }
    private void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums){
        //IF we match the length, it is permutation
        if(tempList.size()==nums.length){
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        for(int number:nums){
            //Skip if we get same number
            if(tempList.contains(number))
                continue;
            

            //Add new Number
            tempList.add(number);

            //Go back to try another Number
            backtrack(resultList, tempList, nums);

            //Remove the element
            tempList.remove(tempList.size()-1);
        }
    }
}
