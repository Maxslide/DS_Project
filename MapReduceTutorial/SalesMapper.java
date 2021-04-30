package SalesCountry;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class SalesMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
	private final static IntWritable one = new IntWritable(1);

	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {

		String valueString = value.toString();
		String[] a = valueString.split(" ");
		String year = a[0].split("-")[0];
		String[] err = a[2].split(":");
		String error = err[0];
		String error_name = err[0] + "-" + err[2];
		String username = err[1].replace("[", "").replace("]", "");
		
		// output.collect(new Text("U - " + username),one);
		// output.collect(new Text("YLN - " + year + "-" + error_name),one);
		// output.collect(new Text("ULN - " + username + "-" + error_name),one); 
		output.collect(new Text("UYL - " + username + "-" + year + "-" + error),one); 
		// output.collect(new Text("Y - " + year), one);
		// output.collect(new Text("L - " + error), one);
		output.collect(new Text("LN - " + error_name), one);
		// output.collect(new Text(year), one);
	}
}
