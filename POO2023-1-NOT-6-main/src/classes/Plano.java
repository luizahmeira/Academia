package classes;

import java.io.Serializable;

public class Plano implements Serializable{

    private static final long serialVersionUID = 38759403L;
    private String plano;
    private String adicionalTreino;
    private double mensalidade;

    public Plano(String plano, String adicionalTreino) {
        this.plano = plano;
        this.adicionalTreino = adicionalTreino;
        setMensalidade();
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        if (!plano.equals("Plano A") && !plano.equals("Plano B")) {
            throw new IllegalArgumentException("Plano inválido! ");
        }
        this.plano = plano;
        setMensalidade();
    }

    public String getAdicionalTreino() {
        return adicionalTreino;
    }

    public void setAdicionalTreino(String adicionalTreino) {
        this.adicionalTreino = adicionalTreino;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    private void setMensalidade() {
        if (plano.equals("Plano A")) {
            this.mensalidade = 80.0;
        } else if (plano.equals("Plano B")) {
            this.mensalidade = 80.0 + 40.0;
        } else {
            throw new IllegalArgumentException("Plano inválido!");
        }
    }


    @Override
    public String toString() {
        return "Plano: " + plano + "\n" +
                "Adicional de Treino: " + adicionalTreino + "\n" +
                "Mensalidade: R$ " + mensalidade;
    }
}
