import java.util.Hashtable;
import java.util.Dictionary;
import java.util.ArrayList;
import java.util.List;

/**
 * Converts Roman numeral to decimal value
 * @author Alex Ru
 * @version 10.11.23
 * I found the code on lines 19-32 at https://www.geeksforgeeks.org/java-util-dictionary-class-java/
 * Also Aarav gave me the basic idea about dictionaries
 * I found the code on lines 138, 144, 148 at https://www.geeksforgeeks.org/list-interface-java-examples/
 * Cameron helped me test my decimalToRoman method and looked over my code
 * Hey what's up JC my extra is on lines 73-130 and 143-150
 */
public class RomanToDecimal {

    private static int valueOfRoman(char roman) {
        Dictionary<Character, Integer> dict = new Hashtable<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);

        String alphabet = "IVXLCDM";
        if (alphabet.indexOf(roman) == -1)
            return -1;

        return dict.get(roman);
    }

    /**
     * Converts string roman numeral to int
     * @param roman string roman numeral
     * @return int decimal value
     */
    public static int romanToDecimal(String roman) {
        // remove spaces
        roman = roman.replaceAll("\\s", "");

        // make everything uppercase
        roman = roman.toUpperCase();

        // result local variable
        int res = 0;
        for (int i = 0; i < roman.length(); i++) {
            // if invalid num
            if (valueOfRoman(roman.charAt(i)) == -1) {
                return -1;
            }

            // in case next index is out of bounds
            if (i + 1 >= roman.length()) {
                res += valueOfRoman(roman.charAt(i));
                break;
            }

            // if num is less than next num
            String next = roman.substring(i, i + 2);
            if (valueOfRoman(next.charAt(0)) < valueOfRoman(next.charAt(1))) {
                res += (valueOfRoman(next.charAt(1)) - valueOfRoman(next.charAt(0)));
                i++;
            } else {
                res += valueOfRoman(next.charAt(0));
            }
        }
        return res;
    }

    private static String decimalToRoman(int decimal) {
        String res = "";
        while (decimal > 0) {
            if (decimal % 10000 >= 1000) {
                decimal -= 1000;
                res = res + "M";
            } else if (decimal % 1000 >= 500) {
                if (decimal % 1000 >= 900) {
                    decimal -= 900;
                    res = res + "CM";
                    continue;
                }
                decimal -= 500;
                res = res + "D";
            } else if (decimal % 1000 >= 100) {
                if (decimal % 1000 >= 400) {
                    decimal -= 400;
                    res = res + "CD";
                    continue;
                }
                decimal -= 100;
                res = res + "C";
            } else if (decimal % 100 >= 50) {
                if (decimal % 100 >= 90) {
                    decimal -= 90;
                    res = res + "XC";
                    continue;
                }
                decimal -= 50;
                res = res + "L";
            } else if (decimal % 100 >= 10) {
                if (decimal % 100 >= 40) {
                    decimal -= 40;
                    res = res + "XL";
                    continue;
                }
                decimal -= 10;
                res = res + "X";
            } else if (decimal % 10 >= 5) {
                if (decimal % 10 == 9) {
                    decimal -= 9;
                    res = res + "IX";
                    continue;
                }
                decimal -= 5;
                res = res + "V";
            } else if (decimal % 10 >= 1) {
                if (decimal % 10 == 4) {
                    decimal -= 4;
                    res = res + "IV";
                    continue;
                }
                decimal -= 1;
                res = res + "I";
            }
        }
        return res;
    }

    /**
     * Main method of class RomanToDecimal
     * @param args command line arguments if needed
     */
    public static void main(String[] args) {
        int val;
        List<String> illogical_inputs = new ArrayList<>();
        for (String roman : args) {
            val = romanToDecimal(roman);
            System.out.println("Input: " + roman + " => output: " +
                    (val == -1 ? "invalid" : val));
            if (!roman.toUpperCase().equals(decimalToRoman(val)) && val != -1) {
                illogical_inputs.add(roman);
            }
        }
        System.out.println();
        for (String roman : illogical_inputs) {
            System.out.println("You inputted: " + roman + ". The correct roman numeral should be: " + decimalToRoman(romanToDecimal(roman)));
        }
    }
}
