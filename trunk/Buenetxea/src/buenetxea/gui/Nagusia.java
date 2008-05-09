package buenetxea.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle;
import javax.swing.border.MatteBorder;

import buenetxea.gui.panelak.CrearClientePanel;
import buenetxea.gui.panelak.CrearPropietarioPanel;
import buenetxea.gui.panelak.IntroducirInmueblePanel;
import buenetxea.gui.panelak.LocalizarClientePanel;
import buenetxea.gui.panelak.LocalizarInmueblePanel;
import buenetxea.gui.panelak.SeguimientoPropietarioPanel;
import buenetxea.gui.panelak.VenderInmueblePanel;

public class Nagusia extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel;

	private static Nagusia nagusia;

	/**
	 * Create the frame
	 */
	public Nagusia() {
		super();

		nagusia = this;

		this.setJMenuBar(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		final JMenu fichasMenu = new JMenu();
		fichasMenu.setText("Fichas");
		menuBar.add(fichasMenu);

		final JMenu visitasMenu = new JMenu();
		visitasMenu.setText("Visitas");
		fichasMenu.add(visitasMenu);

		final JMenuItem newItemMenuItem_2 = new JMenuItem();
		newItemMenuItem_2.setText("Ver");
		visitasMenu.add(newItemMenuItem_2);

		final JMenuItem newItemMenuItem_3 = new JMenuItem();
		newItemMenuItem_3.setText("Imprimir");
		visitasMenu.add(newItemMenuItem_3);

		final JMenuItem newItemMenuItem_1 = new JMenuItem();
		newItemMenuItem_1.setText("Visitas");
		fichasMenu.add(newItemMenuItem_1);

		final JMenuItem newItemMenuItem = new JMenuItem();
		newItemMenuItem.setText("New Item");
		menuBar.add(newItemMenuItem);

		JToolBar toolBar;
		toolBar = new JToolBar();
		toolBar.setFloatable(false);

		panel = new JPanel();
		panel.setLayout(new CardLayout());

		JPanel panel_1;
		panel_1 = new JPanel();
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.setLayout(flowLayout);
		panel_1.setBorder(new MatteBorder(1, 0, 0, 0, Color.GRAY));

		final JLabel listoLabel = new JLabel();
		listoLabel.setText("Listo");
		panel_1.add(listoLabel);

		final JProgressBar progressBar = new JProgressBar();
		panel_1.add(progressBar);
		final GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(
						GroupLayout.Alignment.LEADING).addComponent(toolBar,
						GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 492,
								Short.MAX_VALUE).addGroup(
								groupLayout.createSequentialGroup()
										.addContainerGap().addComponent(panel,
												GroupLayout.DEFAULT_SIZE, 468,
												Short.MAX_VALUE)
										.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING)
				.addGroup(
						groupLayout.createSequentialGroup().addComponent(
								toolBar, GroupLayout.PREFERRED_SIZE, 25,
								GroupLayout.PREFERRED_SIZE).addPreferredGap(
								LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE,
										254, Short.MAX_VALUE).addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(panel_1,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)));

		CrearPropietarioPanel crearPropietarioPanel = null;
		try {

			final LocalizarClientePanel localizarClientePanel = new LocalizarClientePanel();
			localizarClientePanel.setName("localizarCliente");
			panel.add(localizarClientePanel, localizarClientePanel.getName());

			final SeguimientoPropietarioPanel seguimientoPropietarioPanel = new SeguimientoPropietarioPanel();
			seguimientoPropietarioPanel.setName("seguimientoPropietario");
			panel.add(seguimientoPropietarioPanel, seguimientoPropietarioPanel
					.getName());

			final IntroducirInmueblePanel introducirInmueblePanel = new IntroducirInmueblePanel();
			introducirInmueblePanel.setName("peritaje");
			panel.add(introducirInmueblePanel, introducirInmueblePanel
					.getName());

			final CrearClientePanel crearClientePanel = new CrearClientePanel();
			crearClientePanel.setName("crearClientePanel");
			panel.add(crearClientePanel, crearClientePanel.getName());

			final LocalizarInmueblePanel localizarInmueblePanel = new LocalizarInmueblePanel();
			localizarInmueblePanel.setName("localizarInmueble");
			panel.add(localizarInmueblePanel, localizarInmueblePanel.getName());
			crearPropietarioPanel = new CrearPropietarioPanel();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		crearPropietarioPanel.setName("crearPropietario");
		panel.add(crearPropietarioPanel, crearPropietarioPanel.getName());

		final VenderInmueblePanel venderInmueblePanel = new VenderInmueblePanel();
		venderInmueblePanel.setName("venderInmueblePanel");
		panel.add(venderInmueblePanel, venderInmueblePanel.getName());

		final LocalizarInmueblePanel localizadorPanel = new LocalizarInmueblePanel();
		localizadorPanel.setName("localizador");
		panel.add(localizadorPanel, localizadorPanel.getName());
		final JButton peritajeButton = new JButton();
		peritajeButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				((CardLayout) panel.getLayout()).show(panel, "peritaje");
			}
		});
		peritajeButton.setText("Peritaje");
		toolBar.add(peritajeButton);

		final JButton localizarButton = new JButton();
		localizarButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				((CardLayout) panel.getLayout()).show(panel, "localizador");
			}
		});
		localizarButton.setText("Localizador");
		toolBar.add(localizarButton);

		final JButton buscasButton = new JButton();
		buscasButton.setText("Buscas");
		toolBar.add(buscasButton);

		final JButton seguimientoPropietariosButton = new JButton();
		seguimientoPropietariosButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				((CardLayout) panel.getLayout()).show(panel,
						"seguimientoPropietario");
			}
		});
		seguimientoPropietariosButton.setText("Seguimiento propietarios");
		toolBar.add(seguimientoPropietariosButton);

		final JButton visitasButton = new JButton();
		visitasButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
			}
		});
		visitasButton.setText("Visitas");
		toolBar.add(visitasButton);

		final JButton localizarClienteButton = new JButton();
		localizarClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				((CardLayout) panel.getLayout())
						.show(panel, "localizarCliente");
			}
		});
		localizarClienteButton.setText("Localizar cliente");
		toolBar.add(localizarClienteButton);
		this.getContentPane().setLayout(groupLayout);
		this.pack();
		//
	}

	public static Nagusia getInstance() {
		return nagusia;
	}
}
