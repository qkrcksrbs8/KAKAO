package _2017.secretMap;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static String sumArr(String str1, String str2, int n) {
		StringBuilder sb = new StringBuilder(); 
		for (int i = 0; i < n; ++i) {
			sb.append(((str1.charAt(i) + str2.charAt(i)) == 96)? " ":"#");
		}
		return sb.toString();
	}
	
	public static String lpad(String str, int n) {
		int size = n - str.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; ++i) {
			sb.append("0");
		}
		return sb.toString()+str;
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = {9,20,28,18,11};
		int[] arr2 = {30,1,21,17,28};
		int arrCount = arr1.length;
		String[] arrStr = new String[arrCount];
		for (int i = 0; i < arrCount; ++i) {
			String str = lpad(Integer.toBinaryString(arr1[i]), n);
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < str.length(); ++j) {
				sb.append(str.charAt(j));
			}
			arrStr[i] = sb.toString();
		}
		
		List<String> list = new ArrayList<>();
		for (int i = 0; i < arrCount; ++i) {
			String str = lpad(Integer.toBinaryString(arr2[i]), n);
			list.add(sumArr(arrStr[i], str, n));
		}
		System.out.println(list.toString());
		
	}
	
}
