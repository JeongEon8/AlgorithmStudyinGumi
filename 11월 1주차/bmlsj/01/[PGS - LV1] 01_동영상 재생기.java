class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int video = toSec(video_len);
        int curr = toSec(pos);
        int opStart = toSec(op_start);
        int opEnd = toSec(op_end);
        
        for (String cmd : commands) {

            // 광고 구간 진입 시 즉시 점프
            if (curr >= opStart && curr <= opEnd) curr = opEnd;

            if (cmd.equals("next")) {
                curr += 10;
                if (curr > video) curr = video;
            } else {
                curr -= 10;
                if (curr < 0) curr = 0;
            }

            // 이동 후 광고 구간이면 다시 점프
            if (curr >= opStart && curr <= opEnd) curr = opEnd;
        }

        return toMMSS(curr);
    }

    private int toSec(String t) {
        String[] arr = t.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }

    private String toMMSS(int t) {
        int m = t / 60;
        int s = t % 60;
        return String.format("%02d:%02d", m, s);
    }
}
