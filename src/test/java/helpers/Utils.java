package helpers;

import java.util.Random;

public class Utils {

    // Generates a random int with 5 digits
    public static String generateRandomMileageNum() {
        Random random = new Random();
        return String.valueOf(random.nextInt(99999));
    }
}
