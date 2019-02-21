
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class a16928 { // 뱀과 사다리 게임 
	
	static int n , m,map[][],v[][];
	static class state implements Comparable<state> {
		int num,c;
		state(int num,int c) {
			this.num = num;
			this.c=c;
		}
		public int compareTo(state s) {
			if(this.c > s.c) return 1;
			else if(this.c==s.c) return 0;
			else return -1;
		}
	}
	
	static PriorityQueue<state> pq;
	static int lad[],snk[];
	
 public static void main(String[] args) throws IOException {
	 
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	
	lad = new int[101];
    snk = new int[101];
    
    for(int i =0; i<n; i++) {
    	st = new StringTokenizer(bf.readLine());
    	int start = Integer.parseInt(st.nextToken());
    	int end = Integer.parseInt(st.nextToken());
    	lad[start] = end;
    }
    
    for(int i =0; i<m; i++) {
    	st = new StringTokenizer(bf.readLine());
    	int start = Integer.parseInt(st.nextToken());
    	int end = Integer.parseInt(st.nextToken());
    	snk[start] = end;
    }
	
	
    map = new int[11][11];
    int num = 1;          
    for(int i =1; i<=10; i++) {
    	for(int j =1; j<=10; j++) {
    		map[i][j] = num++;
    	}
    }    
    
    v = new int[101][7];    
    pq = new PriorityQueue<>();    
    pq.offer(new state(1,0));
    
    while(!pq.isEmpty()) {    	
    	state p = pq.poll();   
    	if(p.num == 100) {
    		System.out.println(p.c);
    		break;
    	}
    	
    	for(int i =1; i<=6; i++) {
    	 int number = ( p.num + i );
    	 if(number>100) break;
    	 if(v[number][i] == 0) {
    		 v[number][i] = 1;
    		 if(lad[number]!=0) {    			 
    			 pq.offer(new state(lad[number],p.c+1));
    		 }
    		 else if(snk[number] !=0) {    			 
    			 pq.offer(new state(snk[number],p.c+1));
    		 }else
    			 pq.offer(new state(number,p.c+1));
    	 }
    	}
    	
    }
        
	bf.close();	
 }

}


