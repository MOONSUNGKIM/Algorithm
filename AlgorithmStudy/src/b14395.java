import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//4연산 
public class b14395 {
	static int s,t,count;
	static HashMap<Long,String> hm;
	static String ans;
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	s= Integer.parseInt(st.nextToken());
	t= Integer.parseInt(st.nextToken());
	hm = new HashMap<Long, String>();
    if(s == t) System.out.println(0);
    else {
     count= 2100000000;
	 func((long)s,"",0);
	 if(count == 2100000000) {
		 ans = "-1";
	 }
	 System.out.println(ans);
    }
    
	bf.close();
 }
 static void func(long sum, String str, int cnt) {
	 if(cnt > count ) return;
	 if(sum<0 || sum!=s && sum>1000000000) return;
	 if(t == sum) {
		 if(cnt < count) {
			 count = cnt;
		     ans= str;
		 }
		 return;
	 }
	 
	 if(!hm.containsKey(sum)) {
		 hm.put(sum, "");
	  long ss = sum;
	  func(ss*ss,str+"*",(cnt+1));
	  func(ss+ss , str+"+",(cnt+1));
	  func(ss-ss, str+"-",(cnt+1));
	  if(ss>0){
	  func(ss/ss, str+"/",(cnt+1));
	  }
	    hm.remove(sum);
	 }
 }
 
}
