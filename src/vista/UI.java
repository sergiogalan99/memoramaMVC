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
	protected JButton botonJugar;
	protected JComboBox<String> comboBox;
	protected JPanel panelPrincipal;
	private JButton btnReiniciar;
	protected JProgressBar progressBar;
	private JPanel panel_1;
	
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

	private void crearPanelPrincipal(){
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(255, 127, 80));
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		JLabel tituloTamano = new JLabel("ELIGE EL TAMA\u00D1O DEL CUADRANTE");
		tituloTamano.setFont(new Font("Tahoma", Font.BOLD, 13));
		tituloTamano.setBorder(new EmptyBorder(10, 0, 10, 0));
		tituloTamano.setHorizontalAlignment(SwingConstants.CENTER);
		panelPrincipal.add(tituloTamano, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(Color.WHITE);
		panelPrincipal.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		comboBox = new JComboBox<String>();
		comboBox.setBorder(new EmptyBorder(0, 20, 0, 20));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox.setMinimumSize(new Dimension(200, 20));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"4", "6", "8"}));
		panel.add(comboBox, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlight);
		panel_2.setBorder(new LineBorder(Color.DARK_GRAY));
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		botonJugar = new JButton("Jugar");
		panel_2.add(botonJugar);
		botonJugar.setFont(new Font("Tahoma", Font.BOLD, 80));
		botonJugar.setBorder(new EmptyBorder(10, 0, 10, 0));
		botonJugar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonJugar.setFocusPainted(false);
		
		botonJugar.setMinimumSize(new Dimension(130, 70));
		botonJugar.setForeground(new Color(255, 255, 255));
		botonJugar.setOpaque(false);
		botonJugar.setBackground(new Color(244, 164, 96));
	}

	public void crearPanelJuego(String dimension){
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
		
		botonera=new Botonera(Integer.parseInt(dimension));
		botonera.setBorder(new EmptyBorder(20, 20, 20, 20));
		panel_1.add(botonera);
		GridLayout gl_botonera = new GridLayout(Integer.parseInt(dimension), Integer.parseInt(dimension));
		gl_botonera.setVgap(5);
		gl_botonera.setHgap(5);
		botonera.setBackground(new Color(238, 235, 233));
		botonera.setLayout(gl_botonera);
		
	}

	public int crearJuego() {
		this.dimension = (String) comboBox.getSelectedItem();
		this.tiempo = (int) ((Integer.parseInt(this.dimension) * 0.5 ) * 1000);
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
	
	/**
	 * Escala un icono en base a una medida
	 * 
	 * @param Imagen
	 *            Icono a escalar
	 * @param height
	 *            Medida con la que escalar
	 * @return Icono escalado
	 */
	public ImageIcon createScaledIcon(ImageIcon Imagen, int height) {
		return new ImageIcon(Imagen.getImage().getScaledInstance(height - 5, height - 5, Image.SCALE_SMOOTH));
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
	
}