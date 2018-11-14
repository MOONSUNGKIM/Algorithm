import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class b16441 { // 아기돼지와 늑대
	static int n, m,v[][][];
	static char map[][];
	static class state{
		int x,y,d;
		boolean movestate; 
		state(int x, int y, int d,boolean movestate) {
			this.x=x;
			this.y=y;
			this.d=d;
			this.movestate = movestate; // 미끄러지고 있는 상태
		}
	}
	static Queue<state> q;
  public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map =new char[n][m];
	v = new int[n][m][4];
	q = new LinkedList<>();
	for(int i =0; i<n; i++){
		String str =bf.readLine();
		for(int j =0; j<m; j++){
			map[i][j] = str.charAt(j);
			if(map[i][j] == 'W'){ // 늑대
				q.offer(new state(i,j,0,false));
			}
			
		}
	}
	
	
	func();
	
	StringBuilder sb = new StringBuilder();
	
	for(int i =0; i<n; i++) {
		for(int j =0; j<m; j++) {
			if(map[i][j] == '.') {
				if(v[i][j][0] == 0 && v[i][j][1] == 0 && v[i][j][2] == 0 && v[i][j][3] == 0 ) {
					sb.append('P');
				}else {
					sb.append('.');
				}
			}else {
				sb.append(map[i][j]);
			}
		}
		sb.append("\n");
	}
	
	System.out.println(sb.toString());
	
    bf.close();	 
 }
  
//'.' 일 경우 초원, '+' 일 경우 빙판, '#' 일 경우 산, 그리고 'W'는 늑대가 살고 있음을 나타냅니다.
	 //늑대는 상하좌우 인접한 칸 중 산이 아닌 칸으로 이동할 수 있습니다. 
	 //만약 이동한 칸이 빙판이라면 초원을 밟거나 산에 부딪칠 때까지 이동한 방향으로 미끄러집니다.
	 //산에 부딪친 경우 늑대는 빙판 위에 가만히 서있을 수 있고 다시 다른 방향으로 이동할 수 있습니다.
  static final int dx[] = {0,0,1,-1},dy[]={1,-1,0,0};
  
  static void func() {
	  while(!q.isEmpty()) {
		  state p = q.poll();
			if (p.movestate) { // 현재 미끄러지고 있는 상태일 경우 
             int x = p.x+dx[p.d];
             int y = p.y+dy[p.d]; 
             if(x>=0 && y>=0 && x<n && y<m) {
            	 if(map[x][y] == '#') { // 산일경우 빙판에 서있는다 
            		 for(int i =0; i<4; i++) {
            		   q.offer(new state(p.x,p.y,i,false));
            		 }
            	 }
            	 else if(map[x][y]=='.') { // 초원밟을 경우 초원에 서있는다
            		for(int i =0; i<4; i++){
            	     if(v[x][y][i] == 0){
            	    	 v[x][y][i] = 1;
            		 q.offer(new state(x,y,i,false));
            	     }
            		}
            	 }
            	 else {
            		 if(v[x][y][p.d] == 0) {
           			  v[x][y][p.d] = 1;
            		 q.offer(new state(x,y,p.d,p.movestate));
            		 }
            	 }
             }
			}
			
			else { // 미끄러지고 있는 상태 아닐경우 
				for (int i = 0; i < 4; i++) {
					int x = p.x + dx[i];
					int y = p.y + dy[i];
					if (x >= 0 && y >= 0 && x < n && y < m) {
						if (v[x][y][i] == 0) {
							v[x][y][i] = 1;
							if (map[x][y] == '.') {  
							   q.offer(new state(x, y, i, p.movestate));
							}else if (map[x][y] == '+') { // 빙판
                               q.offer(new state(x,y,i,true)); // 상태변경 
							}
						}
					}
				}
			}
			
	  }
	  
  }
  
}
