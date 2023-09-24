import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ColorAdjuster extends JFrame {

    private JSlider sliderRed, sliderGreen, sliderBlue, sliderOpacity;
    private JLabel colorTextLabel;

    public ColorAdjuster() {
        setTitle("Color Adjuster");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        // Sliders
        sliderRed = createSlider("Red");
        sliderGreen = createSlider("Green");
        sliderBlue = createSlider("Blue");
        sliderOpacity = createSlider("Opacity");

        colorTextLabel = new JLabel("COLOR TEXT", SwingConstants.CENTER);
        colorTextLabel.setFont(new Font("Arial", Font.BOLD, 24));
        updateTextColor();

        add(sliderRed);
        add(sliderGreen);
        add(sliderBlue);
        add(sliderOpacity);
        add(colorTextLabel);

        // Add listeners to sliders
        ChangeListener listener = (e) -> updateTextColor();
        sliderRed.addChangeListener(listener);
        sliderGreen.addChangeListener(listener);
        sliderBlue.addChangeListener(listener);
        sliderOpacity.addChangeListener(listener);

        setVisible(true);
    }

    private JSlider createSlider(String title) {
        JSlider slider = new JSlider(0, 255, 255);
        slider.setBorder(BorderFactory.createTitledBorder(title));
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        return slider;
    }

    private void updateTextColor() {
        int r = sliderRed.getValue();
        int g = sliderGreen.getValue();
        int b = sliderBlue.getValue();
        int opacity = sliderOpacity.getValue();
        Color color = new Color(r, g, b, opacity);
        colorTextLabel.setForeground(color);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ColorAdjuster());
    }
}