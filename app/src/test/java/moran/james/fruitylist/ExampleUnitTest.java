package moran.james.fruitylist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        Fruit f=new Fruit("strawberry",99,1200);
        System.out.println(f.getPriceInPoundsAndPence());
        assertEquals(4, 2 + 2);
    }
}