package br.com.dao.implementacao;

import org.springframework.stereotype.Repository;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.project.model.classes.Crianca;
import br.com.repository.interfaces.RepositoryCriancaNew;

@Repository
public class DaoCriancaNew extends ImplementacaoCrud<Crianca> implements RepositoryCriancaNew {

	private static final long serialVersionUID = 1L;

}
