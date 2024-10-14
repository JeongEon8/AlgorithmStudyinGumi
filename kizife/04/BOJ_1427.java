import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        ArrayList<Integer> list = new ArrayList<>();

        for (char c : input.toCharArray()) {
            list.add(c - '0');
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        for(int i:list) {
            System.out.print(i);
        }
        
    }

}
