package binary.trees;

import java.util.Random;

/**
 * Created by iamtrk on 25/04/17.
 */
public class BinaryTre {
    BNode Broot;

    public BinaryTre(int root) {
        this.Broot = new BNode(root);
    }
    // Iteration based node insertion in the tree - to build really large trees.
    public boolean add(int node) {
        if(Broot == null) {
            this.Broot = new BNode(node);
            return true;
        } else {
            BNode travel = Broot;

            while (true) {
                if(travel.data < node) {
                    if(travel.right == null) {
                        travel.right = new BNode(node);
                        break;
                    } else {
                        travel = travel.right;
                    }
                } else if(travel.data > node){
                    if(travel.left == null) {
                        travel.left = new BNode(node);
                        break;
                    } else {
                        travel = travel.left;
                    }
                } else if(travel.data == node) {
                    break;
                }
            }
        }

        return true;
    }
    // Recursion based inorder traversal.
    private void inorder(BNode node) {
        if(node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }

    public void inorder() {
        inorder(Broot);
    }

    public static void main(String[] args) {
        Random random = new Random();
        int N = random.nextInt(20);

        BinaryTre b = new BinaryTre(random.nextInt(50));

        for (int i=0; i<N; i++) {
            b.add(random.nextInt(100));
        }

        b.inorder();

    }

    // Returns a Binary Tree.
    public BinaryTre getBinaryTree(int size, int max) {
        Random random = new Random();

        BinaryTre b = new BinaryTre(random.nextInt(max));

        for (int i=0; i<size; i++) {
            b.add(random.nextInt(max));
        }
        return b;
    }


}

class BNode {
    BNode left, right;
    int data;

    public BNode(int data) {
        this.data = data;
    }
}


