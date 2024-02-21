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
    public void enqueue(Item x, Item[] Q){

    }
    public void unshift(Item x, Item[] Q){
        
    }
    public void resize(Item[] Q, int n){

    }
    public void shift(Item[] Q){

    }
}