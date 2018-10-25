package cn.zrmmpy.dataClean.mr.mapper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import cn.zrmmpy.dataClean.mr.writable.LogWritable;


public class LogCleanMapper extends Mapper<LongWritable, Text, NullWritable, Text> {


    private String[] fields;
    DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    ParsePosition pos = new ParsePosition(0);
    private long userid;//用户编号
    private String operation;//操作名字
    private Date logtime;//操作时间
    private long musicid;//歌曲id
    private String rating;//歌曲评分
    
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
       
    }


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        fields = value.toString().split("@@");
        if (fields == null || fields.length<4) { // 有异常数据
            return;
        }
        userid=Long.parseLong(fields[0]);
        logtime=format1.parse(fields[1], pos);
        operation=fields[2];
        musicid=Long.parseLong(fields[3]);
        if (fields.length>4) {
        	rating=fields[4];
		}
        
        LogWritable access = new LogWritable(userid, operation,logtime, musicid,rating);
        context.write(NullWritable.get(), new Text(access.toString()));
    }


}
