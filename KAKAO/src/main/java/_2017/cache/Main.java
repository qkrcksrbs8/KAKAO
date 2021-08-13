package _2017.cache;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
	/**
	 * 카카오 캐시
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
			
            // 캐시 사이즈가 0일 경우 밑의 로직 수행 X -> 수행 시간 +5
			if (0 == cacheSize) {
				answer += 5;
				continue;
			}
            
            // 캐시에 존재하는 데이터면 순서 변경 후 수행 시간 +1
            if (qu.contains(str)) {
				qu.remove(str);
				qu.add(str);
				++answer;
				continue;
			}
			
            // 캐시 사이즈에 자리가 없을 경우 먼저 들어온 데이터 제거 후 삽입 수행 시간 +5
			if (qu.size() >= cacheSize) {
				qu.poll();
				qu.add(str);
				answer += 5;
				continue;
			}
            
            // 그 외에 캐시에 삽입 후 수행 시간 +5
			qu.add(str);
			answer += 5;
		}
		return answer;
	}
}