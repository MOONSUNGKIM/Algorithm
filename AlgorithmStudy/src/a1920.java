import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a1920 { // 수찾기 -> binarySearch 
	static int n, m, arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(0,arr.length-1);
		
		m = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (binarySearch(num)) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
		bf.close();
	}

	static void quickSort(int s, int e) {
		if (s < e) {
			int p = arr[(s + e) / 2];
			int L = s;
			int R = e;
			do {
				while (arr[L] < p) {
					L++;
				}
				while (arr[R] > p) {
					R--;
				}
				if (L <= R) {
					int temp = arr[L];
					arr[L] = arr[R];
					arr[R] = temp;
					L++;
					R--;
				}
			} while (L <= R);
			quickSort(L, e);
			quickSort(s, R);
		}

	}
	
	static boolean binarySearch(int num) {
		int s = 0;
		int e = (arr.length - 1);
		while (s <= e) {
			int mid = (s + e) / 2;
			if (num == arr[mid]) {
				return true;
			}
			if (num < arr[mid]) {
				e = mid - 1;
			} else if (num > arr[mid]) {
				s = mid + 1;
			}
		}
		
		return false;
	}
	
	static boolean binarySearch2(int num,int s,int e) {
		if (s <= e) {
			int mid = (s + e) / 2;
			if (arr[mid] == num) {
				return true;
			}
			if (arr[mid] > num) {
				return binarySearch2(num, s, (mid-1));
			} 
			else if (arr[mid] < num) {
				return binarySearch2(num, (mid+1), e);
			}
		}
		return false;
	}
	
}
