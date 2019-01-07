/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pektor;
import java.util.Iterator;  //     manggil Package dari java.util
import java.util.Scanner;   //     biar fungsi Scanner,Iterator,Vector bisa jalan
import java.util.Vector;    //     wajib hukumnya
/**
 *
 * @author XV-Clude
 */
public class Pektor {
    //inisialisasi Vektor sehabis class Pektor biar bisa diakses dimana aja,
    //kalo diinisialisasi pas main bakal error, jadi wajib ditaruh disini
    //Atribut private biar cuma bisa diakses dari class ini aja.
    //Atribut static biar variablenya cuma belongs specifically to this class
private static Vector<Vector<String>> patientdata = new Vector<Vector<String>>();
    public static void main(String[] args) {
    //Initialisasi dari Variabel yang mau dipake
    Scanner sc = new Scanner(System.in);
    String nama="",gender="",room="";
    int selection;
    int konter = 0;
    boolean exit = false;
    //End of Initialization
    
    //Loop biar selama boolean (1 atau 0) exit yang udah ditaro diawal itu false, 
    //kode ini terus diulang
    while (!exit) 
    {
    tampilanawal(); //Manggil fungsi tampilanawal di bawah
    selection = sc.nextInt();
    //Kode buat milih nomor 1,2,3
    switch (selection)
        {
        
    case 1 :
        Vector<String> patient = new Vector<String>();
        System.out.print("Input your name [starts with 'Mr.' or 'Mrs.']: ");
        sc = new Scanner(System.in);
        nama = sc.nextLine();
                // Mr\\.\\s+.* itu regex dimana cuma input 'Mr. <namaewa>'/'Mrs. <namaewa>' 
                //                                                         yang bisa lewat
        while (!nama.matches("Mr\\.\\s+.*") && !nama.matches("Mrs\\.\\s+.*")) {
            System.out.print("Input your name [starts with 'Mr.' or 'Mrs.']: ");
            nama = sc.nextLine();
            }
        
        patient.add(nama);
        System.out.print("Input your gender ['Male' or 'Female']: ");
        sc = new Scanner(System.in);
        gender = sc.nextLine();
        while (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female") ) {
            System.out.print("Input your gender ['Male' or 'Female']: ");
            gender = sc.nextLine();
            }
        
        patient.add(gender);
        System.out.print("Input your room type ['VIP' or 'Normal']: ");
        sc = new Scanner(System.in);
        room = sc.nextLine();
        while (!room.equals("VIP") && !room.equals("Normal") ) {
            System.out.print("Input your room type ['VIP' or 'Normal']: ");
            room = sc.nextLine(); // Th1is input is ignored
            }
        
        patient.add(room);
        patientdata.add(konter,patient);
        System.out.println(patientdata);
        konter++;
        System.out.println("Input has been Added !");     
        break;
        
    case 2 :
        if (1 > patientdata.size()){
            System.out.println("No Patient !"); 
        }
        else{
            showpatient(); //Manggil fungsi dibawah biar enak diliat
        // daripada nulis seabreg disini kayak :
//        String leftAlignFormat = "| %-3d | %-16s | %-8s | %-9s |%n";
//        System.out.format("+-----+------------------+----------+-----------+%n");
//        System.out.format("| No. |  Name            | Gender   | Room Type |%n");
//        System.out.format("+-----+------------------+----------+-----------+%n");
//        for (int i = 0; i < patientdata.size(); i++){
//                Vector inner = (Vector)patientdata.elementAt(i);
//    //        for (int j = 0; j < inner.size(); j++) {
//                String m = (String)inner.elementAt(0);
//                String n = (String)inner.elementAt(1);
//                String o = (String)inner.elementAt(2);
//                System.out.format(leftAlignFormat,i,m,n,o);
////        }
//    }
////        for (int i = 0; i < patientdata.size(); i++){
////             System.out.println(patientdata.get(i));
////    }
//        System.out.format("+-----+------------------+----------+-----------+%n");
        }       
        break;
        
    case 3 : 
        System.out.println("-^ Thanks for using this program ... ^-"); 
        exit = true; //EXIT APLIKASI
        break;

    }
    //Akhir dari Kode buat milih nomor 1,2,3
  }
}
    private static void showpatient(){
        String leftAlignFormat = "| %-3d | %-16s | %-8s | %-9s |%n";
        System.out.format("+-----+------------------+----------+-----------+%n");
        System.out.format("| No. |  Name            | Gender   | Room Type |%n");
        System.out.format("+-----+------------------+----------+-----------+%n");
        for (int i = 0; i < patientdata.size(); i++){
                Vector inner = (Vector)patientdata.elementAt(i);
    //        for (int j = 0; j < inner.size(); j++) {
                String m = (String)inner.elementAt(0);
                String n = (String)inner.elementAt(1);
                String o = (String)inner.elementAt(2);
                System.out.format(leftAlignFormat,i,m,n,o);
//        }
    }
//        for (int i = 0; i < patientdata.size(); i++){
//             System.out.println(patientdata.get(i));
//    }
        System.out.format("+-----+------------------+----------+-----------+%n");
    }
    private static void tampilanawal(){
        System.out.println(String.format("%-20s", "===============" , "%-20s"));
        System.out.println(String.format("%-20s", ": BJ Hospital :" , "%-20s"));
        System.out.println(String.format("%-20s", "===============" , "%-20s"));
        System.out.println("1. Add Patient");
        System.out.println("2. View Patient");
        System.out.println("3. Exit");
        System.out.print("Choose >> ");
    }
}
