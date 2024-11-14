import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[] arr1 = new int[8];
    static int[] arr2 = new int[8];
    static int[] arr3 = new int[8];
    static int[] arr4 = new int[8];
    static Scanner sc = new Scanner(System.in);
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        input(); // 입력 받음
        
        for (int i = 0; i < list.size(); i++) {
            turn(i);
        }
        
        System.out.println(score());
    }

    private static void turn(int num) {
        int gear = list.get(num)[0]; //톱니바퀴 넘버 
        int dir = list.get(num)[1];

        int[] dirs = new int[4]; //회전 방향 저장
        dirs[gear - 1] = dir;

        // 왼쪽으로 전파 검사
        for (int i = gear - 1; i > 0; i--) {
            if (getGear(i)[6] != getGear(i - 1)[2]) {
                dirs[i - 1] = -dirs[i];
            } else {
                break;
            }
        }

        //왼쪽에서 오른쪽으로 검토 
        for (int i = gear - 1; i < 3; i++) {
        	//맞붙은 극이 상이한지 검토 
            if (getGear(i)[2] != getGear(i + 1)[6]) { //getGear(i)란..어떤 arr인지 
                dirs[i + 1] = -dirs[i];
            } else {
                break;
            }
        }

        //회전
        for (int i = 0; i < 4; i++) {
            if (dirs[i] == 1) spinRight(getGear(i));
            else if (dirs[i] == -1) spinLeft(getGear(i));
        }
    }

    private static int[] getGear(int index) {
    	    switch (index) {
    	        case 0: return arr1;
    	        case 1: return arr2;
    	        case 2: return arr3;
    	        case 3: return arr4;
    	        default: return null;
    	    }
    	}

    private static void spinRight(int[] arr) {
        int temp = arr[7];
        for (int i = 7; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }

    private static void spinLeft(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < 7; i++) {
            arr[i] = arr[i + 1];
        }
        arr[7] = temp;
    }

    private static void input() {
        String input = sc.nextLine();
        for (int i = 0; i < 8; i++) {
            arr1[i] = input.charAt(i) - '0';
        }
        input = sc.nextLine();
        for (int i = 0; i < 8; i++) {
            arr2[i] = input.charAt(i) - '0';
        }
        input = sc.nextLine();
        for (int i = 0; i < 8; i++) {
            arr3[i] = input.charAt(i) - '0';
        }
        input = sc.nextLine();
        for (int i = 0; i < 8; i++) {
            arr4[i] = input.charAt(i) - '0';
        }

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int dir = sc.nextInt();
            sc.nextLine();
            list.add(new int[]{num, dir});
        }
    }

    private static int score() {
        int sum = 0;
        if (arr1[0] == 1) sum += 1;
        if (arr2[0] == 1) sum += 2;
        if (arr3[0] == 1) sum += 4;
        if (arr4[0] == 1) sum += 8;
        return sum;
    }
}
