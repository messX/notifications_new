package core.lib.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@WebFilter(urlPatterns = {"/*"})
public class MDCFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            MDC.put("CorrelationId", UUID.randomUUID().toString());
            log.info(String.format("Starting to serve %s", ((HttpServletRequest) request).getRequestURI()));
            chain.doFilter(request, response);
        } finally {
            MDC.remove("CorrelationId");
        }
    }
}
