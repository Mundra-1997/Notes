import java.util.Stack;

class Main{
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data,Node left,Node right ){
        this.data = data;
        this.left = left;
        this.right = right;
        }
    }
    public static class Pair{
       Node node;
       int state;
       public Pair(Node node,int state){
       this.node = node;
       this.state = state;
       }
    }
    public static Node createTree(Integer arr[]){
        Stack<Pair> st = new Stack<>();
        Node root = new Node(arr[0],null,null);
        Pair rp = new Pair(root,1);
        st.push(rp);
        int idx = 0;
        while(st.size()>0){
            Pair top = st.peek();
            if(top.state == 1){
               idx++;
               if(arr[idx] != null){
                top.node.left = new Node(arr[idx],null,null);
                Pair lp = new Pair(top.node.left, 1);
                st.push(lp);
               }
               else{
                top.node.left = null;
               }
               top.state++;
            }
            else if(top.state == 2){
                idx++;
                if(arr[idx] != null){
                 top.node.right = new Node(arr[idx],null,null);
                 Pair r = new Pair(top.node.right, 1);
                 st.push(r);
                }
                else{
                 top.node.right = null;
                }
                top.state++;
            }
            else{
                st.pop();
            }
        }
   return root;
    }
    public static int size(Node root){
        if(root == null) return 0;

        int left = size(root.left);
        int right = size(root.right);

        return left+right+1;
    }
    public static int sum(Node root){
        if(root == null) return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        return left+right+root.data;
    }
    public static int Max(Node root){
        if(root == null) return 0;
        int left = Max(root.left);
        int right = Max(root.right);
        return Math.max(root.data,Math.max(left,right));
    }
public static void Display(Node root){
    if(root == null) return;
    System.out.print(root.data+"->");
    if(root.left != null){
            System.out.print(root.left.data+" ");
    }
    if(root.right != null){
        System.out.print(root.right.data+" ");
}
        System.out.println();
        Display(root.left);
        Display(root.right);    
}
public static void Printpreorder(Node root){
    if(root == null) return ;
    System.out.print(root.data+"=>");
    if(root.left != null) System.out.print(root.left.data+" ");
    if(root.right != null) System.out.print(root.right.data+" ");
    System.out.println();
    Printpreorder(root.left);
    Printpreorder(root.right);
}
public static void Inorderiterative(Node root){
    Stack<Node> st = new Stack<>();
    Node node = root;
    while(true){
        if(node != null){
            st.push(node);
            node = node.left;
        }
        else{
            if(st.isEmpty()) break;
            node = st.pop();
            System.out.print(node.data+" ");
            node = node.right;
        }
    }
}
public static void Postorderiterative(Node root){
    Stack<Node> ini = new Stack<>();
    Stack<Node> fin = new Stack<>();
    ini.add(root);
    while(!ini.isEmpty()){
        Node curr = ini.pop();
        fin.push(curr);
        if(curr.left != null){
            ini.push(curr.left);
        }
        if(curr.right != null){
            ini.push(curr.right);
        }
    }
    while(!fin.isEmpty()){

        System.out.print(fin.pop().data+" ");
    }
}
public static void Preorderiterative(Node root){
    Stack<Node> st = new Stack<>();
    st.push(root);
    while(!st.isEmpty()){
        Node node = st.pop();
        System.out.print(node.data+" ");
        if(node.right != null){
            st.push(node.right);
        }
        if(node.left != null){
            st.push(node.left);
        }
    }
}
public static void Printpostorder(Node root){
    if(root == null) return ;
    Printpreorder(root.left);
    Printpreorder(root.right);
    System.out.print(root.data+"=>");
    if(root.left != null) System.out.print(root.left.data+" ");
    if(root.right != null) System.out.print(root.right.data+" ");
    System.out.println();
    
}
public static void Printinorder(Node root){
    if(root == null) return ;
    Printpreorder(root.left);
    System.out.print(root.data+"=>");
    if(root.left != null) System.out.print(root.left.data+" ");
    if(root.right != null) System.out.print(root.right.data+" ");
    System.out.println();
    Printpreorder(root.right);
}
public static void Printinallorder(Node root){
    Stack<Pair> st = new Stack<>();
    Pair rp = new Pair(root, 1);
    st.push(rp);
    String pre = "";
    String in = "";
    String post = "";
    while(!st.isEmpty()){
        Pair top = st.peek();
        if(top.state == 1){
        pre += top.node.data + " ";
         top.state++;
         if(top.node.left != null){
            Pair l = new Pair(top.node.left, 1);
            st.push(l);
         }
        }
        else if(top.state == 2){
         in += top.node.data + " ";
         top.state++;
         if(top.node.right != null){
            Pair r = new Pair(top.node.right, 1);
            st.push(r);
         }
        }
        else{
          post += top.node.data + " ";
          st.pop();
        }
    }
     System.out.println("preorder"+ "   " + pre);
     System.out.println("inorder     "+ in);
     System.out.println("postorder   "+post);

}
public static boolean isnodepresent(Node root, int tofind){
    if(root == null) return false;
    if(root.data == tofind) return true;
    boolean left = isnodepresent(root.left, tofind);
    boolean right = isnodepresent(root.right, tofind);
    return left || right;
}
    public static void main(String[] args) {
        Integer arr[] = {1,2,4,5,3,null,null,null,7,6,null,null,null,null,null};
       Node root = createTree(arr);
      Display(root);
    //    System.out.println("-----------");
    //    System.out.println(size(root));
    //    System.out.println("-----------");
    //    System.out.print(sum(root));
    //    System.out.println("-----------");
    //    System.out.print(Max(root));
    // System.out.println("====================");
    // // Printpreorder(root);
    // System.out.println("====================");
    // // Printpostorder(root);
    // System.out.println("====================");
    // Printinorder(root);
    // System.out.println("====================");
    // System.out.println("====================");
    Printinallorder(root);
    System.out.println("====================");
    System.out.println("====================");
    System.out.println("====================");
    System.out.println(isnodepresent(root,99));
    System.out.println("====================");
    System.out.println("====================");
    System.out.println("====================");
     Inorderiterative(root);
    System.out.println("====================");
    System.out.println("====================");
    System.out.println("====================");
    Postorderiterative(root);
    System.out.println("====================");
    System.out.println("====================");
    System.out.println("====================");
    Preorderiterative(root);
    }

}