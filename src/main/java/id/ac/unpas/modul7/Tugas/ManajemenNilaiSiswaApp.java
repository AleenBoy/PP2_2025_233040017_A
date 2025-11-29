package id.ac.unpas.modul7.Tugas;

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
                "Matematika Dasar", "Bahasa Indonesia", "Algoritma & Pemograman I", "Praktikum Pemograman 2"        });

        JButton btnSimpan = new JButton("Simpan Data");
        JButton btnReset = new JButton("Reset"); // Tambah tombol reset

        btnSimpan.addActionListener(e -> prosesSimpan());
        btnReset.addActionListener(e -> resetInput()); // fungsi reset

        panel.add(new JLabel("Nama Siswa:"));
        panel.add(tfNama);
        panel.add(new JLabel("Mata Kuliah:"));
        panel.add(cbMatkul);
        panel.add(new JLabel("Nilai:"));
        panel.add(tfNilai);

        JPanel panelBtn = new JPanel();
        panelBtn.add(btnSimpan);
        panelBtn.add(btnReset);

        panel.add(panelBtn);

        return panel;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] kolom = {"Nama", "Mata Kuliah", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);
        tableData = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(tableData);

        JButton btnHapus = new JButton("Hapus Data"); // Tugas: tombol hapus

        btnHapus.addActionListener(e -> hapusData());

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(btnHapus, BorderLayout.SOUTH);

        return panel;
    }

    private void prosesSimpan() {
        String nama = tfNama.getText().trim();
        String matkul = cbMatkul.getSelectedItem().toString();
        String strNilai = tfNilai.getText().trim();

        // Validasi nama minimal 3 karakter
        if (nama.isEmpty() || nama.length() < 3) {
            JOptionPane.showMessageDialog(this,
                    "Nama harus minimal 3 karakter!",
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

        // Menentukan grade menggunakan switch-case
        String grade;
        switch (nilai / 10) {
            case 10:
            case 9:
                grade = "A";
                break;
            case 8:
                grade = "B";
                break;
            case 7:
                grade = "C";
                break;
            case 6:
                grade = "D";
                break;
            default:
                grade = "E";
        }

        tableModel.addRow(new Object[]{nama, matkul, nilai, grade});

        JOptionPane.showMessageDialog(this,
                "Data berhasil disimpan!",
                "Sukses",
                JOptionPane.INFORMATION_MESSAGE);

        resetInput();
    }

    private void hapusData() {
        int row = tableData.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this,
                    "Pilih baris yang ingin dihapus!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        tableModel.removeRow(row);

        JOptionPane.showMessageDialog(this,
                "Data berhasil dihapus!",
                "Info",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void resetInput() {
        tfNama.setText("");
        tfNilai.setText("");
        cbMatkul.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ManajemenNilaiSiswaApp());
    }
}
