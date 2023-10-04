package classes;
import java.io.Serializable;
import java.time.LocalDate;

public class Instrutor extends Pessoa implements Serializable{

	private static final long serialVersionUID = 12746874678L;
	
	private String areaA;
	private String cpf;
	private boolean personal;

	public Instrutor(String nome, LocalDate dtNascimento, String endereco, String telefone, String email, char genero, String areaA, String cpf, boolean personal) {
		super(nome, dtNascimento, endereco, telefone, email, genero);
		this.areaA = areaA;
		this.cpf = cpf;
		this.personal = personal;
	}
	public static Instrutor getUmInstrutor(String nome) {

		for (Instrutor instrutorComparado : GestaoAcademia.getInstrutores()) {
			
			if (nome.equals(instrutorComparado.getNome())) {
				return instrutorComparado;
			}
		}
		return null;
	}
	
	public static String[] getTodosInstrutores() {
		String retornoInstrutor[] = new String[GestaoAcademia.getInstrutores().size()];
		for (int i = 0; i < GestaoAcademia.getInstrutores().size(); i++) {
			retornoInstrutor[i] = GestaoAcademia.getInstrutores().get(i).getNome();
		}
		return retornoInstrutor;
	}

	public String getAreaA() {
		return areaA;
	}

	public void setAreaA(String areaA) {
		if(areaA.length() < 3) {
			throw new IllegalArgumentException("Informe uma aréa de atuação com mais de 3 dígitos!"); 
		}
		this.areaA = areaA;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if(cpf.length() < 14) {
			throw new IllegalArgumentException("Necessário Digitar o CPF com pontos(.) e traço (-)"); 
		}
		this.cpf = cpf;
	}

	public String getPersonalString() {
	    return personal ? "Sim" : "Não";
	}

	public void setPersonal(boolean personal) {
		this.personal = personal;
	}
	
	@Override
	public String toString() {
	    return super.toString() + "\n" +
	            "Área de Atuação: " + areaA + "\n" +
	            "CPF: " + cpf + "\n" +
	            "Personal: " + personal;
	}


}
