import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Double avg = 0.0;
        Double subjects = 0.0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String subjectName = st.nextToken();
            Double credit = Double.valueOf(st.nextToken());
            Double grade = -1.0;
            switch (st.nextToken()) {
                case "A+":
                    grade = 4.5;
                    break;
                case "A0" :
                    grade = 4.0;
                    break;
                case "B+" :
                    grade = 3.5;
                    break;
                case "B0" :
                    grade = 3.0;
                    break;
                case "C+" :
                    grade = 2.5;
                    break;
                case "C0" :
                    grade = 2.0;
                    break;
                case "D+" :
                    grade = 1.5;
                    break;
                case "D0" :
                    grade = 1.0;
                    break;
                case "F":
                    grade = 0.0;
                    break;
            }
            if(grade >= 0.0) {
                avg += grade * credit;
                subjects += credit;
            }
        }
        System.out.println(avg/subjects);
    }
}
