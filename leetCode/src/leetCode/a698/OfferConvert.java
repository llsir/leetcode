package leetCode.a698;


/**
 *  二叉搜索树与双向链表
 * @author Administrator
 *
 */
public class OfferConvert {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        if(pRootOfTree.left == null && pRootOfTree.right == null){
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        while(p != null&&p.right != null){
            p = p.right;
        }
        if(p!=null){
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        
        TreeNode right = Convert(pRootOfTree.right);
        if(right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left!=null?left:pRootOfTree;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
