/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.EventObject;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Admin
 */
class CustomCellEditor extends DefaultCellEditor {

    public CustomCellEditor() {
        super(new JTextField());
        final JTextField textField = (JTextField) getComponent();
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopCellEditing();
            }
        });
    }

    @Override
    public boolean stopCellEditing() {
        JTextField textField = (JTextField) getComponent();
        ActionMap actionMap = textField.getActionMap();
        if (actionMap != null) {
            Action action = actionMap.get("selectNextRowCell");
            if (action != null) {
                action.actionPerformed(new ActionEvent(textField, ActionEvent.ACTION_PERFORMED, null));
            }
        }
        return super.stopCellEditing();
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        if (anEvent instanceof KeyEvent) {
            KeyEvent ke = (KeyEvent) anEvent;
            return ke.getKeyCode() != KeyEvent.VK_ENTER;
        }
        return true;
    }
}
