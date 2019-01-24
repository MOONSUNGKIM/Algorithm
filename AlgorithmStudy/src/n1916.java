import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class n1916 { // 최소비용 -> 우선순위큐 구현 
	
	static class priority_queue {
		state arr[] = new state[100001];
	    int idx ;
	    priority_queue(){
	    	this.idx = 0;
	    }
	    public boolean isEmpty(){
	    	return idx ==0;
	    }
	    public int size(){
	    	return idx;
	    }
	    public void offer(state s) {
	    	arr[idx++] = s;
	    	int curr = idx-1;
	    	while(true) {
	    	  if(curr == 0) break;
	    	  int par = (curr-1)/2;
	    	  if(arr[par].cost  >  arr[curr].cost) {
	    		  state temp = arr[par];
	    		  arr[par] = arr[curr];
	    		  arr[curr] = temp;
	    	  }
	    	  curr= par;
	    	}
	    }
	    
	    public state poll() {
	    	state re = arr[0];
	    	arr[0] = arr[--idx];
	    	int curr = 0;
	    	int next;
	    	while(curr*2+1 < idx){
	    		next = curr;
	    		if(arr[next].cost > arr[curr*2+1].cost) next = curr*2+1;
	    		if(curr*2+2 < idx && arr[next].cost > arr[curr*2+2].cost) next = curr*2+2;
	    		if(next == curr) break;
	    		
	    		state temp = arr[curr];
	    		arr[curr] = arr[next];
	    		arr[next] = temp;
	    		
	    		curr= next;
	    		
	    	}
	    	return re;
	    }
	}

	static class state {
		int end, cost;
		state(int end, int cost) {
			this.end =end;
			this.cost = cost;
		}
	}
	
	static priority_queue pq;
	static int n , m ,cost[],start,end;
	static ArrayList<state> graph[];
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	m = Integer.parseInt(bf.readLine());
	cost = new int[n+1];
	graph = new ArrayList[n+1];
	for(int i =0; i<=n; i++){
		cost[i] = Integer.MAX_VALUE;
		graph[i] = new ArrayList<>();
	}
	
	StringTokenizer st ;
	for(int i =0; i<m; i++) {
		st = new StringTokenizer(bf.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		graph[s].add(new state(e,c));
	}
	
	st = new StringTokenizer(bf.readLine());
	start = Integer.parseInt(st.nextToken());
	end = Integer.parseInt(st.nextToken());
	
	pq = new priority_queue();
	pq.offer(new state(start,0));
	cost[start] = 0;
	while(!pq.isEmpty()) {
		state p = pq.poll();
		for(int i =0; i<graph[p.end].size(); i++) {
			state p2 = graph[p.end].get(i);
			if(cost[p2.end] > cost[p.end] + p2.cost){
				cost[p2.end] = cost[p.end] + p2.cost;
				pq.offer(new state(p2.end, cost[p2.end]));
			}
		}
	}
	
	System.out.println(cost[end]);
	bf.close();
}
 
}
