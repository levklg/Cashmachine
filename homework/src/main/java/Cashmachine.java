import java.util.Map;

public class Cashmachine  {

    private CassetteWithAcceptedNotes cassetteWithAcceptedNotes;
    private CassetteWithNotes cassetteWithNotes;

    public void loadNotes(int nominal, int quantity){

    this.cassetteWithNotes.loadNotes(nominal, quantity);
    }



    public void withdraw(int amount){

      Map<Integer, Integer> map = this.cassetteWithNotes.withdraw(amount);

      int totalsumma = 0;
        for (Map.Entry entry: map.entrySet()) {


            int nominal = (int) entry.getKey();
            int quantity = (int) entry.getValue();
            totalsumma = totalsumma + (nominal * quantity );
        }
        System.out.println("Withdraw " + totalsumma);
    }

    public  void deposit (int nominal, int amount){

        String str =  this.cassetteWithAcceptedNotes.deposit(nominal, amount);
        System.out.println(str);
    }


    public Cashmachine() {

        this.cassetteWithAcceptedNotes = new CassetteWithAcceptedNotes();
        this.cassetteWithNotes =new CassetteWithNotes();


    }

    public static void main(String[] args) {

        Cashmachine cashmachine = new Cashmachine();
        cashmachine.loadNotes(50, 100);
        cashmachine.loadNotes(100, 70);
        cashmachine.loadNotes(200, 50);
        cashmachine.loadNotes(500, 30);

        cashmachine.withdraw( 300);

        cashmachine.deposit(200, 2);




    }
}
