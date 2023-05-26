package com.devsuperior.CrudClient.resource.exception;

import java.io.Serializable; 
import java.time.Instant;

public class StandError implements Serializable {
	private static final long serialVersionUID = 1L;
 
	
	private Instant timestamp;
	private Integer status;
    private String error;
    private String mensagem;
    private String path;
    
    
    
    
	public StandError() {
		super();
	}

	public StandError(Instant timestamp, Integer status, String error, String mrssage, String path) {

		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.mensagem = mrssage;
		this.path = path;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mrssage) {
		this.mensagem = mrssage;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
    
	
	
    
    
    
}
