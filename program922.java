import java.io.*;
import java.net.*;
import java.util.*;

class program919
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        try
        {

            System.out.println("---------------------------------------------------------------");
            System.out.println("-----------------Marvellous Client started---------------------");
            System.out.println("---------------------------------------------------------------");

            Socket socket = new Socket(
                                        "127.0.0.1",
                                        9000
                                        );

            System.out.println("Connection with server is succesfully");

            DataInputStream dis = new DataInputStream(socket.getInputStream());

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            System.out.println(dis.readUTF());
        }
        catch(Exception e)
        {
            System.out.println("Exception occured :"+e);
        }
    }
}