package com.innovationem.util;

import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.Transform;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

public class Util {

    public static String genHashKey(String seed) {
        return "0AYxsM9N445HZGhzNGMzZjhfMzZkdjI3a3ZnOQ" + System.currentTimeMillis() + seed;
    }

    public static boolean isNotEmpty(List list) {
        return (list != null && list.size() > 0);
    }

    public static boolean isTimeExpired(long startTime) {
        long endTime = System.currentTimeMillis();
        long totalTimeInSecs = (endTime - startTime) / 1000;
        return (totalTimeInSecs > 120);
    }

    public static byte[] scaleImage(byte[] imageData, int x, int y) {
        ImagesService imagesService = ImagesServiceFactory.getImagesService();
        Image oldImage = ImagesServiceFactory.makeImage(imageData);
        Transform resize = ImagesServiceFactory.makeResize(x, y);
        Image newImage = imagesService.applyTransform(resize, oldImage);
        return newImage.getImageData();
    }

    public static byte[] inputStreamToArray(InputStream inputStream) throws Exception {
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        IOUtils.copy(inputStream, byteOutputStream);
        IOUtils.closeQuietly(inputStream);
        return byteOutputStream.toByteArray();
    }

}
