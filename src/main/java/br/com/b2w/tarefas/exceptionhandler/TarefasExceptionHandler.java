package br.com.b2w.tarefas.exceptionhandler;


import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class TarefasExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	

	public static class Erro {
		
		private String message;
		private String status;
		
		public Erro(String mensagemUsuario, String status) {
			this.message = mensagemUsuario;
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public String getStatus() {
			return status;
		}
		
	}
	

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		FieldError fieldError = ex.getBindingResult().getFieldError();
		
		String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
		String statusRetorno = "400";
		List<Erro> erros = Arrays.asList(new Erro(message, statusRetorno));

		
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	
	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request) {
		String message = messageSource.getMessage("recurso.nao-encontrado", null, LocaleContextHolder.getLocale());
		String status = "404";
		List<Erro> erros = Arrays.asList(new Erro(message, status));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
}
