package util;

import dto.Item;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public final class ItemCreator
{
    public static Item[] getItemsFromNames(String[] names) {
        List<Item> list = Arrays.stream(names)
                .map(name -> new Item(name, PriceHelper.getPriceForItem(name)))
                .collect(Collectors.toList());
        Item[] items = new Item[list.size()];
        list.toArray(items);
        return items;
    }
}
