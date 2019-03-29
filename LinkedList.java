
public class LinkedList<T> implements List<T> 
{

	public class Node
	
	{
	private Object data;
	private Node next;
	
	public Node()
	{
		this.data = 0;
		this.next = null;
	}
	
	
	public Node(Object data)
	{
		
		this.next = null;
		this.data = data;
		
		
	}
	
	
	public Object getData()
	{
		return data;
	}
	
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	public Node getNext()
	{
		return next;
	}
	
}
	
	
	private int size  = 0;
	private Node head = null;
	
	public LinkedList()
	{
		size = 0;
		head  =  null;
	}
	
	
	public Node getNode(int pos)
	{
		 Node node1 = head;
		 for(int i =0; i < pos; i++)
		 {
			 node1 = node1.getNext();

		 }
		 return node1;
		 
	}
	@Override
	public void add(T item) 
	{
		// TODO Auto-generated method stub
		Node node = new Node(item);
		node.setNext(head);
		head = node;
		size++;
	}

	@Override
	public void add(int pos, T item) 
	{
		// TODO Auto-generated method stub
		
		if(pos == 0)
		{
			Node node = new Node();
			node.data = item;
			node.next = head;
			head = node;
			size++;	
		}
		else
		{	
		Node prev = getNode(pos-1);
		Node node = new Node();
		node.data = item;
		node.next = prev.next;
		prev.next = node;
		++size;
		}
	}

	@Override
	public T get(int pos) 
	{
		// TODO Auto-generated method stub
		if(pos < 0 || pos >= size)
		{
			throw new IllegalArgumentException("Size is too big");
		}
		
		Node curr = getNode(pos);
		return (T) curr.data;
	}

	@Override
	public T remove(int pos) 
	{
		// TODO Auto-generated method stub
		
		if(pos < 0 || pos >= size)
		{
			throw new IllegalArgumentException("Size is too big");
		}
		
		if(pos == 0)
		{
			Node curr = head;
			head = head.getNext();
			--size;
			return (T) curr.data;
			
		}
		
		
		else 
		{
			Node prev = getNode(pos-1);
			Node curr = prev.next;
			prev.next = curr.next;
			--size;
			return (T) curr.data;
		}
	}
	
	
	public String toString() 
	{
        String string = "";
        Node current = head;
        while (current != null) 
        {
            string += current.getData() + "\n";
            current = current.getNext();
        }
        return string;
    }

	@Override
	public int size() 
	{
		// TODO Auto-generated method stub
		return size;
	}

}
