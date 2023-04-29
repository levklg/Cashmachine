import java.util.ArrayList;
import java.util.List;
// Класс имеет функциональность принятия банкнот и выдачи денег
public class Cashmachine implements CashmachineInterface {
    private BanknoteStorage banknoteStorageCashMashine;

    public Cashmachine(BanknoteStorage banknoteStorageCashMashine) {
        this.banknoteStorageCashMashine = banknoteStorageCashMashine;
    }
@Override
    public void deposit(List<Banknote> banknotes) {
        for (Banknote banknote : banknotes) {
            Denomination denomination = banknote.getDenomination();
            banknoteStorageCashMashine.deposit(denomination, 1);
        }
    }
@Override
    public List<Banknote> withdraw(int amount) throws IllegalArgumentException {
        List<Banknote> withdrawnBanknotes = new ArrayList<>();
        int remainingAmount = amount;

        for (Denomination denomination : banknoteStorageCashMashine.getAvailableDenominations()) {
            int banknoteQuantity = banknoteStorageCashMashine.getBanknoteQuantity(denomination);
            while (remainingAmount >= denomination.getValue() && banknoteQuantity > 0) {
                remainingAmount -= denomination.getValue();
                try {
                    banknoteStorageCashMashine.withdraw(denomination, 1);
                } catch (Exception e) {
                    deposit(withdrawnBanknotes);
                    throw new IllegalArgumentException("Невозможно выдать запрашиваемую сумму", e);
                }
                withdrawnBanknotes.add(new Banknote(denomination));
                banknoteQuantity--;
            }
        }

        if (remainingAmount > 0) {
            deposit(withdrawnBanknotes);
            throw new IllegalArgumentException("Невозможно выдать запрашиваемую сумму");
        }

        return withdrawnBanknotes;
    }

@Override
    public int getBalance() {
        int balance = 0;
        for (Denomination denomination : banknoteStorageCashMashine.getAvailableDenominations()) {
            balance += denomination.getValue() * banknoteStorageCashMashine.getBanknoteQuantity(denomination);
        }
        return balance;
    }
}
