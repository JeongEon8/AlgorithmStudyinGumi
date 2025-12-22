import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String,Integer>map = new HashMap<>();
        for(String address : phone_book){
            map.put(address,0);
        }
        for(String address : phone_book){
            String tmp = "";
            for(int i=0;i<address.length();i++){
                tmp = address.substring(0,i);
                if(map.get(tmp)!=null)answer=false;
            }
            if(answer==false)break;
        }
        return answer;
    }
}
