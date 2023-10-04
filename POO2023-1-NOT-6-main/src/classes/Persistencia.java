package classes;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Persistencia {    
 
        public static void escrever(List<?> obj, String arquivoNome) {
            try {
                File arquivo = new File(arquivoNome);
                FileOutputStream file = new FileOutputStream(arquivo);
                ObjectOutputStream out = new ObjectOutputStream(file);

                out.writeObject(obj);

                out.close();
                file.close();

                System.out.println("Dados foram serializados.");
            } catch (IOException e) {
                System.out.println("Ocorreu um erro ao serializar os objetos: " + e);
            }
        }

        public static List<?> ler(String arquivoNome) {
            List<?> objetosdesserializados = new ArrayList<>();

            try {
                File arquivo = new File(arquivoNome);

                if (arquivo.exists()) {
                    FileInputStream file = new FileInputStream(arquivo);
                    ObjectInputStream input = new ObjectInputStream(file);

                    objetosdesserializados = (List<?>) input.readObject();

                    input.close();
                    file.close();

                    for (Object objeto : objetosdesserializados) {
                        System.out.println("DESSERIALIZADO: " + objeto);
                    }
                } else {
                    System.out.println("O arquivo não existe.");
                }
            } catch (IOException e) {
                System.out.println("Ocorreu um erro ao desserializar o objeto: " + e);
            } catch (ClassNotFoundException e) {
                System.out.println("Classe do objeto serializado não encontrada: " + e);
            }

            System.out.println("FIM\n");
            return objetosdesserializados;
        }
    }



