package com.github.patrickianwilson.template.java.web.config.writers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.inject.Singleton;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import com.google.api.client.util.IOUtils;

/**
 * Created by pwilson on 2/22/16.
 */
@Provider
@Singleton
@Produces({ "application/octet-stream" })
public class InputStreamWriter implements MessageBodyWriter<InputStream> {
    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        if (!InputStream.class.isAssignableFrom(type)) {
            return false; //not an InputStream
        }

        if (!mediaType.equals(MediaType.APPLICATION_OCTET_STREAM_TYPE)) {
            //this is only intended to serialize octet streams...
            return false;
        }
        return true;
    }

    @Override
    public long getSize(InputStream inputStream, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(InputStream inputStream, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        IOUtils.copy(inputStream, entityStream);
    }
}
