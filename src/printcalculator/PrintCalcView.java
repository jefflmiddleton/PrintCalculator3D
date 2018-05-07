/*
 *  Jeff Middleton
 *  JeffLMiddleton@gmail.com
 *  Created  2018
 */

package printcalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Jeff Middleton
 */
public final class PrintCalcView {

    private final JFrame frame;

    public JRadioButton scale38, scale14, scale12, scale1;
    public JTextField modelWidth = new JTextField("Scale Width", 15);
    public JTextField modelHeight = new JTextField("Scale Height", 15);
    public JTextField modelLength = new JTextField("Scale Length", 15);
    public JButton calculateButton;
    public JButton saveButton;
    public JButton clearButton;

    private JTextField name = new JTextField(25);

    public JTextField widthText = new JTextField(25);
    public JTextField heightText = new JTextField(25);
    public JTextField lengthText = new JTextField(25);
    public JTextField filename = new JTextField(15);

    public JTextArea savedCalculations = new JTextArea(10, 35);

    public Label metricWidth = new Label("");
    public Label metricHeight = new Label("");
    public Label metricLength = new Label("");

    public JPanel pan = new JPanel();
    public JPanel pane = new JPanel();
    public Label labelScale = new Label("Scale: ");

    public Border border = BorderFactory.createLineBorder(Color.RED, 1);
    public Border defaultBorder = BorderFactory.createLineBorder(Color.white);

    public boolean validInput = false;
    public boolean HEADER = true;
    public Color inchesBackground = new Color(149, 164, 188);
    public Color textBackground = new Color(191, 201, 217);
    public Color metricBackground = new Color(118, 137, 169);

    public PrintCalcView(String text) {
        frame = new JFrame(text);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        addComponentsToPane(frame);
        frame.pack();
        frame.setVisible(true);
        setBackgroundColors();

    }

    public void clearTable() {
        savedCalculations.setText("");
        filename.setText("");
        name.setText("");
        widthText.setText("");
        heightText.setText("");
        lengthText.setText("");
        modelWidth.setText("");
        modelHeight.setText("");
        modelLength.setText("");
        metricWidth.setText("");
        metricHeight.setText("");
        metricLength.setText("");
        scale14.setSelected(false);
        scale38.setSelected(false);
        scale12.setSelected(false);
        scale1.setSelected(false);
    }

    public void addComponentsToPane(Container cpane) {

        scale14 = new JRadioButton("1/4 inch");
        scale38 = new JRadioButton("3/8 inch");
        scale12 = new JRadioButton("1/2 inch");
        scale1 = new JRadioButton("1 inch");

        modelWidth.setEditable(false);
        modelHeight.setEditable(false);
        modelLength.setEditable(false);
        savedCalculations.setEditable(false);

        ButtonGroup bscale = new ButtonGroup();
        bscale.add(scale14);
        bscale.add(scale38);
        bscale.add(scale12);
        bscale.add(scale1);

        pane.setOpaque(true);
        pane.setBackground(inchesBackground);
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        pane.setBorder(BorderFactory.createTitledBorder(blackBorder, "Measurement in Inches"));

        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        Label labelName = new Label("Name: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(labelName, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(name, c);

        Label labelWidth = new Label("Width: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        pane.add(labelWidth, c);

        c.gridx = 1;
        c.gridy = 1;
        pane.add(widthText, c);

        c.gridx = 2;
        c.gridy = 1;
        pane.add(modelWidth, c);

        Label labelHeight = new Label("Height: ");
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        pane.add(labelHeight, c);

        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 2;
        pane.add(heightText, c);

        c.gridx = 2;
        c.gridy = 2;
        pane.add(modelHeight, c);

        Label labelLength = new Label("Length: ");
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 3;
        pane.add(labelLength, c);

        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 3;
        pane.add(lengthText, c);

        c.gridx = 2;
        c.gridy = 3;
        pane.add(modelLength, c);

        FlowLayout fl = new FlowLayout();
        pan.setLayout(fl);

        fl.addLayoutComponent("Scale", labelScale);
        pan.add(labelScale, c);
        pan.add(scale14, c);
        pan.add(scale38, c);
        pan.add(scale12, c);
        pan.add(scale1, c);
        pane.add(pan);
        pan.setBackground(textBackground);

        calculateButton = new JButton("Calculate");
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 5;
        pane.add(calculateButton, c);

        JPanel metricPanel = new JPanel();
        metricPanel.setOpaque(true);
        metricPanel.setBackground(metricBackground);
        metricPanel.setBorder(BorderFactory.createTitledBorder(blackBorder, "Metric Scale"));

        metricPanel.setLayout(new GridBagLayout());

        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 1;
        c.gridy = 7;
        metricPanel.add(metricWidth, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 8;
        metricPanel.add(metricHeight, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 9;
        metricPanel.add(metricLength, c);

        saveButton = new JButton("Save");
        saveButton.setEnabled(false);
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 11;
        metricPanel.add(saveButton, c);

        Label labelFile = new Label("File Name: ");
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 10;
        metricPanel.add(labelFile, c);

        c.weightx = 0.0;
        c.gridx = 1;
        c.gridy = 10;
        metricPanel.add(filename, c);

        clearButton = new JButton("Clear");
        clearButton.setEnabled(false);
        c.weightx = 0.0;
        c.gridx = 4;
        c.gridy = 11;
        metricPanel.add(clearButton, c);

        c.gridx = 1;
        c.gridy = 12;
        metricPanel.add(savedCalculations, c);

        JPanel cards = new JPanel(new BorderLayout(5, 5));
        cards.add(pane, BorderLayout.NORTH);
        cards.add(metricPanel, BorderLayout.SOUTH);
        cpane.add(cards);
    }

    public JTextField getName() {
        return name;
    }

    private void setBackgroundColors() {
        widthText.setBackground(textBackground);
        lengthText.setBackground(textBackground);
        heightText.setBackground(textBackground);
        name.setBackground(textBackground);
        modelWidth.setBackground(textBackground);
        modelHeight.setBackground(textBackground);
        modelLength.setBackground(textBackground);
        filename.setBackground(textBackground);
        savedCalculations.setBackground(textBackground);
    }

}
