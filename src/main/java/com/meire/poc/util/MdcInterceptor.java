package com.meire.poc.util;

import com.meire.poc.model.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Component
public class MdcInterceptor implements HandlerInterceptor {

    private final Information information;

    private final Logger logger = LoggerFactory.getLogger(MdcInterceptor.class);

    public MdcInterceptor(Information information) {
        this.information = information;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        MDC.put("requestId", information.getRequestId());
        MDC.put("requestUrl", url);
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        String tempoDeInicio = formatDateTime(startTime);
        MDC.put("startTime", tempoDeInicio);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler, ModelAndView modelAndView)
            throws Exception {
        // Captura o tempo de início da execução da requisição
        long startTime = (Long) request.getAttribute("startTime");
        // Calcula o tempo total de execução
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        // Adiciona o tempo de execução ao MDC para registro nos logs
        System.out.println("Tempo de execução: " + executionTime + "ms");
        ExecutionTimeHolder.setExecutionTime(executionTime);
        System.out.println(ExecutionTimeHolder.getExecutionTime());
        //logger.info("Tempo de execução da requisição: "+ ExecutionTimeHolder.getExecutionTime() + "ms");
        MDC.put("executionTime", String.valueOf(executionTime));
        MDC.clear();
    }

 //Método para formatar o tempo em milissegundos para o fuso horário da Brasília
public static String formatDateTime(long timeMillis) {
    // Defina o formato desejado
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    sdf.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));

    // Converta o tempo em milissegundos para um objeto Date
    Date dateTime = new Date(timeMillis);

    // Formate a data e hora para o fuso horário da Brasília
    return sdf.format(dateTime);
}

}



