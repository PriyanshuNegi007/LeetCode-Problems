class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> bigList = new ArrayList<>();
        List<Integer> smallList = new ArrayList<>();
        helper(candidates,target, 0, smallList, bigList);
        return bigList;
    }
    void helper(int[] candidates, int target,int index, List<Integer> smallList, List<List<Integer>> bigList){
        if(target == 0){
            bigList.add(new ArrayList<>(smallList));
            return;
        }

        if(target<0){
            return;
        }
        
        for(int i = index; i < candidates.length; i++){
            smallList.add(candidates[i]);
            helper(candidates,target-candidates[i], i, smallList, bigList);
            smallList.remove(smallList.size()-1);
        }
    }
}
