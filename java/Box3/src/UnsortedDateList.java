public class UnsortedDateList extends DateList{

public UnsortedDateList()
{
      super();
}
   public int getLength() {
      return length;
   }

   public void add(Date212 dt) {
      DateNode te = new DateNode(dt);
      this.append(te);

   } // method append(Date212)

   public String toString() {
      return super.toString();
}
}