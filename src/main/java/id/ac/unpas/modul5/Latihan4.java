package id.ac.unpas.modul5;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Latihan4 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Contoh BorderLayout");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //1. Atur Layout Manager ke BorderLayout
                //Sebenarnya ini tidak perlu
                //Karena BorderLayout adalah layout Manager default
                frame.setLayout(new BorderLayout());

                //2. Buat komponen GUI
                JLabel label = new JLabel("Label ada di Atas (NORTH)!");
                JButton southButton = new JButton("Tombol ada di Bawah (SOUTH)");
                JButton westButton = new JButton("WEST");
                JButton eastButton = new JButton("EAST");
                JButton centerButton = new JButton("CENTER");

                /*
                3. Tambahkan Aksi (ActionListener) ke tombol
                   Penambahan ini menggunakan lambda untuk mempersingkat
                   penggunaan anonymous inner class
                 */
                southButton.addActionListener(e -> {
                    label.setText("Tombol di SOUTH diklik!");
                });

                westButton.addActionListener(e -> {
                    label.setText("Tombol di WEST diklik!");
                });

                eastButton.addActionListener(e -> {
                    label.setText("Tombol di EAST diklik!");
                });

                centerButton.addActionListener(e -> {
                    label.setText("Tombol di CENTER diklik!");
                });

                /*
                4. Tambahkan komponen ke frame DENGAN POSISI
                   Karena kita menggunakan FlowLayout,
                   keduanya akan tampil berdampingan
                 */
                frame.add(label, BorderLayout.NORTH);
                frame.add(southButton, BorderLayout.SOUTH);
                frame.add(westButton, BorderLayout.WEST);
                frame.add(eastButton, BorderLayout.EAST);
                frame.add(centerButton, BorderLayout.CENTER);

                frame.setVisible(true);
            }
        });
    }
}