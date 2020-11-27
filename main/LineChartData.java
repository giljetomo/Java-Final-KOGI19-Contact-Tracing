package kogi19.main;

public class LineChartData {
	private String date;
	private String count;
	
	public LineChartData(String date, String count) {
		setDate(date);
		setCount(count);
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
}
