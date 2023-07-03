package caculator;

import delimiter.DelimiterResolver;
import java.util.Arrays;
import java.util.regex.Pattern;

public final class Calculator {

    public static final Pattern NUMBER_PATTERN = Pattern.compile("(^[0-9]*$)");

    private Calculator() {
    }

    public static int sum(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        String[] resolved = DelimiterResolver.resolve(text);
        String[] values = resolved[1].split(resolved[0]);
        if (!validate(values)) {
            throw new RuntimeException();
        }

        return Arrays.stream(values)
                     .mapToInt(Integer::parseInt)
                     .reduce(Integer::sum)
                     .orElseThrow(RuntimeException::new);
    }

    private static boolean validate(String[] values) {
        for (String value : values) {
            if (value.isBlank() || !isNumber(value) || value.startsWith("-")) {
                return false;
            }
        }

        return true;
    }

    private static boolean isNumber(String value) {
        return NUMBER_PATTERN.matcher(value).find();
    }

}
