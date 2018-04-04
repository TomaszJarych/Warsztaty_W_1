package a_Zadanie1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SymulatorLotto {

	public static void main(String[] args) {
		int[] lottoNumber = getRandomNumbers();
		System.out.println("Wylosowane liczby to " + Arrays.toString(lottoNumber));
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
	}

	public static int[] getRandomNumbers() {
		int[] randomNumbers = new int[0];
		Random rand = new Random();
		while (randomNumbers.length < 6) {
			int tempNumber = rand.nextInt(49) + 1;
			for (int i : randomNumbers) {
				if (i == tempNumber) {
					tempNumber = rand.nextInt(49) + 1;
				}
			}
			randomNumbers = Arrays.copyOf(randomNumbers, randomNumbers.length + 1);
			randomNumbers[randomNumbers.length - 1] = tempNumber;
		}
		Arrays.sort(randomNumbers);
		return randomNumbers;
	}

}
