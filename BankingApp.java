import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingApp {
    private Account[] accounts;
    private int totalAcc;
    private Scanner sc;

    public BankingApp(int size) {
        accounts = new Account[size];
        totalAcc = 0;
        sc = new Scanner(System.in);
    }

    public void createAccount() {
        try {
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter opening balance: ");
            double bal = sc.nextDouble();
            sc.nextLine(); // eat newline

            System.out.print("Enter email: ");
            String email = sc.nextLine();

            System.out.print("Enter phone: ");
            String phone = sc.nextLine();

            // validate email + phone
            if(!email.contains("@")) {
                System.out.println("Invalid email format!");
                return;
            }
            if(!phone.matches("\\d{10}")) {
                System.out.println("Phone must be 10 digits!");
                return;
            }

            if(bal < 0) {
                System.out.println("Opening balance must be positive!");
                return;
            }

            int accNum = 1000 + totalAcc + 1;
            accounts[totalAcc++] = new Account(accNum, name, bal, email, phone);

            System.out.println("Account created! Your acc no is " + accNum);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numbers where required.");
            sc.nextLine(); // clear wrong input
        }
    }

    private Account findAccount(int accNum) {
        for(int i=0; i<totalAcc; i++) {
            if(accounts[i].getAccNo() == accNum) {
                return accounts[i];
            }
        }
        return null;
    }

    public void performDeposit() {
        try {
            System.out.print("Enter acc no: ");
            int num = sc.nextInt();
            System.out.print("Enter amount: ");
            double amt = sc.nextDouble();
            sc.nextLine();

            Account acc = findAccount(num);
            if(acc != null) {
                acc.deposit(amt);
            } else {
                System.out.println("Account not found!");
            }
        } catch(InputMismatchException e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    public void performWithdrawal() {
        try {
            System.out.print("Enter acc no: ");
            int num = sc.nextInt();
            System.out.print("Enter amount: ");
            double amt = sc.nextDouble();
            sc.nextLine();

            Account acc = findAccount(num);
            if(acc != null) {
                acc.withdraw(amt);
            } else {
                System.out.println("Account not found!");
            }
        } catch(InputMismatchException e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    public void showAccountDetails() {
        try {
            System.out.print("Enter acc no: ");
            int num = sc.nextInt();
            sc.nextLine();

            Account acc = findAccount(num);
            if(acc != null) {
                acc.displayAccountDetails();
            } else {
                System.out.println("Account not found!");
            }
        } catch(InputMismatchException e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    public void updateContact() {
        try {
            System.out.print("Enter acc no: ");
            int num = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter new email: ");
            String email = sc.nextLine();
            System.out.print("Enter new phone: ");
            String phone = sc.nextLine();

            Account acc = findAccount(num);
            if(acc != null) {
                acc.updateContactDetails(email, phone);
            } else {
                System.out.println("Account not found!");
            }
        } catch(InputMismatchException e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    public void mainMenu() {
        while(true) {
            System.out.println("\n*** Banking Menu ***");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Account");
            System.out.println("5. Update Contact");
            System.out.println("6. Exit");
            System.out.print("Choice: ");

            try {
                int ch = sc.nextInt();
                sc.nextLine();

                switch(ch) {
                    case 1: createAccount(); break;
                    case 2: performDeposit(); break;
                    case 3: performWithdrawal(); break;
                    case 4: showAccountDetails(); break;
                    case 5: updateContact(); break;
                    case 6: System.out.println("Goodbye!"); return;
                    default: System.out.println("Wrong choice!");
                }
            } catch(InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine(); // clear wrong input
            }
        }
    }
}
