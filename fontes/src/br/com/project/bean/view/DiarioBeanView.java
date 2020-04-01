package br.com.project.bean.view;

import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.StreamedContent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.carregamento.lazy.CarregamentoLazyListForObject;
import br.com.project.geral.controller.DiarioController;
import br.com.project.model.classes.Diario;

@Controller
@Scope(value = "session")
@ManagedBean(name = "diarioBeanView")
public class DiarioBeanView extends BeanManagedViewAbstract {

	private static final long serialVersionUID = 1L;
	private CarregamentoLazyListForObject<Diario> list = new CarregamentoLazyListForObject<Diario>();
	private Diario objetoSelecionado = new Diario();
	private String url = "/cadastro/cad_diario.jsf?faces-redirect=true";
	private String urlFind = "/cadastro/find_diario.jsf?faces-redirect=true";

	@Resource
	private DiarioController diarioController;

	public void setDiarioController(DiarioController diarioController) {
		this.diarioController = diarioController;
	}

	public DiarioController getDiarioController() {
		return diarioController;
	}

	@Override
	public StreamedContent getArquivoReport() throws Exception {
		super.setNomeRelatorioJasper("report_diario");
		super.setNomeRelatorioSaida("report_diario");
		List<?> list = diarioController.finListOrderByProperty(Diario.class, "dia_codigo");
		super.setListDataBeanColletionReport(list);
		return super.getArquivoReport();
	}

	/**
	 * Ivocado pelo bot�o novo
	 */
	@Override
	public String novo() throws Exception {
		setarVariaveisNulas();
		return url;
	}

	/**
	 * Ivocado pelo bot�o salvar
	 */
	@Override
	public void saveNotReturn() throws Exception {
		if (validarCampoObrigatorio(objetoSelecionado)) {
			list.clear();
			objetoSelecionado = diarioController.merge(objetoSelecionado);
			list.getList().add(objetoSelecionado);
			objetoSelecionado = new Diario();
			sucesso();
		}
	}

	@Override
	public void saveEdit() throws Exception {
		saveNotReturn();
	}

	/**
	 * Ivocado pelo bot�o exlcluir
	 */
	@Override
	public void excluir() throws Exception {
		if (objetoSelecionado.getDia_codigo() != null && objetoSelecionado.getDia_codigo() > 0) {
			diarioController.delete(objetoSelecionado);
			list.getList().remove(objetoSelecionado);
			objetoSelecionado = new Diario();
			sucesso();
		}
	}

	/**
	 * Ivocado pelo bot�o consultar
	 */
	public void consultaEntidade() throws Exception {
		objetoSelecionado = new Diario();
		list.clear();
		list.setTotalRegistroConsulta(super.totalRegistroConsulta(), super.getSqlLazyQuery());
	}

	/**
	 * Ivocado pelo bot�o consultar
	 */
	@Override
	public String redirecionarFindEntidade() throws Exception {
		setarVariaveisNulas();
		return urlFind;
	}

	@Override
	public String editar() throws Exception {
		valorPesquisa = "";
		list.clear();
		return url;
	}

	@Override
	@RequestMapping({ "**/find_diario" })
	public void setarVariaveisNulas() throws Exception {
		valorPesquisa = "";
		list.clear();
		objetoSelecionado = new Diario();
	}

	@Override
	protected Class<?> getClassImplement() {
		return Diario.class;
	}

	@Override
	protected InterfaceCrud<?> getController() {
		return diarioController;
	}

	public CarregamentoLazyListForObject<Diario> getList() {
		return list;
	}

	public void setList(CarregamentoLazyListForObject<Diario> list) {
		this.list = list;
	}

	public Diario getObjetoSelecionado() {
		return objetoSelecionado;
	}

	public void setObjetoSelecionado(Diario objetoSelecionado) {
		this.objetoSelecionado = objetoSelecionado;
	}

	@RequestMapping("**/findDiario")
	public void findDiario(HttpServletResponse httpServletResponse, @RequestParam(value = "codDiario") Long codDiario)
			throws Exception {
		Diario diario = diarioController.findUninqueByPropertyId(Diario.class, codDiario, "dia_codigo");
		if (diario != null) {
			httpServletResponse.getWriter().write(diario.getJson().toString());
		}

	}

	@Override
	public String condicaoAndParaPesquisa() {
		return "";
	}

	public Object onRowSelect(SelectEvent event) {
		objetoSelecionado = (Diario) super.onRowSelect(event);
		return null;
	}

	public Object onRowUnselect(UnselectEvent event) {
		objetoSelecionado = (Diario) super.onRowUnselect(event);
		return null;
	}

}
