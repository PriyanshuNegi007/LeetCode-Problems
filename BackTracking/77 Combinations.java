class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> combination, List<List<Integer>> result) {
        // If the combination has k elements, add it to the result
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }
        
        // Try all possible numbers from start to n
        for (int i = start; i <= n; i++) {
            combination.add(i);  // Add number to the current combination
            backtrack(i + 1, n, k, combination, result);  // Recurse with the next number
            combination.remove(combination.size() - 1);  // Backtrack by removing the last number
        }
    }
}
