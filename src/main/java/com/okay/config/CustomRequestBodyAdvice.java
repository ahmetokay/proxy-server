package com.okay.config;

import com.okay.constant.HeaderConstants;
import com.okay.model.HeaderDto;
import com.okay.model.BaseRequestDto;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

@ControllerAdvice
public class CustomRequestBodyAdvice implements RequestBodyAdvice {


    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
//        return methodParameter.getContainingClass() == QuestionController.class && targetType.getTypeName() == Question.class.getTypeName();
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) throws IOException {
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        if (body instanceof BaseRequestDto) {
            BaseRequestDto baseRequestDto = (BaseRequestDto) body;
            HeaderConstants.HEADER = HeaderDto.builder().application(baseRequestDto.getApplication()).channel(baseRequestDto.getChannel()).tid(baseRequestDto.getTid()).build();
        }
        return body;
    }


    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return body;
    }
}