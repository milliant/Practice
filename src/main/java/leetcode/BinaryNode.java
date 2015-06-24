/**   
* @Title: BinaryNode.java 
* @Package leetcode 
* @Description: TODO(用一句话描述该文件做什么) 
* @author milliant  xfzhou@anchora.me 
* @date 2015年5月16日 下午10:24:49 
* @version V1.0   
*/
package leetcode;

import java.util.Stack;

/** 
 * @ClassName: BinaryNode 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author milliant  xfzhou@anchora.me 
 * @date 2015年5月16日 下午10:24:49 
 *  
 */
public class BinaryNode {

	public int value ;
    public BinaryNode left;
    public BinaryNode right;
    public boolean tag;
    
    public BinaryNode(int value) {
		this.value = value;
		this.left = null;
		this.right=null;
		this.tag=false;
	}
	
    public static void pre_iteration(BinaryNode root){
    	if (root==null) {
			return;
		}
    	Stack<BinaryNode> stack = new Stack<BinaryNode>();
    	stack.push(root);
    	BinaryNode pre = root;
    	while(!stack.isEmpty()){
    		while (pre!=null) {
				visit(pre);
				stack.push(pre);
				pre = pre.left;
			}
    		if (stack.isEmpty()) {
				return;
			}
    		pre = stack.pop();
    		pre = pre.right;
    	}
    }
    
    
    public static void mid_iteration(BinaryNode root){
    	if (root == null) {
			return ;
		}
    	Stack<BinaryNode>stack = new Stack<BinaryNode>();
    	BinaryNode pre =  root;
    	while (true) {//!stack.isEmpty()
			while (pre!=null) {
				stack.push(pre);
				pre=pre.left;
			}
			if (stack.isEmpty()) {
				return;
			}
			pre=stack.pop();
			visit(pre);
			pre=pre.right;
		}
    	
    }
    
    public static void after_iteration(BinaryNode root) {
    	if (root == null) {
			return;
		}
		Stack<BinaryNode>stack = new Stack<BinaryNode>();
		BinaryNode pre = root;
		while (true) {
			while(pre!=null&&!pre.tag){
				stack.push(pre);
				pre = pre.left;
			}
			if (stack.isEmpty()) {
				return;
			}
			pre = stack.peek();
			if (pre.right!=null&&!pre.right.tag) {
				pre=pre.right;
			}else {
				pre = stack.pop();
				visit(pre);
			}
		}
	}
    
    
    
	/** 
	* @Title: visit 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param pre    设定文件 
	* @return void    返回类型 
	* @throws 
	*/
	private static void visit(BinaryNode pre) {
		// TODO Auto-generated method stub
		System.out.print(pre.value+" ");
		pre.tag=true;
	}

	/** 
	 * @Title: main 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param args    设定文件 
	 * @return void    返回类型 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = new BinaryNode(1);
		root.left = new BinaryNode(2);
		root.left.left = new BinaryNode(3);
		root.left.right = new BinaryNode(4);
		root.right = new BinaryNode(5);
//		System.out.println("先根遍历");
//		BinaryNode.pre_iteration(root);
//		System.out.println("中根遍历");
//		BinaryNode.mid_iteration(root);
		System.out.println("后根遍历");
		BinaryNode.after_iteration(root);
	}

}
