import java.util.Map;

public interface Command {

    Map<Integer,Integer> withdraw(int expectedAmount);

    void loadNotes(int nominal, int quantity);

    String deposit(int nominal,Integer amount);


}
