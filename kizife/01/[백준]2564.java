import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hor = sc.nextInt();
        int ver = sc.nextInt();
        int storeNum = sc.nextInt();
        int reLoc = 0;

        int[] storeArr = new int[storeNum];

        for (int i = 0; i < storeNum; i++) { // 상점 좌표별 위치 재지정
            int dir = sc.nextInt();
            int loc = sc.nextInt();

            switch (dir) { // 일직선으로 폈을 때의 상점 위치값
            case 1:
                reLoc = loc;
                break;
            case 2:
                reLoc = hor + ver + hor - loc;
                break;
            case 3:
                reLoc = hor + ver + hor + ver - loc;
                break;
            case 4:
                reLoc = hor + loc;
                break;
            }

            storeArr[i] = reLoc;

        }

        int dgDir = sc.nextInt(); // 동근이의 방향
        int dgLoc = sc.nextInt(); // 동근이의 위치
        int reDgLoc = 0;

        switch (dgDir) { // 일직선으로 폈을 때의 동근이 위치값
        case 1:
            reDgLoc = dgLoc;
            break;
        case 2:
            reDgLoc = hor + ver + hor - dgLoc;
            break;
        case 3:
            reDgLoc = hor + ver + hor + ver - dgLoc;
            break;
        case 4:
            reDgLoc = hor + dgLoc;
            break;
        }

        int result = 0;
        for (int i = 0; i < storeNum; i++) {
            int length1 = Math.abs(storeArr[i] - reDgLoc);
            int length2 = Math.abs((hor * 2 + ver * 2) - Math.abs(storeArr[i] - reDgLoc));
            int length = Math.min(length1, length2); // 최단거리 추출

            result += length;

        }
        System.out.println(result);


    }
}
