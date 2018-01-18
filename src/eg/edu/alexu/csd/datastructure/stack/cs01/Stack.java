/**
 *
 */
package eg.edu.alexu.csd.datastructure.stack.cs01;

import eg.edu.alexu.csd.datastructure.stack.IStack;

/**
 * @author Personal
 *
 */
public class Stack implements IStack {
	/**
	 * @author Personal
	 *
	 */
	class Node {
		/**
		 * data of Node.
		 */
		private Object data;
		/**
		 * next of a Node.
		 */
		private Node next;
		/**
		 * pre of a node.
		 */
		private Node prev;

		/**
		 * setting by null.
		 */
		public Node() {
			data = null;
			next = null;
			prev = null;
		}
		/**
		 * @param p previous.
		 * @param d data.
		 * @param n next.
		 */
		public Node(final Node p, final Object d, final Node n) {
			data = d;
			next = n;
			prev = p;
		}
		/**
		 * @param n next.
		 */
		public void setnext(final Node n) {
			next = n;
		};
		/**
		 * @param n set next.
		 */
		public void setprev(final Node n) {
			prev = n;
		};
		/**
		 * @param d of node.
		 */
		public void setdata(final Object d) {
			data = d;
		};
		/**
		 * @return next node.
		 */
		public Node getnext() {
			return next;
		};
		/**
		 * @return prev node.
		 */
		public Node getprev() {
			return prev;
		};
		/**
		 * @return data of node.
		 */
		public Object getdata() {
			return data;
		}
	}
	/**
	 * head and tail nodes.
	 */
	private Node head, tail;
	/**
	 * linked list size.
	 */
	private int size = 0;
	/**
	 * @return element at top.
	 * @throws Exception.
	 */
	@Override
	public Object pop() {
		if (size == 0) {
			throw new RuntimeException();
		}
		Node popNode = tail;
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			tail = tail.getprev();
			tail.setnext(null);
			popNode.setprev(null);
		}
		size--;
		return popNode.getdata();
	}
	/**
	 * @return element at top.
	 * @throws Exception.
	 */
	@Override
	public Object peek() {
		if (size == 0) {
			throw new RuntimeException();
		} else {
			return tail.getdata();
		}
	}
	/**
	 * @param element of stack
	 */
	@Override
	public void push(final Object element) {
		Node nodetoadd = new Node(null, element, null);
		Node prevnode = head;
		if (size == 0) {
			head = nodetoadd;
			tail = nodetoadd;
			size++;
		} else {
			prevnode = tail;
			tail = nodetoadd;
			prevnode.setnext(tail);
			tail.setprev(prevnode);
			size++;
		}
	}
	/**
	 * @return empty var.
	 */
	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}
	/**
	 * @return size of stack.
	 */
	@Override
	public int size() {
		return size;
	}
	/**
	 * @param element of stack.
	 * @param index of element.
	 */
	@Override
	public void add(final int index, final Object element) {
		if (index > size || index < 0) {
			throw new RuntimeException();
		} else {
			Node prevnode = head;
			Node nodetoadd = new Node(null, element, null);
			if (size == 0) {
				head = nodetoadd;
				tail = nodetoadd;
				size++;
			} else if (index == 0) {
				nodetoadd.setnext(head);
				head.setprev(nodetoadd);
				head = nodetoadd;
				size++;
			} else {
				for (int i = 0; i < size; i++) {
					if (i == index - 1) {
		Node nextnode = prevnode.getnext();
		prevnode.setnext(nodetoadd);
	    nodetoadd.setprev(prevnode);
		nodetoadd.setnext(nextnode);
						if (nextnode != null) {
						nextnode.setprev(nodetoadd);
						}
						size++;
						break;
					}
					prevnode = prevnode.getnext();
				}
			}
			if (nodetoadd.getnext() == null) {
				tail = nodetoadd;
			}
		}
	}
}
