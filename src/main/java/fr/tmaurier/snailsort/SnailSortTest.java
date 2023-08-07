package fr.tmaurier.snailsort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;

class SnailSortTest {

    @Test
    public void shouldSortInSnail() {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] r = {1, 2, 3, 6, 9, 8, 7, 4, 5};
        test(array, r);
    }

    @Test
    public void shouldHandleEmptyArray() {
        int[][] array = {{}};
        int[] r = {};
        test(array, r);
    }


    public String int2dToString(int[][] a) {
        return Arrays.stream(a).map(Arrays::toString).collect(joining("\n"));
    }

    public void test(int[][] array, int[] result) {
        String text = int2dToString(array) + " should be sorted to " + Arrays.toString(result);
        System.out.println(text);
        assertThat(SnailSort.snail(array)).isEqualTo(result);
    }
}