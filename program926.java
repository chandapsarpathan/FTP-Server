import java.io.*;
import java.net.*;
import java.util.*;

class program926
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

            while (true) 
            {
                System.out.println("---------------------------------------------------------------");
                System.out.println("------------------- Mathematical command ----------------------");
                System.out.println("---------------------------------------------------------------");

                System.out.println("LIST");
                System.out.println("EXISTS <FileName>");
                System.out.println("INFO <FileName>");
                System.out.println("SIZE <FileName>");
                System.out.println("GET <FileName>");
                System.out.println("DELETE <FileName>");
                System.out.println("RENAME <OldFileName> <NewFileName>");
                System.out.println("QUIT");

                System.out.println("---------------------------------------------------------------");


                System.out.println("Enter command:");

                String command = sobj.nextLine();

                String part[] = command.split(" ");

                String operation = part[0].toUpperCase();


                if(operation.equals("GET"))
                {
                    if(part.length != 2)
                    {
                        System.out.println("Usage : GET <FileName>");

                        continue;
                    }

                    dos.writeUTF(command);
                }
                else if(operation.equals("PUT"))
                {
                    if(part.length != 2)
                    {
                        System.out.println("Usage : PUT <FileName>");

                        continue;
                    }

                    dos.writeUTF(command);
                }
                else if(operation.equals("INFO"))
                {
                    if(part.length != 2)
                    {
                        System.out.println("Usage : INFo <FileName>");

                        continue;
                    }

                    dos.writeUTF(command);
                }
                else if(operation.equals("SIZE"))
                {
                    if(part.length != 2)
                    {
                        System.out.println("Usage : SIZE <FileName>");

                        continue;
                    }

                    dos.writeUTF(command);
                }
                else if(operation.equals("EXIST"))
                {
                    if(part.length != 2)
                    {
                        System.out.println("Usage : Exist <FileName>");

                        continue;
                    }

                    dos.writeUTF(command);
                }
                else if(operation.equals("RENAME"))
                {
                    if(part.length != 3)
                    {
                        System.out.println("Usage : RENAME <OldFileName> <NewFileName>");

                        continue;
                    }

                    dos.writeUTF(command);
                }
                else if(operation.equals("DELETE"))
                {
                    if(part.length != 2)
                    {
                        System.out.println("Usage : DELETE <FileName>");

                        continue;
                    }

                    dos.writeUTF(command);
                }
                else if(operation.equals("LIST"))
                {
                    if(part.length != 1)
                    {
                        System.out.println("Usage : LIST");

                        continue;
                    }

                    dos.writeUTF(command);
                }
                else if(operation.equals("QUIT"))
                {
                    if(part.length != 1)
                    {
                        System.out.println("Usage : QUIT");

                        continue;
                    }

                    System.out.println("Thank you for using marvellous FTP server");

                    dos.writeUTF(command);

                    String response = dis.readUTF();

                    System.out.println(response);

                    break; // it will terminate the client loop
                }
                else
                {
                    System.out.println("There is no such command");
                    continue;
                }

            } // End of while

            socket.close();
            sobj.close();
            dis.close();
            dos.close();
        } // End of try
        catch(Exception e)
        {
            System.out.println("Exception occured :"+e);
        }
    } // End of main
} // End of class