package br.com.project.model.classes;

import java.io.Serializable;
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
@Table(name = "filial")
@SequenceGenerator(name = "filial_seq", sequenceName = "filial_seq", initialValue = 1, allocationSize = 1)
public class Filial implements Serializable {

	private static final long serialVersionUID = 758145504502063775L;

	@IdentificaCampoPesquisa(descricaoCampo = "Código", campoConsulta = "fil_codigo")
	@Id
	@Column(name = "fil_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filial_seq")
	private Long fil_codigo;

	/*
	@IdentificaCampoPesquisa(descricaoCampo = "Descrição", campoConsulta = "fil_descricao", principal = 1)
	@Column(length = 100, nullable = false)
	private String fil_descricao;
	*/

	@Column(length = 100)
	private String fil_endereco;

	@Column(length = 20)
	private String fil_fone;

	/*
	@Column(length = 20)
	private String fil_fax;
	*/

	@Column(length = 15)
	private String fil_cep;
	
	@Column(nullable = false)
	private Boolean fil_tolerancia_lactose = false;
	
	@Column(nullable = false)
	private Boolean fil_tolerancia_glutem = false;
	
	@Column(nullable = false)
	private Boolean fil_tolerancia_amendoin = false;
	
	@Column(nullable = false)
	private Boolean fil_diabete_tipo_1 = false;		
	
	@Column(nullable = false)
	private Boolean fil_diabete_tipo_2 = false;
	
	@Column(nullable = false)
	private Boolean fil_asma = false;
	
	@Column(nullable = false)
	private Boolean fil_bronquite = false;	

	@Column(nullable = false)
	private Boolean fil_frutos_mar = false;
	
	@Column(nullable = false)
	private Boolean fil_soja = false;
	
	@Column(nullable = false)
	private Boolean fil_ovo = false;
	
	@Column(length = 255, nullable = true)
	private String fil_outros;	

	@ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name = "bai_codigo_fk")
	@JoinColumn(name = "bai_codigo")
	private Bairro bai_codigo = new Bairro();

	@ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name = "cid_codigo_fk")
	@JoinColumn(name = "cid_codigo")
	private Cidade cid_codigo = new Cidade();
	
	
	@IdentificaCampoPesquisa(descricaoCampo = "Nome", campoConsulta = "fil_nome", principal = 1)
	@Column(length = 255, nullable = false)
	private String fil_nome;
	
	@IdentificaCampoPesquisa(descricaoCampo = "RG", campoConsulta = "fil_rg", principal = 1)
	@Column(length = 10, nullable = true)
	private String fil_rg;
	
	@IdentificaCampoPesquisa(descricaoCampo = "CPF", campoConsulta = "cri_cpf", principal = 1)
	@Column(length = 15, nullable = true)
	private String fil_cpf;	
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fil_datacadastro = new Date();	

	@IdentificaCampoPesquisa(descricaoCampo = "Data Nascimento", campoConsulta = "fil_datanascimento", principal = 1)
	@Temporal(TemporalType.DATE)
	private Date fil_datanascimento;	
	
	@IdentificaCampoPesquisa(descricaoCampo = "Observação", campoConsulta = "fil_observacao", principal = 1)
	@Column(length = 5000, nullable = false)
	private String fil_observacao;		
	
	
	public Boolean getFil_tolerancia_lactose() {
		return fil_tolerancia_lactose;
	}

	public void setFil_tolerancia_lactose(Boolean fil_tolerancia_lactose) {
		this.fil_tolerancia_lactose = fil_tolerancia_lactose;
	}
	

	public Boolean getFil_tolerancia_glutem() {
		return fil_tolerancia_glutem;
	}

	public void setFil_tolerancia_glutem(Boolean fil_tolerancia_glutem) {
		this.fil_tolerancia_glutem = fil_tolerancia_glutem;
	}

	
	
	public Boolean getFil_tolerancia_amendoin() {
		return fil_tolerancia_amendoin;
	}

	public void setFil_tolerancia_amendoin(Boolean fil_tolerancia_amendoin) {
		this.fil_tolerancia_amendoin = fil_tolerancia_amendoin;
	}


	public Boolean getFil_diabete_tipo_1() {
		return fil_diabete_tipo_1;
	}

	public void setFil_diabete_tipo_1(Boolean fil_diabete_tipo_1) {
		this.fil_diabete_tipo_1 = fil_diabete_tipo_1;
	}

	public Boolean getFil_diabete_tipo_2() {
		return fil_diabete_tipo_2;
	}

	public void setFil_diabete_tipo_2(Boolean fil_diabete_tipo_2) {
		this.fil_diabete_tipo_2 = fil_diabete_tipo_2;
	}

	public Boolean getFil_asma() {
		return fil_asma;
	}

	public void setFil_asma(Boolean fil_asma) {
		this.fil_asma = fil_asma;
	}

	public Boolean getFil_bronquite() {
		return fil_bronquite;
	}

	public void setFil_bronquite(Boolean fil_bronquite) {
		this.fil_bronquite = fil_bronquite;
	}

	public Boolean getFil_frutos_mar() {
		return fil_frutos_mar;
	}

	public void setFil_frutos_mar(Boolean fil_frutos_mar) {
		this.fil_frutos_mar = fil_frutos_mar;
	}

	public Boolean getFil_soja() {
		return fil_soja;
	}

	public void setFil_soja(Boolean fil_soja) {
		this.fil_soja = fil_soja;
	}


	public Boolean getFil_ovo() {
		return fil_ovo;
	}

	public void setFil_ovo(Boolean fil_ovo) {
		this.fil_ovo = fil_ovo;
	}

	public String getFil_outros() {
		return fil_outros;
	}

	public void setFil_outros(String fil_outros) {
		this.fil_outros = fil_outros;
	}





	/*@Column(length = 100)
	private String fil_enderecoemail;

	private Integer fil_portaemail;
	 
	
	private Boolean fil_autenticaremail; 
	 
	
	@Column(length = 100)
	@Enumerated(EnumType.STRING)
	private SegurancaEmail fil_segurancaemail;

	@Column(length = 100)
	@Enumerated(EnumType.STRING)
	private EmailAutenticacao fil_autenticacaoemail;

	@Column(length = 100)
	private String fil_usuarioemail;

	@Column(length = 100)
	private String fil_senhaemail;

	@Column(length = 50)
	private String fil_statuscomissao;
	
	private String fil_servidoremail;
	*/
	@Version
	@Column(name = "versionNum")
	private int versionNum;
	
	protected int getVersionNum() { 
		return versionNum;
	}

	public void setVersionNum(int versionNum) {
		this.versionNum = versionNum;
	}

	/*
	public String getFil_statuscomissao() {
		return fil_statuscomissao;
	}

	public void setFil_statuscomissao(String fil_statuscomissao) {
		this.fil_statuscomissao = fil_statuscomissao;
	}*/

	public Long getFil_codigo() {
		return fil_codigo;
	}

	public void setFil_codigo(Long fil_codigo) {
		this.fil_codigo = fil_codigo;
	}

	/*
	public String getFil_descricao() {
		return fil_descricao;
	}

	public void setFil_descricao(String fil_descricao) {
		this.fil_descricao = fil_descricao;
	}*/

	public String getFil_endereco() {
		return fil_endereco;
	}

	public void setFil_endereco(String fil_endereco) {
		this.fil_endereco = fil_endereco;
	}

	public String getFil_fone() {
		return fil_fone;
	}

	public void setFil_fone(String fil_fone) {
		this.fil_fone = fil_fone;
	}

	/*
	public String getFil_fax() {
		return fil_fax;
	}

	public void setFil_fax(String fil_fax) {
		this.fil_fax = fil_fax;
	}*/

	public String getFil_cep() {
		return fil_cep;
	}

	public void setFil_cep(String fil_cep) {
		this.fil_cep = fil_cep;
	}

	public Bairro getBai_codigo() {
		return bai_codigo;
	}

	public void setBai_codigo(Bairro bai_codigo) {
		this.bai_codigo = bai_codigo;
	}

	public Cidade getCid_codigo() {
		return cid_codigo;
	}

	public void setCid_codigo(Cidade cid_codigo) {
		this.cid_codigo = cid_codigo;
	}

	/*
	public String getFil_enderecoemail() {
		return fil_enderecoemail;
	}

	public void setFil_enderecoemail(String fil_enderecoemail) {
		this.fil_enderecoemail = fil_enderecoemail;
	}

	public Integer getFil_portaemail() {
		return fil_portaemail;
	}

	public void setFil_portaemail(Integer fil_portaemail) {
		this.fil_portaemail = fil_portaemail;
	}

	public Boolean getFil_autenticaremail() {
		return fil_autenticaremail;
	}

	public void setFil_autenticaremail(Boolean fil_autenticaremail) {
		this.fil_autenticaremail = fil_autenticaremail;
	}

	public SegurancaEmail getFil_segurancaemail() {
		return fil_segurancaemail;
	}

	public void setFil_segurancaemail(SegurancaEmail fil_segurancaemail) {
		this.fil_segurancaemail = fil_segurancaemail;
	}

	public EmailAutenticacao getFil_autenticacaoemail() {
		return fil_autenticacaoemail;
	}

	public void setFil_autenticacaoemail(EmailAutenticacao fil_autenticacaoemail) {
		this.fil_autenticacaoemail = fil_autenticacaoemail;
	}

	public String getFil_usuarioemail() {
		return fil_usuarioemail;
	}

	public void setFil_usuarioemail(String fil_usuarioemail) {
		this.fil_usuarioemail = fil_usuarioemail;
	}

	public String getFil_senhaemail() {
		return fil_senhaemail;
	}

	public void setFil_senhaemail(String fil_senhaemail) {
		this.fil_senhaemail = fil_senhaemail;
	}
	

	public String getFil_servidoremail() {
		return fil_servidoremail;
	}
	
	public void setFil_servidoremail(String fil_servidoremail) {
		this.fil_servidoremail = fil_servidoremail;
	}
	*/
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fil_codigo == null) ? 0 : fil_codigo.hashCode());
		return result;
	}

	public String getFil_nome() {
		return fil_nome;
	}

	public void setFil_nome(String fil_nome) {
		this.fil_nome = fil_nome;
	}

	public String getFil_rg() {
		return fil_rg;
	}

	public void setFil_rg(String fil_rg) {
		this.fil_rg = fil_rg;
	}

	public String getFil_cpf() {
		return fil_cpf;
	}

	public void setFil_cpf(String fil_cpf) {
		this.fil_cpf = fil_cpf;
	}

	public Date getFil_datacadastro() {
		return fil_datacadastro;
	}

	public void setFil_datacadastro(Date fil_datacadastro) {
		this.fil_datacadastro = fil_datacadastro;
	}

	public Date getFil_datanascimento() {
		return fil_datanascimento;
	}

	public void setFil_datanascimento(Date fil_datanascimento) {
		this.fil_datanascimento = fil_datanascimento;
	}

	public String getFil_observacao() {
		return fil_observacao;
	}

	public void setFil_observacao(String fil_observacao) {
		this.fil_observacao = fil_observacao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filial other = (Filial) obj;
		if (fil_codigo == null) {
			if (other.fil_codigo != null)
				return false;
		} else if (!fil_codigo.equals(other.fil_codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Filial [fil_codigo=" + fil_codigo + ", fil_nome="
				+ fil_nome + "]";
	}

	public JSONObject getJson() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("fil_codigo", fil_codigo);
		map.put("fil_nome", fil_nome);
		return new JSONObject(map);
	}
}
