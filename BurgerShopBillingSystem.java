import java.util.*;
class BurgerShopBillingSystem{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String[] customerId = new String[0];
        double[] Billvalue = new double[0];
         System.out.println("===============================================================");
         System.out.println("||              BUGER SHOP BILLING SYSTEM                    ||");
         System.out.println("===============================================================");
         System.out.println("");
        while (true){
            System.out.print("\nEnter Customer ID (-1 to stop)  :  ");
            String cusid = input.next();
            if (cusid.equals("-1")){
                break;
            }
            System.out.print("Enter Bill Value                :  ");
            double bill = input.nextDouble();
           
             System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
            int index = -1;
            for (int i = 0; i < customerId.length; i++) {
                if (customerId[i].equals(cusid)){
                    index = i;
                    break;
					}
            }
            if (index != -1){
                Billvalue[index] += bill;
                }
                
            else{
                String[] tempId =new String[customerId.length + 1];
                double[] tempBill = new double[Billvalue.length + 1];
                for (int i = 0; i< customerId.length;i++) {
                    tempId[i] =customerId[i];
                    tempBill[i] = Billvalue[i];
                }
                tempId[tempId.length - 1] =cusid;
                tempBill[tempBill.length - 1] = bill;

                customerId= tempId;
                Billvalue = tempBill;
            }
        }
        
        for (int i = 0; i < Billvalue.length - 1; i++) {
            for (int j = 0; j < Billvalue.length - 1 - i; j++) {
                if (Billvalue[j] < Billvalue[j + 1]) {
					
                    double tempBill = Billvalue[j];
                    Billvalue[j] =Billvalue[j + 1];
                    Billvalue[j + 1] =tempBill;

                    String tempId = customerId[j];
                    customerId[j] =customerId[j + 1];
                    customerId[j + 1] = tempId;
                }
            }
        }
        System.out.println(" \n");
        System.out.println("\t\t----------------------------------------");
        System.out.println("\t\t|       DAILY BEST CUSTOMER REPORT     |");	
        System.out.println("\t\t----------------------------------------");
		System.out.println(" ");
        System.out.printf("\t\t| %-12s | %-20s |%n",
                        "Customer ID", "Total Bill Values");
        System.out.println("\t\t---------------------------------------");
        
        for (int i = 0; i < customerId.length; i++) {
            System.out.printf("\t\t| %-12s | Rs.%-17.2f |%n",
                          customerId[i], Billvalue[i]);
        }
        System.out.println("\t\t---------------------------------------");
        
        
        
        
        
        
        
    }
}
