package _2017.cache;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
	/**
	 * īī�� ĳ��
	 * @param cacheSize
	 * @param cities
	 * @return
	*/
	public int solution(int cacheSize, String[] cities) {
		int answer 			= 0;
		int count 			= cities.length;
		Queue<String> qu 	= new LinkedList<>();
		
		for (int i = 0; i < count; ++i) {
			String str = cities[i].toLowerCase();
			
            // ĳ�� ����� 0�� ��� ���� ���� ���� X -> ���� �ð� +5
			if (0 == cacheSize) {
				answer += 5;
				continue;
			}
            
            // ĳ�ÿ� �����ϴ� �����͸� ���� ���� �� ���� �ð� +1
            if (qu.contains(str)) {
				qu.remove(str);
				qu.add(str);
				++answer;
				continue;
			}
			
            // ĳ�� ����� �ڸ��� ���� ��� ���� ���� ������ ���� �� ���� ���� �ð� +5
			if (qu.size() >= cacheSize) {
				qu.poll();
				qu.add(str);
				answer += 5;
				continue;
			}
            
            // �� �ܿ� ĳ�ÿ� ���� �� ���� �ð� +5
			qu.add(str);
			answer += 5;
		}
		return answer;
	}
}