package br.com.felipeelvas.request.converters;

public class NumberConverter {
    public static Double convertToDouble(String strNumber) throws IllegalArgumentException {
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", "."); // R$ 5,00 -> USD 5.00
        return Double.parseDouble(number);
    }
    public static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String sanitizedNumber = strNumber.replaceAll("[^0-9.]", "");
        return sanitizedNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }


}
