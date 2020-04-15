/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpuskuis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author sistem
 */
public class CP {

    Mperpus mperpus;
    VPeminjaman vPeminjaman;
    String dataTerpilih;

    public CP(Mperpus mperpus, VPeminjaman vPeminjaman) {
        this.mperpus = mperpus;
        this.vPeminjaman = vPeminjaman;

        if (mperpus.getBykP() != 0) {
            String dataP[][] = mperpus.ReadP();
            vPeminjaman.table.setModel((new JTable(dataP, vPeminjaman.kolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak ada");
        }
        vPeminjaman.simpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vPeminjaman.getNO().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nomor pinjam tidak boleh kosong");
                } else {
                    String no = vPeminjaman.getNO();
                    String nis = vPeminjaman.getNIS();
                    String kode = vPeminjaman.getKode();
                    String pinjam = vPeminjaman.getPinjam();
                    String kembali = vPeminjaman.getKembali();
                    String nik = vPeminjaman.getNIK();

                    mperpus.InsertP(no, nis, kode, pinjam, kembali, pinjam, nik, nik);

                    String dataP[][] = mperpus.ReadP();
                    vPeminjaman.table.setModel(new JTable(dataP, vPeminjaman.kolom).getModel());
                }
            }
        });

        vPeminjaman.keluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Beranda();
                vPeminjaman.dispose();
            }

        });

        vPeminjaman.refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vPeminjaman.tno.setText("");
                vPeminjaman.tnis.setText("");
                vPeminjaman.tnamas.setText("");
                vPeminjaman.tkode.setText("");
                vPeminjaman.tnamab.setText("");
                vPeminjaman.tterbit.setText("");
                vPeminjaman.tpinjam.setText("");
                vPeminjaman.tkembali.setText("");
                vPeminjaman.tlama.setText("");
                vPeminjaman.tdenda.setText("");
                vPeminjaman.tnik.setText("");
                vPeminjaman.tnamak.setText("");

                String dataP[][] = mperpus.ReadP();
                vPeminjaman.table.setModel(new JTable(dataP, vPeminjaman.kolom).getModel());

            }
        });

        vPeminjaman.table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int baris = vPeminjaman.table.getSelectedRow();
                int kolom = vPeminjaman.table.getSelectedColumn();
                dataTerpilih = vPeminjaman.table.getValueAt(baris, 0).toString();

            }
        });
        
        vPeminjaman.hapus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String no = dataTerpilih;
                        mperpus.DeleteP(no);

                        String dataP[][] = mperpus.ReadP();
                        vPeminjaman.table.setModel(new JTable(dataP, vPeminjaman.kolom).getModel());
                    }
                }
                );

        vPeminjaman.cari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jd = vPeminjaman.tnamas.getText();

                mperpus.SearchP(jd);

                String dataP[][] = mperpus.SearchP(jd);
                vPeminjaman.table.setModel(new JTable(dataP, vPeminjaman.kolom).getModel());
            }
        });

//        vPeminjaman.tnis.addKeyListener(new KeyAdapter() {
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                   vPeminjaman.tnamas.getText();
//                   vPeminjaman.tkelas.getText();
//                }
//            }
//        });

    }

}


