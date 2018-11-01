import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class sw5653 { //줄기세포배양
	static int n, m , k,map[][],timearr[][], ans;
	static class sw implements Comparable<sw> {
		int x,y,hp,hpstate,state,time,check;
		sw(int x, int y,int hp, int hpstate ,int state, int time,int check) {
			this.x=x;
			this.y=y;
			this.hp =hp; // 기존 hp 
			this.hpstate = hpstate; // hp 현상태  
			this.state = state; // 0 -> 비 // 1-> 활 
			this.time = time; // 전체시간 
			this.check = check; // 번식유무체크 
		}
		
		public int compareTo(sw o) {
			if(this.time> o.time)return 1;
			else if(this.time == o.time) return 0;
			else return -1;
		}
	}
	
	static PriorityQueue<sw> pq;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int testcase= Integer.parseInt(bf.readLine());
	for(int t=1; t<=testcase; t++) {
	    st= new StringTokenizer(bf.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    k = Integer.parseInt(st.nextToken());
	    map = new int[701][701];
	    timearr = new int[701][701];
	    pq = new PriorityQueue<>();
	    for(int i=300; i<300+n; i++) {
	    	st = new StringTokenizer(bf.readLine());
	    	for(int j =300; j<300+m; j++) {
	    		map[i][j] = Integer.parseInt(st.nextToken());
	    		if(map[i][j] !=0) {
	    		 pq.offer(new sw(i,j,map[i][j],map[i][j],0,0,0));
	    		}
	    	}
	    }
	    ans = 0;
	    func();
		System.out.println("#"+t+" "+ans);
		
	}

	bf.close();
 }
 
 static final int dx[] = {0,0,1,-1},dy[]={1,-1,0,0};
 
 static void func() {
	   while(!pq.isEmpty()) {
		  sw p = pq.poll();
		  if(map[p.x][p.y] != p.hp) continue;
		  //번식시에 같은 시간때 두개 이상 들어온것 인데 하나가 큐에 들어가고 다른 하나가 왔을 수 있다. 
          // 그래서 이전에 들어간 큐 값을 빼줌. 
		  
		  if(p.time == k){
			  ans ++;
			  continue;
		  }
			 if(p.state == 0) { // 비활성상태이면
			   if((p.hpstate -1) == 0) { // 다음 상태가 활성상태로 변할거니 state -> 1로 변경 
				   pq.offer(new sw(p.x,p.y,p.hp,p.hp,1,(p.time+1),0));
			   }else {
			       pq.offer(new sw(p.x,p.y,p.hp,(p.hpstate-1),0,(p.time+1),0));
			   }
			 }
			 
			 else if(p.state == 1) { // 활성상태이면
			  if(p.check == 0){ // 번식안한것일경우 ! 
			   for(int i =0; i<4; i++) { // 4dir 번식 
				   int x = p.x+dx[i];
				   int y = p.y+dy[i];
				   
				  if(map[x][y] == 0) { // 없는곳 -> 그리드
					 timearr[x][y] = (p.time+1);
					 map[x][y] = p.hp;
					 pq.offer(new sw(x,y,p.hp,p.hp,0,(p.time+1),0));
				  }

				  else { // 맵에 무언가 있다! .
					// 같은시간대가 아닌 이전에 있었던거면 안됨 
					if(timearr[x][y] == (p.time+1)) { // 같은시간대에 들어와있는게 있다! 
						// 생명력 비교 
						if(map[x][y] < p.hp) // 내가 더 크당 
						{
						 map[x][y] = p.hp;
						 if(p.hpstate-1 != 0) { // 다음상태가 죽을상태가 아닐때만 큐에넣어준다  
						  pq.offer(new sw(x,y,p.hp,p.hp,0,(p.time+1),0));
						 }
						 
						}
					}
				  }
			   }
			  }
			  
			   //번식 후 현재위치 ( 생명력 다할때까지 살아있어야 함 )
			   if((p.hpstate -1) >0) { // 다음상태가 죽을상태가 아닐때만 큐에넣어준다 
				   pq.offer(new sw(p.x,p.y,p.hp,(p.hpstate-1),p.state,(p.time+1),1)) ; // 번식했으니 1로 변경 
			   }
			 }
			 
	   }
 }

}
