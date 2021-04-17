package testing;

import java.util.Scanner;

public class Driver{
//    public static void main(String[] args){
//        Patient patient = new Patient("12345");
//
//        patient.add("22532");
//        patient.add("22585");
//        patient.add("22103");
//        patient.add("63030");
//        patient.add("22844");
//        patient.add("20936");
//        patient.add("62287NC");
//        patient.add("22103");
//        patient.add("63081");
//        patient.print();
//
//    }
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter Patient ID: ");
        String id = keyboard.next();

        Patient patient = new Patient(id);
        String input;
        do{
            System.out.print("Enter command (add, remove, print, quit): ");
            input = keyboard.next().toLowerCase();
            System.out.println();

            if(input.equals("add")){
                do{
                    System.out.print("Enter CPT code: ");
                    input = keyboard.next().toUpperCase();

                    patient.add(input);
                } while (!(input.equals("DONE") || input.equals("QUIT")));
            }
            else if(input.equals("remove")){
                System.out.print("Enter CPT code to be removed: ");
                input = keyboard.next().toUpperCase();

                if(!input.equals("QUIT")){
                    patient.remove(input);
                }
            }
            else if(input.equals("print")){
                patient.print();
            }
        } while (!input.equals("quit"));
    }
}