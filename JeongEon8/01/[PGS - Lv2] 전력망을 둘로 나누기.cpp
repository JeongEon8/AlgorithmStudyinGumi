#include <string>
#include <vector>

using namespace std;

vector<int> m[200];

int DFS(int togo, int now, int count)
{
    for(int i = 0; i < m[now].size(); i++)
    {
        if(m[now][i] != togo)
        {
            count = DFS(now, m[now][i], count + 1);
        }
    }
    return count;
}

int solution(int n, vector<vector<int>> wires) {
    int answer = 2000;
    for(auto w : wires)
    {
        m[w[0]].push_back(w[1]);
        m[w[1]].push_back(w[0]);
    }
    
    for(auto w : wires)
    {
        int sum = DFS(w[0], w[1], 1);
        int comp = n - (2 * sum);
        answer = min(answer, abs(comp));
    }
    return answer;
}
