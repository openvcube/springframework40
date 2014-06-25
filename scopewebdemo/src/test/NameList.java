package test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 *
 */
public class NameList implements INameList {
	
	protected final static Log log = LogFactory.getLog(NameList.class);

	private List<String> nameList = new ArrayList<String>();

	public NameList(){
		log.info("�����µ�NameList()ʵ��");
	}
	
	public List<String> getNameList() {
		return nameList;
	}
	
	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	@Override
	public String toString() {		
		return this.nameList.toString();
	}
	
}
