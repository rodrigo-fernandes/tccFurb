package br.com.project.bean.view;

import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.model.StreamedContent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.carregamento.lazy.CarregamentoLazyListForObject;
import br.com.project.geral.controller.CriancaNewController;
import br.com.project.model.classes.Crianca;

@Controller
@Scope(value = "session")
@ManagedBean(name = "CriancaNewBeanView")
public class CriancaNewBeanView extends BeanManagedViewAbstract {

	private static final long serialVersionUID = 1L;
	private CarregamentoLazyListForObject<Crianca> list = new CarregamentoLazyListForObject<Crianca>();
	private Crianca objetoSelecionado = new Crianca();
	private String url = "/cadastro/cad_criancaNew.jsf?faces-redirect=true";
	private String urlFind = "/cadastro/find_criancaNew.jsf?faces-redirect=true";

	@Resource
	private CriancaNewController criancaNewController;

	public void setCriancaNewController(CriancaNewController criancaNewController) {
		this.criancaNewController = criancaNewController;
	}

	public CriancaNewController getCriancaNewController() {
		return criancaNewController;
	}

	@Override
	public StreamedContent getArquivoReport() throws Exception {
		super.setNomeRelatorioJasper("report_criancaNew");
		super.setNomeRelatorioSaida("report_criancaNew");
		List<?> list = criancaNewController.finListOrderByProperty(Crianca.class, "cri_codigo");
		super.setListDataBeanColletionReport(list);
		return super.getArquivoReport();
	}

	@Override
	protected Class<?> getClassImplement() {
		return Crianca.class;
	}

	@Override
	public String novo() throws Exception {
		setarVariaveisNulas();
		return url;
	}

	@Override
	public void saveNotReturn() throws Exception {

		if (validarCampoObrigatorio(objetoSelecionado)) {
			list.clear();
			objetoSelecionado = criancaNewController.merge(objetoSelecionado);
			list.add(objetoSelecionado);
			objetoSelecionado = new Crianca();
			sucesso();
		}
	}

	@Override
	public void saveEdit() throws Exception {
		saveNotReturn();
	}

	@Override
	@RequestMapping({ "**/find_criancaNew" })
	public void setarVariaveisNulas() throws Exception {
		valorPesquisa = "";
		list.clear();
		objetoSelecionado = new Crianca();
	}

	@RequestMapping("**/findCriancaNew")
	public void findFilial(HttpServletResponse httpServletResponse,
			@RequestParam(value = "codCriancaNew") Long codCriancaNew) throws Exception {

		Crianca crianca = criancaNewController.findUninqueByPropertyId(Crianca.class, codCriancaNew, "cri_codigo");
		if (crianca != null) {
			httpServletResponse.getWriter().write(crianca.getJson().toString());
		}

	}
	
	@Override
	protected InterfaceCrud<?> getController() {
		return criancaNewController;
	}

	public CarregamentoLazyListForObject<Crianca> getList() {
		return list;
	}

	public void setList(CarregamentoLazyListForObject<Crianca> list) {
		this.list = list;
	}

	public Crianca getObjetoSelecionado() {
		return objetoSelecionado;
	}

	public void setObjetoSelecionado(Crianca objetoSelecionado) {
		this.objetoSelecionado = objetoSelecionado;
	}
	
	@Override
	public void excluir() throws Exception {
			if (objetoSelecionado.getCri_codigo() != null
					&& objetoSelecionado.getCri_codigo() > 0) {
				criancaNewController.delete(objetoSelecionado);
				list.remove(objetoSelecionado);
				objetoSelecionado = new Crianca();
				sucesso();
			}
	}

	@Override
	public String editar() throws Exception {
		valorPesquisa = "";
		list.clear();
		return url;
	}
	
	@Override
	public String redirecionarFindEntidade() throws Exception {
		setarVariaveisNulas();
		return urlFind;
	}

	@Override
	public void consultaEntidade() throws Exception {
			objetoSelecionado = new Crianca();
			list.clear();
			list.setTotalRegistroConsulta(super.totalRegistroConsulta(), super.getSqlLazyQuery());
	}

	@Override
	public String condicaoAndParaPesquisa() {
		return "";
	}

}
