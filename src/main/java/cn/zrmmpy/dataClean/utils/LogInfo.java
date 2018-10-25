package cn.zrmmpy.dataClean.utils;

import java.util.Date;

public class LogInfo {
    private long userid;//用户编号
    private String operation;//操作名字
    private Date logtime;//操作时间
    private long musicid;//歌曲id
    private String rating;//歌曲评分
   

    public LogInfo(){}


	public long getUserid() {
		return userid;
	}


	public String getOperation() {
		return operation;
	}


	public Date getLogtime() {
		return logtime;
	}


	public long getMusicid() {
		return musicid;
	}


	public String getRating() {
		return rating;
	}


	public LogInfo(long userid, String operation, Date logtime, long musicid, String rating) {
		super();
		this.userid = userid;
		this.operation = operation;
		this.logtime = logtime;
		this.musicid = musicid;
		this.rating = rating;
	}


}