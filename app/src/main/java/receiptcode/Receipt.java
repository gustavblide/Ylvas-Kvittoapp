package receiptcode;

import com.kvittoapp.MainActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Gustav on 2018-03-10.
 */

public class Receipt {
    private String date;
    private String id;
    private ArrayList<GroceryItem> items;

    String thisDate = getFormattedDate(new Date());

    public static ArrayList<Receipt> receiptList = new ArrayList<>() ;

    public String getFormattedDate(Date date) {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = myFormat.format(date);
        return dateString;
    }

    public Receipt() {
        date = thisDate;
        id = createId(this);
        items = new ArrayList<GroceryItem>();
    }

    // This constructor should be used if one wants to create a receipt with any other date than the current date.
    public Receipt(String receiptDate) {
        date = receiptDate;
        id = createId(this);
        items = new ArrayList<>();
    }

    public String getId() {
        return id;
    }
    public String getDate() { return date; }
    public ArrayList<GroceryItem> getItems() { return items; }

    /* Creates an id for a receipt.
    * The id is a string containing the receipt's date and an integer number to distinguish from other receipts with the same date.
    * For example: "2018-03-11-001". (Can only handle 999 receipts on the same date)
    */
    private String createId(Receipt receipt) {
       String receiptId;
        int receiptOrder = 1;
        String receiptDate = receipt.date;
        for (int i=0; i<receiptList.size(); i++) {
            String dateAlreadyWithReceipt = receiptList.get(i).date;
            if (receiptDate.equals(dateAlreadyWithReceipt)) {
                receiptOrder++; }
        }
        receiptId = receiptDate + "-" + String.format("%03d", receiptOrder);
        return receiptId;
    }

    public void addItemToReceipt(GroceryItem groceryItem) {
        this.items.add(groceryItem);
    }




}
