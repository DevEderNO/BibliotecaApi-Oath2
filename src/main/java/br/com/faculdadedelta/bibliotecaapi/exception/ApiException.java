package br.com.faculdadedelta.bibliotecaapi.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApiException extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<Object> handlerEmptyResultDataAccessException(
			EmptyResultDataAccessException ex, WebRequest request) {
		String mensagemUsuario = "Recurso não encontrado!";
		String mensagemDesenvolvedor = ex.toString();
		List<ErroDetalhe> erros 
			= Arrays.asList(
					new ErroDetalhe(mensagemUsuario, mensagemDesenvolvedor));
	
		return handleExceptionInternal(
				ex,erros, new HttpHeaders(), 
				HttpStatus.NOT_FOUND, request);
	}
	
	private List<ErroDetalhe> criarListaErros(BindingResult bindingResult) {
		List<ErroDetalhe> erros = new ArrayList<>();
		
		bindingResult.getFieldErrors()
			.forEach((fieldErro) -> erros.add(
						new ErroDetalhe(fieldErro.getDefaultMessage(),
				fieldErro.toString())));
		return erros;
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<ErroDetalhe> erros = criarListaErros(ex.getBindingResult());

		return handleExceptionInternal(ex, 
				erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handlerConstraintViolationException(ConstraintViolationException ex,
			WebRequest request) {
		String mensagemUsuario = "Falha ao realizar opereção, tente novamente mais tarde!";
		String mensagemDesenvolvedor = ex.toString();
		List<ErroDetalhe> erros = Arrays.asList(new ErroDetalhe(mensagemUsuario, mensagemDesenvolvedor));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	private static class ErroDetalhe {
		private String mensagemUsuario;
		private String mensagemDesenvolvedor;

		public ErroDetalhe(String mensagemUsuario, String mensagemDesenvolvedor) {
			this.mensagemUsuario = mensagemUsuario;
			this.mensagemDesenvolvedor = mensagemDesenvolvedor;
		}

		public String getMensagemUsuario() {
			return mensagemUsuario;
		}

		public String getMensagemDesenvolvedor() {
			return mensagemDesenvolvedor;
		}
	}
}
