import java.util.*;
import java.net.*;
import java.io.*;

public class Client{
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String username;

    public Client(Socket socket, String username){
        try{
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = username;
        }catch(Exception e){
            System.out.println(e);
            closeEveryThing(socket, bufferedReader, bufferedWriter);
        }
    }

    public void sendMessages(){
        try{
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            Scanner in = new Scanner(System.in);
            while(socket.isConnected()){
                String messageToSend = in.nextLine();
                bufferedWriter.write(username + ": " + messageToSend+"\n");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }catch(Exception e){
            System.out.println(e);
            closeEveryThing(socket,bufferedReader,bufferedWriter);
        }
    }

    public void listenForMessage(){
        new Thread(new Runnable(){
            public void run(){
                String msgFromGroupChat;
                while(socket.isConnected()){
                    try{
                        msgFromGroupChat = bufferedReader.readLine();
                        System.out.println(msgFromGroupChat);
                    }catch(Exception e){
                        System.out.println(e);
                        closeEveryThing(socket,bufferedReader,bufferedWriter);
                        break;
                    }
                }
            }
        }).start();
    }

    public void closeEveryThing(Socket socket,BufferedReader bufferedReader, BufferedWriter bufferedWriter){
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

    public static void main(String []args)throws Exception{

        Scanner in = new Scanner(System.in);
        System.out.println("Enter your username for the group that: ");
        String username = in.nextLine();
        Socket socket = new Socket("localhost",1234);
        Client client = new Client(socket,username);
        client.listenForMessage();
        client.sendMessages();
    }

}