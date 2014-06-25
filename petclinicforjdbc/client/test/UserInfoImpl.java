package test;

import javax.management.Notification;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;


/**
 * @author worldheart
 * 
 */
@ManagedResource(objectName="bean:spring=userInfo",
		description="userName��password", 
		currencyTimeLimit=20,persistPeriod=100)
public class UserInfoImpl implements IUserInfo, NotificationPublisherAware {

	NotificationPublisher np;
	
	private String userName;	
	private String password;
	
	//δ��¶��JMX�ͻ��˹���
	public String getPassword() {
		return password;
	}
	
	@ManagedAttribute()
	public void setPassword(String password) {
		this.password = password;
	}
	
	@ManagedAttribute()
	public String getUserName() {
		return userName;
	}
	
	@ManagedAttribute()
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@ManagedOperation()
	@ManagedOperationParameters(
			{@ManagedOperationParameter(name="userName",description="�û���"),
				@ManagedOperationParameter(name="password",description="����")})
	public void updateUserInfo(String userName, String password) {
		this.userName = userName;
		this.password = password;
		Notification nf = new Notification("updateUserInfo",this,System.currentTimeMillis());
		nf.setUserData("spring dragon");
		this.np.sendNotification(nf);
	}
	
	@Override
	public String toString() {
		return "userName:" + this.userName + ", password:" + this.password;
	}
	
	public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
			this.np = notificationPublisher;
	}
	
}
