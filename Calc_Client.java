// Calculator duke perdorur TCP
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Calc_Client
{
	public static void main(String[] args) throws IOException
	{
		//InetAddress ip = InetAddress.getLocalHost();
		String ip = "192.168.95.128";
		int port = 4141;
		Scanner sc = new Scanner(System.in);

		Socket s = new Socket(ip, port);

		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

			System.out.println("      :::    ::: :::        ::::::::::: :::::::::: ::::    ::: ::::::::::: :::::::::::");
			System.out.println("     :+:   :+:  :+:            :+:     :+:        :+:+:   :+:     :+:         :+:     ");
			System.out.println("    +:+  +:+   +:+            +:+     +:+        :+:+:+  +:+     +:+         +:+      ");
			System.out.println("   +#++:++    +#+            +#+     +#++:++#   +#+ +:+ +#+     +#+         +#+       ");
			System.out.println("  +#+  +#+   +#+            +#+     +#+        +#+  +#+#+#     +#+         +#+        ");
			System.out.println(" #+#   #+#  #+#            #+#     #+#        #+#   #+#+#     #+#         #+#         ");
			System.out.println("###    ### ########## ########### ########## ###    ####     ###     ###########      ");


		while (true)
		{
			
			// "operand1 operation operand2"
			System.out.println(" ");
			System.out.println("Jepei shprehjet per ti llogaritur ne formatin e meposhtem: ");
			System.out.println("'operand operator operand'");

			String inp = sc.nextLine();

			if (inp.equals("exit"))
				break;

			// dergo te serveri
			dos.writeUTF(inp);

			// respons nga serveri
			String ans = dis.readUTF();
			System.out.println("Rezultati=" + ans);
		}
	}
}
