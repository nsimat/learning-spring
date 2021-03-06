package edu.nsimat.lil.learningspring.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorHandlingController implements ErrorController {

    @GetMapping(value = "/error")
    public String handleError(HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if(status != null){
            Integer statusCode = Integer.parseInt(status.toString());
            int value = statusCode.intValue();

            switch(value){
                case 400:
                    return "error/HTTP400";
                case 401:
                    return "error/HTTP401";
                case 403:
                    return "error/HTTP403";
                case 404:
                    return "error/HTTP404";
                case 500:
                    return "error/HTTP500";
                case 501:
                    return "error/HTTP501";
                case 502:
                    return "error/HTTP502";
                case 503:
                    return "error/HTTP503";
                case 520:
                    return "error/HTTP520";
                case 521:
                    return "error/HTTP521";
                case 533:
                    return "error/HTTP533";
                default:
                    return "error";
            }
        }
        return "error";
    }
}
