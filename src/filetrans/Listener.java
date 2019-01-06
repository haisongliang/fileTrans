/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filetrans;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ball
 */
public class Listener extends Thread
{

    public void run()
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(10086);
            System.out.println("Listener start.");
            while (true)
            {
                Socket s = serverSocket.accept();
                Scanner scanner = new Scanner(s.getInputStream());
                int requestType = scanner.nextInt();
                SocketAddress IP = s.getRemoteSocketAddress();
                
                switch(requestType)
                {
                    case 0:                        
                        System.out.println("Now begin download");                        
                        break;
                }                
                scanner.close();
                s.close();
            }
        } catch (IOException ex)
        {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
