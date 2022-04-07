//This is the POJO/model class
public class ElectricityBill
{
    
    private String consumerNumber;
    private String consumerName;
    private String consumerAddress;
    private int unitsConsumed;
    private double billAmount;
    
    
	
    public String getConsumerNumber() {
		return consumerNumber;
	}



	public void setConsumerNumber(String consumerNumber) {
		this.consumerNumber = consumerNumber;
	}



	public String getConsumerName() {
		return consumerName;
	}



	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}



	public String getConsumerAddress() {
		return consumerAddress;
	}



	public void setConsumerAddress(String consumerAddress) {
		this.consumerAddress = consumerAddress;
	}



	public int getUnitsConsumed() {
		return unitsConsumed;
	}



	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}



	public double getBillAmount() {
		return billAmount;
	}



	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}


	//Write the required business logic as expected in the question description
	public void calculateBillAmount()
    {
    	//fill the code here
		if(unitsConsumed<=100)
		{
			billAmount=0;
		}else if(unitsConsumed<=300)
		{
			
			billAmount=0+(1.5*(unitsConsumed-100));
		}
		else if(unitsConsumed<=600)
		{
			billAmount=0+(1.5*200)+((unitsConsumed-300)*3.5);
		}
		else if(unitsConsumed<=1000)
		{
			billAmount=0+(1.5*200)+(3.5*300)+(5.5*(unitsConsumed-600));			
		}
		else
		{
			billAmount=0+(1.5*200)+(3.5*300)+(5.5*400)+(7.5*(unitsConsumed-1000));
		}
    }
    
    
    
}