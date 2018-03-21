package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;

public class UI extends JFrame {

	private String dimension;
	private JPanel contentPane;
	protected Botonera botonera;
	private JLabel tituloJuego;
	private JPanel panel_1;
	private JLabel Mensaje;
	protected JLabel textoMensaje;
	private JLabel Aciertos;
	protected JLabel numAciertos;
	private JPanel panel_2;
	private JPanel panel_3;
	protected JPanel panelJuego;
	protected JButton botonJugar;
	private JPanel panel;
	protected JComboBox comboBox;
	private JPanel panel_4;
	protected JPanel panelPrincipal;
	
	public UI() {
		setMinimumSize(new Dimension(400, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Memorama");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tituloJuego = new JLabel("Memorama Game");
		tituloJuego.setBorder(new EmptyBorder(10, 10, 10, 10));
		tituloJuego.setOpaque(true);
		tituloJuego.setForeground(Color.WHITE);
		tituloJuego.setBackground(Color.DARK_GRAY);
		tituloJuego.setFont(new Font("Tahoma", Font.BOLD, 24));
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
		panel.setBorder(new EmptyBorder(0, 40, 0, 40));
		panel.setBackground(Color.WHITE);
		panelPrincipal.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox.setMinimumSize(new Dimension(200, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"4", "6", "8"}));
		panel.add(comboBox, BorderLayout.NORTH);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new EmptyBorder(0, 0, 50, 0));
		panel.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		botonJugar = new JButton("Jugar");
		
		botonJugar.setMinimumSize(new Dimension(130, 70));
		panel_4.add(botonJugar);
		botonJugar.setForeground(Color.BLACK);
		botonJugar.setOpaque(false);
		botonJugar.setBackground(Color.WHITE);
		
		
	}
	public void crearPanelJuego(String dimension){
		panelJuego = new JPanel();
		panelJuego.setBounds(10, 11, 344, 220);
		contentPane.add(panelJuego);
		contentPane.add(panelJuego);
		panelJuego.setLayout(new BorderLayout(0, 0));
		
		botonera=new Botonera(Integer.parseInt(dimension));
		panelJuego.add(botonera, BorderLayout.CENTER);
		botonera.setLayout(new GridLayout(Integer.parseInt(dimension), Integer.parseInt(dimension)));
		
		panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 10, 0, 10));
		panelJuego.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_3.add(panel_1, BorderLayout.EAST);
		panel_1.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel_1.setLayout(new BorderLayout(0, 0));
		
		Aciertos = new JLabel("Aciertos:");
		Aciertos.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(Aciertos, BorderLayout.WEST);
		
		numAciertos = new JLabel("");
		numAciertos.setBorder(new EmptyBorder(0, 5, 0, 0));
		numAciertos.setFont(new Font("Tahoma", Font.BOLD, 11));
		numAciertos.setForeground(Color.RED);
		numAciertos.setHorizontalAlignment(SwingConstants.RIGHT);
		numAciertos.setMaximumSize(new Dimension(20, 14));
		panel_1.add(numAciertos, BorderLayout.EAST);
		
		panel_2 = new JPanel();
		panel_3.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		Mensaje = new JLabel("Mensaje:");
		panel_2.add(Mensaje, BorderLayout.WEST);
		Mensaje.setMaximumSize(new Dimension(74, 14));
		Mensaje.setFont(new Font("Tahoma", Font.BOLD, 12));
		Mensaje.setHorizontalAlignment(SwingConstants.CENTER);
		
		textoMensaje = new JLabel("  ");
		panel_2.add(textoMensaje, BorderLayout.EAST);
		textoMensaje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textoMensaje.setMaximumSize(new Dimension(250, 14));
		
	}
	public String crearJuego() {
		this.dimension = (String) comboBox.getSelectedItem();
		remove(panelPrincipal);
		crearPanelJuego(this.dimension);
		return this.dimension;
	}
	
}
