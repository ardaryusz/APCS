package hw;

import java.util.Scanner;

import helpers.ArrayHelpers;

public class PeakFinder {
    public static void main(String[] args) {
        int[][] array = setGrid(10, 10, 9, 0);
        Scanner scanner = new Scanner(System.in);

        print2DArray(array);

        System.out.println("enter the row of the square you want to check");
        int row = scanner.nextInt() - 1;
        System.out.println("enter the column of the square you want to check");
        int col = scanner.nextInt() - 1;

        System.out.println("the peak of the neighbors for the square you picked is " + findPeak(array, row, col));
        scanner.close();
    }

    public static int[][] setGrid(int rows, int cols, int max, int min) {
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = (int) (Math.random() * (max - min + 1) + min);
            }
        }
        return grid;
    }

    public static int findPeak(int[][] grid, int r, int c) {
        int maximum = Integer.MIN_VALUE;

        for (int rchange = -1; rchange <= 1; rchange++) {
            for (int cchange = -1; cchange <= 1; cchange++) {
                int newr = r + rchange;
                int newc = c + cchange;
                if (newr >= 0 && newc >= 0) {
                    if (grid[newr][newc] > maximum)
                        maximum = grid[newr][newc];
                }
            }
        }

        return maximum;
    }

    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }

        System.out.println();
    }

    public static void print2DArray(int[][] grid) {
        for (int[] eachRow : grid) {
            ArrayHelpers.printArray(eachRow);
        }
    }

}
