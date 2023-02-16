package com.mycompany.paint;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

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
        try {
            JFileChooser filepath = new JFileChooser();
            int path = filepath.showDialog(null, "File");
            if (path == JFileChooser.APPROVE_OPTION) {
                File file = filepath.getSelectedFile();
                BufferedImage img = ImageIO.read(file);
                int width = img.getWidth() - 1;
                int height = img.getHeight() - 1;
                System.out.println("Параметры изображения: " + width + "x" + height);
                System.out.print("Введите x y: ");
                Scanner input = new Scanner(System.in);
                int x = input.nextInt();
                int y = input.nextInt();
                if (x <= width & y <= height) {
                    int baseColor = img.getRGB(x, y);
                    System.out.print("Введите r g b: ");
                    int r = input.nextInt();
                    int g = input.nextInt();
                    int b = input.nextInt();
                    int newColor = getIntFromColor(r, g, b);
                    img.setRGB(x, y, newColor);
                    filling(img, x, y, baseColor, newColor);
                    ImageIO.write(img, "png", file);
                } else {
                    System.out.println("'x' or 'y' out of bounds");
                }
            }
        } catch (IOException e) {
            System.out.println("File is not found");
        }
    }
}
