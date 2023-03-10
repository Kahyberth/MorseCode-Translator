//Imports
import java.io.*;
import java.util.StringTokenizer;

public class Morse {

    File file = new File("message.txt");
    private String message = "";

    private String[][] morseCode = { { "A", ".-" }, { "B", "-..." }, { "C", "-.-." }, { "D", "-.." }, { "E", "." },
            { "F", "..-." }, { "G", "--." }, { "H", "...." }, { "I", ".." }, { "J", ".---" }, { "K", "-.-" },
            { "L", ".-.." },
            { "M", "--" }, { "N", "-." }, { "O", "---" }, { "P", ".--." }, { "Q", "--.-" }, { "R", ".-." },
            { "S", "..." }, { "T", "-" },
            { "U", "..-" }, { "V", "...-" }, { "W", ".--" }, { "X", "-..-" }, { "Y", "-.--" }, { "Z", "--.." } };

    private void translator(String code) {
        for (int i = 0; i < morseCode.length; i++) {
            if (morseCode[i][1].equalsIgnoreCase(code)) {
                message += morseCode[i][0];
                break;
            }
        }
    }

    private String readFile() {
        String code;
        try {
            String currentLine;
            try (BufferedReader input = new BufferedReader(new FileReader(file))) {
                while ((currentLine = input.readLine()) != null) {
                    StringTokenizer tokens = new StringTokenizer(currentLine, " ");
                    while (tokens.hasMoreTokens()) {
                        code = tokens.nextToken();
                        translator(code);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return message;
    }

    public static void main(String[] args) {
        Morse code = new Morse();
        System.out.println(code.readFile());
    }

}
