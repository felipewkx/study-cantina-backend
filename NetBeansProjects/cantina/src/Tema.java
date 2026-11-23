
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;

public class Tema {

    public static final Color FUNDO = new Color(0xD6E5F5), TEXTO = new Color(0x172B45), AZUL_PRINCIPAL = new Color(0x102E56), AZUL_SECUNDARIO = new Color(0x174F91), AZUL_DESTAQUE = new Color(0x246FC1), AZUL_BRILHO = new Color(0x438FE0), AZUL_CLARO = new Color(0xDCEBFA);
    public static final Color DESTAQUE = new Color(0x13834D), DESTAQUE_TOPO = new Color(0x25A96A), DESTAQUE_BASE = new Color(0x08713F), HOVER_TOPO = new Color(0x35C17C), HOVER_BASE = new Color(0x159457);
    public static final Color VERMELHO_TOPO = new Color(0xF04444), VERMELHO_BASE = new Color(0xA81818), VERMELHO_HOVER_TOPO = new Color(0xFF6666), VERMELHO_HOVER_BASE = new Color(0xD62828);
    public static final Color CANCELAR_TOPO = new Color(0x438FE0), CANCELAR_BASE = new Color(0x174F91);
    public static final Color BORDA_FOCO = new Color(0x62A5ED), BORDA = new Color(0xC7D5E5), FUNDO_TABELA = new Color(0xF4F7FC), FUNDO_BRANCO = Color.WHITE;
    static Color FUNDO_TELA = FUNDO;

    public static void aplicar() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Não foi possível aplicar o tema Nimbus.");
        }

        UIManager.put("control", FUNDO);
        UIManager.put("info", FUNDO_BRANCO);
        UIManager.put("nimbusBase", AZUL_PRINCIPAL);
        UIManager.put("nimbusBlueGrey", new Color(0xB8C9DD));
        UIManager.put("nimbusLightBackground", FUNDO_BRANCO);
        UIManager.put("text", TEXTO);
        UIManager.put("nimbusFocus", BORDA_FOCO);
        UIManager.put("nimbusSelectionBackground", AZUL_DESTAQUE);

        UIManager.put("Panel.background", FUNDO);
        UIManager.put("Label.foreground", TEXTO);

        UIManager.put("OptionPane.background", FUNDO_BRANCO);
        UIManager.put("OptionPane.messageAreaBackground", FUNDO_BRANCO);
        UIManager.put("OptionPane.buttonAreaBackground", FUNDO_BRANCO);
        UIManager.put("OptionPane.foreground", TEXTO);
        UIManager.put("OptionPane.messageForeground", TEXTO);
        UIManager.put("OptionPane.border", BorderFactory.createLineBorder(BORDA));

        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.background", DESTAQUE);
        UIManager.put("Button.contentMargins", new Insets(10, 24, 10, 24));
        UIManager.put("Button.border", BorderFactory.createEmptyBorder(9, 18, 9, 18));
        UIManager.put("Button[Enabled].backgroundPainter", criarDegradeBotao(DESTAQUE_TOPO, DESTAQUE_BASE));
        UIManager.put("Button[Focused].backgroundPainter", criarDegradeBotao(DESTAQUE_TOPO, DESTAQUE_BASE));
        UIManager.put("Button[MouseOver].backgroundPainter", criarDegradeBotao(HOVER_TOPO, HOVER_BASE));
        UIManager.put("Button[Focused+MouseOver].backgroundPainter", criarDegradeBotao(HOVER_TOPO, HOVER_BASE));
        UIManager.put("Button[Pressed].backgroundPainter", criarDegradeBotao(new Color(0x08713F), new Color(0x064D2D)));

        UIManager.put("TextField.background", FUNDO_BRANCO);
        UIManager.put("TextField.foreground", TEXTO);
        UIManager.put("TextField.caretForeground", AZUL_DESTAQUE);
        UIManager.put("TextField.selectionBackground", AZUL_CLARO);
        UIManager.put("TextField.selectionForeground", AZUL_PRINCIPAL);
        UIManager.put("TextField.contentMargins", new Insets(9, 13, 9, 13));
        UIManager.put("PasswordField.contentMargins", new Insets(9, 13, 9, 13));

        UIManager.put("Table.background", FUNDO_BRANCO);
        UIManager.put("Table.foreground", TEXTO);
        UIManager.put("Table.alternateRowColor", FUNDO_TABELA);
        UIManager.put("Table.showGrid", true);
        UIManager.put("Table.gridColor", new Color(0xDCE4EF));
        UIManager.put("Table.selectionBackground", AZUL_CLARO);
        UIManager.put("Table.selectionForeground", AZUL_PRINCIPAL);
        UIManager.put("Table.rowHeight", 30);
        UIManager.put("Table.focusCellHighlightBorder", BorderFactory.createLineBorder(BORDA_FOCO));

        UIManager.put("TableHeader.background", AZUL_PRINCIPAL);
        UIManager.put("TableHeader.foreground", Color.WHITE);
        UIManager.put("TableHeader.font", new Font("SansSerif", Font.BOLD, 13));

        UIManager.put("ComboBox.background", FUNDO_BRANCO);
        UIManager.put("ComboBox.foreground", TEXTO);
        UIManager.put("ComboBox.selectionBackground", AZUL_DESTAQUE);
        UIManager.put("ComboBox.selectionForeground", Color.WHITE);
        UIManager.put("CheckBox.foreground", TEXTO);
        UIManager.put("RadioButton.foreground", TEXTO);

        Font normal = new Font("SansSerif", Font.PLAIN, 14), negrito = new Font("SansSerif", Font.BOLD, 14);
        UIManager.put("defaultFont", normal);
        UIManager.put("Label.font", normal);
        UIManager.put("Button.font", negrito);
        UIManager.put("TextField.font", normal);
        UIManager.put("PasswordField.font", normal);
        UIManager.put("ComboBox.font", normal);
        UIManager.put("Table.font", normal);
        UIManager.put("OptionPane.messageFont", normal);
        UIManager.put("OptionPane.buttonFont", negrito);
    }

    public static void personalizarAviso(JOptionPane painel) {
        painel.setBackground(FUNDO_BRANCO);
        painel.setForeground(TEXTO);
        painel.setOpaque(true);
        SwingUtilities.invokeLater(() -> {
            for (Component c : painel.getComponents()) {
                personalizarComponente(c);
            }
        });
    }

    private static void personalizarComponente(Component c) {
        if (c instanceof JPanel) {
            c.setBackground(FUNDO_BRANCO);
            ((JPanel) c).setOpaque(true);
        }
        if (c instanceof JLabel) {
            c.setForeground(TEXTO);
            c.setBackground(FUNDO_BRANCO);
        }
        if (c instanceof JButton) {
            JButton b = (JButton) c;
            String t = b.getText();
            if (t != null) {
                t = t.trim().toLowerCase();
                if (t.equals("sim") || t.equals("yes")) {
                    configurarBotao(b, DESTAQUE_TOPO, DESTAQUE_BASE, HOVER_TOPO, HOVER_BASE);
                } else if (t.equals("não") || t.equals("nao") || t.equals("no")) {
                    configurarBotao(b, VERMELHO_TOPO, VERMELHO_BASE, VERMELHO_HOVER_TOPO, VERMELHO_HOVER_BASE);
                } else if (t.equals("cancelar") || t.equals("cancel")) {
                    configurarBotao(b, CANCELAR_TOPO, CANCELAR_BASE, AZUL_BRILHO, AZUL_PRINCIPAL);
                }
            }
        }
        if (c instanceof Container) {
            for (Component filho : ((Container) c).getComponents()) {
                personalizarComponente(filho);
            }
        }
    }

    private static void configurarBotao(JButton b, Color topo, Color base, Color hoverTopo, Color hoverBase) {
        b.setForeground(Color.WHITE);
        b.setBackground(base);
        b.setOpaque(true);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createEmptyBorder(9, 18, 9, 18));
        b.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                AbstractButton botao = (AbstractButton) c;
                ButtonModel m = botao.getModel();
                Color ct = m.isRollover() ? hoverTopo : topo, cb = m.isRollover() ? hoverBase : base;
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setPaint(new GradientPaint(0, 0, ct, 0, c.getHeight(), cb));
                g2.fillRoundRect(1, 1, c.getWidth() - 3, c.getHeight() - 3, 16, 16);
                g2.setColor(new Color(255, 255, 255, 90));
                g2.drawRoundRect(1, 1, c.getWidth() - 3, c.getHeight() - 3, 16, 16);
                g2.dispose();
                super.paint(g, c);
            }
        });
    }

    private static Painter<JComponent> criarDegradeBotao(Color topo, Color base) {
        return (g, c, w, h) -> {
            if (w <= 0 || h <= 0) {
                return;
            }
            Graphics2D g2 = (Graphics2D) g.create();
            try {
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
                g2.setColor(new Color(8, 30, 55, 55));
                g2.fillRoundRect(1, 4, w - 3, h - 5, 16, 16);
                g2.setPaint(new GradientPaint(0, 0, topo, 0, h, base));
                g2.fillRoundRect(1, 1, w - 3, h - 5, 16, 16);
                g2.setColor(new Color(255, 255, 255, 65));
                g2.fillRoundRect(3, 2, w - 7, Math.max(2, h / 3), 12, 12);
                g2.setColor(new Color(255, 255, 255, 90));
                g2.drawRoundRect(1, 1, w - 3, h - 5, 16, 16);
                g2.setColor(new Color(0, 35, 20, 45));
                g2.drawLine(9, h - 5, w - 10, h - 5);
            } finally {
                g2.dispose();
            }
        };
    }
}
