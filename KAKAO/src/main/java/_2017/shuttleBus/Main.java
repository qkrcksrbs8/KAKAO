package _2017.shuttleBus;

import java.util.Arrays;

class Solution {
	
	/**
	 * 시간을 두 자리로 바꿔줌. ex 9 -> 09
	 * @param time
	 * @return
	 */
	public String getTime(int time) {
		if (time < 10) {
			return "0"+time;
		}
		return Integer.toString(time);
	}
	
    /**
     * 카카오 셔틀버스
     * @param n
     * @param t
     * @param m
     * @param timetable
     * @return
     */
    public String solution(int n, int t, int m, String[] timetable) {
    	
        int limit 		= m;// 한 버스에 탈 수 있는 최대 인원
		int count 		= 0;// 한 버스에 탑승한 인원
		int lastBus 	= 0;// 마지막 버스 체크
        int tableCnt 	= timetable.length;// 배열 수
		int start 		= 9*60;// 시작 시간 -> 09:00
		Arrays.sort(timetable);// 배열 안의 시간을 순서대로 정렬
		
		for (int i = 0; i < tableCnt; ++i) {
			String[] timeArr 	= timetable[i].split(":");
			int time 			= Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
			 
			// 배열 수가 하나일 경우 로직
			if (tableCnt == 1) {
				if (time < start) {
					start = time - 1;
					continue;
				}
				continue;
			}
			
			// 첫차 시간부터 버스 탑승 로직
			if (start >= time) {
				++count;
				if (count >= limit || lastBus == n-1) {
					
					if (tableCnt < m) {
						start = 9*60;
						continue;
					}
					
					if (i == tableCnt-1) {
						if (time < start) {
							start = time-1;
							continue;
						}
						start -= 1;
						continue;
					}		
				}
				continue;
			}
			
			// 버스를 타지 못한 경우
			++lastBus;
			if (lastBus == n) {
				break;
			}
			start += t;
			--i;
			count = 0;
		}
        return getTime(start/60)+":"+getTime(start%60);
    }
}