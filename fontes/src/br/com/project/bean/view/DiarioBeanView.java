package br.com.project.bean.view;

import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.carregamento.lazy.CarregamentoLazyListForObject;
import br.com.project.geral.controller.DiarioController;
import br.com.project.geral.controller.EntidadeController;
import br.com.project.geral.controller.FilialController;
import br.com.project.model.classes.Bairro;
import br.com.project.model.classes.Diario;
import br.com.project.model.classes.Filial;

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
	
	@Resource
	private FilialController filialController;

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
		if (objetoSelecionado.getFil_codigo() != null
				&& objetoSelecionado.getFil_codigo().getFil_codigo() != null
				&& objetoSelecionado.getFil_codigo().getFil_codigo() > 0) {
			objetoSelecionado
					.setFil_codigo(filialController.findUninqueByProperty(
							Filial.class, objetoSelecionado.getFil_codigo()
									.getFil_codigo(), "fil_codigo"));
		}
		
		
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
	 * Ivocado pelo botão exlcluir
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
	 * Ivocado pelo botão consultar
	 */
	public void consultaEntidade() throws Exception {
		objetoSelecionado = new Diario();
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
	@RequestMapping({ "**/find_diario" })
	public void setarVariaveisNulas() throws Exception {
		valorPesquisa = "";
		list.clear();
		objetoSelecionado = new Diario();
	}
	
	@RequestMapping("**/addCriancaFilial")
	public void addFilialFilial(@RequestParam Long codFilial) throws Exception {
		if (codFilial != null && codFilial > 0) {
				objetoSelecionado.setFil_codigo(filialController
						.findUninqueByProperty(Filial.class, codFilial,
								"fil_codigo"));
		}
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
