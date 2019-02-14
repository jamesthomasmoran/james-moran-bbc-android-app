package moran.james.fruitylist;

import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(Parameterized.class)
public class FruitUnitTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
                {       "apple", 149, 120,
                        new FruitExpectedValues(1.49,0.12,"£1.49","0.12KG")
                },
                {       "banana", 129, 80,
                        new FruitExpectedValues(1.29,0.08,"£1.29","0.08KG")
                },
                {       "blueberry", 19, 18,
                        new FruitExpectedValues(0.19,0.018,"£0.19","0.018KG")
                },
                {       "orange", 199, 150,
                        new FruitExpectedValues(1.99,1.5,"£1.99","0.15KG")
                },
                {       "pear", 99, 100,
                        new FruitExpectedValues(0.99,0.1,"£0.99","0.1KG")
                },
                {       "strawberry", 99, 20,
                        new FruitExpectedValues(0.99,0.02,"£0.99","0.02KG")
                },
                {       "kumquat", 49, 80,
                        new FruitExpectedValues(0.49,0.08,"£0.49","0.08KG")
                },
                {       "pitaya", 599, 100,
                        new FruitExpectedValues(5.99,0.1,"£5.99","0.1KG")
                },
                {       "kiwi", 89, 200,
                        new FruitExpectedValues(0.89,0.2,"£0.89","0.2KG")
                }

        });
    }

    private Fruit fruit;
    private FruitExpectedValues expected;


    public FruitUnitTest(String type, double price, double weight, FruitExpectedValues expected){

        this.fruit=new Fruit(type,price,weight);
        this.expected=expected;
    }
    @Test
    public void FruitCanReturnPriceInPoundsAndPence() {
        double TOL=0.001;

        assertEquals(expected.getPriceInPoundsAndPence(), fruit.getPriceInPoundsAndPence(),TOL);
    }

    @Test
    public void FruitCanReturnWeightInKilograms() {
        double TOL=0.001;

        assertEquals(expected.getWeightInKilograms(), fruit.getWeightInKilograms(),TOL);
    }
    @Test
    public void FruitCanFormatPriceInPoundsAndPence() {

        assertEquals(expected.getFormattedPrice(), fruit.formatPriceOfFruit());
    }

    @Test
    public void FruitCanFormatWeightInKilograms() {

        assertEquals(expected.getFormattedWeight(), fruit.formatWeightOfFruit());
    }
}