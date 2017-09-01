package finalproj;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class ModularArithmetic {

	public static int modadd(int a, int b, int N) {
		int c = 0;
		c = (a % N + b % N) % N;
		return c;
	}

	public static int modmult(int a, int b, int N) {
		int c = 0;
		c = (a % N * b % N) % N;
		return c;
	}

	public static int moddiv(int a, int b, int N) {
		int c = 0;
		c = (a % N / b % N) % N;
		return c;
	}

	public static int modexp(int a, int b, int N) {
		int c = 0;
		c = (a % N ^ b % N) % N;
		return c;
	}

	public static boolean isPrime(int N, int K) {
		for (int i = 2; i < N; i++) {
			if (N % i == 0)
				return false;
		}
		return true;

	}

	public static BigInteger genPrime(int n) {
		Random rand = new SecureRandom();

		BigInteger c = (BigInteger.probablePrime(n, rand));
		return (c);

	}
}
