import java.util.*;
import java.net.*;
import java.io.*;

public class ClientHandler implements Runnable{

    public static ArrayList<ClientHandler> clientHandlers = new ArrayList();

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientUsername;

    public ClientHandler(Socket socket){
        try{
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.clientUsername = bufferedReader.readLine();
            clientHandlers.add(this);
            broadcastMessage("SERVER: New User \"" + clientUsername + "\" has enter in the chat-room...\n");
        }catch(Exception e){
            System.out.println(e);
            closeEveryThing(socket,bufferedReader,bufferedWriter);
        }
    }
    @Override
    public void run(){
        String messageForClient;
        while(socket.isConnected()){
            try{
                messageForClient = bufferedReader.readLine();
                broadcastMessage(messageForClient);
            }catch(Exception e){
                System.out.println(e);
                break;
            } 
        }
    }

    public String getClientName(){
        return clientUsername;
    }
    
    public void broadcastMessage(String messageToSend){
        for(ClientHandler clientHandler : clientHandlers){
            try{
                if(!clientHandler.clientUsername.equals(clientUsername)){
                    clientHandler.bufferedWriter.write(messageToSend);
                    clientHandler.bufferedWriter.newLine();
                    clientHandler.bufferedWriter.flush();
                }
            }catch(Exception e){
                System.out.println(e);
                closeEveryThing(socket,bufferedReader,bufferedWriter);
            }
        }
    }

    public void removeClientHandler(){
        clientHandlers.remove(this);
        broadcastMessage("Server: " + clientUsername + " has left your chat-room!\n" );
    }

    public void closeEveryThing(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        removeClientHandler();
        try{
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(bufferedWriter != null){
                bufferedWriter.close();
            }
            if(socket != null){
                socket.close();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
