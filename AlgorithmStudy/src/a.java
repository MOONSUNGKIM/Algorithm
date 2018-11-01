

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class a {
   static int n, m, arr[][], virus[][], virusnum, max, w;
   static boolean visit[][];

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      n = scan.nextInt();
      m = scan.nextInt();
      arr = new int[n][m];
      virus = new int[10][2];
      virusnum = 0;
      max = 0;
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            arr[i][j] = scan.nextInt();
            if (arr[i][j] == 2) {
               virus[virusnum][0] = i;// 바이러스의 x좌표
               virus[virusnum][1] = j;// y좌표
               virusnum += 1;
            }
            if (arr[i][j] == 1) {
               w+=1;
            }
         }
      } // 입력 완료

      wall(0, 0, 0);
      System.out.println(max);
   }

   static void wall(int idx, int jdx, int cnt) { // ->>>>  벽 3곳을 찾는거 
      if (cnt == 3) {
         spread(); 
         return;
      }
      if (idx > n - 1 || jdx > m - 1) {
         return;
      }

      if (arr[idx][jdx] == 0) {// 빈칸이면
         if (jdx+1>m-1) {
            arr[idx][jdx] = 1;
            wall(idx + 1, 0, cnt + 1);
            arr[idx][jdx] = 0;
         } else {
            arr[idx][jdx] = 1;
            wall(idx, jdx + 1, cnt + 1);
            arr[idx][jdx] = 0;
         }
      }
      
      //////
      
//         빈칸이 아니면 아무 처리도 안해주면될것같아요 ㅎㅎ
      
      ///////
//      else {// 빈칸이 아니면  
//         if (jdx + 1 > m - 1) {
//            wall(idx + 1, 0, cnt);
//         } else {
//            wall(idx, jdx + 1, cnt);
//         }
//      }

      //백트래킹 후 들어가기
      if (jdx+1>m-1) {
         wall(idx + 1, 0, cnt);
      } else {
         wall(idx, jdx + 1, cnt);
      }
   }

   static int dx[] = { 0, 0, 1, -1 }, dy[] = { 1, -1, 0, 0 };// 우, 좌, 하, 상

   static void spread() {
      visit = new boolean[n][m];
      int cnt = 0;
      Queue<n14502> q = new LinkedList<>();
      for (int i = 0; i < virusnum; i++) {
         q.add(new n14502(virus[i][0], virus[i][1]));
         visit[virus[i][0]][virus[i][1]] = true;
         cnt += 1;
      }

      while (!q.isEmpty()) {
         n14502 no = q.poll();
         for (int i = 0; i < 4; i++) {
            int x = no.a + dx[i];
            int y = no.b + dy[i];
            if (x < 0 || y < 0 || x > n - 1 || y > m - 1 || arr[x][y] == 1) {
               continue;
            }
            if (!visit[x][y]) {
               visit[x][y] = true;
               cnt += 1;
               q.add(new n14502(x, y));
            }
         }
      }
      int result = (n * m) - (cnt + w +3); // 바이러스
      max = Math.max(max, result);
   }
}

class n14502 {
   int a, b;

   n14502(int a, int b) {
      this.a = a;
      this.b = b;
   }
}