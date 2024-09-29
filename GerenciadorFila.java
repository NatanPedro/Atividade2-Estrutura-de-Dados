public class GerenciadorFila {
    Fila filaPrioritaria;
    Fila filaComum;
    int atendimentosPrioritarios;

    public GerenciadorFila() {
        filaPrioritaria = new Fila();
        filaComum = new Fila();
        atendimentosPrioritarios = 0;
    }

    public void adicionarPacientePrioritario(int idPaciente) {
        filaPrioritaria.enfileirar(idPaciente);
    }

    public void adicionarPacienteComum(int idPaciente) {
        filaComum.enfileirar(idPaciente);
    }

    public int chamarProximoPaciente() {
        if (!filaPrioritaria.estaVazia() && atendimentosPrioritarios < 3) {
            atendimentosPrioritarios++;
            return filaPrioritaria.desenfileirar();
        } else if (!filaComum.estaVazia()) {
            atendimentosPrioritarios = 0;
            return filaComum.desenfileirar();
        } else if (!filaPrioritaria.estaVazia()) {
            return filaPrioritaria.desenfileirar();
        } else {
            throw new RuntimeException("Nenhum paciente para atender.");
        }
    }

    public int visualizarProximoPaciente() {
        if (!filaPrioritaria.estaVazia() && atendimentosPrioritarios < 3) {
            return filaPrioritaria.inicio.dado;
        } else if (!filaComum.estaVazia()) {
            return filaComum.inicio.dado;
        } else if (!filaPrioritaria.estaVazia()) {
            return filaPrioritaria.inicio.dado;
        } else {
            throw new RuntimeException("Nenhum paciente para atender.");
        }
    }

    public void listarSenhasPrioritarias() {
        filaPrioritaria.listarSenhas();
    }

    public void listarSenhasComuns() {
        filaComum.listarSenhas();
    }
}