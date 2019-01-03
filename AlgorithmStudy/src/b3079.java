import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class b3079 {
	static long n , m ,arr[], ans, result, max, max2 ;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	arr = new long[100001];
	max = (long)1e18; // 
	result = max;
	max2 = 1;
	
	for(int i =0; i<n; i++) {
		arr[i] = Integer.parseInt(bf.readLine());
		max2 = Math.max(max2, arr[i]); 
	}
	
	 
	long left = 0 ; // 최소 
	long right = (max2*m) -1 ; // 입국심사를 한명에게 몰렸을때가 최대니까  
    
	while(left <= right) {
		long sum = 0; 
		long mid = (left+right)/2;
		
		for(int i =0; i<n; i ++) {
			sum += (mid / arr[i]);
		}
		
		if(sum>=m) { // 인원수보다많이 처리해야할때 간격을 좁히자 
			ans = mid;
			right = mid-1;
		}else { // 인원수보다 적게 처리될때 간격을 넓히자 
			left = mid+1;
		}
		
	}
	
	//
	//System.out.println(left);
	System.out.println(ans);
	bf.close();
	
 }
}
