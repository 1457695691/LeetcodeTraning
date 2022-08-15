package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 013. 二维子矩阵的和
 * @date 2022/7/20 14:26
 */
public class NumMatrix {

    /**
     * 二维数组前缀和
     */
    private final int[][] preSum;

    public NumMatrix(int[][] matrix) {
        preSum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                preSum[i + 1][j + 1] = matrix[i][j] + preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
    }

    public static void main(String[] args) {
        int[][] martix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(martix);
        int i = numMatrix.sumRegion(2, 1, 4, 3);
        int i1 = numMatrix.sumRegion(1, 1, 2, 2);
        int i2 = numMatrix.sumRegion(1, 2, 2, 4);

        System.out.println(i + " " + i1 + " " + i2);
    }
}
