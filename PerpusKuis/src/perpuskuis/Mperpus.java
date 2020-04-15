/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpuskuis;

import static com.sun.xml.internal.ws.client.ContentNegotiation.none;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author sistem
 */
public class Mperpus {

    static final String JDBC__DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/perpustakaan";
    static final String USER = "root";
    static final String PASS = "";

    Connection conn;
    Statement statement;

    public Mperpus() {
        try {
            Class.forName(JDBC__DRIVER);

            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public void InsertA(String nis, String namas, String ttl, String jk, String agama, String kelas, String daftar, String berlaku) {
        try {
            String query = "INSERT INTO `anggota`(`nis`,`namas`,`ttl`,`jk`, `agama`, `kelas`,`daftar`,`berlaku`) VALUES ('" + nis + "','" + namas + "','" + ttl + "','" + jk + "','" + agama + "','" + kelas + "','" + daftar + "','" + berlaku + "')";
            statement = (Statement) conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }

    }

    public void InsertK(String nik, String namak, String jk, String golongan, String jabatan, String tunjangan, String gaji) {
        try {
            String query = "INSERT INTO `karyawan`(`nik`,`namak`,`jk`,`golongan`, `jabatan`, `tunjangan`,`gaji`) VALUES ('" + nik + "','" + namak + "','" + jk + "','" + golongan + "','" + jabatan + "','" + tunjangan + "','" + gaji + "')";
            statement = (Statement) conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }

    }

    public void InsertB(String kode, String namab, String pengarang, String penerbit, String terbit) {
        try {
            String query = "INSERT INTO `buku`(`kode`,`namab`,`pengarang`,`penerbit`, `terbit`) VALUES ('" + kode + "','" + namab + "','" + pengarang + "','" + penerbit + "','" + terbit + "')";
            statement = (Statement) conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }

    }

    public void InsertP(String no, String nis, String kode, String pinjam, String kembali, String lamapinjam, String denda, String nik) {
        try {
            String query = "INSERT INTO `peminjaman`(`no`,`nis`, `kode`, `pinjam`,`kembali`,`lamapinjam`,`denda`,`nik`) VALUES ('" + no + "','" + nis + "','" + kode + "','" + pinjam + "','" + kembali + "','" + lamapinjam + "','" + denda + "','" + nik + "')";
            statement = (Statement) conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }

    }

    public String[][] ReadA() {
        try {
            int jmlData = 0;
            String data[][] = new String[getBykA()][8];
            String query = "SELECT*FROM `anggota`";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data[jmlData][0] = rs.getString("nis");
                data[jmlData][1] = rs.getString("namas");
                data[jmlData][2] = rs.getString("ttl");
                data[jmlData][3] = rs.getString("jk");
                data[jmlData][4] = rs.getString("agama");
                data[jmlData][5] = rs.getString("kelas");
                data[jmlData][6] = rs.getString("daftar");
                data[jmlData][7] = rs.getString("berlaku");

                jmlData++;

            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public String[][] ReadK() {
        try {
            int jmlData = 0;
            String data[][] = new String[getBykK()][7];
            String query = "SELECT*FROM `karyawan`";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
//                int gl = rs.getInt("golongan");
//                int t = rs.getInt("tunjangan");
//                int gj = rs.getInt("gaji");
                data[jmlData][0] = rs.getString("nik");
                data[jmlData][1] = rs.getString("namak");
                data[jmlData][2] = rs.getString("jk");
                data[jmlData][3] = rs.getString("golongan");
                data[jmlData][4] = rs.getString("jabatan");
                data[jmlData][5] = rs.getString("tunjangan");
                data[jmlData][6] = rs.getString("gaji");

                jmlData++;

            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public String[][] ReadB() {
        try {
            int jmlData = 0;
            String data[][] = new String[getBykB()][5];
            String query = "SELECT*FROM `buku`";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
//                int tb = rs.getInt("terbit");
                data[jmlData][0] = rs.getString("kode");
                data[jmlData][1] = rs.getString("namab");
                data[jmlData][2] = rs.getString("pengarang");
                data[jmlData][3] = rs.getString("penerbit");
                data[jmlData][4] = rs.getString("terbit");

                jmlData++;

            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public String[][] ReadP() {
        try {
            int jmlData = 0;
            String data[][] = new String[getBykP()][13];
            String query = "SELECT * FROM `peminjaman` JOIN `anggota` ON `peminjaman`.`nis` = `anggota`.`nis` JOIN `buku` ON `peminjaman`.`kode` = `buku`.`kode` JOIN `karyawan` ON `peminjaman`.`nik` = `karyawan`.`nik`;";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
//                int lp = rs.getInt("lamapinjam");
//                int d = rs.getInt("denda");
                data[jmlData][0] = rs.getString("no");
                data[jmlData][1] = rs.getString("nis");
                data[jmlData][2] = rs.getString("namas");
                data[jmlData][3] = rs.getString("kelas");
                data[jmlData][4] = rs.getString("kode");
                data[jmlData][5] = rs.getString("namab");
                data[jmlData][6] = rs.getString("penerbit");
                data[jmlData][7] = rs.getString("pinjam");
                data[jmlData][8] = rs.getString("kembali");
                data[jmlData][9] = rs.getString("lamapinjam");
                data[jmlData][10] = rs.getString("denda");
                data[jmlData][11] = rs.getString("nik");
                data[jmlData][12] = rs.getString("namak");

                jmlData++;

            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public int getBykA() {
        int jmlData = 0;
        try {
            statement = (Statement) conn.createStatement();
            String query = "SELECT*FROM `anggota`";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                jmlData++;
            }
            return jmlData;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return 0;
        }

    }

    public int getBykK() {
        int jmlData = 0;
        try {
            statement = (Statement) conn.createStatement();
            String query = "SELECT*FROM `karyawan`";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                jmlData++;
            }
            return jmlData;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return 0;
        }

    }

    public int getBykB() {
        int jmlData = 0;
        try {
            statement = (Statement) conn.createStatement();
            String query = "SELECT*FROM `buku`";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                jmlData++;
            }
            return jmlData;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return 0;
        }

    }

    public int getBykP() {
        int jmlData = 0;
        try {
            statement = (Statement) conn.createStatement();
            String query = "SELECT*FROM `peminjaman`";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                jmlData++;
            }
            return jmlData;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return 0;
        }

    }

    public void DeleteA(String nis) {
        try {
            String query = "DELETE FROM `anggota` WHERE nis = '" + nis + "'";
            statement = (Statement) conn.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil dihapus");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void DeleteK(String nik) {
        try {
            String query = "DELETE FROM `karyawan` WHERE nik = '" + nik + "'";
            statement = (Statement) conn.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil dihapus");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void DeleteB(String kode) {
        try {
            String query = "DELETE FROM `buku` WHERE kode = '" + kode + "'";
            statement = (Statement) conn.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil dihapus");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void DeleteP(String no) {
        try {
            String query = "DELETE FROM `peminjaman` WHERE no = '" + no + "'";
            statement = (Statement) conn.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil dihapus");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public String[][] SearchB(String jd) {

        try {
            int jmlData = 0;
            String data[][] = new String[getBykB()][5];
            String query = "SELECT*FROM `buku` WHERE `namab` LIKE '%" + jd + "%'";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
//                int tb = rs.getInt("terbit");
                data[jmlData][0] = rs.getString("kode");
                data[jmlData][1] = rs.getString("namab");
                data[jmlData][2] = rs.getString("pengarang");
                data[jmlData][3] = rs.getString("penerbit");
                data[jmlData][4] = rs.getString("terbit");

                jmlData++;

            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return null;
        }

    }

    public String[][] SearchK(String jd) {

        try {
            int jmlData = 0;
            String data[][] = new String[getBykA()][7];
            String query = "SELECT*FROM `karyawan` WHERE `namak` LIKE '%" + jd + "%'";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int gl = rs.getInt("golongan");
                int t = rs.getInt("tunjangan");
                int gj = rs.getInt("gaji");
                data[jmlData][0] = rs.getString("nik");
                data[jmlData][1] = rs.getString("namak");
                data[jmlData][2] = rs.getString("jk");
                data[jmlData][3] = Integer.toString(gl);
                data[jmlData][4] = rs.getString("jabatan");
                data[jmlData][5] = Integer.toString(t);
                data[jmlData][6] = Integer.toString(gj);

                jmlData++;

            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public String[][] SearchP(String jd) {

        try {
            int jmlData = 0;
            String data[][] = new String[getBykP()][13];
            String query = "SELECT * FROM `peminjaman` JOIN `anggota` ON `peminjaman`.`nis` = `anggota`.`nis` JOIN `buku` ON `peminjaman`.`kode` = `buku`.`kode` JOIN `karyawan` ON `peminjaman`.`nik` = `karyawan`.`nik` WHERE `peminjaman`.`no` LIKE '%"+jd+"%';";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
//                int lp = rs.getInt("lamapinjam");
//                int d = rs.getInt("denda");
                data[jmlData][0] = rs.getString("no");
                data[jmlData][1] = rs.getString("nis");
                data[jmlData][2] = rs.getString("namas");
                data[jmlData][3] = rs.getString("kelas");
                data[jmlData][4] = rs.getString("kode");
                data[jmlData][5] = rs.getString("namab");
                data[jmlData][6] = rs.getString("penerbit");
                data[jmlData][7] = rs.getString("pinjam");
                data[jmlData][8] = rs.getString("kembali");
                data[jmlData][9] = rs.getString("lamapinjam");
                data[jmlData][10] = rs.getString("denda");
                data[jmlData][11] = rs.getString("nik");
                data[jmlData][12] = rs.getString("namak");

                jmlData++;

            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

}
