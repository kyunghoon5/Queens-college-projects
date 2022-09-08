public abstract class Date212List
{
   //define the objects
   protected Date212Node first , last;
   protected int length;
   //Constructor
   public Date212List()
   {
       first = last = new Date212Node(null);
       length = 0;
   }
   //check whether list is empty or not
   public boolean isEmpty()
   {
       return length == 0;
   }
   //implement append method
   public void append(Date212 d)
   {
       last.next = new Date212Node(d);
       last = last.next;
       length++;
   }
   //implement toString method
   public String toString()
   {
       Date212Node curr = first.next;
       String str = "";
       while(curr != null)
       {
           str += curr.data.toString() + "\n\n";
           curr = curr.next;
       }
       return str;
   }
}