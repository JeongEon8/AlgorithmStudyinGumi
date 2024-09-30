#include<iostream>
#include<algorithm>
#include<cstring>
#include<queue>
#define Y first
#define X second
using namespace std;
int n;
int dx[4] = {0,0,1,-1};
int dy[4] = {1,-1,0,0};
int m[504][504];
int dp[504][504];
int ret;

int func(int y, int x){
	//메모이제이션의 핵심입니다. 갔던 곳은 추가로 확인하지 않습니다.
	if(dp[y][x] != 0) return dp[y][x]; //값이 이미 있으면 바로 값을 반환합니다.
	
	dp[y][x] = 1; //처음 가본 곳은 최소 1칸을 이동할 수 있다고 할 수 있기에 1로 초기화 해줍니다.
	for(int dir=0; dir<4; dir++){ //현재 위치에서 상, 하, 좌, 우를 확인합니다.
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if(nx < 0 || ny < 0 || nx >=n || ny >= n) continue;
		if(m[ny][nx] > m[y][x]){ //대나무의 수가 더 많은 지역인지 확인합니다.
        	//현재 위치에서 갈 수 있는 최대 칸보다 ny, nx로 이동했을 때
            //더 많은 칸을 이동할 수 있는지 비교해서 갱신합니다.
			dp[y][x] = max(dp[y][x], func(ny,nx) + 1); 
		}
	}
	return dp[y][x];
}

int main(void){
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			cin >> m[i][j];
		}
	}
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			ret = max(ret, func(i,j));
		}
	}
	cout << ret;
	return 0;
}
