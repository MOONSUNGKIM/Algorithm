import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class n1922 { // 네트워크연결 
	static class Priorityq{
		state arr[] = new state[1000001];
		int idx ;
		Priorityq(){
			this.idx = 0;
		}
		public boolean isEmpty() {
			return idx == 0;
			
		}
		public int size(){
			return idx;
		}
		public void offer(state s) {
		  arr[idx++] = s;
		  int curr = idx-1;
		  while(true) {
			  if(curr==0) break;
			  int par = (curr-1)/2;
			  if(arr[par].cost > arr[curr].cost){
				  state temp = arr[par];
				  arr[par] = arr[curr];
				  arr[curr] = temp;
			  }
			  curr = par;
		  }
			  
		}
		public state poll(){
			state re = arr[0];
			arr[0] = arr[--idx]; 
			int curr=0;
			int next;
			while(curr*2+1 < idx){
				next = curr;
				if(arr[next].cost > arr[curr*2+1].cost) next = curr*2+1;
				if(curr*2+2 < idx && arr[next].cost > arr[curr*2+2].cost) next = curr*2+2;
				if(curr==next) break;
				
				//
				state temp = arr[next];
				arr[next] = arr[curr];
				arr[curr] = temp;
				curr= next;
			}
			return re;
		}
	}
	
	
	static int n , m ,v[];
	static class state {
		int curnum, cost;
		state(int curnum, int cost) {
			this.curnum = curnum;
			this.cost = cost;
		}
	}
	
	static ArrayList<state> graph[];
	static Priorityq pq;
 public static void main(String[] args) throws IOException {
	 
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	m = Integer.parseInt(bf.readLine());
	graph = new ArrayList[n+1];
	
	v = new int[n+1];
	for(int i =0; i<=n; i++) {
		graph[i] = new ArrayList<>();
	}
	
	StringTokenizer st ;
	
	for(int i =0; i<m; i++) {
		st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		graph[a].add(new state(b,c));
		graph[b].add(new state(a,c));
	}
	pq = new Priorityq();
	v[1] = 1;
	for(int i =0; i<graph[1].size(); i++){
		pq.offer(new state(graph[1].get(i).curnum , graph[1].get(i).cost));
	}
	
	int sumcost = 0;
	
	while(!pq.isEmpty()){
		state p = pq.poll();
		int curnum = p.curnum;
		int cost = p.cost;
		if(v[curnum] == 0) {
			v[curnum] = 1;
			sumcost += cost;
			for(int i =0; i<graph[curnum].size(); i++)
			{		
				state p2= graph[curnum].get(i);
				pq.offer(new state(p2.curnum, p2.cost));
			}
		}
	}
	
	System.out.println(sumcost);
	bf.close();
	
}
}
