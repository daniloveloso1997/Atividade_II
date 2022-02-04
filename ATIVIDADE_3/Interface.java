package ATIVIDADE_3;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {
		public String Questionario (String corr) throws RemoteException;
		
}