package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static class Contact {
        String name;
        String number;

        public Contact (String name, String number) {
            this.name = name;
            this.number = number;
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("Шкоунік Єгов", "+380680425823"));
        contacts.add(new Contact("Женя Жменя", "+380931006936"));
        contacts.add(new Contact("Макс Макс", "+380971357947"));

        int uKey = 9;

        while (uKey != 0) {
            System.out.print("<== Menu ==>\n\n" +
                    "1. List\n" +
                    "2. New\n" +
                    "3. Remove\n" +
                    "0. Exit\n\n" +
                    "?: ");
            uKey = cin.nextInt();
            
            switch (uKey) {
                case 1: showList(contacts, ""); break;
                case 2: newContact(contacts, cin); break;
                case 3: removeContact(contacts, cin); break;
                case 0: return;
                default:
                    System.out.println("Wrong option!\n");
            }
        }
    }
    
    public static void showList(ArrayList<Contact> contacts, String message) {
        System.out.println("<== Contacts ==>\n");
        for (int i = 0; i < contacts.size(); i++)
            System.out.println((i + 1) + ". " + contacts.get(i).name + " " + contacts.get(i).number);
        System.out.print("\n" + message);
    }

    public static void newContact(ArrayList<Contact> contacts, Scanner cin) {
        System.out.print("\n<== New ==>\n\nName: ");
        String name = cin.next();
        System.out.print("Number: ");
        String number = cin.next();

        Contact newContact = new Contact(name, number);
        contacts.add(new Contact(name, number));
        System.out.println("\n <== Successful ==>\n");
    }

    public static void removeContact(ArrayList<Contact> contacts, Scanner cin) {
        showList(contacts, "Which one?: ");
        int uKey = cin.nextInt();

        if(uKey >= 1 && uKey <= contacts.size()) {
            contacts.remove(uKey - 1);
            System.out.println("\n <== Successful ==>\n");
        }
        else {
            System.out.println("\n <== Wrong index ==>\n");
        }
    }
}