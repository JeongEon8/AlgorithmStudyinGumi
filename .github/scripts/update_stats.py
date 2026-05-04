"""
update_stats.py
- members.yml 에서 멤버/목표 설정을 읽고
- 각 멤버의 문제풀이 README.md 제목에서 플랫폼·레벨을 파싱해 목표 달성 여부를 판정
- 메인 README.md 의 <!-- STATS_START --> ~ <!-- STATS_END --> 블록을 자동 업데이트
"""

import os
import re
import subprocess
from datetime import datetime, timedelta, timezone

import yaml  # pip install pyyaml

# ─────────────────────────────────────────────────────
# 상수
# ─────────────────────────────────────────────────────
KST = timezone(timedelta(hours=9))
README_PATH = "README.md"
MEMBERS_YML = ".github/scripts/members.yml"

# 플랫폼 인식 별칭 (대괄호 안 사이트명 기준, 소문자+공백제거 후 비교)
PROGRAMMERS_ALIASES = {"프로그래머스", "플그머", "programmers", "pgs"}
LEETCODE_ALIASES    = {"릿코드", "리트코드", "leetcode", "leet"}
SWEA_ALIASES        = {"swea", "스웨아", "스웨어"}

# ─────────────────────────────────────────────────────
# 동급 레벨 변환 테이블 (공통 점수로 비교)
# 그룹 A (점수 2): 프로그래머스 Lv2  =  릿코드 Medium
# 그룹 B (점수 3): 프로그래머스 Lv3  =  릿코드 Hard  =  백준 Gold
# 상위 레벨은 항상 하위 목표 대체 가능
# ─────────────────────────────────────────────────────
UNIFIED_SCORE: dict[tuple[str, str], int] = {
    # 프로그래머스
    ("programmers", "lv0"): 0,
    ("programmers", "lv1"): 1,
    ("programmers", "lv2"): 2,
    ("programmers", "lv3"): 3,
    ("programmers", "lv4"): 4,
    ("programmers", "lv5"): 5,
    # 릿코드
    ("leetcode", "easy"):   1,
    ("leetcode", "medium"): 2,
    ("leetcode", "hard"):   3,
    # SWEA
    ("swea", "D1"):         1,
    ("swea", "D2"):         2,
    ("swea", "D3"):         3,
    ("swea", "D4"):         4,
    ("swea", "D5"):         5,
    ("swea", "D6"):         6,
    ("swea", "D7"):         7,
    ("swea", "D8"):         8,
}


# ─────────────────────────────────────────────────────
# 이번 주 기간: 화요일 00:00 ~ 다음 월요일 20:00 (KST)
# ─────────────────────────────────────────────────────
def get_week_range(readme_content: str | None = None) -> tuple[datetime, datetime]:
    if readme_content:                  # readme가 None이 아닐 경우
        # "### 제 00회 [00.00.00 ~ 00.00.00] (진행중)" 패턴 탐색
        m = re.search(
            r"###\s*제\s*\d+회\s*\[(\d{2})\.(\d{2})\.(\d{2})\s*~\s*(\d{2})\.(\d{2})\.(\d{2})\]\s*\(진행중\)",
            readme_content,
        )
        if m:                           # 진행 중인 기간이 있을 경우 -> 파싱
            sy, sm, sd = int(m.group(1)) + 2000, int(m.group(2)), int(m.group(3))
            ey, em, ed = int(m.group(4)) + 2000, int(m.group(5)), int(m.group(6))
            week_start = datetime(sy, sm, sd,  0,  0, 0, tzinfo=KST)
            week_end   = datetime(ey, em, ed, 20,  0, 0, tzinfo=KST)
            print(f"📅 진행중 회차에서 날짜 파싱: {week_start.strftime('%Y-%m-%d')} ~ {week_end.strftime('%Y-%m-%d')}")
            return week_start, week_end
        
        print("⚠️  '진행중' 회차를 찾지 못했습니다.")
    return None, None


# ─────────────────────────────────────────────────────
# git log: 파일 최초 커밋 시간 (KST)
# ─────────────────────────────────────────────────────
def get_lastest_commit_time(filepath: str) -> datetime | None:
    try:
        result = subprocess.run(
            ["git", "log", "--follow", "--format=%aI", "-1", "--", filepath],
            capture_output=True, text=True, check=True,
        )
        lines = result.stdout.strip().splitlines()
        if not lines:
            return None
        return datetime.fromisoformat(lines[0]).astimezone(KST)
    except Exception:
        return None


# ─────────────────────────────────────────────────────
# README H1에서 (platform, level) 파싱
# 형식: # [사이트 - 레벨] 번호. 제목
# ─────────────────────────────────────────────────────
def parse_readme_level(readme_path: str) -> tuple[str, str] | None:
    try:
        with open(readme_path, "r", encoding="utf-8") as f:
            for line in f:
                line = line.strip()
                if not re.match(r"^# ", line):
                    continue
                m = re.search(r"\[(.+?)\]", line)
                if not m:
                    return None

                bracket = m.group(1)
                # 대괄호 안에서 사이트명만 추출 (대시 앞부분)
                # "[프로그래머스 - Lv2]" → site="프로그래머스", rest="lv2"
                parts = bracket.split("-", 1)
                site = parts[0].strip().lower().replace(" ", "")
                rest = parts[1].strip().lower().replace(" ", "") if len(parts) > 1 else ""

                # ── 프로그래머스 ──
                if site in PROGRAMMERS_ALIASES:
                    lv = re.search(r"lv\.?(\d)", rest)
                    return ("programmers", f"lv{lv.group(1)}" if lv else "lv0")

                # ── 릿코드 ──
                if site in LEETCODE_ALIASES:
                    if "hard" in rest or "하드" in rest:
                        return ("leetcode", "hard")
                    elif "medium" in rest or "미디움" in rest:
                        return ("leetcode", "medium")
                    return ("leetcode", "easy")

                # ── SWEA ──
                if site in SWEA_ALIASES:
                    lv = re.search(r"D?(\d)", rest)
                    return ("swea", f"lv{lv.group(1)}" if lv else "D1")

                return ("unknown", "unknown")
    except Exception:
        pass
    return None


# ─────────────────────────────────────────────────────
# 목표 문자열 파싱
# 형식:
#   단일:  "programmers,lv2,3"
#   OR:    "programmers,lv2,2 OR leetcode,medium,2"  -> 합산 2개
#   AND:   "programmers,lv2,3 AND programmers,lv3,1" -> 각각 동시 충족
# ─────────────────────────────────────────────────────
def parse_single_goal(goal_str: str) -> dict | None:
    parts = [p.strip() for p in goal_str.split(",")]
    if len(parts) != 3:
        return None
    platform, level, count = parts
    return {"platform": platform.lower(), "level": level.lower(), "count": int(count)}


def parse_goals(goal_raw: str) -> dict:
    if " AND " in goal_raw:
        parts = [parse_single_goal(g.strip()) for g in goal_raw.split(" AND ")]
        return {"type": "AND", "groups": [g for g in parts if g]}
    else:
        parts = [parse_single_goal(g.strip()) for g in goal_raw.split(" OR ")]
        return {"type": "OR", "groups": [g for g in parts if g]}


# ─────────────────────────────────────────────────────
# 레벨 충족 여부 (동급 플랫폼 자동 대체 포함)
# ─────────────────────────────────────────────────────
def meets_level(actual_platform: str, actual_level: str, goal: dict) -> bool:
    actual_score = UNIFIED_SCORE.get((actual_platform, actual_level), -999)
    goal_score   = UNIFIED_SCORE.get((goal["platform"], goal["level"]), 999)
    return actual_score >= goal_score


# ─────────────────────────────────────────────────────
# 멤버의 이번 주 유효 제출 수 계산
# AND: 각 조건별 카운트를 따로 집계 후 모두 충족 여부 반환
# OR:  조건 중 하나라도 충족하면 합산 카운트
# ─────────────────────────────────────────────────────
def count_valid_submissions(member: dict, week_start: datetime, week_end: datetime) -> dict:
    print(f"🔍 {member.get('name', member['folder'])} 맴버의 목표를 확인합니다")
    goal_raw = member.get("goal", "")
    print(f"📍 {member.get('goal_text', '')}")
    
    
    folder = member["folder"]
    if not os.path.isdir(folder) or not goal_raw:                                       # 만약 해당 폴더가 없다면
        print(f"⚠️ {member.get('name', '')} 멤버의 폴더를 찾을 수 없습니다.")
        return {"counts": [0], "goal": parse_goals(goal_raw) if goal_raw else None}     # 제출 수: 0개 반환

    parsed_goal = parse_goals(goal_raw)                                                 # 목표 파싱

    # AND: 각 조건별 카운트 배열, OR: 단일 합산 카운트
    if parsed_goal["type"] == "AND":
        counts = [0] * len(parsed_goal["groups"])
    else:
        counts = [0]

    for problem_dir in sorted(os.listdir(folder)):
        problem_path = os.path.join(folder, problem_dir)

        # 폴더가 아닌 경우 스킵
        if not os.path.isdir(problem_path):
            print("🔍 { problem_path }는 폴더 구성 규칙을 따르지 않아, 스킵합니다 💨💨")
            continue

        # 폴더 규칙을 따르지 않는 경우 스킵 (ex 01/, 02/)
        if not re.match(r"^\d{1,3}$", problem_dir):
            print("🔍 { problem_path }는 폴더 이름 규칙을 따르지 않아, 스킵합니다 💨💨")
            continue

        # 대소문자 구분 없이 README.md 찾기
        readme_file = None
        for fname in os.listdir(problem_path):
            if fname.lower() == "readme.md":
                readme_file = os.path.join(problem_path, fname)
                break
        
        # 정해진 규칙 폴더 내 readme 파일이 없는 경우 스킵
        if readme_file is None:
            print(f"🔍 {problem_path} 내 README 파일이 없어, 스킵합니다 💨💨")
            continue

        commit_time = get_lastest_commit_time(readme_file)  # 최근 커밋 시간 반환

        # 이번 주 커밋이 아닌 경우 스킵
        if not (commit_time and week_start <= commit_time < week_end):
            print(f"❌ 이번 주 커밋이 아닙니다. {commit_time} {readme_file}")
            continue

        print(f"✅ 이번 주 커밋입니다!. {commit_time} {readme_file}")
        
        # 레벨 파싱
        parsed = parse_readme_level(readme_file)            # 문제 사이트, 문제 난이도 반환
        if parsed is None:
            print(f"⚠️  레벨 파싱 실패: {readme_file}")
            continue

        actual_platform, actual_level = parsed

        if parsed_goal["type"] == "AND":
            # AND: 가장 엄격한(높은 레벨) 조건에 먼저 배정
            # 예: Lv2 3개 AND Lv3 1개 → Lv3 문제는 counts[1]에 먼저 배정
            # 각 조건의 goal_score 기준으로 내림차순 정렬 후 배정
            groups_with_idx = sorted(
                enumerate(parsed_goal["groups"]),
                key=lambda x: UNIFIED_SCORE.get((x[1]["platform"], x[1]["level"]), 0),
                reverse=True  # 높은 레벨 조건 먼저
            )
            for i, goal in groups_with_idx:
                if meets_level(actual_platform, actual_level, goal):
                    counts[i] += 1
                    print(f"✅ {goal} 유효: {readme_file} ({actual_platform}/{actual_level})")
                    break
        else:
            # OR: 하나라도 충족하면 합산
            for goal in parsed_goal["groups"]:
                if meets_level(actual_platform, actual_level, goal):
                    counts[0] += 1
                    print(f"✅ 유효: {readme_file} ({actual_platform}/{actual_level})")
                    break
            else:
                print(f"❌ 레벨 미달: {readme_file} ({actual_platform}/{actual_level})")

    return {"counts": counts, "goal": parsed_goal}


def is_achieved(result: dict) -> bool:
    parsed_goal = result["goal"]
    counts = result["counts"]
    if parsed_goal["type"] == "AND":
        # AND: 모든 조건 각각 충족
        return all(counts[i] >= parsed_goal["groups"][i]["count"] for i in range(len(parsed_goal["groups"])))
    else:
        # OR: 합산 카운트가 첫 번째 조건의 required 이상
        required = parsed_goal["groups"][0]["count"] if parsed_goal["groups"] else 1
        return counts[0] >= required


def get_ratio(result: dict) -> float:
    parsed_goal = result["goal"]
    counts = result["counts"]
    if parsed_goal["type"] == "AND":        # 전체 개수 대비 푼 개수를 기반으로 % 산정
        total_submitted = sum(counts)
        total_required = sum(g["count"] for g in parsed_goal["groups"])
        return total_submitted / total_required if total_required > 0 else 1.0


# ─────────────────────────────────────────────────────
# 벌금 판정
# ─────────────────────────────────────────────────────
def judge(result: dict | None, goal_raw: str, exempt: bool) -> tuple[str, str]:
    if exempt:
        return "-", "-"

    if result is None:
        return "-", "-"

    achieved = is_achieved(result)
    ratio = get_ratio(result) or 0.0

    if achieved:
        return "✅", "✨굳✨"
    elif ratio >= 0.5:
        return "❌", "💸5,000원"
    else:
        return "❌", "💸10,000원"


# ─────────────────────────────────────────────────────
# 테이블 생성
# ─────────────────────────────────────────────────────
def build_table(members: list[dict], week_start: datetime, week_end:datetime) -> str:
    header = (
        "| 아이디 | 목표 | 달성 여부 | 벌금 |\n"
        "| ------ | ---- | :-------: | :--: |"
    )
    rows = []

    for m in members:                                                           # 맴버별로 확인
        exempt = m.get("exempt", False)                                         # 참여 여부 (false = 참여, true = 불참)
        goal_text = m.get("goal_text", m.get("goal", ""))                       # 맴버별 목표

        if exempt:                                                              # 불참한다면, 목표달성과 벌금 모두 (-)
            status, fine = "-", "-"
        else:                                                                   # 참여한다면
            result = count_valid_submissions(m, week_start, week_end)           # 이번주에 어떤 난이도의 문제를 몇개 올렸는지 확인
            status, fine = judge(result, m.get("goal", ""), exempt)             # 목표와 올린 것을 비교하면 목표 달성 여부와 벌금 계산
            print(f"🗨️ {m['name']}의 결과를 출력합니다 {status} {fine}")

        rows.append(f"| {m['display']} | {goal_text} | {status} | {fine} |")

    period = (
        f"{week_start.strftime('%y.%m.%d')} ~ "
        f"{week_end.strftime('%y.%m.%d')} 20:00 KST 기준"
    )
    return f"{header}\n" + "\n".join(rows) + f"\n\n> 📅 {period}"


# ─────────────────────────────────────────────────────
# 목표 테이블 (-)으로 초기화
# ─────────────────────────────────────────────────────

def build_blank_table(members: list[dict]) -> str:
    header = (
        "| 아이디 | 목표 | 달성 여부 | 벌금 |\n"
        "| ------ | ---- | :-------: | :--: |"
    )
    rows = []
    for m in members:
        rows.append(f"| {m['display']} | - | - | - |")
    return f"{header}\n" + "\n".join(rows) + "\n\n> 📅 휴식 주차"


# ─────────────────────────────────────────────────────
# README 목표 블록 교체
# ─────────────────────────────────────────────────────
def update_readme(content: str, new_table: str) -> str:
    pattern = r"<!-- STATS_START -->.*?<!-- STATS_END -->"
    replacement = f"<!-- STATS_START -->\n{new_table}\n<!-- STATS_END -->"
    if re.search(pattern, content, re.DOTALL):
        return re.sub(pattern, replacement, content, flags=re.DOTALL)
    return content.rstrip() + f"\n\n{replacement}\n"


# ─────────────────────────────────────────────────────
# 메인
# ─────────────────────────────────────────────────────
def main():
    with open(MEMBERS_YML, "r", encoding="utf-8") as f:             # members.yml 파일을 읽음
        config = yaml.safe_load(f)                                  # yaml 파일을 딕셔너리 자료형으로 변환해서 config에 저장
    members = config.get("members", [])                             # config 중 members키에 해당하는 데이터를 저장
    print(f"✅ 멤버 {len(members)}명 로드")                         

    with open(README_PATH, "r", encoding="utf-8") as f:             # 메인 README.md 파일 읽음
        content = f.read()                                          # README에 있는 문자열들을 모두 content에 저장

    week_start, week_end = get_week_range(content)                  # get_week_range()를 통해 이번주를 인식함
    if week_start is None:                                          # readme에 진행 중인 날짜가 없는 경우
        print("⚠️  진행중 회차 없음 → 테이블 초기화 후 종료")
        blank_table = build_blank_table(members)                    # | 맴버 이름 | - | - | - |     로 초기화
        new_content = update_readme(content, blank_table)           # 목표 블럭을 변경한다.
        with open(README_PATH, "w", encoding="utf-8") as f:
            f.write(new_content)
        print("✅ 테이블 초기화 완료")
        sys.exit(0)

    print(f"📅 집계 기간: {week_start.strftime('%Y-%m-%d %H:%M')} ~ {week_end.strftime('%Y-%m-%d %H:%M')} KST")

    new_table = build_table(members, week_start, week_end)          # 목표 확인해서 테이블 만드는 함수 호출
    new_content = update_readme(content, new_table)                 # 목표 블럭을 변경한다.

    with open(README_PATH, "w", encoding="utf-8") as f:             # 파일로 작성한다.
        f.write(new_content)

    print("✅ README.md 업데이트 완료")


if __name__ == "__main__":
    main()
