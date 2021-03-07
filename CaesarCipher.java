import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt (String input, int key){

        StringBuilder encrypted = new StringBuilder(input);
        String uppercaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabetUppercase = uppercaseAlphabet.substring(key) + uppercaseAlphabet.substring(0, key);
        String shiftedAlphabetLowercase = lowercaseAlphabet.substring(key) + lowercaseAlphabet.substring(0, key);

        for (int i = 0; i < encrypted.length(); i++){
            char currentChar = encrypted.charAt(i);
            if (currentChar == Character.toUpperCase(currentChar)){
                int index = uppercaseAlphabet.indexOf(currentChar);
                if (index != -1){
                    char newChar = shiftedAlphabetUppercase.charAt(index);
                    encrypted.setCharAt(i, newChar);
                }
            }
            else {
                int index = lowercaseAlphabet.indexOf(currentChar);
                if (index != -1) {
                    char newChar = shiftedAlphabetLowercase.charAt(index);
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
    }
    public static void input(){
        Scanner user = new Scanner(System.in);
        System.out.print("Please write the message you wish to encrypt: \n");
        String input = user.nextLine();
        System.out.print("Please choose a key (number from 1 to 25): ");
        int key = user.nextInt();
        while (key > 25 || key <= 0){
            System.out.print("Please insert a valid key: ");
            int newKey = user.nextInt();
            key = newKey;
        }
        System.out.println("Check your encrypted message below: \n" + encrypt(input, key) + "\n");
        //user.close();
    }
    public static void main (String[] args){
        Scanner user = new Scanner(System.in);
        System.out.println("Welcome to the Caesar Cipher Encryption tool. \n" +
                "It is a type of substitution cipher in which each letter in the plaintext is replaced by a letter some fixed number (The key) of positions down the alphabet." +
                "\nFor example, with a left shift of 3, D would be replaced by A, E would become B, and so on. " +
                "\nThe method is named after Julius Caesar, who used it in his private correspondence." +
                "\nWARNING: The Caesar Cipher can be easily broken. Use it only for fun and not actual security purposes." +
                "\nThis project was designed to introduce me to cryptography and practice my coding skills. \n");
        input();
        while (true) {
            System.out.println("Would you like to encrypt another message? Yes/No");
            String response = user.nextLine();
            if (response.equalsIgnoreCase("Yes")) {
                input();
            }
            else break;
        }

    }
}
