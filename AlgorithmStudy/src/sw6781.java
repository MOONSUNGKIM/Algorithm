import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw6781 { //삼삼 트리플 게임 
	//각 세트는 동일한 색의 카드 세 장으로 이루어져야 하며, 세 숫자가 모두 같거나, 세 숫자가 모두 연속된 숫자여야 한다.
	// 이러한 세트를 3개 만들어야 승리 할 수 있다 .
	static int num[],v[],finish;
	static char text[];
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	int testcase = Integer.parseInt(bf.readLine());
	
	for(int t=1;t<=testcase ; t++) {
		 String number = bf.readLine();
		 num = new int[number.length()];
		 for(int i =0; i<number.length(); i++) {
			 num[i] = number.charAt(i)-48;
		 }
		 text = bf.readLine().toCharArray();
		 
		 v = new int[10];
		 int temp[] = new int[3];
		 finish = 0;
		 //
		 func(0,0,temp);
		 
		 if(finish == 1) System.out.println("#"+t+" Win");
		 else System.out.println("#"+t+" Continue");
	}
	
    bf.close();
 }

 static void func(int cnt , int setcount, int temp[]) {
	 if(cnt == 3) {
		 boolean check = false;
	     if(text[temp[0]] == text[temp[1]] && text[temp[1]] == text[temp[2]]) {
	    	 int n = num[temp[0]];
	    	 if(n == num[temp[1]] && num[temp[1]] == num[temp[2]]) check = true;
	    	 else if( ( (n-1) == num[temp[1]] && (n+1) == num[temp[2]] ) || ( (n-1) == num[temp[2]] && (n+1) == num[temp[1]]) ) check = true;
	    	 else if( ( (n-1) == num[temp[1]] && (n-2) == num[temp[2]] ) || ( (n-1) == num[temp[2]] && (n-2) == num[temp[1]]) ) check = true;
	    	 else if( ( (n+1) == num[temp[1]] && (n+2) == num[temp[2]] ) || ( (n+1) == num[temp[2]] && (n+2) == num[temp[1]]) ) check = true;
	     }
	     if(check) {
	    		setcount++;
	    		cnt = 0;
	     }else return;
	     
	     if( setcount == 3){
	    	 finish = 1;
	    	 return;
	     }
	 }
	 
	 for(int i =0; i<9; i++) {
		 if(v[i] == 0) {
			 v[i] = 1;
			 temp[cnt] = i;
			 func((cnt+1), setcount, temp);
			 v[i] = 0;
		 }
	 }
	 
 }
 
}
