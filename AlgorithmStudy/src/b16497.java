import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class b16497 { // 대출요청 
	static int n,book;
	static class state implements Comparable<state>{
		int sday,eday;
		state(int sday,int eday) {
			this.sday=sday;
			this.eday = eday;
		}
		public int compareTo(state s) {
			if(this.sday > s.sday) return 1;
			else if(this.sday==s.sday) return 0;
			else return -1;
		}
	}
	
	static class ret implements Comparable<ret>{
		int retday;
		ret(int retday){
			this.retday= retday;
		}
		public int compareTo(ret r){
			if(this.retday > r.retday) return 1;
			else if(this.retday == r.retday) return 0;
			else return -1;
		}
	}
	static PriorityQueue<state> pq; // 대출일 , 반납일 
	static PriorityQueue<ret> re; // 반납일 
  public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	n = Integer.parseInt(bf.readLine());
	pq = new PriorityQueue<>();
	re = new PriorityQueue<>();
	for(int i =0; i<n; i++) {
		st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		pq.offer(new state(start,end));
	}
	
	book = Integer.parseInt(bf.readLine());
	boolean check = false;
	int time = 0;
	
	while(!pq.isEmpty()) {
	    // 반납먼저 
		while(true) {
			if(!re.isEmpty() && re.peek().retday == time) {
				re.poll();
				book++;
			}else break;
		}
		
		//책 대여
		while(true) {
			if(!pq.isEmpty() && pq.peek().sday == time) {
			  if(book==0){ // 책이없다면 
				  check = true;
				  break;
			  }else { 
				  state p = pq.poll();
				  re.offer(new ret(p.eday)); // 반납일 저장 
				  book--;// book 개수 감소 
			  }
			}else break;
		}
		
		if(check) break;
		time++;
	}
	
	if(check) System.out.println(0);
	else System.out.println(1);
	
	bf.close();
	
  }
}
