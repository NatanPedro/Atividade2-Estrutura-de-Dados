import java.util.Scanner;

public class Main {

    static GerenciadorFila gerenciador = new GerenciadorFila();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean executando = true;

        while (executando) {
            exibirMenu();
            int opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    solicitarNovaSenha();
                    break;
                case 2:
                    excluirSenha();
                    break;
                case 3:
                    listarSenhas();
                    break;
                case 4:
                    visualizarProximo();
                    break;
                case 5:
                    chamarProximo();
                    break;
                case 0:
                    executando = false;
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nMENU:");
        System.out.println("[1] Solicitar nova senha");
        System.out.println("[2] Excluir uma senha");
        System.out.println("[3] Listar todas as senhas");
        System.out.println("[4] Visualizar quem é o próximo a ser atendido");
        System.out.println("[5] Chamar o próximo a ser atendido");
        System.out.println("[0] Sair");
        System.out.print("Escolha uma opção meu fi: ");
    }

    private static void solicitarNovaSenha() {
        System.out.println("Digite o tipo de senha (1 para Comum, 2 para Prioritária): ");
        int tipoSenha = input.nextInt();
        input.nextLine();

        System.out.println("Digite o número da senha: ");
        int numeroSenha = input.nextInt();
        input.nextLine();

        if (tipoSenha == 1) {
            gerenciador.adicionarPacienteComum(numeroSenha);
            System.out.println("Senha comum " + numeroSenha + " adicionada com sucesso.");
        } else if (tipoSenha == 2) {
            gerenciador.adicionarPacientePrioritario(numeroSenha);
            System.out.println("Senha prioritária " + numeroSenha + " adicionada com sucesso.");
        } else {
            System.out.println("Tipo de senha inválido.");
        }
    }

    private static void excluirSenha() {
        System.out.println("Digite o número da senha a ser excluída: ");
        int senhaExcluir = input.nextInt();
        input.nextLine();

        boolean removido = false;

        removido = gerenciador.filaPrioritaria.removerSenha(senhaExcluir);

        if (!removido) {
            removido = gerenciador.filaComum.removerSenha(senhaExcluir);
        }

        if (removido) {
            System.out.println("Senha " + senhaExcluir + " removida com sucesso.");
        } else {
            System.out.println("Senha " + senhaExcluir + " não encontrada.");
        }
    }

    private static void listarSenhas() {
        System.out.println("Senhas prioritárias:");
        gerenciador.listarSenhasPrioritarias();

        System.out.println("Senhas comuns:");
        gerenciador.listarSenhasComuns();
    }

    private static void visualizarProximo() {
        try {
            int proximoPaciente = gerenciador.visualizarProximoPaciente();
            System.out.println("O próximo paciente a ser atendido tem a senha: " + proximoPaciente);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void chamarProximo() {
        try {
            int proximoPaciente = gerenciador.chamarProximoPaciente();
            System.out.println("Chamando o paciente com a senha: " + proximoPaciente);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}