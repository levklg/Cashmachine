import java.util.*;

public class CassetteWithAcceptedNotes implements Command{

    private  final Deque<Deposit> listCassetteWithAcceptedNotes = new ArrayDeque<Deposit>() ;




    @Override
    public Map<Integer, Integer> withdraw(int expectedAmount) {

        return null;
    }

    @Override
    public void loadNotes(int nominal, int quantity) {

    }

    @Override
    public String deposit(int nominal, Integer amount) {
        listCassetteWithAcceptedNotes.add(new Deposit(nominal, amount));

        String str = "Deposit " + amount * nominal;
        return str  ;
    }


}
