package table;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

class Line {

	public String exp;
	public int val;
	public String answer;

	Line(String _exp, int _val) {
		exp = _exp;
		val = _val;
	}

	Line(String _exp, int _val, String _answer) {
		exp = _exp;
		val = _val;
		answer = _answer;
	}
}

public class table {

	public static void main(String[] args) {

		ArrayList<Line> lines = new ArrayList<Line>();
		lines.add(new Line("2 * 2", 4));
		lines.add(new Line("2 * 5", 10));
		lines.add(new Line("2 * 7", 14));
		lines.add(new Line("2 * 8", 16));
		lines.add(new Line("2 * 9", 18));
		lines.add(new Line("3 * 2", 6));
		lines.add(new Line("3 * 5", 15));
		lines.add(new Line("3 * 7", 21));
		lines.add(new Line("3 * 8", 24));
		lines.add(new Line("3 * 9", 27));
		lines.add(new Line("4 * 2", 8));
		lines.add(new Line("4 * 5", 20));
		lines.add(new Line("4 * 7", 28));
		lines.add(new Line("4 * 8", 32));
		lines.add(new Line("4 * 9", 36));
		lines.add(new Line("5 * 2", 10));
		lines.add(new Line("5 * 5", 25));
		lines.add(new Line("5 * 7", 35));
		lines.add(new Line("5 * 8", 40));
		lines.add(new Line("5 * 9", 45));
		lines.add(new Line("6 * 2", 12));
		lines.add(new Line("6 * 5", 30));
		lines.add(new Line("6 * 7", 42));
		lines.add(new Line("6 * 8", 48));
		lines.add(new Line("6 * 9", 54));

		ArrayList<Line> errors = new ArrayList<Line>();

		Scanner in = new Scanner(System.in);

		int r = randInt(15, 25);
		System.out.println("ʳ������ ��������: " + r);

		for (int i = 0; i < r; i++) {

			int ind = randInt(0, lines.size() - 1);

			System.out.println("�������� ��������� ������: " + lines.get(ind).exp + " = ");
			String str = in.next();
			int n = Integer.parseInt(str);

			if (lines.get(ind).val != n) {
				errors.add(new Line(lines.get(ind).exp, lines.get(ind).val, str));
				int errind = errors.size() - 1;
				System.out.printf("False! " + errors.get(errind).exp + " = " + errors.get(errind).val + "\n");
			} else {
				System.out.printf("True!\n");
			}

			lines.remove(ind);
		}

		if (errors.size() > 0) {

			for (int i = 0; i < errors.size(); i++) {				
				System.out.printf(errors.get(i).exp + " = " + errors.get(i).answer + " (" + errors.get(i).val + ")\n");
			}

		}

		int mark = (int) Math.round(((r - errors.size()) / (double) r) * 5);
		System.out.println("You made " + errors.size() + " errors:");
		System.out.println("Your mark is " + mark);

	}

	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}
}
