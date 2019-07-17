package it.myproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * classe che si occupa degli errore di richiesta dal client, è una personalizzazione
 * della pagina di errore che verrebbe visualizzata di default
 * @author Alessandro
 *
 */
@Controller
public class MyErrorController implements ErrorController {
	
	  /**
	   * Gestisce le eccezioni generiche lanciate a RunTime dal controller
	   * @param request richiesta HTTP derivante dal client da cui ottenere le informazioni necessarie per visualizzare i messaggi di errore
	   * @return messaggio di errore relativo all'exception lanciata dal controller
	   */
	 @RequestMapping("/error")
	  @ResponseBody
	  public String handleError(HttpServletRequest request) {
	      Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code"); //inserisce lo status code in Status Code
	      Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception"); //inserisce l'eccezione lanciata in exception
	      String path = request.getServletPath();
	      return String.format("<html><body><h2><p style = \"font-family:arial;\"> Error Page </p></h2>"
	      							+ "<div><p style = \"font-family:arial;\"> Status code: <b>%s</b></p></div>"
	                      + "<div> <p style = \"font-family:arial;\">  Exception Message: <b><em>%s</em></b></p></div>"
	                      + "<div> <p style = \"font-family:arial;\"> Path: <b><em>%s</em></b> </p></div></body></html>",
	              statusCode, exception==null? "N/A": exception.getMessage(), path); 
	      //restituisce una pagina html con lo Status Code e l'eccezione lanciata a runtime
	      				
	  }

	 @Override
	  public String getErrorPath() {
	      return "/error";
	  }
	

}
