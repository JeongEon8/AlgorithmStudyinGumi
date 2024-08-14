import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();
        int N = sc.nextInt();
  
        ArrayList<Integer> wList = new ArrayList<>(); //가로로 자르는 선, 즉 세로길이에 영향
        ArrayList<Integer> hList = new ArrayList<>(); //세로로 자르는 선, 즉 가로길이에 영향

        for (int i = 0; i < N; i++) { // 가로, 세로 컷넘버 분류
            int dir = sc.nextInt();
            int num = sc.nextInt();

            if (dir == 0) {
                wList.add(num);
            } else if (dir == 1) {
                hList.add(num);
            }
        }
        
        wList.add(h);
        wList.add(0);
        hList.add(w);
        hList.add(0);

        Collections.sort(wList, Collections.reverseOrder());
        Collections.sort(hList, Collections.reverseOrder());

        int wLastIndex = wList.size() - 1;
        int hLastIndex = hList.size() - 1;

        int hLength = 0;
        int maxHLength = 0;
        for (int i = 0; i < wLastIndex; i++) {
            hLength = wList.get(i) - wList.get(i + 1);
            if (maxHLength < hLength) {
                maxHLength = hLength;
            }
        }
        int wLength = 0;
        int maxWLength = 0;
        for (int i = 0; i < hLastIndex; i++) {
            wLength = hList.get(i) - hList.get(i + 1);
            if (maxWLength < wLength) {
                maxWLength = wLength;
            }
        }

        System.out.println(maxWLength*maxHLength);
    }
}
