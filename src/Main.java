import com.bankApp.entity.Account;
import com.bankApp.exception.AccountNotFoundException;
import com.bankApp.exception.InsufficientBalanceException;
import com.bankApp.service.BankService;

import java.util.Scanner;

public class Main {

    static int mainId= 220100167;
    static BankService service = new BankService();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choice = 0;

        while (choice!=6){
            System.out.println("______________________ Welcome to Student bank ______________________");
            System.out.println("""
                    Enter for following services:
                    1. Create account
                    2. Get Balance
                    3. Deposit
                    4. Withdraw
                    5. Remove Account
                    6. Exit
                    Enter your choice : 
                    """);
            choice = sc.nextInt();
            switch (choice){
                case 1:createAccount();
                    break;
                case 2:getBalance();
                    break;
                case 3:deposit();
                    break;
                case 4:withdraw();
                    break;
                case 5:removeAccount();
                    break;
                case 6:
                    System.out.println("Thank you for using this app!");
                    break;
                default:
                    System.out.println("Enter a valid option");
            }
        }
        sc.close();
    }

    static int generateId(){
        return mainId++;
    }
    public static void createAccount(){
        System.out.println("Enter name : ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Enter phone number : ");
        String phoneNum = sc.nextLine();
        System.out.println("Enter default amount in account : ");
        double balance = sc.nextDouble();
        System.out.println("Enter Account type (Saving/Current): ");
        String accountType = sc.next();
        sc.nextLine();
        System.out.println("Enter your address : ");
        String address = sc.nextLine();
        Account currAcc = new Account();

        currAcc.setBalance(balance);
        currAcc.setAccountType(accountType);
        currAcc.setAddress(address);
        currAcc.setName(name);
        currAcc.setPhoneNo(phoneNum);

        service.createAccount(currAcc);

        System.out.println("Account creation successfully\n"); // a person can have mul accounts
        System.out.println();
        System.out.println("_____________ Your Account details _____________");
        System.out.println(currAcc);
        System.out.println();
    }
    public static void getBalance(){
        System.out.println("Enter account id : ");
        try{
        double balance = service.getBalance(sc.nextInt());
        System.out.println("Your current balance : "+balance+"\n");
        }catch (AccountNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void deposit(){
        System.out.println("Enter account id : ");
        int id = sc.nextInt();
        System.out.println("Enter amount to add : ");
        double balance = sc.nextDouble();
        try {
            service.deposit(balance, id);
            System.out.println("Balance updated successfully");
            System.out.println("Your current balance : "+service.getBalance(id)+"\n");
        }catch (AccountNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void withdraw(){
        System.out.println("Enter account id : ");
        int id = sc.nextInt();
        System.out.println("Enter amount to withdraw : ");
        double balance = sc.nextDouble();
        try{
        service.withdraw(balance,id);
            System.out.println("Withdraw of :"+balance+" is successful\n");
        }catch (AccountNotFoundException | InsufficientBalanceException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void removeAccount(){
        System.out.println("Enter account id : ");
        int id = sc.nextInt();
        try {
            service.removeAccount(id);
            System.out.println("Account deletion successful!\n");
        }catch (AccountNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }
}