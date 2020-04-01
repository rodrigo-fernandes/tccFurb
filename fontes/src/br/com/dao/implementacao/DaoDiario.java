package br.com.dao.implementacao;

import org.springframework.stereotype.Repository;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.project.model.classes.Diario;
import br.com.repository.interfaces.RepositoryDiario;

@Repository
public class DaoDiario extends ImplementacaoCrud<Diario> implements RepositoryDiario {
	
	private static final long serialVersionUID = 1L;

}
