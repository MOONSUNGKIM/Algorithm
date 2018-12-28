import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class a9019 { // DSLR 
	static int n,ans ,v[];
	static class state implements Comparable<state> {
		int cnt;
		int result;
		String com;
		state(int cnt , int result,String com) {
			this.cnt = cnt;
			this.result = result;
			this.com=com;
		}
		public int compareTo(state o) {
			if(this.cnt > o.cnt) return 1;
			else if(this.cnt == o.cnt) return 0 ;
			else return -1;
		}
	}
	
	static PriorityQueue<state> pq;
	static final int mod = 10000;
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	n = Integer.parseInt(bf.readLine());
	for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine());
		String str = st.nextToken(); 
		ans = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<>();
		pq.offer(new state(0,Integer.parseInt(str),""));
		v = new int[10001];
		func();
		
	}
	bf.close();
 }

 static void func() {
	 
		while(!pq.isEmpty()) {
			state p = pq.poll();
			if(p.result == ans) {
				System.out.println(p.com);
				break;
			}
			
			//D
			int re = 0;
			re = (p.result * 2) % mod;
			if (v[re] == 0) {
				v[re] = 1;
				pq.offer(new state((p.cnt + 1), re, (p.com + "D")));
			}
			
			//S
			re = 0;
			re = (p.result - 1);
			if (p.result == 0)
				re = 9999;
			if (v[re] == 0) {
				v[re] = 1;
				pq.offer(new state((p.cnt + 1), re, (p.com + "S")));
			}
			
			//L
			re = 0;
			re = (p.result % 1000) * 10 + p.result / 1000;
			if (v[re] == 0) {
				v[re] = 1;
				pq.offer(new state((p.cnt + 1), re, (p.com + "L")));
			}
			
			//R
			re = 0;
			re = (p.result / 10) + (p.result % 10) * 1000;
			if (v[re] == 0) {
				v[re] = 1;
				pq.offer(new state((p.cnt + 1), re, (p.com + "R")));
			}

		}
 }
 
}
