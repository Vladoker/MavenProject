import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {
    EmployeeManager employeeManager;
    ValueDao dao;
    
     private String name;
     private String surname;


    public MainFrame() {
        initComponents();
        employeeManager = EmployeeManager.getInstance();
        dao = new ValueDao();
        this.empLoader();
    }
    
    public void empLoader() {     
        DefaultTableModel defaultTableModel = (DefaultTableModel) this.jTable1.getModel();
        
        for(Employee emp : dao.getAll()){
            Object[] obj = new Object[]{ emp.getName(), emp.getSurname(),
            emp.getSex().toString(), emp.getDateStringFormat(), String.valueOf(emp.getSalary()), emp.getAddress() };
            defaultTableModel.addRow(obj);
        }            
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelite = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 300));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Surname", "Gender", "Date", "Salary", "Address"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelite.setText("Delete");
        btnDelite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelite, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd)
                .addGap(18, 18, 18)
                .addComponent(btnEdit)
                .addGap(18, 18, 18)
                .addComponent(btnDelite)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       AddDialog modal = new AddDialog(this, true);
       modal.setVisible(true);
       
      this.name = modal.getName();
      this.surname = modal.getSurname();
      
      if(!this.name.isEmpty()) {
          
      DefaultTableModel defaultTableModel = (DefaultTableModel) this.jTable1.getModel();
      Object[] arrObj = new Object[] { name, surname , modal.getGender(), modal.getDate(),
      modal.getSalary(), modal.getAddress() };
         
      defaultTableModel.addRow(arrObj); //defaultTableModel.insertRow()
      Employee emp = employeeManager.addEmployee(arrObj);    
      dao.add(emp);
    }
      
      
      
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeliteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliteActionPerformed
         int selectedRow = this.jTable1.getSelectedRow();
         if(selectedRow != -1){
             DefaultTableModel defaultTableModel = (DefaultTableModel) this.jTable1.getModel();
           String name = (String) defaultTableModel.getValueAt(selectedRow, 0);
           String surname = (String) defaultTableModel.getValueAt(selectedRow, 1);
           defaultTableModel.removeRow(selectedRow);
           employeeManager.deleteEmployee(name + " " + surname);
           dao.remove(name, surname);
         }        
    }//GEN-LAST:event_btnDeliteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int selectedRow = this.jTable1.getSelectedRow();
        if(selectedRow != -1) {
            DefaultTableModel defaultTableModel = (DefaultTableModel) this.jTable1.getModel();
            String[] valuesRow = new String[6];
            for (int i = 0; i < valuesRow.length; i++) {
                valuesRow[i] = (String) defaultTableModel.getValueAt(selectedRow, i);//позиция каждого столбца
            }
            EditDialog editDialog = new EditDialog(this, true, valuesRow);
                      
            editDialog.setVisible(true);
            
            for (int i = 0; i < valuesRow.length; i++) {
                defaultTableModel.setValueAt(valuesRow[i], selectedRow, i);
            }
            dao.edit(editDialog.getOldUser(), valuesRow);
            if(employeeManager.deleteEmployee(editDialog.getOldUser())){
                employeeManager.addEmployee(valuesRow);                
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelite;
    private javax.swing.JButton btnEdit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
