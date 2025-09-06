import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_1302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Map<String, Integer> bookCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String book = sc.nextLine();
            bookCount.put(book, bookCount.getOrDefault(book, 0) + 1);
        }

        int maxCount = 0;
        String answer = "";
        for (String book : bookCount.keySet()) {
            int count = bookCount.get(book);
            if (count > maxCount || (count == maxCount && book.compareTo(answer) < 0)) {
                maxCount = count;
                answer = book;
            }
        }

        System.out.println(answer);
    }
}
