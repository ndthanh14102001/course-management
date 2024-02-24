/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.BUS_StudentGrade;
import DAO.DAO_Course;
import DAO.DAO_StudentGrade;
import DTO.DTO_StudentGrade;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Đức Anh
 */
public class GUI_ManageStudentGrade extends javax.swing.JFrame {

    private static int pos = 0;
    public DAO_StudentGrade daoStudentGrade = new DAO_StudentGrade();
    public DTO_StudentGrade dtoStudentGrade = new DTO_StudentGrade();
    public BUS_StudentGrade busStudentGrade = new BUS_StudentGrade();

    /**
     * Creates new form ManageDepartment
     */
    public GUI_ManageStudentGrade() {
        initComponents();

        try {
            listStudentGrade();
        } catch (SQLException ex) {
            Logger.getLogger(GUI_ManageStudentGrade.class.getName()).log(Level.SEVERE, null, ex);
        }

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(
                        GUI_ManageStudentGrade.this,
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

    private DefaultTableModel convertStudentGrade(List list) {
        String[] columnNames = {"Enrollment ID", "Course ID", "Student ID", "Grade"};
        Object[][] data = new Object[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            DTO_StudentGrade dtoStudentGrade = (DTO_StudentGrade) list.get(i);
            data[i][0] = dtoStudentGrade.getENROLLMENTID();
            data[i][1] = dtoStudentGrade.getCOURSEID();
            data[i][2] = dtoStudentGrade.getSTUDENTID();
            data[i][3] = dtoStudentGrade.getGRADE();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        return model;
    }

    private void listStudentGrade() throws SQLException {
//        DAO_StudentGrade daoStudentGrade = new DAO_StudentGrade();
//        List list = daoStudentGrade.ReadStudentGrade();
//        
//        DefaultTableModel model = convertStudentGrade(list);
//        DataTable.setModel(model);
        BUS_StudentGrade busStudentGrade = new BUS_StudentGrade();
        List list = busStudentGrade.LoadStudentGrade(1);
        DefaultTableModel model = convertStudentGrade(list);
        DefaultComboBoxModel modelcomboBox_course = (DefaultComboBoxModel) jComboBox1_courseid_stdgrate.getModel();
        DefaultComboBoxModel modelcomboBox_person = (DefaultComboBoxModel) jComboBox2_studentid_stdgrade.getModel();
        modelcomboBox_course.removeAllElements();
        modelcomboBox_person.removeAllElements();
        DAO_StudentGrade dAO_studentGrade = new DAO_StudentGrade();
        ArrayList listcourseID_course = dAO_studentGrade.ReadCOURSEID_course();
        ArrayList listpersonID_person = dAO_studentGrade.ReadPERSONID_person();
        for (Object courseID : listcourseID_course) {
            modelcomboBox_course.addElement(courseID);
        }
        for (Object personID : listpersonID_person) {
            modelcomboBox_person.addElement(personID);
        }
        DataTable.setModel(model);
        status_stdgrade.setText("Num Of StudentGrade: " + list.size());
    }

    public void View() throws SQLException {
        DAO_StudentGrade studentgrade = new DAO_StudentGrade();
        ArrayList list = studentgrade.ReadDepartment();
        DTO_StudentGrade dtoStudentGrade = (DTO_StudentGrade) list.get(pos);
        this.TextFieldEnrollmentId.setText(Integer.toString(dtoStudentGrade.getENROLLMENTID()));
        this.jComboBox1_courseid_stdgrate.setSelectedItem(dtoStudentGrade.getCOURSEID());
        this.jComboBox2_studentid_stdgrade.setSelectedItem(dtoStudentGrade.getSTUDENTID());
        this.TextFieldGrade.setText(Integer.toString(dtoStudentGrade.getGRADE()));
    }

    public void NullView() throws SQLException {
        this.TextFieldEnrollmentId.setText("");
        this.jComboBox1_courseid_stdgrate.setSelectedItem("");
        this.jComboBox2_studentid_stdgrade.setSelectedItem("");
        this.TextFieldGrade.setText("");
        this.TextFieldSearch.setText("");
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
        LabelEnrollmentId = new javax.swing.JLabel();
        TextFieldEnrollmentId = new javax.swing.JTextField();
        LabelCourseId = new javax.swing.JLabel();
        LabelGrade = new javax.swing.JLabel();
        TextFieldGrade = new javax.swing.JTextField();
        LabelStudentId = new javax.swing.JLabel();
        ButtonEdit = new javax.swing.JButton();
        ButtonAdd = new javax.swing.JButton();
        ButtonDelete = new javax.swing.JButton();
        ButtonSearch = new javax.swing.JButton();
        ButtonQuit = new javax.swing.JButton();
        ButtonRefresh = new javax.swing.JButton();
        LabelSearch = new javax.swing.JLabel();
        TextFieldSearch = new javax.swing.JTextField();
        jComboBox1_courseid_stdgrate = new javax.swing.JComboBox<>();
        jComboBox2_studentid_stdgrade = new javax.swing.JComboBox<>();
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        LabelEnrollmentId.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LabelEnrollmentId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelEnrollmentId.setText("Enrollment ID: ");

        TextFieldEnrollmentId.setEditable(false);
        TextFieldEnrollmentId.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        TextFieldEnrollmentId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldEnrollmentId.setToolTipText("");
        TextFieldEnrollmentId.setAutoscrolls(false);
        TextFieldEnrollmentId.setEnabled(false);
        TextFieldEnrollmentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldEnrollmentIdActionPerformed(evt);
            }
        });

        LabelCourseId.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LabelCourseId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelCourseId.setText("Course ID:");

        LabelGrade.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LabelGrade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelGrade.setText("Grade:");
        LabelGrade.setToolTipText("");

        TextFieldGrade.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        TextFieldGrade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldGrade.setToolTipText("");
        TextFieldGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldGradeActionPerformed(evt);
            }
        });

        LabelStudentId.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LabelStudentId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelStudentId.setText("Student ID:");

        ButtonEdit.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ButtonEdit.setText("Edit");
        ButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditActionPerformed(evt);
            }
        });

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
        ButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSearchActionPerformed(evt);
            }
        });

        ButtonQuit.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ButtonQuit.setText("Quit");
        ButtonQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonQuitActionPerformed(evt);
            }
        });

        ButtonRefresh.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ButtonRefresh.setText("Refresh");
        ButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRefreshActionPerformed(evt);
            }
        });

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

        jComboBox1_courseid_stdgrate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2_studentid_stdgrade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout PanelFunctionLayout = new javax.swing.GroupLayout(PanelFunction);
        PanelFunction.setLayout(PanelFunctionLayout);
        PanelFunctionLayout.setHorizontalGroup(
            PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFunctionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LabelCourseId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelEnrollmentId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextFieldEnrollmentId, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jComboBox1_courseid_stdgrate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addComponent(LabelStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFunctionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LabelGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextFieldGrade, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(jComboBox2_studentid_stdgrade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                                .addComponent(LabelEnrollmentId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TextFieldEnrollmentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LabelCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox1_courseid_stdgrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ButtonRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
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
                            .addComponent(LabelStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2_studentid_stdgrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextFieldGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                "Course ID", "Title", "Credits", "Department ID"
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
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
                    .addComponent(PanelTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelFunction, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status_stdgrade, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldGradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldGradeActionPerformed

    private void ButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteActionPerformed
        // TODO add your handling code here:
        String enrollmentId = TextFieldEnrollmentId.getText();
        try {
            if (busStudentGrade.DeleteStudentGrade(enrollmentId) > 0) {
                JOptionPane.showMessageDialog(this, "Complete delete studentgrade", "Message", JOptionPane.INFORMATION_MESSAGE);
                listStudentGrade();
            } else {
                JOptionPane.showMessageDialog(this, "Error delete studentgrade", "Message", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI_ManageStudentGrade.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ButtonDeleteActionPerformed

    private void TextFieldEnrollmentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldEnrollmentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldEnrollmentIdActionPerformed

    private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddActionPerformed
        // TODO add your handling code here:

        try {

            //dtoStudentGrade.setENROLLMENTID(TextFieldEnrollmentId.getText()); 
            dtoStudentGrade.setCOURSEID((int) jComboBox1_courseid_stdgrate.getSelectedItem());
            dtoStudentGrade.setSTUDENTID((int) jComboBox2_studentid_stdgrade.getSelectedItem());

            dtoStudentGrade.setGRADE(Integer.getInteger(TextFieldGrade.getText()));

            if (busStudentGrade.AddStudentGrade(dtoStudentGrade) > 0) {
                //NullView();
                JOptionPane.showMessageDialog(this, "Complete add studentgrade", "Message", JOptionPane.INFORMATION_MESSAGE);
                listStudentGrade();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error add studentgrade", "Message", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GUI_ManageStudentGrade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonAddActionPerformed

    private void TextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldSearchActionPerformed

    private void ButtonQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQuitActionPerformed
        String[] args = null;
        dispose();
        GUI_ChooseOption.main(args);
    }//GEN-LAST:event_ButtonQuitActionPerformed

    private void ButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRefreshActionPerformed
        // TODO add your handling code here:
        pos = this.DataTable.getSelectedRow();
        try {
            NullView();
        } catch (SQLException ex) {
            Logger.getLogger(GUI_ManageStudentGrade.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // TODO add your handling code here:
            listStudentGrade();
        } catch (SQLException ex) {
            Logger.getLogger(GUI_ManageStudentGrade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonRefreshActionPerformed

    private void ButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSearchActionPerformed
        // TODO add your handling code here:
        try {

            String searchInput = TextFieldSearch.getText();
            if (searchInput.isBlank() == false) {
                List list = busStudentGrade.FindStudentGrade(searchInput);
                DefaultTableModel model = convertStudentGrade(list);
                DataTable.setModel(model);
                status_stdgrade.setText("Num of rows: " + list.size());
            } else {
                JOptionPane.showMessageDialog(this, "StudentGrade is empty", "Message", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GUI_ManageStudentGrade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonSearchActionPerformed

    private void ButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditActionPerformed
        // TODO add your handling code here:
        try {
            dtoStudentGrade.setENROLLMENTID(Integer.getInteger(TextFieldEnrollmentId.getText()));
            dtoStudentGrade.setCOURSEID((int) jComboBox1_courseid_stdgrate.getSelectedItem());
            dtoStudentGrade.setSTUDENTID((int) jComboBox2_studentid_stdgrade.getSelectedItem());

            dtoStudentGrade.setGRADE(Integer.getInteger(TextFieldGrade.getText()));
            if (busStudentGrade.EditStudentGrade(dtoStudentGrade) > 0) {
                //NullView();
                JOptionPane.showMessageDialog(this, "Complete edit studentgrade", "Message", JOptionPane.INFORMATION_MESSAGE);
                listStudentGrade();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error edit studentgrade", "Message", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GUI_ManageStudentGrade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonEditActionPerformed
    private void DataTableMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        pos = this.DataTable.getSelectedRow();
        try {
            View();
        } catch (SQLException ex) {
            Logger.getLogger(GUI_ManageDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void DataTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DataTableKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_DataTableKeyPressed

    private void DataTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DataTableKeyReleased
        // TODO add your handling code here:
        pos = this.DataTable.getSelectedRow();
        try {
            View();
        } catch (SQLException ex) {
            Logger.getLogger(GUI_ManageDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void TextFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldSearchKeyPressed

    }

    private void TextFieldSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextFieldSearchMouseExited
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

    private void TextFieldSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextFieldSearchMouseReleased
        // TODO add your handling code here:
    }

    private void TextFieldSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextFieldSearchMouseEntered
        // TODO add your handling code here:

    }

    private void TextFieldSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextFieldSearchMousePressed
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
    public javax.swing.JButton ButtonAdd;
    public javax.swing.JButton ButtonDelete;
    public javax.swing.JButton ButtonEdit;
    public javax.swing.JButton ButtonQuit;
    public javax.swing.JButton ButtonRefresh;
    public javax.swing.JButton ButtonSearch;
    public javax.swing.JTable DataTable;
    public javax.swing.JLabel LabelCourseId;
    public javax.swing.JLabel LabelEnrollmentId;
    public javax.swing.JLabel LabelGrade;
    public javax.swing.JLabel LabelSearch;
    public javax.swing.JLabel LabelStudentId;
    public javax.swing.JLabel LabelTitle;
    public javax.swing.JPanel PanelFunction;
    public javax.swing.JPanel PanelTable;
    public javax.swing.JPanel PanelTitle;
    public javax.swing.JTextField TextFieldEnrollmentId;
    public javax.swing.JTextField TextFieldGrade;
    public javax.swing.JTextField TextFieldSearch;
    private javax.swing.JComboBox<String> jComboBox1_courseid_stdgrate;
    private javax.swing.JComboBox<String> jComboBox2_studentid_stdgrade;
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
