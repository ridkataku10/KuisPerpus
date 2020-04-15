/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpuskuis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author sistem
 */
public class CB {

    Mperpus mperpus;
    VBuku vBuku;
    String dataTerpilih;

    public CB(Mperpus mperpus, VBuku vBuku) {
        this.mperpus = mperpus;
        this.vBuku = vBuku;

        if (mperpus.getBykB() != 0) {
            String dataB[][] = mperpus.ReadB();
            vBuku.table.setModel((new JTable(dataB, vBuku.kolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak ada");
        }
        vBuku.simpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vBuku.getKode().equals("")) {
                    JOptionPane.showMessageDialog(null, "Kode buku tidak boleh kosong");
                } else {
                    String kode = vBuku.getKode();
                    String namab = vBuku.getNama();
                    String pengarang = vBuku.getKarang();
                    String penerbit = vBuku.getTerbit();
                    String terbit = vBuku.getTahun();

                    mperpus.InsertB(kode, namab, pengarang, penerbit, terbit);

                    String dataB[][] = mperpus.ReadB();
                    vBuku.table.setModel(new JTable(dataB, vBuku.kolom).getModel());
                }
            }
        });

        vBuku.keluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Beranda();
                vBuku.dispose();
            }

        });

        vBuku.refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vBuku.tkode.setText("");
                vBuku.tnama.setText("");
                vBuku.tkarang.setText("");
                vBuku.tterbit.setText("");
                vBuku.tthn.setText("");

                String dataB[][] = mperpus.ReadB();
                vBuku.table.setModel(new JTable(dataB, vBuku.kolom).getModel());

            }
        });

        vBuku.table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int baris = vBuku.table.getSelectedRow();
                int kolom = vBuku.table.getSelectedColumn();
                 dataTerpilih = vBuku.table.getValueAt(baris, 0).toString();
            }
        });
        
        vBuku.hapus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String kode = dataTerpilih;
                        mperpus.DeleteB(kode);

                        String dataB[][] = mperpus.ReadB();
                        vBuku.table.setModel(new JTable(dataB, vBuku.kolom).getModel());
                    }
                }
                );

        vBuku.cari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jd = vBuku.tnama.getText();

                mperpus.SearchB(jd);

                String dataB[][] = mperpus.SearchB(jd);
                vBuku.table.setModel(new JTable(dataB, vBuku.kolom).getModel());
            }
        });

    }

}
