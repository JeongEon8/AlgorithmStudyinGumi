import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>> map = new HashMap<>();
        
        for(String str: info) {
            String[] arr = str.split(" ");
            String key = "";
            for(int i = 0; i < arr.length-1; i++) {
                key += arr[i].charAt(0);
            }
            
            map.computeIfAbsent(key, k -> new ArrayList<Integer>()).add(Integer.valueOf(arr[arr.length-1]));
        }
        for(List<Integer> list: map.values()) {
            Collections.sort(list);
        }
        String[][] name = {{"c","j","p"},{"b","f"},{"j","s"},{"c","p"}};
        Queue<String> keys = new LinkedList<>();
        List<String> tmp = new ArrayList<>();
        
        for(int k = 0; k < query.length; k++) {
            String q = query[k];
            String[] arr = q.split(" and | (?=\\d+$)");

            for(int i = 0; i < arr.length-1; i++) {
                if("-".equals(arr[i])) {
                    if(keys.size() == 0) {
                        for(String first: name[i]) {
                            tmp.add(first);
                        }
                    } else {
                        while(keys.size() > 0) {
                            String key = keys.poll();
                            for(String first: name[i]) {
                                tmp.add(key+first);
                            }
                        }
                    }
                } else {
                    if(keys.size() == 0) {
                        tmp.add(Character.toString(arr[i].charAt(0)));
                    } else {
                        while(keys.size() > 0) {
                            String key = keys.poll();
                            tmp.add(key+arr[i].charAt(0));
                        }
                    }
                }
                keys.addAll(tmp);
                tmp.clear();
            }
            
            int sum = 0;
            while(keys.size() > 0) {
                String key = keys.poll();
                int score = Integer.valueOf(arr[arr.length-1]);
                List<Integer> values = map.get(key);
                if(values != null) {
                    int left = 0;
                    int right = values.size();
                    int index = values.size();
                    while(left < right) {
                        int mid = (left+right)/2;
                        if(values.get(mid) < score) {
                            left = mid + 1;
                        } else {
                            right = mid;
                            index = mid;
                        }
                    }
                    if(values.size() > index) sum += values.size() - index;
                }
            }
            
            answer[k] = sum;
        }
        return answer;
    }
}
