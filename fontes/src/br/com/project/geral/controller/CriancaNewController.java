package br.com.project.geral.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.Crianca;
import br.com.repository.interfaces.RepositoryCriancaNew;
import br.com.srv.interfaces.SrvCriancaNew;

@Controller
public class CriancaNewController  extends ImplementacaoCrud<Crianca> implements InterfaceCrud<Crianca> {

	private static final long serialVersionUID = 1L;
	
	@Resource
	private SrvCriancaNew srvCriancaNew;
	
	@Resource
	private RepositoryCriancaNew repositoryCriancaNew;

	public void setSrvCriancaNew(SrvCriancaNew srvCriancaNew) {
		this.srvCriancaNew = srvCriancaNew;
	}

	public void setRepositoryCriancaNew (RepositoryCriancaNew repositoryCriancaNew) {
		this.repositoryCriancaNew = repositoryCriancaNew;
	}


}
