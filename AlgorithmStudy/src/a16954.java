import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class a16954 {
	static final int n=8, dx[]={0,0,1,-1,1,1,-1,-1},dy[]={1,-1,0,0,1,-1,1,-1} ;
	static char map[][][];
	static int temp[][],v[][][];
	static class state {
		int x, y,time;
		state(int x, int y,int time) {
			this.x=x;
			this.y=y;
			this.time = time;
		}
	}
	static Queue<state> q;
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	map = new char[n+1][n+1][9];
	temp = new int[ (n+1) * (n+1) ][2];
	v = new int[n+1][n+1][9];
	int tempidx = 0;
	
	for(int i =1; i<=n; i++) {
		String str = bf.readLine();
		for(int j =1; j<=n; j++) {
			map[i][j][0] = str.charAt(j-1);
			if(map[i][j][0] == '#') {
				temp[tempidx][0] = i;
				temp[tempidx][1] = j;
				tempidx++;
			}
			for(int k=1; k<=8; k++){
				map[i][j][k] = '.';
			}
		}
	}
	
	for(int idx=0 ; idx<tempidx; idx++) {
		for(int h=1; h<=8; h++) {
			int x = temp[idx][0]+dx[2]*h;
			int y = temp[idx][1]+dy[2]*h;
			if(x>=1 && y>=1 && x<=n && y<=n) {
				map[x][y][h] = '#';
			}
		}
	}
	
	
//	for(int h=0; h<=8; h++){
//		for(int i =1; i<=n; i++){
//			for(int j=1; j<=n; j++){
//				System.out.print(map[i][j][h]);
//			}
//			System.out.println();
//		}
//		System.out.println("===================================");
//	}
	q = new LinkedList<>();
	boolean finish = false;
	q.offer(new state(8,1,0));
	
	while(!q.isEmpty()) {
		state p = q.poll();
		if(p.x == 1 && p.y == 8){
			finish = true;
			break;
		}
		if(p.time+1 > 8 ){
			finish = true;
			break;
		}
		
		for(int i =0; i<8; i++){
			int x = p.x+dx[i];
			int y = p.y+dy[i];
			if(x>=1 && y>=1 && x<=n && y<=n) {
				//이동할 때는 빈 칸으로만 이동할 수 있다.
				//벽이 캐릭터가 있는 칸으로 이동하면 더 이상 캐릭터는 이동할 수 없다.
				if(map[x][y][(p.time)] == '.' && map[x][y][(p.time+1)]=='.') {
					if(v[x][y][p.time+1] == 0) {
						v[x][y][p.time+1] = 1;
						q.offer(new state(x,y,(p.time+1)));
					}
				}
				if(map[p.x][p.y][(p.time+1)] == '.'){
					if(v[p.x][p.y][p.time+1] == 0) {
						v[p.x][p.y][p.time+1] = 1;
						q.offer(new state(p.x,p.y,(p.time+1)));
					}
				}
			}
			
		}
	}
	if(finish) System.out.println(1);
	else System.out.println(0);
	
	
	bf.close();
	
 }
}
