/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpuskuis;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sistem
 */
public class VAnggota extends JFrame {

    String jkk;

    JLabel judul = new JLabel("DATA ANGGOTA");
    JLabel nis = new JLabel("NIS");
    JTextField tnis = new JTextField();
    JLabel nama = new JLabel("Nama Siswa");
    JTextField tnama = new JTextField();
    JLabel ttl = new JLabel("Tanggal Lahir");
    JTextField tfttl = new JTextField();
    JLabel jk = new JLabel("Jenis Kelamin");
    JRadioButton p = new JRadioButton("Perempuan");
    JRadioButton l = new JRadioButton("Laki-laki");
    JLabel agama = new JLabel("Agama");
    String[] aga = {"Islam", "Kristen", "Hindu", "Budha", "Katolik"};
    JComboBox ma = new JComboBox(aga);
    JLabel kelas = new JLabel("Kelas");
    JTextField tkelas = new JTextField();
    JLabel daftar = new JLabel("Tanggal Daftar");
    JTextField tdaftar = new JTextField();
    JLabel laku = new JLabel("Berlaku Hingga");
    JTextField tlaku = new JTextField();
    JButton simpan = new JButton("Simpan");
    JButton hapus = new JButton("Hapus");
    JButton keluar = new JButton("Keluar");
    JButton refresh = new JButton("Refresh");

    DefaultTableModel model;
    String kolom[] = {"NIS", "Nama Siswa", "Tanggal Lahir", "Jenis Kelamin", "Agama", "Kelas", "Tanggal Daftar", "Berlaku Hingga"};
    JTable table;
    JScrollPane sp;

    VAnggota() {
        setTitle("DATA ANGGOTA");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        
        ButtonGroup group = new ButtonGroup();
        group.add(p);
        group.add(l);

        model = new DefaultTableModel(kolom, 0);
        table = new JTable(model);
        sp = new JScrollPane(table);
        add(sp).setBounds(30, 270, 900, 200);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(judul).setBounds(440, 20, 100, 20);
        add(nis).setBounds(30, 80, 90, 20);
        add(tnis).setBounds(150, 80, 120, 20);
        add(nama).setBounds(30, 115, 90, 20);
        add(tnama).setBounds(150, 115, 120, 20);
        add(ttl).setBounds(30, 150, 90, 20);
        add(tfttl).setBounds(150, 150, 120, 20);
        add(jk).setBounds(30, 185, 90, 20);
        add(p).setBounds(150, 185, 120, 20);
        add(l).setBounds(280, 185, 90, 20);
        add(agama).setBounds(450, 80, 90, 20);
        add(ma).setBounds(570, 80, 100, 20);
        add(kelas).setBounds(450, 115, 90, 20);
        add(tkelas).setBounds(570, 115, 120, 20);
        add(daftar).setBounds(450, 150, 90, 20);
        add(tdaftar).setBounds(570, 150, 120, 20);
        add(laku).setBounds(450, 185, 90, 20);
        add(tlaku).setBounds(570, 185, 120, 20);
        add(simpan).setBounds(50, 230, 90, 20);
        add(hapus).setBounds(180, 230, 90, 20);
        add(keluar).setBounds(290, 230, 90, 20);
        add(refresh).setBounds(400, 230, 90, 20);

    }

    public String getNIS() {
        return tnis.getText();
    }

    public String getNama() {
        return tnama.getText();
    }

    public String getTtl() {
        return tfttl.getText();
    }

    public String getJk() {
        if (p.isSelected()) {
            jkk = p.getText();
        }
        if (l.isSelected()) {
            jkk = l.getText();
        }
        return jkk;
    }
    public String getAgama(){
        return (String) ma.getSelectedItem();
    }
    public String getKelas(){
        return tkelas.getText();
    }
    public String getDaftar(){
        return tdaftar.getText();
    }
    public String getLaku(){
        return tlaku.getText();
    }

}

 
