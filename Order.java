package cakepackage;

//This is the "Order" interface

public interface Order
{
	 public void setDate(String date);

	    public String getDate();

	    public void setCustName(String customerName);

	    public String getCustName();

	    public double getTotCost();

	    public void setTotCost(double totalCost);
}
