public abstract class DateList {
    private DateNode first;
    private DateNode last;
    int length;
    public DateList()
    {
       first = last = new DateNode();
       length = 0;
    }
     public void append(DateNode dt)
   {
       last.next = dt;
       last = last.next;
       length++;
   }
      public void append_sorted(DateNode dt)
   {
       DateNode nodepre = this.first;
      while (nodepre.next != null && nodepre.next.data.compareTo(dt.data) < 0) {
         nodepre = nodepre.next;
      }
      dt.next = nodepre.next;
      nodepre.next = dt;
       this.length++;
   }
    public String toString() {
      String res = "";
      DateNode nodecurr = this.first.next;
      while (nodecurr != null) {
         res += nodecurr.data.toString() + "\n";
         nodecurr = nodecurr.next;
      }
      return res;
}
}