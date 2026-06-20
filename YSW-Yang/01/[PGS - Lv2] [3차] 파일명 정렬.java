import java.util.*;

class Info implements Comparable<Info>{
    String file;
    String head;
    int num;
    int index;
    
    public Info(String file, String head, int num, int index){
        this.file = file;
        this.head = head;
        this.num = num;
        this.index = index;
    }
    
    @Override
    public int compareTo(Info other){
        String thead = this.head.toUpperCase();
        String ohead = other.head.toUpperCase();
        
        if(thead.equals(ohead)){
            if(this.num == other.num){
                return Integer.compare(this.index, other.index);
            }
            return Integer.compare(this.num, other.num);
        }
        
        return thead.compareTo(ohead);
    }
}

class Solution {
    public String[] solution(String[] files) {
        int size = files.length;
        String[] answer = new String[size];
        Info[] fileInfo = new Info[size];
        
        for(int i = 0; i < size; i++){
            fileInfo[i] = division(files[i], i);
        }
        Arrays.sort(fileInfo);
        
        for(int i = 0; i < size; i++){
            answer[i] = fileInfo[i].file;
        }
        
        return answer;
    }
    
    public Info division(String file, int index){
        String head = "";
        int num = 0;
        
        int size = file.length();
        int left = -1;
        for(int i = 0; i < size; i++){
            if((file.charAt(i) >= '0' && file.charAt(i) <= '9')){
                left = i;
                break;
            }
        }
        
        int right = left;
        while(right < size && (file.charAt(right) >= '0' && file.charAt(right) <= '9')) {
            right++;
        }
        
        head = file.substring(0, left);
        num = Integer.parseInt(file.substring(left, right));
        
        return new Info(file, head, num, index);
    }
}
