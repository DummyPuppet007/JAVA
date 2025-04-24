import java.util.*;
public class BTee {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int index = -1;
        public static Node buildTree(int[] nodes){
            index++;
            if(nodes[index] == -1){
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        //preorder traversal : O(n)
        // root -> left -> right
        public static void preOrder(Node root){
            if(root == null){
                return;
            }
            
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        //inorder traversal : O(n)
        // left -> root -> right
        public static void inOrder(Node root){
            if(root == null){
                return;
            }
            
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        //postorder traversal : O(n)
        // left -> right -> root
        public static void postOrder(Node root){
            if(root == null){
                return;
            }
            
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        //level order traversal : O(n)
        public static void levelOrder(Node root){
            if(root == null){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }

        //count of nodes : O(n)
        public static int countOfNodes(Node root){
            if(root == null){
                return 0;
            }

            int leftCount = countOfNodes(root.left);
            int rightCount = countOfNodes(root.right);
            return leftCount + rightCount + 1;
        }

        //sum of nodes : O(n)
        public static int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }

            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);
            return leftSum + rightSum + root.data;
        }

        //height of tree : O(n)
        public static int heightOfTree(Node root){
            if(root == null){
                return 0;
            }

            int leftHeight = heightOfTree(root.left);
            int rightHeight = heightOfTree(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }

        //diameter of tree : O(n^2)
        public static int diameterOfTree(Node root){
            if(root == null){
                return 0;
            }

            int diam1 = diameterOfTree(root.left);
            int diam2 = diameterOfTree(root.right);
            int diam3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;

            return Math.max(diam1, Math.max(diam2, diam3));
        }

    }

    //find tree diameter optimized : O(n)
    static class TreeInfo{
        int ht;
        int diam;

        TreeInfo(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameter2(Node root){
        if(root == null){
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int height = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int diameter = Math.max(diam1, Math.max(diam2, diam3));

        return new TreeInfo(height, diameter);
    }

    //sum of nodes at kth level
    public static int sumOfNodesAtK(Node root, int k){
        if(root == null){
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 1;
        int sum = 0;

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                level++;
                if(q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(level == k){
                    sum += currNode.data;
                }
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int nodes [] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        //System.out.println(root.data);

        System.out.print("Preorder Traversal : ");
        tree.preOrder(root);
        System.out.println();

        System.out.print("Inorder Traversal : ");
        tree.inOrder(root);
        System.out.println();

        System.out.print("Postorder Traversal : ");
        tree.postOrder(root);
        System.out.println();

        System.out.println("Level Order Traversal : ");
        tree.levelOrder(root);
        System.out.println();

        int count = tree.countOfNodes(root);
        System.out.println("Count of nodes : " + count);

        int sum = tree.sumOfNodes(root);
        System.out.println("Sum of nodes : " + sum);

        int height = tree.heightOfTree(root);
        System.out.println("Height of tree : " + height);

        int diameter = tree.diameterOfTree(root);
        System.out.println("Diameter of tree : " + diameter);

        TreeInfo treeInfo = diameter2(root);
        System.out.println("Diameter of tree : " + treeInfo.diam);

        System.out.println("Sum of nodes at kth level : " + sumOfNodesAtK(root, 3));
    }
}
