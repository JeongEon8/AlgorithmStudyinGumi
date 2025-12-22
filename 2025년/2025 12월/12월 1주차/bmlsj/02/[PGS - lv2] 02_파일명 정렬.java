import java.util.*;
class Solution {
    
    static class File {
        String origin, head, number, tail;
        
        File(String origin, String head, String number, String tail) {
            this.origin = origin;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
    }
    
    public String[] solution(String[] files) {

        List<File> fileList = new ArrayList<>();

        for(String file : files) {
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            StringBuilder tail = new StringBuilder();
            
            int idx = 0;
            
            // HEAD
            while(idx < file.length() && !(file.charAt(idx) >= '0' && file.charAt(idx) <= '9')) {
                head.append(file.charAt(idx++));
            }
            
            // NUMBER
            while(idx < file.length() && file.charAt(idx) >= '0' && file.charAt(idx) <= '9') {
                number.append(file.charAt(idx++));
            }
            
            while(idx < file.length()) {
                tail.append(file.charAt(idx++));
            }
            
            fileList.add(new File(file, head.toString(), number.toString(), tail.toString()));
        }
        
        // 정렬 1. head 순 2. number 순 3. arr순
        fileList.sort((f1, f2) -> {
            int headCom = f1.head.toLowerCase().compareTo(f2.head.toLowerCase());
            int num1 = Integer.parseInt(f1.number);
            int num2 = Integer.parseInt(f2.number);
            
            if (headCom == 0) {
                return Integer.compare(num1, num2);
            }
            return headCom;
        });
        
        String[] answer = new String[files.length];
        for(int i = 0; i < fileList.size(); i++) {
            answer[i] = fileList.get(i).origin;
        }
        
        return answer;
    }
}