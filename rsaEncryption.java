import java.math.BigInteger;
import java.util.Random;
import java.io.*;

public class rsaEncryption
{
    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;
    private int bitlength = 1024;
    private int blocksize = 256;
    private Random r;

    public rsaEncryption(BigInteger e, BigInteger d, BigInteger n)
    {
        this.e=e;
        this.d=d;
        this.n=n;
    }
    
    public rsaEncryption()
    {
        r=new Random();
        p=BigInteger.probablePrime(bitlength,r);
        q=BigInteger.probablePrime(bitlength,r);
        n=p.multiply(q);
        
        phi=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e= BigInteger.probablePrime(bitlength/2,r);
        
        while(phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi)<0)
        {
            e.add(BigInteger.ONE);
        }
        d=e.modInverse(phi);
    }
    
    public static void main(String [] args) throws IOException
    {
        rsaEncryption rs = new rsaEncryption();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(isr);
        String teststring;
        System.out.println("Enter the string");
        teststring = in.readLine();
        System.out.println("Encrypyion string: "+teststring);
        System.out.println("String in bytes: "+bytesToString(teststring.getBytes()));
        
        //Encrypting the string
        byte [] encrypted = rs.encrypt(teststring.getBytes());
        System.out.println("Encrypted string in bytes: "+bytesToString(encrypted));
        
        //Decrypting the string
        byte [] decrypted = rs.decrypt(encrypted);
        System.out.println("Decrypted string in bytes: "+bytesToString(decrypted));
        
        System.out.println("Decrypted string: "+new String(decrypted));
    }
    
    private static String bytesToString(byte [] encrypted)
    {
        String test = "";
        for(byte b: encrypted)
        {
            test += Byte.toString(b);
        }
        return test;
    }
    
    public byte [] encrypt(byte [] message)
    {
        return (new BigInteger(message)).modPow(e,n).toByteArray();
    }
    
    public byte [] decrypt(byte [] message)
    {
        return (new BigInteger(message)).modPow(d,n).toByteArray();
    }

}
