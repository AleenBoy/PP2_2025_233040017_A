package id.ac.unpas.modul6;

import javax.swing.*;
import java.awt.*;

public class Latihan1{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Kalkulator Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());

        // layar atas (JTextField)
        JTextField layar = new JTextField();
        layar.setEditable(false);
        layar.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(layar, BorderLayout.NORTH);

        // tombol (Pake GridLayout)
        JPanel panelTombol = new JPanel();
        panelTombol.setLayout(new GridLayout(4, 4, 5, 5));

        // Nambahin tombol angka dan operator
        String[] tombol = {
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "*",
                "0", "C", "=", "/"
        };

        for (String text : tombol) {
            JButton btn = new JButton(text);
            panelTombol.add(btn);
        }

        frame.add(panelTombol, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

