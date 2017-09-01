package finalproj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class RSA {

	private BigInteger n, d, e;

	public RSA(BigInteger n, BigInteger e, BigInteger d) {
		this.n = n;
		this.d = d;
		this.e = e;

	}

	public RSA(BigInteger n) {
		SecureRandom r = new SecureRandom();
		int bitlen = 1024;
		BigInteger p = new BigInteger(bitlen / 2, 100, r);
		BigInteger q = new BigInteger(bitlen / 2, 100, r);
		BigInteger n1 = p.multiply(q);
		this.n = n1;
		BigInteger m = (p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));
		SecureRandom r1 = new SecureRandom();
		BigInteger e = new BigInteger(bitlen / 2, 100, r);

		
		while (m.gcd(e).intValue() > 1) {
			e = e.add(new BigInteger("2"));
		}
		BigInteger d = e.modInverse(m);
		this.e = e;
		this.d = d;
		System.out.println("public key ["+e +"   ,   "+n+"]");
	    System.out.println("privet key ["+d +"   ,   "+n+"]");
	    System.out.println();

	}

	public RSA(BigInteger n, String filename) {
		SecureRandom r = new SecureRandom();
		int bitlen = 1024;
		BigInteger p = new BigInteger(bitlen / 2, 100, r);
		BigInteger q = new BigInteger(bitlen / 2, 100, r);
		BigInteger n1 = p.multiply(q);
		this.n = n1;
		BigInteger m = (p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));
		SecureRandom r1 = new SecureRandom();
		BigInteger e = new BigInteger(bitlen / 2, 100, r);
		while (m.gcd(e).intValue() > 1) {
			e = e.add(new BigInteger("2"));
		}
		BigInteger d = e.modInverse(m);

		try {

			FileWriter fileWriter = new FileWriter(filename);

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(d + "," + n);
			bufferedWriter.newLine();
			bufferedWriter.write(e + "," + n);

			bufferedWriter.close();
		} catch (IOException ex) {
			System.out.println("Error writing to file '" + filename + "'");

		}

	}

	

	public RSA(String filename) // read private ley
	{

		String line = null;

		try {

			FileReader fileReader = new FileReader(filename);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {

				Scanner s = new Scanner(line);
				while (s.hasNextLine()) {
					String i = s.nextLine();
					String arr[] = i.split(",");

					BigInteger val1 = new BigInteger(arr[0]);
					BigInteger val2 = new BigInteger(arr[1]);

				}

				bufferedReader.close();
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + filename + "'");
		} catch (IOException ex) {
			System.out.println(" ");

		}
		this.d = d;
	}

	public synchronized String encrypt(String message) {
		return (new BigInteger(message.getBytes())).modPow(e, n).toString();
	}

	public String encryptFile(String fileName) {
		try {

			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String message;
			while ((message = bufferedReader.readLine()) != null) {

				System.out.println("plain text = "+message);
				String encr = message;
				String cyphertext = encrypt(message);
				System.out.println("encrypted text = " + cyphertext);
				System.out.println();

				try {
					String name = "test.enc";

					FileWriter fileWriter = new FileWriter(name);

					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

					bufferedWriter.write(cyphertext);

					bufferedWriter.close();
				} catch (IOException ex) {
					System.out.println("Error writing to file '" + fileName + "'");

				}
			}

			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");

		}
		return null;

	}

	public synchronized String decrypt(String message) {
		return new String((new BigInteger(message)).modPow(d, n).toByteArray());
	}

	public void decryptFile(String fileName) {
		try {

			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;
		
			System.out.print("decrypted Text:");
			while ((line = bufferedReader.readLine()) != null) {
				String ans = decrypt(line);
				System.out.println(ans);

			}

			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");

		}
	}

}
