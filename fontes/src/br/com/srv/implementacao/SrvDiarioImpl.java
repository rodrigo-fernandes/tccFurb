package br.com.srv.implementacao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.repository.interfaces.RepositoryDiario;
import br.com.srv.interfaces.SrvDiario;

@Service
public class SrvDiarioImpl implements SrvDiario {
	
	private static final long serialVersionUID = 1L;
	
	@Resource
	private RepositoryDiario repositoryDiario;
	
	public void setRepositoryDiario(RepositoryDiario repositoryDiario) {
		this.repositoryDiario = repositoryDiario;
	}
	

}
