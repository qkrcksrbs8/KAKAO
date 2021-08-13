package _2017.shuttleBus;

import java.util.Arrays;

class Solution {
	
	/**
	 * �ð��� �� �ڸ��� �ٲ���. ex 9 -> 09
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
     * īī�� ��Ʋ����
     * @param n
     * @param t
     * @param m
     * @param timetable
     * @return
     */
    public String solution(int n, int t, int m, String[] timetable) {
    	
        int limit 		= m;// �� ������ Ż �� �ִ� �ִ� �ο�
		int count 		= 0;// �� ������ ž���� �ο�
		int lastBus 	= 0;// ������ ���� üũ
        int tableCnt 	= timetable.length;// �迭 ��
		int start 		= 9*60;// ���� �ð� -> 09:00
		Arrays.sort(timetable);// �迭 ���� �ð��� ������� ����
		
		for (int i = 0; i < tableCnt; ++i) {
			String[] timeArr 	= timetable[i].split(":");
			int time 			= Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
			 
			// �迭 ���� �ϳ��� ��� ����
			if (tableCnt == 1) {
				if (time < start) {
					start = time - 1;
					continue;
				}
				continue;
			}
			
			// ù�� �ð����� ���� ž�� ����
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
			
			// ������ Ÿ�� ���� ���
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