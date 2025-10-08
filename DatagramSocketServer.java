/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.side;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author Lab6
 */
public class DatagramSocketServer {
    public static void main(String[] args) throws Exception{
    Scanner in =new Scanner(System.in);
            DatagramSocket serverSocket=new DatagramSocket(9000);
            byte[] receiveData=new byte[1024];
            byte[] sendData =new byte[1024];
            System.out.println("***Server Side***");
             DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
             serverSocket.receive(receivePacket);
             System.out.println(new String(receivePacket.getData()));
              InetAddress IPAddress=receivePacket.getAddress();
              int port=receivePacket.getPort();
              while(true){
               System.out.println("Type some Message to display at client end");
               String message=in.nextLine();
               sendData=message.getBytes();
               System.out.println("Message send from the Server." +new String(sendData));
               DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,port);
               serverSocket.send(sendPacket);
              }
        // TODO code application logic here
    }
    
}
