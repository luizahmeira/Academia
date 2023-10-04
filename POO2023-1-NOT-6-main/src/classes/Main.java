package classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        try {
            Plano planoA = new Plano("Plano A", "Sem adicional de treino");
            Plano planoB = new Plano("Plano B", "Com adicional de treino");

            Aluno teste1 = new Aluno("Mariah", LocalDate.of(2004, 11, 17), "Rua Victor Konder, 99, apt 1002", "+55 (47) 99143-2434", "eisingbrenda@gmail.com",
                    'F', 1.65, 75.0, "Perder peso", planoB, "Tem asma", 120.0);
            Aluno teste2 = new Aluno("Jose", LocalDate.of(2005, 9, 9), "Rua Antonio da Veiga, 908", "+55 (47) 99783-2374", "josensei@gmail.com",
                    'M', 1.95, 75.0, "Ganhar massa muscular", planoA, "Tem arritmia", 80.0);

            Instrutor instrutor1 = new Instrutor("Camile", LocalDate.of(2003, 5, 10), "Joiville street, 87", "+55 (47)9555-9012",
                    "camile.flohr@gmail.com", 'F', "Musculação", "123.456.789-00", true);

            Treino treino1 = new Treino(instrutor1, teste1, "Treino A", "Treino de perda de peso", "Agachamento", 3, 12);
            Treino treino2 = new Treino(instrutor1, teste2, "Treino B", "Treino de musculação", "Elevação pélvica", 3, 20);

            GestaoAcademia academia = new GestaoAcademia();
            Dados_Json dados = new Dados_Json();
            
            academia.cadastrarAluno(teste1);    
            academia.cadastrarAluno(teste2);
            academia.cadastrarInstrutor(instrutor1);
            academia.cadastrarPlano(planoA);
            academia.cadastrarPlano(planoB);
            academia.cadastrarTreino(treino1);
            academia.cadastrarTreino(treino2);
            academia.realizarPresenca(teste1, 1, LocalDate.now());
            academia.realizarPresenca(teste2, 1, LocalDate.now());
       
   
            System.out.println("==== Dados salvos em arquivo json ====");     
            dados.add(planoA);
            dados.add(planoB);
            dados.add(teste1);
            dados.add(teste2);
            dados.add(instrutor1);
            dados.add(treino1);
            dados.add(treino2);
            System.out.println("-----------------------------");
            
            System.out.println("==== Alunos importados ====");
            for (Aluno aluno : dados.extrair_Dados()) {
                System.out.println(aluno);
                academia.cadastrarAluno(aluno);    
                System.out.println("-----------------------------");
            }
            System.out.println("-----------------------------");
            
            
			System.out.println("==== Alunos Serializados ====");	
			Persistencia.escrever(academia.getAlunos(), "alunos.ser");
			List<?> alunosDesserializados = Persistencia.ler("alunos.ser");
			System.out.println("-----------------------------");
			
			System.out.println("==== Instrutores Serializados ====");
			Persistencia.escrever(academia.getInstrutores(), "instrutores.ser");
			List<?> instrutoresDesserializados = Persistencia.ler("instrutores.ser");
			System.out.println("-----------------------------");
			
			System.out.println("==== Planos Serializados ====");
			Persistencia.escrever(academia.getPlanos(), "planos.ser");
			List<?> planosDesserializados = Persistencia.ler("planos.ser");
			System.out.println("-----------------------------");
			
			System.out.println("==== Treinos Serializados ====");
			Persistencia.escrever(academia.getTreinos(), "treinos.ser");
			List<?> treinosDesserializados = Persistencia.ler("treinos.ser");
			System.out.println("-----------------------------");
			
			System.out.println("==== Presenças Serializados ====");
			Persistencia.escrever(academia.getPresencas(), "presenca.ser");
			List<?> presencaDesserializados = Persistencia.ler("presenca.ser");
			System.out.println("-----------------------------");
			
			
            System.out.println("==== Alunos cadastrados ====");
            for (Aluno aluno : GestaoAcademia.getAlunos()) {
                System.out.println(aluno);
                System.out.println("-----------------------------");
            }

            System.out.println("==== Presenças registradas ====");
            for (Presenca presenca : academia.getPresencas()) {
                System.out.println(presenca);
                System.out.println("-----------------------------");
            }

            List<Instrutor> instrutores = academia.getInstrutores();
            System.out.println("==== Instrutores Cadastrados ====");
            for (Instrutor instrutor : instrutores) {
                System.out.println(instrutor);
                System.out.println("-----------------------------");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
