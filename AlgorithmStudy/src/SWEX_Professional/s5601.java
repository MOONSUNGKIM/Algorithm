package SWEX_Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s5601 { //쥬스나누기
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	int testcase = Integer.parseInt(bf.readLine());
	StringBuilder sb;
	for(int t=1; t<=testcase ; t++) {
	 //
	 int n = Integer.parseInt(bf.readLine());
	 sb = new StringBuilder();
	 for(int i =0; i<n; i++) {
		sb.append(1+"/"+n+" ");
	 }
     System.out.println("#"+t+" "+sb.toString());
	}
	
 }
 
}
