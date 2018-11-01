import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class s12886 {
	static int arr[], ans,v[][];
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	arr = new int[3];
    StringTokenizer st  = new StringTokenizer(bf.readLine());
    
    for(int i =0; i<3; i++) {
    	arr[i] = Integer.parseInt(st.nextToken());
    }
    v = new int[3000][3000];
    ans = 0;
    finish = false;
    func(arr);
    System.out.println(ans);
    bf.close();
    
 }
 static boolean finish ;
 static void func(int temp[]) {
	 if(finish) return;
	 if(temp[0] == temp[1] && temp[0] == temp[2]) {
		 finish = true;
		 ans = 1;
		 return;
	 }
	 int t[] = new int[3];
	 
	 for(int i =0; i<3; i++) {
		 t[i] = temp[i];
	 }
	 
	 for(int i =0 ; i< 3; i++) {
		 for(int j =0; j< 3; j++) {
			 if(i==j) continue;
			 if(t[i] == t[j]) continue;
			 if(v[t[i]][t[j]] == 0 && v[t[j]][t[i]] == 0) { // 두개 고른적이 없는 경우
				 v[t[i]][t[j]] =1;
				 v[t[j]][t[i]] =1;
				 
					// 돌의 개수가 작은 쪽을 X, 큰 쪽을 Y라고 정한다.
					// 그 다음, X에 있는 돌의 개수를 X+X개로, Y에 있는 돌의 개수를 Y-X개로 만든다.
					int X = 0;
					int Y = 0;
					if (t[i] > t[j]) {
						Y = t[i];
						X = t[j];
						t[i] = Y-X;
						t[j] = X+X;
					}
					else if(t[i] < t[j]){
						Y = t[j];
						X = t[i];
						t[j] = Y-X;
						t[i] = X+X;
					}
					if(t[i] >=0 && t[j]>=0){
				     func(t);
					}
			 }
		 }
	 }
	 
 }
 
}
