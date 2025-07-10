
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
       List<List<Integer>> bigList = new ArrayList<>();
       Arrays.sort(nums);

       backtrack(bigList, new ArrayList<>(), nums, new boolean[nums.length]);

       return bigList;
    }

    private void backtrack(List<List<Integer>> bigList, ArrayList<Integer> smallList, int nums[], boolean isVisited[]){

        //If we match the length, it is permutation
        if(smallList.size()==nums.length){
            bigList.add(new ArrayList<>(smallList));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(isVisited[i] || i >0 && nums[i]==nums[i-1] && !isVisited[i-1]){
                continue;
            }
            isVisited[i]=true;

            smallList.add(nums[i]);

            backtrack(bigList,smallList,nums,isVisited);

            isVisited[i]=false;

            smallList.remove(smallList.size()-1);
        }
    }
}
