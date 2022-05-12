// Calculator duke perdorur TCP
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class Calc_Server
{
	public static void main(String args[]) throws IOException
	{

		ServerSocket ss = new ServerSocket(4141);
		Socket s = ss.accept();

		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

  			System.out.println("      ::::::::  :::::::::: :::::::::  :::     ::: :::::::::: :::::::::  ::::::::::: ");
			System.out.println("    :+:    :+: :+:        :+:    :+: :+:     :+: :+:        :+:    :+:     :+:      ");
			System.out.println("   +:+        +:+        +:+    +:+ +:+     +:+ +:+        +:+    +:+     +:+       ");
			System.out.println("  +#++:++#++ +#++:++#   +#++:++#:  +#+     +:+ +#++:++#   +#++:++#:      +#+        ");
			System.out.println("        +#+ +#+        +#+    +#+  +#+   +#+  +#+        +#+    +#+     +#+         ");
			System.out.println("#+#    #+# #+#        #+#    #+#   #+#+#+#   #+#        #+#    #+#     #+#          ");
			System.out.println("########  ########## ###    ###     ###     ########## ###    ### ###########       ");
			
			

		while (true)
		{
			
			String input = dis.readUTF();

			if(input.equals("exit"))
				break;

			System.out.println("Problemi i pranuar: " + input);
			int result;

			StringTokenizer st = new StringTokenizer(input);

			int oprnd1 = Integer.parseInt(st.nextToken());
			String operation = st.nextToken();
			int oprnd2 = Integer.parseInt(st.nextToken());

			// Performimi i operacioneve
			if (operation.equals("+"))
			{
				result = oprnd1 + oprnd2;
			}

			else if (operation.equals("-"))
			{
				result = oprnd1 - oprnd2;
			}
			else if (operation.equals("*"))
			{
				result = oprnd1 * oprnd2;
			}
			else
			{
				result = oprnd1 / oprnd2;
			}
			System.out.println("Duke derguar rezultatin...");
			System.out.println(" ");
			// Dergo rezultatin
			dos.writeUTF(Integer.toString(result));
		}
	}
}
