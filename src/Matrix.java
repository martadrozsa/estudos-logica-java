/*
You are given a 2-d matrix where each cell represents number of coins in tha cell.
Assuming we start at matrix[0][0], and can only move right or down, find the maximum number of coins you can collect by the bottom right corner.

For example, in this matrix
0 3 1 1
2 0 0 4
1 5 3 1
The most we can collect is: 0 + 2 + 1 + 5 + 3 + 1 = 12 coins
*/
public class Matrix {
    public static void main(String[] args) {

        int[][] matrix = {{0, 3, 1, 1}, {2, 0, 0, 4}, {1, 5, 3, 1}};

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Element [" + i + ", " + j + "]: ");
                sum = sum + matrix[i][j];
            }
        }
        System.out.println("\n\nSum of the elements: " + sum);
    }


}
