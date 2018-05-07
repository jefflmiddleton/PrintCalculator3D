/*
 *  Jeff Middleton
 *  JeffLMiddleton@gmail.com
 *  Created  2018
 */

package printcalculator;

/**
 *
 * @author Jeff Middleton
 */
public class PrintCalcModel {

    private Float width;

    private Float height;
    private Float length;

    private Float scaleWidth;
    private Float scaleHeight;
    private Float scaleLength;

    private Float metricWidth;
    private Float metricHeight;
    private Float metricLength;

    public Float scale = new Float(0);

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getScaleWidth() {
        return scaleWidth;
    }

    public void setScaleWidth(Float scaleWidth) {
        this.scaleWidth = scaleWidth;
    }

    public Float getScaleHeight() {
        return scaleHeight;
    }

    public void setScaleHeight(Float scaleHeight) {
        this.scaleHeight = scaleHeight;
    }

    public Float getScaleLength() {
        return scaleLength;
    }

    public void setScaleLength(Float scaleLength) {
        this.scaleLength = scaleLength;
    }

    public Float getMetricWidth() {
        return metricWidth;
    }

    public void setMetricWidth(Float metricWidth) {
        this.metricWidth = metricWidth;
    }

    public Float getMetricHeight() {
        return metricHeight;
    }

    public void setMetricHeight(Float metricHeight) {
        this.metricHeight = metricHeight;
    }

    public Float getMetricLength() {
        return metricLength;
    }

    public void setMetricLength(Float metricLength) {
        this.metricLength = metricLength;
    }

    public Float getScale() {
        return scale;
    }

    public void setScale(Float scale) {
        this.scale = scale;
    }

}
