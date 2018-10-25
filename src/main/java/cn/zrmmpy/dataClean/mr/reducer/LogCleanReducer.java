package cn.zrmmpy.dataClean.mr.reducer;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class LogCleanReducer extends Reducer<NullWritable, Text, NullWritable, Text>{
	@Override
	protected void reduce(NullWritable key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException 
	{
		StringBuffer logs = new StringBuffer();
		for(Text loginfo : values){
			logs.append(loginfo+";");
		}
		context.write(NullWritable.get() , new Text(logs.toString()));			
	}

}
