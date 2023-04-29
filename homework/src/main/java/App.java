
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        BanknoteStorage banknoteStorage = new CMBanknoteStorage();
        Cashmachine cashmachine = new Cashmachine(banknoteStorage);

        // Создаем список из 5 банкнот по 100 рублей
        List<Banknote> banknotes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            banknotes.add(new Banknote(Denomination.HUNDRED));
        }
        // Создаем список из 10 банкнот по 50 рублей
        for (int i = 0; i < 10; i++) {
            banknotes.add(new Banknote(Denomination.FIFTY));
        }
        // Создаем список из 3 банкнот по 200 рублей
        for (int i = 0; i < 3; i++) {
            banknotes.add(new Banknote(Denomination.TWO_HUNDRED));
        }
        // Создаем список из 1 банкнот по 500 рублей
        for (int i = 0; i < 1; i++) {
            banknotes.add(new Banknote(Denomination.FIVE_HUNDRED));
        }

        // Вносим банкноты в банкомат
        cashmachine.deposit(banknotes);

        //код для снятия суммы
        try {
            List<Banknote> withdrawnBanknotes = cashmachine.withdraw(700);
            System.out.println("Снято " + withdrawnBanknotes.size() + " банкнот(ы):");
            for (Banknote banknote : withdrawnBanknotes) {
                System.out.println("Номинал: " + banknote.getDenomination().getValue() + " руб.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
