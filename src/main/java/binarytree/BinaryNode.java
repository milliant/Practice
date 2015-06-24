/**   
* @Title: BinaryNode.java 
* @Package binarytree 
* @Description: TODO(用一句话描述该文件做什么) 
* @author milliant  xfzhou@anchora.me 
* @date 2015年6月24日 下午9:01:58 
* @version V1.0   
*/
package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/** 
 * @ClassName: BinaryNode 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author milliant  xfzhou@anchora.me 
 * @date 2015年6月24日 下午9:01:58 
 *  
 */
public class BinaryNode {
	private int  data;
	public BinaryNode left = null;
	public BinaryNode right = null ;
	public BinaryNode(int d){
		this.data = d;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
	public static int getNodeNumRec(BinaryNode root) {
		if (root == null ){
			return  0;
		}
		int left = getNodeNumRec(root.left);
		int right = getNodeNumRec(root.right);
		return left + right +1;
	}
	
	public static int getNodeNum(BinaryNode root){
		if (root == null) {
			return 0;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		int count = 1;
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode temp = queue.poll();
			if (temp.left!= null) {
				queue.add(temp.left);
				count++;
			}
			if (temp.right != null) {
				queue.add(temp.right);
				count++;
			}
		}
		return count;
	}

	public static int getDepthRec(BinaryNode root){
	if (root == null) {
		return 0;
	}	
	int left = getDepthRec(root.left);
	int right = getDepthRec(root.right);
	return Math.max(left, right)+1;
//	return left>right? left+1:right+1;
	}
	
	public static int getDepth(BinaryNode root){
		if (root == null) {
			return 0;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		int level = 0 ,clnum = 1,nlnum= 0 ;
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode tempBinaryNode =queue.remove();
			if (tempBinaryNode.left!= null) {
				queue.add(tempBinaryNode.left);
				nlnum++;
			}
			if(tempBinaryNode.right!=null){
				queue.add(tempBinaryNode.right);
				nlnum++;
			}
			
			clnum --;
			if (clnum==0) {
				level ++;
				clnum = nlnum;
				nlnum = 0;
			}
		}
		return level;
	}

	
	/*
	 * 先序遍历的迭代实现
	 * 编码思路与层次遍历十分像
	 * 用队列来实现则是层次遍历
	 * 用栈来实现，则是先序遍历
	 * 
	 * */
	public static void preTravel(BinaryNode root){
		if (root  == null){
			return;
		}
		Stack<BinaryNode> stack = new Stack<BinaryNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			BinaryNode temp = stack.pop();
			System.out.println(" "+temp);
			if (temp.right!=null) {
				stack.push(temp.right);
			}
			if (temp.left !=null) {
				stack.push(temp.left);
			}
		}
		
	}
	
	

}
