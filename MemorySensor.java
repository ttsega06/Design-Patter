

import java.awt.Color;
import java.awt.Dimension;

import libs.CpuUtilizationSensor;
import libs.DeskUsageSensor;
import libs.MemoryUsageSensor;

public class MemorySensor implements AdapterSensor {

	private MemoryUsageSensor sensor;
	private double value;
	private String status;
	private String title;

	public MemorySensor() {
		sensor = new MemoryUsageSensor();
		value = sensor.readValue();
		status = sensor.getReport();
		title = sensor.getAlertName();
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
		return 13;
	}

}

