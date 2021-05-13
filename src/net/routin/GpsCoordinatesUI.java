package net.routin;


import net.routin.Models.Coordinates;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.util.List;

public class GpsCoordinatesUI {
    private JPanel panel;
    private JLabel titleText;
    private JLabel placeText;
    private JTextField place;
    private JButton find;
    private JLabel resultText;
    private JTextField latitude;
    private JTextField longitude;
    private JLabel credits;
    private JLabel latitudeText;
    private JLabel longitudeText;
    private JButton copy;
    private JLabel listText;
    private JList<String> list;
    private List<Coordinates> coordinates;
    private DefaultListModel<String> listModel;
    private GpsCoordinates gpsCoordinates;

    /**
     * Constructor of the application UI.
     */
    public GpsCoordinatesUI() {
        gpsCoordinates = new GpsCoordinates();
        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    coordinates = gpsCoordinates.getGpsCoordinates(place.getText());
                    listModel = new DefaultListModel<>();
                    for (Coordinates coordinate : coordinates) {
                        listModel.addElement(coordinate.getDisplay_name());
                    }
                    list.setModel(listModel);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection(latitude.getText() + " " + longitude.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        });

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int index = list.locationToIndex(e.getPoint());
                if (index > -1) {
                    latitude.setText(coordinates.get(index).getLat());
                    longitude.setText(coordinates.get(index).getLon());
                }
            }
        });
    }

    /**
     * Main method of the program.
     * @param args Arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("GPS Coordinates");
        frame.setContentPane(new GpsCoordinatesUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}