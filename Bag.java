import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>{
	private Node<Item> first;
	private int n;
	
	private static  class Node<Item>{
		private Item item;
		private Node<Item> next;
	}
	public Bag()
	{
		first =null;
		n=0;
	}
	public void add(Item item)
	{
		Node<Item> oldFirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldFirst;
		n++;
	}
	public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
}
