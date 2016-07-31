package com.Java.Image;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

class ImageInfo {

    public static void main(String[] args) throws Exception {
    	List<URL> urlList = new ArrayList<URL>();
    	
    	urlList.add(new URL("http://api.androidhive.info/feed/img/time_best.jpg"));
    	
    	for(URL url: urlList){
    		ImageInfo.getImageInfo(url);
    	}    	
    }
    
    private static void getImageInfo(URL url){    	
		try {
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        InputStream is = url.openStream();
	        byte[] b = new byte[2^16];
	        int read = is.read(b);
	        while (read>-1) {
	            baos.write(b,0,read);
	            read = is.read(b);
	        }
	        double countInBytes = baos.toByteArray().length;
	        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
	        Image image = ImageIO.read(bais);
	        int width = image.getWidth(null);
	        int height = image.getHeight(null);
	        String imageInfo = width + "x" + height + " px, " + countInBytes/1024.000 + " KB.";
	        System.out.println("imageInfo:"+imageInfo);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}