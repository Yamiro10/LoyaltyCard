package card;

public class ExceptionLength extends Exception {
    public ExceptionLength(){
        System.out.println("Errore lunghezza numero carta");
    }
    public ExceptionLength(String s){
        System.out.println(s);
    }
}
