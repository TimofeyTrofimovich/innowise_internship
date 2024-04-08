import dto.Item;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import util.PriceHelper;

public class PriceHelperTest {

    @Test
    void shouldCountCorrectSum() {
        Item[] items = new Item[2];
        items[0] = new Item("item1", 12.45);
        items[1] = new Item("item2", 14.55);
        double countedSum = PriceHelper.getSumPrice(items);
        Assert.assertEquals(countedSum, 27.00);
    }
}
