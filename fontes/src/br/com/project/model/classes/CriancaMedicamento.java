package br.com.project.model.classes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;
import org.primefaces.json.JSONObject;

import br.com.project.annotation.IdentificaCampoPesquisa;

@Audited
@Entity
@Table(name = "crianca_medicamento")
@SequenceGenerator(name = "crianca_medicamento_seq", sequenceName = "crianca_medicamento_seq", initialValue = 1, allocationSize = 1)
public class CriancaMedicamento {

	private static final long serialVersionUID = 1L;

	@IdentificaCampoPesquisa(descricaoCampo = "Código", campoConsulta = "cmd_codigo")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crianca_medicamento_seq")
	private Long cmd_codigo;

	@IdentificaCampoPesquisa(descricaoCampo = "Descrição", campoConsulta = "cmd_descricao", principal = 1)
	@Column(length = 500, nullable = false)
	private String cmd_descricao;

	@IdentificaCampoPesquisa(descricaoCampo = "Data", campoConsulta = "cmd_datahora", principal = 1)
	@Temporal(TemporalType.TIMESTAMP)
	private Date cmd_datahora = new Date();

	@IdentificaCampoPesquisa(descricaoCampo = "Observação", campoConsulta = "cmd_observacao", principal = 1)
	@Column(length = 5000, nullable = false)
	private String cmd_observacao;

	@IdentificaCampoPesquisa(descricaoCampo = "Criança", campoConsulta = "fil_codigo.fil_nome")
	@ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name = "fil_codigo_fk")
	@JoinColumn(name = "fil_codigo")
	private Filial fil_codigo;

	@Version
	@Column(name = "versionNum")
	private int versionNum;

	public Long getCmd_codigo() {
		return cmd_codigo;
	}

	public void setCmd_codigo(Long cmd_codigo) {
		this.cmd_codigo = cmd_codigo;
	}

	public String getCmd_descricao() {
		return cmd_descricao;
	}

	public void setCmd_descricao(String cmd_descricao) {
		this.cmd_descricao = cmd_descricao;
	}

	public Date getCmd_datahora() {
		return cmd_datahora;
	}

	public void setCmd_datahora(Date cmd_datahora) {
		this.cmd_datahora = cmd_datahora;
	}

	public Filial getFil_codigo() {
		return fil_codigo;
	}

	public void setFil_codigo(Filial fil_codigo) {
		this.fil_codigo = fil_codigo;
	}

	public String getCmd_observacao() {
		return cmd_observacao;
	}

	public void setCmd_observacao(String cmd_observacao) {
		this.cmd_observacao = cmd_observacao;
	}

	public int getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(int versionNum) {
		this.versionNum = versionNum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JSONObject getJson() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("cmd_codigo", cmd_codigo);
		map.put("cmd_descricao", cmd_descricao);
		map.put("cmd_datahora", cmd_datahora);
		map.put("cmd_observacao", cmd_observacao);		
		return new JSONObject(map);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cmd_codigo ^ (cmd_codigo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CriancaMedicamento other = (CriancaMedicamento) obj;
		if (cmd_codigo != other.cmd_codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Crianca_Medicamento [dia_codigo=" + cmd_codigo + ", dia_descricao=" + cmd_descricao + "]";
	}

}
