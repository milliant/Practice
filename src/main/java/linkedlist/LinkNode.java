/**   
* @Title: LinkNode.java 
* @Package linkedlist 
* @Description: TODO(用一句话描述该文件做什么) 
* @author milliant  xfzhou@anchora.me 
* @date 2015年6月24日 下午7:36:02 
* @version V1.0   
*/
package linkedlist;

import java.util.Random;

import org.eclipse.swt.widgets.Link;

/** 
 * @ClassName: LinkNode 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author milliant  xfzhou@anchora.me 
 * @date 2015年6月24日 下午7:36:02 
 *  
 */
public class LinkNode {
	private int data;
	public LinkNode next;
	public  LinkNode() {
		data = 0;
	}
	public LinkNode(int d){
		this.data = d;
	}
	public static LinkNode getLinkList(int length) {
		LinkNode head = new LinkNode();
		LinkNode p = head;
		for (int i = 0; i < length-1; i++) {
			p.next = new LinkNode(i+1);
			p = p.next;
		}
		return head;
	}
	public static LinkNode getLinkList(int[] arr){
		LinkNode head = new LinkNode(arr[0]);
		LinkNode p = head;
		for (int i = 0; i < arr.length-1; i++) {
			p.next = new LinkNode(arr[i+1]);
			p = p.next;
		}
		return head;
	}
	
	public static void display(LinkNode start,String msg){
		System.out.println(msg);
		LinkNode p =start;
		while (p!=null) {
			System.out.print(p.data+" ");
			p = p.next;
		}
		System.out.println();
	}
	public static LinkNode merge(LinkNode A,LinkNode B){
		if (A ==null ) {
			return B;
		}else if (B == null) {
			return A;
		}
		LinkNode h = null,r=null,p,q;
		p = A;q = B;
		while(p!=null && q!=null){
			LinkNode temp;
			if (p.data<q.data) {
				temp = p;
				p=p.next;
			} else {
				temp = q;
				q = q.next;
			}
			if (h == null) {
				h = temp;
				r = h;
			}else {
				r.next = temp;
				r = r.next;
			}
		}
		if (p!=null) {
			r.next = p;
		} else {
			r.next = q;
		}
		return h;
	}
		
	public static LinkNode mergeRec(LinkNode A,LinkNode B){
		if (A == null) {
			return B;
		}else if(B == null){
			return A;
		}
		LinkNode headLinkNode;
		if (A.data <= B.data) {
			headLinkNode = A;
			headLinkNode.next = mergeRec(A.next, B);
		} else {
			headLinkNode = B;
			headLinkNode.next = mergeRec(B.next, A);
		}
		return headLinkNode;
	}
	public static void main(String[] args){
		int length = 5;
		int[] arr1 = new int[]{1,3,5,7,9};
		int[]  arr2 =  new int[]{0,2,4,6,8};
		LinkNode start  = LinkNode.getLinkList(arr1);
		LinkNode s2 = LinkNode.getLinkList(arr2);
		LinkNode.display(start, "init the link list:");
		LinkNode.display(s2, "init list s2:");
//		LinkNode.display(LinkNode.merge(start, s2),"after imerge:");
		LinkNode.display(LinkNode.mergeRec(start, s2),"after imerge (rec):");
		
		
	}
	
		
	
}
