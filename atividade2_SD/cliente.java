package atividade2_SD;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class cliente {
	public static void main(String[] args) {
		try {
			System.out.println("**************CLIENTE UDP*****************");  /// SO PARA ENCHER LINGUIÇA
			DatagramSocket cliente = new DatagramSocket ();
			System.out.println("Abrindo Conexão");
			InetAddress ipDoServidor = InetAddress.getByName("localhost");  // local da conexão
			byte[] sendData = new byte [1024];
			
			System.out.println("\n***********Criando Questionario***************");
			sendData = "1;4;VVVF".getBytes();           ///// mensagem - pacote de envio
			DatagramPacket questionarioDeEnvio = 
					new DatagramPacket(sendData, sendData.length, ipDoServidor, 4000);
			
			System.out.println("Pressione ENTER para Enviar o Questionario");  // SO PARA DA UMA INCREMENTADA - FICAR DIVERTIDO.KKKK
			System.in.read();
			
			cliente.send(questionarioDeEnvio);//// envio do questionario para o servidor
			System.out.println("\n*******Questionario Enviado!!*******");
			
			byte[] receiveData = new byte[1024]; // recebendo uma resposta do servidor/////////////
			DatagramPacket Pac = new DatagramPacket(receiveData, receiveData.length);
			System.out.println("Esperando a Correção do Questionario!");
			cliente.receive(Pac);
/////////////////////////////////////////////////////////////////////////////			
			
			String Correcao = new String(receiveData);   // recebendo a conversão
			System.out.println("\n*********Correção Realizada********\n" + Correcao);/////////////////////////////////////
			cliente.close(); /// impressao da correção
			
		} catch (Exception e) {
			System.out.println("Deu Bug no Cliente");
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
