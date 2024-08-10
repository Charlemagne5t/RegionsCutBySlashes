import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        String [] grid = {"/\\","\\/"};
        int expected = 5;
        int actual = new Solution().regionsBySlashes(grid);

        Assert.assertEquals(expected, actual);
    }
}
