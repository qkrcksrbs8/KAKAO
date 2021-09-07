package _2017.shuttleBus;

import java.util.Arrays;

class Solution {

	public String getTime(int time) {
		if (time < 10) {
			return "0"+time;
		}
		return Integer.toString(time);
	}

    public String solution(int n, int t, int m, String[] timetable) {
    	
        int limit 		= m;
		int count 		= 0;
		int lastBus 	= 0;
        int tableCnt 	= timetable.length;
		int start 		= 9*60;
		Arrays.sort(timetable);
		
		for (int i = 0; i < tableCnt; ++i) {
			String[] timeArr 	= timetable[i].split(":");
			int time 			= Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);

			if (tableCnt == 1) {
				if (time < start) {
					start = time - 1;
					continue;
				}
				continue;
			}

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