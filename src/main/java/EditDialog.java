
public class EditDialog extends javax.swing.JDialog {

    private String[] valuesRow;
    private String oldData; 
    /**
     * Creates new form EditDialog
     */
    public EditDialog(java.awt.Frame parent, boolean modal, String[] valuesRow) {
        super(parent, modal);
        initComponents();
        this.valuesRow = valuesRow;           
        this.selectedValues();
    }
    
    public void setValuesRow(String[] values){
        this.valuesRow = values;
    }
    public String[] getValuesRow() {
        return this.valuesRow;
    }
    public String getOldUser(){
        return this.oldData;
    }
    
    private void selectedValues() {
        this.NameTextField.setText(valuesRow[0]);
        this.SurnameTextField.setText(valuesRow[1]);
        this.DataTextField.setText(valuesRow[3]);
        this.SalaryTextField.setText(valuesRow[4]);
        this.AddresTextField.setText(valuesRow[5]); 
        
        this.oldData = valuesRow[0] + " " + valuesRow[1];
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        SalaryTextField = new javax.swing.JTextField();
        AddresTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NameTextField = new javax.swing.JTextField();
        SurnameTextField = new javax.swing.JTextField();
        btnEditModal = new javax.swing.JButton();
        jCheckBoxMale = new javax.swing.JCheckBox();
        jCheckBoxFemale = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        DataTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(600, 350));

        jLabel4.setText("Salary");

        SalaryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalaryTextFieldActionPerformed(evt);
            }
        });

        AddresTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddresTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Address");

        jLabel1.setText("Name");

        jLabel2.setText("Surname");

        NameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTextFieldActionPerformed(evt);
            }
        });

        SurnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SurnameTextFieldActionPerformed(evt);
            }
        });

        btnEditModal.setText("Edit");
        btnEditModal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditModalActionPerformed(evt);
            }
        });

        jCheckBoxMale.setText("Male");
        jCheckBoxMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMaleActionPerformed(evt);
            }
        });

        jCheckBoxFemale.setText("Female");

        jLabel3.setText("Data");

        DataTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SalaryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBoxMale)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxFemale)
                                .addContainerGap())
                            .addComponent(SurnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddresTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(btnEditModal, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SurnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxMale)
                    .addComponent(jCheckBoxFemale)
                    .addComponent(jLabel3)
                    .addComponent(DataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(SalaryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddresTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(btnEditModal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalaryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaryTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalaryTextFieldActionPerformed

    private void AddresTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddresTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddresTextFieldActionPerformed

    private void NameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTextFieldActionPerformed

    }//GEN-LAST:event_NameTextFieldActionPerformed

    private void SurnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SurnameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SurnameTextFieldActionPerformed

    private void btnEditModalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditModalActionPerformed
        if(!this.NameTextField.getText().isEmpty() &&
            !this.SurnameTextField.getText().isEmpty()&&
            !this.AddresTextField.getText().isEmpty() &&
            !this.SalaryTextField.getText().isEmpty() &&
            !this.DataTextField.getText().isEmpty() &&
            (this.jCheckBoxFemale.isSelected()|| this.jCheckBoxMale.isSelected())){

            this.valuesRow[0] = this.NameTextField.getText();
            this.valuesRow[1] = this.SurnameTextField.getText();
            this.valuesRow[2] = this.jCheckBoxMale.isSelected() ? "Male" : "Female";
            this.valuesRow[3] = this.DataTextField.getText();
            this.valuesRow[4] = this.SalaryTextField.getText();
            this.valuesRow[5] = this.AddresTextField.getText();
            
            
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnEditModalActionPerformed

    private void jCheckBoxMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxMaleActionPerformed

    private void DataTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DataTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddresTextField;
    private javax.swing.JTextField DataTextField;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JTextField SalaryTextField;
    private javax.swing.JTextField SurnameTextField;
    private javax.swing.JButton btnEditModal;
    private javax.swing.JCheckBox jCheckBoxFemale;
    private javax.swing.JCheckBox jCheckBoxMale;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
