import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Trees {
     Node root;
     public Trees(Node root){
        this.root = root;
     }
    static class Node{
        Object val;
        ArrayList<Node> child;
       public Node(int val){
            this.val = val;
            this.child = new ArrayList<>();
        }
    }
public void addnode(Node parent, Node addnode){
        if(parent == null || addnode == null) return;
        if(ispartofTree(root, parent)) {
            parent.child.add(addnode);
            return;
        }
        else{
            parent.child.add(addnode);
            System.out.print("given parent node is not a part of tree");
            return;
        }
    }
public int sizeR(Node root){
       if(root == null) return 0;
       int k = 0;
       for(Node child : root.child){
         k += sizeR(child);
       }
       return k+1;
    }
public int sizeI(Node root){
        if(root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int k = 0;
        while(!q.isEmpty()){
            Node s = q.remove();
            k++;
            if(s.child != null){
                for(Node child : s.child){
                    q.add(child);
                }
            }
        }
        return k;
    }

public void displayrec(Node root){
    
    System.out.print(root.val+"->");
    if(root.child != null){
        for(Node children : root.child){
            System.out.print(children.val+" ");
        }
    }
        System.out.println();
        for(Node children : root.child){
            displayrec(children);
        }  
} 
public void displayST(Node root){
    if(root == null) return;
    Stack<Node> st = new Stack<>();
    st.push(root);
    while(!st.empty()) {
        System.out.print(st.peek().val+"->");
        if(st.peek().child != null){
            Node k = st.pop();
            for(Node children : k.child ){
                System.out.print(children.val+" ");
                st.push(children);
            }
        }
        
        else st.pop();
        System.out.println();
    }  
}
public void displayQ(Node root){
    if(root == null) return;
    Queue<Node> st = new LinkedList<>();
    st.add(root);
    while(!st.isEmpty()) {
        System.out.print(st.peek().val+"->");
        if(st.peek().child != null){
            Node k = st.remove();
            for(Node children : k.child ){
                System.out.print(children.val+" ");
                st.add(children);
            }
        }
        
        else st.remove();
        System.out.println();
    }  
}
public boolean ispartofTree(Node root, Node find){
    if(root == null) return false;
    if(find == root) return true;
    boolean check = false;
    for(Node child : root.child){
      if(ispartofTree(child, find))
      return true;
    }
    return check;
}

// public static void main(String[] args) {
       
//     Node root = new Node(1);
//     Node c1 = new Node(2);
//     Node c2 = new Node(3);
//     Node c3 = new Node(50);
//     root.child.add(c1);
//     root.child.add(c2);
//     root.child.add(c3);
//     Node c1c1 = new Node(4);
//     Node c1c2 = new Node(5);
//     Node c1c3 = new Node(6);
//     c1.child.add(c1c1);
//     c1.child.add(c1c2);
//     c1.child.add(c1c3);
//     Node c2c1 = new Node(7);
//     Node c2c2 = new Node(8);
//     c2.child.add(c2c1);
//     c2.child.add(c2c2);
//     Trees tree = new Trees(root) ;
// // tree.displayrec(node);
//     //  tree.displayST(node);
//     //  System.out.println();
//     //  tree.displayQ(node);
//     // tree.displayrec(node);
//     // System.out.println(tree.ispartofTree(root,c2c2));
//     System.out.print(tree.sizeI(root));
//     System.out.println();
//     System.out.print(tree.sizeR(root));

// }
 
    
}
// public static void IDisplay(Node rt){

//     Stack<Node> st = new Stack<>();
    
//     st.push(rt);
    
//     while(!st.isEmpty()){
    
//     Node t=st.pop();
    
//     String s = t.val+"-> ";
    
//     for(Node nd:t.children)
    
//     s+=nd.val+" ";
    
//     System.out.println(s);
    
//     for(int i=t.children.size()-1;i>=0;i--)
    
//     st.push(t.children.get(i));
    
//     }
    
    
