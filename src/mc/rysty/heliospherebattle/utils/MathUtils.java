package mc.rysty.heliospherebattle.utils;

public class MathUtils {

    public static int getLargestInt(int... numbers) {
        Integer largest = null;

        for (int number : numbers)
            if (largest == null || number > largest)
                largest = number;
        return largest;
    }
}