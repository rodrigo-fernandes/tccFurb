package br.com.project.geral.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.Diario;
import br.com.repository.interfaces.RepositoryDiario;
import br.com.srv.interfaces.SrvDiario;

@Controller
public class DiarioController extends ImplementacaoCrud<Diario> implements InterfaceCrud<Diario> {

	private static final long serialVersionUID = 1L;

	@Resource
	private SrvDiario srvDiario;

	@Resource
	private RepositoryDiario repositoryDiario;

	public void setSrvDiario(SrvDiario srvDiario) {
		this.srvDiario = srvDiario;
	}

	public void setRepositoryDiario(RepositoryDiario repositoryDiario) {
		this.repositoryDiario = repositoryDiario;
	}

}
