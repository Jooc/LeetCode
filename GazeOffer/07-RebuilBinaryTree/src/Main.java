import java.util.*;

public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public void printByLayerOrder(){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(this);
            List<Integer> list = new ArrayList<>();

            while(!queue.isEmpty()){
                TreeNode current = queue.poll();
                if(current == null) continue;
                list.add(current.val);
                queue.add(current.left);
                queue.add(current.right);
            }

            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int len = preorder.length;

            Map<Integer, Integer> inoOrderIndex = new HashMap<>();
            for(int i = 0; i < len; i++){
                inoOrderIndex.put(inorder[i], i);
            }

            return build(preorder, 0, len-1, 0, len-1, inoOrderIndex);
        }

        private TreeNode build(int []preorder, int preBegin, int preEnd, int inBegin, int inEnd, Map<Integer, Integer> inorderIndex){
            if(preBegin > preEnd || inBegin > inEnd) return null;

            int val = preorder[preBegin];
            int index = inorderIndex.get(val);

            TreeNode root = new TreeNode(val);
            root.left = build(preorder, preBegin + 1, preBegin+index-inBegin , inBegin, index-1, inorderIndex);
            root.right = build(preorder, preBegin+1+index-inBegin, preEnd , index+1, inEnd, inorderIndex);

            return root;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Main().new Solution();

        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};

        solution.buildTree(preOrder, inOrder).printByLayerOrder();
    }
}
