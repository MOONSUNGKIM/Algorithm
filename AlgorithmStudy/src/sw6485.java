import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class sw6485 { //삼성시의 버스노선 
	static int n,p,count[];
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st ;
	int testcase = Integer.parseInt(bf.readLine());
	for(int t=1 ;t<=testcase ; t++) {
	 n = Integer.parseInt(bf.readLine());
	 count = new int[5001];
	 for(int i =0; i<n; i++){
		 st = new StringTokenizer(bf.readLine());
		 int s = Integer.parseInt(st.nextToken());
		 int e = Integer.parseInt(st.nextToken());
		 for(int k=s; k<=e; k++) {
			 count[k] +=1;
		 }
	 }
	 p = Integer.parseInt(bf.readLine());
	 StringBuilder sb = new StringBuilder();
	 for(int i =0; i<p; i++){
		 int number = Integer.parseInt(bf.readLine());
		 sb.append(count[number]+" ");
	 }
	 System.out.println("#"+ t+" "+sb.toString());
	}
	bf.close();
}
}
