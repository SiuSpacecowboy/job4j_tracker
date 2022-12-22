package ru.job4j.collection;

import java.util.*;

public class BankService {

    private final Map<User, List<Acc>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user,  new ArrayList<Acc>());
    }

    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    public User findByPassport(String passport) {
        User res = null;
        for (User pasp : users.keySet()) {
            if (pasp.getPassport().equals(passport)) {
                res = pasp;
                break;
            }
        }
        return res;
    }

    public Acc findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Acc req : users.get(user)) {
                if (requisite.equals(req.getRequisite())) {
                    return req;
                }
            }
        }
        return null;
    }

    public void addAccount(String passport, Acc acc) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(acc)) {
                users.get(user).add(acc);
            }
        }
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                          String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        User srcUser = findByPassport(srcPassport);
        User desUser = findByPassport(destPassport);
        Acc srcAcc = findByRequisite(srcPassport, srcRequisite);
        Acc desAcc = findByRequisite(destPassport, destRequisite);
        if (users.get(srcUser).contains(srcAcc) && users.get(desUser).contains(desAcc)) {
            for (Acc req : users.get(srcUser)) {
                if (req.equals(srcAcc) && srcAcc.getBalance() < amount) {
                    req.setBalance(srcAcc.getBalance() - amount);
                    break;
                }
            }
            if (srcAcc.getBalance() >= amount) {
                for (Acc req : users.get(desUser)) {
                    if (req.equals(desAcc)) {
                        req.setBalance(req.getBalance() + amount);
                        rsl = true;
                        break;
                    }
                }
            }
        }
        return rsl;
    }

    public List<Acc> getAccounts(User user) {
        return users.get(user);
    }
}
