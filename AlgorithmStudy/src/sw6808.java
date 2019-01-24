import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class sw6808 { //규영이와 인영이의 카드게임 
	static int  arr[], arr2[], v[] ,win1,win2, temp[];
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int testcase  = Integer.parseInt(bf.readLine());
	for(int t=1; t<=testcase; t++) {
		arr = new int[9];
		arr2 = new int[9];
		temp = new int[9];
		v = new int[20];
		visit = new int[9];
		st = new StringTokenizer(bf.readLine());
		for(int i =0; i<9; i++){
			arr[i]= Integer.parseInt(st.nextToken());
			v[arr[i]] +=1;
		}
		int index = 0;
		for(int i=1; i<=18; i++) {
			if(v[i] == 0) {
				arr2[index++] = i;
			}
		}
		win1 = 0;
		win2 = 0;
		func(0);
		
		System.out.println("#"+t+" "+win1+" "+win2);
		
	}
	
	bf.close();
}
 
 static int visit[];
 static void func(int cnt) {
	 if( cnt == 9){
		 func2();
		 return ;
	 }
	 for(int i =0; i<9; i++) {
		if(visit[i] == 0) {
			visit[i] = 1;
			temp[cnt] = arr2[i];
			func(cnt+1);
			visit[i] = 0;
		}
	 }
	 
 }
 
 static void func2() {
	 int w1=0 , w2=0;
	 for(int i =0; i<9; i++) {
		 if(arr[i] < temp[i]){
			 w2+= (arr[i]+temp[i]) ;
		 }else if(arr[i] > temp[i]){
			 w1+= (arr[i]+temp[i]) ;
		 }
	 }
	 
	 if(w1 > w2)win1 +=1;
	 else if(w1 < w2) win2+=1;
	 
 }
 
 
}
