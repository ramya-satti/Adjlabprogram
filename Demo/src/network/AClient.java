package network;


import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class AClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Socket s =new Socket("localhost",2719);
		
		Scanner sc1 = new Scanner(s.getInputStream());
		System.out.println("Enter a sentence :");
		String str = sc.nextLine();
		PrintStream p = new PrintStream(s.getOutputStream());
		p.println(str);
		int v = sc1.nextInt();
		int c = sc1.nextInt();
		System.out.println("vowels : "+v+"\nconsonants : "+c);
		
		s.close();
			
	}

}