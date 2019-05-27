package ru.job4j.bank;

import java.util.*;

public class Bank {

    Map<User, List<Account>> storage = new HashMap<>();

    public void addUser(User user) {
        storage.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        storage.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        storage.entrySet().stream()
                .filter(e -> e.getKey().getPassport()
                        .equals(passport))
                .findFirst()
                .map(Map.Entry::getValue)
                .ifPresent(accounts -> accounts.add(account));
    }

    public void deleteAccountFromUser(String passport, Account account) {
        storage.entrySet().stream()
                .filter(e -> e.getKey().getPassport()
                        .equals(passport))
                .findFirst()
                .map(Map.Entry::getValue)
                .ifPresent(accounts -> accounts.remove(account));

    }

    public List<Account> getUserAccounts(String passport) {
        return storage.entrySet().stream().filter(e -> e.getKey().getPassport().equals(passport))
                .findFirst().map(Map.Entry::getValue).orElse(new ArrayList<>());
    }

    public Account searchAccount(String passport, String requisite) {
        return storage.entrySet().stream()
                .filter(e -> e.getKey().getPassport().equals(passport))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(new ArrayList<>())
                .stream().filter(e -> e.getRequisites().equals(requisite)).findFirst()
                .orElse(null);
    }

    public boolean transferMoney(String userPassport, String requisite, String anotherPassport,
                                 String anotherRequisite, int money) {
        Account recipientAccount = searchAccount(anotherPassport, anotherRequisite);
        Account senderAccount = searchAccount(userPassport, requisite);
        boolean result = false;
        if ((senderAccount != null && recipientAccount != null && senderAccount.getValue() > money)) {
            recipientAccount.setValue(recipientAccount.getValue() + money);
            senderAccount.setValue(senderAccount.getValue() - money);
            result = true;
        }
        return result;
    }

    public Map<User, List<Account>> getStorage() {
        return storage;
    }
}
