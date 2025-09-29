import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
      
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
          
            int[] entries = new int[N+1]; // 팀 순서 담기
            boolean[] passed = new boolean[N+1]; // 패스한 팀 체크
            int[] check = new int[N+1]; // 현재 패스한 인원 수 체크
            // 현재까지 들어온 팀원 수, 점수합산을 값을 갖고, 팀번호를 배열 인덱스로 갖기
            st = new StringTokenizer(bf.readLine());
            for (int i = 1; i <= N; i++) {
                int num = Integer.parseInt(st.nextToken());
                entries[i] = num; 
                check[num] += 1;
                if(check[num] == 6) passed[num] = true;

            }

            HashMap<Integer, Team> teams = new HashMap<>();
            int idx = 1;
            int pivot = 1;
            while(pivot < N+1) {
                // entries[pivot] 은 팀
                // pivot은 등수
                // idx는 점수를 가리킬 예정
                int teamNum = entries[pivot];
                Team team = teams.get(teamNum);
                if(passed[teamNum] == true) {
                    if(team == null) {
                        teams.put(teamNum,new Team(1, idx));
                    } else {
                        if(team.passCnt < 4) {
                            team.updateScore(idx);
                        } else if(team.passCnt == 4) {
                            teams.put(teamNum, new Team(5, team.score, idx));
                        } else {
                            team.updateCnt();
                        }
                    }
                    idx++;
                }
                pivot++;
            }

            Optional<Map.Entry<Integer, Team>> result = teams.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .filter(entry -> entry.getValue().passCnt == 6)
                    .findFirst();

            sb.append(result.get().getKey()).append("\n");

        }
        System.out.println(sb);
    }

    static class Team implements Comparable<Team> {

        int passCnt;
        int score;
        int fifthScore;

        public Team(int passCnt, int score) {
            this.passCnt = passCnt;
            this.score = score;
            this.fifthScore = 0;
        }

        public Team(int passCnt, int score, int fifthScore) {
            this.passCnt = passCnt;
            this.score = score;
            this.fifthScore = fifthScore;
        }

        public void updateScore(int newScore) {
            passCnt++;
            score += newScore;
        }
        
        public void updateCnt() {
            passCnt++;
        }

        @Override
        public int compareTo(Team object) {
            if (this.score < object.score) {
                return -1;
            } else if (this.score == object.score) {
                if (this.fifthScore < object.fifthScore) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }
}
