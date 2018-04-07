package a_Zadanie1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SymulatorLotto {

	public static void main(String[] args) {
		int[] randomNumbers = randomNumbers();
		int[] userNumbers = userNumber();
		int counter = commonNumber(randomNumbers, userNumbers);
		System.out.println("Podane liczby to " + Arrays.toString(userNumbers));
		System.out.println("wylosowane numery to " + Arrays.toString(randomNumbers));
		System.out.println("Liczba trafień to "+counter);
	}

	public static int commonNumber(int[] randomNumbers, int[] userNumbers) {
		int counter = 0;

		for (int i : userNumbers) {
			for (int j : randomNumbers) {
				if (i == j) {
					counter++;
				}

			}
		}
		return counter;
	}

	public static int[] userNumber() {
		int[] userNumbers = new int[0];
		try (Scanner scan = new Scanner(System.in)) {
			while (userNumbers.length < 6) {
				System.out.println("podaj liczbę w przedziale od 1 do 52");
				int tempInt = scan.nextInt();
				for (int i : userNumbers) {
					if (i == tempInt) {
						System.out.println("Ta liczba została już podana. Podaj inną");
						tempInt = scan.nextInt();
					}
				}
				if (tempInt != 0 && tempInt < 53) {
					userNumbers = Arrays.copyOf(userNumbers, userNumbers.length + 1);
					userNumbers[userNumbers.length - 1] = tempInt;
				}

			}
			Arrays.sort(userNumbers);
		} catch (InputMismatchException e) {
			System.out.println("Błędne dane. Podaj liczbę!");

		}
		return userNumbers;
	}

	public static int[] randomNumbers() {
		int[] arraysOfRandom = new int[0];
		Random r = new Random();
		while (arraysOfRandom.length < 6) {
			int tempInt = r.nextInt(50) + 1;
			for (int i : arraysOfRandom) {
				if (i == tempInt) {
					tempInt = r.nextInt(50) + 1;
				}
			}
			if (tempInt != 0 && !arraysOfRandom.equals(r)) {
				arraysOfRandom = Arrays.copyOf(arraysOfRandom, arraysOfRandom.length + 1);
				arraysOfRandom[arraysOfRandom.length - 1] = tempInt;
			}

		}
		Arrays.sort(arraysOfRandom);
		return arraysOfRandom;
	}

}

