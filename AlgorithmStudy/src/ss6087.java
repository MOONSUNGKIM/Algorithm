import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class ss6087 { // 레이저통신 
	static class sw implements Comparable<sw> {
		int x, y,d,k;
		sw(int x, int y, int d,int k){
			this.x=x;
			this.y=y;
			this.d=d; // 방
			this.k = k; // 꺾
		}
		
		public int compareTo(sw o){ //꺽인 횟수에따라 우선순위 
			if(this.k> o.k) return 1;
			else if(this.k==o.k) return 0;
			else return -1;
		}
	}
	
	static PriorityQueue<sw> pq;
	
	static int n , m ,sx,sy,ex,ey,v[][][];
	
	static char map[][]; 
	static final int dx[]={ 0,0,1,-1},dy[]={1,-1,0,0};
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	m  = Integer.parseInt(st.nextToken());
	n = Integer.parseInt(st.nextToken());
	map = new char[n][m];
	int che = 0;
	v = new int[n][m][4];
	pq = new PriorityQueue<>();
	for(int i =0; i<n; i++) {
		String str = bf.readLine();
		for(int j =0; j<m; j++) {
			map[i][j] = str.charAt(j);
			if(map[i][j] == 'C'){
				if(che == 0){
					sx = i;
					sy = j;
					// 출발할 C 방문 막는다 
                    v[sx][sy][0] = 1;
                    v[sx][sy][1] = 1;
                    v[sx][sy][2] = 1;
                    v[sx][sy][3] = 1;
                    
					che = 1;

				}else{
					//도착할 C 좌표 저장 
					ex = i;
					ey = j;
				}
			}
		}
	}
	
	//start
	// 미리 한칸 가놓는다 .
	for(int i =0; i<4; i++){
	  int x = sx+dx[i];
	  int y = sy+dy[i];
	  if(x>=0 && y>=0 && x<n && y<m) {
		  if(map[x][y] =='.'){
			  pq.offer(new sw(x,y,i,0));
		  }
	  }
	}
	
	
	while(!pq.isEmpty()){
	  sw p = pq.poll();
	  if(p.x == ex && p.y== ey) { // 도착 
			 System.out.println(p.k);
			 break;
	  }
	  
	  for(int i =0; i<4; i++) {
		  int x = p.x+dx[i];
		  int y = p.y+dy[i];
		  if(x>=0 && y>=0 && x<n && y<m) {
			 if(map[x][y] != '*') { // 벽이 아닐때 
				if(v[x][y][i] ==0) { //다음 갈 곳이 안갔던 곳이고 방향도안갔던 곳이면 
					v[x][y][i] = 1; 
					if(p.d == i) { // 내가 온방향과 다음 갈 방향이 같다면 그대로 
						pq.offer(new sw(x,y,p.d,p.k));
					}else{ // 내가 온방향과 다음 갈 방향이 다르면 k+1 
						pq.offer(new sw(x,y,i,(p.k+1)));
					}
				}
			 }
		  }
	  }
	  
	}

	bf.close();
 }

}
