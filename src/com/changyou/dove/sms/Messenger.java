package com.changyou.dove.sms;

public interface Messenger {
	/**
	 * 下行短信发送
	 * 
	 * @param channelNum
	 *            畅游通道号码(主通道号+自定义扩展子号)
	 * @param phoneNum
	 *            目标手机号(用户)
	 * @param content
	 *            短信内容
	 * @param msgId
	 *            消息唯一ID，与上行状态反馈发时应一致
	 * @return 返回值： 成功返回0, 失败:返回<0 的错误代码
	 */
	public int sendMessage(String channelNum, String phoneNum, String content,
			long msgId);

	/**
	 * 上行短信接收（下发短信异步回执消息）
	 * 
	 * @param channelNum
	 *            畅游通道号码(主通道号+自定义扩展子号)
	 * @param msgId
	 *            消息唯一ID，与下发时应一致
	 * @param phoneNum
	 *            用户手机号码，与下发时应一致
	 * @param result
	 *            反馈结果：短信发送成功返回0, 发送失败：返回<0的错误代码
	 */
	public void onFeedback(String channelNum, String phoneNum, long msgId,
			int result);

	/**
	 * 上行短信消息(来自用户发送)
	 * 
	 * @param channelNum
	 *            畅游通道号码(主通道号+自定义扩展子号)
	 * @param phoneNum
	 *            用户手机号
	 * @param content
	 *            用户发送信息内容
	 */
	public void onReceive(String channelNum, String phoneNum, String content);

	/**
	 * 获取余额信息
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 失败 ：-1 成功：>0的余额短信条数（不金额，请转化成可发送条数）
	 */
	public long queryAccount(String username, String password);
}
