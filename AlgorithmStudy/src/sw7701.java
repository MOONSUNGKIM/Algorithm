import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class sw7701 { // 염라대왕의 이름 정렬 
	static int n;

	static class state implements Comparable<state> {
		String str;
		int length;

		state(String str, int length) {
			this.str = str;
			this.length = length;
		}

		public int compareTo(state s) {
			if (this.length > s.length) {
				return 1;
			}
			if (this.length == s.length) {
				return str.compareTo(s.str);
			}
			return -1;
		}
	}
	
	static PriorityQueue<state> pq;
	static BufferedReader bf;
	static Set<String> overlap;
	public static void main(String[] args) throws IOException {
		bf = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= testcase; t++) {
			n = Integer.parseInt(bf.readLine());
			func();
			System.out.println("#"+t);
			output();
		}
	}
	
	static void func() throws IOException {
		pq = new PriorityQueue<>();
		overlap = new HashSet<>();
		for (int i =0; i<n; i++) {
			String str = bf.readLine();
			if(!overlap.contains(str)) {
				pq.offer(new state(str,str.length()));
				overlap.add(str);
			}
		}
	}
	
	static void output() {
		while (!pq.isEmpty()) {
			state p = pq.poll();
			System.out.println(p.str);
		}
	}
}
