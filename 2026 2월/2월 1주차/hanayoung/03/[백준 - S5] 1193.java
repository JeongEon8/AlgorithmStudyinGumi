import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(bf.readLine());

        int idx = 1;
        int sum = 3;
        String answer = "";
        if(X == 1) answer = "1/1";
        else {
            while(idx <= X) {
                if(sum % 2 == 0) {
                    for(int i = sum-1; i > 0; i--) {
                        idx++;
                        if(idx == X) {
                            answer = i+"/"+(sum-i);
                            break;
                        }
                    }
                } else {
                    for(int i = 1; i < sum; i++) {
                        idx++;
                        if(idx == X) {
                            answer = i+"/"+(sum-i);
                            break;
                        }
                    }
                }
                sum++;
            }
        }
        System.out.println(answer);
    }
}
