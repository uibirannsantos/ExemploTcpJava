/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
import java.util.*;
public class TCPClient{
    public static void main(String[] args){
        try {
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();
            byte[] buf = msg.getBytes(); // Obtendo a respresntação em bytes da mensagem
            byte[] buf2 = new byte[100]; // buffer de recepção
            
            System.out.print("[ Enviando mensagem    ..............................  ");
            os.write(buf);
            System.out.println("[OK] ]");
            
            System.out.print("[ Aguardando recebimento de mensagem   ..............  ");
            is.read(buf2); // Operação bloqueante (aguardando chegada de dados)
            String msg2 = new String(buf2); // Mapeando vetor de bytes recebido para String
            System.out.println("[OK] ]");
           
            System.out.println("  Mensagem recebida: "+ msg2);
           
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}