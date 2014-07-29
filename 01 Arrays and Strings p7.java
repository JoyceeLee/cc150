/*
 * 1.7  Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
 
public class Solution {
    public void setZero(int[][] matrix) {
        if(matrix==null || matrix.length==0) return;
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m]
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++) {
                if(matrix[i][j]==0) {
                row[i] = true;
                col[j] = true;
            }
        }
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++) {
                if(row[i] || col[j])
                matrix[i][j] = 0;
            }
    }
}
