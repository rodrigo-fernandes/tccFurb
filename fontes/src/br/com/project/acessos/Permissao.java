package br.com.project.acessos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum Permissao {
	
	ADMIN("ADMIN", "Administrador"),
	USER("USER","Usuário Padrão"), 
	CADASTRO_ACESSAR("CADASTRO_ACESSAR", "Cadastro - Acessar"),
    FINANCIERO_ACESSAR("FINANCIERO_ACESSAR", "Financeiro - Acessar"),
	MENSAGEM_ACESSAR("MENSAGEM_ACESSAR", "Mensagem recebida - Acessar"),
	
	BAIRRO_ACESSAR("BAIRRO_ACESSAR", "Bairro - Acessar"),
	BAIRRO_NOVO("BAIRRO_NOVO", "Bairro - Novo"),
	BAIRRO_EDITAR("BAIRRO_EDITAR", "Bairro - Editar"),
	BAIRRO_EXCLUIR("BAIRRO_EXCLUIR", "Bairro - Excluir"),
	
	CIDADE_ACESSAR("CIDADE_ACESSAR", "Cidade - Acessar"),
	CIDADE_NOVO("CIDADE_NOVO", "Cidade - Novo"),
	CIDADE_EDITAR("CIDADE_EDITAR", "Cidade - Editar"),
	CIDADE_EXCLUIR("CIDADE_EXCLUIR", "Cidade - Excluir"),

	DIARIO_ACESSAR("DIARIO_ACESSAR", "Diario - Acessar"),
	DIARIO_NOVO("DIARIO_NOVO", "Diario - Novo"),
	DIARIO_EDITAR("DIARIO_EDITAR", "Diario - Editar"),
	DIARIO_EXCLUIR("DIARIO_EXCLUIR", "Diario - Excluir"),
	

	CRIANCA_ACESSAR("CRIANCA_ACESSAR", "Criança - Acessar"),
	CRIANCA_NOVO("CRIANCA_NOVO", "Criança - Novo"),
	CRIANCA_EDITAR("CRIANCA_EDITAR", "Criança - Editar"),
	CRIANCA_EXCLUIR("CRIANCA_EXCLUIR", "Criança - Excluir"),	
	

	CLIENTE_ACESSAR("CLIENTE_ACESSAR", "Cliente - Acessar"),
	CLIENTE_NOVO("CLIENTE_NOVO", "Cliente - Novo"),
	CLIENTE_EDITAR("CLIENTE_EDITAR", "Cliente - Editar"),
	CLIENTE_EXCLUIR("CLIENTE_EXCLUIR", "Cliente - Excluir"),
	
	ENVIAR_EMAIL("ENVIAR_EMAIL", "Enviar e-mail"),
	
	FUNCIONARIO_ACESSAR("FUNCIONARIO_ACESSAR", "Funcionário - Acessar"),
	FUNCIONARIO_NOVO("FUNCIONARIO_NOVO", "Funcionário - Novo"),
	FUNCIONARIO_EDITAR("FUNCIONARIO_EDITAR", "Funcionário - Editar"),
	FUNCIONARIO_EXCLUIR("FUNCIONARIO_EXCLUIR", "Funcionário - Excluir"), 
	
	FORNECEDOR_ACESSAR("FORNECEDOR_ACESSAR", "Criança - Acessar"),
	FORNECEDOR_NOVO("FORNECEDOR_NOVO", "Criança - Novo"),
	FORNECEDOR_EDITAR("FORNECEDOR_EDITAR", "Criança - Editar"),
	FORNECEDOR_EXCLUIR("FORNECEDOR_EXCLUIR", "Criança - Excluir"),
	

	MENSAGENS_ENVIAR_ACESSAR("MENSAGENS_ENVIAR_ACESSAR", "Enviar mensagem - Acessar"),
	MENSAGENS_ENVIAR_NOVO("MENSAGENS_ENVIAR_NOVO", "Enviar mensagem - Novo"),
	MENSAGENS_ENVIAR_EDITAR("MENSAGENS_ENVIAR_EDITAR", "Enviar mensagem - Editar"),
	MENSAGENS_ENVIAR_EXCLUIR("MENSAGENS_ENVIAR_EXCLUIR", "Enviar mensagem - Excluir"),
	
	APPLET_FILE_LOCAL("APPLET_FILE_LOCAL", "Habilitar - Applet");
	
	private String valor = "";
	private String descricao = "";

	private Permissao(String name, String descricao) {
		this.valor = name;
		this.descricao = descricao;
	}

	private Permissao() {
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return getValor();
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public static List<Permissao> getListPermissao() {
		List<Permissao> permissoes = new ArrayList<Permissao>();
		for (Permissao permissao : Permissao.values()) {
			permissoes.add(permissao);
		}
		Collections.sort(permissoes, new Comparator<Permissao>() {

			@Override
			public int compare(Permissao o1, Permissao o2) {
				return new Integer(o1.ordinal()).compareTo(new Integer(o2.ordinal()));
			}
		});
		return permissoes;
	}

}
