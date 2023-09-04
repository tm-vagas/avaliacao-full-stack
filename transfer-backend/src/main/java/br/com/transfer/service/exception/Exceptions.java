package br.com.transfer.service.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class Exceptions extends RuntimeException {	
	
	private static final long serialVersionUID = 1L;
	
	private Integer httpCode;
	private String mensagem;
	
	public Integer getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(Integer httpCode) {
		this.httpCode = httpCode;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public Exceptions(Integer httpCode, String mensagem) {
		this.httpCode = httpCode;
		this.mensagem = mensagem;
	}
	
}