
package view;

import control.Controller;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import model.InvoiceHeader;
import model.InvoiceHeaderTableModel;
import model.InvoiceLineTableModel;


public class Zframe extends javax.swing.JFrame {

   
    public Zframe() {
        controller = new Controller(this); 
        initComponents();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crtNewInvBtn = new javax.swing.JButton();
        crtNewInvBtn.addActionListener(controller);
        dltInvBtn = new javax.swing.JButton();
        dltInvBtn.addActionListener(controller);
        saveBtn = new javax.swing.JButton();
        saveBtn.addActionListener(controller);
        jScrollPane1 = new javax.swing.JScrollPane();
        linesTbl = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        invoicesTbl = new javax.swing.JTable();
        invoicesTbl.getSelectionModel().addListSelectionListener(controller);
        _invNumberLbl = new javax.swing.JLabel();
        _invDateLbl = new javax.swing.JLabel();
        _cxNameLbl = new javax.swing.JLabel();
        _invTotalLbl = new javax.swing.JLabel();
        invNumLbl = new javax.swing.JLabel();
        invDateLbl = new javax.swing.JLabel();
        cxLbl = new javax.swing.JLabel();
        totalLbl = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();
        cancelBtn.addActionListener(controller);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        opnMitem = new javax.swing.JMenuItem();
        opnMitem.addActionListener(controller);
        savMitem = new javax.swing.JMenuItem();
        savMitem.addActionListener(controller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        crtNewInvBtn.setText("Create New Invoice");
        crtNewInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crtNewInvBtnActionPerformed(evt);
            }
        });

        dltInvBtn.setText("Delete Invoice");

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        linesTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(linesTbl);

        invoicesTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(invoicesTbl);

        _invNumberLbl.setText("Invoice Number");

        _invDateLbl.setText("Invoice Date");

        _cxNameLbl.setText("Customer Name");

        _invTotalLbl.setText("Invoice Total");

        invNumLbl.setText(".");

        invDateLbl.setText(".");

        cxLbl.setText(".");

        totalLbl.setText(".");

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        jMenu1.setText("Menu");

        opnMitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        opnMitem.setText("Open");
        opnMitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opnMitemActionPerformed(evt);
            }
        });
        jMenu1.add(opnMitem);

        savMitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        savMitem.setText("Save Data");
        savMitem.setToolTipText("");
        savMitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savMitemActionPerformed(evt);
            }
        });
        jMenu1.add(savMitem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(_invNumberLbl)
                                    .addComponent(_invDateLbl)
                                    .addComponent(_cxNameLbl)
                                    .addComponent(_invTotalLbl))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invNumLbl)
                                    .addComponent(invDateLbl)
                                    .addComponent(cxLbl)
                                    .addComponent(totalLbl))
                                .addContainerGap(206, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(crtNewInvBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dltInvBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveBtn)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn)
                        .addGap(94, 94, 94))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(_invNumberLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(_invDateLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(_cxNameLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(_invTotalLbl))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(invNumLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invDateLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cxLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalLbl)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crtNewInvBtn)
                    .addComponent(dltInvBtn)
                    .addComponent(saveBtn)
                    .addComponent(cancelBtn))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opnMitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opnMitemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opnMitemActionPerformed

    private void savMitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savMitemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_savMitemActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void crtNewInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crtNewInvBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crtNewInvBtnActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Zframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Zframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Zframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Zframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Zframe().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel _cxNameLbl;
    private javax.swing.JLabel _invDateLbl;
    private javax.swing.JLabel _invNumberLbl;
    private javax.swing.JLabel _invTotalLbl;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton crtNewInvBtn;
    private javax.swing.JLabel cxLbl;
    private javax.swing.JButton dltInvBtn;
    private javax.swing.JLabel invDateLbl;
    private javax.swing.JLabel invNumLbl;
    private javax.swing.JTable invoicesTbl;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable linesTbl;
    private javax.swing.JMenuItem opnMitem;
    private javax.swing.JMenuItem savMitem;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel totalLbl;
    // End of variables declaration//GEN-END:variables
private Controller controller = new Controller(this); 
private ArrayList<InvoiceHeader> invHeader;
private InvoiceHeaderTableModel invTableModel;
private InvoiceLineTableModel invLineTableModel;

    public InvoiceLineTableModel getInvLineTableModel() {
        return invLineTableModel;
    }

    public JLabel getCxLbl() {
        return cxLbl;
    }

    public void setCxLbl(JLabel cxLbl) {
        this.cxLbl = cxLbl;
    }

    public JLabel getInvDateLbl() {
        return invDateLbl;
    }

    public void setInvDateLbl(JLabel invDateLbl) {
        this.invDateLbl = invDateLbl;
    }

    public JLabel getInvNumLbl() {
        return invNumLbl;
    }

    public void setInvNumLbl(JLabel invNumLbl) {
        this.invNumLbl = invNumLbl;
    }

    public JTable getInvoicesTbl() {
        return invoicesTbl;
    }

    public void setInvoicesTbl(JTable invoicesTbl) {
        this.invoicesTbl = invoicesTbl;
    }

    public JTable getLinesTbl() {
        return linesTbl;
    }

    public void setLinesTbl(JTable linesTbl) {
        this.linesTbl = linesTbl;
    }

    public JLabel getTotalLbl() {
        return totalLbl;
    }

    public void setTotalLbl(JLabel totalLbl) {
        this.totalLbl = totalLbl;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setInvLineTableMoel(InvoiceLineTableModel invLineTableMoel) {
        this.invLineTableModel = invLineTableMoel;
    }

    public InvoiceHeaderTableModel getInvTableModel() {
        return invTableModel;
    }

    public void setInvTableModel(InvoiceHeaderTableModel invTableModel) {
        this.invTableModel = invTableModel;
    }
    public ArrayList<InvoiceHeader> getInvHeader() {
        return invHeader;
    }

    public void setInvHeader(ArrayList<InvoiceHeader> invHeader) {
        this.invHeader = invHeader;
    }
    public int getNextInvNum() {
            int num = 0;

            for (InvoiceHeader invoice : getInvHeader()) {
                if (invoice.getInvoiceNum()> num) 
                    num = invoice.getInvoiceNum();
            }

            return ++num;
        }

}