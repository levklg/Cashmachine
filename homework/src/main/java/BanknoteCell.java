public class BanknoteCell {
    private final Denomination denomination;
    private int quantity;

    public BanknoteCell(Denomination denomination, int initialQuantity) {
        this.denomination = denomination;
        this.quantity = initialQuantity;
    }

    public void deposit(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Количество банкнот не может быть отрицательным");
        }
        this.quantity += quantity;
    }

    public int withdraw(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Количество банкнот не может быть отрицательным");
        }
        if (this.quantity < quantity) {
            throw new IllegalArgumentException("Недостаточное количество банкнот данного номинала в ячейке");
        }
        this.quantity -= quantity;
        return quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    @Override
    public String toString() {
        return "BanknoteCell { denomination: " + denomination + ", quantity: " + quantity + " }";
    }
}
