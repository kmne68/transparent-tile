/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transparenttile;

/**
 *
 * @author Keith
 */
    
//***********************************************************
// Title: TileSplitter
// Author: Keith Emery
// Contributors: Zach Best, Scott Rieger, Aaron Zeitler
// Date of last change: 2/19/08
// Description: Splits a composite tile image into individual tiles, filter the magenta background to transparent
//************************************************************




import java.awt.*;
import java.awt.image.*; // for using images
import javax.imageio.*; // for the BufferedImage class and its methods
import java.io.*; // supports input and output
import javax.swing.*;	// for display
import java.awt.image.ColorModel;


class TileSplitter
{
	BufferedImage input, output, testImage, testOut; 	// create a variable of the BufferedImage type to hold our image
//	BufferedImage[] testArray;							// used for testing the code early on
	BufferedImage[][] tileArray;						// double array to hold the individual tile images
	int imageWidth=0, imageHeight=0;					// variables to hold the width and height of the image

	public void LoadImage()								// method to load the image for manipulation

	{
		try
		{
			input = ImageIO.read(new File("c:\\java\\images\\curses.png")); // assigning the image to the variable "input"
			imageWidth = input.getWidth();									// determine the image's width for use in the loops
			imageHeight = input.getHeight();								// determine the image's height for use in the loops
		}
		catch(Exception e)
		{
			System.out.println(e.toString()); // minimal error handling, add more later to alert user if image fails to load
		}
	}

	public void ShowImage(BufferedImage test) // method to show a SubImage of "input", used for testing
	{
		try
		{
			BufferedImage output = test;							// Establish a BI variable "output" and assign to it the value "test" passed to it from main
			File fo = new File("C:\\java\\images\\newimages101.png"); // create a new File object "fo" with the given file name
			ImageIO.write(output,"PNG",fo); 						// The subimage is written to the file object "fo" and is converted from .bmp to .png.
			}
		catch (IOException e) 			// minimal error handling, add more later
		{
		}
	}

	public BufferedImage SaveImage() // method to capture and save an array of SubImages of the "input" image, returns a single BI object for testing
	{
		int x = 0, y = 0, w = 8, h = 12;	// variables to hold the x, y, w and h values. x and y tell the program where subimage begins, w = width, h = height
	//	testArray = new BufferedImage[imageWidth/8];		used for code testing
		tileArray = new BufferedImage[imageHeight/12][imageWidth/8];	// new double array to hold the subimages, the number of elements in each array is determined by the main image's length and width
		System.out.println("The image width is " + imageWidth);			// text output to check the width value
		System.out.println("The image length is " + imageHeight);		// text output to check the height value

		try
		{
			for (int j = 0; j < imageHeight/12; j = j + 1)		// outer loop increments the row (y) location
			{
				x = 0;											// reset the x counter to 0 for each row of tiles
				for (int i = 0; i < imageWidth/8; i = i + 1)	// inner loop increments the column (x) location
				{
					tileArray[j][i] = input.getSubimage(x,y,w,h);	// assigns successive subimages to the tile array
					System.out.println("x i " + x);					// text output to check the value of x as the program executes
					x = x + 8;										// increment x to step to the next tile image
				}
				y = y + 12;		// increment y to step to the next row of tiles
			}
			return testImage = tileArray[3][3];				// outputs a single image from the array for test purposes
			}
		finally{}
		}

	  public Image MakeColorTransparent (BufferedImage im, final Color color)	// Accepts a BI object and a color to filter to transparent, returns an Image object
	  {
	    ImageFilter filter = new RGBImageFilter()		// Initialize the filter object
	    {
	    	// the color we want to replace... Alpha bits are set to opaque
	    	// the first two digits after the "x" are the alpha bits, the second two are red, the next two are green and the last two are blue
	    	// getRGB gets the rgb code for the target color in integer form, this is the color we will make transparent
	    	public int markerRGB = color.getRGB() | 0xFF000000;		// changed from 0xFF000000. FF00FF00 turns magenta to clear
	    	// int transparentColor = 0xFF00FF;
	    	public int filterRGB(int x, int y, int rgb)		// use the filterRGB method to apply the rgb filter to the image
	    	{
	    		if ( ( rgb | 0xFF000000 ) == markerRGB )		// go through the image pixel by pixel to determine if the pixel needs to be made transparent
	    		{
	    			return 0x00FFFFFF & rgb;					// Mark the alpha bits as zero - transparent, leave other bits alone
	    		}
	    		else
	    		{
	    			return rgb;									// if the target color is not found, do nothing to that pixel
	    		}
	        }
	    };
	    ImageProducer ip = new FilteredImageSource(im.getSource(), filter);

	    return Toolkit.getDefaultToolkit().createImage(ip);				// need to learn more about this, part of Swing I believe
	  }

//	 This method returns true if the specified image has transparent pixels
	    public static boolean hasAlpha(Image image) {
	        // If buffered image, the color model is readily available
	        if (image instanceof BufferedImage) {
	            BufferedImage bimage = (BufferedImage)image;
	            return bimage.getColorModel().hasAlpha();
	        }

	        // Use a pixel grabber to retrieve the image's color model;
	        // grabbing a single pixel is usually sufficient
	         PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
	        try {
	            pg.grabPixels();
	        } catch (InterruptedException e) {
	        }

	        // Get the image's color model
	        ColorModel cm = pg.getColorModel();
	        System.out.println("the color model of the image is " + cm);		// print the pixel model for testing purposes
	        return cm.hasAlpha();
	    }

	    // Convert an Image object to a BufferedImage so that BI methods can be applied to it
	    public static BufferedImage imageToBufferedImage(Image im)
	    {
	       BufferedImage bi = new BufferedImage(im.getWidth(null),im.getHeight(null),BufferedImage.TYPE_INT_RGB);
	       Graphics bg = bi.getGraphics();
	       bg.drawImage(im, 0, 0, null);
	       bg.dispose();
	       return bi;
	    }

	    public static BufferedImage toBufferedImage(Image image) {
	        if (image instanceof BufferedImage) {
	            return (BufferedImage)image;
	        }

	        // This code ensures that all the pixels in the image are loaded
	        image = new ImageIcon(image).getImage();

	        // Determine if the image has transparent pixels; for this method's
	        // implementation, see e661 Determining If an Image Has Transparent Pixels
	        boolean hasAlpha = hasAlpha(image);

	        // Create a buffered image with a format that's compatible with the screen
	        BufferedImage bimage = null;
	        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	        try {
	            // Determine the type of transparency of the new buffered image
	            int transparency = Transparency.OPAQUE;
	            if (hasAlpha) {
	                transparency = Transparency.BITMASK;
	            }

	            // Create the buffered image
	            GraphicsDevice gs = ge.getDefaultScreenDevice();
	            GraphicsConfiguration gc = gs.getDefaultConfiguration();
	            bimage = gc.createCompatibleImage(
	                image.getWidth(null), image.getHeight(null), transparency);
	            System.out.println("image height is " + image.getHeight(null) + " and width is " + image.getWidth(null));
	            System.out.println("image has alpha true or false: " + hasAlpha(image) );
	        } catch (HeadlessException e) {
	            // The system does not have a screen
	        }

	        if (bimage == null) {
	            // Create a buffered image using the default color model
	            int type = BufferedImage.TYPE_INT_RGB;
	            if (hasAlpha) {
	                type = BufferedImage.TYPE_INT_ARGB;

	            }
	            bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
	        }

	        // Copy image to buffered image
	        Graphics g = bimage.createGraphics();

	        // Paint the image onto the buffered image
	        g.drawImage(image, 0, 0, null);
	        g.dispose();

	        return bimage;
	    }


	public static void main(String args[]) // the main method, calls our class methods to do their thing
	{
		BufferedImage testOut = null;			// create a BI object to receive a test image
		Image filteredImage = null;
		BufferedImage newbuff = null;
		TileSplitter fout; 						// declare a variable "fout" of type TileSplitter on which our methods can act
		fout = new TileSplitter();				// establish fout as a new instance of TileSplitter.
		fout.LoadImage(); 						// call the class method "LoadImage" on fout--to load the image
		testOut = fout.SaveImage(); 			// call the class method "SaveImage" on fout--to capture and save the SubImage
		// fout.ShowImage(testOut);

		filteredImage = fout.MakeColorTransparent(testOut, Color.magenta); //new Color(0).blue);
		newbuff = toBufferedImage(filteredImage);

		  fout.ShowImage(newbuff);				// pass the BI object "newbuff" to the method ShowImage--saves the subimage to a tile for output testing.
	}
}
