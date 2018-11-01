import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw4013 { //특이한 자석
	static int k,d[][],ans;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st ;
	int testcase  = Integer.parseInt(bf.readLine());
	for(int t=1; t<=testcase ; t++) {
		k = Integer.parseInt(bf.readLine());
		d = new int[5][8];
		for(int i =1; i<=4; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j =0; j<8; j++) {
				d[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i =0; i<k; i++) {
			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			func(num, dir);
		}
		
		ans = 0;
		if(d[1][0] == 1) ans+=1;
		if(d[2][0] == 1) ans+=2;
		if(d[3][0] == 1) ans+=4;
		if(d[4][0] == 1) ans+=8;
		
		
		System.out.println("#"+t+" "+ans);
	}
	bf.close();
 }
 
 // 2 , 6 
 static void func(int num, int dir) {
  int check [] = new int[5];
  check[num] = dir; // dir 1 -> r     dir -1-> l
  
  // right 톱니 체크 
  for(int i= num; i<4; i++) {
	  if(d[i][2] != d[i+1][6]) check[i+1] =check[i]*-1;
	  else break;
  }
  
  //left톱니 체크 
  for(int i= num; i>0; i--) {
	  if(d[i][6] != d[i-1][2]) check[i-1] =check[i]*-1;
	  else break;
  }
  
  for(int i =1; i<=4; i++) {
	  if(check[i]!=0){
		  rotation(i,check[i]);
	  }
  }
  
 }
 
 static void rotation(int number , int dir) {
	 int temp0 = d[number][0];
	 int temp1 = d[number][1];
	 int temp2 = d[number][2];
	 int temp3 = d[number][3];
	 int temp4 = d[number][4];
	 int temp5 = d[number][5];
	 int temp6 = d[number][6];
	 int temp7 = d[number][7];
	 
	 if(dir ==1){ // r
		 d[number][1] = temp0;
		 d[number][2] = temp1;
		 d[number][3] = temp2;
		 d[number][4] = temp3;
		 d[number][5] = temp4;
		 d[number][6] = temp5;
		 d[number][7] = temp6;
		 d[number][0] = temp7;
		 
	 }
	 else if(dir==-1){ // l
		 d[number][0] = temp1;
		 d[number][1] = temp2;
		 d[number][2] = temp3;
		 d[number][3] = temp4;
		 d[number][4] = temp5;
		 d[number][5] = temp6;
		 d[number][6] = temp7;
		 d[number][7] = temp0;
	 }
	 
 }
 
}

