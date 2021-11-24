package com.okay.filter;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;
import java.time.Duration;
import java.time.Instant;

@Component
@Order(1)
public class TransactionFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        LOGGER.info("Starting a transaction for req : {}", req.getRequestURI());

        Instant start = Instant.now();

        String token = req.getParameter("token");
        if (token != null && token.equalsIgnoreCase("ahmet")) {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token is not valid.");
        } else {

//            OutputStream output = response.getOutputStream();
//            InputStream is = new ByteArrayInputStream(bos.toByteArray());
//
//            try {
//                ByteArrayOutputStream buffer = (ByteArrayOutputStream) response.getOutputStream();
//                byte[] bytes = buffer.toByteArray();
//                InputStream inputStream = new ByteArrayInputStream(bytes);
//            } catch (Exception e) {
//
//            }




//            ByteArrayOutputStream capture = new ByteArrayOutputStream(response.getBufferSize());
//            PrintWriter writer = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), Charset.defaultCharset()));

//            writer.write(capture);
//            IOUtils.copy()

//            ServletOutputStream outputStream = response.getOutputStream();
//
//            //OutputStream
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            bos.write();
//            bos.close();
//            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//
//            //byte[] -> InputStream
//            ByteArrayInputStream inStream = new ByteArrayInputStream( outStream.toByteArray() )
//
//            response.getOutputStream().;
//
//            IOUtils.copy(request.getInputStream(), outputStream);
//            IOUtils.copy(outputStream, outputStream);
            chain.doFilter(request, response);
        }

        Instant end = Instant.now();

        Duration between = Duration.between(start, end);

        LOGGER.info("Committing a transaction for req : {}", req.getRequestURI());
        LOGGER.info("Committing a transaction duration is {} hours {} minutes {} seconds {} milliseconds", between.toHours(), between.toMinutesPart(), between.toSecondsPart(), between.toMillisPart());
    }
}