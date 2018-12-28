package entidades;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

public class Funcionario {
	private int id;
	private String nome;
	private String usuario;
	private String senha;
	private int idade;
	DateTime start;
	private DateTime end = new DateTime();

	public Funcionario(String nome, String usuario, String senha, int dia, int mes, int ano) {
		super();
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		start = new DateTime(ano, mes, dia, 0, 0, 0, 0);
		this.setIdade(dia, mes, ano);

	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int dia, int mes, int ano) {
		int idadeC;
		Period per = new Period(start, end);
		PeriodFormatter pf = new PeriodFormatterBuilder().appendYears().appendSuffix(" ano, ", " anos, ").appendMonths()
				.appendSuffix(" mês, ", " meses, ").appendWeeks().appendSuffix(" semana e ", " semanas e ").appendDays()
				.appendSuffix(" dia ", " dias ").toFormatter();
		idadeC = per.getYears();
		System.out.println(idadeC);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
