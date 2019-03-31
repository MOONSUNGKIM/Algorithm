import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class a16985 { //Maaaaaaaaaze
	static final int n = 5,rotationcount = 4;
	static int map[][][][], start[][], end[][],ans;
	static int combinationdir[],combinationmap[];
	static final int dx[]={0,0,1,-1,0,0},dy[]={1,-1,0,0,0,0},dh[]={0,0,0,0,1,-1};
	static boolean check ;
	static class state {
		int x, y, h, cnt;
		state(int x, int y, int h, int cnt) {
			this.x = x;
			this.y = y;
			this.h = h;
			this.cnt = cnt;
		}
	}
	static Queue<state> q;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[5][n][n][4];
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < n; j++) {
					map[k][i][j][0] = Integer.parseInt(st.nextToken());
				}
			}
		}
		combinationdir = new int[5];
		combinationmap = new int[5];
		for(int i =1; i<=3; i++){
			rotation(i);
		}
		check =false;
		ans = Integer.MAX_VALUE;
		layer();
		if(!check) ans = -1;
		System.out.println(ans);
		bf.close();
	}
	static void rotation(int dir) {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 0,0 -> 0,4 // 0,1 -> 1,4 // 0,2 ->2,4 // 0,3 ->3,4 // 0,4 -> 4,4
					map[k][j][4 - i][dir] = map[k][i][j][dir - 1];
				}
			}
		}
	}
	static void layer() {
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				if(a==b) continue;
				for (int c = 0; c < n; c++) {
					if(a==c || b==c) continue;
					for (int d = 0; d < n; d++) {
						if(a==d || b==d || c==d) continue;
						for (int e = 0; e < n; e++) {
							if(a==e || b==e || c==e|| d==e) continue;
							combinationmap[0] = a;
							combinationmap[1] = b;
							combinationmap[2] = c;
							combinationmap[3] = d;
							combinationmap[4] = e;
							direction();
						}
					}
				}
			}
		}
	}
	
	static void direction() {
		for (int a = 0; a < rotationcount; a++) {
			combinationdir[0] = a;
			for (int b = 0; b < rotationcount; b++) {
				combinationdir[1] = b;
				for (int c = 0; c < rotationcount; c++) {
					combinationdir[2] = c;
					for (int d = 0; d < rotationcount; d++) {
						combinationdir[3] = d;
						for (int e = 0; e < rotationcount; e++) {
							combinationdir[4] = e;
							func();
						}
					}
				}
			}
		}
	}
	static void func() {
		int v[][][][] = new int [n][n][n][4];
		if(map[combinationmap[0]][0][0][combinationdir[0]] == 0 || map[combinationmap[4]][4][4][combinationdir[4]] == 0 ) return; 
		v[combinationmap[0]][0][0][combinationdir[0]] = 1;
		q = new LinkedList<>();
		q.offer(new state(0,0,0,0));
		while (!q.isEmpty()) {
			state p = q.poll();
			if (p.h == 4 && p.x == 4 && p.y == 4) {
				ans = Math.min(p.cnt, ans);
				check = true;
				break;
			}
			for (int i =0; i<6; i++){
				 int x = p.x+dx[i];
				 int y = p.y+dy[i];
				 int h = p.h+dh[i];
				 if(x>=0 && y>=0 && x<n && y<n && h>=0 && h<n && map[combinationmap[h]][x][y][combinationdir[h]]==1) {
					 if(v[combinationmap[h]][x][y][combinationdir[h]] == 0) {
						 v[combinationmap[h]][x][y][combinationdir[h]] = 1;
						 q.offer(new state(x,y,h,(p.cnt+1)));
					 }
				 }
			}
		}
		
	}
}
