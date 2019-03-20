import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
 
public class a17070 { // 파이프옮기기1
    static int N,ans;
    static int[][] map;
    static final int[] dx = {1,0, 1},dy = {0,1, 1}; // 아,오,대 
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 0;
        func(0,1,1);
        System.out.println(ans);
        bf.close();
    }
    
    public static void func(int a,int b, int type) {
        if(a==N-1 && b==N-1) { 
        	ans++;
            return;
        }
        
        int next[] = arr(type); // | , - , \/
        
        for(int i=0;i<next.length;i++) {
            int x = a+dx[next[i]];
            int y = b+dy[next[i]];
            if(x>=0 && y>=0 && x<N && y<N) {
            	if(map[x][y] == 0) {
            		if(next[i]==2 && (map[a][b+1]!=0||map[a+1][b]!=0)) continue; 
                    func(x,y,next[i]);
            	}
            }
        }
        
    }
    
    public static int[] arr(int type) {
        if(type == 0) { //세로
            int[] d = {0,2}; //세로 , 대각선만 가능 
            return d;
        } 
        if(type == 1) { //가로 
            int[] d = {1,2}; // 가로 , 대각선만 가능 
            return d;
        }
        if(type ==2) { //대각선 
            int[] d = {0,1,2}; // 가로 세로 대각선 가능 
            return d;
        }
        return null;
    }
    
}