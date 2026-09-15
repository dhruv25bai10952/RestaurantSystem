package util;

public class Validator {

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{10}");
    }

    public static boolean isPositiveInteger(int value) {
        return value > 0;
    }

    public static boolean isValidTimeFormat(String time) {
        // basic check e.g. "7:30 PM" or "19:30"
        return time != null && !time.trim().isEmpty();
    }
}
