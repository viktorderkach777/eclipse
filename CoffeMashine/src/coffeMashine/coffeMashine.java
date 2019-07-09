package coffeMashine;

import java.util.Scanner;

public class coffeMashine {

	public static void main(String[] args) {
		
		ProtoMashine proto = new ProtoMashine(1, 100, 2, 100, 3, 100, 1, 10, 0);
		proto.MashinePrint();
		Human human = new Human("Petro", 400);
		human.print();
		Order order = proto.OrderSum();
		
		if(human.CanPayment(order) && proto.CanMashineMakeOrder(order)) {
			
			double clientSum = proto.GetOrder(order);			
			human.Payment(order);
			proto.GetChange(order,  clientSum);
			proto.MakePayment(order);							
		}
		
		human.print();
		proto.MashinePrint();		
	}	
	
	}	



class ProtoMashine{	
	static double minAmountCofee = 0;
	static double maxAmountCofee = 10;
	static double minAmountSugar = 0;
	static double maxAmountSugar = 20;
	static double minAmountMilk = 0;
	static double maxAmountMilk = 30;
	static double minAmountCognac = 0;
	static double maxAmountCognac = 20;	
	static double maxClientSum = 500;
	static double minSum = 2;
	
	double sugarPrice;
	double sugarAmount;
	double cofeePrice;
	double cofeeAmount;
	double cognacPrice;
	double cognacAmount;	
	double milkPrice;
	double milkAmount;	
	double allMoney;	
	
	public ProtoMashine(double sugarPrice, double sugarAmount, double cofeePrice, double cofeeAmount,
			double cognacPrice, double cognacAmount,  double milkPrice,
			double milkAmount, double allMoney) {
		
		this.sugarPrice = sugarPrice;
		this.sugarAmount = sugarAmount;
		this.cofeePrice = cofeePrice;
		this.cofeeAmount = cofeeAmount;
		this.cognacPrice = cognacPrice;
		this.cognacAmount = cognacAmount;		
		this.milkPrice = milkPrice;
		this.milkAmount = milkAmount;		
		this.allMoney = allMoney;	
		
	}
	
	
	
	public Order OrderSum() {
		double coffeeAmount =  GetIngredient("������ ������� ���� (" + minAmountCofee +" - " + maxAmountCofee + " ��)", minAmountCofee , maxAmountCofee);
		double milkAmount =  GetIngredient("������ ������� ������ (" + minAmountMilk + " - " + maxAmountMilk + " ��)", minAmountMilk , maxAmountMilk);
		double sugarAmount =  GetIngredient("������ ������� ����� (" + minAmountSugar + " - " + maxAmountSugar + " ��)", minAmountSugar , maxAmountSugar);
		double cognacAmount =  GetIngredient("������ ������� ������� (" + minAmountCognac + " - " + maxAmountCognac + " ��)", minAmountCognac , maxAmountCognac);
		double sum = minSum + coffeeAmount * this.cofeePrice + milkAmount * this.milkPrice + 
				+ sugarAmount * this.sugarPrice + cognacAmount * this.cognacPrice;	
		
		Order order = new Order(sum, coffeeAmount, sugarAmount, milkAmount, cognacAmount);
		
		return order;
				
	}
	
	public double GetOrder(Order order) {		
		double clientSum = GetIngredient("������ ����� (" + order.getSum() +  " - " + maxClientSum +"���)", order.getSum() , maxClientSum);		
		return clientSum;
	}
	
	public double GetChange(Order order, double clientSum) {				
		double clientChange = clientSum - order.getSum();
		System.out.println("���� �����: " + clientChange);
		return order.getSum();
	}
	
	
	public boolean CanMashineMakeOrder(Order order) {
		if(this.sugarAmount <= order.getSugarAmount()) {
			System.out.println("���������� �� ��������: � ������ ����������� �����!");
			return false;
		}		
		
		if(this.cofeeAmount <= order.getCofeeAmount()) {			
			System.out.println("���������� �� ��������: � ������ ����������� ����!");
			return false;
		}		
		
		if(this.cognacAmount <= order.getCognacAmount()) {
			System.out.println("���������� �� ��������: � ������ ����������� �������!");
			return false;		
		}		
		
		if(this.milkAmount <= order.getMilkAmount()) {
			System.out.println("���������� �� ��������: � ������ ����������� ������!");
			return false;			
		}		
		
		return true;
	}
	
	
	public void MakePayment(Order order) {		
		this.sugarAmount -= order.getSugarAmount();	
		this.cofeeAmount -= order.getCofeeAmount();
		this.cognacAmount -= order.getCognacAmount();
		this.milkAmount -= order.getMilkAmount();
		this.allMoney += order.getSum();
		System.out.println("������ �� ����������!");		
		
	}
	
	public void MashinePrint() {
		System.out.println("----------------------���������� ����������------------------------ ");
		System.out.printf("ʳ������ ����� (��) : %.2f\n",this.sugarAmount);
		System.out.printf("ʳ������ ���� (��) : %.2f\n",this.cofeeAmount);	
		System.out.printf("ʳ������ ������� (��) : %.2f\n",this.cognacAmount);	
		System.out.printf("ʳ������ ������ (��) : %.2f\n",this.milkAmount);	
		System.out.printf("����� (���) : %.2f\n",this.allMoney);
		System.out.println("-------------------------------------------------------------------- \n");
	}
	
	
	public double GetIngredient(String condition, double min, double max ) {
    	double n=0;
    	int checknumber = -1;
    	Scanner in=new Scanner(System.in);
    	do {
		try {
			System.out.println(condition);
			String str=in.next();
			n=Double.parseDouble(str);		
			
			checknumber = 1;
		}
		catch(NumberFormatException ex)
		{
			System.out.println("������� ������������ ������ � �����");
			checknumber = -1;
		}
		catch(Exception ex) {
			System.out.printf("error input = %s\n",ex.getMessage());
			checknumber = -1;
		}
		if(n <min || n>max) {
			checknumber = -1;
		}
    	}while(checknumber == -1);
    return n;
    }
}

class Order{
	double sum;	
	double sugarAmount;	
	double cofeeAmount;	
	double cognacAmount;	
	double milkAmount;
	
	public Order(double sum, double cofeeAmount, double sugarAmount,
			   double milkAmount, double cognacAmount) {
		
		this.sum = sum;		
		this.sugarAmount = sugarAmount;		
		this.cofeeAmount = cofeeAmount;	
		this.cognacAmount = cognacAmount;		
		this.milkAmount = milkAmount;
	}
	
	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getSugarAmount() {
		return sugarAmount;
	}

	public void setSugarAmount(double sugarAmount) {
		this.sugarAmount = sugarAmount;
	}

	public double getCofeeAmount() {
		return cofeeAmount;
	}

	public void setCofeeAmount(double cofeeAmount) {
		this.cofeeAmount = cofeeAmount;
	}

	public double getCognacAmount() {
		return cognacAmount;
	}

	public void setCognacAmount(double cognacAmount) {
		this.cognacAmount = cognacAmount;
	}

	public double getMilkAmount() {
		return milkAmount;
	}

	public void setMilkAmount(double milkAmount) {
		this.milkAmount = milkAmount;
	}
	
}

class Human{	

	String name;		
	double money;
	
	public Human(String name, double money) {
		super();
		this.name = name;
		this.money = money;
	}
	
	public boolean Payment(Order order) {
		this.money = this.money - order.getSum();
		return true; 
	}
	
	public boolean CanPayment(Order order) {				 
		if(this.money >= order.getSum()) {
			return true; 
		}
		System.out.println("����������� ����� ��� ����������!");
		return false;		
	}
	
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	public void print() {
		System.out.println("-----------------------���� �볺���---------------------------------- ");
		System.out.println("�볺��: " + this.name + "; �����: " + this.money);
		System.out.println("-------------------------------------------------------------------- \n");
	}
}
