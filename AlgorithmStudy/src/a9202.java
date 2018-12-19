import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class a9202 {// Boggle
	static int n ,m,v[][],maxscore,find;
	static HashSet<String> hs ,res;
	static char map[][];
	static String maxstr;
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	
    n = Integer.parseInt(bf.readLine());
    hs = new HashSet<>();
    for(int i =0; i<n; i++) {
    	String str = bf.readLine();
    	hs.add(str);
    }
    bf.readLine();
    m = Integer.parseInt(bf.readLine());
    for(int a =0; a<m; a++) {
    	map = new char[4][4];
    	res = new HashSet<String>();
    	for(int i =0; i<4; i++) {
    		String str = bf.readLine();
    		for(int j =0; j<4; j++) {
    			map[i][j] = str.charAt(j);
    		}
    	}
    	if(a!=m) bf.readLine();	
    	maxscore = 0; 
    	maxstr = "";
    	find = 0;
    	v = new int[4][4];
    	for(int a1 =0; a1<4; a1++) {
    		for(int b1 = 0; b1<4; b1++) {
    			v[a1][b1] = 1;
    			String s = map[a1][b1]+"";
    			if(hs.contains(s)){
    				if(!res.contains(s)) {
    					find++;
    					res.add(s);
    				}
    			}
    			
    			func(a1,b1,1,s);
    			v[a1][b1] = 0;
    		}
    	}
    
    	System.out.println(maxscore+" "+maxstr+" "+find);
        
    }
    
    bf.close();
}
 
 static final int dx[] = {0,0,1,-1,1,1,-1,-1} , dy[] = {1,-1,0,0,1,-1,1,-1};
 //1글자, 2글자로 이루어진 단어는 0점, 3글자, 4글자는 1점, 5글자는 2점, 6글자는 3점, 7글자는 5점, 8글자는 11점이다.
 static void func(int a, int b, int c, String s) {
	 
	 if(c >8) {
		 return;
	 }
	 for(int i =0; i<8; i++){
		 int x = a+dx[i];
		 int y = b+dy[i];
		 if(x>=0 && y>=0 && x<4 && y<4){
			 if(v[x][y] == 0){
				 v[x][y] = 1;
				 String str = s+map[x][y]+"";
				 if(hs.contains(str)) {
					if(!res.contains(str)) {
						find++;
						res.add(str);
						//score
						if(str.length()==3 || str.length() == 4){
							maxscore +=1;
						}else if(str.length() == 5){
							maxscore +=2;
						}else if(str.length() == 6){
							maxscore +=3;
						}else if(str.length() == 7){
							maxscore +=5;
						}else if(str.length() == 8){
							maxscore +=11;
						}
						
						//maxstr
						if(maxstr.length() < str.length()) {
							maxstr = str;
						}else if(maxstr.length() == str.length()) {
							for(int i2 =0; i2<maxstr.length(); i2++) {
							  if(str.charAt(i2) > maxstr.charAt(i2)){
								  break;
							  }else if(str.charAt(i2) < maxstr.charAt(i2)){
								  maxstr = str;
								  break;
							  }
							}
						}
						
						
					}
				 }
				 func(x,y,(c+1), (str));
				 v[x][y] = 0;
				 
			 }
		 }
	 }
 }
 
}
