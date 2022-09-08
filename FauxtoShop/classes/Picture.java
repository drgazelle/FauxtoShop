import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 * @author Ria Galanos (TJHSST), Doug Oberle (WTW)...
 */
public class Picture extends SimplePicture
{
///////////////////// constructors ///////////////////////////////////**
   /**
    * Constructor that takes no arguments
    */
   public Picture ()
   {
      /* not needed but use it to show the implicit call to super()
       * child constructors always call a parent constructor
       */
      super();
   }

   /**
    * Constructor that takes a file name and creates the picture
    * @param fileName the name of the file to create the picture from
    */
   public Picture(String fileName)
   {
      // let the parent class handle this fileName
      super(fileName);
   }

   /**
    * Constructor that takes the width and height
    * @param height the height of the desired picture
    * @param width the width of the desired picture
    */
   public Picture(int height, int width)
   {
      // let the parent class handle this width and height
      super(width,height);
   }

   /**
    * Constructor that takes a picture and creates a
    * copy of that picture
    * @param copyPicture the picture to copy
    */
   public Picture(Picture copyPicture)
   {
      // let the parent class do the copy
      super(copyPicture);
   }

   /**
    * Constructor that takes a buffered image
    * @param image the buffered image to use
    */
   public Picture(BufferedImage image)
   {
      super(image);
   }

////////////////////// methods ///////////////////////////////////////

   /**
    * Method to return the Picture from the Picture
    * @return the picture (this)
    */
   public Picture getPicture()
   {
      return this;
   }

   /**
    * Method to return a string with information about this picture.
    * @return a string with information about the picture such as fileName,
    * height and width.
    */
   public String toString()
   {
      String output = "Picture, filename " + getFileName() +
              " height " + getHeight()
              + " width " + getWidth();
      return output;
   }

   /**
    * Method to set the red to 0
    */
   public void zeroRed()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row < pixels.length; row++)
      {
         for(int col = 0; col < pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setRed(0);
         }
      }
   }

   /**
    * Method to set the green to 0
    */
   public void zeroGreen()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row < pixels.length; row++)
      {
         for(int col = 0; col < pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setGreen(0);
         }
      }
   }

   /**
    * Method to set the blue to 0
    */
   public void zeroBlue()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row < pixels.length; row++)
      {
         for(int col = 0; col < pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setBlue(0);
         }
      }
   }

   /**
    * Method to keep just the red
    */
   public void keepOnlyRed()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row < pixels.length; row++)
      {
         for(int col = 0; col < pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setGreen(0);
            pixelObj.setBlue(0);
         }
      }
   }

   /**
    * Method to keep just the green
    */
   public void keepOnlyGreen()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row < pixels.length; row++)
      {
         for(int col = 0; col < pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setRed(0);
            pixelObj.setBlue(0);
         }
      }
   }

   /**
    * Method to keep just the blue
    */
   public void keepOnlyBlue()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row < pixels.length; row++)
      {
         for(int col = 0; col < pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            pixelObj.setRed(0);
            pixelObj.setGreen(0);
         }
      }
   }

   /**
    * Method to modify red by some percentage parameter between 0% and 200%
    * modifyRed(100) nets no change, modifyRed(50) decreases the red to 50% of its original value
    * modifyRed(200) increases the red by 100%
    * @param x the percentage by which we want to modify the red pixels by
    */
   public void modifyRed(int x)
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col< pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            int r = pixelObj.getRed() * (x / 100);
            pixelObj.setRed(r);
         }
      }
   }

   /**
    * Method to modify green by some percentage parameter between 0% and 200%
    * modifyGreen(100) nets no change, modifyGreen(50) decreases the green to 50% of its original value
    * modifyGreen(200) increases the green by 100%
    * @param x the percentage by which we want to modify the blue pixels by
    *
    */
   public void modifyGreen(int x)
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col< pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            int g = pixelObj.getGreen() * (x / 100);
            pixelObj.setGreen(g);
         }
      }
   }

   /**
    * Method to modify blue by some percentage parameter between 0% and 200%
    * modifyBlue(100) nets no change, modifyBlue(50) decreases the blue to 50% of its original value
    * modifyBlue(200) increases the blue by 100%
    * @param x the percentage by which we want to modify the blue pixels by
    */
   public void modifyBlue(int x)
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col< pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            int b = pixelObj.getBlue() * (x / 100);
            pixelObj.setBlue(b);
         }
      }
   }

   /**
    * Method to place a rainbow filter over the picture
    */
   public void rainbowBar()
   {
      Pixel pixel = null;
      Pixel[][] pixels = this.getPixels2D();
      int numRows = pixels.length/6;
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col<pixels[row].length; col++)
         {
            pixel = pixels[row][col];
            //red orange yellow green blue purple
            if (row<numRows)//red
            {
               pixel.setRed((pixel.getRed()+255)/2);
            }
            else if (row<numRows*2)//orange
            {
               pixel.setRed((pixel.getRed()+255)/2);
               pixel.setGreen((pixel.getGreen()+127)/2);
               pixel.setBlue((pixel.getBlue()+44)/2);
            }
            else if (row<numRows*3)//yellow
            {
               pixel.setRed((pixel.getRed()+255)/2);
               pixel.setGreen((pixel.getGreen()+255)/2);
            }
            else if (row<numRows*4)//green
            {
               pixel.setGreen((pixel.getGreen()+255)/2);
            }
            else if (row<numRows*5)//blue
            {
               pixel.setBlue((pixel.getBlue()+255)/2);
            }
            else //purple
            {
               pixel.setRed((pixel.getRed()+143)/2);
               pixel.setBlue((pixel.getBlue()+255)/2);
            }
         }
      }
   }

   /**
    * Method to negate the picture - change the color of every pixel to its inverse
    *
    */
   public void negate()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col< pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            //calculates inverted colors
            int r = 255 - pixelObj.getRed();
            int g = 255 - pixelObj.getGreen();
            int b = 255 - pixelObj.getBlue();
            //sets new color
            pixelObj.setColor(new Color(r,g,b));
         }
      }
   }

   /**
    * Method to grayscale the picture - change every pixel to its equvalently bright or dark shade of gray
    */
   public void grayscale()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col< pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            //calculates grayscale colors
            int gr = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3;
            //sets new color
            pixelObj.setColor(new Color(gr,gr,gr));
         }
      }
   }

   /** Method that mirrors the picture around a
    * vertical mirror in the center of the picture
    * from left to right */
   public void mirrorVertical()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row < pixels.length; row++)
      {
         for(int col = 0; col < pixels[row].length / 2; col++)
         {
            //defines pixel variables
            Pixel mirrorR = pixels[row][pixels[row].length - col - 1];
            Pixel mirrorL = pixels[row][col];
            mirrorR.setColor(mirrorL.getColor());
         }
      }
   }

   /** Method that mirrors the picture around a
    * vertical mirror in the center of the picture
    * from right to left */
   public void mirrorVerticalRightToLeft()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row < pixels.length; row++)
      {
         for(int col = 0; col < pixels[row].length / 2; col++)
         {
            //defines pixel variables
            Pixel mirrorL = pixels[row][col];
            Pixel mirrorR = pixels[row][pixels[row].length - col - 1];
            mirrorL.setColor(mirrorR.getColor());
         }
      }
   }

   /** Method that mirrors the picture around a
    * horizontal mirror in the center of the picture
    * from top to bottom */
   public void mirrorHorizontal()
   {
      Pixel[][] pixels = this.getPixels2D();
      for (int row = 0; row < pixels.length / 2; row++) {
         for (int col = 0; col < pixels[row].length; col++) {

            //defines pixel variables
            Pixel mirrorT = pixels[row][col];
            Pixel mirrorB = pixels[pixels.length - row - 1][col];
            mirrorB.setColor(mirrorT.getColor());
         }
      }
   }

   /** Method that mirrors the picture around a
    * horizontal mirror in the center of the picture
    * from bottom to top */
   public void mirrorHorizontalBotToTop()
   {
      Pixel[][] pixels = this.getPixels2D();
      for (int row = 0; row < pixels.length / 2; row++) {
         for (int col = 0; col < pixels[row].length; col++) {
            //defines pixel variables
            Pixel mirrorT = pixels[row][col];
            Pixel mirrorB = pixels[pixels.length - row - 1][col];
            //sets color
            mirrorT.setColor(mirrorB.getColor());
         }
      }
   }

   /** Method that mirrors the picture around a
    * diagonal mirror from the upper-left corner
    * to the lower-right  */
   public void mirrorDiagonal()
   {
      Pixel[][] pixels = this.getPixels2D();
      int dist = pixels.length;
      if (pixels[0].length < dist) {
         dist = pixels[0].length;
      }
      for (int row = 0; row < dist; row++) {
         for (int col = 0; col < dist; col++) {
            //defines pixel variables
            Pixel mirrorT = pixels[row][col];
            Pixel mirrorB = pixels[col][row];
            //sets color
            mirrorT.setColor(mirrorB.getColor());
         }
      }
   }

   /** Method that mirrors the picture around a
    * diagonal mirror from the upper-right corner
    * to the lower-left  */
   public void mirrorDiagonalOpposite()
   {
      Pixel[][] pixels = this.getPixels2D();
      int dist = pixels.length;
      if (pixels[0].length < dist) {
         dist = pixels[0].length;
      }
      for (int row = 0; row < dist; row++) {
         for (int col = 0; col < dist; col++) {
            //defines pixel variables
            Pixel mirrorT = pixels[row][col];
            Pixel mirrorB = pixels[col][row];
            //sets color
            mirrorB.setColor(mirrorT.getColor());
         }
      }
   }

   /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
   public void copy(Picture fromPic, int startRow, int startCol)
   {
      Pixel fromPixel = null;
      Pixel toPixel = null;
      Pixel[][] toPixels = this.getPixels2D();
      Pixel[][] fromPixels = fromPic.getPixels2D();
      for (int fromRow = 0, toRow = startRow;
           fromRow < fromPixels.length &&
                   toRow < toPixels.length;
           fromRow++, toRow++)
      {
         for (int fromCol = 0, toCol = startCol;
              fromCol < fromPixels[0].length &&
                      toCol < toPixels[0].length;
              fromCol++, toCol++)
         {
            fromPixel = fromPixels[fromRow][fromCol];
            toPixel = toPixels[toRow][toCol];
            toPixel.setColor(fromPixel.getColor());
         }
      }
   }

   /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture to a specific location
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy
    * @param startCol the start col to copy
    * @param finRow the finish row to copy
    * @param finCol the finish col to copy
    * @param startToRow the start row location to copy to
    * @param startToCol the start col location to copy to
    */
   public void copySection(Picture fromPic, int startRow, int startCol,
                           int finRow, int finCol, int startToRow, int startToCol)
   {
      Pixel fromPixel=null;
      Pixel toPixel=null;
      Pixel[][] toPixels = this.getPixels2D();
      Pixel[][] fromPixels = fromPic.getPixels2D();
      for( int fromRow = startRow, toRow = startToRow; fromRow < (finRow)
              && toRow < toPixels.length; fromRow ++,toRow++)
      {
         for(int fromCol = startCol, toCol = startToCol; fromCol < finCol
                 &&  toCol < toPixels[0].length; fromCol++, toCol++)
         {
            fromPixel = fromPixels[fromRow][fromCol];
            toPixel = toPixels[toRow][toCol];
            toPixel.setColor(fromPixel.getColor());
         }
      }
   }

   /**
    * Method to sepia tone the picture
    */
   public void sepiatone()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++)
      {
         for(int col = 0; col< pixels[row].length; col++)
         {
            Pixel pixelObj = pixels[row][col];
            //gets rgb colors
            int r = pixelObj.getRed();
            int g = pixelObj.getGreen();
            int b = pixelObj.getBlue();
            //sets individual rgb values
            pixelObj.setRed((int) (0.393*r + 0.769*g + 0.189*b));
            pixelObj.setGreen((int) (0.349*r + 0.686*g + 0.168*b));
            pixelObj.setBlue((int) (0.272*r + 0.534*g + 0.131*b));
         }
      }
   }

   /** Method to show large changes in color
    * @param edgeDist the distance for finding edges
    */
   public void edgeDetection(int edgeDist)
   {
      Pixel[][] pixels = this.getPixels2D();
      for (int row = 1; row < pixels.length; row++) {
         for (int col = 0; col < pixels[row].length; col++) {
               //first pixel
               Pixel PixelObj = pixels[row - 1][col];
               //Second pixel for comparison
               Pixel tempPixel = pixels[row][col];
               // Compares color value is within margin of error.
               if (distance(PixelObj, tempPixel.getColor()) > edgeDist) {
                  //fails edge condition
                  PixelObj.setColor(Color.WHITE);
               }
               else {
                  //passes edge condition
                  PixelObj.setColor(Color.BLACK);
               }
         }
      }
   }

   /**
    * Method to pixelate the picture (low bit video game effect)
    * @param resolution the block size that we simulate for each pixel
    */
   public void pixelate(int resolution)
   {
      resolution = (int) Math.sqrt(resolution);
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row < pixels.length - 1; row += resolution) {
         for (int col = 0; col < pixels[row].length - 1; col += resolution) {
            //establish total color variables
            int rTotal = 0;
            int gTotal = 0;
            int bTotal = 0;
            //loops through surrounding pixel grid
            for (int x = 0; x < resolution; x++) {
               for (int y = 0; y < resolution; y++) {
                  Pixel tempPixel = pixels[row + x][col + y];
                  //adds to total color values
                  rTotal += tempPixel.getRed();
                  gTotal += tempPixel.getGreen();
                  bTotal += tempPixel.getBlue();
               }
            }
            //sets all pixel to average rgb values
            for (int x = 0; x < resolution; x++) {
               for (int y = 0; y < resolution; y++) {
                  Pixel pixelObj = pixels[row + x][col + y];
                  pixelObj.setRed(rTotal / 9);
                  pixelObj.setGreen(gTotal / 9);
                  pixelObj.setBlue(bTotal / 9);
               }
            }
         }
      }
   }

   /**
    * Method to blur the picture
    */
   public void blur()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 1; row< pixels.length - 1; row++)
      {
         for(int col = 1; col< pixels[row].length - 1; col++)
         {
            //establish total color variables
            int rTotal = 0;
            int gTotal = 0;
            int bTotal = 0;
            //loops through surrounding pixel grid
            for(int x = -1; x < 2; x++) {
               for (int y = -1; y < 2; y++) {
                  Pixel tempPixel = pixels[row + x][col + y];
                  //adds to total color values
                  rTotal += tempPixel.getRed();
                  gTotal += tempPixel.getGreen();
                  bTotal += tempPixel.getBlue();
               }
            }
            //sets center pixel to average rgb values
            Pixel pixelObj = pixels[row][col];
            pixelObj.setRed(rTotal / 9);
            pixelObj.setGreen(gTotal / 9);
            pixelObj.setBlue(bTotal / 9);
         }
      }
   }

   /**
    * Method to calculate the distance between two colors
    * @param p the pixel we want to find the color distance from
    * @param c the color we want to find the color distance from pixel
    * @return the color distance between p and c
    */
   public double distance(Pixel p, Color c)
   {

      return Math.sqrt( Math.pow ( Math.abs (p.getRed()-c.getRed() ),2 ) +
              Math.pow ( Math.abs (p.getGreen()-c.getGreen() ),2 ) +
              Math.pow ( Math.abs (p.getBlue()-c.getBlue() ),2 ) );
   }

   /**
    * Method to posterize the picture - reduce to only 3-4 colors of your choice
    */
   public void posterize()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 1; row < pixels.length - 1; row++) {
         for (int col = 1; col < pixels[row].length - 1; col++) {
            Pixel pixelObj = pixels[row][col];
            //sets pixel to the max of the greatest color

            if (pixelObj.getRed() > pixelObj.getBlue() && pixelObj.getRed() > pixelObj.getBlue()) {
               pixelObj.setColor(Color.red);
            }
            else if (pixelObj.getBlue() > pixelObj.getGreen() && pixelObj.getBlue() > pixelObj.getRed()) {
               pixelObj.setColor(Color.blue);
            }
            else if (pixelObj.getGreen() > pixelObj.getRed() && pixelObj.getGreen() > pixelObj.getBlue()) {
               pixelObj.setColor(Color.green);
            }
            else {
               pixelObj.setColor(Color.black);
            }
         }
      }
   }

   /**
    * Method for copying the no-green pixels from left side of a picture (with green background) to the right side
    */
   public void greenScreen()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row< pixels.length; row++) {
         for (int col = 0; col < pixels[row].length / 2; col++) {
            Pixel pixelObj = pixels[row][col];
            if (distance(pixelObj, Color.green) > 15) {
               Pixel mirrorR = pixels[row][pixels[row].length - col - 1];
               Pixel mirrorL = pixels[row][col];
               mirrorR.setColor(mirrorL.getColor());
            }
         }
      }
   }

   /**
    * Method to color splash a picture
    * Keeps any pixel close to Color c, but casts all other pixels to its gray-scale equivalent
    * @param c the color we want to keep
    */
   public void colorSplash(Color c)
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row < pixels.length; row++)
      {
         for(int col = 0; col < pixels[row].length; col++)
         {
            Pixel p = pixels[row][col];
            double maxP = 0.6;
            //sets color to grey if outside of color scope
            if (distance(p, c) > 75) {
               int gr = (p.getRed() + p.getGreen() + p.getBlue()) / 3;
               //sets new color
               p.setColor(new Color(gr,gr,gr));
            }
         }
      }
   }

   /** Hide a black and white message in the current
    * picture by changing the red to even and then
    * setting it to odd if the message pixel is black 
    * @param messagePict the picture with a message
    */
   public void encode(Picture messagePict)
   {
      Pixel[][] pixels = this.getPixels2D();
      Pixel[][] cypher = messagePict.getPixels2D();
      for(int row = 0; row < pixels.length; row++) {
         for (int col = 0; col < pixels[row].length; col++) {
            Pixel pixelObj = pixels[row][col];
            int pRed = pixelObj.getRed();
            //Sets r value to even including special cases
            if (pRed % 2 != 0) {
               if (pRed == 0) {
                  pixelObj.setRed(2);
               }
               else if (pRed == 255) {
                  pixelObj.setRed(254);
               }
               else {
                  pixelObj.setRed(pRed + 1);
               }
            }
            //checks if cypher is white
            if (cypher[row][col].getRed() < 50) {
               pixelObj.setRed(pixelObj.getRed() + 1);
            }
         }
      }
   }

   /**
    * Method to decode a message hidden in the
    * red value of the current picture
    * @return the picture with the hidden message (this)
    */
   public Picture decode()
   {
      Pixel[][] pixels = this.getPixels2D();
      for(int row = 0; row < pixels.length; row++) {
         for (int col = 0; col < pixels[row].length; col++) {
            Pixel pixelObj = pixels[row][col];
            // if pixel is even, set to white
            if (pixelObj.getRed() % 2 == 0) {
               pixelObj.setColor(Color.WHITE);
            }
            // else, set to black
            else {
               pixelObj.setColor(Color.BLACK);
            }
         }
      }
      return this;
   }

   public void dither() {
      grayscale();
      Pixel[][] pixels = this.getPixels2D();
      for(int x = 1; x < pixels.length - 1; x++) {
         for (int y = 0; y < pixels[x].length - 1; y++) {
            //finds grey value of original pixel
            int oldPixel = pixels[x][y].getRed();
            //determines if the pixel is closer to black or white
            int newPixel = 255;
            if (Math.round(oldPixel / 255) == 0.0) {
               newPixel = 0;
            }
            //sets pixel to the outcome
            pixels[x][y].setColor(toGrey(newPixel));
            //calculates the quantity error to be dispersed
            int quant_error = Math.abs(oldPixel - newPixel);
            //disperses error to surrounding pixels
            Color value;
            value = toGrey(pixels[x + 1][y].getRed() + quant_error * 7 / 16);
            pixels[x + 1][y].setColor(value);
            value = toGrey(pixels[x - 1][y + 1].getRed() + (quant_error * 3 / 16));
            pixels[x - 1][y + 1].setColor(value);
            value = toGrey(pixels[x][y + 1].getRed() + quant_error * 5 / 16);
            pixels[x][y + 1].setColor(value);
            value = toGrey(pixels[x + 1][y + 1].getRed() + quant_error * 1 / 16);
            pixels[x + 1][y + 1].setColor(value);
         }
      }
      //error checking to ensure all non-white pixels are turned to grey
      for(int x = 1; x < pixels.length - 1; x++) {
         for (int y = 0; y < pixels[x].length - 1; y++) {
            if(pixels[x][y].getRed() < 255 && pixels[x][y].getRed() > 0) {
               //dither();
               pixels[x][y].setColor(Color.black);
            }
         }
      }
   }

   private Color toGrey(int value) {
      if (value < 0) {
         value = 0;
      }
      if (value > 255) {
         value = 255;
      }
      return new Color(value, value, value);
   }

   /**
    * Main method for testing - each class in Java can have a main method
    * @param args 'cause, you know...we need this
    */
   public static void main(String[] args)
   {
      //Picture pix = new Picture(); // rg - this doesn't open a picture
      Picture pix = new Picture("640x480.jpg"); //- rg this explores the 640x480 in the images directory
      pix.explore();
   }

}
