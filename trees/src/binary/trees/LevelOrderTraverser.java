package binary.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author rockyinde
 * 
 * Memory: O(n)
 * Time: O(n)
 *
 */
public class LevelOrderTraverser extends BaseTraverser {

	static Queue<Node> queue;

	static void traverse (Node root) {
		
		queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			
			Node next = queue.remove();
			
			System.out.println(next.data);
			
			if (next.left != null)
				queue.add(next.left);
			
			if (next.right != null)
				queue.add(next.right);
		}
	}
	
	public static void main (String[] args) {
		traverse(getTree());
	}
}
