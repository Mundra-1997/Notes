
import java.util.*;


  
public class BinaryTree1 {
    static class Node
{
    int data;
    Node left, right;
  
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
    public static Node BuildTree(int inorder[], int start, int end, Node node){
        if (start > end)
        return null;

    /* Find index of the maximum element from Binary Tree */
    int i = max(inorder, start, end);

    /* Pick the maximum value and make it root */
    node = new Node(inorder[i]);

    /* If this is the only element in inorder[start..end],
     then return it */
    if (start == end)
        return node;

    /* Using index in Inorder traversal, construct left and
     right subtress */
    node.left = BuildTree(inorder, start, i - 1, node.left);
    node.right = BuildTree(inorder, i + 1, end, node.right);

    return node;
    }
    public static int max(int arr[], int strt, int end){
        int max = arr[strt], maxind = strt;
        for (int i = strt + 1; i <= end; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                maxind = i;
            }
        }
        return maxind;
    }
public static ArrayList<Integer> merge(ArrayList<Integer> l1, ArrayList<Integer> l2){
    ArrayList<Integer> res = new ArrayList<>();
    int i = 0;
    int j = 0;
    // int k = 0;
    while(i<l1.size() && j<l2.size()){
        if(l1.get(i)<=l2.get(j)){
            res.add(l1.get(i));
            i++;
        }
        else{
            res.add(l2.get(j));
            j++;
        }
    while(i<l1.size()){
        res.add(l1.get(i));
        i++;
    }
    while(j<l2.size()){
        res.add(l2.get(j));
        j++;
    }
        
}
    return res;
}
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        ArrayList<Integer> res =  merge(l1,l2);
    }
}
