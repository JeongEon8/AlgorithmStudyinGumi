import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
  static int answer = 0;
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int N = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    f(0,N,r,c);
    System.out.println(answer);
  }

  static void f(int order, int n, int sr, int sc){
    if(n==0){
      answer = order;
      return;
    }else{
      int len = (int)Math.pow(2, n);
      if(len/2 > sr && len/2 > sc){
        f(order, n-1, sr, sc);
      }else if(len/2 > sr && len/2 <= sc){
        f(order+(len*len/4), n-1, sr, sc - (len/2));
      }else if(len/2 <= sr && len/2 > sc){
        f(order+(len*len/4*2), n-1, sr - (len/2), sc);
      }else if(len/2 <= sr && len/2 <= sc){
        f(order+(len*len/4*3), n-1, sr - (len/2), sc - (len/2));
      }
    }
  }
}
