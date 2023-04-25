import java.util.ArrayList;
import java.util.List;
// Класс имеет функциональность принятия банкнот и выдачи денег
public class Cashmachine {
    private BanknoteStorage banknoteStorageCashMashine;

    public Cashmachine(BanknoteStorage banknoteStorageCashMashine) {
        this.banknoteStorageCashMashine = banknoteStorageCashMashine;
    }
    public void deposit(List<Banknote> banknotes) {
        for (Banknote banknote : banknotes) {
            int denomination = banknote.getDenomination();
            banknoteStorageCashMashine.deposit(denomination, 1);
        }
    }

    public List<Banknote> withdraw(int amount) throws Exception {
        List<Banknote> withdrawnBanknotes = new ArrayList<>();

        for (int denomination : banknoteStorageCashMashine.getAvailableDenominations()) {
            while (amount >= denomination && banknoteStorageCashMashine.getBanknoteQuantity(denomination) > 0) {
                amount -= denomination;
                banknoteStorageCashMashine.withdraw(denomination, 1);
                withdrawnBanknotes.add(new Banknote(denomination));
            }
        }

        if (amount > 0) {
            deposit(withdrawnBanknotes);
            throw new Exception("Невозможно выдать запрашиваемую сумму");
        }

        return withdrawnBanknotes;
    }

    public int getBalance() {
        int balance = 0;
        for (int denomination : banknoteStorageCashMashine.getAvailableDenominations()) {
            balance += denomination * banknoteStorageCashMashine.getBanknoteQuantity(denomination);
        }
        return balance;
    }
}

