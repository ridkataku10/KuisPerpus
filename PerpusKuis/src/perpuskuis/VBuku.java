/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpuskuis;

import javax.swing.JButton;
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
public class VBuku extends JFrame {

    DefaultTableModel model;
    String kolom[] = {"Kode Buku", "Nama Buku", "Pengarang", "Penerbit", "Tahun Terbit"};
    JTable table;
    JScrollPane sp;

    JLabel judul = new JLabel("DATA BUKU");
    JLabel kode = new JLabel("Kode Buku");
    JTextField tkode = new JTextField();
    JLabel nama = new JLabel("Nama Buku");
    JTextField tnama = new JTextField();
    JLabel pengarang = new JLabel("Pengarang");
    JTextField tkarang = new JTextField();
    JLabel penerbit = new JLabel("Penerbit");
    JTextField tterbit = new JTextField();
    JLabel thntb = new JLabel("Tahun Terbit");
    JTextField tthn = new JTextField();
    JButton cari = new JButton("Cari");
    JButton simpan = new JButton("Simpan");
    JButton hapus = new JButton("Hapus");
    JButton keluar = new JButton("Keluar");
    JButton refresh = new JButton("Refresh");

    VBuku() {
        setTitle("DATA BUKU");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        
        model = new DefaultTableModel(kolom, 0);
        table = new JTable(model);
        sp = new JScrollPane(table);
        add(sp).setBounds(30, 250, 720, 200);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(judul).setBounds(450, 20, 100, 20);
        add(kode).setBounds(30, 70, 90, 20);
        add(tkode).setBounds(150, 70, 120, 20);
        add(nama).setBounds(30, 105, 90, 20);
        add(tnama).setBounds(150, 105, 120, 20);
        add(pengarang).setBounds(30, 140, 90, 20);
        add(tkarang).setBounds(150, 140, 120, 20);
        add(penerbit).setBounds(30, 175, 90, 20);
        add(tterbit).setBounds(150, 175, 120, 20);
        add(thntb).setBounds(30, 210, 90, 20);
        add(tthn).setBounds(150, 210, 120, 20);
        add(simpan).setBounds(450, 105, 90, 20);
        add(hapus).setBounds(550, 105, 90, 20);
        add(cari).setBounds(400, 145, 90, 20);
        add(keluar).setBounds(500, 145, 90, 20);
        add(refresh).setBounds(600, 145, 90, 20);

    }
    
    public String getKode(){
        return tkode.getText();
    }
    public String getNama(){
        return tnama.getText();
    }
    public String getKarang(){
        return tkarang.getText();
    }
    public String getTerbit(){
        return tterbit.getText();
    }
    public String getTahun(){
        return tthn.getText();
    }

}



