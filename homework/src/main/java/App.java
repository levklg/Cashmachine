public class App {

    public static void main(String[] args) {

        Cashmachine cashmachine = new Cashmachine();
        cashmachine.loadNotes(50, 100);
        cashmachine.loadNotes(100, 70);
        cashmachine.loadNotes(200, 50);
        cashmachine.loadNotes(500, 30);

        cashmachine.withdrawEx( 300);

        System.out.println( cashmachine.deposit(200, 2));




    }
}
