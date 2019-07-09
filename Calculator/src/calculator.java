import java.util.Scanner;
import java.util.Random;
public class Main {
	public static void main(String[] args) {
		/*int n=23;
		System.out.printf("n = %d\n",n);
		String name="Semen";
		System.out.println("Hello "+name);
		Scanner in=new Scanner(System.in);
		try {
			System.out.println("������ n: ");
			String str=in.next();
			n=Integer.parseInt(str); //in.nextInt();
			System.out.printf("n = %d\n",n);
		}
		catch(NumberFormatException ex)
		{
			System.out.println("������� ������������ ������ � �����");
		}
		catch(Exception ex) {
			System.out.printf("error input = %s\n",ex.getMessage());
		}
		int summ=getSum("Hello Peter", 23,12,9);
		System.out.println("sum =  "+summ);
		
		System.out.println("random = "+ randInt(12,20));*/
		
		
		int checknum =0;
		int result = 0;
		
		do {
			int firstNum = FirstNumber();
			int operat =Operation();
			int secondNum = SecondNumber(operat);
		result = Result(firstNum, secondNum, operat);
		System.out.println("��������� 1 ��� �����������,");
		System.out.println("��������� 2 ��� ������;");
		checknum = FirstNumber();
		}while(checknum == 1);
	}
	
	public static int Result(int firstNum, int secondNum, int operat) {
		//switch(operat):
		int result = 0;
		switch(operat){
        
	    case 1: 
	    	result = firstNum + secondNum;	        
	        break;
	    case 2: 
	    	result = firstNum - secondNum;
	        break;
	    case 3: 
	    	result = firstNum * secondNum;
	        break;
	    case 4: 
	    	result = firstNum / secondNum;
	        break;
	    default:
	        System.out.println("default");
	}
		System.out.printf("��������� ��������, result = %d\n",result);	
		return result;
	}
	
	public static int getSum(String message, int ...nums) {
		System.out.println(message);
		int result=0;
//		for(int i=0;i<nums.length; i++)
//		{
//			result+=nums[i];
//		}
		for(int item : nums)
			result+=item;
		return result;
	}
	
	public static int randInt(int min, int max) {

	    
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
        public static int FirstNumber() {
        	int n=0;
        	int checknumber = -1;
        	Scanner in=new Scanner(System.in);
        	do {
    		try {
    			System.out.println("������ ����� n: ");
    			String str=in.next();
    			n=Integer.parseInt(str); 
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
        	}while(checknumber == -1);
	    return n;
	}	
        
        public static int SecondNumber(int operation) {
        	int n=0;
        	
        	int checknumber = -1;
        	Scanner in=new Scanner(System.in);
        	
        	do {
    		try {
    			System.out.println("������ ����� ����� n2: ");
    			String str=in.next();
    			n=Integer.parseInt(str); //in.nextInt();
    			//System.out.printf("����� ����� n2 = %d\n",n);
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
    		if(n == 0 && operation == 4) {
    			System.out.println("�������: �� ����� ����� �� ����!");
    			checknumber = -1;
    		}
        	}while(checknumber == -1);        	
	    return n;
	}	
        
        public static int Operation() {
        	int n=0;
        	Scanner in=new Scanner(System.in);
        	
        	do {
        		try {
        			System.out.println("������� ��������: ");
        			System.out.println("1 - ��������� ");
        			System.out.println("2 - ��������� ");
        			System.out.println("3 - �������� ");
        			System.out.println("4 - ������ ");
        			String str=in.next();
        			
        			
        			n=Integer.parseInt(str); //in.nextInt();
        			System.out.printf("����� �������� n = %d\n",n);
        		}
        		catch(NumberFormatException ex)
        		{
        			System.out.println("������� ������������ ������ � �����");
        		}
        		catch(Exception ex) {
        			System.out.printf("error input = %s\n",ex.getMessage());
        		}
			}while(n <1 || n>4);
    		
	    return n;
	}	

}