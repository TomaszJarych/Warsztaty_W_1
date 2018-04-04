package a_Zadanie1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SymulatorLotto {

	public static void main(String[] args) {
		int[] lottoNumber = getRandomNumbers();
		System.out.println("Wylosowane liczby to " + Arrays.toString(lottoNumber));
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Podaj 6 unikalnych liczb w przedziale 1-49");
			int [] userNumber = new int[0];
			while (userNumber.length <6) {
				int tempNumber  = scan.nextInt();
				for (int i : userNumber) {
					if (i == tempNumber) {
						System.out.println("liczba została już podana, podaj inną");
						tempNumber = scan.nextInt();
					}
				}
				if (tempNumber > 0 && tempNumber <=49) {
					
					userNumber = Arrays.copyOf(userNumber, userNumber.length + 1);
					userNumber[userNumber.length - 1] = tempNumber;}
				}

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
