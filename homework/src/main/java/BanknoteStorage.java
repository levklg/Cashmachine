import java.util.Set;

public interface BanknoteStorage {
    void deposit(int denomination, int quantity);
    int withdraw(int denomination, int quantity) throws Exception;
    int getBanknoteQuantity(int denomination);
    Set<Integer> getAvailableDenominations();
}


