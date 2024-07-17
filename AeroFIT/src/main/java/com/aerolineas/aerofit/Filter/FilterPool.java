package com.aerolineas.aerofit.Filter;
import org.springframework.stereotype.Component;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.util.concurrent.*;

@Component
public class FilterPool implements Filter {

    private static final int MAX_THREADS = 5;
    private static final int QUEUE_SIZE = 100;
    private ExecutorService executorService;

    @Override
    public void init(FilterConfig filterConfig) {
        executorService = new ThreadPoolExecutor(
                MAX_THREADS,
                MAX_THREADS,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(QUEUE_SIZE)
        );
    }

    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException{
        executorService.submit(() -> {
            try {
                chain.doFilter(request, response);
            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void destroy() {
        executorService.shutdown();
    }
}