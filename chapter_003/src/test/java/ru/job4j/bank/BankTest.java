package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    @Test
    public void whenTestTransferMoney() {
        Bank bank = new Bank();
        bank.addUser(new User("Victor", "1234 5678"));
        bank.addUser(new User("Alex", "1221 3443"));
        bank.addUser(new User("Petr", "5665 7887"));

        bank.addAccountToUser("1234 5678", new Account(100000, "12000"));
        bank.addAccountToUser("1234 5678", new Account(50000, "18000"));
        bank.addAccountToUser("1234 5678", new Account(10000, "6000"));

        bank.addAccountToUser("1221 3443", new Account(22000, "16000"));
        bank.addAccountToUser("1221 3443", new Account(500000, "4000"));

        bank.addAccountToUser("5665 7887", new Account(5000, "3000"));
        bank.addAccountToUser("5665 7887", new Account(300, "7800"));

        bank.transferMoney("1234 5678", "12000", "1221 3443", "16000", 50000);

        double resSubtract = bank.getStorage().get(new User("Victor", "1234 5678")).get(0).getValue();
        double resAdd = bank.getStorage().get(new User("Alex", "1221 3443")).get(0).getValue();

        assertThat(resSubtract, is(50000.0));
        assertThat(resAdd, is(72000.0));
    }
}
