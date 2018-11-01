import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class sw5644 { //무선충전 
	static int map[][][],M,BCnum,user[][],v[][],sum;
	static class sw {
		int x,y,c;
		sw(int x, int y, int c ){
			this.x=x;
			this.y=y;
			this.c=c;
		}
	}
	static Queue<sw> q;
	//상우하좌 
	static final int dx[] = {0,0,1,0,-1},dy[]={0,-1,0,1,0};
	//1,1 2,1 ,3,1
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	int testcase = Integer.parseInt(bf.readLine());
	StringTokenizer st;
	for(int t=1; t<=testcase; t++) {
		st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken()); // M 시간 이동 
		BCnum = Integer.parseInt(st.nextToken()); // BC 개수 
		map = new int[BCnum][11][11];
		user = new int[2][M+1];
		//user 
		for(int k =0; k<2; k++){
			st = new StringTokenizer(bf.readLine());
		 for(int i =1; i<=M; i++){
			int d = Integer.parseInt(st.nextToken());
			user[k][i] = d; 
		 }
		}
		
		//AP information
		
		for(int i =0; i<BCnum; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			v = new int[11][11];
			map[i][x][y] = p;
			q = new LinkedList<>();
			q.offer(new sw(x,y,0));
			v[x][y] = 1;
			spread(i,c,p);
		}
		
	    move();
		
		System.out.println("#"+t+" "+sum);
	}
	bf.close();
 }
 
 static void spread(int num, int count, int p ) { // Ap , coverage , performance
	 while(!q.isEmpty()){
		 sw s = q.poll();
		 for(int i=1; i<=4; i++){
			 int x = s.x+dx[i];
			 int y = s.y+dy[i];
			 if(x>=1 && y>=1 && x<=10 && y<=10) {
				 if(v[x][y]  == 0){
					 v[x][y] = 1;
					 if((s.c+1) <= count) {
					 map[num][x][y] = p;
					 q.offer(new sw(x,y,s.c+1));
					 }
				 }
			 }
		 }
	 }
 }
 
 static void move() {
	 int time = 0;
	 int x1 = 1,y1 = 1;
	 int x2 = 10,y2 = 10;
	 sum = 0;
	 
	 while(true) {  

		 int A = 0,B=0; 
		 int resultlen =0, result = 0;
		 int aindex = 0;
         int bindex = 0;
         
         int arr[] = new int[BCnum]; // 
         int brr[] = new int[BCnum]; // 
         
         for(int i =0; i<BCnum; i++){
        	 if(map[i][x1][y1] !=0) { //현재 A위치에 BC가 있으면 
        		 arr[aindex] = i;
                 aindex++;
             }
             if(map[i][x2][y2] !=0) { // 현재 B위치에 BC가 있으면 
            	 brr[bindex] = i;
                 bindex++;
             }
         }
		 
         
         
		 if(aindex ==0 && bindex >0) { // B 만있는경우 
			 for(int i =0; i<bindex; i++) {
                 resultlen = Math.max(resultlen, map[brr[i]][x2][y2]);
             }
		 }else if(bindex ==0 && aindex>0) { ///A만있는경우 
			 for(int i =0; i<aindex; i++) {
                 resultlen = Math.max(resultlen, map[arr[i]][x1][y1]);
             }
		 }
		 
		 if(aindex!=0){ //A 가 있는경우 
			  // a 한칸 그다음 B 다가보고 
			 for(int i =0; i<aindex; i++) {
				 A = map[arr[i]][x1][y1];
				 result = 0;
				 for(int j =0; j<bindex; j++) {
					 B = map[brr[j]][x2][y2];
					 if(arr[i] == brr[j]){ //중복
						 result = Math.max(result , (A/2)+(A/2));
					 }else {
	                     result = Math.max(result, (A+B));
	                 }
				 }
				 resultlen = Math.max(resultlen, result);
			 }
		 }
		 
		 else if(bindex !=0){ // B가 있는경우
			// b 한칸 그다음 A 다가보고
			 for(int i =0; i<bindex; i++) {
				 B = map[brr[i]][x2][y2] ;
				 result = 0;
				 for(int j =0; j<aindex; j++){
					 A = map[arr[j]][x1][y1];
					 if(arr[j] == brr[i]) // 중복 
					 {
						 result = Math.max(result , (A/2)+(A/2));
					 }else{
						 result = Math.max(result, (A+B));
					 }
				 }
			 }
		 }

		 sum +=resultlen;
		 time++;
		 if(time > M) return;
		 x1 = x1+ dx[user[0][time]];
		 y1 = y1+ dy[user[0][time]];
		 x2 = x2+ dx[user[1][time]];
		 y2 = y2+ dy[user[1][time]];
		 
	 }
 }
 
}
