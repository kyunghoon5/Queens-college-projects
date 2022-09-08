
public class MoneyMain {
   
   static String[] dataSource =  {"B5","Q","B20","Q","D","N","P","B100"};
   static Money[] wallet = new Money[dataSource.length];
   
   public static void main (String[] args) {
        
	  // String s1 ="apple";
	   //s1.substring(1,5); //from 1 to (5-1)=4 pple
	   
      for (int i=0;i<dataSource.length;i++){
         char dataItem = dataSource[i].charAt(0);
         if (dataItem == 'B') {
            int billValue= Integer.parseInt(dataSource[i].substring(1,dataSource[i].length()));
            wallet[i]= new Bill(billValue);
         }   
         else if (dataItem == 'Q')
               wallet[i]=new Quarter();
         else if (dataItem == 'D')
             wallet[i]=new Dime();
         else if (dataItem == 'N')
             wallet[i]=new Nickel();
         else if (dataItem == 'P')
             wallet[i]=new Penny();
         //else if (dataItem == 'C')
         //    wallet[i]=new Coin(); //cannot create abstract class
         }
      printWallet();
   }
   public static void printWallet () {
      for (int i=0;i<wallet.length;i++) {
    	  /*
         if (wallet[i] instanceof Bill)
            System.out.println("$ "+((Bill)wallet[i]).getValue()+".00");
         else
            System.out.println(wallet[i]);
            //System.out.println(wallet[i].toString());
         */
    	  System.out.println(wallet[i]);
    	  //toString() in Object => ClassName@hexadecimalcode of memory address
      }
   }
}
