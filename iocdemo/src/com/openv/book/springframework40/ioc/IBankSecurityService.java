package com.openv.book.springframework40.ioc;

/**
 * <pre>
 * ����ȯ�̷����
 * </pre>
 * @author openvcube  openvcube@open-v.com
 * @version 1.00.00
 * <pre>
 * �޸ļ�¼
 *    �޸ĺ�汾:     �޸��ˣ�  �޸�����:     �޸�����: 
 * </pre>
 */
public interface IBankSecurityService {

	public abstract void bankToSecurity(Double money);

	public abstract void securityToBank(Double money);
	
}
