import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        Point head = null, heart = null;
        ArrayList<Integer> waist = new ArrayList<>();
        ArrayList<Integer> lArms = new ArrayList<>();
        ArrayList<Integer> rArms = new ArrayList<>();
        ArrayList<Integer> lLegs = new ArrayList<>();
        ArrayList<Integer> rLegs = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());

        for(int i = 1; i < N+1; i++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            for(int j = 1; j < N+1; j++) {
                if(str.charAt(j-1) == '*') { // 쿠키 일부분
                    if(head == null) {
                        head = new Point(i, j);
                        heart = new Point(i+1, j);
                    } else {
                        if(i == heart.x) {
                            if(j < heart.y) lArms.add(j);
                            else if(j > heart.y) rArms.add(j);
                        } 
                        else if(i > heart.x && j == heart.y) waist.add(i);
                        else if(i > heart.x) {
                            if(j == heart.y - 1) lLegs.add(i);
                            else if(j == heart.y + 1) rLegs.add(i);
                        }
                    }
                }
            }
        }

        System.out.println(heart.x+" "+heart.y);
        System.out.println(lArms.size()+" "+rArms.size()+" "+waist.size()+" "+lLegs.size()+" "+rLegs.size());

    }
}
