import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CassetteWithNotes implements Command {

    private final HashMap<Integer, Integer> hashMapCassette = new HashMap<>();

    @Override
    public Map<Integer, Integer> withdraw(int expectedAmount) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>(hashMapCassette.keySet());
        Collections.sort(list);
        Collections.reverse(list);

        for (Integer integer : list) {
            int x = expectedAmount / integer;

            if (x > 0) {
                if (hashMapCassette.get(integer) >= x) {
                    map.put(integer, x);
                    expectedAmount -= integer * x;
                } else {
                    map.put(integer, hashMapCassette.get(integer));
                    expectedAmount -= hashMapCassette.get(integer) * integer;
                }
            }
            if (expectedAmount == 0) break;
        }
        if (expectedAmount > 0) {


            System.out.println("There is no such amount at the ATM");
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int m = hashMapCassette.get(entry.getKey());
            hashMapCassette.remove(entry.getKey());
            hashMapCassette.put(entry.getKey(), (m - entry.getValue()));
        }
        return map;

    }

    @Override
    public void loadNotes(int nominal, int quantity) {
        this.hashMapCassette.put(nominal, quantity);
    }

    @Override
    public String deposit(int nominal, Integer amount) {
        return null;
    }
}
