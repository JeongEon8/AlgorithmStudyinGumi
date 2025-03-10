import java.io.*;
import java.util.*;

public class Main {
    static class StackItem {
        int level;  
        int index;  

        StackItem(int level, int index) {
            this.level = level;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] v = new int[n+1];       
        int[] answers = new int[n];
        Deque<StackItem> stack = new ArrayDeque<>();
        int before = 0;
        
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine()); 
            if (stack.isEmpty() || stack.peek().level <= tmp) {  
                if (before + 1 < tmp) {  
                    System.out.println("-1");
                    return;
                }
                before = tmp;  
                

                stack.push(new StackItem(tmp, i));
                

                if (tmp > 0) {
                    v[tmp - 1]++;
                }
            } else {  
                before = tmp;  
                
                while (!stack.isEmpty() && tmp <= stack.peek().level) {
                    StackItem item = stack.pop();
                    answers[item.index] = v[item.level]; 
                    v[item.level] = 0;  
                }

              
                stack.push(new StackItem(tmp, i));

              
                if (tmp > 0) {
                    v[tmp - 1]++;
                }
            }
        }

      
        while (!stack.isEmpty()) {
            StackItem item = stack.pop();
            answers[item.index] = v[item.level];
            v[item.level] = 0;
        }

      
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answers[i]).append("\n");
        }
        System.out.print(sb);
    }
}
