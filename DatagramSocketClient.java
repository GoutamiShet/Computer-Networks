/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.side;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Lab6
 */
public class DatagramSocketClient {
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
      String line="Connected with client" ;
      DatagramSocket clientSocket=new DatagramSocket();
      InetAddress IPAddress=InetAddress.getByName("localhost");
      byte[] sendData =new byte[1024];
       byte[] receiveData =new byte[1024];
      sendData=line.getBytes();
       DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,9000);
       clientSocket.send(sendPacket);
       System.out.println("*****Client Display Terminal*****");
       while(true){
           DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
           clientSocket.receive(receivePacket);
           String messageReceived=new String(receivePacket.getData(),receivePacket.getOffset(), receivePacket.getLength());
           System.out.println("Message typed at server side is:" +messageReceived);
       }
    }
    
}
