package com.tavisca.workshops.pratham;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {

   /*     Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name please: ");

        String name;
        if((name = sc.nextLine()) != null)*/
            System.out.println(greet("Bibek BC", false, 19, "India"));
       /* else
            System.out.println("You must provide the name.");*/
    }

    public static String  greet(String name, boolean isMale, int age, String country){

        StringBuffer sb = new StringBuffer();
        switch(country){
            case "India":
                sb.append("Namaste ");
                break;
            case "Spaiin":
                sb.append("Hola");
                break;
            default:
                sb.append("Hello");
                break;
        }

        if(isMale && age < 18)
            sb.append("Master ");
        else if(isMale)
            sb.append("Mr. ");
        else
            sb.append("Mrs. ");

        sb.append(name);

        return sb.toString();
    }
}
