//THis is a java programm which start a server

import java.net.*;
import java.util.*;

public class Server{
    
    public ServerSocket server;

    //Server constructer which access pid on server
    public Server(ServerSocket server){
        this.server = server;
    }

    public void startServer(){
        try{
            while(!server.isClosed()){
                Socket socket = server.accept();
                ClientHandler client = new ClientHandler(socket);
                System.out.println("A new client is joined username : " + client.getClientName());

                Thread thread = new Thread(client);
                thread.start();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    //function which close server
    public void closeServerSocket(){
        try{
            if(server != null){
                server.close();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String []args)throws Exception{
        System.out.println(".....................SERVER IS GONE STARTED..................");
        System.out.println(".......................WAITING FOR CLIENT....................");
        ServerSocket server = new ServerSocket(1234);
        Server s = new Server(server);
        s.startServer();
    }

}