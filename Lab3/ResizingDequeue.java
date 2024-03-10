import java.util.ArrayDeque;
import java.util.Deque;

public class ResizingDequeue<Item>{
    private Item[] q;
    private int n; //num of elements in the dequeue
    private int tail;
    private int head;

    public ResizingDequeue(){
        q = (Item[]) new Object[2];
        n = 0;
        head = 0;
        tail = 0;
    }
    public  void push_back(ResizingDequeue<Item> Q, Item x) //Enqueue
    {
        if(queue_size(Q)==n-1){
            resize(Q, 2*n);
        }
        else{
            Q.q[Q.tail] = x;
            Q.tail = (Q.tail + 1) % n;
            Q.n++;
        }
    }
    public void push_front(ResizingDequeue<Item> Q, Item x)//Unshift
    {
        
    }
    public void pop_back(ResizingDequeue<Item> Q)//pop back
    {
        
    }
    public Item pop_front(ResizingDequeue<Item> Q) throws Exception//dequeue or shift
    {
        if(queue_empty(Q)){
            throw new Exception("underflow");
        }

        Item x = q[head];
        head = (head + 1) % n;
        if(queue_size(Q)==n/4){
            resize(Q, n/2);
        }
        return x;
        
    }
    public int queue_size(ResizingDequeue<Item> Q)
    {
        return (n-Q.head + Q.tail) % n;
    }
    public boolean queue_empty(ResizingDequeue<Item> Q)
    {
        return Q.head == Q.tail;
    }



    public void resize(ResizingDequeue<Item> Q, int n)
    {
        Item[] copy = (Item[]) new Object[n];
        for(int i = 0; i < n; i++){
            copy[i] = q[(head + i) % q.length];
        }
        q = copy;
        head = 0;
        tail = n;
    }
    
}