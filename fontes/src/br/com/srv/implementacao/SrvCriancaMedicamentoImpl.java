package br.com.srv.implementacao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.repository.interfaces.RepositoryCriancaMedicamento;
import br.com.srv.interfaces.SrvCriancaMedicamento;

@Service
public class SrvCriancaMedicamentoImpl implements SrvCriancaMedicamento {

	private static final long serialVersionUID = 1L;

	@Resource
	private RepositoryCriancaMedicamento repositoryCriancaMedicamento;

	public void setRepositoryCriancaMedicamento(RepositoryCriancaMedicamento repositoryCriancaMedicamento) {
		this.repositoryCriancaMedicamento = repositoryCriancaMedicamento;
	}

}
