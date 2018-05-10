package receiptcode;

import android.content.ClipData;

/**
 * Created by Gustav on 2018-03-10.
 */

public class GroceryItem {

    String itemName;
    int price;
    String itemCategory;

    public GroceryItem(String itemName, String itemCategory, int price) {
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.price = price;
    }

    public String getName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return itemCategory;
    }
}

