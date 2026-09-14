package atm;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();

        // Sample accounts
        accounts.add(
                new Account(
                        "1001",
                        "Vamshi",
                        1234,
                        10000.00
                )
        );

        accounts.add(
                new Account(
                        "1002",
                        "Rahul",
                        2345,
                        8000.00
                )
        );

        accounts.add(
                new Account(
                        "1003",
                        "Suresh",
                        3456,
                        15000.00
                )
        );
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccount(String accountId) {

        for (Account account : accounts) {

            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }

        return null;
    }

    public Account authenticate(String accountId, int pin) {

        Account account = findAccount(accountId);

        if (account != null && account.getPin() == pin) {
            return account;
        }

        return null;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}