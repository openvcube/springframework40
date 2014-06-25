package test;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 
 * @author worldheart
 * 
 */
//����ǿ���RMI-IIOPʹ��Ӧ�ã���Ҫʹ��javax.rmi.PortableRemoteObject
public class UserInfoImpl extends UnicastRemoteObject 
	implements IUserInfo {
	private UserPassPojo upp;

	//�����������׳�RemoteException
	public UserInfoImpl(UserPassPojo upp) throws RemoteException {
		this.upp = upp;
	}

	//ҵ�񷽷�Ҳ�����׳�RemoteException
	public String getUserInfo() throws RemoteException {
		System.out.println("�ͻ����õ���");
		return this.upp.toString();
	}
}
