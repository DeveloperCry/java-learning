/**
 * 
 */
package third.example.tess4j;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.sun.jna.Pointer;

import net.sourceforge.tess4j.ITessAPI.TessBaseAPI;
import net.sourceforge.tess4j.ITessAPI.TessPageSegMode;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.TessAPI1;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageIOHelper;
import net.sourceforge.tess4j.util.LoadLibs;

/**
 * @author Xiong.Liu
 *
 */
public class TesseractExample {

	private static String language = "eng";
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		File imageFile = new File("C:\\Users\\Xiong.Liu\\Desktop\\tt.png");
        /*ITesseract instance = new Tesseract();  // JNA Interface Mapping
//         ITesseract instance = new Tesseract1(); // JNA Direct Mapping
        System.out.println(new File(System.getenv("TESSDATA_PREFIX"),"./tessdata/eng.traineddata").exists());
        File tessDataFolder = LoadLibs.extractTessResources("tessdata"); // Maven build only; only English data bundled
        instance.setDatapath(tessDataFolder.getAbsolutePath());
//        final String destDir = "C:\\Users\\Xiong.Liu\\Desktop\\tmp";
//        cleanImage(imageFile, destDir);
//        Thread.sleep(1000);
//        File tagertFile = new File(destDir + "\\tt.png");
        try {
        	List<String> configs = new ArrayList<>();
        	configs.add("txt");
        	instance.setConfigs(configs);
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }*/

		
		testTessBaseAPIRect(imageFile);
		testTessBaseAPIGetUTF8Text(imageFile);
	}
	
	public static void testTessBaseAPIRect(File imageFile) throws IOException {
        BufferedImage image = ImageIO.read(imageFile); // require jai-imageio lib to read TIFF
        ByteBuffer buf = ImageIOHelper.convertImageData(image);
        int bpp = image.getColorModel().getPixelSize();
        int bytespp = bpp / 8;
        int bytespl = (int) Math.ceil(image.getWidth() * bpp / 8.0);
        
        TessBaseAPI handle = TessAPI1.TessBaseAPICreate();
        File tessDataFolder = LoadLibs.extractTessResources("tessdata");
        TessAPI1.TessBaseAPIInit3(handle, tessDataFolder.getAbsolutePath(), language);
        TessAPI1.TessBaseAPISetPageSegMode(handle, TessPageSegMode.PSM_AUTO);
        Pointer utf8Text = TessAPI1.TessBaseAPIRect(handle, buf, bytespp, bytespl, 0, 0, image.getWidth(), image.getHeight());
        String result = utf8Text.getString(0);
        TessAPI1.TessDeleteText(utf8Text);
        System.out.println(result);
	}
	
	public static void testTessBaseAPIGetUTF8Text(File imageFile) throws Exception {
        BufferedImage image = ImageIO.read(new FileInputStream(imageFile)); // require jai-imageio lib to read TIFF
        ByteBuffer buf = ImageIOHelper.convertImageData(image);
        int bpp = image.getColorModel().getPixelSize();
        int bytespp = bpp / 8;
        int bytespl = (int) Math.ceil(image.getWidth() * bpp / 8.0);
        
        TessBaseAPI handle = TessAPI1.TessBaseAPICreate();
        File tessDataFolder = LoadLibs.extractTessResources("tessdata");
        
        TessAPI1.TessBaseAPIInit3(handle, tessDataFolder.getAbsolutePath(), language);
        TessAPI1.TessBaseAPISetPageSegMode(handle, TessPageSegMode.PSM_AUTO);
        TessAPI1.TessBaseAPISetImage(handle, buf, image.getWidth(), image.getHeight(), bytespp, bytespl);
        TessAPI1.TessBaseAPISetRectangle(handle, 0, 0, 1024, 800);
        Pointer utf8Text = TessAPI1.TessBaseAPIGetUTF8Text(handle);
        String result = utf8Text.getString(0);
        TessAPI1.TessDeleteText(utf8Text);
        System.out.println(result);
    }
	
	//https://github.com/nguyenq/tess4j/blob/master/src/test/java/net/sourceforge/tess4j/TessAPI1Test.java#L465
	
	
	 public static void cleanImage(File sfile, String destDir) throws IOException  
	    {  
	        File destF = new File(destDir);  
	        if (!destF.exists())  
	        {  
	            destF.mkdirs();  
	        }  
	  
	        BufferedImage bufferedImage = ImageIO.read(sfile);  
	        int h = bufferedImage.getHeight();  
	        int w = bufferedImage.getWidth();  
	  
	        int[][] gray = new int[w][h];  
	        for (int x = 0; x < w; x++)  
	        {  
	            for (int y = 0; y < h; y++)  
	            {  
	                int argb = bufferedImage.getRGB(x, y);  
	                int r = (int) (((argb >> 16) & 0xFF) * 1.1 + 30);  
	                int g = (int) (((argb >> 8) & 0xFF) * 1.1 + 30);  
	                int b = (int) (((argb >> 0) & 0xFF) * 1.1 + 30);  
	                if (r >= 255)  
	                {  
	                    r = 255;  
	                }  
	                if (g >= 255)  
	                {  
	                    g = 255;  
	                }  
	                if (b >= 255)  
	                {  
	                    b = 255;  
	                }  
	                gray[x][y] = (int) Math  
	                        .pow((Math.pow(r, 2.2) * 0.2973 + Math.pow(g, 2.2)  
	                                * 0.6274 + Math.pow(b, 2.2) * 0.0753), 1 / 2.2);  
	            }  
	        }  
	  
	        int threshold = ostu(gray, w, h);  
	        BufferedImage binaryBufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_BINARY);  
	        for (int x = 0; x < w; x++)  
	        {  
	            for (int y = 0; y < h; y++)  
	            {  
	                if (gray[x][y] > threshold)  
	                {  
	                    gray[x][y] |= 0x00FFFF;  
	                } else  
	                {  
	                    gray[x][y] &= 0xFF0000;  
	                }  
	                binaryBufferedImage.setRGB(x, y, gray[x][y]);  
	            }  
	        }  
	  
	        for (int y = 0; y < h; y++)  
	        {  
	            for (int x = 0; x < w; x++)  
	            {  
	                if (isBlack(binaryBufferedImage.getRGB(x, y)))  
	                {  
	                    System.out.print("*");  
	                } else  
	                {  
	                    System.out.print(" ");  
	                }  
	            }  
	            System.out.println();  
	        }  
	  
	        ImageIO.write(binaryBufferedImage, "png", new File(destDir, sfile  
	                .getName()));  
	    }  
	  
	    public static boolean isBlack(int colorInt)  
	    {  
	        Color color = new Color(colorInt);  
	        if (color.getRed() + color.getGreen() + color.getBlue() <= 300)  
	        {  
	            return true;  
	        }  
	        return false;  
	    }  
	  
	    public static boolean isWhite(int colorInt)  
	    {  
	        Color color = new Color(colorInt);  
	        if (color.getRed() + color.getGreen() + color.getBlue() > 300)  
	        {  
	            return true;  
	        }  
	        return false;  
	    }  
	  
	    public static int isBlackOrWhite(int colorInt)  
	    {  
	        if (getColorBright(colorInt) < 30 || getColorBright(colorInt) > 730)  
	        {  
	            return 1;  
	        }  
	        return 0;  
	    }  
	  
	    public static int getColorBright(int colorInt)  
	    {  
	        Color color = new Color(colorInt);  
	        return color.getRed() + color.getGreen() + color.getBlue();  
	    }  
	  
	    public static int ostu(int[][] gray, int w, int h)  
	    {  
	        int[] histData = new int[w * h];  
	        // Calculate histogram  
	        for (int x = 0; x < w; x++)  
	        {  
	            for (int y = 0; y < h; y++)  
	            {  
	                int red = 0xFF & gray[x][y];  
	                histData[red]++;  
	            }  
	        }  
	  
	        // Total number of pixels  
	        int total = w * h;  
	  
	        float sum = 0;  
	        for (int t = 0; t < 256; t++)  
	            sum += t * histData[t];  
	  
	        float sumB = 0;  
	        int wB = 0;  
	        int wF = 0;  
	  
	        float varMax = 0;  
	        int threshold = 0;  
	  
	        for (int t = 0; t < 256; t++)  
	        {  
	            wB += histData[t]; // Weight Background  
	            if (wB == 0)  
	                continue;  
	  
	            wF = total - wB; // Weight Foreground  
	            if (wF == 0)  
	                break;  
	  
	            sumB += (float) (t * histData[t]);  
	  
	            float mB = sumB / wB; // Mean Background  
	            float mF = (sum - sumB) / wF; // Mean Foreground  
	  
	            // Calculate Between Class Variance  
	            float varBetween = (float) wB * (float) wF * (mB - mF) * (mB - mF);  
	  
	            // Check if new maximum found  
	            if (varBetween > varMax)  
	            {  
	                varMax = varBetween;  
	                threshold = t;  
	            }  
	        }  
	  
	        return threshold;  
	    }  

}
