package com.tugasbesarpbotake3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.*;

public class Novel extends Buku {
    String Genre;

    public Novel(String Judul, String Penulis, Integer Harga,  String Genre) {
        super(Judul, Penulis, Harga);
        this.Genre = Genre;
    }

    public Novel() {
    }

    
    public void TambahkanNovel(){
        Scanner scanNovel = new Scanner(System.in);
        System.out.println("Masukkan Judul: ");
        String Judul = scanNovel.nextLine();
        System.out.println("Masukkan Penulis: ");
        String Penulis = scanNovel.nextLine();
        System.out.println("Masukkan Harga: " );
        Integer Harga = scanNovel.nextInt();
        System.out.println("Masukkan Genre: ");
        String Genre = scanNovel.next();

        System.out.println("\t NOVEL BERHASIL DITAMBAH");
        System.out.println("=====================================");
        System.out.println("Judul" + Judul);
        System.out.println("Penulis: " + Penulis);
        System.out.println("Harga: " + Harga);
        System.out.println("Genre: " + Genre);
        System.out.println("=====================================");


    
        String URL = "jdbc:mysql://localhost:3306/wongbookstore";
        String USER = "root";
        String PASSWORD = "";
        try {
            // Membuat koneksi ke database (ganti dengan informasi koneksi Anda)
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Query untuk menyimpan data pelanggan ke database
            String query = "INSERT INTO buku (judul, penulis, harga, keterangan) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Menyetel parameter query dengan nilai-nilai dari objek Pemesanan
            preparedStatement.setString(1, Judul);
            preparedStatement.setString(2, Penulis);
            preparedStatement.setInt(3, Harga);
            preparedStatement.setString(4,"Genre " + Genre);
           

            // Eksekusi query
            preparedStatement.executeUpdate();

            // Menutup koneksi
            preparedStatement.close();
            connection.close();

            System.out.println("Data Novel Berhasil Disimpan Ke Database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }    
    }

    public void updateNovel(){

        Scanner scanNovel2 = new Scanner(System.in);

        String URL = "jdbc:mysql://localhost:3306/wongbookstore";
        String USER = "root";
        String PASSWORD = "";
        System.out.println("");
        System.out.print("Masukkan Judul Yang Ingin Diupdate: ");
        String CariJudul = scanNovel2.next();

        try {
            // Membuat koneksi ke database (ganti dengan informasi koneksi Anda)
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Query untuk mencari data pelanggan berdasarkan nama
            String queryCari = "SELECT * FROM buku WHERE judul = ?";
            PreparedStatement preparedStatementCari = connection.prepareStatement(queryCari);
            preparedStatementCari.setString(1, CariJudul);

            // Eksekusi query pencarian
            ResultSet resultSet = preparedStatementCari.executeQuery();

            // Cek apakah data ditemukan
            if (resultSet.next()) {
                // Jika data ditemukan, tampilkan data lama dan minta input data baru
                String Judulb = resultSet.getString("judul");
                String Penulisb = resultSet.getString("penulis");
                Integer Hargab = resultSet.getInt("harga");
                String Genreb = resultSet.getString("keterangan");
            
                System.out.println("");
                System.out.println("Judul: " + Judulb);
                System.out.println("Penulis: " + Penulisb);
                System.out.println("Harga: " + Hargab);
                System.out.println("Genre: " + Genreb);
                System.out.println("");

                // Minta input data baru
                System.out.println("Masukkan Data Baru: ");

                // Input untuk setiap atribut yang diizinkan diubah
                System.out.println("Masukkan Harga Baru: ");
                Integer HargaBaru = scanNovel2.nextInt();

                // Query UPDATE untuk mengubah tanggal dan jam keberangkatan
                String queryUpdate = "UPDATE buku SET harga = ? WHERE judul = ?";
                PreparedStatement preparedStatementUpdate = connection.prepareStatement(queryUpdate);
                preparedStatementUpdate.setInt(1, HargaBaru);
                preparedStatementUpdate.setString(2, CariJudul);
            
                // Eksekusi query update
                preparedStatementUpdate.executeUpdate();

                System.out.println("Data Harga Berhasil Diupdate.");

                // Menutup koneksi
                preparedStatementCari.close();
                preparedStatementUpdate.close();
                connection.close();
            } else {
                System.out.println("Data Buku dengan Judul " + CariJudul + " tidak ditemukan.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void beliNovel(){

        Scanner scanNovel3 = new Scanner(System.in);

        String URL = "jdbc:mysql://localhost:3306/wongbookstore";
        String USER = "root";
        String PASSWORD = "";
        System.out.println("");
        System.out.print("Masukkan Judul Yang Ingin Dibeli: ");
        String CariJudul = scanNovel3.next();

        try {
            // Membuat koneksi ke database (ganti dengan informasi koneksi Anda)
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Query untuk mencari data pelanggan berdasarkan nama
            String queryCari = "SELECT * FROM buku WHERE judul = ?";
            PreparedStatement preparedStatementCari = connection.prepareStatement(queryCari);
            preparedStatementCari.setString(1, CariJudul);

            // Eksekusi query pencarian
            ResultSet resultSet = preparedStatementCari.executeQuery();

            // Cek apakah data ditemukan
            if (resultSet.next()) {
                // Jika data ditemukan, tampilkan data lama dan minta input data baru
                String Judulb = resultSet.getString("judul");
                String Penulisb = resultSet.getString("penulis");
                Integer Hargab = resultSet.getInt("harga");
                String Genreb = resultSet.getString("keterangan");
            
                System.out.println("");
                System.out.println("Judul: " + Judulb);
                System.out.println("Penulis: " + Penulisb);
                System.out.println("Harga: " + Hargab);
                System.out.println("Genre " + Genreb);
                System.out.println("");

                String queryHapus = "DELETE FROM buku WHERE judul = ?";
                PreparedStatement preparedStatementHapus = connection.prepareStatement(queryHapus);
                preparedStatementHapus.setString(1, CariJudul);

                preparedStatementHapus.executeUpdate();

                System.out.println("Pembelian Berhasil!");
                System.out.println("\tDETAIL PEMBELIAN");
                System.out.println("===================================");
                System.out.println("Judul: " + Judulb);
                System.out.println("Pengarang: " + Penulisb);
                System.out.println("Harga: " + Hargab);
                System.out.println("Keterangan: " + Genreb);
                Date tanggal = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd/MM/yyyy");
                String tanggalTransaksi = dateFormat.format(tanggal);
                System.out.println("Tanggal Pembelian: " + tanggal);
                System.out.println("===================================");
                
                } else {
                    System.out.println("Buku tidak Tersedia, Pembelian gagal");
                }
            // Menutup koneksi
            resultSet.close();
        preparedStatementCari.close();
        connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
