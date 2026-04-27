class Main {
    static int MAX_NUM = 10000;
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int[] nonSelfNum = new int[MAX_NUM+1];
        // 체크안함 0 체크함+셀프넘버아님 1 체크함+셀프넘버임 2
        int idx = 1;
        while(idx <= MAX_NUM) {
            if(nonSelfNum[idx] == 0){
                int cal = idx;
                int num;
                nonSelfNum[idx] = 2;
                while(cal <= MAX_NUM) {
                    num = cal;
                    while(num > 0) {
                        cal += num % 10;
                        num /= 10;
                    }
                    if(cal <= MAX_NUM &&nonSelfNum[cal] == 0) nonSelfNum[cal] = 1;
                    else break;
                }
            }
            idx++;
        }
        for(int i = 1; i <= MAX_NUM; i++) {
            if(nonSelfNum[i] == 2) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
