package test;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author worldheart
 * 
 */
//�̳�Remote�ӿڣ���֧��RMI����
public interface IUserInfo extends Remote {

	//�׳�RemoteException����֧��RMI����
	String getUserInfo() throws RemoteException;

}
