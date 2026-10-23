import java.io.*;
import java.net.*;

class program924
{
    public static int clientCount = 1;
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

    // Request handler for each client Request
    public static void HandleClientRequest(Socket socket)
    {
        System.out.println("New thread get created for client no : "+clientCount);
        clientCount++;

        try
        {
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            dos.writeUTF("Connected to marvellous server");

            while (true) 
            {
                // read command from client
                String command = dis.readUTF();
                
                System.out.println("command received from client :" + command);

                String parts[] = command.split(" ");

                String operation = parts[0].toUpperCase();

                if(operation.equals("QUIT"))
                {
                    if(parts.length != 1)
                    {
                        dos.writeUTF("Usage : QUIT");

                        continue;
                    }

                    dos.writeUTF("Dissconnect from server");

                    clientCount--;

                    break;
                }

                double no1 = Double.parseDouble(parts[1]);
                double no2 = Double.parseDouble(parts[2]);

                double result = 0.0;

                if(operation.equals("GET"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : GET <FileName>");

                        continue;
                    }
                }
                else if(operation.equals("PUT"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : PUT <FileName>");

                        continue;
                    }
                }
                else if(operation.equals("INFO"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : INFO <FileName>");

                        continue;
                    }
                }
                else if(operation.equals("SIZE"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : SIZE <FileName>");

                        continue;
                    }
                }
                else if(operation.equals("EXIST"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : EXIST <FileName>");

                        continue;
                    }
                }
                else if(operation.equals("RENAME"))
                {
                    if(parts.length != 3)
                    {
                        dos.writeUTF("Usage : RENAME <OldFileName> <NewFileName>");

                        continue;
                    }
                }
                else if(operation.equals("DELETE"))
                {
                    if(parts.length != 2)
                    {
                        dos.writeUTF("Usage : DELETE <FileName>");

                        continue;
                    }
                }
                else if(operation.equals("LIST"))
                {
                    if(parts.length != 1)
                    {
                        dos.writeUTF("Usage : LIST");

                        continue;
                    }
                }
                else
                {
                    dos.writeUTF("Invalid operation");
                }// End of while

                socket.close();
                dis.close();
                dos.close();

                System.out.println("Client disconnected");


            } // ENd of While
        } // End of try
        catch(Exception e)
        {
            System.out.println("Exception occured :"+e);
        }
    } // End of HandleCLientRequest() method
 
} // End of class