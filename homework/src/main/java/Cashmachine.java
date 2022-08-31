import java.util.Map;

public class Cashmachine  implements Command{

    private CassetteWithAcceptedNotes cassetteWithAcceptedNotes;
    private CassetteWithNotes cassetteWithNotes;

    public Cashmachine() {

        this.cassetteWithAcceptedNotes = new CassetteWithAcceptedNotes();
        this.cassetteWithNotes = new CassetteWithNotes();


    }

    @Override
    public Map<Integer, Integer> withdraw(int expectedAmount) {
        return null;
    }

    @Override
    public void loadNotes(int nominal, int quantity) {

        this.cassetteWithNotes.loadNotes(nominal, quantity);
    }

    @Override
    public String deposit(int nominal, Integer amount) {
        return  this.cassetteWithAcceptedNotes.deposit(nominal, amount);
    }

    public void withdrawEx(int amount) {

        Map<Integer, Integer> map = this.cassetteWithNotes.withdraw(amount);

        int totalsumma = 0;
        for (Map.Entry entry : map.entrySet()) {


            int nominal = (int) entry.getKey();
            int quantity = (int) entry.getValue();
            totalsumma = totalsumma + (nominal * quantity);
        }
        System.out.println("Withdraw " + totalsumma);
    }



}
