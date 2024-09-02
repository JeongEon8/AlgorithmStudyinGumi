import java.util.Scanner;
 
public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int result;
				
		for(int i=1; i<=9; i++) {
            result = A*i;
            
            System.out.println(A + " * " + i +" = " + result);
        }
        
	}
}
