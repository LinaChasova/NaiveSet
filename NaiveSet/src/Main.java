import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by AlinaCh on 05.02.2017.
 */
public class Main {

    /**
     * reads text from file input
     * @return input
     */
    public static String readString() {
        try {
            Scanner sc = new Scanner(new File("input.txt"));
            String read = "";
            while(sc.hasNextLine()) {
                read = read + sc.nextLine() + "/n";
            }
            return read;
        } catch (FileNotFoundException ex) {
            return null;
        }
    }

    /**
     * writes result to the output
     * @param s String
     */
    public static void writeString(String s) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("output.txt"), "ascii"))) { writer.write(s); }
        catch (IOException ex) { }
    }

    /**
     * adds given numbers to the bitset
     * checks whether test numbers in the bitset
     * @param args
     */
    public static void main(String[] args) {
        String text = readString();
        String[] check = text.split("/n");
        //BitSet numbers = new BitSet();
        LowercaseTrieVocabulary numbers = new LowercaseTrieVocalubary();
        String result = "";
        if (check[0].equals("")) {
            for (String test : check[1].split(" ")) {
                result = result + "false ";
            }
        } else if (check.length != 1) {
            for (String num : check[0].split(" ")) {
                numbers.set(Integer.parseInt(num));
            }
            for (String test : check[1].split(" ")) {
                result = result + Boolean.toString(numbers.get(Integer.parseInt(test))) + " ";
            }
        }
        writeString(result);
    }
}
