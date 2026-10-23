import java.io.*;
import java.net.*;

class program918
{
    public static void main(String A[])
    {
        try
        {
            ServerSocket serversocket = new ServerSocket(9000);

            System.out.println("---------------------------------------------------------------");
            System.out.println("-----------------Marvellous server started---------------------");
            System.out.println("---------------------------------------------------------------");

            System.out.println("Server is waiting for client request");

            Socket clientsocket = serversocket.accept();

            System.out.println("Client connected succesfully");
        }
        catch(Exception e)
        {
            System.out.println("Exception occured :"+e);
        }
    }
}