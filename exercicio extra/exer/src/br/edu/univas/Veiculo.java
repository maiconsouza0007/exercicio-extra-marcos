package br.edu.univas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Veiculo {
    private final String marca;
    private final int anoFabricacao;
    private final String modelo;
    private final int potencia;

    public Veiculo(String marca, int anoFabricacao, String modelo, int potencia) {
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    public String getMarca() {
        return marca;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Ano de Fabricação: " + anoFabricacao + ", Modelo: " + modelo + ", Potência: " + potencia;
    }
}

class Carro extends Veiculo {
    private final String tracao;
    private final int quantidadePortas;

    public Carro(String marca, int anoFabricacao, String modelo, int potencia, String tracao, int quantidadePortas) {
        super(marca, anoFabricacao, modelo, potencia);
        this.tracao = tracao;
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tração: " + tracao + ", Quantidade de Portas: " + quantidadePortas;
    }
}

class Caminhao extends Veiculo {
    private final int capacidadeCarga;

    public Caminhao(String marca, int anoFabricacao, String modelo, int potencia, int capacidadeCarga) {
        super(marca, anoFabricacao, modelo, potencia);
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public String toString() {
        return super.toString() + ", Capacidade de Carga: " + capacidadeCarga;
    }
}

class SistemaControleVeiculos {
    private final List<Veiculo> veiculos;

    public SistemaControleVeiculos() {
        veiculos = new ArrayList<>();
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
        } else {
            for (Veiculo veiculo : veiculos) {
                System.out.println(veiculo);
            }
        }
    }

    public List<Veiculo> listarVeiculosPorAno(int ano) {
        List<Veiculo> veiculosPorAno = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getAnoFabricacao() == ano) {
                veiculosPorAno.add(veiculo);
            }
        }
        return veiculosPorAno;
    }

    public Map<String, Integer> quantidadeVeiculosPorMarca() {
        Map<String, Integer> quantidadePorMarca = new HashMap<>();
        for (Veiculo veiculo : veiculos) {
            String marca = veiculo.getMarca();
            quantidadePorMarca.put(marca, quantidadePorMarca.getOrDefault(marca, 0) + 1);
        }
        return quantidadePorMarca;
    }
}

class Main {
    public static void main(String[] args) {
        SistemaControleVeiculos sistema = new SistemaControleVeiculos();

        Carro carro1 = new Carro("Fiat", 2020, "Palio", 100, "Dianteira", 4);
        Carro carro2 = new Carro("Volkswagen", 2021, "Gol", 120, "Dianteira", 4);
        Caminhao caminhao1 = new Caminhao("Mercedes-Benz", 2022, "Actros", 400, 10000);

        sistema.cadastrarVeiculo(carro1);
        sistema.cadastrarVeiculo(carro2);
        sistema.cadastrarVeiculo(caminhao1);

        System.out.println("Lista de veículos cadastrados:");
        sistema.listarVeiculos();

        System.out.println("\nLista de veículos cadastrados no ano de 2021:");
        List<Veiculo> veiculosPorAno = sistema.listarVeiculosPorAno(2021);
        for (Veiculo veiculo : veiculosPorAno) {
            System.out.println(veiculo);
        }

        System.out.println("\nQuantidade de veículos por marca:");
        Map<String, Integer> quantidadePorMarca = sistema.quantidadeVeiculosPorMarca();
        for (Map.Entry<String, Integer> entry : quantidadePorMarca.entrySet()) {
            System.out.println("Marca: " + entry.getKey() + ", Quantidade: " + entry.getValue());
        }
    }
}
