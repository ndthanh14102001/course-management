/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Đức Anh
 */
public class GUI_ManageOnsiteCourse extends javax.swing.JFrame {

    /**
     * Creates new form ManageDepartment
     */
    public GUI_ManageOnsiteCourse() {
        initComponents();
                
//        try {
//            listOnsiteCourse();
//        } catch (SQLException ex) {
//            Logger.getLogger(GUI_ManageOnsiteCourse.class.getName()).log(Level.SEVERE, null, ex);
//        }

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(
                        GUI_ManageOnsiteCourse.this,
                        "Bạn có chắc muốn đóng ứng dụng không?",
                        "Xác nhận đóng",
                        JOptionPane.YES_NO_OPTION
                );

                if (option == JOptionPane.YES_OPTION) {
                    // Thực hiện các thao tác cần thiết trước khi đóng ứng dụng
                    // Ví dụ: Lưu dữ liệu, đóng kết nối, v.v.

                    // Đóng JFrame
                    dispose();
                    String[] args = null;
                    GUI_ChooseOption.main(args);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTitle = new javax.swing.JPanel();
        LabelTitle = new javax.swing.JLabel();
        PanelFunction = new javax.swing.JPanel();
        LabelCourseId = new javax.swing.JLabel();
        TextFieldCourseId = new javax.swing.JTextField();
        TextFieldLocation = new javax.swing.JTextField();
        LabelLocation = new javax.swing.JLabel();
        LabelDepartmentId = new javax.swing.JLabel();
        TextFieldDays = new javax.swing.JTextField();
        TextFieldDepartmentId = new javax.swing.JTextField();
        LabelDays = new javax.swing.JLabel();
        ButtonEdit = new javax.swing.JButton();
        ButtonAdd = new javax.swing.JButton();
        ButtonDelete = new javax.swing.JButton();
        ButtonSearch = new javax.swing.JButton();
        ButtonQuit = new javax.swing.JButton();
        ButtonRefresh = new javax.swing.JButton();
        LabelSearch = new javax.swing.JLabel();
        TextFieldSearch = new javax.swing.JTextField();
        PanelTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DataTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Department");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        PanelTitle.setBackground(new java.awt.Color(200, 200, 200));
        PanelTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        LabelTitle.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitle.setText("MANAGE ONSITE COURSE");
        LabelTitle.setToolTipText("");

        javax.swing.GroupLayout PanelTitleLayout = new javax.swing.GroupLayout(PanelTitle);
        PanelTitle.setLayout(PanelTitleLayout);
        PanelTitleLayout.setHorizontalGroup(
            PanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelTitle)
                .addGap(408, 408, 408))
        );
        PanelTitleLayout.setVerticalGroup(
            PanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanelFunction.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        LabelCourseId.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LabelCourseId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelCourseId.setText("Course ID: ");

        TextFieldCourseId.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        TextFieldCourseId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldCourseId.setToolTipText("");
        TextFieldCourseId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldCourseIdActionPerformed(evt);
            }
        });

        TextFieldLocation.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        TextFieldLocation.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldLocation.setToolTipText("");
        TextFieldLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldLocationActionPerformed(evt);
            }
        });

        LabelLocation.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LabelLocation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLocation.setText("Location:");

        LabelDepartmentId.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LabelDepartmentId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelDepartmentId.setText("Department ID:");
        LabelDepartmentId.setToolTipText("");

        TextFieldDays.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        TextFieldDays.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldDays.setToolTipText("");
        TextFieldDays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldDaysActionPerformed(evt);
            }
        });

        TextFieldDepartmentId.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        TextFieldDepartmentId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldDepartmentId.setToolTipText("");
        TextFieldDepartmentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldDepartmentIdActionPerformed(evt);
            }
        });

        LabelDays.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LabelDays.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelDays.setText("Days: ");

        ButtonEdit.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ButtonEdit.setText("Edit");

        ButtonAdd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ButtonAdd.setText("Add");
        ButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddActionPerformed(evt);
            }
        });

        ButtonDelete.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ButtonDelete.setText("Delete");
        ButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteActionPerformed(evt);
            }
        });

        ButtonSearch.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ButtonSearch.setText("Search");

        ButtonQuit.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ButtonQuit.setText("Quit");
        ButtonQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonQuitActionPerformed(evt);
            }
        });

        ButtonRefresh.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ButtonRefresh.setText("Refresh");

        LabelSearch.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LabelSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelSearch.setText("Search:");
        LabelSearch.setToolTipText("");

        TextFieldSearch.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        TextFieldSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldSearch.setToolTipText("");
        TextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelFunctionLayout = new javax.swing.GroupLayout(PanelFunction);
        PanelFunction.setLayout(PanelFunctionLayout);
        PanelFunctionLayout.setHorizontalGroup(
            PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFunctionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelLocation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(LabelCourseId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(TextFieldLocation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(TextFieldCourseId, javax.swing.GroupLayout.Alignment.LEADING))
                .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFunctionLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(LabelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelFunctionLayout.createSequentialGroup()
                        .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFunctionLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(LabelDays, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFunctionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LabelDepartmentId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextFieldDays)
                            .addComponent(TextFieldDepartmentId, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(48, 48, 48)
                .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFunctionLayout.createSequentialGroup()
                        .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33))
                    .addGroup(PanelFunctionLayout.createSequentialGroup()
                        .addComponent(ButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        PanelFunctionLayout.setVerticalGroup(
            PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFunctionLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFunctionLayout.createSequentialGroup()
                        .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LabelCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TextFieldCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LabelLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TextFieldLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ButtonRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ButtonDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25)
                        .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LabelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelFunctionLayout.createSequentialGroup()
                        .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDays, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextFieldDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDepartmentId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextFieldDepartmentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        DataTable.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        DataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Course ID", "Location", "Days", "Time"
            }
        ));
        DataTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DataTable.setRowHeight(40);
        jScrollPane1.setViewportView(DataTable);

        javax.swing.GroupLayout PanelTableLayout = new javax.swing.GroupLayout(PanelTable);
        PanelTable.setLayout(PanelTableLayout);
        PanelTableLayout.setHorizontalGroup(
            PanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        PanelTableLayout.setVerticalGroup(
            PanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelFunction, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelFunction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldLocationActionPerformed

    private void TextFieldDepartmentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldDepartmentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldDepartmentIdActionPerformed

    private void TextFieldDaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldDaysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldDaysActionPerformed

    private void ButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonDeleteActionPerformed

    private void TextFieldCourseIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldCourseIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldCourseIdActionPerformed

    private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonAddActionPerformed

    private void TextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldSearchActionPerformed

    private void ButtonQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQuitActionPerformed
        String[] args = null;
        dispose();
        GUI_ChooseOption.main(args);
    }//GEN-LAST:event_ButtonQuitActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_ManageOnsiteCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_ManageOnsiteCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_ManageOnsiteCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_ManageOnsiteCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_ManageOnsiteCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton ButtonAdd;
    public javax.swing.JButton ButtonDelete;
    public javax.swing.JButton ButtonEdit;
    public javax.swing.JButton ButtonQuit;
    public javax.swing.JButton ButtonRefresh;
    public javax.swing.JButton ButtonSearch;
    public javax.swing.JTable DataTable;
    public javax.swing.JLabel LabelCourseId;
    public javax.swing.JLabel LabelDays;
    public javax.swing.JLabel LabelDepartmentId;
    public javax.swing.JLabel LabelLocation;
    public javax.swing.JLabel LabelSearch;
    public javax.swing.JLabel LabelTitle;
    public javax.swing.JPanel PanelFunction;
    public javax.swing.JPanel PanelTable;
    public javax.swing.JPanel PanelTitle;
    public javax.swing.JTextField TextFieldCourseId;
    public javax.swing.JTextField TextFieldDays;
    public javax.swing.JTextField TextFieldDepartmentId;
    public javax.swing.JTextField TextFieldLocation;
    public javax.swing.JTextField TextFieldSearch;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
