/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.BUS_Department;
import BUS.BUS_OnlineCourse;
import DTO.DTO_Course;
import DTO.DTO_Department;
import DTO.DTO_OnlineCourse;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class GUI_OnlineCourse extends javax.swing.JFrame {

    private int URL_COLUMN_POSITION = 3;
    private int COURSE_ID_COLUMN_POSITION = 0;

    private List<DTO_Department> departments;
    private List<DTO_Course> courses;
    private List<DTO_OnlineCourse> onlineCourses;

    /**
     * Creates new form OnlineCourse
     */
    public GUI_OnlineCourse() {
        initComponents();
        showCoursesInCombobox();
        showOnlineCoures();
        addEventEditURL();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(
                        GUI_OnlineCourse.this,
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

    public void showCoursesInCombobox() {
        try {
            this.courses = new BUS_OnlineCourse().getCoursesWithoutType();
            for (DTO_Course course : this.courses) {
                cbSelectCourse.addItem(course.getTITLE());
            }
        } catch (Exception e) {
        }
    }

    public void showOnlineCoures() {
        String[] columnNames = {"Course ID", "Title", "Credits", "URL"};
        this.onlineCourses = new BUS_OnlineCourse().getAll();
        Object[][] data = new Object[this.onlineCourses.size()][columnNames.length];
        for (int i = 0; i < this.onlineCourses.size(); i++) {
            DTO_OnlineCourse course = (DTO_OnlineCourse) this.onlineCourses.get(i);
            data[i][COURSE_ID_COLUMN_POSITION] = course.getCOURSEID();
            data[i][1] = course.getTITLE();
            data[i][2] = course.getCREDITS();
            data[i][URL_COLUMN_POSITION] = course.getURL();
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == URL_COLUMN_POSITION;
            }
        };
        courseTable.setModel(model);
    }

    public void addEventEditURL() {
        CellEditorListener ChangeNotification = new CellEditorListener() {
            @Override
            public void editingCanceled(ChangeEvent e) {
                System.out.println("The user canceled editing.");
            }

            @Override
            public void editingStopped(ChangeEvent e) {
                int selectedRow = courseTable.getSelectedRow();
                String changedURL = courseTable.getValueAt(selectedRow, URL_COLUMN_POSITION).toString();
                int courseId = Integer.parseInt(courseTable.getValueAt(selectedRow, COURSE_ID_COLUMN_POSITION).toString());

                DTO_OnlineCourse onlineCourse = new DTO_OnlineCourse();
                onlineCourse.setCOURSEID(courseId);
                onlineCourse.setURL(changedURL);
                try {
                    new BUS_OnlineCourse().update(onlineCourse);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        courseTable.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);
    }

    public void searchCourses(String title) {
        String[] columnNames = {"Course ID", "Title", "Credits", "URL"};
        this.onlineCourses = new BUS_OnlineCourse().getByTitle(title);
        Object[][] data = new Object[this.onlineCourses.size()][columnNames.length];
        for (int i = 0; i < this.onlineCourses.size(); i++) {
            DTO_OnlineCourse course = (DTO_OnlineCourse) this.onlineCourses.get(i);
            data[i][COURSE_ID_COLUMN_POSITION] = course.getCOURSEID();
            data[i][1] = course.getTITLE();
            data[i][2] = course.getCREDITS();
            data[i][URL_COLUMN_POSITION] = course.getURL();
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == URL_COLUMN_POSITION;
            }
        };
        courseTable.setModel(model);
    }

    public void resetCBSelectCourse() {
        cbSelectCourse.removeAllItems();
        showCoursesInCombobox();
    }

    public void resetCourseTable() {
        courseTable.removeAll();
        showOnlineCoures();
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
        courseTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtURL = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btmDelete = new javax.swing.JButton();
        btnSearchTitle = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbSelectCourse = new javax.swing.JComboBox<>();
        txtSearchTitle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Course Id", "Title", "Credits", "Department", "URL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(courseTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ONLINE COURSE");

        txtURL.setPreferredSize(new java.awt.Dimension(100, 22));

        jLabel4.setText("URL");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btmDelete.setText("Delete");
        btmDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmDeleteActionPerformed(evt);
            }
        });

        btnSearchTitle.setText("Search");
        btnSearchTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchTitleActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel6.setText("Course");

        jLabel2.setText("Title");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(cbSelectCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(txtSearchTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearchTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRefresh)))
                        .addGap(18, 18, 18)
                        .addComponent(btmDelete)
                        .addGap(98, 98, 98)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btmDelete, btnRefresh, jButton1});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbSelectCourse, txtSearchTitle});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(btmDelete))
                    .addComponent(jLabel4)
                    .addComponent(txtURL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(cbSelectCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchTitle)
                    .addComponent(jLabel2)
                    .addComponent(btnRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btmDelete, btnRefresh, btnSearchTitle, cbSelectCourse, jButton1, jLabel4, jLabel6, txtURL});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String url = txtURL.getText();

        int courseId = courses.get(cbSelectCourse.getSelectedIndex()).getCOURSEID();
        DTO_OnlineCourse onlineCourse = new DTO_OnlineCourse(courseId, "", "", 0, url);
        try {
            new BUS_OnlineCourse().add(onlineCourse);
            resetCourseTable();
            resetCBSelectCourse();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        resetCourseTable();
        resetCBSelectCourse();
        txtURL.setText("");
        txtSearchTitle.setText("");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btmDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = courseTable.getSelectedRow();
        int onlineCourseId = this.onlineCourses.get(selectedRow).getCOURSEID();
        try {
            new BUS_OnlineCourse().delete(onlineCourseId);
            DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
            model.removeRow(selectedRow);
            resetCBSelectCourse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btmDeleteActionPerformed

    private void btnSearchTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchTitleActionPerformed
        // TODO add your handling code here:
        searchCourses(txtSearchTitle.getText());
    }//GEN-LAST:event_btnSearchTitleActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_OnlineCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_OnlineCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_OnlineCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_OnlineCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_OnlineCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearchTitle;
    private javax.swing.JComboBox<String> cbSelectCourse;
    private javax.swing.JTable courseTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtSearchTitle;
    private javax.swing.JTextField txtURL;
    // End of variables declaration//GEN-END:variables
}
