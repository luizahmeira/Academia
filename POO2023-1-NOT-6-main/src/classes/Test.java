package classes;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		
		Plano planoB = new Plano("Plano B", "Com adicional de treino");

		Aluno teste1 = new Aluno("Mariah", LocalDate.of(2004, 11, 17), "Rua Victor Konder, 99, apt 1002", "+55 (47) 99143-2434", "eisingbrenda@gmail.com",
                  				 'F', 1.65, 75.0, "Perder peso", planoB, "Tem asma", 120.0);
		
		 Instrutor instrutor1 = new Instrutor("Camile", LocalDate.of(2003, 5, 10), "Joiville street, 87", "+55 (47)9555-9012",
                 "camile.flohr@gmail.com", 'F', "Musculação", "123.456.789-00", true);
		 
         Treino treino1 = new Treino(instrutor1, teste1, "Treino A", "Treino de perda de peso", "Agachamento", 3, 12);

         GestaoAcademia academia = new GestaoAcademia();

         academia.cadastrarAluno(teste1);
         academia.cadastrarInstrutor(instrutor1);
         academia.cadastrarPlano(planoB);
         academia.cadastrarTreino(treino1);
         
         academia.realizarPresenca(teste1, 1, LocalDate.now());
         academia.realizarPresenca(teste1, 1, LocalDate.of(2023, 1, 28));    
         
         
         for (Presenca presenca : academia.getPresencas()) {
            // System.out.println(presenca.getFrequencia());
             int teste = presenca.getFrequencia();
             teste = teste + presenca.getFrequencia();
             System.out.println(teste);
             
             assertEquals(2, teste);
         }

	}
	
	@org.junit.jupiter.api.Test
	void test1() {
		
		Plano planoB = new Plano("Plano B", "Com adicional de treino");

		Aluno teste1 = new Aluno("Larissa", LocalDate.of(2004, 11, 17), "Rua Victor Konder, 99, apt 1002", "+55 (47) 99143-2434", "eisingbrenda@gmail.com",
                  				 'F', 1.65, 75.0, "Perder peso", planoB, "Tem asma", 120.0);
		
		 Instrutor instrutor1 = new Instrutor("Camile", LocalDate.of(2003, 5, 10), "Joiville street, 87", "+55 (47)9555-9012",
                 "camile.flohr@gmail.com", 'F', "Musculação", "123.456.789-00", true);
		 
         Treino treino1 = new Treino(instrutor1, teste1, "Treino A", "Treino de perda de peso", "Agachamento", 3, 12);

         GestaoAcademia academia = new GestaoAcademia();

         academia.cadastrarAluno(teste1);
         academia.cadastrarInstrutor(instrutor1);
         academia.cadastrarPlano(planoB);
         academia.cadastrarTreino(treino1);
         
         academia.realizarPresenca(teste1, 1, LocalDate.now());
         academia.realizarPresenca(teste1, 1, LocalDate.of(2023, 1, 28));  
         
         assertEquals("Larissa", teste1.getNome());
		
	}

}
