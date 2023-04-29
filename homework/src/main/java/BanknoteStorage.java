import java.util.Set;

public interface BanknoteStorage {
        void deposit(Denomination denomination, int quantity);
        int withdraw(Denomination denomination, int quantity) throws Exception;
        int getBanknoteQuantity(Denomination denomination);
        Set<Denomination> getAvailableDenominations();

}


