public class SortedDateList extends DateList {
     public SortedDateList()
{
      super();
}
   public int getLength() {
      return length;
   }

   public void add(Date212 dt) {
        DateNode te = new DateNode(dt);
      this.append_sorted(te);
    

   }

   public String toString() {
      return super.toString();
}
}