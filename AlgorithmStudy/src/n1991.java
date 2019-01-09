import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1991 { // 트리 순회 
	static class Node {
		char data;
		Node left,right;
		public Node(char data) {
			this.data= data;
		}
	}

	static Node tree;
	static void add(char data, char leftdata , char rightdata) {
		if( tree == null) {
			if(data!='.') tree = new Node(data);
			if(leftdata != '.') tree.left = new Node(leftdata);
			if(rightdata != '.') tree.right = new Node(rightdata);
		} else {
			search(tree, data, leftdata, rightdata);
		}
	}
	
	static void search(Node root ,char data, char leftdata, char rightdata) {
		if(root == null) return;
		else if(root.data == data) {
			if(leftdata !='.') root.left = new Node(leftdata);
			if(rightdata != '.') root.right = new Node(rightdata);
		}else {
			search(root.left,data,leftdata,rightdata );
			search(root.right,data,leftdata,rightdata );
		}
	}
	
	static void preorder(Node root) {
		System.out.print(root.data);
		if(root.left!= null) preorder(root.left);
		if(root.right!= null) preorder(root.right);
	}

	static void inorder(Node root) {
		if(root.left != null) inorder(root.left);
        System.out.print(root.data);
        if(root.right!= null) inorder(root.right);
	}

	static void postorder(Node root) {
        if(root.left!=null) postorder(root.left);
        if(root.right!=null) postorder(root.right);
        System.out.print(root.data);
	}

 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(bf.readLine());
	StringTokenizer st ;
	for(int i =0; i<n; i++) {
		st = new StringTokenizer(bf.readLine());
		char root = st.nextToken().charAt(0);
		char left = st.nextToken().charAt(0);
		char right = st.nextToken().charAt(0);
		add(root,left,right);
	}

	preorder(tree);
	System.out.println();
	inorder(tree);
	System.out.println();
	postorder(tree);
	
	bf.close();	
}
 
}
