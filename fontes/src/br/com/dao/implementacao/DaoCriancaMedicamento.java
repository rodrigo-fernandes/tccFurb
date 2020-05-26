package br.com.dao.implementacao;

import org.springframework.stereotype.Repository;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.project.model.classes.CriancaMedicamento;
import br.com.repository.interfaces.RepositoryCriancaMedicamento;

@Repository
public class DaoCriancaMedicamento extends ImplementacaoCrud<CriancaMedicamento> implements RepositoryCriancaMedicamento {

	private static final long serialVersionUID = 1L;

}
