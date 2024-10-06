# [SWEA - D6] 1257. K번째 문자열
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
단순 구현으로 풀었음...

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. n^2으로 모든 가능한 문자열 구한 후 n log n으로 정렬
   ```cpp
		for(int ct=1;ct<=ctn;ct++){
        int n;
        cin>>n;
        string s;
        cin>>s;
        vector<string>v;
        unordered_set<string>set;
 
        for(int i=0;i<s.size();i++){
            string tmp ="";
            for(int j=i;j<s.size();j++){
                tmp+=s[j];
                if(!set.count(tmp)){
                    v.push_back(tmp);
                    set.insert(tmp);
                }
            }
        }
 
        if(n>v.size()){
            cout << '#' << ct << " none" << v[n] << '\n';
        }else {
            sort(v.begin(), v.end());
            cout << '#' << ct << ' ' << v[n-1] << '\n';
        }
    }
   ```

## :black_nib: **Review**
- 

## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18KWf6ItECFAZN
