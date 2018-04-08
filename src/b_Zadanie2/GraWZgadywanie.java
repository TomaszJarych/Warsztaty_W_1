package b_Zadanie2;

import java.util.Random;
import java.util.Scanner;


public class GraWZgadywanie {

	public static void main(String[] args) {
		int liczbaLosowa = getRandomNumber();
		int podanyNumer = 0;

		try (Scanner scan = new Scanner(System.in)) {
			do {
				podanyNumer = userNumber(scan);
				if (podanyNumer < liczbaLosowa) {
					System.out.println("To za mało");
				} else if (podanyNumer > liczbaLosowa) {
					System.out.println("To za dużo");
				}

			} while (podanyNumer != liczbaLosowa);
			System.out.println("Zgadłeś");
		}

	}

	public static int userNumber(Scanner scan) {
		System.out.println("Podaj liczbę");
		while (!scan.hasNextInt()) {
			scan.next();
			System.out.println("Podaj prawidłową liczbę");
		}
		return scan.nextInt();

	}

	public static int getRandomNumber() {
		Random r = new Random();
		return r.nextInt(100) + 1;
	}

}
// Warsztat: Gra w zgadywanie liczb.
//
// Napisz prostą grę w zgadywanie liczb. Komputer musi wylosować liczbę w
// zakresie od 1 do 100. Następnie:
//
// Zadać pytanie: "Zgadnij liczbę" i pobrać liczbę z klawiatury.
// Sprawdzić, czy wprowadzony napis, to rzeczywiście liczba i w razie błędu
// wyświetlić komunikat "To nie jest liczba", po czym wrócić do pkt. 1
// Jeśli liczba podana przez użytkownika jest mniejsza niż wylosowana,
// wyświetlić komunikat "Za mało!", po czym wrócić do pkt. 1.
// Jeśli liczba podana przez użytkownika jest większa niż wylosowana, wyświetlić
// komunikat "Za dużo!", po czym wrócić do pkt. 1.
// Jeśli liczba podana przez użytkownika jest równa wylosowanej, wyświetlić
// komunikat "Zgadłeś!", po czym zakończyć działanie programu.
//
// Przykład:
//
// Zgadnij liczbę: cześć
// To nie jest liczba.
// Zgadnij liczbę: 50
// Za mało!
// Zgadnij liczbę: 75
// Za dużo!
// Zgadnij liczbę: 63
// Zgadłeś!
