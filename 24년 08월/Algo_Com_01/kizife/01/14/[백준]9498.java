import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
      
        if (A >= 90){
            System.out.println("A");
        } else if (A>=80) {
            System.out.println("B");
        } else if (A>=70){
            System.out.println("C");
        } else if (A>=60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        };
        
    }
}
