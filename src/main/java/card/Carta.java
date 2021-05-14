
/*Scopo dell’esercizio è creare una classe che sponga i seguenti metodi:
1)checkValidity() ritorna true se il numero di carta è a 13 cifre e la 13.ma è corretta, false altrimenti.
2)checkDigit(). Ritorna il checkDigit del numero di carta, indipendentemente dal fatto che sia un numero di carta a 12 o a 13 cifre.
3)getCardNo(). Ritorna il numero di carta a 12 cifre, ignorando l'eventuale checkdigit (o 13.cifra)
4)getFullCardNo(). Ritorna il numero di carta a 13 cifre. Se il numero è a 12 cifre,
                    calcola il checkDigit e lo appende al numero di partenza.
-----------Il costruttore-------------
1)di default crea una carta senza numero,
2)mentre il costruttore dedicato crea una carta con un numero a 12 cifre o a 13 cifre.

NOTA IMPORTANTE. Sarebbe tutto semplicissimo se fosse consentito un membro privato, come cardNo, che fosse solo a 12 cifre.
Ma qui ci complichiamo la vita consentendo a tale membro di poter rappresentare anche il numero a 13 cifre.

Il vincolo è che quando si cerca di assegnare un numero di carta a 13 cifre,
prima della sua assegnazione deve essere verificato che il numero sia accettabile,
altrimenti deve essere segnalato in qualche modo un errore.*/
package card;

import java.text.StringCharacterIterator;

public class Carta  {
    /**
     * Stringa rappresentante il codice della carta
     */
    private String num;

    /**
     * Costruttore base
     */
    private Carta() {

    }

    /**
     * costruttore speciale che fa il set del codice della carta
     *
     * @param s
     * @throws ExceptionLength
     */
    public Carta(String s) throws ExceptionLength {
        if(s.matches("\\d+")){
            if (CheckLength(s))
            this.num = s;
        else throw new ExceptionLength();}
        else throw new ExceptionLength();
    }

    /**
     * Ritorna il numero di carta a 13 cifre. Se il numero è a 12 cifre,
     * calcola il CheckDigit e lo appende al numero di partenza.
     *
     * @return object
     */
    public String getFullCardNo() {
        if (!CheckLength(num)) {
            return null;
        }
        if (num.length() == 13) {
            return num;
        } else {
            String numdigit = String.valueOf(CalcolaDigit());
            num = num + numdigit;
            return num;
        }
    }

    /**
     * Calcola il checkDigit e lo restituisce sottoforma di object
     *
     * @return object
     */
    private int CalcolaDigit() {
        int digitDisp = 0;
        int digitPar = 0;
        int digit = 0;
        for (int i = 0; i < 12; i++) {
            if (i == 0 || i % 2 == 0) {
                digitDisp = digitDisp + Character.getNumericValue(num.charAt(i));
            } else {
                digitPar = digitPar + Character.getNumericValue(num.charAt(i));

            }
        }
        digitPar = digitPar * 3;
        digit = digitPar + digitDisp;
        digit = digit % 10;
        digit = 10 - digit;
        return digit;
    }

    /**
     * Controlla la lunghezza del codice,
     * ritorna true se è a 12 o 13 cifre e flase negli altri casi
     *
     * @return boolean
     */
    private boolean CheckLength(String s) {
        if (s.length() == 13 || s.length() == 12) {
            return true;
        } else {
            if (s.length() < 12) {
                System.out.println("Lunghezza codice troppo piccolo");

            } else System.out.println("Lunghezza codice troppo lunga");
        }
        return false;
    }

    /**
     * Ritorna il numero di carta a 12 cifre,
     * ignorando l'eventuale checkdigit (o 13.cifra)
     *
     * @return String
     */
    public String getCardNo() {
        if (!CheckLength(num)) {
            return null;
        }
        String numCard = null;
        if (num.length() == 13) {
            numCard = num.substring(0, 12);
        } else {
            return num;
        }
        return numCard;
    }

    /**
     * Ritorna il checkDigit del numero di carta,
     * indipendentemente dal fatto che sia un numero di carta a 12 o a 13 cifre.
     *
     * @return Object
     */
    public int checkDigit() {
        if (!CheckLength(num)) {
            return 0;
        }
        if (num.length() == 13) {
            int s = CalcolaDigit();
            if (s == Character.getNumericValue(num.charAt(12)))
                return Character.getNumericValue(num.charAt(12));
            else {
                System.out.println("il checkDigit ha dedotto che il numero sulla carta non è corretto il numero corretto è:" + s);
                return s;
            }
        } else {
            return CalcolaDigit();
        }
    }

    /**
     * ritorna true se il numero di carta è a 13 cifre e la 13.ma è corretta, false altrimenti.
     *
     * @return boolean
     */
    public boolean checkValidity() {
        if (!CheckLength(num)) {
            return false;
        }
        if (num.length() == 13) {
            int digit = Character.getNumericValue(num.charAt(12));
            if (digit == CalcolaDigit()) {
                return true;
            } else return false;
        } else return false;
    }
}
