package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import control.ActionCasilla;
import control.ActionReiniciar;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

public class UI extends JFrame {

	private Color colorProgreso = new Color(32, 187, 129);
	private Color colorPenalizado = new Color(229, 40, 40);
	private String dimension;
	private int tiempo;
	private JPanel contentPane;
	protected Botonera botonera;
	protected JPanel panelPrincipal;
	private JButton btnReiniciar;
	protected JProgressBar progressBar;
	private JPanel panel_1;
	private JLabel mensajeFinal;
	protected JButton btn4;
	protected JButton btn6;
	protected JButton btn8;

	public UI() {
		setPreferredSize(new Dimension(800, 800));
		setMinimumSize(new Dimension(700, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Memorama");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel tituloJuego = new JLabel("MEMORAMA");
		tituloJuego.setBorder(new EmptyBorder(10, 10, 10, 10));
		tituloJuego.setOpaque(true);
		tituloJuego.setForeground(Color.WHITE);
		tituloJuego.setBackground(Color.DARK_GRAY);
		tituloJuego.setFont(new Font("Tahoma", Font.BOLD, 60));
		tituloJuego.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tituloJuego, BorderLayout.NORTH);

		crearPanelPrincipal();

	}

	private void crearPanelPrincipal() {
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(255, 127, 80));
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panelPrincipal.add(panel_2, BorderLayout.NORTH);
		panel_2.setBorder(null);
		panel_2.setLayout(new BorderLayout(0, 0));

		JLabel tituloTamano = new JLabel("ELIGE EL TAMA\u00D1O DEL CUADRANTE");
		tituloTamano.setOpaque(true);
		panel_2.add(tituloTamano, BorderLayout.NORTH);
		tituloTamano.setBackground(SystemColor.textHighlight);
		tituloTamano.setForeground(Color.WHITE);
		tituloTamano.setFont(new Font("Tahoma", Font.BOLD, 20));
		tituloTamano.setBorder(new EmptyBorder(30, 0, 30, 0));
		tituloTamano.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel_2.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(3, 1, 0, 5));

		btn4 = new JButton("4");
		btn4.setFocusPainted(false);
		btn4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn4.setForeground(Color.WHITE);
		btn4.setBackground(SystemColor.textHighlight);
		btn4.setFont(new Font("Arial Black", Font.BOLD, 40));
		btn4.setBorder(new EmptyBorder(15, 0, 15, 0));
		btn4.setName("4");
		panel_3.add(btn4);

		btn6 = new JButton("6");
		btn6.setFocusPainted(false);
		btn6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn6.setForeground(Color.WHITE);
		btn6.setBackground(new Color(0, 102, 153));
		btn6.setFont(new Font("Arial Black", Font.BOLD, 40));
		btn6.setBorder(new EmptyBorder(15, 0, 15, 0));
		btn6.setName("6");
		panel_3.add(btn6);

		btn8 = new JButton("8");
		btn8.setFocusPainted(false);
		btn8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn8.setForeground(Color.WHITE);
		btn8.setBackground(new Color(0, 102, 102));
		btn8.setFont(new Font("Arial Black", Font.BOLD, 40));
		btn8.setBorder(new EmptyBorder(15, 0, 15, 0));
		btn8.setName("8");
		panel_3.add(btn8);

		JLabel lblNewLabel = new JLabel("Chambea!");
		lblNewLabel.setBorder(new EmptyBorder(5, 0, 5, 0));
		lblNewLabel.setForeground(new Color(30, 30, 30));
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelPrincipal.add(lblNewLabel, BorderLayout.SOUTH);
	}

	public void crearPanelJuego(String dimension) {
		JPanel panelJuego = new JPanel();
		panelJuego.setBounds(10, 11, 344, 220);
		contentPane.add(panelJuego);
		contentPane.add(panelJuego);
		panelJuego.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panelJuego.add(panel, BorderLayout.SOUTH);
		panel.setBorder(new LineBorder(Color.DARK_GRAY));
		panel.setForeground(Color.WHITE);
		panel.setLayout(new BorderLayout(0, 0));

		btnReiniciar = new JButton("Reiniciar");
		panel.add(btnReiniciar);
		btnReiniciar.setForeground(Color.WHITE);
		btnReiniciar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnReiniciar.setBackground(SystemColor.textHighlight);
		btnReiniciar.setBorder(new EmptyBorder(5, 0, 5, 0));
		btnReiniciar.setFocusPainted(false);
		btnReiniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		panel_1 = new JPanel();
		panelJuego.add(panel_1, BorderLayout.CENTER);
		panel_1.setBackground(Color.red);
		panel_1.setLayout(new BorderLayout(0, 0));

		progressBar = new JProgressBar();
		progressBar.setBorder(null);
		panel_1.add(progressBar, BorderLayout.NORTH);
		progressBar.setBorderPainted(false);
		progressBar.setMinimumSize(new Dimension(10, 50));
		progressBar.setValue(100);
		progressBar.setMaximum(100);
		progressBar.setMinimum(0);
		progressBar.setForeground(this.colorProgreso);

		botonera = new Botonera(Integer.parseInt(dimension));
		botonera.setBorder(new EmptyBorder(20, 20, 20, 20));
		panel_1.add(botonera);
		GridLayout gl_botonera = new GridLayout(Integer.parseInt(dimension), Integer.parseInt(dimension));
		gl_botonera.setVgap(5);
		gl_botonera.setHgap(5);
		botonera.setBackground(new Color(238, 235, 233));
		botonera.setLayout(gl_botonera);

	}

	public int crearJuego(String dimension) {
		this.dimension = dimension;
		this.tiempo = (int) ((Integer.parseInt(this.dimension) * 0.5) * 1000);
		remove(panelPrincipal);
		crearPanelJuego(this.dimension);
		return Integer.parseInt(this.dimension);
	}

	public void setListeners(ActionCasilla listenerCasilla, ActionReiniciar listenerReiniciar) {
		for (JButton[] i : this.botonera.getBotonera()) {
			for (JButton boton : i) {
				boton.addActionListener(listenerCasilla);
			}

		}

		btnReiniciar.addActionListener(listenerReiniciar);
	}

	public void despenalizarTiempo() {
		this.progressBar.setValue(this.progressBar.getValue() + 10);
	}

	public void penalizarTiempo() {
		this.progressBar.setValue(this.progressBar.getValue() - 5);
		this.progressBar.setForeground(this.colorPenalizado);
	}

	public void disminuirTiempo() {
		this.progressBar.setValue(this.progressBar.getValue() - 1);
		this.progressBar.setForeground(this.colorProgreso);
	}

	public void reiniciarVista() {
		this.progressBar.setValue(100);
		this.botonera.setVisible(true);
		this.panel_1.add(this.botonera, BorderLayout.CENTER);

		for (JButton[] i : botonera.getBotonera()) {
			for (JButton boton : i) {
				boton.setVisible(true);
				boton.setIcon(null);
				boton.setBackground(this.botonera.getCartaVelada());
			}
		}
	}

	public Botonera getBotonera() {
		return botonera;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	public int getTiempo() {
		return tiempo;
	}

	public Color getCartaVelada() {
		return botonera.getCartaVelada();
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public Color getColorProgreso() {
		return colorProgreso;
	}

	public Color getColorPenalizado() {
		return colorPenalizado;
	}

}