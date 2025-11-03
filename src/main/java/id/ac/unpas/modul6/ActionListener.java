package id.ac.unpas.modul06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ActionListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh ActionListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Halo, klik tombol di bawah!");
        JButton button = new JButton("Klik Saya!");

        // Gunakan nama lengkap java.awt.event.ActionListener
        java.awt.event.ActionListener listener = new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Tombol telah diklik!");
            }
        };

        button.addActionListener(listener);
        frame.add(label);
        frame.add(button);
        frame.setVisible(true);
    }
}
