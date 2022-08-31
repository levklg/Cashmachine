public class Deposit {
    private int nominal;
    private int amount;


    public Deposit(int nominal, int amount) {
        this.nominal = nominal;
        this.amount = amount;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
