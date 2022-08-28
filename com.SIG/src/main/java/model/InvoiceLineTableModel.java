
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class InvoiceLineTableModel extends AbstractTableModel {
    
    private ArrayList<InvoiceLine> items;

    public ArrayList<InvoiceLine> getItems() {
        return items;
    }
        private String[] columns = {"No.","Item Name","Item Price","Count","Total"};

  public InvoiceLineTableModel(ArrayList<InvoiceLine> items) {
        this.items = items;
    }
    @Override
    public int getRowCount() {
         return items.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int r) {
         return columns[r];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine item = items.get(rowIndex);
         switch (columnIndex){
             case 0: return item.getInv().getInvoiceNum();
             case 1: return item.getItemName();
             case 2: return item.getItemPrice();
             case 3: return item.getItemCount();
             case 4: return item.getTotal();
             default: return "";
         }
    }
    
}
