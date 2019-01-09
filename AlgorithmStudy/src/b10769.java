import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class b10769 { // 행복한지 슬픈지
	//행복한 얼굴을 나타내는 :-) 와 슬픈 얼굴을 나타내는 :-( 가 있다.
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int happy = 0;
	int sad = 0;
	while(st.hasMoreTokens()) {
		String s = st.nextToken();
		for(int i =0; i<s.length()-2; i++) {
			if(s.charAt(i) == ':') {
				if(s.charAt(i+1) == '-'){
					if(s.charAt(i+2) == ')') {
						happy++;
					}else if(s.charAt(i+2) == '(') {
						sad++;
					}
				}
			}
		}
	}
	if(happy > sad) System.out.println("happy");
	else if(happy <sad) System.out.println("sad");
	else if(happy ==0 && sad ==0) System.out.println("none");
	else if(happy == sad) System.out.println("unsure");
	bf.close();
}
}
