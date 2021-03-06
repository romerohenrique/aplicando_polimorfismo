package application;

import entity.Contribuinte;
import entity.PessoaFisica;
import entity.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ImpostosApplication {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);// formato fracionário americano
        Scanner sc = new Scanner(System.in);

        /*
        fazendo um upcasting na superclasse abstrata, dessa forma consguimos acessar as subclasses
        utilizando-se do polimorfismo, alterando os métodos, e agrupando em uma lista única do tipo
        Contribuinte.
         */
        List<Contribuinte> list = new ArrayList<>();

        System.out.print("Digite quantos impostos à declarar: ");
        int n = sc.nextByte();
        for (int i = 1; i <= n; i++) {
            System.out.println("Imposto do " + i + "º declaração: ");
            System.out.println("Digite a opção:\n" + " (1) Pessoa Física  (2) Pessoa Jurídica\n");
            int opc = sc.nextInt();
            sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            if (opc == 1) {
                System.out.print("Renda Anual: ");
                double rendaAnual = sc.nextDouble();
                System.out.print("Despesas com saúde: ");
                double depesasComSaude = sc.nextDouble();
                list.add(new PessoaFisica(nome, rendaAnual, depesasComSaude));

            } else {
                System.out.print("Renda Anual: ");
                double rendaAnual = sc.nextDouble();
                System.out.print("Números de Funcionários: ");
                int numeroDeFuncionario = sc.nextInt();
                list.add(new PessoaJuridica(nome, rendaAnual, numeroDeFuncionario));
            }
            System.out.println();
        }

        System.out.println();
        double sum = 0.00;
        System.out.println("Impostos pagos:");
        for (Contribuinte aux : list) {
            System.out.println(aux.getNome() + ": $" + String.format("%.2f", aux.taxa()));
        }
        for (Contribuinte imp : list) {
            sum += imp.taxa();
        }
        System.out.println();
        System.out.println("Total Taxas: $" + String.format("%.2f", sum));
        sc.close();
    }
}
