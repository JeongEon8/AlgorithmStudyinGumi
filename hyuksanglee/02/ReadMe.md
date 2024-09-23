# [SWEA - SSAFY Pro 연습4] No4. 성적조회
 
## ⏰  **time**
4시간

## :pushpin: **Algorithm**
- 구현, 정렬


## :round_pushpin: **Logic**
1. init 단계
   - id, 점수의 정보를 받을 수 있는 클래스 생성
   - 학년, 성별 그룹으로 나누어 담을수 있는 배열 생성
2. add 단계
   - 성별을 char[] -> Int형으로 변경
   - 해당 학년과 성별 칸에 정렬 기준에 맞게 해당 칸에 추가
        
2. remove 단계
   - 배열안에 전체를 다 탐색하면서 찾고자 하는 id를 찾으면 제거를 하고 해당 id를 탐색하고 있는 학년과 성별칸에 사이즈를 계산하고 1개 이상 있으면 첫번째 인덱스를 뽑는다.
      
4. query 단계
    - 조건에서 낮은 점수 중에서 낮은 id를 찾기 위해 id와 score라는 변수를 int최댓값으로 초기화 해준다.
    - 학년과 성별 조건에 맞는 배열만 탐색을 하면서 조건 점수 이상이면 score에 저장된 값이랑 비교하여 갱신해주고 만약 같을 경우 id를 비교해서 갱신해준다.
   	- 조건 점수 이상을 발견하면 뒤에 부분은 점수가 높기 때문에 탐색할 필요가 없어서 break문으로 빠져나온다. 
```
java
public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
		int id = Integer.MAX_VALUE;
		int score = Integer.MAX_VALUE;
		boolean check = false;

		int[] genders = new int[mGenderCnt];
		for (int i = 0; i < mGenderCnt; i++) {
			genders[i] = (mGender[i][0] == 'f') ? 1 : 0;
		}

		for (int grade : mGrade) {
			if(grade==0) {
				continue;
			}
			for (int gender : genders) {
				for (Student s : school[grade-1][gender]) {
					if (s.score >= mScore) {
						if (score > s.score) {
							id = s.id;
							score = s.score;
							check = true;
						}else if(score == s.score) {
							if(id > s.id) {
								id = s.id;
								score = s.score;
								check = true;
							}
						}
						break;
					}
				}

			}
		}
		
		
		if(check) {
//			System.out.println(id);
			return id;
		}else {
//			System.out.println(0);
			return 0;
		}
		
	}
```
```
java
public int remove(int mId) {
		int grade = -1; // 삭제한 학생의 학년
		int gender = -1; // 삭제한 학생의 성별

		int result = 0; // 결과

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < school[i][j].size(); k++) {
					if (school[i][j].get(k).id == mId) {
						grade = i;
						gender = j;
						school[grade][gender].remove(k);

						if (school[grade][gender].size() > 0) {
							result = school[grade][gender].get(0).id;
						}

						break;
					}
				}
				if (grade != -1) {
					break;
				}
			}
			if (gender != -1) {
				break;
			}
		}

//		System.out.println(result);

		return result;
	}
```

## :black_nib: **Review**
- 배열에서 해당 id를 찾을때 더 빠른 방법이 있을거 같아요



## 📡 Link
https://swexpertacademy.com/main/code/codeBattle/problemDetail.do?contestProbId=AYhwyUKaxHQDFAT2&categoryId=AZEGCEMa7TkDFAQW&categoryType=BATTLE&battleMainPageIndex=1
