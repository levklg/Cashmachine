import java.util.List;

public interface CashmachineInterface {
    void deposit(List<Banknote> banknotes);
    List<Banknote> withdraw(int amount) throws IllegalArgumentException;
    int getBalance();
}
