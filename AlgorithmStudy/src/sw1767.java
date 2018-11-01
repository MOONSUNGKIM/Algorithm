import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class sw1767 {
    static int n,p,map[][],arr[][],ans;
    static final int dx[]={0,0,1,-1},dy[]={1,-1,0,0};
    
 public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int test = Integer.parseInt(bf.readLine());
    for(int t=1; t<=test;t++) {
        ans = 1000000;
        
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        arr = new int[12][2];
        p =0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++) {     
            for(int j=0; j<n; j++) {
                if(map[i][j] == 1) { // core
                    boolean check = false;
                    int c = 0;
                    for(int k=0; k<4; k++) {
                        int x= i+dx[k];
                        int y= j+dy[k];                     
                        if(x<0 || y<0 || x>=n || y>=n) {                        
                            check = true;
                            break;
                        }
                        else{
                         for(int h=1; h<n; h++){
                            x = i+dx[k]*h;
                            y = j+dy[k]*h;
                            if(x>=0 && y>=0 && x<n && y<n){
                                if(map[x][y] == 1){
                                    c++;
                                    break;
                                }
                            }
                         }
                        }   
                    }                   
                    if(c!=4 && check == false){                         
                     arr[p][0] = i;
                     arr[p][1] = j;
                     p++;
                    }
                }
            }
        }       
        func(0,0);
        System.out.println("#"+t+" "+ans);
    }
    bf.close();
}
 static void func(int a , int s) {   
     if(a >=p){
      
        if(ans >s ){
            ans =s;
        }       
      
      return;
     }
     int xx = arr[a][0];
     int yy = arr[a][1];
      
     for(int i=0; i<4; i++) {
         int cnt = 0;
        for(int k=1; k<n; k++) {
            int x = xx+dx[i]*k;
            int y=  yy+dy[i]*k;
            if(x>=0 && y>=0 && x<n && y<n){
             if(map[x][y]==1 || map[x][y] == -1) { 
                 for(int k2=1;k2<n; k2++) {
                        int x2 = xx+dx[i]*k2;
                        int y2=  yy+dy[i]*k2;
                        if(x2 == x && y2 == y) break;
                        map[x2][y2] = 0; 
                 }
                break;
             }
             else if(map[x][y]==0) {
                 map[x][y] = -1;
                 cnt++;
             }
            }
            else if(x<0 || y<0 || x>=n || y>=n) {
                func(a+1,(s+cnt));              
                for(int k2=1;k2<n; k2++) {
                    int x2 = xx+dx[i]*k2;
                    int y2=  yy+dy[i]*k2;
                    if(x2 == x && y2 == y) break;
                    map[x2][y2] = 0;
                }
                break;
            }            
                                 
        }
     }   
 } 
}