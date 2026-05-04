"""
organize.py
매주 월요일 21:00 KST에 실행되어:
1. 항상: 멤버 폴더들을 해당 주차 폴더로 이동
2. 조건: 새 달의 1주차면 → 지난 달 주차 폴더들을 월 폴더로 이동
3. 조건: 1월 1주차면 → 지난 해 월 폴더들을 연도 폴더로 이동

주차 계산 기준: 목요일이 속한 달이 그 주의 달
예) 4월 28일(화) ~ 5월 4일(월) → 목요일 4월 30일 → 4월의 주차
"""

import os
import re
import shutil
import subprocess
from datetime import datetime, timedelta, timezone

import yaml

KST = timezone(timedelta(hours=9))
MEMBERS_YML = ".github/scripts/members.yml"

# 무시할 폴더
IGNORE_DIRS = {".github", ".git"}


# ─────────────────────────────────────────────────────
# 날짜/주차 계산
# ─────────────────────────────────────────────────────
def get_last_week_info() -> dict:
    """
    방금 끝난 주차 정보 반환
    (월요일 21:00에 실행 → 오늘이 월요일 → 지난주 화~오늘 월요일 주차)
    목요일 기준으로 달/주차 결정
    """
    now = datetime.now(KST)
    # 오늘이 월요일 → 지난주 목요일 = 3일 전
    last_thursday = now - timedelta(days=3)

    year = last_thursday.year
    month = last_thursday.month

    # 해당 월의 몇 번째 주차인지 (목요일 기준)
    # 그 달의 첫 번째 목요일 찾기
    first_day = last_thursday.replace(day=1)
    first_thursday_offset = (3 - first_day.weekday()) % 7  # 목요일=3
    first_thursday = first_day + timedelta(days=first_thursday_offset)

    week_number = ((last_thursday - first_thursday).days // 7) + 1

    # 지난주 화요일 ~ 오늘 월요일
    last_tuesday = now - timedelta(days=6)

    return {
        "year": year,
        "month": month,
        "week_number": week_number,
        "folder_name": f"{month}월 {week_number}주차",
        "month_folder_name": f"{str(year)[2:]}년 {month:02d}월",
        "year_folder_name": f"{str(year)[2:]}년",
        "week_start": last_tuesday,
        "week_end": now,
    }


def get_this_week_info() -> dict:
    """이번 주 (새로 시작된 주) 정보 - 월/연 정리 트리거 판단용"""
    now = datetime.now(KST)
    # 이번주 목요일 = 3일 후
    this_thursday = now + timedelta(days=3)

    year = this_thursday.year
    month = this_thursday.month

    first_day = this_thursday.replace(day=1)
    first_thursday_offset = (3 - first_day.weekday()) % 7
    first_thursday = first_day + timedelta(days=first_thursday_offset)
    week_number = ((this_thursday - first_thursday).days // 7) + 1

    return {
        "year": year,
        "month": month,
        "week_number": week_number,
    }


# ─────────────────────────────────────────────────────
# 멤버 폴더 목록 로드
# ─────────────────────────────────────────────────────
def load_member_folders() -> list[str]:
    with open(MEMBERS_YML, "r", encoding="utf-8") as f:
        config = yaml.safe_load(f)
    return [m["folder"] for m in config.get("members", [])]


# ─────────────────────────────────────────────────────
# git mv 실행
# ─────────────────────────────────────────────────────
def git_mv(src: str, dst: str):
    os.makedirs(os.path.dirname(dst) if os.path.dirname(dst) else dst, exist_ok=True)
    result = subprocess.run(
        ["git", "mv", src, dst],
        capture_output=True, text=True
    )
    if result.returncode != 0:
        print(f"  ⚠️  git mv 실패: {src} → {dst}\n{result.stderr}")
    else:
        print(f"  📁 이동: {src} → {dst}")


# ─────────────────────────────────────────────────────
# 1단계: 주차 정리 - 멤버 폴더 → 주차 폴더
# ─────────────────────────────────────────────────────
def organize_weekly(last_week: dict, member_folders: list[str]) -> list[str]:
    """
    멤버 폴더들을 주차 폴더로 이동
    반환: 벌금 대상자 목록 [(이름, 금액), ...]
    """
    week_folder = last_week["folder_name"]  # 예: "4월 4주차"
    print(f"\n📁 주차 정리: {week_folder}")

    moved = []
    for folder in member_folders:
        if os.path.isdir(folder):
            dst = os.path.join(week_folder, folder)
            os.makedirs(week_folder, exist_ok=True)
            git_mv(folder, dst)
            moved.append(folder)

    print(f"  ✅ {len(moved)}개 멤버 폴더 이동 완료")
    return moved


# ─────────────────────────────────────────────────────
# 2단계: 월 정리 - 지난 달 주차 폴더들 → 월 폴더
# ─────────────────────────────────────────────────────
def organize_monthly(last_week: dict):
    last_month = last_week["month"]
    last_year = last_week["year"]
    month_folder = last_week["month_folder_name"]  # 예: "26년 04월"

    print(f"\n📅 월 정리: {last_month}월 주차들 → {month_folder}/")

    # 지난 달 주차 폴더 탐색 (패턴: "4월 N주차")
    pattern = re.compile(rf"^{last_month}월 \d+주차$")
    week_folders = [d for d in os.listdir(".") if os.path.isdir(d) and pattern.match(d)]

    if not week_folders:
        print(f"  ℹ️  정리할 {last_month}월 주차 폴더 없음")
        return

    os.makedirs(month_folder, exist_ok=True)
    for wf in sorted(week_folders):
        git_mv(wf, os.path.join(month_folder, wf))

    print(f"  ✅ {len(week_folders)}개 주차 폴더 → {month_folder}/ 이동 완료")


# ─────────────────────────────────────────────────────
# 3단계: 연도 정리 - 지난 해 월 폴더들 → 연도 폴더
# ─────────────────────────────────────────────────────
def organize_yearly(last_week: dict):
    last_year = last_week["year"]
    year_short = str(last_year)[2:]  # "2025" → "25"
    year_folder = last_week["year_folder_name"]  # 예: "25년"

    print(f"\n📆 연도 정리: {last_year}년 월 폴더들 → {year_folder}/")

    # 지난 해 월 폴더 탐색 (패턴: "25년 MM월")
    pattern = re.compile(rf"^{year_short}년 \d{{2}}월$")
    month_folders = [d for d in os.listdir(".") if os.path.isdir(d) and pattern.match(d)]

    if not month_folders:
        print(f"  ℹ️  정리할 {last_year}년 월 폴더 없음")
        return

    os.makedirs(year_folder, exist_ok=True)
    for mf in sorted(month_folders):
        git_mv(mf, os.path.join(year_folder, mf))

    print(f"  ✅ {len(month_folders)}개 월 폴더 → {year_folder}/ 이동 완료")


# ─────────────────────────────────────────────────────
# 벌금 대상자 파싱 (README STATS 블록에서)
# members.yml의 folder → name 매핑으로 이름 변환
# ─────────────────────────────────────────────────────
def get_fine_list() -> list[str]:
    # members.yml에서 folder → name 매핑 로드
    with open(MEMBERS_YML, "r", encoding="utf-8") as f:
        config = yaml.safe_load(f)
    folder_to_name = {m["folder"]: m.get("name", m["folder"]) for m in config.get("members", [])}

    try:
        with open("README.md", "r", encoding="utf-8") as f:
            readme = f.read()

        m = re.search(r"<!-- STATS_START -->(.*?)<!-- STATS_END -->", readme, re.DOTALL)
        if not m:
            return []

        fines = []
        for line in m.group(1).splitlines():
            # | display | 목표 | ❌ | 💸5,000원 | 형식 파싱
            parts = [p.strip() for p in line.split("|") if p.strip()]
            if len(parts) >= 4 and "❌" in parts[2]:
                fine_str = parts[3]
                # display 안에 folder명이 포함되어 있으면 name으로 변환
                # 예: "[양성원(YSW-Yang)]..." 에서 folder "YSW" 매칭 → "양성원"
                name = parts[0]  # 기본값
                for folder, n in folder_to_name.items():
                    if folder in parts[0]:
                        name = n
                        break
                # 금액 추출
                amount_match = re.search(r"[\d,]+원", fine_str)
                if amount_match:
                    fines.append(f"{name} {amount_match.group()}")
        return fines
    except Exception as e:
        print(f"  ⚠️  벌금 파싱 실패: {e}")
        return []


# ─────────────────────────────────────────────────────
# 커밋 메시지 파일 작성
# ─────────────────────────────────────────────────────
def write_commit_args(week_folder: str, fines: list[str], commit_type: str, extra_msg: str = ""):
    """
    git commit 인자를 파일로 저장
    commit_type: "weekly" | "monthly" | "yearly"
    """
    if commit_type == "weekly":
        title = f"{week_folder} 완료"
        body = ", ".join(fines) if fines else "전원 달성"
    elif commit_type == "monthly":
        title = extra_msg  # "26년 4월 스터디 완료"
        body = ""
    else:  # yearly
        title = extra_msg  # "25년 스터디 마무리"
        body = ""

    with open("/tmp/organize_commit_title.txt", "w") as f:
        f.write(title)
    with open("/tmp/organize_commit_body.txt", "w") as f:
        f.write(body)

    print(f"\n📝 커밋 메시지: {title}")
    if body:
        print(f"   상세: {body}")


# ─────────────────────────────────────────────────────
# 메인
# ─────────────────────────────────────────────────────
def main():
    last_week = get_last_week_info()
    this_week = get_this_week_info()
    member_folders = load_member_folders()

    print(f"📅 지난 주차: {last_week['folder_name']} ({last_week['year']}년 {last_week['month']}월)")
    print(f"📅 이번 주차: {this_week['year']}년 {this_week['month']}월 {this_week['week_number']}주차")

    # 벌금 대상자 파싱 (폴더 이동 전에 먼저 읽기)
    fines = get_fine_list()
    print(f"💸 벌금 대상자: {fines if fines else '없음'}")

    commit_type = "weekly"
    extra_msg = ""

    # ── 1. 항상: 주차 정리 ──
    organize_weekly(last_week, member_folders)

    # ── 2. 조건: 새 달 1주차 → 지난 달 월 정리 ──
    if this_week["week_number"] == 1:
        organize_monthly(last_week)
        commit_type = "monthly"
        extra_msg = f"{str(last_week['year'])[2:]}년 {last_week['month']}월 스터디 완료"

        # ── 3. 조건: 1월 1주차 → 지난 해 연도 정리 ──
        if this_week["month"] == 1:
            organize_yearly(last_week)
            commit_type = "yearly"
            extra_msg = f"{str(last_week['year'])[2:]}년 스터디 마무리"

    # 커밋 메시지 작성
    write_commit_args(last_week["folder_name"], fines, commit_type, extra_msg)
    print("\n✅ 폴더 정리 완료")


if __name__ == "__main__":
    main()
