package util;

import dto.Item;
import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public final class PriceHelper {

    public static double getPriceForItem (String description) {

        /*
         * there must be reference to database there
         * but I think it is not essential for this task
         */

        double price = 0;
        switch (description) {
            case "Book" -> price = 5.5;
            case "Mobile phone" -> price = 150;
            case "Laptop" -> price = 830;
            case "Toy" -> price = 0.34;
            case "Computer mouse" -> price = 12.7;
        }
        return price;
    }

    public static double getSumPrice(Item[] items) {
        return Arrays.stream(items)
                .mapToDouble(Item::getPrice)
                .sum();
    }

}
