import java.util.Scanner;
import java.util.*;
class account{
    static  void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name :");
        ATM.name=sc.nextLine();
        System.out.println("Enter username :");
        String user=sc.nextLine();
        System.out.println("Enter password :");
        String pass=sc.nextLine();
        System.out.println("Enter Account number :");
        ATM.accnumber=sc.nextLine();
        System.out.println("REGISTRATION SUCCESSFULL!");
        ATM.prompt();
        while(true){
            display(ATM.name);
            int choice=sc.nextInt();
            if(choice==1){
                login(user,pass);
                break;
            }
            else {
                if(choice==2){
                    System.exit(0);
                }
                else{
                    System.out.println("Invalid option! Enter again!");
                }
            }
        }
    }
    static void display(String name){}
    static void login(String user,String pass){}
}
class transaction{
    static void withdraw(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter amount you want to withdraw :");
        int WithdrawCash=sc.nextInt();
        if(WithdrawCash<=ATM.balance){
            ATM.balance=ATM.balance-WithdrawCash;
            ATM.history.add(Integer.toString(WithdrawCash));
            ATM.history.add("Withdraw");
            System.out.println("Amount Rs"+WithdrawCash+"/-withdraw successfully");
        
        }
        else{
            System.out.println("insufficient balance to withdraw the cash");
        
        }
        ATM.prompt();
    }
    static void deposit(){
        Scanner sc=new Scanner(System.in);
    
        System.out.print("Enter amount to deposit :");
        int DepositCash=sc.nextInt();
        ATM.updatebalance(DepositCash);
        ATM.history.add(Integer.toString(DepositCash));
        ATM.history.add("Deposit");
        System.out.println("Amount Rs."+DepositCash+"/- deposit successful!");
    
        ATM.prompt();
    }
    static void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the account number of the receiving body");
        int anumber=sc.nextInt();
        System.out.println("Enter the amount to be transferred :");
        int TransferCash=sc.nextInt();
        if(TransferCash<=ATM.balance){
            ATM.balance=ATM.balance-TransferCash;
            ATM.history.add(Integer.toString(TransferCash));
            ATM.history.add("Transferred");
            System.out.println("Transferred successfully");
        
        }
        else{
            System.out.println("insufficient balance!");
        
        }
    }
}
class check{
    static void checkbalance(){
        
        System.out.println("The available balance in your account :");
        ATM.showbalance();
    
        ATM.prompt();
    }
}
class his{
    static void transactionhistory(){
            
            System.out.println("Transaction History :");
            int k=0;
            if(ATM.balance>0){
            for(int i=0;i<(ATM.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.print(ATM.history.get(k)+" ");
                    k++;
                }
                
            }
            }
            else {
                System.out.println("your account is empty");
            }
            ATM.prompt();
    }
}
public class ATM {
    public static String name;
    public static int balance=0;
    public static String accnumber;
    public static ArrayList<String> history=new ArrayList<String>();

    static void updatebalance(int DepositCash){
        balance=balance+DepositCash;
    }
    static void showbalance(){
        System.out.println(balance);
    }
    public static void home(){
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME TO ATM INTERFACE");
        System.out.println("--------------------------");
        System.out.println("select option :");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.println("Enter choice...(1/2)");
        int choice =sc.nextInt();
        if (choice==1){
                account.register();
        }
        else {
            if(choice==2){
                System.exit(0);
            }
            else{
                System.out.println("Invalid Selection..!");
                home();
            }
        }
    }
    static void prompt(){
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME "+ATM.name+"! TO ATM SYSTEM");
        System.out.println("---------------------");
        System.out.println("Select option : ");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Check balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice : ");
        
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                transaction.withdraw();
            case 2:
                transaction.deposit();
            case 3:
                transaction.transfer();
            case 4:
                check.checkbalance();
            case 5:
                his.transactionhistory();
            case 6:
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        home();
    }
}