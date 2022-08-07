
import java.awt.Color;
import java.awt.Dimension;

public interface AdapterSensor {
	double getValue();
	String getTitle();
	String getStatusMessage();
	Color getBarColor();
	int getDangerBarValue();
}
