import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a16503 {  //괄호없는 사칙연산
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	String str = bf.readLine();
	String arr[] = str.split(" ");
    int num[] = new int[3];
    char d[] = new char[2];
    int s = 0;
    int nidx = 0;
    int didx = 0;
    for(int i =0; i<5; i++) {
    	if(s ==0) {
    		num[nidx++] =Integer.parseInt(arr[i]);
    		s =1;
    	}else{
    		d[didx++] = arr[i].charAt(0);
    		s=0;
    	}
    }
    
    int min = 2100000000;
    int max = -2100000000;
    
    int number = num[0];
	for(int i =0; i<2; i++) { // ->
	 if(d[i]=='+'){
	   number += num[i+1];	 
	 }else if(d[i] =='-'){
		 number -= num[i+1];	  
	 }else if(d[i] == '*'){
		 number *= num[i+1];	 
	 }else if(d[i] == '/'){
		 if(num[i+1] <0){ // -
			 int k = num[i+1]*-1;
			 number /= k;
			 number *=-1;
		 }else { 
			 number /=num[i+1];
		 }
	 }
	}
	
	min = Math.min(number, min);
	max = Math.max(number, max);

	
	number = num[1];
	int t = 1;
	for(int i =2; i>=0; i-=2) {
		if(i==0){
			t = 0;
			int temp = num[i];
			num[i] = number;
		    number = temp;
		}
		
	     if(d[t]=='+') {
		   number += num[i];	 
		 }else if(d[t] =='-') {
			 number -= num[i];	  
		 }else if(d[t] == '*') {
			 number *= num[i];	 
		 }else if(d[t] == '/') {
			 if(number <0) { // -
				 int k = num[i]*-1;
				 number /= k;
				 number *=-1;
			 }else { 
				 number /=num[i];
			 }
		 }
	} 
	
	min = Math.min(number, min);
	max = Math.max(number, max);
	
	System.out.println(min);
	System.out.println(max);
	bf.close();
 }
 
 
}
