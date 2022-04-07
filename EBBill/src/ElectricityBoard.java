import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class ElectricityBoard {

	// write the required business logic methods as expected in the question
	// description

	public void addBill(List<ElectricityBill> billList) {
		// fill your code here
		DBHandler dbh = new DBHandler();
		Connection con = null;
		for (ElectricityBill bill : billList) {
			try {
				con = dbh.establishConnection();
				PreparedStatement st = con.prepareStatement("INSERT INTO ElectricityBill VALUES (?,?,?,?,?)");
				st.setString(1, bill.getConsumerNumber());
				st.setString(2, bill.getConsumerName());
				st.setString(3, bill.getConsumerAddress());
				st.setInt(4, bill.getUnitsConsumed());
				st.setDouble(5, bill.getBillAmount());
				st.executeUpdate();
				con.close();
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<ElectricityBill> generateBill(String filePath)
	{
		// fill your code here
		List<ElectricityBill> billList = new ArrayList<>();
		try
		{
			FileReader fr = new FileReader(filePath);
			String line = "";
			BufferedReader br = new BufferedReader(fr);
			
			while ((line = br.readLine()) != null) {
				// line is a csv, parse it into an object
				String[] arr = line.split(",");
				// validate the consumer number
				try {
					if (validate(arr[0])) {
						ElectricityBill ebill = new ElectricityBill();
						ebill.setConsumerNumber(arr[0]);
						ebill.setConsumerName(arr[1]);
						ebill.setConsumerAddress(arr[2]);
						ebill.setUnitsConsumed(Integer.parseInt(arr[3]));
						ebill.calculateBillAmount();
						billList.add(ebill);
					}
				} catch (InvalidConsumerNumberException icne) {
					continue;
				}
			}	
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return billList;
	}

	public boolean validate(String consumerNumber) throws InvalidConsumerNumberException {
		// fill your code here
		if (!consumerNumber.matches("0{1}[0-9]{9}")) {
			throw new InvalidConsumerNumberException("Invalid Consumer Number");
		} else {
			return true;
		}
	}

}
