RSA Encryption

In this project, you are going to implement the well-known RSA algorithm for public-key cryptography. Please check the textbook or slides for the detailed description of the algorithm. You should use Java to implement the algorithm. In Java, class BigInteger provides the functionality to deal with large n-bit numbers.

1.The main component of any RSA implementation is the generation of public and private keys. Let a, b, N denote k-bit numbers, define
a class named ModularArithmetic to contain the following static functions:

c = modadd(a, b, N) : returns c = a + b (mod N)
c = modmult(a, b, N): returns c = a * b (mod N)
c = moddiv(a, b, N): returns c = a/b (mod N)
c = modexp(a, b, N): returns c = a^b (mod N)
b = isPrime(N, k): returns true if N is prime with probability 1/2^k, or false if N is not prime.
N = genPrime(n): returns a n-bit prime number N
You should write appropriate code to validate the accuracy of each of the ModularArithmetic functions.

2. Define a class RSA to provide the following functionality:

RSA(n) (constructor): generates a public (N; e) and private (N; d) RSA key pair, where N; e; d are numbers of approximately n bits in length. The private key is stored as a private
field of the class and the public key is printed to standard output.
RSA(n, filename) (constructor): same as RSA(n) but in addition it stores the public and private key pair in
le filename.
RSA(filename) (constructor): reads in the private key stored in
the file filename.
c = encrypt(m, N, e): for a given integer m < N and public key (N; e) return the encrypted message c = m^e(mod N).
m = decrypt(c): for an integer c < N, use the private key to return the decrypted message m = c^d(mod N)
encryptFile(filename, N, e): for a given
file (with extension txt) and public key (N; e), it creates a
file of the same name (with extension enc) containing the encrypted data to be transmitted over an insecure communication line.
decryptFile(filename): for a given
file (with extension enc) it uses the private key to decrypt the content of the file and print it to standard output.
3. Demonstrate that your encryption system is working properly in Main.java.

Generate 1024-bit RSA encryption keys
Encrypt test.txt and generate test.enc
Decrypt test.enc
