class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while(top <= bottom && left <= right){
            //Step 1 - Move from left to right
            for(int j = left; j <= right; j++){
                result.add(matrix[top][j]);
            }
            //Shrink the ow after traversal
            top++;

            //Step 2 - Move top to bottom
            for(int j = top; j <= bottom; j++){
                result.add(matrix[j][right]);
            }
            //Shrink the right col
            right--;

            //Step 3 - Move right to left
            if(top <= bottom){
                for(int j = right; j >= left; j--){
                    result.add(matrix[bottom][j]);
                }
                //Shrink the bottom
                bottom--;
            }

            //Step 4 - Move down to up
            if(left <= right){
                for(int j = bottom; j >= top; j--){
                    result.add(matrix[j][left]);
                }
                //Shrink left
                left++;
            }
        }
        return result;
    }
}
