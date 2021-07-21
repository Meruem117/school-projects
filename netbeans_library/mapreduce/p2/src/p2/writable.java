/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2;

/**
 *
 * @author jenie
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;

/**
 *
 * @author jenie
 */
public class writable implements WritableComparable<writable> {
	private DoubleWritable min;
	private DoubleWritable max;
	private IntWritable total;

	public writable() {
		this.min=new DoubleWritable(0);
		this.max=new DoubleWritable(0);
		this.total=new IntWritable(0);
	}

	public writable(double min,double max,int total){
		this.min=new DoubleWritable(min);
		this.max=new DoubleWritable(max);
		this.total=new IntWritable(total);
	}
	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		min.write(out);
		max.write(out);
		total.write(out);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		min.readFields(in);
		max.readFields(in);
		total.readFields(in);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return min.get()+"\t"+max.get()+"\t"+total.get();
	}

	public DoubleWritable getMin() {
		return min;
	}

	public void setMin(DoubleWritable min) {
		this.min = min;
	}

	public DoubleWritable getMax() {
		return max;
	}
	public void setMax(DoubleWritable max) {
		this.max = max;
	}
	public IntWritable getTotal() {
		return total;
	}
	public void setTotal(IntWritable total) {
		this.total = total;
	}
	@Override
	public int compareTo(writable o) {
		int maxcomp=max.compareTo(o.max);
		if(maxcomp!=0){
			return maxcomp;
		}
		int mincomp=min.compareTo(o.min);
		if(mincomp!=0){
			return mincomp;
		}
		
		return 0;

	}	
}
