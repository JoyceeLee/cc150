/*
 * 1.6 Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, 
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */
 
 
public class Solution {
	// public static void main(String[] args) {
	//     int[][] A = new int[4][4];
	//     for(int i=0; i<4; i++)
	// 	for(int j=0; j<4; j++) {
	// 	    A[i][j] = (int) (Math.random() * 100);
	// 	}
	//     rotate(A);
	// }
	public static void rotate(int[][] img) {
	    //int N = img.length;
	    //for(int j=0; j<N; j++) {
	    //	for(int jj=0; jj<N; jj++){
	    //		System.out.print(img[j][jj]+", ");
	    //    }
	    //	System.out.print('\n');
	    //}
	    //System.out.print('\n');
 
	    int n = img.length;
            if(n<=1) return;
            for(int i=0; i<(n/2);i++){
                for(int j=i; j<n-i-1; j++){
                    int tmp = img[i][j];
                    img[i][j] = img[n-1-j][i];
                    img[n-1-j][i] = img[n-1-i][n-1-j];
                    img[n-1-i][n-1-j] = img[j][n-1-i];
                    img[j][n-1-i] = tmp;
                }
            }
	    //for(int j=0; j<N; j++) {
	    //	for(int jj=0; jj<N; jj++){
	    //	    System.out.print(img[j][jj]+", ");
	    //    }
	    //	System.out.print('\n');
	    //}
    }
}
