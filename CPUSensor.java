
import java.awt.Color;

import libs.CpuUtilizationSensor;

public class CPUSensor implements AdapterSensor {

	private CpuUtilizationSensor cus;
	private double value;
	private String status;
	private String title;

	public CPUSensor() {
		cus = new CpuUtilizationSensor();
		value = cus.readValue();
		status = cus.getReport();
		title = cus.getAlertName();
	}

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getStatusMessage() {
		return status + " --> " + String.valueOf(value);
	}

	@Override
	public Color getBarColor() {
		Color barColor = Color.GREEN;		
		if (status.equals("DANGER")) {
			barColor = Color.RED;
		} else if (status.equals("CRITICAL")) {
			barColor = Color.YELLOW;
		}
		return barColor;
	}

	@Override
	public int getDangerBarValue() {
		return 90;
	}

}