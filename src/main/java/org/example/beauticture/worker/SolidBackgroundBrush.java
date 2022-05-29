package org.example.beauticture.worker;

import java.awt.*;

public class SolidBackgroundBrush implements BrushStroke {

    private String colorCode;
    private int width;
    private int height;

    public SolidBackgroundBrush(String colorCode, int width, int height) {
        this.colorCode = colorCode;
        this.width = width;
        this.height = height;
    }

    @Override
    public void execute(Graphics2D graphics) {
        Color color = Color.decode(colorCode);
        graphics.setColor(color);
        graphics.fillRect(0, 0, width, height);
    }
}
