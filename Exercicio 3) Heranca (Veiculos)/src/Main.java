public class Main {
    public static void main(String[] args)
    {
        Veiculo[] v = new Veiculo[5];
        v[0] = new Veiculo("Moto", 14.f, 2, "Cheio");
        v[1] = new Carro("Onix", 120.f, 4, "Vazio", 2020, "4 portas");
        v[2] = new Aviao("Boeing 747", 950.f, 200, "Metade cheio", "Comercial", "Nacional");
        v[3] = new Carro("Civic", 150.f, 4, "3/4 Cheio", 2014, "2 portas");
        v[4] = new Veiculo("Barco", 0.f, 0, "Vazio");

        for (Veiculo veiculo : v) {
            System.out.println(veiculo);
        }

        System.out.println(v[0].toString());

        Carro c1 = new Carro("Fiat Uno", 20.f, 4, "Vazio", 2022, "4 portas");

        System.out.println(c1.toString());

        Aviao a1 = new Aviao("Aviao", 500.f, 200, "Cheio", "Jato", "Internacional");

        System.out.println(a1.toString());

    }
}