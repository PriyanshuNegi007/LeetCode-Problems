class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    void mergeSort(int nums[], int low, int high){
        if (low >= high) { //base case
            return;
        }
        int mid = (low + high) / 2;
        //Divide part
        mergeSort(nums, low, mid); // Left half
        mergeSort(nums, mid + 1, high); // Right half

        //Merge part
        merge(nums, low, mid, high);
    }

    void merge(int nums[], int low, int mid, int high) {
        int left = low;
        int right = mid + 1;  // ➜ must start at mid + 1
        List<Integer> list = new ArrayList<>();

        // Merge two sorted parts
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                list.add(nums[left]);
                left++;
            } else {
                list.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            list.add(nums[left]);
            left++; // ➜ should increment `left`
        }

        while (right <= high) {
            list.add(nums[right]);
            right++; // ➜ should increment `right`
        }

        for (int i = low; i <= high; i++) {
            nums[i] = list.get(i - low);
        }
    }
}
