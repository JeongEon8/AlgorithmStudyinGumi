# [프로그래머스 - 2] 할인 행사


## ⏰ **time**
20분

## :pushpin: **Algorithm**
구현, 해시, 슬라이딩 윈도우

## ⏲️**Time Complexity**
O(D*W)

## :round_pushpin: **Logic**
1. 원하는 상품과 수량을 Map으로 저장 (wantmap)
2. discount 배열을 10일 단위로 순회
- 각 10일 구간의 상품 수량을 Map으로 계산 (discountmap)
3. wantmap의 모든 상품이 discountmap에 충분히 있는지 확인
- 하나라도 부족하면 해당 구간 패스
- 모두 충족하면 answer 증가
4. answer 반환

## :black_nib: **Review** 
낫밷

## 📡**Link**
