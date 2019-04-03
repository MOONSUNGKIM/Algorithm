import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class sw5650 { // 핀볼게임 
    static int n, map[][],wh[][],maxpoint,point;
    static final int dx[] = {0,0,1,-1},dy[]={1,-1,0,0};
    static class start {
        int x, y;
        start(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    
    static Queue<start> sxy;
     
 public static void main(String[] args) throws IOException {
     Scanner sc = new Scanner(System.in);
     int testcase = sc.nextInt();
    for(int t=1; t<=testcase; t++) {
        n = sc.nextInt();
        map = new int[n+2][n+2];
        sxy = new LinkedList<>();
        wh = new int[11][4];
        int check[] = new int[11];
         
        for(int i =1; i<=n; i++) {
            for(int j =1; j<=n; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] ==0) {
                	sxy.offer(new start(i,j));
                }else if(map[i][j] >=6 && map[i][j] <=10) {
                    if(check[map[i][j]] == 0) {
                        check[map[i][j]] = 1;
                        wh[map[i][j]][0] = i;
                        wh[map[i][j]][1] = j;
                    }else{
                    	wh[map[i][j]][2] = i;
                    	wh[map[i][j]][3] = j;
                    }
                }
            }
        }
 
        maxpoint = 0;
         
        //start
        while(!sxy.isEmpty()) {
            start p = sxy.poll();
            for(int i=0; i<4; i++) { //
                point = 0;
                move((p.x),(p.y),i);
                maxpoint = Math.max(maxpoint, point);
            }
        }
        System.out.println("#"+t+" "+maxpoint);
    }
    sc.close();
 }
  
 static void move(int sa, int sb,int dd) {
     int a = sa;
     int b = sb;
     int d = dd;
     int p = 0;
      
     while(true) {
         int x = a+dx[d];
         int y = b+dy[d];
        //finish
         if( (map[x][y] == -1 ) || (x==sa && y==sb) ) {
             point = p;
             return;
         }
          
         // 
         if(x==0 || y==0 || x== (n+1) || y== (n+1)) {
             p++;
             d = reverse(d);
         }
          
         //B
         else if(map[x][y] >=1 && map[x][y] <=5) { 
             d = rev(map[x][y],d);
             p++;
         }
         //WH
         else if((map[x][y]) >= 6 && (map[x][y]) <= 10) {
             if(wh[ (map[x][y]) ][0] == x && wh[(map[x][y])][1] == y ) {
                 a = wh[(map[x][y])][2];
                 b = wh[(map[x][y])][3];
             }else if(wh[(map[x][y])][2] == x && wh[(map[x][y])][3] == y ) {
                 a = wh[(map[x][y])][0];
                 b = wh[(map[x][y])][1];
             }
             continue;
         }
             a = x;
             b = y;
             
     }
      
 }
  
 static int reverse(int dir) {
		if (dir == 0) {
			return 1;
		}
		else if (dir == 1) {
			return 0;
		}
		else if (dir == 2) {
			return 3;
		}
		else if (dir == 3) {
			return 2;
		}
		else {
			return 0;
		}
 }
  
 static int rev(int num, int dir) {
	 	if (num == 1) {
	 		if (dir == 0){
	 			return 1;
	 		}
	 		if( dir == 1){
	 			return 3;
	 		}
	 		if( dir == 2) {
	 			return 0;
	 		}
	 		if( dir == 3) {
	 			return 2;
	 		}
	 		return -1;
	 	}
	 	if (num == 2) {
	 		if (dir == 0){
	 			return 1;
	 		}
	 		if( dir == 1){
	 			return 2;
	 		}
	 		if( dir == 2) {
	 			return 3;
	 		}
	 		if( dir == 3) {
	 			return 0;
	 		}
	 		return -1;
	 	}
	 	if (num == 3) {
	 		if (dir == 0){
	 			return 2;
	 		}
	 		if( dir == 1){
	 			return 0;
	 		}
	 		if( dir == 2) {
	 			return 3;
	 		}
	 		if( dir == 3) {
	 			return 1;
	 		}
	 		return -1;
	 	}
	 	if (num == 4) {
	 		if (dir == 0){
	 			return 3;
	 		}
	 		if( dir == 1){
	 			return 0;
	 		}
	 		if( dir == 2) {
	 			return 1;
	 		}
	 		if( dir == 3) {
	 			return 2;
	 		}
	 		return -1;
	 	}
	 	if (num == 5) {
	 		if (dir == 0){
	 			return 1;
	 		}
	 		if( dir == 1){
	 			return 0;
	 		}
	 		if( dir == 2) {
	 			return 3;
	 		}
	 		if( dir == 3) {
	 			return 2;
	 		}
	 		return -1;
	 	}
	 	return -1;
 }
  
}