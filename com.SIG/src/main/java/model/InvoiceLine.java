package model;

/**
 *
 * @author Ahmed
 */
public class InvoiceLine {
    private InvoiceHeader inv;
    private String itemName;
    private double itemPrice;
    private int itemCount;

    public InvoiceLine(InvoiceHeader inv, String itemName, double itemPrice, int itemCount) {
        this.inv = inv;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
    }
    

    public InvoiceHeader getInv() {
        return inv;
    }

    public void setInv(InvoiceHeader inv) {
        this.inv = inv;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    @Override
    public String toString() {
        return "InvoiceLine{" + "inv=" + inv.getInvoiceNum() + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemCount=" + itemCount + ", invNum=" + inv.getInvoiceNum() + '}';
    }

   public String getAsCSV() {
        return inv.getInvoiceNum()+ "," + itemName + "," + itemPrice + "," + itemCount;
    }
   
    public double getTotal(){
        return itemPrice * itemCount;
        }

}
