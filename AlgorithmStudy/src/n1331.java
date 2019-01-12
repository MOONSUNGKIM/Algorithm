import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class n1331 {// 나이트투어
	static final int dx[] = { -2,-1,1, 2, -2,-1,1,2},dy[] = {-1,-2,-2,-1, 1, 2,2,1};
	static String arr[];
	static boolean finish;
	static int v[][];
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	arr = new String[36];
	v = new int[6][6];
	for(int i =0; i<36; i++) {
		arr[i] =  bf.readLine();
	}
	finish = false;
	for(int i =0; i<36; i++) {
		int a = arr[i].charAt(0)-'A';
		int b = arr[i].charAt(1)-48;
		b -=1;
		int ex = 0;
		int ey = 0;
		if(i==35){
			ex = arr[0].charAt(0)-'A';
			ey = arr[0].charAt(1)-48;
		}else{
			ex = arr[i+1].charAt(0)-'A';
			ey = arr[i+1].charAt(1)-48;
		}
		ey-=1;
		
		boolean check = false;
		for(int j=0; j<8; j++) {
			int x = a+dx[j];
			int y = b+dy[j];
			if(x>=0 && y>=0 && x<6 && y<6) {
				if(x==ex && y==ey){
					if(v[x][y] == 0){
						v[x][y] = 1;
						check = true;
						break;
					}
				}
			}
		}
		
		if(check==false) {
			finish = true;
			break;
		}
		
	}
	
	if(finish){
		System.out.println("Invalid");
	}
	else{
		boolean check = false;
		for(int i =0; i<6; i++){
			for(int j =0; j<6; j++){
				if(v[i][j] == 0){
					check = true;
					break;
				}
			}
			if(check) break;
		}
		if(check == false){
			System.out.println("Valid");
			
		}else {
			System.out.println("Invalid");
		}
	}
	bf.close();
 }
}
