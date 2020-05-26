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
import br.com.project.geral.controller.CriancaMedicamentoController;
import br.com.project.geral.controller.FilialController;
import br.com.project.model.classes.CriancaMedicamento;
import br.com.project.model.classes.Filial;

@Controller
@Scope(value = "session")
@ManagedBean(name = "criancaMedicamentoBeanView")
public class CriancaMedicamentoBeanView extends BeanManagedViewAbstract {

	private static final long serialVersionUID = 1L;
	private CarregamentoLazyListForObject<CriancaMedicamento> list = new CarregamentoLazyListForObject<CriancaMedicamento>();
	private CriancaMedicamento objetoSelecionado = new CriancaMedicamento();
	private String url = "/cadastro/cad_criancamedicamento.jsf?faces-redirect=true";
	private String urlFind = "/cadastro/find_criancamedicamento.jsf?faces-redirect=true";

	@Resource
	private CriancaMedicamentoController criancaMedicamentoController;

	@Resource
	private FilialController filialController;

	public void setCriancaMedicamentoController(CriancaMedicamentoController medicamentoController) {
		this.criancaMedicamentoController = medicamentoController;
	}

	public CriancaMedicamentoController getCriancaMedicamentoController() {
		return criancaMedicamentoController;
	}

	@Override
	public StreamedContent getArquivoReport() throws Exception {
		super.setNomeRelatorioJasper("report_criancamedicamento");
		super.setNomeRelatorioSaida("report_criancamedicamento");
		List<?> list = criancaMedicamentoController.finListOrderByProperty(CriancaMedicamento.class, "cmd_codigo");
		super.setListDataBeanColletionReport(list);
		return super.getArquivoReport();
	}

	/**
	 * Ivocado pelo botão novo
	 */
	@Override
	public String novo() throws Exception {
		setarVariaveisNulas();
		return url;
	}

	/**
	 * Ivocado pelo botão salvar
	 */
	@Override
	public void saveNotReturn() throws Exception {
		if (objetoSelecionado.getFil_codigo() != null && objetoSelecionado.getFil_codigo().getFil_codigo() != null
				&& objetoSelecionado.getFil_codigo().getFil_codigo() > 0) {
			objetoSelecionado.setFil_codigo(filialController.findUninqueByProperty(Filial.class,
					objetoSelecionado.getFil_codigo().getFil_codigo(), "fil_codigo"));
		}

		if (validarCampoObrigatorio(objetoSelecionado)) {
			list.clear();
			objetoSelecionado = criancaMedicamentoController.merge(objetoSelecionado);
			list.getList().add(objetoSelecionado);
			objetoSelecionado = new CriancaMedicamento();
			sucesso();
		}
	}

	@Override
	public void saveEdit() throws Exception {
		saveNotReturn();
	}

	/**
	 * Ivocado pelo botão exlcluir
	 */
	@Override
	public void excluir() throws Exception {
		if (objetoSelecionado.getCmd_codigo() != null && objetoSelecionado.getCmd_codigo() > 0) {
			criancaMedicamentoController.delete(objetoSelecionado);
			list.getList().remove(objetoSelecionado);
			objetoSelecionado = new CriancaMedicamento();
			sucesso();
		}
	}

	/**
	 * Ivocado pelo botão consultar
	 */
	public void consultaEntidade() throws Exception {
		objetoSelecionado = new CriancaMedicamento();
		list.clear();
		list.setTotalRegistroConsulta(super.totalRegistroConsulta(), super.getSqlLazyQuery());
	}

	/**
	 * Ivocado pelo botão consultar
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
	@RequestMapping({ "**/find_criancamedicamento" })
	public void setarVariaveisNulas() throws Exception {
		valorPesquisa = "";
		list.clear();
		objetoSelecionado = new CriancaMedicamento();
	}

	@RequestMapping("**/addCriancaMedicamentoFilial")
	public void addFilialFilial(@RequestParam Long codFilial) throws Exception {
		if (codFilial != null && codFilial > 0) {
			objetoSelecionado
					.setFil_codigo(filialController.findUninqueByProperty(Filial.class, codFilial, "fil_codigo"));
		}
	}

	@Override
	protected Class<?> getClassImplement() {
		return CriancaMedicamento.class;
	}

	@Override
	protected InterfaceCrud<?> getController() {
		return criancaMedicamentoController;
	}

	public CarregamentoLazyListForObject<CriancaMedicamento> getList() {
		return list;
	}

	public void setList(CarregamentoLazyListForObject<CriancaMedicamento> list) {
		this.list = list;
	}

	public CriancaMedicamento getObjetoSelecionado() {
		return objetoSelecionado;
	}

	public void setObjetoSelecionado(CriancaMedicamento objetoSelecionado) {
		this.objetoSelecionado = objetoSelecionado;
	}

	@RequestMapping("**/findCriancaMedicamento")
	public void findDiario(HttpServletResponse httpServletResponse,
			@RequestParam(value = "codCriancaMedicamento") Long codCriancaMedicamento) throws Exception {
		CriancaMedicamento criancaMedicamento = criancaMedicamentoController
				.findUninqueByPropertyId(CriancaMedicamento.class, codCriancaMedicamento, "cmd_codigo");
		if (criancaMedicamento != null) {
			httpServletResponse.getWriter().write(criancaMedicamento.getJson().toString());
		}

	}

	@Override
	public String condicaoAndParaPesquisa() {
		return "";
	}

	public Object onRowSelect(SelectEvent event) {
		objetoSelecionado = (CriancaMedicamento) super.onRowSelect(event);
		return null;
	}

	public Object onRowUnselect(UnselectEvent event) {
		objetoSelecionado = (CriancaMedicamento) super.onRowUnselect(event);
		return null;
	}

}
