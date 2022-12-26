package ru.job4j.collection;

import java.util.*;

public class BankService {

    private final Map<NUser, List<Acc>> users = new HashMap<>();

    public void addUser(NUser user) {
        users.putIfAbsent(user,  new ArrayList<Acc>());
    }

    public boolean deleteUser(String passport) {
        return users.remove(new NUser(passport, "")) != null;
    }

    public NUser findByPassport(String passport) {
        NUser res = null;
        for (NUser pasp : users.keySet()) {
            if (pasp.getPassport().equals(passport)) {
                res = pasp;
                break;
            }
        }
        return res;
    }

    public Acc findByRequisite(String passport, String requisite) {
        NUser user = findByPassport(passport);
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
        NUser user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(acc)) {
                users.get(user).add(acc);
            }
        }
    }

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

    public List<Acc> getAccounts(NUser user) {
        return users.get(user);
    }
}
