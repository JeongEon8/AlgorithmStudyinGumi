#include <string>
#include <map>
#include <iostream>
using namespace std;

int solution(string dirs) {
    int answer = 0;
    map<pair<pair<int,int>,pair<int,int>>, bool> m;
    int x,y,nx,ny; 
    x=0; y=0; nx=0; ny=0;
    for(int i=0; i<dirs.length(); i++) {
        if(dirs[i]=='U' && ny+1<=5) {
            ny++;
        } else if(dirs[i]=='D' && ny-1>=-5) {
            ny--;
        } else if(dirs[i]=='R' && nx+1<=5) {
            nx++;
        } else if(dirs[i]=='L' && nx-1>=-5) {
            nx--;
        } else { 
            continue;
        }
        
        if(m.find(make_pair(make_pair(x,y),make_pair(nx,ny)))==m.end() && 
           m.find(make_pair(make_pair(nx,ny),make_pair(x,y)))==m.end()) {
            m.insert({make_pair(make_pair(x,y),make_pair(nx,ny)), true}); 
            answer++;
        }
           x=nx; y=ny;
    }
    
    return answer;
}
