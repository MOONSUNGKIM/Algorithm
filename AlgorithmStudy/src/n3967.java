import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class n3967 {
	static final int n = 5, m = 9;
	static int map[][];
	static int temp[][],tempindex;
	static int v[];
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    map = new int[n][m];
    v = new int[12];
    temp = new int[12][2];
    for(int i =0; i<n; i++) {
    	String str = bf.readLine();
    	for(int j =0; j<m; j++) {
    	 char ch =str.charAt(j);
    	 if(ch!='.' && ch!='x') {
    		map[i][j] = (ch-'A') + 1;
    		v[ch-'A'] =1;
    	 }else if(ch == 'x'){
    		 temp[tempindex][0] = i;
    		 temp[tempindex][1] = j;
    		 tempindex++;
    	 }
    	}
    }
    func(0,0);
    
    bf.close();
 }
static boolean finish;
 static void func(int idx, int cnt) {
	 if(finish ) return;
     if(idx>=tempindex) {
    	 
    	 // (0,4) / 1,3 / 2,2/ 3,1 
    	 // 0,4 / 1,5 / 2,6/ 3,7
    	 // 1,1 / 2,2/ 3,3/ 4,4
    	 // 1,7 / 2,6/ 3,5/ 4,4
    	 //1,1 // 1,3// 1,5//1,7//
    	 //3,1// 3,3// 3,5// 3,7
    	 if(map[0][4]+ map[1][3] + map[2][2] + map[3][1] == 26 && map[0][4]+ map[1][5] + map[2][6] + map[3][7] == 26 && 
    			 map[1][1]+ map[2][2] + map[3][3] + map[4][4] == 26 && map[1][7]+ map[2][6] + map[3][5] + map[4][4] == 26 && 
    			 map[1][1]+ map[1][3] + map[1][5] + map[1][7] == 26 
    			 && map[3][1]+ map[3][3] + map[3][5] + map[3][7] == 26  ){
    		 
    		 finish = true;
    		 
    		 for(int i =0; i<n; i++){
    		    	for(int j =0; j<m; j++){
    		    		if(map[i][j] == 0) System.out.print(".");
    		    		else{
    		    			System.out.print((char)(map[i][j]+'A'-1));
    		    		}
    		    	}
    		    	System.out.println();
    		    }
    		 
    	 }
    	 
    	 
    	 return;
     }
     
	 for(int i =0; i<12; i++) {
		 if(v[i] == 0){
			 v[i] =1;
			 map[temp[idx][0]][temp[idx][1]] = (i+1);
			 func(idx+1,cnt+1);
			 map[temp[idx][0]][temp[idx][1]] = 0;
			 v[i] = 0;
		 }
	 }
	 
 }
 
}
