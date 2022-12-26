package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        NUser user = new NUser("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        NUser res = bank.findByPassport("3434");
        assertThat(res, is(user));
    }

    @Test
    public void deleteUserIsTrue() {
        NUser first = new NUser("3434", "Petr Arsentev");
        NUser second = new NUser("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(first);
        bank.addUser(second);
        assertTrue(bank.deleteUser("3434"));
    }

    @Test
    public void deleteUserIsFalse() {
        NUser first = new NUser("3434", "Petr Arsentev");
        NUser second = new NUser("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(first);
        bank.addUser(second);
        assertFalse(bank.deleteUser("343434"));
    }

    @Test
    public void whenEnterInvalidPassport() {
        NUser user = new NUser("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Acc("5546", 150D));
        Acc res = bank.findByRequisite("34", "5546");
        assertNull(res);
    }

    @Test
    public void addAccount() {
        NUser user = new NUser("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Acc("5546", 150D));
        double res = bank.findByRequisite("3434", "5546").getBalance();
        assertThat(res, is(150D));
    }

    @Test
    public void addDuplicateAccount() {
        NUser user = new NUser("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Acc("5546", 150D));
        bank.addAccount(user.getPassport(), new Acc("5546", 500D));
        int res = bank.getAccounts(user).size();
        assertThat(res, is(1));
    }

    @Test
    public void transferMoneyOk() {
        NUser user = new NUser("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Acc("5546", 150D));
        bank.addAccount(user.getPassport(), new Acc("113", 50D));
        bank.getAccounts(user);
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        double res = bank.findByRequisite(user.getPassport(), "113").getBalance();
        assertThat(res, is(200D));
    }

    @Test
    public void transferMoneySourceNull() {
        NUser user = new NUser("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Acc("5546", 150D));
        bank.addAccount(user.getPassport(), new Acc("113", 50D));
        bank.transferMoney(user.getPassport(), "554", user.getPassport(), "113", 150D);
        double res = bank.findByRequisite(user.getPassport(), "5546").getBalance();
        assertThat(res, is(150D));
    }

    @Test
    public void transferMoneyDontHaveEnoughMoney() {
        NUser user = new NUser("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Acc("5546", 150D));
        bank.addAccount(user.getPassport(), new Acc("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 300D);
        double res = bank.findByRequisite(user.getPassport(), "113").getBalance();
        assertThat(res, is(50D));
    }

    @Test
    public void transferMoneyDestinationIsNull() {
        NUser user = new NUser("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Acc("5546", 150D));
        bank.addAccount(user.getPassport(), new Acc("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "1131", 150D);
        double res = bank.findByRequisite(user.getPassport(), "5546").getBalance();
        assertThat(res, is(150D));
    }
}
