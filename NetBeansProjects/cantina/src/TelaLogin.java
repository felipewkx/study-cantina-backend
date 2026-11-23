
/*
 * Tela de Login - Cantina
 */
public class TelaLogin extends javax.swing.JFrame {

    private final Autenticador autenticador = new Autenticador();
    private int tentativaLogin = 0;

    public TelaLogin() {
        initComponents();

        // Preserva o tamanho original do formulário
        java.awt.Container conteudoOriginal = getContentPane();
        java.awt.Dimension tamanhoReal = conteudoOriginal.getPreferredSize();

        conteudoOriginal.setMinimumSize(tamanhoReal);
        conteudoOriginal.setMaximumSize(tamanhoReal);

        // Centraliza o formulário
        javax.swing.JPanel painelCentralizador
                = new javax.swing.JPanel(new java.awt.GridBagLayout());

        painelCentralizador.setBackground(Tema.FUNDO_TELA);
        painelCentralizador.add(conteudoOriginal,
                new java.awt.GridBagConstraints());

        setContentPane(painelCentralizador);

        // Configura o tamanho padrão apenas para quando a janela NÃO estiver maximizada
        java.awt.Dimension resolucaoJanela
                = new java.awt.Dimension(800, 600);

        setMinimumSize(resolucaoJanela);
        setSize(resolucaoJanela);
        setLocationRelativeTo(null);

        // Botão padrão e tecla Enter
        getRootPane().setDefaultButton(botaoEntrar);

        java.awt.event.ActionListener acaoEnter
                = e -> botaoEntrar.doClick();

        campoUsuario.addActionListener(acaoEnter);
        campoSenha.addActionListener(acaoEnter);
    }

// Método de autenticação
    private void validarLogin() {
        String usuarioDigitado = campoUsuario.getText().trim();
        String senhaDigitada = new String(campoSenha.getPassword()).trim();

        // Não faz nada e não conta tentativa se algum campo estiver vazio
        if (usuarioDigitado.isEmpty()) {
            campoUsuario.requestFocus();
            return;
        }

        if (senhaDigitada.isEmpty()) {
            campoSenha.requestFocus();
            return;
        }

        Usuario tentativa = new Usuario(usuarioDigitado, senhaDigitada);
        Usuario logado = autenticador.autenticar(tentativa);

        if (logado != null) {
            dispose();
            new TelaPrincipal(logado).setVisible(true);
        } else {
            tentativaLogin++;

            if (tentativaLogin >= 3) {
                botaoEntrar.setEnabled(false);
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Número máximo de tentativas atingido. Favor entrar novamente.",
                        "Limite atingido",
                        javax.swing.JOptionPane.ERROR_MESSAGE
                );
                System.exit(0);
            } else {
                javax.swing.JOptionPane.showMessageDialog(
                        this,
                        "Usuário ou senha inválidos | Tentativa " + tentativaLogin + " de 3",
                        "Erro",
                        javax.swing.JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    // Inicialização dos componentes
    @SuppressWarnings("unchecked")
    private void initComponents() {

        rotuloUsuario = new javax.swing.JLabel();
        campoUsuario = new javax.swing.JTextField();
        rotuloSenha = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        rotuloAcessarConta = new javax.swing.JLabel();
        botaoEntrar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        caixaMostrarSenha = new javax.swing.JCheckBox();

        setDefaultCloseOperation(
                javax.swing.WindowConstants.EXIT_ON_CLOSE
        );

        rotuloUsuario.setFont(
                new java.awt.Font("Yu Gothic UI", 0, 18)
        );
        rotuloUsuario.setText("Usuário:");

        campoUsuario.addActionListener(evt
                -> campoUsuarioActionPerformed(evt)
        );

        rotuloSenha.setFont(
                new java.awt.Font("Yu Gothic UI", 0, 18)
        );
        rotuloSenha.setText("Senha:");

        campoSenha.addActionListener(evt
                -> campoSenhaActionPerformed(evt)
        );

        rotuloAcessarConta.setFont(
                new java.awt.Font("Yu Gothic UI", 0, 24)
        );
        rotuloAcessarConta.setText("ACESSAR CONTA");

        botaoEntrar.setFont(
                new java.awt.Font("Yu Gothic UI", 0, 12)
        );
        botaoEntrar.setText("Entrar");
        botaoEntrar.addActionListener(evt
                -> botaoEntrarActionPerformed(evt)
        );

        // Botão Voltar
        botaoVoltar.setFont(
                new java.awt.Font("Yu Gothic UI", 0, 12)
        );
        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(evt
                -> botaoVoltarActionPerformed(evt)
        );

        caixaMostrarSenha.setText("Mostrar senha");
        caixaMostrarSenha.addActionListener(evt
                -> caixaMostrarSenhaActionPerformed(evt)
        );

        javax.swing.GroupLayout layout
                = new javax.swing.GroupLayout(getContentPane());

        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(
                        javax.swing.GroupLayout.Alignment.LEADING
                )
                        .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addGroup(layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.TRAILING
                                )
                                        .addComponent(rotuloUsuario)
                                        .addComponent(rotuloSenha)
                                )
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING
                                )
                                        .addComponent(rotuloAcessarConta)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                        false
                                                )
                                                        .addComponent(campoUsuario)
                                                        .addComponent(campoSenha,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                200,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                )
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED
                                                )
                                                .addComponent(caixaMostrarSenha)
                                        )
                                )
                                .addContainerGap(44, Short.MAX_VALUE)
                        )
                        .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup()
                                        .addContainerGap(
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE
                                        )
                                        .addGroup(layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.CENTER
                                        )
                                                .addComponent(botaoEntrar)
                                                .addComponent(botaoVoltar)
                                        )
                                        .addGap(216, 216, 216)
                        )
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(
                        javax.swing.GroupLayout.Alignment.LEADING
                )
                        .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(rotuloAcessarConta)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.BASELINE
                                )
                                        .addComponent(rotuloUsuario)
                                        .addComponent(campoUsuario,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                )
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.BASELINE
                                )
                                        .addComponent(rotuloSenha)
                                        .addComponent(campoSenha,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(caixaMostrarSenha)
                                )
                                .addGap(32, 32, 32)
                                .addComponent(botaoEntrar)
                                .addGap(10, 10, 10)
                                .addComponent(botaoVoltar)
                                .addContainerGap(66, Short.MAX_VALUE)
                        )
        );

        pack();
    }

    // Ações dos campos
    private void campoUsuarioActionPerformed(
            java.awt.event.ActionEvent evt) {
    }

    private void campoSenhaActionPerformed(
            java.awt.event.ActionEvent evt) {
    }

    // Mostrar ou esconder senha
    private void caixaMostrarSenhaActionPerformed(
            java.awt.event.ActionEvent evt) {

        campoSenha.setEchoChar(
                caixaMostrarSenha.isSelected() ? (char) 0 : '•'
        );
    }

    // Ação do botão Entrar
    private void botaoEntrarActionPerformed(
            java.awt.event.ActionEvent evt) {

        validarLogin();
    }

    // Ação do botão Voltar
    private void botaoVoltarActionPerformed(
            java.awt.event.ActionEvent evt) {

        new TelaInicial().setVisible(true);
        this.dispose();
    }

    // Inicialização do programa
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager.getInstalledLookAndFeels()) {

                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(
                            info.getClassName()
                    );
                    break;
                }
            }

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
    }

    // Declaração dos componentes
    private javax.swing.JButton botaoEntrar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JCheckBox caixaMostrarSenha;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JLabel rotuloAcessarConta;
    private javax.swing.JLabel rotuloSenha;
    private javax.swing.JLabel rotuloUsuario;
}
