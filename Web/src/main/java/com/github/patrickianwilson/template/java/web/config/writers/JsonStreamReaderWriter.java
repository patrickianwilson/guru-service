package com.github.patrickianwilson.template.java.web.config.writers;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.gson.Gson;

/**
 * Created by pwilson on 4/4/16.
 */
public class JsonStreamReaderWriter implements MessageBodyWriter<Object>, MessageBodyReader<Object> {

    /**
     * Classes listed by name to avoid jar dependencies.
     */
    private static final Set<String> INTERNAL_CLASSES = ImmutableSet.of(
            "com.sun.jersey.api.view.Viewable",
            "javax.ws.rs.core.StreamingOutput",
            "javax.ws.rs.core.Response"
    );

    private final Set<String> doNotHandleList = Sets.newHashSet(INTERNAL_CLASSES);;

    private final Gson gson;

    @Inject
    public JsonStreamReaderWriter(Gson gson) {
        this.gson = gson;
    }


    @Override
    public boolean isReadable(Class<?> type, Type genericType, java.lang.annotation.Annotation[] annotations, MediaType mediaType) {
        if (!supported(type))
            return false;

        return type != String.class;
    }

    @Override
    public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations, MediaType mediaType,
                           MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException {
        try (InputStreamReader streamReader = new InputStreamReader(entityStream, Charsets.UTF_8)) {
            return gson.fromJson(streamReader, genericType);
        }
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        if (!supported(type))
            return false;

        // Can write anything
        return true;
    }

    @Override
    public long getSize(Object object, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        // -1 if the length cannot be determined in advance
        return -1;
    }

    @Override
    public void writeTo(Object object, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException {
        try (OutputStreamWriter writer = new OutputStreamWriter(entityStream, Charsets.UTF_8)) {
            if (genericType != null)
                gson.toJson(object, genericType, writer);
            else
                gson.toJson(object, writer);
        }
    }

    /**
     * Check for some unsupported classes.
     */
    private boolean supported(Class<?> type) {
        if (doNotHandleList.contains(type.getName()))
            return false;

        return true;
    }
}
