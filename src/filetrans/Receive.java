/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filetrans;

import java.io.BufferedInputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.io.PrintStream;

/**
 *
 * @author ball
 */
public class Receive extends Thread
{
    private String IP;
    private int socketNum;
    private String absoluteFilePath;
    private long fileLength;
    private Boolean isCoded;
    private long totalBlock;
    private long blockNum;
    private byte[] buff = new byte[1024];

    public Receive(String IP, int socketNum, long fileLength, Boolean isCoded)
    {
        this.IP = IP;
        this.socketNum = socketNum;
        this.fileLength = fileLength;
        this.isCoded = isCoded;
    }

    
    public void run()
    {
        try
        {
            RandomAccessFile randomAccessFile = new RandomAccessFile(absoluteFilePath, "rw");
            totalBlock = randomAccessFile.length() / 1024;
            //File file = new file();
            while (blockNum < totalBlock)
            {
                Socket socket = new Socket(IP, socketNum);
                PrintStream printStream = new PrintStream(socket.getOutputStream());
                printStream.println(blockNum);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
                bufferedInputStream.read(buff, 0, 1024);
                randomAccessFile.setLength(fileLength);
                randomAccessFile.seek(blockNum * 1024);
                randomAccessFile.write(buff, 0, 1024);
                blockNum++;
            }
        } catch (Exception e)
        {
        }
    }
}
