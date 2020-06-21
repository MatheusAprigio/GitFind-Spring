package com.gitapi.error;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ErrorHandlerComponent  implements ErrorViewResolver{
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        ModelAndView modelAndView = new ModelAndView("errorPage");
        modelAndView.addObject("status", status.value());
        switch (status.value()) {
            case 404:
                modelAndView.addObject("error", "Ops! Page not found.");
                modelAndView.addObject("message", "Requested URL '" + model.get("path") + "' do not exists.");
                break;
            case 500:
                modelAndView.addObject("error", "Ops! something went wrong.");
                modelAndView.addObject("message", "Sorry, we are trying to fix this problem ASAP.");
                break;
            default:
                modelAndView.addObject("error", model.get("error"));
                modelAndView.addObject("message", model.get("message"));
                break;
        }
        return modelAndView;
    }
}