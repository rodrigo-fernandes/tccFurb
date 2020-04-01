package br.com.project.model.classes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
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
@Table(name = "diario")
@SequenceGenerator(name = "diario_seq", sequenceName = "diario_seq", initialValue = 1, allocationSize = 1)
public class Diario {

	private static final long serialVersionUID = 1L;

	@IdentificaCampoPesquisa(descricaoCampo = "Código", campoConsulta = "dia_codigo")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diario_seq")
	private Long dia_codigo;

	@IdentificaCampoPesquisa(descricaoCampo = "Descrição", campoConsulta = "dia_descricao", principal = 1)
	@Column(length = 500, nullable = false)
	private String dia_descricao;

	@IdentificaCampoPesquisa(descricaoCampo = "Data", campoConsulta = "dia_datahora", principal = 1)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dia_datahora = new Date();

	@ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name = "fil_codigo_fk")
	@JoinColumn(name = "fil_codigo") 
	private Filial fil_codigo;

	@Version
	@Column(name = "versionNum")
	private int versionNum;

	public Long getDia_codigo() {
		return dia_codigo;
	}

	public void setDia_codigo(long dia_codigo) {
		this.dia_codigo = dia_codigo;
	}

	public String getDia_descricao() {
		return dia_descricao;
	}

	public void setDia_descricao(String dia_descricao) {
		this.dia_descricao = dia_descricao;
	}

	public Date getDia_datahora() {
		return dia_datahora;
	}

	public void setDia_datahora(Date dia_datahora) {
		this.dia_datahora = dia_datahora;
	}

	public Filial getFil_codigo() {
		return fil_codigo;
	}

	public void setFil_codigo(Filial fil_codigo) {
		this.fil_codigo = fil_codigo;
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
		map.put("dia_codigo", dia_codigo);
		map.put("dia_descricao", dia_descricao);
		map.put("dia_datahora", dia_datahora);
		return new JSONObject(map);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (dia_codigo ^ (dia_codigo >>> 32));
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
		Diario other = (Diario) obj;
		if (dia_codigo != other.dia_codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Diario [dia_codigo=" + dia_codigo + ", dia_descricao=" + dia_descricao + "]";
	}

}
