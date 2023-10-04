package classes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Dados_Json {

	private static final String arquivo = "dados_academia.json";
	

	//verifica se o arquivo existe e se o mesmo está vazio
	private boolean fileExists() {
        File file = new File(arquivo);
        return file.exists() && file.length() > 0;
    }
	
	
	//extrai o objeto plano apartir de uma String
		private Plano extrairPlano(String planoString) {
		    String[] partes = planoString.split("\n");

		    String nomePlano = partes[0].replace("Plano: ", "");
		    
		    String adicionalTreinoString = partes[1].replace("Adicional de Treino: ", "");

		    String mensalidadeString = partes[2].replace("Mensalidade: R$ ", "");

		    double mensalidade = Double.parseDouble(mensalidadeString);

		    Plano plano = new Plano(nomePlano, adicionalTreinoString);
		    plano.getMensalidade();

		    return plano;
		}
		
		
		//importa os dados de alunos de um json e os converte para uma lista
		public List<Aluno> extrair_Dados() {
		    JSONArray jsonArray = new JSONArray();
		    JSONParser parser = new JSONParser();
		    List<Aluno> alunos = new ArrayList<>();

		    try {
		        jsonArray = (JSONArray) parser.parse(new FileReader("importar_Alunos.json"));

		        for (Object obj : jsonArray) {
		            JSONObject alunoJson = (JSONObject) obj;
		            
		            //criando o objto aluno apartir dos dados que estão dentro o arquivo json
		            Aluno aluno = new Aluno(
		            		(String) alunoJson.get("nome"),
		                    LocalDate.parse((String) alunoJson.get("dataNascimento")),
		                    (String) alunoJson.get("endereco"),
		                    (String) alunoJson.get("telefone"),
		                    (String) alunoJson.get("email"),
		                    ((String) alunoJson.get("genero")).charAt(0),
		                    ((Number) alunoJson.get("altura")).doubleValue(), //precisa mudar o valor de altura de dentro do json de long para double
		                    ((Number) alunoJson.get("peso")).doubleValue(), //precisa mudar o valor de peso de dentro do json de long para double
		                    (String) alunoJson.get("objetivo"),
		                    extrairPlano((String) alunoJson.get("plano")),
		                    (String) alunoJson.get("observacao"),
		                    ((Number) alunoJson.get("valorPago")).doubleValue() //precisa mudar o valor de valorPago do json de long para double
		            );

		            alunos.add(aluno);
		        }
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    } catch (org.json.simple.parser.ParseException e) {
		        e.printStackTrace();
		    }

		    return alunos;
	}

	//adiciona um aluno ao arquivo json
	public void add(Aluno aluno) {
		try {
			FileWriter fileWriter = new FileWriter(arquivo, true);
	        JSONObject jsonObject = new JSONObject();
	        
	        //adicona os parametros de aluno ao json
	        JSONObject alunoJson = new JSONObject();
	        alunoJson.put("nome", aluno.getNome());
	        alunoJson.put("dataNascimento", ""+aluno.getDtNascimento()+"");
	        alunoJson.put("email", aluno.getEmail());
	        alunoJson.put("endereco", aluno.getEndereco());
	        alunoJson.put("objetivo", aluno.getObjetivo());
	        alunoJson.put("observacao", ""+aluno.getObservacao()+"");
	        alunoJson.put("telefone", aluno.getTelefone());
	        alunoJson.put("altura", aluno.getAltura());
	        alunoJson.put("genero", ""+aluno.getGenero()+"");
	        alunoJson.put("peso", aluno.getPeso());
	        alunoJson.put("plano", ""+aluno.getPlano()+"");
	        alunoJson.put("valorPago", aluno.getValorPago());
	        
	        jsonObject.put("aluno", alunoJson);
	        
	        //colocar vírgula para separar os dados
	        if (fileExists()) {
	            fileWriter.write(",");
	            fileWriter.write(System.lineSeparator());
	        }

	        fileWriter.write(jsonObject.toJSONString());
	        fileWriter.write(System.lineSeparator());
	        fileWriter.close();
	        System.out.println("Dados do aluno adicionados com sucesso.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//adiciona um instrutor ao arquivo json
	public void add(Instrutor instrutor) {
		try {
			FileWriter fileWriter = new FileWriter(arquivo, true);
            JSONObject jsonObject = new JSONObject();
            jsonObject.putIfAbsent("Instrutor", ""+instrutor+"");
            
            if (fileExists()) {
                fileWriter.write(",");
                fileWriter.write(System.lineSeparator());
            }
            
            
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.write(System.lineSeparator());
            fileWriter.close();
            System.out.println("Dados do instrutor adicionados com sucesso.");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//adiciona um plano ao arquivo json
	public void add(Plano plano) {
		try {
			FileWriter fileWriter = new FileWriter(arquivo, true);
            JSONObject jsonObject = new JSONObject();
            jsonObject.putIfAbsent("plano", ""+plano+"");
            
            if (fileExists()) {
                fileWriter.write(",");
                fileWriter.write(System.lineSeparator());
            }
            
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.write(System.lineSeparator());
            fileWriter.close();
            System.out.println("Dados do plano adicionados com sucesso.");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//adiciona um treino ao arquivo json
	public void add(Treino treino) {
	
		try {
			FileWriter fileWriter = new FileWriter(arquivo, true);
            JSONObject jsonObject = new JSONObject();
            jsonObject.putIfAbsent("treino", ""+treino+"");
            
            if (fileExists()) {
                fileWriter.write(",");
                fileWriter.write(System.lineSeparator());
            }
            
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.write(System.lineSeparator());
            fileWriter.close();
            System.out.println("Dados do treino adicionados com sucesso.");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
}





	
	
	