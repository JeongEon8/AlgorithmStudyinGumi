#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <vector>
#include <cmath>
#include <list>
#include <queue>
#include <stack>
#include <map>
#include <ctime>
#include <string.h>
 
using namespace std;
 
int main(void)
{
    int n, maxDP[3] = { 0,0,0 }, minDP[3] = { 0,0,0 }, input[3], temp_0, temp_2;
    scanf("%d", &n);
    scanf("%d %d %d", &maxDP[0], &maxDP[1], &maxDP[2]);
    minDP[0] = maxDP[0]; minDP[1] = maxDP[1]; minDP[2] = maxDP[2];
 
 
    for (int i = 1; i < n; i++) {
        scanf("%d %d %d", &input[0], &input[1], &input[2]);
        //최대값을 구해주는 DP배열 
        temp_0 = maxDP[0]; temp_2 = maxDP[2];
        maxDP[0] = max(maxDP[0], maxDP[1]) + input[0];
        maxDP[2] = max(maxDP[1], maxDP[2]) + input[2];
        maxDP[1] = max(max(temp_0, maxDP[1]), temp_2) + input[1];
        //최소값을 구해주는 DP배열
        temp_0 = minDP[0]; temp_2 = minDP[2];
        minDP[0] = min(minDP[0], minDP[1]) + input[0];
        minDP[2] = min(minDP[1], minDP[2]) + input[2];
        minDP[1] = min(min(temp_0, minDP[1]), temp_2) + input[1];
    }
 
    printf("%d ", max(max(maxDP[0], maxDP[1]), maxDP[2]));
    printf("%d", min(min(minDP[0], minDP[1]), minDP[2]));
    return 0;
}