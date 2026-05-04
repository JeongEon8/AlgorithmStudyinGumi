"""
new_week.py
매주 화요일 00:00 KST에 실행되어:
1. CURRENT_ROUND 블록의 진행중 회차를 진행완료로 처리 후 details 블록으로 이동
2. 새 회차 번호 / 날짜로 CURRENT_ROUND 블록 교체
3. update_stats.py를 실행해서 테이블 날짜도 새 기간으로 업데이트
"""

import re
import sys
import importlib.util
import pathlib
from datetime import datetime, timedelta, timezone

KST = timezone(timedelta(hours=9))
README_PATH = "README.md"


def get_this_week() -> tuple[datetime, datetime]:
    """이번 화요일 00:00 ~ 다음 월요일 20:00 KST"""
    now = datetime.now(KST)
    days_since_tuesday = (now.weekday() - 1) % 7
    tuesday = now - timedelta(days=days_since_tuesday)
    week_start = tuesday.replace(hour=0, minute=0, second=0, microsecond=0)
    week_end = (week_start + timedelta(days=6)).replace(hour=20, minute=0, second=0, microsecond=0)
    return week_start, week_end


def parse_current_round(block_content: str) -> tuple[int, str, str] | None:
    """
    CURRENT_ROUND 블록 안에서 진행중 회차 파싱
    반환: (회차번호, 시작일 "YY.MM.DD", 종료일 "YY.MM.DD")
    """
    m = re.search(
        r"###\s*제\s*(\d+)회\s*\[(\d{2}\.\d{2}\.\d{2})\s*~\s*(\d{2}\.\d{2}\.\d{2})\]\s*\(진행중\)",
        block_content,
    )
    if not m:
        return None
    return int(m.group(1)), m.group(2), m.group(3)


def get_year_from_date(date_str: str) -> int:
    """'26.04.21' → 2026"""
    return int(date_str.split(".")[0]) + 2000


def update_readme(content: str) -> str:
    week_start, week_end = get_this_week()
    new_start = week_start.strftime("%y.%m.%d")
    new_end   = week_end.strftime("%y.%m.%d")

    # ── CURRENT_ROUND 블록 추출 ──
    block_pattern = r"<!-- CURRENT_ROUND_START -->.*?<!-- CURRENT_ROUND_END -->"
    block_match = re.search(block_pattern, content, re.DOTALL)
    if not block_match:
        print("⚠️  CURRENT_ROUND 블록을 찾을 수 없습니다.")
        sys.exit(1)

    block_content = block_match.group(0)
    parsed = parse_current_round(block_content)
    if not parsed:
        print("⚠️  CURRENT_ROUND 블록 안에서 진행중 회차를 찾을 수 없습니다.")
        sys.exit(1)

    current_round, old_start, old_end = parsed
    old_year = get_year_from_date(old_start)
    next_round = current_round + 1

    # ── 1. CURRENT_ROUND 블록을 새 회차로 교체 ──
    new_round_line = f"### 제 {next_round}회 [{new_start} ~ {new_end}] (진행중)"
    new_block = f"<!-- CURRENT_ROUND_START -->\n{new_round_line}\n<!-- CURRENT_ROUND_END -->"
    content = re.sub(block_pattern, new_block, content, flags=re.DOTALL)

    # ── 2. 완료된 회차를 연도별 details 블록 안으로 이동 ──
    done_entry = f"  - 제 {current_round}회 [{old_start} ~ {old_end}] (진행완료) <br>"
    year_label = f"{old_year}년"
    year_summary = f"<summary>{year_label}</summary>"

    if year_summary in content:
        # 해당 연도 details 블록의 </details> 바로 앞에 삽입
        year_pattern = rf"(<summary>{re.escape(year_label)}</summary>.*?)(</details>)"
        def insert_entry(m):
            return m.group(1) + f"{done_entry}\n" + m.group(2)
        content = re.sub(year_pattern, insert_entry, content, count=1, flags=re.DOTALL)
    else:
        # 해당 연도 details 블록이 없으면 새로 생성해서 마지막 </details> 뒤에 추가
        new_block = (
            f"\n<details>\n"
            f"    <summary>{year_label}</summary>\n"
            f"{done_entry}\n"
            f"</details>"
        )
        last_details = content.rfind("</details>")
        if last_details != -1:
            insert_pos = last_details + len("</details>")
            content = content[:insert_pos] + new_block + content[insert_pos:]
        else:
            content += new_block

    print(f"✅ 제 {current_round}회 진행완료 처리")
    print(f"✅ 제 {next_round}회 [{new_start} ~ {new_end}] 진행중 추가")
    return content


def main():
    with open(README_PATH, "r", encoding="utf-8") as f:
        content = f.read()

    content = update_readme(content)

    with open(README_PATH, "w", encoding="utf-8") as f:
        f.write(content)

    # update_stats.py도 바로 실행해서 테이블 날짜 반영
    import subprocess
    result = subprocess.run(
        ["python", ".github/scripts/update_stats.py"],
        capture_output=True, text=True
    )
    print(result.stdout)
    if result.returncode != 0:
        print(f"⚠️  update_stats.py 실행 실패:\n{result.stderr}")
        sys.exit(1)

    print("✅ 새 회차 업데이트 완료")


if __name__ == "__main__":
    main()
