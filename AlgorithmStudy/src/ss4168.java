import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ss4168 {
	static int limitmoney,mindex,money[],smile[], maxsmile,v[];
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int testcase = Integer.parseInt(bf.readLine());
	for(int t=1; t<=testcase; t++) {
	   st = new StringTokenizer(bf.readLine());
	   limitmoney = Integer.parseInt(st.nextToken());
	   mindex = Integer.parseInt(st.nextToken());
	   money = new int[mindex];
	   smile = new int[mindex];
	   for(int i =0; i<mindex; i++){
		st = new StringTokenizer(bf.readLine());
		money[i] = Integer.parseInt(st.nextToken());
		smile[i] = Integer.parseInt(st.nextToken());
	   }
	    maxsmile = -1;
	    v= new int[mindex];
	    func(0,0,0,v);
	   StringBuilder sb = new StringBuilder();
	   for(int i =0; i<mindex; i++) {
		   if(v[i] == 1) {
			   sb.append(i+" ");
		   }
	   }
	   sb.append(maxsmile);
		System.out.println("#"+t+" "+sb.toString());
	}
	
	bf.close();
 }
 
 static void func(int idx, int m, int s,int pick[]) {
	 if(idx>=mindex){
		 if(maxsmile < s){
			 maxsmile = s;
			 for(int i =0; i<mindex; i++){
				 v[i] = pick[i];
			 }
		 }
		 
		 return;
	 }
	 int p [] = new int[mindex];
	 for(int i =0; i<mindex; i++) {
	     p[i] = pick[i];
	 }
	 if(m+money[idx] <=limitmoney){
	  p[idx] +=1;
	  func(idx+1, m+money[idx] , s+smile[idx], p);
	  p[idx] -=1;
	 }func(idx+1, m,s,p);
 }
 
}
