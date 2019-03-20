import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n10815_2 { //숫자카드 -> 배열로 해쉬값 접근하도록 만듬 
 public static void main(String[] args) throws IOException{
	 	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	 	int n = Integer.parseInt(bf.readLine());
	 	int arr[] = new int[10000001];
	 	int arr2[] = new int[10000001];
	 	StringTokenizer st = new StringTokenizer(bf.readLine());
	 	for(int i =0; i<n; i++){
	 		int num = Integer.parseInt(st.nextToken());
	 		if(num>=0){
	 			arr[num] +=1;
	 		}else{
	 			num*=-1;
	 			arr2[num]+=1;
	 		}
	 	}
	 	StringBuilder sb = new StringBuilder();
	 	int m = Integer.parseInt(bf.readLine());
	 	st = new StringTokenizer(bf.readLine());
	 	for(int i =0; i<m; i++){
	 		int num = Integer.parseInt(st.nextToken());
	 		if(num>=0){
	 			if(arr[num]>0)  sb.append("1 ");
	 			else sb.append("0 ");
	 		}else{
	 			num*=-1;
	 			if(arr2[num]>0)  sb.append("1 ");
	 			else sb.append("0 ");
	 		}
	 	}
	 	System.out.println(sb.toString());
	 	bf.close();
 }
}
