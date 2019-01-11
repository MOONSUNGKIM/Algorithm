import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class b1922 { // 네트워크연결 
	//프림알고리즘 적용 
	static int n , m ,weight[],graph[][];
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	n = Integer.parseInt(bf.readLine());
	m = Integer.parseInt(bf.readLine());
	graph = new int[n+1][n+1];
	weight = new int[n+1];
	for(int i =1; i<=n; i++){
		for(int j =1; j<=n; j++){
			graph[i][j] = 2100000000;
		}
	}
   
	for(int i =0; i<m; i++){
		st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int cost = Integer.parseInt(st.nextToken());
		graph[a][b] = cost;
		graph[b][a] = cost;
	}
	
	for(int i =0; i<=n; i++) weight[i] = -1;
	
	weight[1] = 0; //임의 시작정점 1로 잡음 따라서 0 으로 초기화 
	int sumcost = 0;
	
	for(int k =2; k<=n; k++) { // 2~ n 만큼 돌면서  노드선택	
		int minindex =0  ;
		int minweight = 2100000000;
		//이미 선택된것 중 선택 안된 노드를 방문해야한다 
		for(int i =1; i<=n; i++) {
			if(weight[i] <0) continue; // 선택안된건 continue;
			for(int j =1; j<=n; j++){ 
				if(weight[j] >=0) continue; // 선택된건 continue; 
				
				if(graph[i][j] < minweight) {
					minindex = j;
				    minweight = graph[i][j]; 
				}
			}
		}
		weight[minindex ] = minweight;
		sumcost += weight[minindex];
	}
	System.out.println(sumcost);
	bf.close();
 }

}
