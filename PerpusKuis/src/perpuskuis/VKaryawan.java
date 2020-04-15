/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpuskuis;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
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
public class VKaryawan extends JFrame {

    String jkk,man;
    int tun,gj;
    DefaultTableModel model;
    String kolom[] = {"NIK", "Nama Karyawan", "Jenis Kelamin", "Golongan", "Jabatan", "Tunjangan", "Total Gaji"};
    JTable table;
    JScrollPane sp;

    JLabel judul = new JLabel("DATA KARYAWAN");
    JLabel nik = new JLabel("NIK");
    JTextField tnik = new JTextField();
    JLabel nama = new JLabel("Nama Karyawan");
    JTextField tnama = new JTextField();
    JLabel jk = new JLabel("Jenis Kelamin");
    JRadioButton p = new JRadioButton("Perempuan");
    JRadioButton l = new JRadioButton("Laki-laki");
    JLabel gol = new JLabel("Golongan");
    JTextField tgol = new JTextField();
    JLabel jabatan = new JLabel("Jabatan");
    JLabel tjab = new JLabel("");
    JLabel tunjang = new JLabel("Tunjangan");
    JLabel ttunjang = new JLabel("");
    JLabel gaji = new JLabel("Jumlah Gaji");
    JLabel tgaji = new JLabel("");
    JButton cari = new JButton("Cari");
    JButton simpan = new JButton("Simpan");
    JButton hapus = new JButton("Hapus");
    JButton keluar = new JButton("Keluar");
    JButton refresh = new JButton("Refresh");

    VKaryawan() {
        setTitle("DATA KARYAWAN");
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
        add(sp).setBounds(30, 330, 750, 200);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(judul).setBounds(450, 20, 200, 20);
        add(nik).setBounds(30, 70, 90, 20);
        add(tnik).setBounds(150, 70, 120, 20);
        add(nama).setBounds(30, 105, 120, 20);
        add(tnama).setBounds(150, 105, 120, 20);
        add(jk).setBounds(30, 140, 90, 20);
        add(p).setBounds(150, 140, 110, 20);
        add(l).setBounds(260, 140, 90, 20);
        add(gol).setBounds(30, 175, 90, 20);
        add(tgol).setBounds(150, 175, 120, 20);
        add(jabatan).setBounds(30, 210, 90, 20);
        add(tjab).setBounds(150, 210, 150, 20);
        add(tunjang).setBounds(30, 245, 90, 20);
        add(ttunjang).setBounds(150, 245, 120, 20);
        add(gaji).setBounds(30, 280, 90, 20);
        add(tgaji).setBounds(150, 280, 120, 20);

        add(simpan).setBounds(450, 105, 90, 20);
        add(hapus).setBounds(550, 105, 90, 20);
        add(cari).setBounds(400, 145, 90, 20);
        add(keluar).setBounds(500, 145, 90, 20);
        add(refresh).setBounds(600, 145, 90, 20);
    }
    
    public String getNIK(){
        return tnik.getText();
    }
    public String getNama(){
        return tnama.getText();
    }

    public String getJk(){
         if (p.isSelected()) {
            jkk = p.getText();
        }
        if (l.isSelected()) {
            jkk = l.getText();
        }
        return jkk;
    }
    public String getGol(){
       return tgol.getText();
    }
    public String getJab(){
        return tjab.getText();
    }
    public String getTun(){
        return ttunjang.getText();
    }
    public String getGaji(){
        return tgaji.getText();
    }
   
}
