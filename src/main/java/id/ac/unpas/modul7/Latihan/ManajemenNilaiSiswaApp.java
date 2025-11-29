package id.ac.unpas.modul7.Latihan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ManajemenNilaiSiswaApp extends JFrame {

    private JTextField tfNama, tfNilai;
    private JComboBox<String> cbMatkul;

    private JTable tableData;
    private DefaultTableModel tableModel;

    private JTabbedPane tabPane;

    public ManajemenNilaiSiswaApp() {

        setTitle("Manajemen Nilai Siswa");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tabPane = new JTabbedPane();
        tabPane.addTab("Input Data", createInputPanel());
        tabPane.addTab("Daftar Nilai", createTablePanel());

        add(tabPane);
        setVisible(true);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        tfNama = new JTextField();
        tfNilai = new JTextField();

        cbMatkul = new JComboBox<>(new String[]{
                "Matematika Dasar", "Bahasa Indonesia", "Algoritma & Pemograman I", "Praktikum Pemograman 2"
        });

        JButton btnSimpan = new JButton("Simpan Data");

        btnSimpan.addActionListener(e -> prosesSimpan());

        panel.add(new JLabel("Nama Siswa:"));
        panel.add(tfNama);
        panel.add(new JLabel("Mata Kuliah:"));
        panel.add(cbMatkul);
        panel.add(new JLabel("Nilai:"));
        panel.add(tfNilai);

        JPanel panelBtn = new JPanel();
        panelBtn.add(btnSimpan);

        panel.add(panelBtn);

        return panel;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] kolom = {"Nama", "Mata Kuliah", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(tableData);

        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private void prosesSimpan() {
        String nama = tfNama.getText().trim();
        String matkul = cbMatkul.getSelectedItem().toString();
        String strNilai = tfNilai.getText().trim();

        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nama tidak boleh kosong!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (strNilai.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nilai tidak boleh kosong!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int nilai;

        try {
            nilai = Integer.parseInt(strNilai);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Nilai harus berupa angka!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (nilai < 0 || nilai > 100) {
            JOptionPane.showMessageDialog(this,
                    "Nilai harus berada pada rentang 0 - 100!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Grade masih versi sederhana (belum switch-case, sesuai latihan)
        String grade = "";
        if (nilai >= 90) grade = "A";
        else if (nilai >= 80) grade = "B";
        else if (nilai >= 70) grade = "C";
        else if (nilai >= 60) grade = "D";
        else grade = "E";

        tableModel.addRow(new Object[]{nama, matkul, nilai, grade});

        JOptionPane.showMessageDialog(this,
                "Data berhasil disimpan!",
                "Sukses",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ManajemenNilaiSiswaApp());
    }
}
