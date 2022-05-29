package org.example.beauticture.worker;

import java.awt.*;

public class TextStroke implements BrushStroke {

    private String text;
    private String fontName;
    private String colorCode;
    private int size;
    private int style;

    public TextStroke(String text, String fontName, String colorCode, int size, int style) {
        this.text = text;
        this.fontName = fontName;
        this.colorCode = colorCode;
        this.size = size;
        this.style = style;
    }

    @Override
    public void execute(Graphics2D graphics) {
        Font font = new Font(fontName, style, size);
        Color color = Color.decode(colorCode);
        graphics.setFont(font);
        graphics.setColor(color);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.drawString(text, 50, 250);
    }
}
