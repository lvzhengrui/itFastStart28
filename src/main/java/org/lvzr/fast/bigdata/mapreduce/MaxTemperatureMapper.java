package org.lvzr.fast.bigdata.mapreduce;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxTemperatureMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	private static final int MISSING = 9999;

	public void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String line = value.toString();

		String year = line.substring(15, 19);
		int airTemperature;
		if (line.charAt(87) == '+')
			airTemperature = Integer.parseInt(line.substring(88, 92));
		else {
			airTemperature = Integer.parseInt(line.substring(87, 92));
		}

		String quantity = line.substring(92, 93);

		if ((airTemperature == 9999) || (!(quantity.matches("[01459]")))) {
			return;
		}
		context.write(new Text(year), new IntWritable(airTemperature));
	}

}