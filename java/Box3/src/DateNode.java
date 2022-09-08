public class DateNode {
   Date212 data;
   DateNode next;

DateNode(Date212 dt) {
         this.data = dt;
      this.next = null;
    }


    DateNode() {
       this.data = null;
      this.next = null;
    }
    public String toString() {
        return this.data.toString();
     }
  }