import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw3459 { //승자예측하기  
	static long n ;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	int testcase = Integer.parseInt(bf.readLine());
	for(int t=1; t<=testcase ; t++){
		n = Long.parseLong(bf.readLine());
		long sub = 1;
		int check = 1;
		while(sub < n){
			n -= sub;
			if(check == 1) sub*=4;
			if(check ==0 ) check = 1;
			else check = 0;
		}
		if(check==1) System.out.println("#"+t+" "+"Bob");
		else System.out.println("#"+t+" "+"Alice");
	}
	
	bf.close();
 }
}
