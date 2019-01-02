import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class b2110 { // 공유기 설치
	static int n , c ,arr[];
 public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	c = Integer.parseInt(st.nextToken());
	arr = new int[n];
	for(int i =0; i<n; i++) {
		arr[i] = Integer.parseInt(bf.readLine());
	}
	
	Arrays.sort(arr);
	int left = 1; // 최소거리 
	int right =  arr[n-1] - arr[0]; // 최대거리 
	int d =  0;
	int ans = 0;
	 
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 1;
			int s = arr[0];
			// 간격d 를 기준으로 설치
			for (int i = 1; i < n; i++) {
				d = arr[i] - s;
				if (mid <= d) {
					cnt++;
					s = arr[i];
				}
			}

			if (cnt >= c) { // 
				ans = mid; 
				// 공유기의 수를 줄이자 => 간격 넓히기
				left = mid + 1;
			}else { 
				// 공유기가 더 설치되어야한다. => 간격 좁히기
				right = mid - 1;
			}

		}
		System.out.println(ans);
		bf.close();
 }
}
//http://mygumi.tistory.com/301
