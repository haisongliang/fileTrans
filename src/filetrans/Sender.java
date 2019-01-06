/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filetrans;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author ball
 */
public class Sender extends Thread
{

    private String fileAbsolutePath;    
    private Boolean isCoded;
    private RandomAccessFile randomAccessFile;   
    private int socketNum;
    private byte[] buff = new byte[1024];
    private long totalBlock;

    public Sender(String fileAbsolutePath, Boolean isCoded, int socketNum)
    {
        this.fileAbsolutePath = fileAbsolutePath;
        this.isCoded = isCoded;
        this.socketNum = socketNum;
    }

    
    
    public void run()
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(socketNum);
            randomAccessFile = new RandomAccessFile(fileAbsolutePath, "r");
            totalBlock = randomAccessFile.length() / 1024;
            long blockNum = -1L;
            while (blockNum < totalBlock)
            {
                Socket s = serverSocket.accept();
                Scanner scanner = new Scanner(s.getInputStream());
                blockNum = scanner.nextLong();
                PrintStream printStream = new PrintStream(s.getOutputStream());;
                randomAccessFile.seek(blockNum * 1024);
                randomAccessFile.read(buff, 0, 1024);
                if(isCoded)
                {
                    
                }
                printStream.println(buff);
                printStream.close();
                s.close();
            }
            //send final block
        } catch (Exception e)
        {
        }
    }
}
