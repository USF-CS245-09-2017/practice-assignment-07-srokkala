
public class ArrayList<T> implements List<T>
{
private Object [] arr;
private int size;

public ArrayList()
{
	arr = new Object[10];
}

	@Override
	public int size() 
	{
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void add(T item) 
	{
		// TODO Auto-generated method stub
		if(arr.length == size)
		{
			Object[] temparr = new Object[2*size];			//doubling size of array
			for(int i = 0 ; i <= size -1; i++)
			{
				temparr[i] = arr[i];						//copying original elements into new temp array which is twice the size of original array
			}
			arr = temparr;										
		}
		arr[size] = item;			// adds item to last index
		size ++;
		
	}

	@Override
	public void add(int pos, T item) 			//this time we know where we want to place the item
	{
		// TODO Auto-generated method stub
		if(arr.length == size)							//use the same method to create a temp array of twice the size as before
		{
			Object[] temparr = new Object[2*size];			
			for(int i = 0 ; i <= size -1; i++)
			{
				temparr[i] = arr[i];		
			}
			arr = temparr;										
			}
	
		
		for(int i = size; i > pos;i--)
		{
			arr[i] = arr[i-1];
		}
		arr[pos] = item;
		size ++;
	}

	@Override
	public T get(int pos) 
	{
		// TODO Auto-generated method stub
		if(pos >= size || pos < 0)							//if pos is out of bounds or less than 0, throw an exception otherwise return value at pos
		{
			throw new IndexOutOfBoundsException();
		}
		
		return (T) arr[pos];
	}

	@Override
	public T remove(int pos) 
	{
		// TODO Auto-generated method stub
		T value = get(pos);		// get the value of the position you want removed 
		for(int i = pos; i < size -1; i++)		
		{
			arr[i] = arr[i+1];							//decrement all values into indexes of one less than the one they are in currently
		}
		size --;
		return value;								//return the value removed
	}

}
