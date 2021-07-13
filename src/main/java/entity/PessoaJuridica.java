package entity;

public class PessoaJuridica extends Imposto {
    private Integer numeroDeEmpregados;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, Double rendaAnual, Integer numeroDeEmpregados) {
        super(nome, rendaAnual);
        this.numeroDeEmpregados = numeroDeEmpregados;
    }

    public Integer getNumeroDeEmpregados() {
        return numeroDeEmpregados;
    }

    public void setNumeroDeEmpregados(Integer numeroDeEmpregados) {
        this.numeroDeEmpregados = numeroDeEmpregados;
    }

    @Override
    public Double taxa() {

        if (this.numeroDeEmpregados <= 10) {
            return this.rendaAnual * 0.16;
        } else
            return this.rendaAnual * 0.14;
    }
}
