package bankAccount;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] command = input.split("\\s+");

            String output = "";
            switch (command[0]){
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccounts.put(bankAccount.getId(), bankAccount);
                    output = String.format("Account ID%d created", bankAccount.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(command[1]);
                    int amount = Integer.parseInt(command[2]);
                    if (bankAccounts.containsKey(id)){
                        bankAccounts.get(id).deposit(amount);
                        output = String.format("Deposited %d to ID%d", amount, id);
                    } else {
                        output = String.format("Account does not exist");
                    }

                    break;
                case "GetInterest":
                    id = Integer.parseInt(command[1]);
                    int years = Integer.parseInt(command[2]);
                    if (bankAccounts.containsKey(id)) {
                        double interest = bankAccounts.get(id).getInterest(years);
                        output = String.format("%.2f", interest);
                    } else {
                        output = String.format("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double newInterest = Double.parseDouble(command[1]);
                    BankAccount.setInterestRate(newInterest);
                    break;

            }
            if (!output.isEmpty()) {
                System.out.println(output);
            }
            input = scanner.nextLine();
        }
    }
}
