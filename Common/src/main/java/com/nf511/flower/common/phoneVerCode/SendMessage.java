package com.nf511.flower.common.phoneVerCode;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * @功能概要：调用DEMO
 * @公司名称： ShenZhen Montnets Technology CO.,LTD.
 */
public class SendMessage
{
	// 日期格式定义
	private static SimpleDateFormat	sdf	= new SimpleDateFormat("MMddHHmmss");

	public  void EX(String tel,String code)
	{
		// 用户账号
		String userid = "E1076C";  //E1076L    E1076C     E106RS
		// 用户密码
		String pwd = "2Ho4cG";    //yKo54O     2Ho4cG     jHqIsH
		
		//主IP信息  必填
		String masterIpAddress="api01.monyun.cn:7901";
		//备IP1  选填
		String ipAddress1="192.169.3.225:8088";
		//备IP2  选填
		String ipAddress2=null;
		//备IP3  选填
		String ipAddress3=null;
		//设置IP
		ConfigManager.setIpInfo(masterIpAddress, ipAddress1, ipAddress2, ipAddress3);
		
		//密码是否加密   true：密码加密;false：密码不加密
		ConfigManager.IS_ENCRYPT_PWD=true;
		boolean isEncryptPwd= ConfigManager.IS_ENCRYPT_PWD;

		// 单条发送
		singleSend(userid, pwd,isEncryptPwd,tel,code);

		// 每次请求想要获取的上行的最大条数。
		int retsizeMo = 100;
		//实例化获取上行线程
		RecvMoThread recvMoThread=new RecvMoThread(userid, pwd,isEncryptPwd,retsizeMo);
		//线程获取 启动获取上行的线程 
		recvMoThread.start();
		System.out.println("获取上行的线程启动成功！");
		
		// 每次请求想要获取的状态报告的最大条数。
		int retsizeRpt = 100;
		//实例化状态报告线程
		RecvRptThread recvRptThread=new RecvRptThread(userid, pwd,isEncryptPwd,retsizeRpt);
		//线程获取 启动获取状态报告的线程
		recvRptThread.start();
		System.out.println("获取状态报告的线程启动成功！");
		
	    //清除所有IP (此处为清除IP示例代码，如果需要修改IP，请先清除IP，再设置IP)
		ConfigManager.removeAllIpInfo();

	}
	
	/**
	 * 
	 * @description  单条发送  
	 * @param userid  用户账号
	 * @param pwd 用户密码
	 * @param isEncryptPwd 密码是否加密   true：密码加密;false：密码不加密
	 */
	public static void singleSend(String userid, String pwd,boolean isEncryptPwd,String phone,String verCode)
	{
		try
		{
			// 参数类
			Message message = new Message();
			// 实例化短信处理对象
			CHttpPost cHttpPost = new CHttpPost();
			
			// 设置账号   将 userid转成大写,以防大小写不一致
			message.setUserid(userid.toUpperCase());
			
			//判断密码是否加密。
			//密码加密，则对密码进行加密
			if(isEncryptPwd)
			{
				// 设置时间戳
				String timestamp = sdf.format(Calendar.getInstance().getTime());
				message.setTimestamp(timestamp);
				
				// 对密码进行加密
				String encryptPwd = cHttpPost.encryptPwd(message.getUserid(),pwd, message.getTimestamp());
				// 设置加密后的密码
				message.setPwd(encryptPwd);
				
			}else {
				// 设置密码
				message.setPwd(pwd);
			}
			
			// 设置手机号码 此处只能设置一个手机号码
			message.setMobile(phone);
			// 设置内容
			message.setContent("您的验证码是"+verCode+"，在10分钟内输入有效。如非本人操作请忽略此短信。");
			// 设置扩展号
			message.setExno("11");
			// 用户自定义流水编号
			message.setCustid("20160929194950100001");
			// 自定义扩展数据
			message.setExdata("abcdef");
			//业务类型
			message.setSvrtype("SMS001");

			// 返回的平台流水编号等信息
			StringBuffer msgId = new StringBuffer();
			// 返回值
			int result = -310099;
			// 发送短信
			result = cHttpPost.singleSend(message, msgId);
			// result为0:成功;非0:失败
			if(result == 0) {
				System.out.println("单条发送提交成功！");
				//System.out.println(msgId.toString());
			}
			else {
				System.out.println("单条发送提交失败,错误码：" + result);
			}
		}
		catch (Exception e) {
			//异常处理
			e.printStackTrace();
		}
	}


}
