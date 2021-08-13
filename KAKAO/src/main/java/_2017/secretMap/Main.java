package _2017.secretMap;

class Solution {
    
    /**
     * �� �迭�� ���� ��ġ��
     * @param str1
     * @param str2
     * @param n
     * @return
     */
    public String sumArr(String str1, String str2, int n) {
		StringBuilder sb = new StringBuilder(); 
		for (int i = 0; i < n; ++i) {
			sb.append(((str1.charAt(i) + str2.charAt(i)) == 96)? " ":"#");
		}
		return sb.toString();
	}
	
	/**
	 * �� �迭�� �ڸ��� ä���ֱ�
	 * @param str
	 * @param n
	 * @return
	 */
	public String lpad(String str, int n) {
		int size 			= n - str.length();
		StringBuilder sb 	= new StringBuilder();
		for (int i = 0; i < size; ++i) {
			sb.append("0");
		}
		return sb.toString()+str;
	}
    
    /**
     * īī�� �������
     * @param n
     * @param arr1
     * @param arr2
     * @return
     */
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int arrCount 	= arr1.length;
		String[] arrStr = new String[arrCount];
        String[] answer = new String[arrCount];
        
		for (int i = 0; i < arrCount; ++i) {
			String str 			= lpad(Integer.toBinaryString(arr1[i]), n);
			StringBuilder sb	= new StringBuilder();
			for (int j = 0; j < str.length(); ++j) {
				sb.append(str.charAt(j));
			}
			arrStr[i] = sb.toString();
		}
		
		for (int i = 0; i < arrCount; ++i) {
			String str 	= lpad(Integer.toBinaryString(arr2[i]), n);
			answer[i] 	= sumArr(arrStr[i], str, n);
		}
        return answer;
    }
}
