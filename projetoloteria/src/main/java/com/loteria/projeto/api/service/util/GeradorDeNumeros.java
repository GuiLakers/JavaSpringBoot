package com.loteria.projeto.api.service.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class GeradorDeNumeros {

	int interval = 0;
	int primeNumbers = 0;
	int numRand1 = 1;
	int numRand2 = 1;
	int baseRandom = 30030 * 5;
	int numAleatorio = 0;
	int numberLottery = 0;
//	Set<Integer> lottery = new LinkedHashSet<Integer>(6);
	List<Integer> lottery = new ArrayList<>(6);

	Random rand = new Random();

	public List<Integer> gerarNumeros() {

		do {
			numRand1 = rand.nextInt(baseRandom);
			numRand2 = rand.nextInt(baseRandom);
			if (numRand1 != numRand2) {
				if (numRand1 > numRand2) {
					interval = numRand1 - numRand2;
				} else {
					interval = numRand2 - numRand1;
				}
			}

		} while (interval < 1000);

		for (int j = 1; j <= interval; j++) {
			boolean eh = ehPrimo(j);
			if (eh) {
				primeNumbers++;
			}
		}

		for (int i = 0; i < 6; i++) {

			numAleatorio = (int) (Math.random() * primeNumbers) + 1;
			while (numAleatorio > 60) {
				numAleatorio = (int) (Math.random() * primeNumbers) + 1;
			}

			do {
				numberLottery = (int) (Math.random() * numAleatorio) + 1;
			} while (lottery.contains(numberLottery));

			lottery.add(numberLottery);
		}
		
		List<Integer> lottery2 = new ArrayList<>(lottery);
		Collections.sort(lottery2);

		for (Integer integer : lottery2) {
			System.out.println("Numero " + (integer));
		}
		Collections.sort(lottery);
		
		return lottery;
	}

	public boolean ehPrimo(int numero) {

		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				return false;
			}
		}
		return true;
	}

}