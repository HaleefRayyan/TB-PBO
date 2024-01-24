package com.tugasbesarpbotake3;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Majalah forb = new Majalah();
        Novel Sampai = new Novel();
        BankSoal UASPBO = new BankSoal();
        Buku show = new Buku();

        boolean walawe = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!walawe) {
            show.tampilkanMenu();
            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Membersihkan buffer

            switch (pilihan) {
                case 1: 
                    Scanner case1 = new Scanner(System.in);
                    
                    System.out.println("1. Majalah");
                    System.out.println("2. Novel");
                    System.out.println("3. Bank Soal");
                    System.out.println("4. Keluar");
                    int choice = case1.nextInt();
                    if (choice==1) {
                        forb.TambahkanMajalah();
                    } else if (choice==2){
                        Sampai.TambahkanNovel();
                    } else if(choice==3){
                        UASPBO.TambahkanBankSoal();
                    } else if(choice==4){
                        System.exit(0);
                    }
                    break;
                case 2:
                    Scanner case2 = new Scanner(System.in);
                    System.out.println("Majalah");
                    System.out.println("Novel");
                    System.out.println("Bank Soal");
                    System.out.println("4. -Exit-");
                    int choice2 = case2.nextInt();
                    if (choice2==4){
                        System.exit(0);
                    } else {
                        System.exit(0);
                    }
                    break;
                case 3:
                    Scanner case3 = new Scanner(System.in);
                    
                    System.out.println("1. Majalah");
                    System.out.println("2. Novel");
                    System.out.println("3. Bank Soal");
                    System.out.println("4. Exit");
                    int choice3 = case3.nextInt();
                    if (choice3==1) {
                        forb.beliMajalah();
                    } else if (choice3==2){
                        Sampai.beliNovel();
                    } else if(choice3==3){
                        UASPBO.beliBankSoal();
                    } else if(choice3==4){
                        System.exit(0);
                    }
                    break;
                case 4:
                    Scanner case4 = new Scanner(System.in);
                    
                    System.out.println("1. Majalah");
                    System.out.println("2. Novel");
                    System.out.println("3. Bank Soal");
                    System.out.println("4. Exit");
                    int choice4 = case4.nextInt();
                    if (choice4==1) {
                        forb.updateMajalah();
                    } else if (choice4==2){
                        Sampai.updateNovel();
                    } else if(choice4==3){
                        UASPBO.updateBankSoal();
                    } else if(choice4==4){
                        System.exit(0);
                    }
                    break;
                case 5:
                    System.out.println("Terima kasih! Keluar dari program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1, 2, 3, 4, atau 5.");
            }
        }
    }
}    