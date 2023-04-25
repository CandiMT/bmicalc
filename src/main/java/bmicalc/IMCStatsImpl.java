package bmicalc;

import java.util.ArrayList;
import java.util.List;

public class IMCStatsImpl implements IMCStats {
    private static IMCStatsImpl instance = null;
    private List<Paciente> pacientes;

    private IMCStatsImpl() {
        pacientes = new ArrayList<>();
    }

    public static IMCStatsImpl getInstance() {
        if (instance == null) {
            instance = new IMCStatsImpl();
        }
        return instance;
    }

    public void agregarPaciente(double altura, double peso, double imc) {
        pacientes.add(new Paciente(altura, peso, imc));
    }

    public double alturaMedia() {
        double total = 0;
        for (Paciente p : pacientes) {
            total += p.getAltura();
        }
        return total / pacientes.size();
    }

    public double pesoMedio() {
        double total = 0;
        for (Paciente p : pacientes) {
            total += p.getPeso();
        }
        return total / pacientes.size();
    }

    public double imcMedio() {
        double total = 0;
        for (Paciente p : pacientes) {
            total += p.getIMC();
        }
        return total / pacientes.size();
    }

    public int numPacientes() {
        return pacientes.size();
    }

    private class Paciente {
        private double altura;
        private double peso;
        private double imc;

        public Paciente(double altura, double peso, double imc) {
            this.altura = altura;
            this.peso = peso;
            this.imc = imc;
        }

        public double getAltura() {
            return altura;
        }

        public double getPeso() {
            return peso;
        }

        public double getIMC() {
            return imc;
        }
    }
}
