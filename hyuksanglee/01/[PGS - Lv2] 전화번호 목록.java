import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        for (String phone : phone_book) {
            set.add(phone);
        }
        
        for (String phone : phone_book) {
            int size = phone.length();
            
            for (int j = 1; j < size; j++) {
                String result = phone.substring(0, j); 
                
                if (set.contains(result)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
