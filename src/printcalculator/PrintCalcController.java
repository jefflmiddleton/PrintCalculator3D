/*
 *  Jeff Middleton
 *  JeffLMiddleton@gmail.com
 *  Created  2018
 */

package printcalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 *
 * @author Jeff Middleton
 */
public class PrintCalcController {

    private final PrintCalcModel model;
    private final PrintCalcView view;
    public ActionListener actionListener;

    public PrintCalcController(PrintCalcModel model, PrintCalcView view) {
        this.model = model;
        this.view = view;

    }

    public void control() {
        if(view == null)
            return;
        
        actionListener = (ActionEvent e) -> {
            Object source = e.getSource();
            if (source == view.scale14) {
                model.setScale(new Float(.25));
            }
            if (source == view.scale38) {
                model.setScale(new Float(.375));
            }
            if (source == view.scale12) {
                model.setScale(new Float(.5));
            }
            if (source == view.scale1) {
                model.setScale(new Float(1));
            }
            if (source == view.calculateButton) {
                highlightErrors();
            }
            if (source == view.saveButton) {
                saveToFileAndTable();
            }
            if (source == view.clearButton) {
                view.clearTable();
            }
        };
        view.calculateButton.addActionListener(actionListener);
        view.saveButton.addActionListener(actionListener);
        view.clearButton.addActionListener(actionListener);

        view.widthText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                checkNumber(evt);
            }
        });
        view.heightText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                checkNumber(evt);
            }
        });
        view.lengthText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                checkNumber(evt);
            }
        });
        view.filename.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                if (view.filename.getText().length() > 0 && view.validInput) {
                    view.clearButton.setEnabled(true);
                    view.saveButton.setEnabled(true);
                }
            }
        });
        view.scale14.addActionListener(actionListener);
        view.scale38.addActionListener(actionListener);
        view.scale12.addActionListener(actionListener);
        view.scale1.addActionListener(actionListener);

    }

    public void highlightErrors() {

        if (model == null || view == null) {
            return;
        }

        if (model.getScale() == 0) {
            view.pan.setBorder(view.border);
        } else {
            view.pan.setBorder(view.defaultBorder);
        }
        if (view.widthText.getText().length() < 1) {
            view.widthText.setBorder(view.border);
        } else {
            view.widthText.setBorder(view.defaultBorder);
        }
        if (view.heightText.getText().length() < 1) {
            view.heightText.setBorder(view.border);
        } else {
            view.heightText.setBorder(view.defaultBorder);
        }
        if (view.lengthText.getText().length() < 1) {
            view.lengthText.setBorder(view.border);
        } else {
            view.lengthText.setBorder(view.defaultBorder);
        }

        if (!model.getScale().equals(0) 
                && view.widthText.getText().length() > 0 
                && view.heightText.getText().length() > 0 
                && view.lengthText.getText().length() > 0) {
            view.validInput = true;
        }
        if (view.validInput) {
            calculateScale();
            view.metricWidth.setText(model.getMetricWidth().toString());
            view.metricHeight.setText(model.getMetricHeight().toString());
            view.metricLength.setText(model.getMetricLength().toString());
            view.modelWidth.setText(model.getScaleWidth().toString());
            view.modelHeight.setText(model.getScaleHeight().toString());
            view.modelLength.setText(model.getScaleLength().toString());
        }

    }

    public void calculateScale() {

        if(view == null || model == null)
            return;
        // Metric conversion factor
        Float metricScale = new Float(25.4);
        
        // Convert inches to feet
        Float w = new Float(view.widthText.getText()) / 12;
        Float h = new Float(view.heightText.getText()) / 12;
        Float l = new Float(view.lengthText.getText()) / 12;

        model.setWidth(new Float(view.widthText.getText()));
        model.setHeight(new Float(view.heightText.getText()));
        model.setLength(new Float(view.lengthText.getText()));

        model.setScaleWidth(w * model.getScale());
        model.setScaleHeight(h * model.getScale());
        model.setScaleLength(l * model.getScale());

        model.setMetricWidth(model.getScaleWidth() * metricScale);
        model.setMetricHeight(model.getScaleHeight() * metricScale);
        model.setMetricLength(model.getScaleLength() * metricScale);

        view.modelWidth.setText(model.getScaleWidth().toString());
        view.modelHeight.setText(model.getScaleHeight().toString());
        view.modelLength.setText(model.getScaleLength().toString());

        view.metricWidth.setText(model.getMetricWidth().toString());
        view.metricHeight.setText(model.getMetricHeight().toString());
        view.metricLength.setText(model.getMetricLength().toString());

    }

    @SuppressWarnings({"CallToPrintStackTrace", "null"})
    private void saveToFileAndTable() {
        if (view.filename.getText().trim().length() < 1) {
            view.filename.setBorder(view.border);
            return;
        } else {
            view.filename.setBorder(view.defaultBorder);
        }

        if (view.HEADER) {
            String header = "Name               Width               Height              Length\n";
            view.savedCalculations.append(header);
            view.HEADER = false;
        }
        String tabValue = "            ";
        view.savedCalculations.append(view.getName().getText());
        view.savedCalculations.append(tabValue);
        view.savedCalculations.append(view.metricWidth.getText());
        view.savedCalculations.append(tabValue);
        view.savedCalculations.append(view.metricHeight.getText());
        view.savedCalculations.append(tabValue);
        view.savedCalculations.append(view.metricLength.getText());
        view.savedCalculations.append("\n");
        tabValue = view.savedCalculations.getText();

        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(view.filename.getText() + ".txt"), "utf-8"));
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }

        try {
            writer.write(tabValue);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    public void checkNumber(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE
                || c == KeyEvent.VK_DELETE || c == '.')) {
            evt.consume();
        }

    }

}
