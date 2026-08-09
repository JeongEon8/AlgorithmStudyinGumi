# [PGS - lv2] 01\_방금그곡

## ⏰**time**

40분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. 'C#'과 같이 #이 붙은 문자들을 소문자로 변환해서 진행 => m과 악보 정보 모두 변환
2. 재생 시간은 분단위로 변경하면 계산하기 편하다.
3. m이 포함된 것 중, 재생시간이 가장 긴 제목을 출력한다.

```java
m = replaceNote(m);
int max = -1;

// C, C#, D, D#, E, F, F#, G, G#, A, A#, B
for(String music: musicinfos) {
    String[] info = music.split(",");
    String[] start = info[0].split(":");
    String[] end = info[1].split(":");
    String title = info[2];
    String musicInfo = info[3];

    // 시간 변환
    int playTime = changeTime(Integer.parseInt(start[0]),Integer.parseInt(start[1]),
                                  Integer.parseInt(end[0]),Integer.parseInt(end[1]));

    // '#' 다른 문자로 치환
    musicInfo = replaceNote(musicInfo);

    StringBuilder tmp = new StringBuilder();
    int len = musicInfo.length();
    for (int i = 0; i < playTime; i++) {
        tmp.append(musicInfo.charAt(i % len));
    }

    if (tmp.toString().contains(m)) {
        if (playTime > max) {
            max = playTime;
            answer = title;
        }
    }
}
```

## :black_nib: **Review**

- 증빤새 가지마

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/17683>
