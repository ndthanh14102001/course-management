/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.BUS_Course;
import BUS.BUS_StudentGrade;
import DAO.DAO_Course;
import DAO.DAO_StudentGrade;
import DTO.DTO_Course;
import DTO.DTO_StudentGrade;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Đức Anh
 */
public class GUI_ManageStudentGrade extends javax.swing.JFrame {

    private int GRADE_COLUMN_POSITION = 3;
    private static int pos = 0;
    public DAO_StudentGrade daoStudentGrade = new DAO_StudentGrade();
    public DTO_StudentGrade dtoStudentGrade = new DTO_StudentGrade();
    public BUS_StudentGrade busStudentGrade = new BUS_StudentGrade();
    private List<DTO_Course> courses;
    private List<DTO_StudentGrade> students;

    /**
     * Creates new form ManageDepartment
     */
    public GUI_ManageStudentGrade() {
        initComponents();

        try {
            showCoursesInCombobox();
            addEventEditGrade();
        } catch (SQLException ex) {
            Logger.getLogger(GUI_ManageStudentGrade.class.getName()).log(Level.SEVERE, null, ex);
        }

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(
                        GUI_ManageStudentGrade.this,
                        "Bạn có chắc muốn đóng cửa sổ này không?",
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

    void showStudentGrade() {
        try {
            BUS_StudentGrade busStudentGrade = new BUS_StudentGrade();
            this.students = busStudentGrade.getRegistedStudents(getSelectedCourseId());
            DefaultTableModel model = convertStudentGrade(this.students);
            DataTable.setModel(model);
            status_stdgrade.setText("Num Of Students: " + this.students.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getSelectedCourseId() {
        if (this.courses != null && !this.courses.isEmpty()) {
            return this.courses.get(jComboBox1_courseid_stdgrate.getSelectedIndex()).getCOURSEID();
        }
        return 0;
    }

    private DefaultTableModel convertStudentGrade(List list) {
        String[] columnNames = {"Student ID", "First name", "Last name", "Grade"};
        Object[][] data = new Object[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            DTO_StudentGrade dtoStudentGrade = (DTO_StudentGrade) list.get(i);
            data[i][0] = dtoStudentGrade.getId();
            data[i][1] = dtoStudentGrade.getFirst_name();
            data[i][2] = dtoStudentGrade.getLast_name();
            data[i][GRADE_COLUMN_POSITION] = dtoStudentGrade.getGRADE();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == GRADE_COLUMN_POSITION;
            }
        };
        return model;
    }

    private void showCoursesInCombobox() throws SQLException {
        DefaultComboBoxModel modelcomboBox_course = (DefaultComboBoxModel) jComboBox1_courseid_stdgrate.getModel();
        modelcomboBox_course.removeAllElements();
        courses = new BUS_Course().getAll();
        for (DTO_Course course : courses) {
            modelcomboBox_course.addElement(course.getTITLE());
        }

    }

    public void addEventEditGrade() {
        CellEditorListener ChangeNotification = new CellEditorListener() {
            @Override
            public void editingCanceled(ChangeEvent e) {
                System.out.println("The user canceled editing.");
            }

            @Override
            public void editingStopped(ChangeEvent e) {
                int selectedRow = DataTable.getSelectedRow();

                int enrollmentId = students.get(selectedRow).getENROLLMENTID();
                float grade = Float.parseFloat(DataTable.getValueAt(selectedRow, GRADE_COLUMN_POSITION).toString());
                try {
                    new BUS_StudentGrade().updateGrade(enrollmentId, grade);
                    DataTable.editCellAt(selectedRow + 1, GRADE_COLUMN_POSITION);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        DataTable.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);
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
        jComboBox1_courseid_stdgrate = new javax.swing.JComboBox<>();
        PanelTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DataTable = new javax.swing.JTable();
        status_stdgrade = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Department");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        PanelTitle.setBackground(new java.awt.Color(200, 200, 200));
        PanelTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        LabelTitle.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitle.setText("MANAGE STUDENT GRADE");
        LabelTitle.setToolTipText("");

        javax.swing.GroupLayout PanelTitleLayout = new javax.swing.GroupLayout(PanelTitle);
        PanelTitle.setLayout(PanelTitleLayout);
        PanelTitleLayout.setHorizontalGroup(
            PanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTitleLayout.createSequentialGroup()
                .addContainerGap(437, Short.MAX_VALUE)
                .addComponent(LabelTitle)
                .addGap(397, 397, 397))
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
        LabelCourseId.setText("Course");

        jComboBox1_courseid_stdgrate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1_courseid_stdgrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1_courseid_stdgrateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelFunctionLayout = new javax.swing.GroupLayout(PanelFunction);
        PanelFunction.setLayout(PanelFunctionLayout);
        PanelFunctionLayout.setHorizontalGroup(
            PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFunctionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1_courseid_stdgrate, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelFunctionLayout.setVerticalGroup(
            PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFunctionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1_courseid_stdgrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        DataTable.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        DataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTableLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
        );

        status_stdgrade.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        status_stdgrade.setText("jLabel1");
        status_stdgrade.setMaximumSize(new java.awt.Dimension(50, 21));
        status_stdgrade.setMinimumSize(new java.awt.Dimension(50, 21));
        status_stdgrade.setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(PanelFunction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(status_stdgrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelFunction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelTable, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(status_stdgrade, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void DataTableMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        pos = this.DataTable.getSelectedRow();

    }

    private void DataTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DataTableKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_DataTableKeyPressed

    private void jComboBox1_courseid_stdgrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1_courseid_stdgrateActionPerformed
        // TODO add your handling code here:
        showStudentGrade();
    }//GEN-LAST:event_jComboBox1_courseid_stdgrateActionPerformed

    private void DataTableKeyReleased(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:

    }

    private void TextFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {

    }

    private void TextFieldSearchMouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
//        try {
//            
//            String searchInput = TextFieldSearch.getText();
//            if (searchInput.isBlank() == false) {
//                List list = busDepartment.FindDepartment(searchInput);
//                DefaultTableModel model = convertDepartment(list);
//                DataTable.setModel(model);
//                LabelStatus.setText("Num of rows: " + list.size());
//            } else {
//                JOptionPane.showMessageDialog(this, "Department is empty", "Message", JOptionPane.ERROR_MESSAGE);
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(GUI_ManageDepartment.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private void TextFieldSearchMouseReleased(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void TextFieldSearchMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:

    }

    private void TextFieldSearchMousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
//        try {
//            
//            String searchInput = TextFieldSearch.getText();
//            if (searchInput.isBlank() == false) {
//                List list = busDepartment.FindDepartment(searchInput);
//                DefaultTableModel model = convertDepartment(list);
//                DataTable.setModel(model);
//                LabelStatus.setText("Num of rows: " + list.size());
//            } else {
//                JOptionPane.showMessageDialog(this, "Department is empty", "Message", JOptionPane.ERROR_MESSAGE);
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(GUI_ManageDepartment.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

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
            java.util.logging.Logger.getLogger(GUI_ManageDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_ManageDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_ManageDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_ManageDepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_ManageStudentGrade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable DataTable;
    public javax.swing.JLabel LabelCourseId;
    public javax.swing.JLabel LabelTitle;
    public javax.swing.JPanel PanelFunction;
    public javax.swing.JPanel PanelTable;
    public javax.swing.JPanel PanelTitle;
    private javax.swing.JComboBox<String> jComboBox1_courseid_stdgrate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel status_stdgrade;
    // End of variables declaration//GEN-END:variables
//
//    private static class LabelStatus {
//
//        private static void setText(String string) {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        }
//    }
}
