package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class servy {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/**
		 * @param args
		 */
		
				
				DatagramSocket ds = new DatagramSocket(8); 
				byte[] b = new byte[10000];	
				DatagramPacket in = new DatagramPacket(b, b.length);  
				System.out.println("Waiting for client's data");
				ds.receive(in);
				System.out.println("Range : " + new String(b)); 
				String x = new String(b);
				//System.out.println("as string" + x);
				String x1 = x.trim();
				int n = Integer.parseInt(x1);
				//System.out.println(n);
				String st = "";
				for(int i =1 ; i < n; i++) {
					if (isPerfectNumber(i)) {
						st = st + i + " ";
					}
				}
				//System.out.println(st);
				byte buff[] = st.getBytes();
				DatagramPacket out = new DatagramPacket (buff, buff.length, in.getAddress(), in.getPort()); 
				ds.send(out);
				ds.close();
			} 
		
		public static boolean isPerfectNumber(int number) {
	        int sum=0;         
	        for(int i=1; i<=number/2; i++) {
	            if(number%i == 0) {
	                sum += i;
	            }
	        }
	          
	        if(sum==number) { 
	            return true;
	        }else {
	            return false;
	        }
	}

}