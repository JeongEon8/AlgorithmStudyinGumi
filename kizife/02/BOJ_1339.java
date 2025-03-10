import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 

        int n = sc.nextInt();
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        Map<Character, Integer> map = new HashMap<>();

        for (String word : words) {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char ch = word.charAt(i);
                int weight = (int) Math.pow(10, length-i-1); //몇의자리숫자인지?? int화
                map.put(ch, map.getOrDefault(ch, 0) + weight);
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue()); //내림차순

        Map<Character, Integer> assignMap = new HashMap<>();
        int num = 9;
        for (Map.Entry<Character, Integer> entry : list) {
            assignMap.put(entry.getKey(), num--);
        }

        int sum = 0;
        for (String word: words) {
            int value = 0;
            for (char ch : word.toCharArray()) {
                value = value*10 + assignMap.get(ch);
            }
            sum += value;
        }

        System.out.println(sum);
    }
}
