import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1620 {
	static int n , m ,hashcode[];
	static String arr[];
	
	static class Hashtable {
		class Hash {
			String key;
		}
		int capacity;
		Hash tb[];
		Hashtable(int capacity) {
			this.capacity = capacity;
			tb = new Hash[capacity];
			for(int i =0; i<capacity; i++) {
				tb[i] = new Hash();
			}
		}
		private int hash(String str) {
			int hash = 5381;
			for (int i = 0; i < str.length(); i++) {
				int c = (int) str.charAt(i);
				hash = ((hash << 5) + hash) + c;
			}
			if (hash < 0) hash *= -1;
			return hash % capacity;
	    }
		int add(String key) {
			int h = hash(key);
			while(hashcode[h] !=-1) {
				h = (h+1) % capacity;
			}
			tb[h].key = key;
			return h;
		}
		
		int find(String key){
			int h = hash(key);
			int cnt = capacity;
			while(hashcode[h]!=-1 && (--cnt) !=0){
				if(isCheck(key, tb[h].key)) return h;
				h = (h+1) % capacity;
			}
			return -1;
		}
		boolean isCheck(String key,String data){
			int len = key.length();
			if(len!=data.length()) return false;
			for(int i =0; i<len; i++){
				if(key.charAt(i)!=data.charAt(i)) return false;
			}
			
			return true;
		}
		
	}
	
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st  = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	hashcode = new int[100001];
	for(int i =0; i<100001; i++) {
		hashcode[i] = -1;
	}
	arr= new String[n+1];
	Hashtable tb = new Hashtable(100001);
	for(int i =1; i<=n; i++){
		String s = bf.readLine();
		int idx= tb.add(s);
		hashcode[idx] = i;
		arr[i] = s;
	}
	for(int i =0; i<m; i++){
		String s = bf.readLine();
		if(s.charAt(0) -'A' >=0){
			int idx = tb.find(s);
			System.out.println(hashcode[idx]);
		}else {
			System.out.println(arr[Integer.parseInt(s)]);
		}
	}
 }
}
