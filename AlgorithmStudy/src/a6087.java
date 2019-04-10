import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class a6087 { // 레이저통신
	static class state implements Comparable<state> {
		int x, y, d, mc;
		state(int x, int y, int d, int mc) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.mc = mc;
		}
		public int compareTo(state o) {
			if (this.mc > o.mc)
				return 1;
			else if (this.mc == o.mc)
				return 0;
			else
				return -1;
		}
	}

	static PriorityQueue<state> pq;
	static int n, m, sx, sy, ex, ey, v[][][];
	static char map[][];
	static final int dx[] = { 0, 0, 1, -1 }, dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		boolean check = false;
		v = new int[n][m][4];
		pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'C') {
					if (!check) {
						sx = i;
						sy = j;
						v[sx][sy][0] = 1;
						v[sx][sy][1] = 1;
						v[sx][sy][2] = 1;
						v[sx][sy][3] = 1;
						check = true;

					} else {
						ex = i;
						ey = j;
					}
				}
			}
		}

		// start
		for (int i = 0; i < 4; i++) {
			int x = sx + dx[i];
			int y = sy + dy[i];
			if (x >= 0 && y >= 0 && x < n && y < m) {
				if (map[x][y] == '.') {
					pq.offer(new state(x, y, i, 0));
				}
			}
		}

		while (!pq.isEmpty()) {
			state p = pq.poll();
			if (p.x == ex && p.y == ey) { // 도착
				System.out.println(p.mc);
				break;
			}

			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				if (x >= 0 && y >= 0 && x < n && y < m) {
					if (map[x][y] != '*') {
						if (v[x][y][i] == 0) {
							v[x][y][i] = 1;
							if (p.d == i) {
								pq.offer(new state(x, y, p.d, p.mc));
							} else {
								pq.offer(new state(x, y, i, (p.mc + 1)));
							}
						}
					}
				}
			}

		}

		bf.close();
	}

}
