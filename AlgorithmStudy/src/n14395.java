import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class n14395 { // 4연산 
	static int s,t,min;
	static String result;
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
    s = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());
    result = "";
    min = 2100000000;
    if( s==0) {
    	System.out.println(-1);
    }else if(s==t) {
    	System.out.println(0);
    }else {
    func(s,0,"");
    System.out.println(result);
    }
    bf.close();
 }
 
 static void func(long sum,int cnt,String str) {
	 System.out.println(sum);
	 if(sum == t){
		 if(min > cnt) {
			 result = str;
			 min = cnt;
		 }
		 return;
	 }
	 
	 if((sum - s )> t ) return;
	 else if(sum <0) return;

	 for(int i =0; i<4; i++) {
	   
		 if(i==0) {
			 func(sum*s,cnt+1,str+"*");
		 }else if(i==1) {
			 func(sum+s,cnt+1,str+"+");
		 }else if(i==2) {
			 func(sum-s,cnt+1,str+"-");
		 }else if(i==3) {
			 func(sum/s,cnt+1,str+"/");
		 }
	   
	 }
	 
 }
 
}
