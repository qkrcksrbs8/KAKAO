package _2017.dartGame;

class Solution {
	
    /**
     * īī�� ��Ʈ ����
     * @param dartResult
     * @return
     */
    public int solution(String dartResult) {

    	int count	= dartResult.length();
    	int bonus 	= 0;
    	int[] arr 	= new int[3];
    	int arrCnt 	= 0;
    	for (int i = 0; i < count; ++i) {
    		char ch =  dartResult.charAt(i);
    		if (ch == 49) {
    			if (dartResult.charAt(i+1) == 48) {
    				ch = 58;
    				++i;
    			}
    		}
    		
    		//�ɼ� ����
    		switch(ch) {
    		case '*':
    			arr[arrCnt-1] *= 2;
    			if (arrCnt-1 > 0) {
    				arr[arrCnt-2] *= 2;
    			}
    			continue;
    		case '#':
    			arr[arrCnt-1] *= (-1);
    			continue;
    		}
    		
    		//���� ����
    		switch(dartResult.charAt(i+1)) {
    		case 'S':
    			bonus = 1;
    			break;
    		case 'D':
    			bonus = 2;
    			break;
    		case 'T':
    			bonus = 3;
    			break;
    		}
    		
     		arr[arrCnt] = (int) Math.round(Math.pow(ch-'0', bonus));
    		++arrCnt;
    		++i;
    	}
    	return arr[0]+arr[1]+arr[2];
	}
    
}
