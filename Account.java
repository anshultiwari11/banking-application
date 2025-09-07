public class Account {
    private int accNo;
    private String holderName;
    private double balance;
    private String email;
    private String phone;

    // constructor
    public Account(int accNo, String holderName, double balance, String email, String phone) {
        this.accNo = accNo;
        this.holderName = holderName;
        this.balance = balance;
        this.email = email;
        this.phone = phone;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposit done. New balance: " + balance);
        } else {
            System.out.println("Amount must be positive!");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw successful. Remaining balance: " + balance);
        } else if(amount > balance) {
            System.out.println("Not enough balance!");
        } else {
            System.out.println("Enter a valid amount!");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account No: " + accNo);
        System.out.println("Name: " + holderName);
        System.out.println("Balance: " + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
    }

    public void updateContactDetails(String email, String phone) {
        // simple validation
        if(email.contains("@") && phone.matches("\\d{10}")) {
            this.email = email;
            this.phone = phone;
            System.out.println("Contact updated.");
        } else {
            System.out.println("Invalid email or phone!");
        }
    }

    public int getAccNo() {
        return accNo;
    }
}
