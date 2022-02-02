package atividade2_SD;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class servidor {
	public static void main(String[] args) {
		int porta= 4000;
		String gabarito = "1;4;VVFF"; // respostas corretas
		String[] VSeparacao = gabarito.split(";"); // separação dentres a Questão, Quant. de Responats e as alternativas
		char[] Sep = VSeparacao[2].toCharArray();   //  conversão da variavel das alternativas(VVFF) em char
		int acertos = 0;
		int erros = 0;
		try {
			System.out.println ("*******SEJA BEM VINDO AO SERVIDOR********* "); /// SO PARA ENCHER LINGUIÇA.KKKKK
			DatagramSocket servidor = new DatagramSocket(porta);  //identificando em qual porta esta rodando o servidor
			System.out.println ("Servidor Rodando na Porta: "+porta);
			int i = 0;    //// int i - variavel para contar o tanto de questionario recebido
			while (true) {   /// receber pacote do cliente
				byte [] receiveData = new byte [1024];		
				DatagramPacket QuestRecebido = new DatagramPacket(receiveData, receiveData.length);/// comando para receber os questionario do cliente
				i++;
				System.out.println ("\n*****Aguardando o Recebimentos de Questionarios:" +i + " *****");
				servidor.receive(QuestRecebido); // servido vai ficar bloqueado ate que um pacote seja recebido
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
				String questionario = new String(QuestRecebido.getData());  ///// convertendo bytes em String
				System.out.println ("\n*********Questionario Recebido com Sucesso!!************");
				System.out.println("Resposta do Questionario Recebido: " + questionario); ///mostrando o conteudo do questionario
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				String[] Separacao = questionario.split(";");  //// iniciando a correção
				String n_questao = Separacao[0];
				String n_alternativa = Separacao[1];
				String respostas = Separacao[2];
				char[] Resp = respostas.toCharArray();   ///conversão da variavel das alternativas(VVFF) do questioanrio em char
						for(int a=0; a<Sep.length; a++) {
							if(Resp[a] == Sep[a]) {
									acertos++;
							}else 
								erros++;
							}
				System.out.println("\n******CORREÇÃO!*******");
				String correcao = new String("Questão: "+ n_questao + //// comando montando a correção
						"\n Numeros de Certos: " + acertos+ "\n Numero de Erros: "+ erros);
				System.out.println(correcao);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
				
				System.out.println("\nPressione ENTER para enviar Correção ao Cliente");  // SO PARA DA UMA INCREMENTADA - FICAR DIVERTIDO.KKKK
				System.in.read();
				
				byte[] sendData = new byte [1024]; ///// transfomando a string e bytes para o envio ao cliente
				sendData = correcao.getBytes();
				InetAddress enderDestino= QuestRecebido.getAddress(); //// enviando mensagem para o remetente da mensagem///////////////
				int portaDoCliente = QuestRecebido.getPort();
				
				DatagramPacket PacSaida= new DatagramPacket(sendData, sendData.length, enderDestino, portaDoCliente); // enviando a correção
				System.out.println("Enviando: " + new String(sendData));
				servidor.send(PacSaida);          ////////////////////////////////////////////////////////////
      		}
		} catch (Exception e) {
			System.out.println ("Deu Bug no Servidor");
			e.printStackTrace();
		}
	}
}
