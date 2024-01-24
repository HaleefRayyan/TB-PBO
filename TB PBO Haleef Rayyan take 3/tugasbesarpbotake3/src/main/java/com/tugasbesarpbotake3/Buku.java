package com.tugasbesarpbotake3;

public class Buku implements IMenu {
    String Judul;
    String Penulis;
    Integer Harga;

    public Buku(String Judul, String Penulis , Integer Harga) {
        this.Judul = Judul;
        this.Penulis = Penulis;
        this.Harga = Harga;
    }

    public Buku(){
    }


    @Override
    public void tampilkanMenu() {
        System.out.println("\nMenu:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Daftar Yang tersedia");
            System.out.println("3. Beli Buku");
            System.out.println("4. Update Buku");
            System.out.println("5. Keluar");

            System.out.print("Pilih menu (1/2/3/4/5): ");
    }
}
