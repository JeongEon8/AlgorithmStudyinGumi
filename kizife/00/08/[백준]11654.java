import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char inputChar = sc.next().charAt(0);

        int asciiValue = (int) inputChar;
        System.out.println(asciiValue);

    }
}
