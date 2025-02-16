public class BinarySearchProblem3{

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int right = rows * columns - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int row = mid / columns;
            int col = mid % columns;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int target = 3;
        boolean result = searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + result);

        target = 13;
        result = searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + result);
    }
}
