package com.github.patrickianwilson.template.java.web.config;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.common.annotations.VisibleForTesting;
import com.google.inject.servlet.GuiceFilter;

/**
 * This is just a nice mechanism to bypass Jersey/Guice and delegate to the underlying filterchain.
 */
public class DefaultFilter extends GuiceFilter {
    /**
     * These are the patterns that are white-listed for handling by the AppEngine application.
     */
    public static final String DEFAULT_APPLICATION_HANDLER_PATTERN = "/_ah/(warmup|mail|channel/connected|channel/disconnected)(/.*)?";

    /**
     * These patterns require Access-Control-Allow-Origin headers in dev mode.
     */
    public static final String DEFAULT_CROSS_DOMIAN_HANDLER_PATTERN = "/_ah/channel(/.*)?";

    /**
     * The name of the filter parameter for application handlers.
     */
    public static final String APPLICATION_HANDLER_PARAM_NAME = "appengine.application.admin.handler.pattern";

    /**
     * The name of the filter parameter for cross domain handlers.
     */
    public static final String CROSS_DOMAIN_HANDLER_PARAM_NAME = "appengine.cross.domain.admin.handler.pattern";

    public static final String CORS_ORIGIN_HEADER_NAME = "Access-Control-Allow-Origin";

    public static final String CORS_ORIGIN_HEADER_VALUE = "*";

    /**
     * Matches _ah URLs.
     */
    private static final Pattern ADMIN_HANDLER = Pattern.compile("/_ah/.*");

    private Pattern applicationHandlers;

    private Pattern crossDomainHandlers;

    private Pattern fileResourceHandlers;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String handlerPattern = filterConfig.getInitParameter(APPLICATION_HANDLER_PARAM_NAME);
        applicationHandlers = Pattern.compile(handlerPattern != null ? handlerPattern : DEFAULT_APPLICATION_HANDLER_PATTERN);

        String crossDomain = filterConfig.getInitParameter(CROSS_DOMAIN_HANDLER_PARAM_NAME);
        crossDomainHandlers = Pattern.compile(crossDomain != null ? crossDomain : DEFAULT_CROSS_DOMIAN_HANDLER_PATTERN);

        fileResourceHandlers = Pattern.compile("(/api-viewer/|/rest-api-docs/).*");

        super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        // Ensure that this correctly serves Access-Control-Allow-Origin headers for certain /_ah/ URLs in dev mode
        if (matchesRequestUri(crossDomainHandlers, req)) {
            HttpServletResponse httpResp = (HttpServletResponse) response;
            httpResp.addHeader(CORS_ORIGIN_HEADER_NAME, CORS_ORIGIN_HEADER_VALUE);
        }

        // We don't want the GuiceFilter handling stuff it should not be dealing with (ie: most /_ah/ requests)
        if (isAdminHandlerRequest(req) && !isAdminHandlerForApplication(req) && !shouldHandle(req.getRequestURI())) {
            chain.doFilter(request, response);
            return;
        }

        if (isFilePassthrough(req)) {
            chain.doFilter(request, response);
            return;
        }

        executeGuiceFilter(request, response, chain);
    }

    /**
     * Override this if you want to force it to handle a certain /_ah/ URL.
     */
    protected boolean shouldHandle(String uri) {
        return false;
    }

    @VisibleForTesting
    void executeGuiceFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        super.doFilter(request, response, chain);
    }

    private boolean isAdminHandlerRequest(HttpServletRequest req) {
        return matchesRequestUri(ADMIN_HANDLER, req);
    }

    private boolean isAdminHandlerForApplication(HttpServletRequest req) {
        return matchesRequestUri(applicationHandlers, req);
    }

    private boolean matchesRequestUri(Pattern pattern, HttpServletRequest req) {
        return pattern.matcher(req.getRequestURI()).matches();
    }

    private boolean isFilePassthrough(HttpServletRequest req) {
        return matchesRequestUri(fileResourceHandlers, req);
    }

}
