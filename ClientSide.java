/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package client.side;
import java.net.*;
import java.util.*;
import java.io.*;


/**
 *
 * @author Lab6
 */
public class ClientSide {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner in=new Scanner(System.in);
        Socket clientSocket=new Socket("127.0.0.1",4000);
        System.out.println("****Client side****");
        System.out.println("enter the file name to transfer");
        String fname=in.nextLine();
        OutputStream ostream=clientSocket.getOutputStream();
        PrintWriter pwrite=new PrintWriter(ostream,true);
        pwrite.println(fname);
        InputStream istream=clientSocket.getInputStream();
        BufferedReader socketRead=new BufferedReader(new InputStreamReader(istream));
        System.out.println("contents of the file "+fname+"are");
        String str;
        while((str=socketRead.readLine())!=null){
            System.out.println(str); 
        }
        pwrite.close();
        socketRead.close();
        
    }
    
}
