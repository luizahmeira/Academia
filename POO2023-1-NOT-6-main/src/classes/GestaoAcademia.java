package classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestaoAcademia {
    private final static List<Aluno> alunos = new ArrayList<>();
    private List<Presenca> presencas = new ArrayList<>();
    private final static List<Instrutor> instrutores = new ArrayList<>();
    private final static List<Plano> planos = new ArrayList<>();
    private final static List<Treino> treinos = new ArrayList<>();
   
    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void cadastrarInstrutor(Instrutor instrutor) {
        instrutores.add(instrutor);
    }

    public void cadastrarPlano(Plano plano) {
        planos.add(plano);
    }

    public void cadastrarTreino(Treino treino) {
        treinos.add(treino);
    }

    public void realizarPresenca(Aluno aluno, int frequencia, LocalDate data) {
        Presenca presenca = new Presenca(aluno, frequencia, data);
        presencas.add(presenca);
    }

    public void registrarPagamento(Aluno aluno, double valor) {
        int index = alunos.indexOf(aluno);

        if (index == -1) {
            throw new IllegalArgumentException("Aluno não encontrado.");
        }

        aluno.setValorPago(valor);
    }

    public static List<Aluno> getAlunos() {
        return alunos;
    }

    public static List<Instrutor> getInstrutores() {
        return instrutores;
    }

    public static List<Plano> getPlanos() {
        return planos;
    }

    public static List<Treino> getTreinos() {
        return treinos;
    }

    public List<Presenca> getPresencas() {
        return presencas;
    }
}
