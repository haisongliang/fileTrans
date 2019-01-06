/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filetrans;

/**
 *
 * @author ball
 */
public class ConfigMessage
{
    private boolean isSend;//1 send
    private String ip;
    private String fileName;
    private long fileLength;
    private boolean isCoded;
    private String note;

    public ConfigMessage(boolean isSend, String ip, String fileName, long fileLength, boolean isCoded, String note)
    {
        this.isSend = isSend;
        this.ip = ip;
        this.fileName = fileName;
        this.fileLength = fileLength;
        this.isCoded = isCoded;
        this.note = note;
    }

    public boolean isIsSend()
    {
        return isSend;
    }

    public String getIp()
    {
        return ip;
    }

    public String getFileName()
    {
        return fileName;
    }

    public long getFileLength()
    {
        return fileLength;
    }

    public boolean isIsCoded()
    {
        return isCoded;
    }

    public String getNote()
    {
        return note;
    }

    public void setIsSend(boolean isSend)
    {
        this.isSend = isSend;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public void setFileLength(long fileLength)
    {
        this.fileLength = fileLength;
    }

    public void setIsCoded(boolean isCoded)
    {
        this.isCoded = isCoded;
    }

    public void setNote(String note)
    {
        this.note = note;
    }
    
    
    
}
