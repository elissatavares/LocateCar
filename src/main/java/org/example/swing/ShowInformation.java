package org.example.swing;

import javax.swing.*;

public class ShowInformation {
    public static void execute(String message, String title) {
        JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }
}
