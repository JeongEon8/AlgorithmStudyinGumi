import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            char[] word = sc.next().toCharArray();
            Arrays.sort(word);
            set.add(new String(word));  
        }

        System.out.println(set.size());
    }
}
