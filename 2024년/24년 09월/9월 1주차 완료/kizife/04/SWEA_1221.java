import java.util.*;

public class SWEA_1221 {

	static ArrayList<String> list;
	static ArrayList<Integer> number;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		add();
		
		int t = sc.nextInt(); // 테스트 케이스 수

		for (int i = 0; i < t; i++) {
			number = new ArrayList<>();

			String qNum = sc.next(); // 문제 번호 입력

			int n = sc.nextInt(); // 단어의 갯수

			for (int j = 0; j < n; j++) {
				String input = sc.next();

				for (int k = 0; k <= 9; k++) {
					if (input.equals(list.get(k))) {
						number.add(k);
					}
				}

			}
			
			Collections.sort(number);
			
			System.out.println(qNum);

			for (int j = 0; j < number.size(); j++) {
				int index = number.get(j);
				
				System.out.print(list.get(index) + " "); 
			}
			
			
			System.out.println();

		}
	}

	private static void add() {
		list = new ArrayList<>();
		list.add("ZRO");
		list.add("ONE");
		list.add("TWO");
		list.add("THR");
		list.add("FOR");
		list.add("FIV");
		list.add("SIX");
		list.add("SVN");
		list.add("EGT");
		list.add("NIN");
	}

}
