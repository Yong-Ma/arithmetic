package other;

public class Solution {
    public int maxValue (int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0]=matrix[i][0]+matrix[i-1][0];
        }
        for (int i = 1; i < matrix[0].length; i++) {
            matrix[0][i]= matrix[0][i]+matrix[0][i-1];
        }
        for (int i = 1; i <matrix.length ; i++) {
            for (int j = 1; j <matrix[0].length ; j++) {
                matrix[i][j]=matrix[i][j]+Math.max(matrix[i][j-1],matrix[i-1][j]);
            }
        }
        return matrix[matrix.length-1][matrix[0].length-1];
    }
}
