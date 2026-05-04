package programmers;

import java.util.*;

public class Pragrammers_과제진행하기 {

	static class Info implements Comparable<Info> {
        String name;
        int hour;
        int minute;
        int work;
        Info(String name, int hour, int minute, int work){
            this.name = name;
            this.hour = hour;
            this.minute = minute;
            this.work = work;
        }
        
        @Override
        public int compareTo(Info o ){
            if(this.hour == o.hour){
                return this.minute - o.minute;
            }
            return this.hour - o.hour;
        }
        
    }
    public String[] solution(String[][] plans) {
        
        
        
        
        int len = plans.length;
        String[] answer = new String[len];
        Info[] infos = new Info[len];
        for(int l = 0; l < len; l++){
            String n = plans[l][0];
            String[] t = plans[l][1].split(":");
            int w = Integer.parseInt(plans[l][2]);
            int h = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);
            
            Info info = new Info(n,h,m,w);
            infos[l] = info;
        }
        Arrays.sort(infos);
        
        int startH = infos[0].hour;
        int startM = infos[0].minute;
        
        Stack<Info> stack = new Stack<Info>();
        Queue<String> que = new ArrayDeque<String>();
        for(int l = 0; l<len; l++){
            Info info = infos[l];
            int time = (info.hour - startH)*60 + info.minute - startM;
            while(time !=0 && !stack.isEmpty()){
                Info infoS = stack.pop();
                if (infoS.work <= time) {         
                    time -= infoS.work;
                    que.add(infoS.name);           
                } else {                           
                    infoS.work -= time;             
                    stack.push(infoS);              
                    time = 0;
                }
            }
            stack.push(info);
            startH = info.hour;
            startM = info.minute;
            
        }
        
        while(!stack.isEmpty()){
            Info i = stack.pop();
            que.add(i.name);
        }
        
        int index = 0;
        for(String s : que){
            answer[index] = s;
            index++;
        }
        
        return answer;
    }

}
