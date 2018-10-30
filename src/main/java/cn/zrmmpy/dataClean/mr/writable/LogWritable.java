  package cn.zrmmpy.dataClean.mr.writable;

import java.util.Date;

public class LogWritable {
    private long userid;//用户编号
    private String operation;//操作名字
    private Date logtime;//操作时间
    private long musicid;//歌曲id
    private String rating;//歌曲评分
	public LogWritable(long userid, String operation, Date logtime, long musicid, String rating) {
		super();
		this.userid = userid;
		this.operation = operation;
		this.logtime = logtime;
		this.musicid = musicid;
		this.rating = rating;
	}
	@Override
	public String toString() {
		return userid + "@@" + operation + "@@" + logtime + "@@"
				+ musicid + "@@" + rating;
	}
	
}
