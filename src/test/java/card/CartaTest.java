package card;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.opentest4j.AssertionFailedError;

class CartaTest {

    private ExceptionLength Ex;

    @org.junit.jupiter.api.Test
    void getFullCardNo() {
    }

    @org.junit.jupiter.api.Test
    void getCardNo() {
    }

    @org.junit.jupiter.api.Test
    void checkDigit() {
    }

    @org.junit.jupiter.api.Test
    void checkValidity() {
    }

    @Test
    void TestGenerico() throws ExceptionLength {
        Carta card = new Carta("123456789101");
        Assertions.assertTrue(card.checkDigit() == 9);
        Assertions.assertTrue(card.getCardNo().equals("123456789101"));
        Assertions.assertFalse(card.checkValidity());
        Assertions.assertTrue(card.getFullCardNo().equals("1234567891019"));
    }

    @Test
    void ShortNumber() throws ExceptionLength {
        Assertions.assertThrows(ExceptionLength.class, () ->{Carta card = new Carta("123");});
    }

    @Test
    void LongNumber() throws ExceptionLength {
        Assertions.assertThrows(ExceptionLength.class, () ->{Carta card = new Carta("123333333333333333333");});
    }
    @Test
    void NotValidDigit() throws ExceptionLength {
        Carta card = new Carta("1234567891018");
        Assertions.assertFalse(card.checkDigit() == 8);
    }
    @Test
    void CharacterNumber() throws ExceptionLength {
        Assertions.assertThrows(ExceptionLength.class, () ->{Carta card = new Carta("okokokokokok");});
    }

}