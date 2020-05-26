package br.com.project.geral.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.CriancaMedicamento;
import br.com.repository.interfaces.RepositoryCriancaMedicamento;
import br.com.srv.interfaces.SrvCriancaMedicamento;

@Controller
public class CriancaMedicamentoController extends ImplementacaoCrud<CriancaMedicamento>
		implements InterfaceCrud<CriancaMedicamento> {

	private static final long serialVersionUID = 1L;

	@Resource
	private SrvCriancaMedicamento srvCriancaMedicamento;

	@Resource
	private RepositoryCriancaMedicamento repositoryCriancaMedicamento;

	public void setSrvCriancaMedicamento(SrvCriancaMedicamento srvCriancaMedicamento) {
		this.srvCriancaMedicamento = srvCriancaMedicamento;
	}

	public void setRepositoryCriancaMedicamento(RepositoryCriancaMedicamento repositoryCriancaMedicamento) {
		this.repositoryCriancaMedicamento = repositoryCriancaMedicamento;
	}

}
