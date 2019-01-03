package entidades;

import java.util.Arrays;

import entidades.Funcionario;

public class TEste {

	public static void main(String[] args) {
		Funcionario f = new Funcionario("Leo", "leoeifert", "123", 29, 12, 1999);
		String alunoRecebido = "Teste, teste1, teste2";
		String[] textoSeparado = alunoRecebido.split(",");
		 
		System.out.println(textoSeparado[1]);
	}

}
