import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2503 { // 숫자야구 
	static int n ,ans;
	static class sw {
		int s,b,num;
		sw(int num,int s, int b) {
			this.num = num;
			this.s =s;
			this.b=b;
		}
	}
	
	static sw arr[];
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	StringTokenizer st ;
	arr = new sw[n];
	for(int i =0; i<n; i++) {
		st = new StringTokenizer(bf.readLine());
		int num = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		arr[i] = new sw(num,s,b);
	}
	ans = 0;
	for(int i =1; i<10; i++) {
		for(int j =1; j<10; j++) {
			if(i==j) continue;
			for(int k =1; k<10; k++) {
				if(i==k || j==k) continue;
				int number = (i*100 + j*10 + k);
				int a1 = number/100;
				int a2 = (number%100)/10;
				int a3 = (number%100)%10;
				
				boolean check = false;
				for(int p =0; p<arr.length; p++) {
					int Strike=0; 
					int Ball=0;
					int num = arr[p].num;
					int a11 = num/100;
					int a22 = (num%100)/10;
					int a33 = (num%100)%10;
					if(a1 == a11)Strike++;
					if(a2 == a22)Strike++;
					if(a3 == a33)Strike++;
					
					if(a1 != a11 && a1 == a22) Ball++;
					if(a1 != a11 && a1 == a33) Ball++;
					
					if(a2 != a22 && a2 == a33) Ball++;
					if(a2 != a22 && a2 == a11) Ball++;
					
					if(a3 != a33 && a3 == a22) Ball++;
					if(a3 != a33 && a3 == a11) Ball++;
					
					
				    if(Strike == arr[p].s && Ball == arr[p].b){
				    	
				    }else check = true;
					
				}
				if(check == false) ans++;
				
			}
		}
	}
	System.out.println(ans);
	
 }
 
}
