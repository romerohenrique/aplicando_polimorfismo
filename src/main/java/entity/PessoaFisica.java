package entity;

public class PessoaFisica extends Imposto {

    private Double despesaComSaude;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, Double rendaAnual, Double despesaComSaude) {
        super(nome, rendaAnual);
        this.despesaComSaude = despesaComSaude;
    }

    public Double getDespesaComSaude() {
        return despesaComSaude;
    }

    public void setDespesaComSaude(Double despesaComSaude) {
        this.despesaComSaude = despesaComSaude;
    }

    @Override
    public Double taxa() {
        double imposto = 0.00;
        if (this.rendaAnual < 20000.00) {
            imposto = this.rendaAnual * 0.15;
        } else {
            imposto = this.rendaAnual * 0.25;
        }
        if (this.despesaComSaude > 0) {
            imposto -= despesaComSaude * 0.5;
            if (imposto < 0.00) {
                imposto = 0.00;
            } else {
                return imposto;
            }
        }
        return imposto;
    }
}
