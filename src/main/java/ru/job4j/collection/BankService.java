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
        if (users.containsKey(findByPassport(passport))) {
            for (Acc req : users.get(findByPassport(passport))) {
                if (requisite.equals(req.getRequisite())) {
                    return req;
                }
            }
        }
        return null;
    }

    public void addAccount(String passport, Acc acc) {
        boolean rsl = true;
        for (Acc req : users.get(findByPassport(passport))) {
            if (acc.getRequisite().equals(req.getRequisite())) {
                rsl = false;
                break;
            }
        }
        if (rsl) {
            users.get(findByPassport(passport)).add(acc);
        }
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                          String destPassport, String destRequisite, double amount) {
        boolean rsl = true;
        if (users.get(findByPassport(srcPassport)).contains(findByRequisite(srcPassport, srcRequisite))
                && users.get(findByPassport(destPassport)).contains(findByRequisite(destPassport, destRequisite))) {
            for (Acc el : users.get(findByPassport(srcPassport))) {
                if (el.getRequisite().equals(srcRequisite)) {
                if (el.getBalance() - amount >= 0) {
                    el.setBalance(el.getBalance() - amount);
                } else {
                    rsl = false;
                }
                break;
                }
            }
            if (rsl) {
                for (Acc accs : users.get(findByPassport(destPassport))) {
                    if (accs.getRequisite().equals(destRequisite)) {
                        accs.setBalance(accs.getBalance() + amount);
                        break;
                    }
                }
            }
    } else {
            rsl = false;
        }
        return rsl;
    }

    public List<Acc> getAccounts(User user) {
        return users.get(user);
    }
}
