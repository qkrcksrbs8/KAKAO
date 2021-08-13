package _2017.dartGame;

public class test {

	public static void main(String[] args) {
//    	System.out.println(((1^1) * 2) + ((2^2) * 2) + (3^3));
//    	String dart = "1S2D*3T";
//    	String dart = "1D2S#10S";
//    	String dart = "1D2S0T";
    	String dart = "1S*2T*3S";
//    	String dart = "1D#2S*3S";
//    	String dart = "1T2D3D#";
//    	String dart = "1D2S3T*";
    	int count	= dart.length();
    	int bonus 	= 0;
    	int[] arr 	= new int[3];
    	int arrCnt 	= 0;
    	for (int i = 0; i < count; ++i) {
    		char ch =  dart.charAt(i);
    		if (ch == 49) {
    			if (dart.charAt(i+1) == 48) {
    				ch = 58;
    				++i;
    			}
    		}
    		
    		//可记 肺流
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
    		
    		//力蚌 肺流
    		switch(dart.charAt(i+1)) {
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
    	System.out.println(arr[0]+arr[1]+arr[2]);
	}

}
