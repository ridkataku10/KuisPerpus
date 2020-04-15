/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpuskuis;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sistem
 */
public class VPeminjaman extends JFrame {

    DefaultTableModel model;
    String kolom[] = {"Nomor Pinjam", "NIS", "Nama Siswa", "Kelas", "Kode Buku", "Nama Buku", "Penerbit","Tanggal Pinjam","Tanggal Kembali","Denda","NIK","Karyawan"};
    JTable table;
    JScrollPane sp;

    JLabel judul = new JLabel("DATA PENGEMBALIAN BUKU");
    JLabel no = new JLabel("Nomor Pinjam");
    JTextField tno = new JTextField();
    JLabel nis = new JLabel("NIS");
    JTextField tnis = new JTextField();
    JLabel namas = new JLabel("Nama Siswa");
    JLabel tnamas = new JLabel("");
    JLabel kelas = new JLabel("Kelas");
    JLabel tkelas = new JLabel("");
    JLabel kode = new JLabel("Kode Buku");
    JTextField tkode = new JTextField();
    JLabel namab = new JLabel("Nama Buku");
    JLabel tnamab = new JLabel("");
    JLabel terbit = new JLabel("Penerbit");
    JLabel tterbit = new JLabel("");
    JLabel pinjam = new JLabel("Tanggal Pinjam");
    JTextField tpinjam = new JTextField();
    JLabel kembali = new JLabel("Tanggal Kembali");
    JTextField tkembali = new JTextField();
    JLabel denda = new JLabel("Denda");
    JLabel tdenda = new JLabel("");
    JLabel nik = new JLabel("NIK");
    JTextField tnik = new JTextField();
    JLabel namak = new JLabel("Karyawan yang Bertugas");
    JLabel tnamak = new JLabel("");
    JLabel lama = new JLabel("Lama Pinjam");
    JLabel tlama = new JLabel("");

    JButton cari = new JButton("Cari");
    JButton simpan = new JButton("Simpan");
    JButton hapus = new JButton("Hapus");
    JButton keluar = new JButton("Keluar");
    JButton refresh = new JButton("Refresh");
    JButton print = new JButton("Print");

    VPeminjaman() {
        setTitle("DATA PENGEMBALIAN");
        setSize(1500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);

        model = new DefaultTableModel(kolom, 0);
        table = new JTable(model);
        sp = new JScrollPane(table);
        add(sp).setBounds(30, 430, 1300, 200);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(judul).setBounds(410, 20, 200, 20);
        add(no).setBounds(30, 70, 90, 20);
        add(tno).setBounds(150, 70, 120, 20);
        add(nis).setBounds(30, 105, 90, 20);
        add(tnis).setBounds(150, 105, 120, 20);
        add(namas).setBounds(30, 140, 90, 20);
        add(tnamas).setBounds(150, 140, 120, 20);
        add(kelas).setBounds(30, 175, 90, 20);
        add(tkelas).setBounds(150, 175, 120, 20);
        add(kode).setBounds(30, 210, 90, 20);
        add(tkode).setBounds(150, 210, 120, 20);
        add(namab).setBounds(30, 245, 90, 20);
        add(tnamab).setBounds(150, 245, 120, 20);
        add(terbit).setBounds(30, 280, 90, 20);
        add(tterbit).setBounds(150, 280, 120, 20);
        add(pinjam).setBounds(30, 315, 90, 20);
        add(tpinjam).setBounds(150, 315, 120, 20);
        add(kembali).setBounds(30, 350, 120, 20);
        add(tkembali).setBounds(150, 350, 120, 20);
        add(lama).setBounds(30, 385, 90, 20);
        add(tlama).setBounds(150, 385, 120, 20);
        add(denda).setBounds(450, 230, 90, 20);
        add(tdenda).setBounds(620, 230, 120, 20);
        add(nik).setBounds(450, 265, 90, 20);
        add(tnik).setBounds(620, 265, 120, 20);
        add(namak).setBounds(450, 300, 160, 20);
        add(tnamak).setBounds(620, 300, 120, 20);

        add(simpan).setBounds(450, 105, 90, 20);
        add(hapus).setBounds(550, 105, 90, 20);
        add(cari).setBounds(450, 145, 90, 20);
        add(keluar).setBounds(550, 145, 90, 20);
        add(refresh).setBounds(450, 185, 90, 20);
        add(print).setBounds(550, 185, 90, 20);
    }
    
    public String getNO(){
        return tno.getText();
    }
    public String getNIS(){
        return tnis.getText();
    }
   
    
    public String getKode(){
        return tkode.getText();
    }
   
    public String getPinjam(){
        return tpinjam.getText();
    }
    public String getKembali(){
        return tkembali.getText();
    }
    public String getNIK(){
        return tnik.getText();
    }

}

