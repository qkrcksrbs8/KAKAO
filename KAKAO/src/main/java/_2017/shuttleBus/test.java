package _2017.shuttleBus;

import java.util.Arrays;
public class test {

	public static String getTime(int time) {
		if (time < 10) {
			return "0"+time;
		}
		return Integer.toString(time);
	}
	
	public static void main(String[] args) {
		int n = 1;
		int t = 1;
		int m = 5;
		int limit = m;
		int last = 0;
		
//		String[] timetable = {"08:00", "08:01", "08:02", "08:03"};//1 1 5
//		String[] timetable = {"09:10", "09:09", "08:00"};//2 10 2
//		String[] timetable = {"09:00", "09:00", "09:00", "09:00"};//2 1 2
//		String[] timetable = {"00:01", "00:01", "00:01", "00:01", "00:01"};//1 1 5
//		String[] timetable = {"23:59"};//1 1 1
//		String[] timetable = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
		//10 60 45
		String[] timetable = {"00:00", "00:00", "00:00", "00:00", "00:01", "00:02", "00:03", "00:04"};//1 1 5
	
		
		int tableCnt = timetable.length;
		int start = 9*60;
		
		for (int i = 0; i < tableCnt; ++i) {
			timetable[i] = timetable[i].replaceAll(":", "");
		}
		
		Arrays.sort(timetable);
		int count = 0;
		
		for (int i = 0; i < tableCnt; ++i) {
			int hh = Integer.parseInt(timetable[i].substring(0,2));
			int time = hh*60 + Integer.parseInt(timetable[i].substring(2));
			
			if (tableCnt == 1) {
				if (time < start) {
					start = time - 1;
					continue;
				}
				continue;
			}
			
			if (start >= time) {
				++count;
				if (count >= limit ) {
					if (tableCnt < m) {
						start = 9*60;
						continue;
					}
					if (i == tableCnt-1 || last == n-1) {
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
			
			++last;
			if (last == n) {
				break;
			}
			start += t;
			--i;
			count = 0;
		}
		
		String hh = getTime(start/60);
		String mm = getTime(start%60);
		System.out.println(hh+":"+mm);
	}
}
