import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

 // 아기상어 (Samsung CEIM 2)
public class a16236 {
	static int map[][],n,v[][],fishsize, fisheat,result;
	//up, left, right, down
	static final int dx[] = {-1,0,0,1}, dy[] = {0,-1,1,0};
	static class state implements Comparable<state> {
		int x, y,d,fishdistance;
		state(int x, int y,int d, int fishdistance) {
		  this.x=x;
		  this.y=y;
		  this.d=d;
		  this.fishdistance = fishdistance;
		}
		
		public int compareTo(state s) {
			if(this.fishdistance > s.fishdistance) return 1;
			else if(this.fishdistance == s.fishdistance) return 0 ;
			else return -1;
			
		}
	}
	
	static PriorityQueue<state> q ;
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st ;
	n = Integer.parseInt(bf.readLine());
	map = new int[n][n];
	v = new int[n][n];
	fishsize = 2;
	fisheat  = 0;
	result = 0;
	q = new PriorityQueue<>();
	
	for(int i =0; i<n; i++) {
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<n; j++) {
			map[i][j] = Integer.parseInt(st.nextToken());
			if(map[i][j] == 9) {
				map[i][j] = 0;
				q.offer(new state(i,j,0,0));
				v[i][j] = 1;
			}
		}
	}
	
	check = false;
	while(true) {
		check = false;
		miny = 2100000000;
		minx = 2100000000;
		mindist = 2100000000;
		func();
		
		if(check == false) break;
		
		fisheat+=1;
        if(fishsize == fisheat) {
    		fishsize++;
    		fisheat = 0;
	    }

	    result += (mindist) ;
		map[minx][miny] = 0;
		q.clear();
    	q.offer(new state(minx,miny,0,0));
    	
    	v = new int[n][n];
	}
	
	System.out.println(result);
	bf.close();
	
 }
 
 static boolean check ;
 static int miny,minx,mindist;
 
 static void func() {
	 while(!q.isEmpty()) {
			state p = q.poll();
			    for(int dir = 0; dir<4; dir++) {
				int x = p.x+dx[dir];
				int y = p.y+dy[dir];
				if(x>=0 && y>=0 && x<n && y<n) {
				  if(map[x][y] <= fishsize) {
					if(v[x][y] == 0) {
						v[x][y] = 1;
					    if(map[x][y] !=0 && map[x][y] <fishsize) {
					    	check = true;
					    	if(mindist > ( p.fishdistance+1 )) {
					    		minx = x;
					    		miny = y;
					    		mindist = (p.fishdistance+1);
					    	}
					    	
					    	else if(mindist == (p.fishdistance+1)) {
					    		if(minx > x) {
					    			minx=x;
					    			miny=y;
					    		}
					    		else if(minx==x) {
					    			if(miny >y) {
					    				miny= y;
					    			}
					    		}
					    	}
					    	else if(mindist < (p.fishdistance+1)) return;
					    }
					    q.offer(new state(x,y,(dir),(p.fishdistance+1)));
					}
				  }
				 
				 }
			    }
			
		}
 }
 
}
