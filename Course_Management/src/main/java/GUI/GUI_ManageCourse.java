/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.BUS_Course;
import DAO.DAO_Course;
import DTO.DTO_Course;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Đức Anh
 */
public class GUI_ManageCourse extends javax.swing.JFrame {

    private static int pos = 0;
    public BUS_Course bus__course = new BUS_Course();
    public DTO_Course dto__course = new DTO_Course();

    /**
     * Creates new form ManageDepartment
     */
    public GUI_ManageCourse() {
        initComponents();

        try {
            listCourse();
        } catch (SQLException ex) {
            Logger.getLogger(GUI_ManageCourse.class.getName()).log(Level.SEVERE, null, ex);
        }

        jComboBox_course.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox_course = (JComboBox) e.getSource();
                int selectedIndex = comboBox_course.getSelectedIndex();

                if (selectedIndex == 0) {
                    int itemCount = comboBox_course.getItemCount();
                    int nextIndex = (selectedIndex + 1) % itemCount;
                    comboBox_course.setSelectedIndex(nextIndex);
                }
            }
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(
                        GUI_ManageCourse.this,
                        "Bạn có chắc muốn đóng ứng dụng không?",
                        "Xác nhận đóng",
                        JOptionPane.YES_NO_OPTION
                );

                if (option == JOptionPane.YES_OPTION) {
                    // Thực hiện các thao tác cần thiết trước khi đóng ứng dụng
                    // Ví dụ: Lưu dữ liệu, đóng kết nối, v.v.

                    // Đóng JFrame
                    dispose();
//                    String[] args = null;
//                    GUI_ChooseOption.main(args);
                    System.exit(0);
                }
            }
        });
    }

    private DefaultTableModel convertCourse(List list_course) {
        String[] columnNames_course = {"Course ID", "Title", "Credits", "Department ID"};
        Object[][] data_course = new Object[list_course.size()][4];
        for (int i = 0; i < list_course.size(); i++) {
            DTO_Course dto__course = (DTO_Course) list_course.get(i);
            data_course[i][0] = dto__course.getCOURSEID();
            data_course[i][1] = dto__course.getTITLE();
            data_course[i][2] = dto__course.getCREDITS();
            data_course[i][3] = dto__course.getDEPARTMENTID();
        }
        DefaultTableModel model_course = new DefaultTableModel(data_course, columnNames_course);
        return model_course;
    }

    public void listCourse() throws SQLException {
        BUS_Course bus__course = new BUS_Course();
        List list_course = bus__course.LoadCourse(1);
        DefaultTableModel model_course = convertCourse(list_course);
        DefaultComboBoxModel modelcomboBox_course = (DefaultComboBoxModel) jComboBox_course.getModel();
        modelcomboBox_course.removeAllElements();
        modelcomboBox_course.addElement("");
        DAO_Course dao__course = new DAO_Course();
        ArrayList listdepartmentID_course = dao__course.ReadDEPARTMENTID_course();
        for (Object departmentID : listdepartmentID_course) {
            modelcomboBox_course.addElement(departmentID);
        }

        DataTable_Course.setModel(model_course);
        LabelStatus_course.setText("Num Of Course: " + list_course.size());
    }

    public void View_course() throws SQLException {
        DAO_Course dao__course = new DAO_Course();
        ArrayList list_course = dao__course.ReadCourse();
        DTO_Course dto__course = (DTO_Course) list_course.get(pos);
        this.TextFieldCourseId_course.setText(dto__course.getCOURSEID() + "");
        this.TextFieldTitle_course.setText(dto__course.getTITLE());
        this.TextFieldCredits_course.setText(dto__course.getCREDITS());
        this.jComboBox_course.setSelectedItem(dto__course.getDEPARTMENTID());

    }

    public void NullView_course() throws SQLException {
        this.TextFieldCourseId_course.setText("");
        this.TextFieldTitle_course.setText("");
        this.TextFieldCredits_course.setText("");
        this.jComboBox_course.setSelectedIndex(-1);
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
        TextFieldCourseId_course = new javax.swing.JTextField();
        TextFieldTitle_course = new javax.swing.JTextField();
        LabelTitles = new javax.swing.JLabel();
        LabelDepartmentId = new javax.swing.JLabel();
        TextFieldCredits_course = new javax.swing.JTextField();
        LabelCredits = new javax.swing.JLabel();
        ButtonEdit = new javax.swing.JButton();
        ButtonAdd = new javax.swing.JButton();
        ButtonDelete = new javax.swing.JButton();
        ButtonQuit = new javax.swing.JButton();
        ButtonRefresh = new javax.swing.JButton();
        LabelSearch = new javax.swing.JLabel();
        TextFieldSearch_course = new javax.swing.JTextField();
        jComboBox_course = new javax.swing.JComboBox<>();
        PanelTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DataTable_Course = new javax.swing.JTable();
        LabelStatus_course = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Department");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        PanelTitle.setBackground(new java.awt.Color(200, 200, 200));
        PanelTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        LabelTitle.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitle.setText("MANAGE COURSE");
        LabelTitle.setToolTipText("");

        javax.swing.GroupLayout PanelTitleLayout = new javax.swing.GroupLayout(PanelTitle);
        PanelTitle.setLayout(PanelTitleLayout);
        PanelTitleLayout.setHorizontalGroup(
            PanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelTitle)
                .addGap(458, 458, 458))
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

        TextFieldCourseId_course.setEditable(false);
        TextFieldCourseId_course.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        TextFieldCourseId_course.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldCourseId_course.setToolTipText("");
        TextFieldCourseId_course.setEnabled(false);
        TextFieldCourseId_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldCourseId_courseActionPerformed(evt);
            }
        });

        TextFieldTitle_course.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        TextFieldTitle_course.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldTitle_course.setToolTipText("");
        TextFieldTitle_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldTitle_courseActionPerformed(evt);
            }
        });

        LabelTitles.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LabelTitles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitles.setText("Title:");

        LabelDepartmentId.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LabelDepartmentId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelDepartmentId.setText("Department ID:");
        LabelDepartmentId.setToolTipText("");

        TextFieldCredits_course.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        TextFieldCredits_course.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextFieldCredits_course.setToolTipText("");
        TextFieldCredits_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldCredits_courseActionPerformed(evt);
            }
        });

        LabelCredits.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        LabelCredits.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelCredits.setText("Credits:");

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

        TextFieldSearch_course.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        TextFieldSearch_course.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TextFieldSearch_course.setToolTipText("");
        TextFieldSearch_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldSearch_courseActionPerformed(evt);
            }
        });
        TextFieldSearch_course.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldSearch_courseKeyReleased(evt);
            }
        });

        jComboBox_course.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBox_course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout PanelFunctionLayout = new javax.swing.GroupLayout(PanelFunction);
        PanelFunction.setLayout(PanelFunctionLayout);
        PanelFunctionLayout.setHorizontalGroup(
            PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFunctionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(LabelTitles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addComponent(LabelCourseId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(LabelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelFunctionLayout.createSequentialGroup()
                        .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextFieldTitle_course, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(TextFieldCourseId_course))
                        .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFunctionLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(LabelCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFunctionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LabelDepartmentId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextFieldCredits_course, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(jComboBox_course, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(TextFieldSearch_course))
                .addGap(48, 48, 48)
                .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ButtonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
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
                                .addComponent(TextFieldCourseId_course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LabelTitles, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TextFieldTitle_course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ButtonRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ButtonDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25)
                        .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LabelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TextFieldSearch_course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ButtonQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelFunctionLayout.createSequentialGroup()
                        .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelCredits, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextFieldCredits_course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(PanelFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelDepartmentId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_course, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        DataTable_Course.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        DataTable_Course.setModel(new javax.swing.table.DefaultTableModel(
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
        DataTable_Course.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DataTable_Course.setFocusTraversalPolicyProvider(true);
        DataTable_Course.setRowHeight(40);
        DataTable_Course.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTable_CourseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DataTable_Course);

        LabelStatus_course.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        LabelStatus_course.setText("Status");
        LabelStatus_course.setRequestFocusEnabled(false);

        javax.swing.GroupLayout PanelTableLayout = new javax.swing.GroupLayout(PanelTable);
        PanelTable.setLayout(PanelTableLayout);
        PanelTableLayout.setHorizontalGroup(
            PanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(PanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(PanelTableLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(LabelStatus_course)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        PanelTableLayout.setVerticalGroup(
            PanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelStatus_course)
                .addGap(0, 0, 0))
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

    private void TextFieldTitle_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldTitle_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldTitle_courseActionPerformed

    private void TextFieldCredits_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldCredits_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldCredits_courseActionPerformed

    private void ButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteActionPerformed
        // TODO add your handling code here:
        String course_id = TextFieldCourseId_course.getText();
        try {
            if (bus__course.Delete_course(course_id) > 0) {
                JOptionPane.showMessageDialog(this, "Complete Delete Course", "Message", JOptionPane.INFORMATION_MESSAGE);
                listCourse();
                NullView_course();
            } else {
                JOptionPane.showMessageDialog(this, "Error Delete Course", "Message", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Course.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ButtonDeleteActionPerformed

    private void TextFieldCourseId_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldCourseId_courseActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_TextFieldCourseId_courseActionPerformed

    private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddActionPerformed
        // TODO add your handling code here:

        try {
            dto__course.setTITLE(TextFieldTitle_course.getText());
            dto__course.setCREDITS(TextFieldCredits_course.getText());

            dto__course.setDEPARTMENTID((int) jComboBox_course.getSelectedItem());
            if (bus__course.Add_course(dto__course) > 0) {
                //NullView();
                JOptionPane.showMessageDialog(this, "Complete Add Course", "Message", JOptionPane.INFORMATION_MESSAGE);
                listCourse();
                NullView_course();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error Add Course", "Message", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GUI_ManageCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonAddActionPerformed

    private void TextFieldSearch_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldSearch_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldSearch_courseActionPerformed

    private void ButtonQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonQuitActionPerformed
        String[] args = null;
        dispose();
        GUI_ChooseOption.main(args);
    }//GEN-LAST:event_ButtonQuitActionPerformed

    private void DataTable_CourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTable_CourseMouseClicked
        // TODO add your handling code here:
        pos = this.DataTable_Course.getSelectedRow();
        try {
            View_course();
        } catch (SQLException ex) {
            Logger.getLogger(GUI_ManageCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DataTable_CourseMouseClicked

    private void ButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRefreshActionPerformed
        // TODO add your handling code here:
        pos = this.DataTable_Course.getSelectedRow();
        try {
            NullView_course();
            listCourse();
        } catch (SQLException ex) {
            Logger.getLogger(GUI_ManageCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonRefreshActionPerformed

    private void TextFieldSearch_courseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldSearch_courseKeyReleased
        // TODO add your handling code here:
        DefaultTableModel obj_course = (DefaultTableModel) DataTable_Course.getModel();
        TableRowSorter<DefaultTableModel> oj1_course = new TableRowSorter<>(obj_course);
        DataTable_Course.setRowSorter(oj1_course);
        oj1_course.setRowFilter(RowFilter.regexFilter(TextFieldSearch_course.getText()));
    }//GEN-LAST:event_TextFieldSearch_courseKeyReleased

    private void ButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditActionPerformed
        // TODO add your handling code here:
        try {
            dto__course.setCOURSEID(Integer.parseInt(TextFieldCourseId_course.getText()));
            dto__course.setTITLE(TextFieldTitle_course.getText());
            dto__course.setCREDITS(TextFieldCredits_course.getText());

            // Kiểm tra kiểu dữ liệu của đối tượng trong JComboBox
            Object selectedItem = jComboBox_course.getSelectedItem();
            if (selectedItem instanceof Integer) {
                int departmentID = (int) selectedItem;
                dto__course.setDEPARTMENTID(departmentID);
            }

            if (bus__course.Edit_course(dto__course) > 0) {
                JOptionPane.showConfirmDialog(this, "Complete Edit Course", "Message", JOptionPane.INFORMATION_MESSAGE);
                listCourse();
                NullView_course();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error Edit Course", "Message", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GUI_Course.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonEditActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_ManageCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_ManageCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_ManageCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_ManageCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_ManageCourse().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton ButtonAdd;
    public javax.swing.JButton ButtonDelete;
    public javax.swing.JButton ButtonEdit;
    public javax.swing.JButton ButtonQuit;
    public javax.swing.JButton ButtonRefresh;
    public javax.swing.JTable DataTable_Course;
    public javax.swing.JLabel LabelCourseId;
    public javax.swing.JLabel LabelCredits;
    public javax.swing.JLabel LabelDepartmentId;
    public javax.swing.JLabel LabelSearch;
    private javax.swing.JLabel LabelStatus_course;
    public javax.swing.JLabel LabelTitle;
    public javax.swing.JLabel LabelTitles;
    public javax.swing.JPanel PanelFunction;
    public javax.swing.JPanel PanelTable;
    public javax.swing.JPanel PanelTitle;
    public javax.swing.JTextField TextFieldCourseId_course;
    public javax.swing.JTextField TextFieldCredits_course;
    public javax.swing.JTextField TextFieldSearch_course;
    public javax.swing.JTextField TextFieldTitle_course;
    private javax.swing.JComboBox<String> jComboBox_course;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
