package _2017.cache;

import java.util.LinkedList;
import java.util.Queue;

public class test {

	public static void main(String[] args) {
		int answer 			= 0;
		int cacheSize 		= 0;
//		String[] cities 	= {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};//3
//		String[] cities		= {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};//3
//		String[] cities		= {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};//2
//		String[] cities		= {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};//5
//		String[] cities		= {"Jeju", "Pangyo", "NewYork", "newyork"};//2
//		String[] cities		= {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};//0
		String[] cities		= {"LA", "LA"};
		int count 			= cities.length;
		Queue<String> qu 	= new LinkedList<>();
		
		for (int i = 0; i < count; ++i) {
			String str = cities[i].toLowerCase();
			if (qu.contains(str)) {
				++answer;
				qu.remove(str);
				qu.add(str);
				continue;
			}
			
			if (0 == cacheSize) {
				answer += 5;
				continue;
			}
			
			if (qu.size() >= cacheSize) {
				qu.poll();
				qu.add(str);
				answer += 5;
				continue;
			}
			qu.add(str);
			answer += 5;
		}
		System.out.println(answer);
		
	}

}
