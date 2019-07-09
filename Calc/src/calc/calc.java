package calc;

import java.util.Scanner;
import java.util.Random;

public class calc {
	public static void main(String[] args) {
		int checknum = 0;
		int result = 0;

		do {
			int firstNum = GetNumber();
			int operat = Operation();
			int secondNum = GetNumber(operat);
			result = Result(firstNum, secondNum, operat);
			System.out.println("�������� 1 ��� �����������,");
			System.out.println("�������� 2 ��� ������;");
			checknum = GetNumber();
		} while (checknum == 1);
		System.out.println("Thank you for your calculations!");
	}

	public static int Result(int firstNum, int secondNum, int operat) {
		int result = 0;
		switch (operat) {

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
		System.out.printf("��������� ��������, result = %d\n", result);
		return result;
	}

	public static int GetNumber() {
		int n = 0;
		int checknumber = -1;
		Scanner in = new Scanner(System.in);
		do {
			try {
				System.out.println("������ �����: ");
				String str = in.next();
				n = Integer.parseInt(str);
				checknumber = 1;
			} catch (NumberFormatException ex) {
				System.out.println("������� ������������ ������ � �����");
				checknumber = -1;
			} catch (Exception ex) {
				System.out.printf("error input = %s\n", ex.getMessage());
				checknumber = -1;
			}
		} while (checknumber == -1);
		return n;
	}

	public static int GetNumber(int operation) {
		int n = 0;

		int checknumber = -1;
		Scanner in = new Scanner(System.in);

		do {
			try {
				System.out.println("������ ����� �����: ");
				String str = in.next();
				n = Integer.parseInt(str);
				checknumber = 1;
			} catch (NumberFormatException ex) {
				System.out.println("������� ������������ ������ � �����");
				checknumber = -1;
			} catch (Exception ex) {
				System.out.printf("error input = %s\n", ex.getMessage());
				checknumber = -1;
			}
			if (n == 0 && operation == 4) {
				System.out.println("�������: �� ����� ����� �� ����!");
				checknumber = -1;
			}
		} while (checknumber == -1);
		return n;
	}

	public static int Operation() {
		int n = 0;
		Scanner in = new Scanner(System.in);

		do {
			try {
				System.out.println("������� ��������: ");
				System.out.println("1 - ��������� ");
				System.out.println("2 - �������� ");
				System.out.println("3 - �������� ");
				System.out.println("4 - ������ ");
				String str = in.next();

				n = Integer.parseInt(str);
			} catch (NumberFormatException ex) {
				System.out.println("������� ������������ ������ � �����");
			} catch (Exception ex) {
				System.out.printf("error input = %s\n", ex.getMessage());
			}
		} while (n < 1 || n > 4);

		return n;
	}

}