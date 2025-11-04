import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.next();
            if (s.equals("0")) break;

            System.out.println(getDiffToNextPalindrome(s));
        }
        sc.close();
    }

    private static String addOne(String s) {
        StringBuilder sb = new StringBuilder(s);
        int carry = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int sum = (s.charAt(i) - '0') + carry;
            sb.setCharAt(i, (char) ('0' + (sum % 10)));
            carry = sum / 10;
        }
        if (carry > 0) sb.insert(0, '1');
        return sb.toString();
    }

    private static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    private static int getDiffToNextPalindrome(String s) {
        int count = 0;
        String num = s;
        while (!isPalindrome(num)) {
            num = addOne(num);
            count++;
        }
        return count;
    }
}
