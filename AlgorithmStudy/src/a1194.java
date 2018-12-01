import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class a1194 { //달이차오른다 가자 
  static class pr{
	  int x,y,cnt,now;
	  pr(int x, int y, int cnt, int now){
		  this.x = x;
		  this.y = y;
		  this.cnt = cnt;
		  this.now = now;
	  }
  }
  
  
  static int dx[] = {0,0,1,-1};
  static int dy[] = {1,-1,0,0};
  
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n =Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		char map[][]= new char[n][m];
		boolean visit[][][] = new boolean[n][m][64];
		Queue<pr> q = new LinkedList<>();
		for(int i =0; i<n; i++){
			String str = bf.readLine();
			for(int j=0; j<m; j++){
				map[i][j] = str.charAt(j);
				if(map[i][j] == '0'){
					map[i][j] = '.';
					q.offer(new pr(i,j,0,0));
					
				}
			}
		}
		boolean finish = false;
		while(!q.isEmpty()){
			pr p = q.poll();
			for(int i=0; i<4; i++){
				int x= p.x+dx[i];
				int y= p.y+dy[i];
				int cnt = p.cnt;
				int now = p.now;
				
				if(x>=0 && y>=0 && x<n && y<m){
					if(map[x][y]=='1'){
						finish = true;
						System.out.println(cnt+1);
						break;
					}
					
					if(visit[x][y][now]==false){
						visit[x][y][now] = true;
						if(map[x][y]=='.'){
							q.offer(new pr(x,y,cnt+1,now));
						}
						else if(map[x][y]-'a'>=0 && map[x][y]-'a'<6){
							if((now & (1<<(102 - map[x][y]))) == 0){
								now += 1<<(102-map[x][y]);
							}
							q.offer(new pr(x,y,cnt+1,now));
						}
						else if(map[x][y]-'A'>=0 && map[x][y]-'A'<6){
							if((now & (1<<(70-map[x][y])))!=0){
								q.offer(new pr(x,y,cnt+1,now));
							}
						}
					}
				}
			}
			
			if(finish){
				break;
			}
		}
		
		if(finish ==false){
			System.out.println(-1);
		}
		
		
	}
}
