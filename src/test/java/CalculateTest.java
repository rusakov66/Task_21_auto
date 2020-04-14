import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.junit.jupiter.api.Assertions.assertAll;

class CalculateTest {

    @Test
    public void trip() {
        int[][] matrix1 = {
                { 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 1, 0, 0},
                { 0, 0, 0, 0, 0, 0}
        };
        int[][] matrix2 = {
                { 0,  0, 0, 0, 0, 0},
                { 0, -1, 0,-1, 0, 0},
                { 0, -1, 0, 0, 0, 0},
                { -1,-1, 0, 0,-1, 0},
                { -1, 0, 0, 1, 0,-1},
                { -1,-1,-1,-1,-1,-1}
        };
        int[][] matrix3 = {
                { 0, 0, 0, 0, 0, 0},
                { 0,-1, 0,-1, 0, 0},
                { 0, 0, 0, 0, 0, 0},
                {-1, 0,-1,-1,-1, 0},
                {-1, 0, 0, 1, 0,-1},
                {-1,-1,-1,-1,-1,-1}
        };
        String expected1 = "(3, 4); (3, 5); ";
        String expected2 = "(3, 4); (3, 3); (3, 2); (4, 2); (5, 2); ";
        String expected3 = "(3, 4); (2, 4); (1, 4); (1, 3); (1, 2); (0, 2); ";
        Calculate calc = new Calculate();
        String actual1 = calc.trip(matrix1);
        String actual2 = calc.trip(matrix2);
        String actual3 = calc.trip(matrix3);
        assertAll(
                ()-> assertThat(expected1, comparesEqualTo(actual1)),
                ()-> assertThat(expected2, comparesEqualTo(actual2)),
                ()-> assertThat(expected3, comparesEqualTo(actual3))
        );
    }
}