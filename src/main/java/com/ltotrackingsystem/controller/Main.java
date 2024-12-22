package main.java.com.ltotrackingsystem.controller;

import java.util.Scanner;
import java.util.Optional;

import main.java.com.ltotrackingsystem.repository.UserRepositoryImplementation;
import main.java.com.ltotrackingsystem.model.User;

public class Main {
    
    private static void mainMenu() {
        UserRepositoryImplementation implementRepository = new UserRepositoryImplementation();
        
        if(implementRepository.readAll().isEmpty()){
            System.out.println("List empty.\n");
        }
        
        System.out.println("""
                           LTO LICENSE TRACKING SYSTEM
                           
                           1. Add User
                           2. Edit User
                           3. View User
                           4. Delete User
                           5. Exit""");
    }
    
    private static void selectedOption(int option) {
        UserRepositoryImplementation implementRepository = new UserRepositoryImplementation();
        Scanner sc = new Scanner(System.in);
        User newUser = new User();
        
        String confirm;
        
        switch(option) {
            case 1 -> {
                System.out.print("\nEnter last name: ");
                newUser.setLastName(sc.nextLine());
                
                System.out.print("Enter middle name (N/A if none): ");
                newUser.setMiddleName(sc.nextLine());
                
                System.out.print("Enter first name: ");
                newUser.setFirstName(sc.nextLine());
                
                System.out.print("Enter email: ");
                newUser.setEmail(sc.next());
                
                System.out.print("Enter phone number: ");
                newUser.setPhoneNumber(sc.next());
                
                System.out.print("Enter citizenship: ");
                newUser.setCitizenship(sc.next());
                
                System.out.print("Enter date of birth: ");
                sc.nextLine();
                newUser.setBirthdate(sc.nextLine());
                
                System.out.print("Enter gender: ");
                newUser.setGender(sc.next());
                
                System.out.print("Enter address: ");
                sc.nextLine();
                newUser.setAddress(sc.nextLine());
                
                System.out.print("Enter civil status: ");
                newUser.setCivilStatus(sc.next());
                
                System.out.print("Confirm? [y/n]: ");
                confirm = sc.next();
                
                if(confirm.equals("y")) {
                    implementRepository.create(newUser);
                } else {
                    System.out.println("Creation cancelled.");
                }
            }
            case 2 -> {
                System.out.print("\nEnter user id: ");
                newUser.setId(sc.nextInt());
                
                System.out.print("Enter new last name: ");
                newUser.setLastName(sc.nextLine());
                
                System.out.print("Confirm? [y/n]: ");
                confirm = sc.next();
                
                if(confirm.equals("y")) {
                    implementRepository.update(newUser);
                } else {
                    System.out.println("Update cancelled.");
                }
            }
            case 3 -> {
                System.out.print("\nEnter user id: ");
                newUser.setId(sc.nextInt());
                
                Optional<User> user = implementRepository.read(newUser.getId());
                user.ifPresent(u -> System.out.println("\nSelected user: " + u.getFirstName()));
            }
            case 4 -> {
                System.out.print("\nEnter user id to delete: ");
                newUser.setId(sc.nextInt());
                
                System.out.print("Confirm? [y/n]: ");
                confirm = sc.next();
                
                if(confirm.equals("y")) {
                    implementRepository.delete(newUser.getId());
                } else {
                    System.out.println("Update cancelled.");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        mainMenu();
        System.out.print("Enter option: ");
        int option = sc.nextInt();
        
        selectedOption(option);
    }
}