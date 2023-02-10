package com.mycompany.paint;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Paint {

    public static int getIntFromColor(int red, int green, int blue) {
        red = (red << 16) & 0x00FF0000;
        green = (green << 8) & 0x0000FF00;
        blue = blue & 0x000000FF;
        return 0xFF000000 | red | green | blue;
    }

    public static void filling(BufferedImage image, int x, int y,
                               int origColor, int newColor) {
        if (x + 1 < image.getWidth() && image.getRGB(x + 1, y) == origColor) {
            image.setRGB(x + 1, y, newColor);
            filling(image, x + 1, y, origColor, newColor);
        }
        if (x - 1 >= 0 && image.getRGB(x - 1, y) == origColor) {
            image.setRGB(x - 1, y, newColor);
            filling(image, x - 1, y, origColor, newColor);
        }
        if (y + 1 < image.getHeight() && image.getRGB(x, y + 1) == origColor) {
            image.setRGB(x, y + 1, newColor);
            filling(image, x, y + 1, origColor, newColor);
        }
        if (y - 1 >= 0 && image.getRGB(x, y - 1) == origColor) {
            image.setRGB(x, y - 1, newColor);
            filling(image, x, y - 1, origColor, newColor);
        }
    }

    public static void main(String[] args) {
        String filepath = "C:\\Users\\user\\Desktop\\image.png";
        try {
            BufferedImage img = ImageIO.read(new File(filepath));
            int width = img.getWidth();
            int height = img.getHeight();
            System.out.println(width + " " + height);
            int x = 65; //136
            int y = 45; //90
            int baseColor = img.getRGB(x, y);
            int newColor = getIntFromColor(255, 255, 0);
            img.setRGB(x, y, newColor);
            filling(img, x, y, baseColor, newColor);
            ImageIO.write(img, "png", new File(filepath));
        } catch (IOException e) {
            System.out.println("File is not found");
        }
    }
}
