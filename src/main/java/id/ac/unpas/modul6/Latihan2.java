import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Latihan2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Konverter Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        JLabel lblCelcius = new JLabel("Celcius:");
        JTextField txtCelcius = new JTextField(10);
        JButton btnKonversi = new JButton("Konversi");
        JLabel lblFahrenheit = new JLabel("Fahrenheit:");
        JLabel lblHasil = new JLabel("");

        frame.add(lblCelcius);
        frame.add(txtCelcius);
        frame.add(btnKonversi);
        frame.add(lblFahrenheit);
        frame.add(lblHasil);

        // Event handling menggunakan ActionListener
        btnKonversi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celcius = Double.parseDouble(txtCelcius.getText());
                    double fahrenheit = (celcius * 9 / 5) + 32;
                    lblHasil.setText(String.format("%.2f °F", fahrenheit));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Input harus berupa angka!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
