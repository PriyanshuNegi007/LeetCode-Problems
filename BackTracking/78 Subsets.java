class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> bigList = new ArrayList<>();
        subSetsHelper(nums, 0, bigList, new ArrayList<>());
        return bigList;
    }

    private void subSetsHelper(int[] nums, int index, List<List<Integer>> bigList, List<Integer> smallList) {
         if(index>nums.length){
            return;
        }
        bigList.add(new ArrayList<>(smallList));

        for (int i = index; i < nums.length; i++) {
            smallList.add(nums[i]);  // choose
            subSetsHelper(nums, i + 1, bigList, smallList);
            smallList.remove(smallList.size() - 1);
        }
    }
}
