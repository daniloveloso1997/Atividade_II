package ATIVIDADE_3;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
	public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {
						//* obtain a reference to a bootstrap remote object registry */
		Registry registry = LocateRegistry.getRegistry(4000);
		Interface stub = (Interface) registry.lookup("Questionario"); // confirmanod o registro
		System.out.println(stub.Questionario("1;4;VVFF"));///enviando o questionario

	}
}