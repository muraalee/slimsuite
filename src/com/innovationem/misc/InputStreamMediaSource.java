package com.innovationem.misc;

import com.google.gdata.data.media.BaseMediaSource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: murali
 * Date: Jul 27, 2010
 * Time: 9:23:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class InputStreamMediaSource extends BaseMediaSource {
    InputStream inputStream;

    public InputStreamMediaSource(InputStream inputStream, String mediaType) {
        super(mediaType);
        this.inputStream = inputStream;
    }

    public InputStream getInputStream() throws IOException {
        return inputStream;
    }

    public OutputStream getOutputStream() throws IOException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
