/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.side;

/**
 *
 * @author Lab6
 */
import java.net.*;
import java.util.*;
import java.io.*;
public class ServerSide {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        ServerSocket servSocket=new ServerSocket(4000);
        System.out.println("*** Server side***");
        System.out.println("Server ready for connection");
        Socket connSock=servSocket.accept();
        System.out.println("Connection is successfully and ready for file transfer");
        InputStream istream=connSock.getInputStream();
        BufferedReader fileRead=new BufferedReader(new InputStreamReader(istream));
        String fname=fileRead.readLine();
        File fileName=new File(fname);
        OutputStream ostream=connSock.getOutputStream();
        PrintWriter pwrite=new PrintWriter(ostream,true);
        if(fileName.exists()){
            BufferedReader contentRead=new BufferedReader(new FileReader(fname));
            System.out.println("waiting file conents to the socket");
            String str;
            while((str=contentRead.readLine())!=null){
                pwrite.println(str);
            }
            contentRead.close();
    }
        else{
            System.out.println("requested file log does not exists");
            String msg="requested file does not exists at the server side";
            pwrite.println(msg);
            
        }
        connSock.close();
        servSocket.close();
        fileRead.close();
        pwrite.close();
    
}
}
