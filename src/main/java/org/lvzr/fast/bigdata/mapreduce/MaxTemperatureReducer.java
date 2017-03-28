package org.lvzr.fast.bigdata.mapreduce;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxTemperatureReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	public void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) 
					throws IOException, InterruptedException {

		int maxValue = -2147483648;

		for (IntWritable value : values) {
			maxValue = Math.max(maxValue, value.get());
		}

		context.write(key, new IntWritable(maxValue));
	}

}