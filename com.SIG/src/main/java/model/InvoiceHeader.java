package model;

import java.util.ArrayList;

/**
 *
 * @author Ahmed
 */
public class InvoiceHeader {
    private int invoiceNum;
    private String invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine> items;
 

    public InvoiceHeader(int invoiceNum, String invoiceDate, String customerName) {
        this.invoiceNum = invoiceNum;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public ArrayList<InvoiceLine> getItems() {
        if (items == null){
            items = new ArrayList();
        }
        return items;
    }

  public double getTotal(){
      double total = 0.0;
        for (InvoiceLine item : getItems()){
         total += item.getTotal();
     }
      
      return total;
  }
  public String getAsCSV() {
        return invoiceNum + "," + invoiceDate + "," + customerName;
    }
    

    @Override
    public String toString() {
        return "InvoiceHeader{" + "invoiceNum=" + invoiceNum + ", invoiceDate=" + invoiceDate + ", customerName=" + customerName + '}';
    }
    
    
}
