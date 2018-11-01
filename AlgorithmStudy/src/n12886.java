import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n12886 { //돌 그룹
	static int arr[],v[][],max;
	static boolean result;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	arr= new int[3];
	StringTokenizer st = new StringTokenizer(bf.readLine());
	for(int i =0; i<3; i++) {
		arr[i] = Integer.parseInt(st.nextToken());
		max =Math.max(arr[i], max);
	}
	
	v = new int[max*3][max*3];// 넉넉하게 잡고 
	result = false;
	func(arr);
	
	if(result) {
	System.out.println(1);
	}else System.out.println(0);
	bf.close();	
 }
 
 static void func(int temp[]) {
	 if(result) return;
	 if(temp[0] == temp[1] && temp[0]== temp[2]) {
		 result = true;
		 return;
	 }
	 
	 int t[] = new int[3];
	 for(int i =0; i<3; i++) {
		 t[i] = temp[i];
	 }
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j)
					continue;
				if (t[i] == t[j])
					continue;
//				if (v[t[i]][t[j]] == 0 && v[t[j]][t[i]] == 0) { // 선택된 돌이 이미 계산했었던 돌이 아니라면 (여기에도 가능)
//					v[t[i]][t[j]] = 1;
//					v[t[j]][t[i]] = 1;
					int min = 0;
					if (t[i] > t[j]) {
						min = t[j];
						t[j] += t[j];
						t[i] = t[i] - min;
					} else if (t[i] < t[j]) {
						min = t[i];
						t[i] += t[i];
						t[j] = t[j] - min;
					}
					if (t[i] >= 0 && t[j] >= 0) {
						if (v[t[i]][t[j]] == 0 && v[t[j]][t[i]] == 0) { // 선택된 돌이 이미 계산했었던 돌이 아니라면 (여기에도가능)
							v[t[i]][t[j]] = 1;
							v[t[j]][t[i]] = 1;
						func(t);
						}
					}
			//	}
			}
		}
	 
 }
 
}
