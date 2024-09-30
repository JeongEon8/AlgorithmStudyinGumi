import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_28445 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<String> list = new ArrayList<>();

		list.add(sc.next());
		list.add(sc.next());
		list.add(sc.next());
		list.add(sc.next());
		
		ArrayList<String> colors = new ArrayList<>();
		
		for (String i : list) {
			if (!colors.contains(i)) colors.add(i);
		}
		
		Collections.sort(colors);
		
		
		for (String i : colors) {
			for (String j : colors) {
				System.out.println(i + " " + j);
			}
		}
		
	}

}
