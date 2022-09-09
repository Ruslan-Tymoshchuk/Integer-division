package ua.com.rtim.integerdivision;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter dividend and divisor: ");
		int dividend = requireInput(scanner);
		int divisor = requireInput(scanner);
		scanner.close();
		IntegerDivision integerDivision = new IntegerDivision();
		DivisionResult result = integerDivision.divide(dividend, divisor);
		DivisionFormatter formatter = new DivisionFormatter();
		System.out.println(formatter.format(result));
	}

	private static int requireInput(Scanner scanner) {
		while (!scanner.hasNextInt()) {
			System.out.println("The " + scanner.next()
					+ " is incorrect input! Entered must be a number and not more then 2147483647");
		}
		return scanner.nextInt();
	}
}
