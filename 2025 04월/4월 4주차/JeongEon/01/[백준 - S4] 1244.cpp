#include <iostream>

using namespace std;

int main() {
  int n, arr[101], std, g, y, i, k;

  cin >> n;  //스위치의 개수 입력 받기

  for(i=1; i<=n; i++) {
    cin>>arr[i];  //스위치의 상태 입력 받기
  }

  cin>>std;   //학생 수 입력 받기
  for(k=0; k<std; k++) {
    cin>>g>>y;  //학생의 성별, 번호 입력

    if(g==1) {  //남학생일 때
      for(i=1; i<=n; i++) {
        if(i%y==0){  //배수일 때
          arr[i]=!arr[i];  //스위치의 상태를 바꾼다.
        }
      }
    }
    else { //여학생일 때
      arr[y]=!arr[y];  //우선 자기자신(중심)의 상태를 바꾼다.
      for(i=1; arr[y+i] == arr[y-i]; i++) { // <x o x> || <x가 같다면 실행> 
        if(y+i>n || y-i<1) { //인덱스가 벗어나면 멈춘다.
          break;
        }
        arr[y+i]=!arr[y+i];   //뒤집
        arr[y-i]=!arr[y-i];   //뒤집
      }
    }
  }

  for(i=1; i<=n; i++) {
    cout<<arr[i]<<" ";
    if(i%20==0) { //20개의 숫자를 출력했다면 줄바꾸기
      cout<<"\n";
    }
  }

}
