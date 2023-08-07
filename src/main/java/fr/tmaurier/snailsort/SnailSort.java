package fr.tmaurier.snailsort;

public class SnailSort {

    public static int[] snail(int[][] array) {
        int size = array.length;
        int totalElements = size * size;
        int[] result = new int[totalElements];
        int index = 0;
        int row = 0;
        int col = 0;

        if (array.length == 0 || array[0].length == 0) {
            return new int[0];
        }

        for (int i = 0; i < totalElements; i++) {
            result[index++] = array[row][col];
            array[row][col] = 0;

            if (col + 1 < size && array[row][col + 1] != 0) {
                col++;
            } else if (row + 1 < size && array[row + 1][col] != 0) {
                row++;
            } else if (col - 1 >= 0 && array[row][col - 1] != 0) {
                col--;
            } else if (row - 1 >= 0 && array[row - 1][col] != 0) {
                row--;
            }
        }

        return result;
    }


}
