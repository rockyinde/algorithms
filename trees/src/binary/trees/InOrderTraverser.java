package binary.trees;

import java.util.Stack;

public class InOrderTraverser {

	static Stack<Node> stack = new Stack<>();
	
	public static void traverse(Node root) {
		
		Node prev = null;
		
		if (root.right != null)
			stack.push(root.right);
		
		stack.push(root);
		
		if (root.left != null)
			stack.push(root.left);

		// start the traversal
		while (!stack.isEmpty()) {
			
			Node top = stack.pop();
			
			if (prev == top.left || top.left == null) {
				
				System.out.println(top.data);
				prev = top;
			}
			if (prev == null) {
				
				if (top.left == null) {
					
				}
			}
			
			else {
				
				prev = null;
				if (top.right != null)
					stack.push(top.right);
				stack.push(top);
				if (top.left != null)
					stack.push(top.left);
			}
		}
	}
	
	public static void main (String[] args) {
		
		Node one = new Node(1);
		Node two = new Node (2);
		Node three = new Node (3);
		Node four = new Node (4);
		Node five = new Node (5);
		Node six = new Node (6);
		Node seven = new Node (7);
		
		one.left = two;
		one.right = three;
		
		two.left = four;
		two.right = five;
		
		three.left = six;
		three.right = seven;
		
		traverse(one);
	}
}
