public class Main {
    public static void main(String[] args) {

        Desenvolvedor desenvolvedor = new Desenvolvedor("Leonardo", 19, 80, 150);

        System.out.println("\nInformações do Desenvolvedor:\n" + desenvolvedor.toString());
        System.out.println("\nSalário do Desenvolvedor: R$" + desenvolvedor.calcularSalario());

        Gerente gerente = new Gerente("Rodrigo", 35, 18000.0);

        System.out.println("\n\nInformações do Gerente:\n" + gerente.toString());
        System.out.println("\nSalário do Gerente: R$" + gerente.calcularSalario());

        Designer designer = new Designer("Alice", 21, 6);

        System.out.println("\n\nInformações do Designer:\n" + designer.toString());
        System.out.println("\nSalário do Designer: R$" + designer.calcularSalario());

    }
}