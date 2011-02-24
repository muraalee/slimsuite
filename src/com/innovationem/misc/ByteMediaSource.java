package com.innovationem.misc;

import com.google.gdata.data.media.BaseMediaSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: murali
 * Date: Jul 17, 2010
 * Time: 12:28:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class ByteMediaSource extends BaseMediaSource {
    byte[] mediaBytes;

    public ByteMediaSource(String mediaType) {
        super(mediaType);
    }

    public ByteMediaSource(byte[] bytes, String mediaType) {
        super(mediaType);
        mediaBytes = bytes;
    }

    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(mediaBytes);
    }

    public OutputStream getOutputStream() throws IOException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
