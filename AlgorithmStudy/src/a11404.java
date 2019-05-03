import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a11404 { // 플로이드 -> 플로이드와샬 알고리즘 적
	static int n, m;
	static int dist[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		m = Integer.parseInt(bf.readLine());
		dist = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					dist[i][j] = 0;
				} else {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dist[a][b] = Math.min(dist[a][b], c);
		}

		for (int k = 1; k <= n; k++) { // 거쳐가는 노드
			for (int i = 1; i <= n; i++) { // 출발노드
				for (int j = 1; j <= n; j++) { // 도착노드
					if (dist[i][k] == Integer.MAX_VALUE
							|| dist[k][j] == Integer.MAX_VALUE)
						continue;
					if (dist[i][j] > dist[i][k] + dist[k][j]) { // k 거쳐간다.
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int cost = dist[i][j] == Integer.MAX_VALUE ? 0 : dist[i][j]; // 만약,
																				// i에서
																				// j로
																				// 갈
																				// 수
																				// 없는
																				// 경우에는
																				// 그
																				// 자리에
																				// 0을
																				// 출력한다.
				sb.append(cost + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
		bf.close();

	}
}
