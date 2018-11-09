import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class a16235 { //  나무 재테크 (SAMSUNG CEIM) 
	static int n ,m,k, Plus[][], init[][],breeding[][];
	static final int dx[] = {0,0,1,-1,1,1,-1,-1},dy[]={1,-1,0,0,1,-1,1,-1};
	
	static class state {
		PriorityQueue<Integer> tree = new PriorityQueue<>();
		Queue<Integer> treedie = new LinkedList<>();
		state(PriorityQueue<Integer> tree, Queue<Integer> treedie) {
			this.tree= tree;
			this.treedie= treedie;
		}
	}
	
	static state map[][][];
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st  = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	k = Integer.parseInt(st.nextToken());
	
	Plus = new int[n][n];
	init = new int[n][n];
	breeding= new int[n][n];
	map = new state[n][n][1001];
	
	for(int i =0; i<n; i++) {
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<n; j++) {
			init [i][j] = Integer.parseInt(st.nextToken());
			Plus[i][j] = 5; // 양분
			for(int y=0; y<=k; y++){
				PriorityQueue<Integer>pq = new PriorityQueue<Integer>();
				Queue<Integer> q  = new LinkedList<Integer>();
				map[i][j][y] = new state(pq,q);
			}
		}
	}
	
	for(int i =0; i<m; i++) {
        st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken())-1;
		int b = Integer.parseInt(st.nextToken())-1;
		int age = Integer.parseInt(st.nextToken());
		map[a][b][0].tree.add(age);
	}
	
	
	for(int i =0; i<k ;i++){
		func(i);	
	}
	
	int result = 0;
    for(int i =0; i<n; i++) {
    	for(int j =0; j<n; j++) {
    		result +=map[i][j][k].tree.size();
    	}
    }
	
	System.out.println(result);
	bf.close();
	
 }
 
 //n *n // M개의 나무 구매 // K년 후
 static void func(int y) {
	 
  // Spring 
	 for(int i =0; i<n; i++) {
		for(int j =0; j<n; j++) {
		  while(!map[i][j][y].tree.isEmpty()) {
	         int age = map[i][j][y].tree.poll();
	          if(Plus[i][j] >=age) { // age +  1
	        	Plus[i][j]-=age;
	        	map[i][j][y+1].tree.offer(age+1);
	        	
	          }else { //die 
	        	map[i][j][y+1].treedie.offer(age);
	          }
		  }
		}
	 }
	 
  // summer
	 for(int i =0; i<n; i++) {
		 for(int j=0; j<n; j++) {
			 if(map[i][j][y+1].treedie.size() ==0) continue;
			 while(!map[i][j][y+1].treedie.isEmpty()) {
				 int dieage = map[i][j][y+1].treedie.poll();
				 int dietreeplus = dieage/2;
				 Plus[i][j] += dietreeplus;
			 }
		 }
	 }
	 
  // fall -> 번식 
	 for(int i =0; i<n; i++) {
		 for(int j =0; j<n; j++) {
			 int size = map[i][j][y+1].tree.size();
			 int cnt =0;
			 PriorityQueue<Integer> pq = new PriorityQueue<>();
			 //현 위치 나무 나이가 5의 배수 번식하면 된다 .
			 while(cnt <size) {
			  int age = map[i][j][y+1].tree.poll();
			  if(age %5 ==0) {
				  breeding[i][j] +=1; // 번식 한 개수 증가 시킴 
			  }
			  pq.offer(age); //우선순위큐라 따로 저장 
			  cnt++;
			 }
			 
			 while(!pq.isEmpty()) { // 
				 int preage = pq.poll();
				 map[i][j][y+1].tree.offer(preage);
			 }
			 
		 }
	 }
	 
	 //번식할 개수만큼 실제 번식 .
	 for(int i =0; i<n; i++) {
		 for(int j =0; j<n; j++) {
		  for(int bre = 0; bre < breeding[i][j]; bre++) {
			 for(int d =0; d<8; d++) {
					int a = i+dx[d];
					int b = j+dy[d];
					if(a>=0 && b>=0 && a<n && b<n) {
						map[a][b][y+1].tree.offer(1);
					}
			 }
		  }
		 }
	 }
	 
	 
	 
  // winter ->
	 for(int i =0; i<n; i++) {
		 for(int j =0; j<n; j++) {
			 Plus[i][j] += init[i][j];
			 breeding[i][j] = 0;
		 }
	 }
	 
 }
 
}
