import java.io.*;
import java.net.*;

class program924
{
    public static void main(String A[])
    {
        try
        {
            ServerSocket serversocket = new ServerSocket(9000);

            System.out.println("---------------------------------------------------------------");
            System.out.println("-----------------Marvellous server started---------------------");
            System.out.println("---------------------------------------------------------------");

            // Loop for multiple client requests
            while(true)
            {
                System.out.println("Server is waiting for client request");

                Socket clientsocket = serversocket.accept();

                System.out.println("Client connected succesfully");

                // Thread gets created for client
                Thread t = new Thread(() -> HandleClientRequest(clientsocket));

                t.start();
            } // End of while
        }
        catch(Exception e)
        {
            System.out.println("Exception occured :"+e);
        }
    } // End of main

    public static void HandleClientRequest(Socket socket)
    {
        try
        {
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            dos.writeUTF("Connected to marvellous server");

            while (true) 
            {
                String command = dis.readUTF();
                
                System.out.println("command received from client :" + command);

                String parts[] = command.split(" ");

                String operation = parts[0].toUpperCase();

                if(operation.equals("Quit"))
                {
                    dos.writeUTF("Dissconnect from server");

                    break;
                }

                if(parts.length != 3)
                {
                    dos.writeUTF("Invalid command format");

                    continue;
                }

                double no1 = Double.parseDouble(parts[1]);
                double no2 = Double.parseDouble(parts[2]);

                double result = 0.0;

                if(operation.equals("ADD"))
                {
                    result = no1+no2;

                    dos.writeUTF("Result is:"+result);
                }
                else if(operation.equals("SUB"))
                {
                    result = no1-no2;

                    dos.writeUTF("Result is:"+result);
                }
                else
                {
                    dos.writeUTF("Invalid operation");
                }// End of while

                socket.close();

                System.out.println("Client disconnected");


            }
        }
        catch(Exception e)
        {
            System.out.println("Exception occured :"+e);
        }
    }

} // End of class