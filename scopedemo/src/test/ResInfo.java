package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;


/**
 * ʵ����IResInfo�ӿ�
 * 
 * @author worldheart
 *
 */
public class ResInfo implements IResInfo {
	
	protected static final Log log = LogFactory.getLog(ResInfo.class);

	private Resource resClass;
	
	private Resource resFile;
	
	public ResInfo(){
		log.info("�����µ�ResInfoʵ��");
	}
	
	public Resource getResClass() {
		return resClass;
	}

	public void setResClass(Resource resClass) {
		this.resClass = resClass;
	}

	public Resource getResFile() {
		return resFile;
	}

	public void setResFile(Resource resFile) {
		this.resFile = resFile;
	}

}
