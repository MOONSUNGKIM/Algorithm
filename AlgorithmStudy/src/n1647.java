import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
이 문제는 MST로 해결할 수 있습니다.
MST라고 생각한 이유
1. 모든 집은 전부 연결되어야 한다.
2. 필요 없는 다리는 제거한다.(유지 비용이 작은 다리만 남겨둔다.)
이 두 가지 조건을 보고 MST라고 생각했습니다.
그렇다면 한 마을을 두 마을로 어떻게 나눌까요?

두 마을로 나눴을 때 한쪽 마을에 집이 한 채 이상이라면 두 마을로 나눠진 것입니다.
즉, 크루스칼을 이용하여 n - 2개의 다리만 연결하면 됩니다.
왜 n - 1이 아닌 n - 2인지 설명해드리겠습니다.
우선 마을이 하나라고 생각하고 MST를 이용해 모든 집을 연결하겠지요?
그리고 두 마을로 나눠야하는데
제가 생각했을 때 어차피 최소 비용을 유지하려면 가장 유지비가 큰 다리를 제거하면 된다는 것입니다.
그래서 n - 1개를 연결하고 그 다리 중에 가장 큰 비용의 다리 하나를 제거하면 된다는 뜻이 됩니다.
근데 크루스칼은 어차피 최소 비용을 가진 것 부터 처리하므로 애초에 마지막 다리를 설치하지도 않은 채 n - 2개의 다리만 연결한다면 문제를 해결할 수 있습니다.
*/

public class n1647 { // 도시분할계획 -> 크루스칼 알고리즘 
	static int n , m, parent[] ;
	static class state{
		int num1,num2, cnt ;
		state(int num1,int num2 , int cnt) {
			this.num1= num1;
			this.num2= num2;
			this.cnt = cnt;
		}
	}
	static state graph[];
public static void main(String[] args) throws IOException { 
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	parent = new int [n+1];
	graph =new state[m+1];
	for(int i =0; i<m; i++) {
		st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		graph[i] = new state(a,b,c);
	}
	
	makeSet();
	quickSort(0,m-1);
	
	int selectcnt = 0;
	int cost = 0;
	
	for(int i =0; i<m; i++) {
		int a = graph[i].num1;
		int b = graph[i].num2;
		int c = graph[i].cnt;
		if(findSet(a) == findSet(b)) continue;
		unionSet(a,b);
		cost +=c;
		selectcnt ++;
		if(selectcnt >= n-2) break;
	}
	System.out.println(cost);
	bf.close();
 }
	
	static void quickSort(int s, int e){
		int L = s;
		int R = e;
		state pivot = graph[(s+e)/2];
		do{
			while(graph[L].cnt < pivot.cnt) L++;
			while(graph[R].cnt > pivot.cnt) R--;
			if(L<=R){
				state temp = graph[L];
				graph[L] = graph[R];
				graph[R] = temp;
				L++;
				R--;
			}
		}while(L<=R);
		if(L<e) quickSort(L,e);
		if(R>s) quickSort(s,R);
		
	}
 	static void makeSet() {
 		for(int i =1; i<=n; i++) {
 			parent[i] = i;
 		}
 	}
 	static void unionSet(int a, int b) {
 		a = findSet(a);
 		b = findSet(b);
 		if(a==b) return ;
 		parent[a] = b;
 	}
 	
 	static int findSet(int num) {
 	 if(parent[num] == num) return num;
 	 return parent[num] = findSet(parent[num]);
 	}
}
