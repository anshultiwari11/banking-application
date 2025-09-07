public class Main {
    public static void main(String[] args) {
        // allow up to 50 accounts
        BankingApp app = new BankingApp(50);
        app.mainMenu();
    }
} 