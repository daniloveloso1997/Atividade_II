package ATIVIDADE_3;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Implementa��o extends UnicastRemoteObject implements Interface {
	protected Implementa��o() throws RemoteException {
		super();
	}
	private static final long serialVersionUID = 1L;

	@Override
	public String Questionario(String corr) throws RemoteException {
		System.out.println("Questionario Esta em Execus�o");
		 int certos = 0;
	     int errados = 0;
//////////////////////////////////////////////////////quest�o recebida
		String questoes = corr;
		String[] separa��o = questoes.split(";"); // separa��o dentres a Quest�o, Quant. de Responats e as alternativas         
        String n_questoes = separa��o[0];  //quest�o do questionario
        String n_alternativas = separa��o[1]; ///numero de alternativas do questionario
        String resposta_quest = separa��o[2];   //alternativas enviadas
        char[] Resp = resposta_quest.toCharArray();///convers�o da variavel das alternativas(VVFF) do questioanrio em char
/////////////////////////////////////////////////// iniciando a corre��o     
        String resposta = "1;4;VVFF"; 
        String[] VSepara��o = resposta.split(";");// separa��o dentres a Quest�o, Quant. de Responats e as alternativas
        String n_ques_gab = VSepara��o[0];  //quest�o 
        String n_alt_gab = VSepara��o[1];  // alternativa
        String gabarito = VSepara��o[2];   // alternativas certas
        char[] Sep = gabarito.toCharArray();///convers�o da variavel das alternativas(VVFF) do questioanrio em char
      
            	for (int a = 0; a<Sep.length; a++) {
            		if (Resp[a] == Sep[a]) {
            			certos++;
            		}else 
   	            	 errados++;
              }
       
	return "Questionario Enviado pelo Cliente: " + questoes + "\n" +
				"\n ******Corrigido******* " 
					+ "\n Numero da Quest�es: "+ n_questoes + "\n Numero de Acertos" + 
							certos + "\n Numero de Erros: "+ errados ;
	//return null;
	}	
}