/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.BUS_CourseInstructor;
import BUS.BUS_OnlineCourse;
import BUS.BUS_Person;
import DTO.DTO_Course;
import DTO.DTO_OnlineCourse;
import DTO.DTO_Person;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class GUI_CourseInstructor extends javax.swing.JFrame {

    private List<DTO_Course> courses;
    private List<DTO_Person> currentInstructors;
    private List<DTO_Person> ortherInstructors;

    /**
     * Creates new form CourseInstructor
     */
    public GUI_CourseInstructor() {
        initComponents();
        showCoursesInCombobox();
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(
                        GUI_CourseInstructor.this,
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

    private void showCoursesInCombobox() {
        try {
            this.courses = new BUS.BUS_Course().getAll();
            for (DTO_Course course : this.courses) {
                cbSelectCourse.addItem(course.getTITLE());
            }
        } catch (Exception e) {
        }
    }

    private int getSelectedCourseId() {
        return this.courses.get(cbSelectCourse.getSelectedIndex()).getCOURSEID();
    }

    private DTO_Person getSelectedOrtherInstructor() {
        return this.ortherInstructors.get(ortherInstructorTable.getSelectedRow());
    }

    private DTO_Person getSelectedCurrentInstructor() {
        return this.currentInstructors.get(currentInstructorTable.getSelectedRow());
    }

    private void showCurrentIntructorTable() {
        int selectedCourseId = getSelectedCourseId();
        currentInstructorTable.removeAll();
        String[] columnNames = {"Person ID", "Last name", "First name"};
        this.currentInstructors = new BUS_CourseInstructor().GetInstructorByCourseId(selectedCourseId);
        Object[][] data = new Object[this.currentInstructors.size()][columnNames.length];
        for (int i = 0; i < this.currentInstructors.size(); i++) {
            DTO_Person person = (DTO_Person) this.currentInstructors.get(i);
            data[i][0] = person.getId();
            data[i][1] = person.getLast_name();
            data[i][2] = person.getFirst_name();
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        currentInstructorTable.setModel(model);
    }

    private void showOrtherIntructorTable() {
        int selectedCourseId = getSelectedCourseId();
        ortherInstructorTable.removeAll();
        String[] columnNames = {"Person ID", "Last name", "First name"};
        this.ortherInstructors = new BUS_CourseInstructor().GetUnassignedInstructorsByCourseId(selectedCourseId);
        Object[][] data = new Object[this.ortherInstructors.size()][columnNames.length];
        for (int i = 0; i < this.ortherInstructors.size(); i++) {
            DTO_Person person = (DTO_Person) this.ortherInstructors.get(i);
            data[i][0] = person.getId();
            data[i][1] = person.getLast_name();
            data[i][2] = person.getFirst_name();
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        ortherInstructorTable.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ortherInstructorTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbSelectCourse = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        currentInstructorTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnRemoveAssignment = new javax.swing.JButton();
        btnAssign = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ortherInstructorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Person ID", "Last Name", "First Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ortherInstructorTable);

        jLabel2.setText("Course");

        cbSelectCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSelectCourseActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("COURSE INSTRUCTOR");

        currentInstructorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Person ID", "Last Name", "First Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(currentInstructorTable);

        jLabel1.setText("Current Instructors");

        jLabel3.setText("Orther Instructors ");

        btnRemoveAssignment.setText(">>>");
        btnRemoveAssignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveAssignmentActionPerformed(evt);
            }
        });

        btnAssign.setText("<<<");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbSelectCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRemoveAssignment, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAssign, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAssign, btnRemoveAssignment});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(btnRemoveAssignment)
                                .addGap(39, 39, 39)
                                .addComponent(btnAssign))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbSelectCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAssign, btnRemoveAssignment});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbSelectCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSelectCourseActionPerformed
        // TODO add your handling code here:
        showCurrentIntructorTable();
        showOrtherIntructorTable();
    }//GEN-LAST:event_cbSelectCourseActionPerformed

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        // TODO add your handling code here:
        if (ortherInstructorTable.getSelectedRow() > -1) {
            DTO_Person selectedOrtherInstructor = getSelectedOrtherInstructor();
            int selectedCourseId = getSelectedCourseId();
            try {
                new BUS_CourseInstructor().add(selectedOrtherInstructor.getId(), selectedCourseId);
                showCurrentIntructorTable();
                showOrtherIntructorTable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnRemoveAssignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAssignmentActionPerformed
        // TODO add your handling code here:
        if (currentInstructorTable.getSelectedRow() > -1) {
            DTO_Person selectedCurrentInstructor = getSelectedCurrentInstructor();
            int selectedCourseId = getSelectedCourseId();
            try {
                new BUS_CourseInstructor().delete(selectedCurrentInstructor.getId(), selectedCourseId);
                showCurrentIntructorTable();
                showOrtherIntructorTable();
            } catch (Exception e) {
                 e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnRemoveAssignmentActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_CourseInstructor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_CourseInstructor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_CourseInstructor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_CourseInstructor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_CourseInstructor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnRemoveAssignment;
    private javax.swing.JComboBox<String> cbSelectCourse;
    private javax.swing.JTable currentInstructorTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable ortherInstructorTable;
    // End of variables declaration//GEN-END:variables
}
