import java.util.*;

class Solution {
    public String solution(String p) {
        return convert(p);
    }
    
    public String convert(String w) {
        if (w.isEmpty()) {
            return "";
        }

        String[] divided = divide(w);
        String u = divided[0];
        String v = divided[1];

        if (isRight(u)) {
            return u + convert(v);
        }

        StringBuilder sb = new StringBuilder();

        sb.append("(");
        sb.append(convert(v));
        sb.append(")");

        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }

        return sb.toString();
    }
    
    public static String[] divide(String w) {
        int balance = 0;

        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }

            if (balance == 0) {
                return new String[] { w.substring(0, i + 1), w.substring(i + 1) };
            }
        }

        return null;
    }
    
    public boolean isRight(String w) {
        int balance = 0;

        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') balance++;
            else balance--;

            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }
}
