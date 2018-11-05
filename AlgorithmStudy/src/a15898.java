import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a15898{ //피아의 아틀리에 ~ 신비한 대회의 연금술사 
	static int n,ans;
	static char quality[][][][],qresult[][];
	static int element[][][][],eresult[][],v[];
	
 public static void main(String[] args) throws IOException {
   BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
   StringTokenizer st ;
   n = Integer.parseInt(bf.readLine());
   quality = new char[n][4][4][4];
   element = new int[n][4][4][4];
   qresult = new char[5][5];
   eresult = new int[5][5];
   v = new int [n];
   for(int k=0; k<n; k++) {
	   for(int i=0; i<4; i++) {
		   st = new StringTokenizer( bf.readLine());
		   for(int j =0; j<4; j++) {
		     element[k][i][j][0] = Integer.parseInt(st.nextToken());
		   }
	   }
	   
	   for(int i2 =0; i2<4; i2++) {
		   st = new StringTokenizer(bf.readLine());
		   for(int j2 =0; j2<4; j2++) {
			   quality[k][i2][j2][0] = st.nextToken().charAt(0);   
		   }
	   }
   }
   
   for(int i =1; i<=3; i++) {//방향 저장
     rotation(i);
   }
   ans = 0;
   func(0,qresult,eresult);
   
   System.out.println(ans);
   bf.close();
   
 }
 
 static void rotation(int p) {
  for(int k=0; k<n; k++) {
   for(int i =0; i<4; i++) {
	   for(int j =0; j<4; j++) {		   
		   // 0,0 -> 0,3  // 0,1 -> 1,3 // 0,2 ->2,3 // 0,3 ->3,3
		   quality[k][j][3-i][p] = quality[k][i][j][p-1];
		   element[k][j][3-i][p] = element[k][i][j][p-1];
	   }
   }
  }
 }
 
 static void func(int cnt, char qtemp[][], int etemp[][] ) {
	 if(cnt == 3){
		 maxQuality();
		 return;
	 }
	 
	 char qt[][] = new char[5][5];
	 int et[][] = new int[5][5];
	 for(int i =0; i<5; i++){
		 for(int j =0; j<5; j++){
			 qt[i][j] = qtemp[i][j];
			 et[i][j] = etemp[i][j];
		 }
	 }

		
				for (int i = 0; i < 2; i++) { // start
					for (int j = 0; j < 2; j++) {
						for (int k = 0; k < n; k++) { // combination
							if (v[k] == 0) {
								v[k] = 1;
						for (int p = 0; p < 4; p++) { // rotation
							for (int a = 0; a < 4; a++) {
								for (int b = 0; b < 4; b++) {
									int x = i + a;
									int y = j + b;
									if (quality[k][a][b][p] != 'W') {
										qresult[x][y] = quality[k][a][b][p];
									}
									eresult[x][y] += element[k][a][b][p]; 
									if (eresult[x][y]  < 0) eresult[x][y] = 0;
									else if (eresult[x][y]  > 9) eresult[x][y] = 9;
								}
							}
							
							func((cnt + 1), qresult, eresult);

							// backtracking
							for (int b1 = 0; b1 < 5; b1++) {
								for (int b2 = 0; b2 < 5; b2++) {
									qresult[b1][b2] = qt[b1][b2];
									eresult[b1][b2] = et[b1][b2];
								}
							}

						}
						v[k] = 0;
					}
				}
				
			}
		}
 }
 
 static void maxQuality() {
	 int R=0,B=0,G=0,Y=0;
	 for(int i =0; i<5; i++){
		 for(int j =0; j<5; j++){
			 char ch = qresult[i][j];
			 int num = eresult[i][j];
			 if(ch == 'R'){
				 R += num;
			 }else if(ch=='B'){
				 B += num;
			 }else if(ch =='G'){
				 G += num;
			 }else if(ch == 'Y'){
				 Y += num;
			 }
		 }
	 }
	 
	 ans = Math.max(ans,( (7*R) + (5*B) + (3*G) + (2*Y)) );
 }
 
 
 
}
