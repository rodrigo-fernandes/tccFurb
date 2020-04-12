package br.com.project.model.classes;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.envers.Audited;
import org.primefaces.json.JSONObject;

import br.com.project.annotation.IdentificaCampoPesquisa;

@Audited
@Entity
@Table(name = "crianca")
@SequenceGenerator(name = "crianca_seq", sequenceName = "crianca_seq", initialValue = 1, allocationSize = 1)
public class Crianca implements Serializable {
	
	private static final long serialVersionUID = 758145504502063775L;
	
	@IdentificaCampoPesquisa(descricaoCampo = "Código", campoConsulta = "cri_codigo")
	@Id
	@Column(name = "cri_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crianca_seq")
	private Long cri_codigo;

	@IdentificaCampoPesquisa(descricaoCampo = "Nome", campoConsulta = "cri_nome", principal = 1)
	@Column(length = 255, nullable = false)
	private String cri_nome;
	
	@IdentificaCampoPesquisa(descricaoCampo = "RG", campoConsulta = "cri_rg", principal = 1)
	@Column(length = 10, nullable = false)
	private String cri_rg;
	
	@IdentificaCampoPesquisa(descricaoCampo = "CPF", campoConsulta = "cri_cpf", principal = 1)
	@Column(length = 15, nullable = false)
	private String cri_cpf;	
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date cri_datacadastro = new Date();	

	@IdentificaCampoPesquisa(descricaoCampo = "Data Nascimento", campoConsulta = "cri_datanascimento", principal = 1)
	@Temporal(TemporalType.DATE)
	private Date cri_datanascimento;	
	
	@IdentificaCampoPesquisa(descricaoCampo = "Observação", campoConsulta = "cri_observacao", principal = 1)
	@Column(length = 5000, nullable = false)
	private String cri_observacao;		
	
	@Version
	@Column(name = "versionNum")
	private int versionNum;

	public Long getCri_codigo() {
		return cri_codigo;
	}

	public void setCri_codigo(Long cri_codigo) {
		this.cri_codigo = cri_codigo;
	}

	public String getCri_nome() {
		return cri_nome;
	}

	public void setCri_nome(String cri_nome) {
		this.cri_nome = cri_nome;
	}

	public String getCri_rg() {
		return cri_rg;
	}

	public void setCri_rg(String cri_rg) {
		this.cri_rg = cri_rg;
	}

	public String getCri_cpf() {
		return cri_cpf;
	}

	public void setCri_cpf(String cri_cpf) {
		this.cri_cpf = cri_cpf;
	}

	public Date getCri_datacadastro() {
		return cri_datacadastro;
	}

	public void setCri_datacadastro(Date cri_datacadastro) {
		this.cri_datacadastro = cri_datacadastro;
	}

	public Date getCri_datanascimento() {
		return cri_datanascimento;
	}

	public void setCri_datanascimento(Date cri_datanascimento) {
		this.cri_datanascimento = cri_datanascimento;
	}

	public String getCri_observacao() {
		return cri_observacao;
	}

	public void setCri_observacao(String cri_observacao) {
		this.cri_observacao = cri_observacao;
	}

	public int getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(int versionNum) {
		this.versionNum = versionNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cri_codigo == null) ? 0 : cri_codigo.hashCode());
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
		Crianca other = (Crianca) obj;
		if (cri_codigo == null) {
			if (other.cri_codigo != null)
				return false;
		} else if (!cri_codigo.equals(other.cri_codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Crianca [cri_codigo=" + cri_codigo + ", cri_nome=" + cri_nome + "]";
	}	
	
	public JSONObject getJson() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("cri_codigo", cri_codigo);
		map.put("cri_nome", cri_nome);
		return new JSONObject(map);
	}
	
	
	
}
