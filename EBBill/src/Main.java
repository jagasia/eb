import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
   
   public static void main(String[] args) throws NumberFormatException, IOException, InvalidConsumerNumberException, ClassNotFoundException, SQLException {
	  
	   Scanner sc=new Scanner(System.in);
	   //fill your code here
	   ElectricityBoard eb=new ElectricityBoard();
	   List<ElectricityBill> list = eb.generateBill("src/ElectricityBill.txt");
	   eb.addBill(list);
	   System.out.println("Done");
   }
}
          