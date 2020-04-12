package br.com.project.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.framework.hibernate.session.HibernateUtil;
import br.com.project.model.classes.Crianca;

@FacesConverter(forClass = Crianca.class)
public class CriancaNewConverter implements Converter, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if (value != null && !value.isEmpty()) {
				return (Crianca) HibernateUtil.getCurrentSession().get(
						Crianca.class, new Long(value));
		}
		return value;
	}
	
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (value != null) {
			Crianca c = (Crianca) value;
			return c.getCri_codigo() != null && c.getCri_codigo() > 0 ? c.getCri_codigo().toString() : null;
		} else {
			return null;
		}
	}

}
