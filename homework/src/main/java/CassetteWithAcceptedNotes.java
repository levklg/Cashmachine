import java.util.HashMap;
import java.util.Map;

public class CassetteWithAcceptedNotes {

    private  final HashMap<Integer, Integer> hashMapCassetteWithAcceptedNotes = new HashMap<>();

    public  String deposit (Integer nominal, Integer amount){

        if (!hashMapCassetteWithAcceptedNotes.isEmpty()) {
            for (Map.Entry entry : hashMapCassetteWithAcceptedNotes.entrySet()) {
               int key = (int) entry.getKey();
                if ( key == nominal) {

                    hashMapCassetteWithAcceptedNotes.put((Integer) entry.getKey(), amount + (Integer) entry.getValue());
                }

            }
        }else hashMapCassetteWithAcceptedNotes.put(nominal, amount);
             String str = "Deposit " + amount * nominal;
             return str  ;
    }


    public void loadNotes(int nominal, int quantity) {

    }
}
