package ATIVIDADE_3;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {
	protected Servidor() throws RemoteException {
		super();
	}
	public static void main(String args[]) throws RemoteException,
			AlreadyBoundException {
	    Implementação quest = new Implementação();
		Registry registry = LocateRegistry.createRegistry(4000);
		registry.bind("Questionario", quest); //envio de registro
		System.out.println("********Servidor Rodando******");
	}
}