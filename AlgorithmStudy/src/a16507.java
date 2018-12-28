import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class a16507 { // 어두운 건 무서워 
	static int r,c,k;
	static long d[][];
 public static void main(String[] args) throws IOException
 {
   BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
   StringTokenizer st = new StringTokenizer(bf.readLine());
   r = Integer.parseInt(st.nextToken());
   c = Integer.parseInt(st.nextToken());
   k = Integer.parseInt(st.nextToken());
   //map = new int[r+1][c+1];
   d = new long[r+1][c+1];
   for(int i = 1; i <= r; i ++) {
	   st = new StringTokenizer(bf.readLine());
	   for(int j = 1; j<=c; j++) {
		  int num = Integer.parseInt(st.nextToken());
		   d[i][j] = d[i-1][j] + d[i][j-1] - d[i-1][j-1] + num; 
	   }
   }
	for (int a = 0; a < k; a++) {
		st = new StringTokenizer(bf.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
// -> 시간초과		
//		int avg = 0;
//		int sum = 0;
//		for(int i =x1; i<=x2; i++) {
//			for(int j =y1; j<=y2; j++) {
//				avg += map[i][j];
//				sum+=1;
//			}
//		}
//	    System.out.println((avg/sum));
	    
		System.out.println( (d[x2][y2] - d[x2][y1-1] - d[x1-1][y2] + d[x1-1][y1-1]) / ( (x2-x1+1)*(y2-y1+1) ) );
		
	    
	}
	
   bf.close();
 }
}
