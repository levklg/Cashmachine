import com.zaxxer.hikari.HikariConfig;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        BanknoteStorage banknoteStorage = new CMBanknoteStorage();
        Cashmachine cashmachine = new Cashmachine(banknoteStorage);

        // Создаем список из 5 банкнот по 100 рублей
        List<Banknote> banknotes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            banknotes.add(new Banknote(100));
        }
        // Создаем список из 10 банкнот по 50 рублей
               for (int i = 0; i < 10; i++) {
            banknotes.add(new Banknote(50));
        }
        // Создаем список из 3 банкнот по 200 рублей
              for (int i = 0; i < 3; i++) {
            banknotes.add(new Banknote(200));
        }
        // Создаем список из 1 банкнот по 200 рублей
        for (int i = 0; i < 3; i++) {
            banknotes.add(new Banknote(500));
        }

        // Вносим банкноты в банкомат
        cashmachine.deposit(banknotes);

        //код для снятия суммы
        try {
            List<Banknote> withdrawnBanknotes = cashmachine.withdraw(700);
            System.out.println("Снято " + withdrawnBanknotes.size() + " банкнот(ы):");
            for (Banknote banknote : withdrawnBanknotes) {
                System.out.println("Номинал: " + banknote.getDenomination() + " руб.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }
}
