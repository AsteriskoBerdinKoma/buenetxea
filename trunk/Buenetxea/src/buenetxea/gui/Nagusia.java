package buenetxea.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
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

import buenetxea.db.Connector;
import buenetxea.gui.dialogs.SeleccionarInmuebleDialog;
import buenetxea.gui.panelak.BuenetxeaPanel;
import buenetxea.gui.panelak.BuscasPanel;
import buenetxea.gui.panelak.CrearClientePanel;
import buenetxea.gui.panelak.CrearPropietarioPanel;
import buenetxea.gui.panelak.IntroducirDatosVisitaPanel;
import buenetxea.gui.panelak.IntroducirInmueblePanel;
import buenetxea.gui.panelak.LocalizarClientePanel;
import buenetxea.gui.panelak.LocalizarInmueblePanel;
import buenetxea.gui.panelak.ModificarInmueblePanel;
import buenetxea.gui.panelak.MostrarClientesInteresadosPanel;
import buenetxea.gui.panelak.SeguimientoPropietarioPanel;
import buenetxea.gui.panelak.VenderInmueblePanel;
import buenetxea.gui.panelak.VerClientePanel;
import buenetxea.gui.panelak.VerInmueblePanel;
import buenetxea.gui.panelak.VerPeritajePanel;
import buenetxea.gui.panelak.VerVisitaPanel;
import buenetxea.objektuak.Inmueble;

import com.swtdesigner.SwingResourceManager;

public class Nagusia extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel;

	private static Nagusia nagusia;

	private VenderInmueblePanel venderInmueblePanel;
	private VerInmueblePanel verInmueblePanel;
	private VerVisitaPanel verVisitaPanel;
	private LocalizarClientePanel localizarClientePanel;
	private MostrarClientesInteresadosPanel mostrarClientesInteresadosPanel;
	private LocalizarInmueblePanel localizarInmueblePanel;
	private VerClientePanel verClientePanel;
	private ModificarInmueblePanel modificarInmueblePanel;

	/**
	 * Create the frame
	 */
	public Nagusia() {
		super();
		setTitle("Buenetxea");
		setIconImage(SwingResourceManager.getImage(Nagusia.class,
				"/buenetxea/resources/logo_buenetxea.png"));

		nagusia = this;

		this.setJMenuBar(null);
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new NagusiaWindowListener());

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

		CrearPropietarioPanel crearPropietarioPanel = null;
		try {
			// panel.add(panela,"prueba");
			final BuenetxeaPanel buenetxeaPanel = new BuenetxeaPanel();
			buenetxeaPanel.setName("presentacion");
			panel.add(buenetxeaPanel, buenetxeaPanel.getName());

			localizarClientePanel = new LocalizarClientePanel();
			localizarClientePanel.setName("localizarCliente");
			panel.add(localizarClientePanel, localizarClientePanel.getName());

			final BuscasPanel buscas = new BuscasPanel();
			buscas.setName("buscas");
			panel.add(buscas, buscas.getName());

			localizarInmueblePanel = new LocalizarInmueblePanel();
			localizarInmueblePanel.setName("localizador");
			panel.add(localizarInmueblePanel, localizarInmueblePanel.getName());

			final SeguimientoPropietarioPanel seguimientoPropietarioPanel = new SeguimientoPropietarioPanel();
			seguimientoPropietarioPanel.setName("seguimientoPropietario");
			panel.add(seguimientoPropietarioPanel, seguimientoPropietarioPanel
					.getName());

			final IntroducirInmueblePanel introducirInmueblePanel = new IntroducirInmueblePanel();
			introducirInmueblePanel.setName("peritaje");
			panel.add(introducirInmueblePanel, introducirInmueblePanel
					.getName());

			modificarInmueblePanel = new ModificarInmueblePanel();
			modificarInmueblePanel.setName("modificarInmueble");
			panel.add(modificarInmueblePanel, modificarInmueblePanel.getName());

			final IntroducirDatosVisitaPanel introducirDatosVisitaPanel = new IntroducirDatosVisitaPanel();
			introducirDatosVisitaPanel.setName("visitas");
			panel.add(introducirDatosVisitaPanel, introducirDatosVisitaPanel
					.getName());

			final CrearClientePanel crearClientePanel = new CrearClientePanel();
			crearClientePanel.setName("nuevoCliente");
			panel.add(crearClientePanel, crearClientePanel.getName());
			crearPropietarioPanel = new CrearPropietarioPanel();

			mostrarClientesInteresadosPanel = new MostrarClientesInteresadosPanel();
			mostrarClientesInteresadosPanel
					.setName("mostrarClientesInteresados");
			panel.add(mostrarClientesInteresadosPanel,
					mostrarClientesInteresadosPanel.getName());

			verVisitaPanel = new VerVisitaPanel();
			verVisitaPanel.setName("verVisita");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		crearPropietarioPanel.setName("crearPropietario");
		panel.add(crearPropietarioPanel, crearPropietarioPanel.getName());

		venderInmueblePanel = new VenderInmueblePanel();
		venderInmueblePanel.setName("venderInmueble");
		panel.add(venderInmueblePanel, venderInmueblePanel.getName());

		final VerPeritajePanel verPeritajePanel = new VerPeritajePanel();
		verPeritajePanel.setName("verPeritaje");
		panel.add(verPeritajePanel, verPeritajePanel.getName());

		verClientePanel = new VerClientePanel();
		verClientePanel.setName("verCliente");
		panel.add(verClientePanel, verClientePanel.getName());

		verInmueblePanel = new VerInmueblePanel();
		verInmueblePanel.setName("verInmueble");
		panel.add(verInmueblePanel, verInmueblePanel.getName());

		panel.add(verVisitaPanel, verVisitaPanel.getName());
		final JButton peritajeButton = new JButton();
		peritajeButton.setToolTipText("Peritaje");
		peritajeButton.setIcon(SwingResourceManager.getIcon(Nagusia.class,
				"/buenetxea/resources/peritaje 48x48.png"));
		peritajeButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				((CardLayout) panel.getLayout()).show(panel, "peritaje");
			}
		});
		toolBar.add(peritajeButton);

		final JButton localizadorButton = new JButton();
		localizadorButton.setIcon(SwingResourceManager.getIcon(Nagusia.class,
				"/buenetxea/resources/localizador 48x48.png"));
		localizadorButton.setToolTipText("Localizador");
		localizadorButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				((CardLayout) panel.getLayout()).show(panel, "localizador");
			}
		});
		toolBar.add(localizadorButton);

		final JButton buscasButton = new JButton();
		buscasButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				((CardLayout) panel.getLayout()).show(panel, "buscas");
			}
		});
		buscasButton.setIcon(SwingResourceManager.getIcon(Nagusia.class,
				"/buenetxea/resources/buscas 48x48.png"));
		buscasButton.setToolTipText("Buscas");
		toolBar.add(buscasButton);

		final JButton seguimientoPropietariosButton = new JButton();
		seguimientoPropietariosButton
				.setToolTipText("Seguimiento de propietario");
		seguimientoPropietariosButton.setIcon(SwingResourceManager.getIcon(
				Nagusia.class,
				"/buenetxea/resources/seguimientoPropietario 48x48.png"));
		seguimientoPropietariosButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				((CardLayout) panel.getLayout()).show(panel,
						"seguimientoPropietario");
			}
		});
		toolBar.add(seguimientoPropietariosButton);

		final JButton visitasButton = new JButton();
		visitasButton.setToolTipText("Visitas");
		visitasButton.setIcon(SwingResourceManager.getIcon(Nagusia.class,
				"/buenetxea/resources/visitas 48x48.png"));
		visitasButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				((CardLayout) panel.getLayout()).show(panel, "visitas");
			}
		});
		toolBar.add(visitasButton);

		final JButton localizarClienteButton = new JButton();
		localizarClienteButton.setIcon(SwingResourceManager.getIcon(
				Nagusia.class,
				"/buenetxea/resources/localizarCliente 48x48.png"));
		localizarClienteButton.setToolTipText("Localizar cliente");
		localizarClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				// localizarClientePanel.refresh();
				((CardLayout) panel.getLayout())
						.show(panel, "localizarCliente");
			}
		});
		toolBar.add(localizarClienteButton);
		final GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(
						GroupLayout.Alignment.LEADING).addComponent(panel_1,
						GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
						.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 709,
								Short.MAX_VALUE).addGroup(
								GroupLayout.Alignment.TRAILING,
								groupLayout.createSequentialGroup()
										.addContainerGap().addComponent(panel,
												GroupLayout.DEFAULT_SIZE, 689,
												Short.MAX_VALUE)
										.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING)
				.addGroup(
						groupLayout.createSequentialGroup().addComponent(
								toolBar, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE).addPreferredGap(
								LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE,
										489, Short.MAX_VALUE).addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(panel_1,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)));
		this.getContentPane().setLayout(groupLayout);

		final JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		final JMenu inmuebleMenu = new JMenu();
		inmuebleMenu.setText("Inmueble");
		menuBar.add(inmuebleMenu);

		final JMenuItem newItemMenuItem_4 = new JMenuItem();
		newItemMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				((CardLayout) panel.getLayout()).show(panel, "verInmueble");
			}
		});
		newItemMenuItem_4.setText("Ver Inmueble");
		inmuebleMenu.add(newItemMenuItem_4);

		final JMenuItem newItemMenuItem_1 = new JMenuItem();
		newItemMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				SeleccionarInmuebleDialog d = new SeleccionarInmuebleDialog();
				d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				d.setLocationRelativeTo(null);
				d.setVisible(true);
			}
		});
		newItemMenuItem_1.setText("Vender Inmueble");
		inmuebleMenu.add(newItemMenuItem_1);

		final JMenu clientesMenu = new JMenu();
		clientesMenu.setText("Clientes");
		menuBar.add(clientesMenu);

		final JMenuItem newItemMenuItem_2 = new JMenuItem();
		newItemMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				((CardLayout) panel.getLayout()).show(panel, "nuevoCliente");
			}
		});
		newItemMenuItem_2.setText("Nuevo Cliente");
		clientesMenu.add(newItemMenuItem_2);

		final JMenuItem newItemMenuItem_6 = new JMenuItem();
		newItemMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				((CardLayout) panel.getLayout()).show(panel, "verCliente");
			}
		});
		newItemMenuItem_6.setText("Ver Cliente");
		clientesMenu.add(newItemMenuItem_6);

		final JMenu fichasMenu = new JMenu();
		fichasMenu.setText("Fichas");
		menuBar.add(fichasMenu);

		final JMenuItem newItemMenuItem_3 = new JMenuItem();
		newItemMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				((CardLayout) panel.getLayout()).show(panel, "verInmueble");
			}
		});
		newItemMenuItem_3.setText("Ficha Inmueble");
		fichasMenu.add(newItemMenuItem_3);

		final JMenuItem newItemMenuItem_5 = new JMenuItem();
		newItemMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				((CardLayout) panel.getLayout()).show(panel, "verCliente");
			}
		});
		newItemMenuItem_5.setText("Ficha Cliente");
		fichasMenu.add(newItemMenuItem_5);

		final JMenuItem newItemMenuItem_7 = new JMenuItem();
		newItemMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				((CardLayout) panel.getLayout()).show(panel, "verPeritaje");
			}
		});
		newItemMenuItem_7.setText("Ficha Peritaje");
		fichasMenu.add(newItemMenuItem_7);

		final JMenuItem newItemMenuItem_8 = new JMenuItem();
		newItemMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				((CardLayout) panel.getLayout()).show(panel, "verVisita");
			}
		});
		newItemMenuItem_8.setText("Ficha Visita");
		fichasMenu.add(newItemMenuItem_8);

		final JMenu verMenu = new JMenu();
		verMenu.setText("Ver");
		menuBar.add(verMenu);

		final JMenuItem newItemMenuItem = new JMenuItem();
		newItemMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				((CardLayout) panel.getLayout()).show(panel, "presentacion");
			}
		});
		newItemMenuItem.setText("Presentación");
		verMenu.add(newItemMenuItem);

		pack();
		//
	}

	public static Nagusia getInstance() {
		return nagusia;
	}

	public void showVenderInmueble(Inmueble inmueble) {
		venderInmueblePanel.setInmueble(inmueble.getReferencia());
		((CardLayout) panel.getLayout()).show(panel, "venderInmueble");
	}

	public void updateInmueble() {
		verInmueblePanel.updateInmueble();
		venderInmueblePanel.updateInmueble();
	}

	public void show(String panelName) {
		((CardLayout) panel.getLayout()).show(panel, panelName);
	}

	public void showVerInmueble(int referencia) {
		verInmueblePanel.setInmueble(referencia);
		((CardLayout) panel.getLayout()).show(panel, "verInmueble");
	}

	public void showVerCliente(String dni) {
		verClientePanel.setCliente(dni);
		((CardLayout) panel.getLayout()).show(panel, "verCliente");
	}

	public void showMostrarClientesInterados(String zona, int habs,
			double precio) {
		mostrarClientesInteresadosPanel.setDatos(zona, habs, precio);
		// mostrarClientesInteresadosPanel.refresh();
		((CardLayout) panel.getLayout()).show(panel,
				"mostrarClientesInteresados");
	}

	public void showVerVisita(int refInm, Calendar fecha, String dni,
			String representante) {
		verVisitaPanel.setDatos(dni, refInm, fecha, representante);
		((CardLayout) panel.getLayout()).show(panel, "verVisita");
	}

	public void showModificarInmueble(Inmueble inmueble) {
		modificarInmueblePanel.setDatuak(inmueble);
		((CardLayout) panel.getLayout()).show(panel, "modificarInmueble");
	}

	private final class NagusiaWindowListener implements WindowListener {
		@Override
		public void windowActivated(WindowEvent e) {
		}

		@Override
		public void windowClosed(WindowEvent e) {
		}

		@Override
		public void windowClosing(WindowEvent e) {
			try {
				Connector.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.exit(0);
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
		}

		@Override
		public void windowIconified(WindowEvent e) {
		}

		@Override
		public void windowOpened(WindowEvent e) {
		}
	}
}
