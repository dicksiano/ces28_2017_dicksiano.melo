package model;

import java.util.Vector;

public class XPlusOne implements InterpolationMethod {
	public double calculateResult(double t, Vector<Double> xx, Vector<Double> yy) {
		return t + 1;
	}
}
