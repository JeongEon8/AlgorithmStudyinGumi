import java.util.*;

class FileInfo {
    String file;
    String head;
    int number;
    int index;
    
    public FileInfo(String file, int index) {
        this.file = file;
        this.index = index;
        parse(file);
    }
    
    private void parse(String file) {
        int idx = 0;

        while (idx < file.length() && !Character.isDigit(file.charAt(idx))) {
            idx++;
        }

        this.head = file.substring(0, idx);

        int numStart = idx;

        while (idx < file.length() && Character.isDigit(file.charAt(idx))) {
            idx++;
        }

        this.number = Integer.parseInt(file.substring(numStart, idx));
    }
}

class Solution {
    public String[] solution(String[] files) {
        FileInfo[] infos = new FileInfo[files.length];
        
        for (int i = 0; i < files.length; i++) {
            infos[i] = new FileInfo(files[i], i);
        }
        
        Arrays.sort(infos, (a, b) -> {
            int headCompare = a.head.compareToIgnoreCase(b.head);

            if (headCompare != 0) {
                return headCompare;
            }

            int numberCompare = Integer.compare(a.number, b.number);

            if (numberCompare != 0) {
                return numberCompare;
            }

            return Integer.compare(a.index, b.index);
        });
        
        String[] answer = new String[files.length];

        for (int i = 0; i < infos.length; i++) {
            answer[i] = infos[i].file;
        }

        return answer;
    }
}
