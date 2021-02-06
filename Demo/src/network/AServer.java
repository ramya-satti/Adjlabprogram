package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintStream;

public class AServer {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		ServerSocket s1 = new ServerSocket(2719);
		System.out.println("Server is ready for clients");
		Socket ss = s1.accept();
		
		Scanner sc = new Scanner(ss.getInputStream());
		String str =sc.nextLine();
		int v=0,c=0;
		str=str.toLowerCase();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)>=97 && str.charAt(i)<=122) {
				if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u') {
					v++;
				}
				else {
					c++;
				}
			}
		}
		
		PrintStream p = new PrintStream(ss.getOutputStream());
		p.println(v);
		p.println(c);
		ss.close();

	}

}