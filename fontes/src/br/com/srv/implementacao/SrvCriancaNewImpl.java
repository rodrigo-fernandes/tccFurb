package br.com.srv.implementacao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.repository.interfaces.RepositoryCriancaNew;
import br.com.srv.interfaces.SrvCriancaNew;

@Service
public class SrvCriancaNewImpl implements SrvCriancaNew {
	private static final long serialVersionUID = 1L;

	@Resource
	private RepositoryCriancaNew repositoryCriancaNew;

	public void setRepositoryCriancaNew(RepositoryCriancaNew repositoryCriancaNew) {

		this.repositoryCriancaNew = repositoryCriancaNew;
	}

}
