import java.util.*;
// Класс реализует интерфейс BanknoteStorage в соответствии с принципами SOLID
public class CMBanknoteStorage implements BanknoteStorage {

    private Map<Denomination, BanknoteCell> cells;

    public CMBanknoteStorage() {
        cells = new HashMap<>();
        for (Denomination denomination : Denomination.values()) {
            cells.put(denomination, new BanknoteCell(denomination, 0));
        }
    }

    @Override
    public void deposit(Denomination denomination, int quantity) {
        BanknoteCell cell = cells.get(denomination);
        cell.deposit(quantity);
    }

    @Override
    public int withdraw(Denomination denomination, int quantity) {
        BanknoteCell cell = cells.get(denomination);
        return cell.withdraw(quantity);
    }

    @Override
    public int getBanknoteQuantity(Denomination denomination) {
        BanknoteCell cell = cells.get(denomination);
        return cell.getQuantity();
    }

    @Override
    public Set<Denomination> getAvailableDenominations() {
        return EnumSet.allOf(Denomination.class);
    }
}
