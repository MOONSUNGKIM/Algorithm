import java.util.Scanner;

class sw1768 {
    private final static int N              = 4;  
    private final static int MAX_QUERYCOUNT = 1000000;

    private static int digits[] = new int[N]; 
    private static int digits_c[] = new int[10];

    private static int T;                          

	private static int querycount;
	
    // the value of limit_query will be changed in evaluation
	private final static int limit_query = 2520;

    static class Result {
        public int strike;                                
        public int ball;
	}
	
	private static boolean isValid(int guess[]) {
		int guess_c[] = new int[10];
		
		for (int count = 0; count < 10; ++count) guess_c[count] = 0;
		for (int idx = 0; idx < N; ++idx) {
			if (guess[idx] < 0 || guess[idx] >= 10 || guess_c[guess[idx]] > 0) return false;
			guess_c[guess[idx]]++;
		}
		return true;
	}
	
	// API : return a result for comparison with digits[] and guess[]
    public static Result query(int guess[]) {
		Result result = new Result();
		
		if (querycount >= MAX_QUERYCOUNT) {
			result.strike = -1;
			result.ball = -1;
			return result;
		}
		
		querycount++;
		
		if (!isValid(guess)) {
			result.strike = -1;
			result.ball = -1;
			return result;
		}
		
		result.strike = 0;
		result.ball = 0;

		for (int idx = 0; idx < N; ++idx)
			if (guess[idx] == digits[idx])
				result.strike++;
			else if (digits_c[guess[idx]] > 0)
				result.ball++;
		
		return result;
	}

	private static void initialize(Scanner sc) {
		for (int count = 0; count < 10; ++count) digits_c[count] = 0;
		
		String input;
		do input = sc.next(); while(input.charAt(0) < '0' || input.charAt(0) > '9');

		for (int idx = 0; idx < N; ++idx) {
			digits[idx] = input.charAt(idx) - '0';
			digits_c[digits[idx]]++;
		}
		
		querycount = 0;
	}

	private static boolean check(int guess[]) {
		for (int idx = 0; idx < N; ++idx)
			if (guess[idx] != digits[idx]) return false;
		return true;
	}
	
	public static void main(String[] args) throws Exception
	{
		
		int total_score = 0;
		int total_querycount = 0;
		
		//System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		UserSolution usersolution = new UserSolution();
		for (int testcase = 1; testcase <= T; ++testcase) {
			initialize(sc);

			int guess[] = new int[N];
            usersolution.doUserImplementation(guess);

			if (!check(guess)) querycount = MAX_QUERYCOUNT;
			if (querycount <= limit_query) total_score++;
			System.out.printf("#%d %d\n", testcase, querycount);
			total_querycount += querycount;
		}
		
		if (total_querycount > MAX_QUERYCOUNT) total_querycount = MAX_QUERYCOUNT;
		System.out.printf("total score = %d\ntotal query = %d\n", total_score * 100 / T, total_querycount);
		sc.close();
	}
}

class UserSolution {
	public final static int N = 4, SIZE = 5040;
	static int arr[][], check[] , resultnumber[];
    public void doUserImplementation(int guess[]) {
		arr = new int[SIZE][N];
		check = new int[SIZE];
		resultnumber = new int[N];
		
		randomnumber();
		
		func();
		
		//
		for(int i =0; i<N; i++) {
			guess[i] = resultnumber[i];
        }
		
		
	}
    
    static void randomnumber() {
    	int idx =0 ;
    	for(int i =0; i<10; i++) {
    		for(int j =0; j<10; j++) {
    			if(i==j) continue;
    			for(int k=0; k<10; k++) {
    				if(i==k || j==k) continue;
    				for(int h=0; h<10; h++) {
    					if(i==h || j==h || k==h) continue;
    					arr[idx][0] = i;
    					arr[idx][1] = j;
    					arr[idx][2] = k;
    					arr[idx][3] = h;
    					idx++;
    				}
    			}
    		}
    	}
    	
    }
    
    static void func() {
    	while(true) {
    		int guess[] = new int[4];
    		int idx = guessindex(); // 0~ 5040 중에 몇번째뽑을지  
    		
    		for(int i =0; i<4; i++) {
    			guess[i] = arr[idx][i];
    		}
    		
    		sw1768.Result r = sw1768.query(guess); //guess 한 번호와 정답과 비교 
    		
    		//이거만으로도 가능 
//    		if(r.strike == 4) {
//    			for(int c= 0; c<4; c++) {
//						 resultnumber[c] = guess[c];
//				}
//    			return;
//    		}
    		
    		// 최적화 
    		if(r.strike + r.ball == 4) { //
    			combination(guess);
    			return;
    		}
    		
    		
    		
    		// 거르는 작업 
    		int compare[] = new int[10]; // 0 ~ 9
    		for(int a=0 ;a<N; a++) {
  	    	  compare[guess[a]] +=1;
  	    	}
    		
    	    for(int i =0; i<SIZE; i++) { // 5040개 중 
    	    	if(check[i] == -1) continue;  
    	    	
    	    	int compareStrike = 0;
    	    	int compareBall = 0;

    	    	for(int a=0; a<N; a++) {
    	    	  if(arr[i][a] == guess[a]) {
    	    		  compareStrike ++;
    	    	  }
    	    	  else if(compare[arr[i][a]] > 0) {
    	    		  compareBall++;
    	    	  }
    	    	}
    	    	
    	    	if(compareStrike!=r.strike || compareBall != r.ball) {
    	    		check[i] = -1;
    	    	}
    	    	
    	    }
    		
    	}
    }
    
    static int guessindex() {
    	for(int i =0; i<SIZE; i++) {
    		if(check[i]!=-1) return i;
    	}
    	return SIZE;
    }
    
    static void combination(int guess[]) { //나온값들을 조합하여  4strike 가능한지! 
        int number[]= new int[4];
        for(int i =0; i<4; i++){
      	 number[0] = guess[i];
      	 for(int j =0; j<4; j++) {
      		 if(i==j) continue;
      		 number[1] = guess[j];
      		 for(int k=0; k<4; k++){
      			 if(i==k || j==k) continue;
      			 number[2] = guess[k];
      			 for(int l=0; l<4; l++){
      				 if(i==l || j==l || k==l) continue;
      				 number[3] = guess[l];
      				 sw1768.Result r = sw1768.query(number);
      				 if(r.strike == 4){
      					 for(int c= 0; c<4; c++){
      						 resultnumber[c] = number[c];
      					 }
      					 return; // 끝  
      				 }
      			 }
      		 }
      	 }
        }
     }
    
}

