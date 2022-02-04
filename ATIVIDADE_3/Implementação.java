package ATIVIDADE_3;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Implementação extends UnicastRemoteObject implements Interface {
	protected Implementação() throws RemoteException {
		super();
	}
	private static final long serialVersionUID = 1L;

	@Override
	public String Questionario(String corr) throws RemoteException {
		System.out.println("Questionario Esta em Execusão");
		 int certos = 0;
	     int errados = 0;
//////////////////////////////////////////////////////questão recebida
		String questoes = corr;
		String[] separação = questoes.split(";"); // separação dentres a Questão, Quant. de Responats e as alternativas         
        String n_questoes = separação[0];  //questão do questionario
        String n_alternativas = separação[1]; ///numero de alternativas do questionario
        String resposta_quest = separação[2];   //alternativas enviadas
        char[] Resp = resposta_quest.toCharArray();///conversão da variavel das alternativas(VVFF) do questioanrio em char
/////////////////////////////////////////////////// iniciando a correção     
        String resposta = "1;4;VVFF"; 
        String[] VSeparação = resposta.split(";");// separação dentres a Questão, Quant. de Responats e as alternativas
        String n_ques_gab = VSeparação[0];  //questão 
        String n_alt_gab = VSeparação[1];  // alternativa
        String gabarito = VSeparação[2];   // alternativas certas
        char[] Sep = gabarito.toCharArray();///conversão da variavel das alternativas(VVFF) do questioanrio em char
      
            	for (int a = 0; a<Sep.length; a++) {
            		if (Resp[a] == Sep[a]) {
            			certos++;
            		}else 
   	            	 errados++;
              }
       
	return "Questionario Enviado pelo Cliente: " + questoes + "\n" +
				"\n ******Corrigido******* " 
					+ "\n Numero da Questões: "+ n_questoes + "\n Numero de Acertos" + 
							certos + "\n Numero de Erros: "+ errados ;
	//return null;
	}	
}