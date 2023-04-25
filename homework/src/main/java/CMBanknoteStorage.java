import java.util.*;
// Класс реализует интерфейс BanknoteStorage в соответствии с принципами SOLID
public class CMBanknoteStorage implements BanknoteStorage {

    private Map<Integer, Integer> cashStorage;

public CMBanknoteStorage(){
        cashStorage = new HashMap<>();
        initializeCashStorage();
    }

    private void initializeCashStorage() {
        int[] denominations = new int[]{50, 100, 200, 500, 1000, 2000, 5000};
        for (int denomination : denominations) {
            cashStorage.put(denomination, 0);
        }
    }

    @Override
    public void deposit(int denomination, int quantity) {
        cashStorage.put(denomination, cashStorage.get(denomination) + quantity);
    }

    @Override
    public int withdraw(int denomination, int quantity) throws Exception {
        int availableQuantity = cashStorage.get(denomination);
        if (availableQuantity < quantity) {
            throw new Exception("Недостаточное количество банкнот данного номинала");
        }

        cashStorage.put(denomination, availableQuantity - quantity);
        return quantity;
    }

    @Override
    public int getBanknoteQuantity(int denomination) {
        return cashStorage.get(denomination);
    }
    @Override
    public Set<Integer> getAvailableDenominations() {
        return cashStorage.keySet();
    }

}
