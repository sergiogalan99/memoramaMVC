package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ActionCasilla;
import control.ActionReiniciar;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

public class UI extends JFrame {

	private Color colorProgreso = new Color(32, 187, 129);
	private Color colorPenalizado = new Color(229, 40, 40);
	private String dimension;
	private JPanel contentPane;
	protected Botonera botonera;
	private JLabel tituloJuego;
	private JPanel panel_1;
	private JLabel mensaje;
	private JLabel jugadas;
	protected JLabel numJugadas;
	private JPanel panel_3;
	protected JPanel panelJuego;
	protected JButton botonJugar;
	private JPanel panel;
	protected JComboBox comboBox;
	protected JPanel panelPrincipal;
	private JButton btnReiniciar;
	private JPanel panel_2;
	private JPanel panel_4;
	protected JProgressBar progressBar;
	private JPanel panel_5;
	
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
		
		tituloJuego = new JLabel("MEMORAMA");
		tituloJuego.setBorder(new EmptyBorder(10, 10, 10, 10));
		tituloJuego.setOpaque(true);
		tituloJuego.setForeground(Color.WHITE);
		tituloJuego.setBackground(Color.DARK_GRAY);
		tituloJuego.setFont(new Font("Tahoma", Font.BOLD, 60));
		tituloJuego.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tituloJuego, BorderLayout.NORTH);
		
		crearPanelPrincipal();
	}

	private void crearPanelPrincipal(){
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.WHITE);
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		JLabel tituloTamano = new JLabel("Elige el tama\u00F1o:");
		tituloTamano.setFont(new Font("Tahoma", Font.BOLD, 15));
		tituloTamano.setBorder(new EmptyBorder(5, 0, 20, 0));
		tituloTamano.setHorizontalAlignment(SwingConstants.CENTER);
		panelPrincipal.add(tituloTamano, BorderLayout.NORTH);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(Color.WHITE);
		panelPrincipal.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		comboBox = new JComboBox();
		comboBox.setBorder(new EmptyBorder(0, 20, 0, 20));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox.setMinimumSize(new Dimension(200, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"4", "6", "8"}));
		panel.add(comboBox, BorderLayout.NORTH);
		
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlight);
		panel_2.setBorder(new LineBorder(Color.DARK_GRAY));
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		botonJugar = new JButton("Jugar");
		panel_2.add(botonJugar);
		botonJugar.setFont(new Font("Tahoma", Font.BOLD, 40));
		botonJugar.setBorder(new EmptyBorder(20, 0, 20, 0));
		botonJugar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonJugar.setFocusPainted(false);
		
		botonJugar.setMinimumSize(new Dimension(130, 70));
		botonJugar.setForeground(new Color(255, 255, 255));
		botonJugar.setOpaque(false);
		botonJugar.setBackground(new Color(244, 164, 96));
		
		
	}

	public void crearPanelJuego(String dimension){
		panelJuego = new JPanel();
		panelJuego.setBounds(10, 11, 344, 220);
		contentPane.add(panelJuego);
		contentPane.add(panelJuego);
		panelJuego.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelJuego.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_3.add(panel_1, BorderLayout.EAST);
		panel_1.setBorder(new EmptyBorder(10, 0, 10, 10));
		panel_1.setLayout(new BorderLayout(0, 0));
		
		jugadas = new JLabel("Jugadas:");
		jugadas.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(jugadas, BorderLayout.WEST);
		
		numJugadas = new JLabel("0");
		numJugadas.setBorder(new EmptyBorder(0, 5, 0, 0));
		numJugadas.setFont(new Font("Tahoma", Font.BOLD, 13));
		numJugadas.setForeground(UIManager.getColor("FormattedTextField.selectionBackground"));
		numJugadas.setHorizontalAlignment(SwingConstants.RIGHT);
		numJugadas.setMaximumSize(new Dimension(20, 14));
		panel_1.add(numJugadas, BorderLayout.EAST);
		
		mensaje = new JLabel("\u00A1Completado!");
		mensaje.setVisible(false);
		mensaje.setBorder(new EmptyBorder(0, 15, 0, 15));
		panel_3.add(mensaje, BorderLayout.WEST);
		mensaje.setForeground(new Color(0, 100, 0));
		mensaje.setMaximumSize(new Dimension(74, 14));
		mensaje.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		mensaje.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel_4 = new JPanel();
		panelJuego.add(panel_4, BorderLayout.SOUTH);
		panel_4.setBorder(new LineBorder(Color.DARK_GRAY));
		panel_4.setForeground(Color.WHITE);
		panel_4.setBackground(SystemColor.textHighlight);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		btnReiniciar = new JButton("Reiniciar");
		panel_4.add(btnReiniciar);
		btnReiniciar.setForeground(Color.WHITE);
		btnReiniciar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnReiniciar.setBackground(SystemColor.textHighlight);
		btnReiniciar.setBorder(new EmptyBorder(5, 0, 5, 0));
		btnReiniciar.setFocusPainted(false);
		btnReiniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		panel_5 = new JPanel();
		panelJuego.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		progressBar = new JProgressBar();
		progressBar.setBorder(null);
		panel_5.add(progressBar, BorderLayout.NORTH);
		progressBar.setBorderPainted(false);
		progressBar.setString("");
		progressBar.setMinimumSize(new Dimension(10, 50));
		progressBar.setToolTipText("");
		progressBar.setValue(100);
		progressBar.setMaximum(100);
		progressBar.setMinimum(0);
		progressBar.setForeground(this.colorProgreso);
		
		botonera=new Botonera(Integer.parseInt(dimension));
		panel_5.add(botonera);
		GridLayout gl_botonera = new GridLayout(Integer.parseInt(dimension), Integer.parseInt(dimension));
		gl_botonera.setVgap(1);
		gl_botonera.setHgap(1);
		botonera.setBackground(Color.LIGHT_GRAY);
		botonera.setLayout(gl_botonera);
		actualizarTextoTiempo();
		
	}

	public int crearJuego() {
		this.dimension = (String) comboBox.getSelectedItem();
		remove(panelPrincipal);
		crearPanelJuego(this.dimension);
		return Integer.parseInt(this.dimension);
	}

	public void setListeners(ActionCasilla listenerCasilla, ActionReiniciar listenerReiniciar) {
		int dimension=Integer.parseInt(this.dimension);
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				this.botonera.getBotonera()[i][j].addActionListener(listenerCasilla);
			}
			
		}
		btnReiniciar.addActionListener(listenerReiniciar);
	}
	
	public void penalizarTiempo() {
		this.progressBar.setValue(this.progressBar.getValue() - 5);
		this.progressBar.setForeground(this.colorPenalizado);
		actualizarTextoTiempo();
	}
	
	public void disminuirTiempo() {
		this.progressBar.setValue(this.progressBar.getValue() - 1);
		this.progressBar.setForeground(this.colorProgreso);
		actualizarTextoTiempo();
	}
	
	public void actualizarTextoTiempo() {
		this.progressBar.setString(String.valueOf(this.progressBar.getValue()) + " segundos");
	}

	public Botonera getBotonera() {
		return botonera;
	}

	public JLabel getMensaje() {
		return mensaje;
	}

	public JLabel getNumJugadas() {
		return numJugadas;
	}

	public void setNumJugadas(JLabel numJugadas) {
		this.numJugadas = numJugadas;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}
	
}