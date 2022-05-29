package org.example.beauticture.worker;

import org.example.beauticture.core.BeautyPictureWorker;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AwtWorker implements BeautyPictureWorker {

    private BufferedImage buffer;
    private List<BrushStroke> strokes;

    public AwtWorker(int width, int height) {
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        strokes = new ArrayList<>();
    }

    @Override
    public byte[] build() {
        Graphics2D graphics = buffer.createGraphics();
        strokes.stream().forEach(stroke -> stroke.execute(graphics));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(buffer, "png", out);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return out.toByteArray();
    }

    public void addBrush(BrushStroke brush) {
        this.strokes.add(brush);
    }
}
