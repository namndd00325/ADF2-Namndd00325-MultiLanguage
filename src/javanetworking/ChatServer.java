/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetworking;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.print.attribute.standard.Severity;

/**
 *
 * @author Nam Nguyen
 */
public class ChatServer {
    private Socket socket=null;
    private ServerSocket server = null;
    private DataInputStream streamIn = null;

    public ChatServer(int port) {
       try{
        System.out.println("Binding to port "+port+", please wait ...");
        server=new ServerSocket(port);
        System.out.println("Server started: "+server);
        System.out.println("Waiting for a client ...");
        socket=server.accept();
        System.out.println("Client accepted: "+socket);
        streamIn=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        boolean done=false;
        
        while(!done){
            try {
                String line=streamIn.readUTF();
                System.out.println(line);
                done=line.equals(".bye");
            } catch (IOException e) {
                done=true;
            }
        }
        if(socket!=null){
            socket.close();
        }
        if(streamIn!=null){
            streamIn.close();
        }
        
        }catch(IOException ex){
            System.err.println(ex);
        }
    }
    public static void main(String[] args) {
        ChatServer chatSv= new ChatServer(3333);
    }
    
}
