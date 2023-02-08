package varnavizsga.jjbvizsga.feladat1;

import java.nio.file.ClosedWatchServiceException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Billing {

    private static int LOWEST_VAT = 5;
    private static int MIDDLE_VAT = 18;
    private static int HIGHEST_VAT = 27;
    private static ArrayList<Integer> vats = new ArrayList<>(List.of(LOWEST_VAT,MIDDLE_VAT,HIGHEST_VAT));


    public static int priceWithVAT(int vatRate, int priceWithoutVAT) {
        if (!validVATrate(vatRate)){
            throw new IllegalArgumentException("Érvénytelen áfakulcs");
        }
        return (int) Math.ceil (priceWithoutVAT *(1+vatRate/100.0));
    }


    private static boolean validVATrate(int rate) {
        return vats.contains(rate);
    }

    public static int priceWithoutVAT(int vatRate, int priceWithVAT) {
        if (!validVATrate(vatRate)){
            throw new IllegalArgumentException("Érvénytelen áfakulcs");
        }
        return (int) Math.floor((priceWithVAT/(vatRate + 100.0))*100);
        }

    public static String displayBook(String author, String title, int priceWithVAT) {
        String firstPart = String.format("%s - %s", author, title);
        return String.format("%-50s Áfával: %5d Ft, Áfa nélkül: %5d Ft", firstPart, priceWithVAT, priceWithoutVAT(LOWEST_VAT, priceWithVAT));
    }
}
