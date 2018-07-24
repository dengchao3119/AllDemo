package com.bsoft.message_auth_code;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.axis2.AxisFault;
import org.apache.axis2.transport.http.HTTPConstants;

/**
 * 
* @ClassName: MessageAuthCode  
* @Description: 短息验证码测试  
* @author DENGCHAO
* @date 2018年7月9日 上午8:58:48  
*
 */
public class MessageAuthCodeTest {
public static SmsStub stub = null;
	
	static{
		try {
			stub = new SmsStub("http://localhost:8896/sms/services/Sms?wsdl");//高并发时注意使用单实例
			stub._getServiceClient().getOptions().setProperty(HTTPConstants.REUSE_HTTP_CLIENT, true);//高并发时设置成true
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			//发送接口,高并发请采用多线程提交
			String code = ValidateCodeUtil.createData();
			SmsStub.Sms sms0 = new SmsStub.Sms();
			sms0.setIn0("239476");//企业编号
			sms0.setIn1("admin3");//登录名
			sms0.setIn2("szmby123");//密码
			sms0.setIn3("尊敬的用户，您本次验证码为"+code+"，请在10分钟内使用！");//短信内容
			sms0.setIn4("18271261013");//手机号码
			sms0.setIn5("000"+format.format(new Date()));
			sms0.setIn6("");
			sms0.setIn7("1");
			sms0.setIn8("");
			sms0.setIn9("");
			sms0.setIn10("");
		
			SmsStub.SmsResponse resp;
			try {
				resp = stub.Sms(sms0);
				stub.cleanup();//使用完后cleanup
				System.out.println(resp.getOut());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
	}
}
