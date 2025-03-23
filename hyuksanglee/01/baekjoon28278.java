package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class baekjoon28278 {

	public static void main(String[] args)throws Exception {
        //TIP 캐럿을 강조 표시된 텍스트에 놓고 <shortcut actionId="ShowIntentionActions"/>을(를) 누르면
        // IntelliJ IDEA이(가) 수정을 제안하는 것을 확인할 수 있습니다.
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(in.readLine());
        Deque<Integer> arr = new ArrayDeque<>();

        for(int i = 0; i<X; i++){
            String[] input = in.readLine().split(" ");
            if(input[0].equals("1")){
                arr.add(Integer.parseInt(input[1]));
            }else if(input[0].equals("2")){
                if (arr.size()>0){
                    System.out.println(arr.pollLast());
                }else{
                    System.out.println(-1);
                }
            }
            else if(input[0].equals("3")){
                System.out.println(arr.size());
            }else if(input[0].equals("4")){
                if(arr.size()>0){
                    System.out.println(0);
                }else{
                    System.out.println(1);
                }
            }else{
                if (arr.size()>0){
                    System.out.println(arr.getLast());
                }else{
                    System.out.println(-1);
                }
            }
        }

    }

}
