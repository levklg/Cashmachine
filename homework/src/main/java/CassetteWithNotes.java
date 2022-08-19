import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CassetteWithNotes {
   private  final HashMap<Integer, Integer> hashMapCassette = new HashMap<>();


   public  void loadNotes(int nominal, int quantity){
      this.hashMapCassette.put(nominal, quantity);
   }


  public boolean checkAmountAvailable(int amount){
      int value = 0;
      int nominal = 0;
      int totalSumma = 0;
      for (Map.Entry entry: hashMapCassette.entrySet()) {
         nominal = (int) entry.getKey();
         value = value + (int) entry.getValue();
         totalSumma = totalSumma + (nominal * value);
      }
      if (totalSumma >= amount) return true;
       else return  false;
  }


    public Map<Integer,Integer>   withdraw(int expectedAmount){
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
                }
                else {
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


    public void deposit(String nominal, int amount) {

    }


}
