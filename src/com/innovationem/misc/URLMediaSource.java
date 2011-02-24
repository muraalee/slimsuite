package com.innovationem.misc;

import com.google.gdata.data.media.BaseMediaSource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: murali
 * Date: Jul 5, 2010
 * Time: 2:52:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class URLMediaSource extends BaseMediaSource {
    /**
     * Constructs a new BaseMediaSource of the specified content type.
     */
    private URL url;

    public URLMediaSource(URL url, String mediaType) {
        super(mediaType);
        this.url = url;
        this.name = url.toString();
    }

    public InputStream getInputStream() throws IOException {
        return url.openConnection().getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
