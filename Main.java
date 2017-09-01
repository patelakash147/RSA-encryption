package finalproj;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Main {
	public static void main(String args[]) {
		SecureRandom r = new SecureRandom();
		int bitlen = 1024;
		BigInteger p = new BigInteger(bitlen / 2, 100, r);
		BigInteger q = new BigInteger(bitlen / 2, 100, r);
		ModularArithmetic ob3=new ModularArithmetic();
		BigInteger n = p.multiply(q);
		RSA ob =new RSA(n);
		RSA ob1=new RSA(n,"file.txt");
		RSA ob2=new RSA("file.txt");
		ob.encryptFile("test.txt");
		ob.decryptFile("test.enc");

	}

}
