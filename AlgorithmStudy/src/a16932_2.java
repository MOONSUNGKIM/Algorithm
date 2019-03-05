import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class a16932_2 {
	static int n,m;
	static int map[][] ;
	static final int dx[] = { 0, 0, -1, 1 },dy[] = { 1, -1, 0, 0 };
	static int v[][],isd[][];
	static int max = 0;
	static int d[][] = new int[1001][1001];

	static class state {
		public int x;
		public int y;
		public state(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		v = new int[n+1][m+1];
		isd = new int[n+1][m+1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
		bf.close();
	}

	public static int bfs() {
		int distNum = 2;
		for (int x = 1; x <= n; x++) {
			for (int y = 1; y <= m; y++) {
				if (map[x][y] == 1 && v[x][y]==0) {
					v[x][y] = 1;
					map[x][y] = distNum;
					int size = bfs(x, y, distNum); // 해당구간을 포함해서계산해야함.
					d[x][y] = size;
					isd[x][y] = 1;
					dfs(x, y, size, distNum);
					distNum++;
				}
			}
		}

		int maxSize = 0;
		for (int x = 1; x <= n; x++) {
			for (int y = 1; y <= m; y++) {
				int size = 1;
				if (map[x][y] == 0) {
					HashSet<Integer> hashMap = new HashSet<>();
					for (int i = 0; i < 4; i++) {
						int nX = x + dx[i];
						int nY = y + dy[i];
						if (mapSize(nX, nY) && d[nX][nY] > 0) {
							if (!hashMap.contains(map[nX][nY])) {
								hashMap.add(map[nX][nY]);
								size += d[nX][nY];
							} 						}
					}
				}
				maxSize = Math.max(size, maxSize);
			}
		}

		return maxSize;
	}

	public static void dfs(int x, int y, int size, int distNum) {
		for (int i = 0; i < 4; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];
			if (mapSize(nX, nY) && isd[nX][nY] ==0 && map[nX][nY] == distNum) {
				isd[nX][nY] = 1;
				d[nX][nY] = size;
				dfs(nX, nY, size, distNum);
			}
		}
	}


	public static int bfs(int x, int y, int distNum) {
		Queue<state> q = new LinkedList<>();
		q.offer(new state(x, y));
		int cnt = 1;
		while (!q.isEmpty()) {
			state now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nX = now.x + dx[i];
				int nY = now.y + dy[i];
				if (mapSize(nX, nY) && v[nX][nY]==0 && map[nX][nY] == 1) {
					v[nX][nY] = 1;
					map[nX][nY] = distNum;
					cnt++;
					q.offer(new state(nX, nY));
				}
			}
		}
		return cnt;
	}
	

	public static boolean mapSize(int nX, int nY) {
		return nX > 0 && nY > 0 && nX <= n && nY <= m ? true : false;
	}
	
}
