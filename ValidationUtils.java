public class ValidationUtils {
    Object[] array = new Object[10];
    int emptyIndex = ValidationUtils.getEmptyIndex(array);
    public static int getEmptyIndex(Object[] array) {
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean is0(String str) {

        if (Double.parseDouble(str) > 0) {
            return true;
        } else {
            return false;
        }

    }
}
