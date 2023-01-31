package ru.job4j.collection;

import java.util.*;

/**
 * Класс описывает работу банковского сервиса, работающий с клиентами и их аккаунтами.
 * @author Danyukovas VITALY.
 * @version 4.0
 */
public class BankService {

    /**
     * Хранение всех клиентов осуществляется в карте типа HashMap.
     */
    private final Map<NUser, List<Acc>> users = new HashMap<>();

    /**
     * Метод принимает на вход клиента, после чего добавляет его в нашу карту.
     * Если такой клиент уже существует, клиент добавлен не будет.
     * @param user клиент, добавляемый в карту.
     */
    public void addUser(NUser user) {
        users.putIfAbsent(user,  new ArrayList<Acc>());
    }

    /**
     * Метод принимает на вход номер паспорта,
     * после чего удаляет пользователя с таким паспортом из нашей карты.
     * @param passport номер паспорта, по которому удаляют пользователя.
     */
    public boolean deleteUser(String passport) {
        return users.remove(new NUser(passport, "")) != null;
    }

    /**
     * Метод находит пользователя по номеру принимаемого паспорта.
     * @param passport номер паспорта, по которому ищут пользователя.
     */
    public NUser findByPassport(String passport) {
        return users.keySet().stream()
                .filter(p -> p.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод находит пользователя по номеру паспорта и номеру реквизита.
     * @param passport номер паспорта, по которому ищут пользователя.
     * @param requisite номер реквизита, по которому ищут пользователя.
     */
    public Acc findByRequisite(String passport, String requisite) {
        NUser user = findByPassport(passport);
        if (user != null) {
            return users.get(user).stream()
                    .filter(acc -> acc.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод добавляет аккаунт пользователю по номеру паспорта.
     * @param passport номер паспорта, по которому добавляют аккаунт.
     * @param acc аккаунт, который добавляют пользователю.
     */
    public void addAccount(String passport, Acc acc) {
        NUser user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(acc)) {
                users.get(user).add(acc);
            }
        }
    }

    /**
     * Метод, который позволяет переводить деньги с одного аккаунта на другой.
     * Если денег на аккаунте не хватает для перевода, деньги не снимутся и не добавятся.
     * @param srcPassport номер паспорта пользователя аккаунта, с которого переводят деньги.
     * @param destPassport номер паспорта пользователя аккаунта, на который переводят деньги.
     * @param srcRequisite номер реквизита аккаунта, с которого переводят деньги.
     * @param destRequisite номер реквизита аккаунта, на который переводят деньги.
     * @param amount сумма перевода.
     * @return возвращает удачно или неудачно был произведен перевод.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                          String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Acc srcAcc = findByRequisite(srcPassport, srcRequisite);
        Acc desAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null && desAcc != null && srcAcc.getBalance() >= amount) {
                srcAcc.setBalance(srcAcc.getBalance() - amount);
                desAcc.setBalance(desAcc.getBalance() + amount);
                rsl = true;
        }
        return rsl;
    }

    /**
     * Метод возвращает все аккаунты, принадлежащую клиенту.
     * @param user клиент, владеющий аккаунтами.
     * @return Возвращает коллекцию аккаунтов типа List.
     */
    public List<Acc> getAccounts(NUser user) {
        return users.get(user);
    }
}
