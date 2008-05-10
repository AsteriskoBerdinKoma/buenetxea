package buenetxea.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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

import buenetxea.gui.dialogs.SeleccionarInmuebleDialog;
import buenetxea.gui.panelak.BuenetxeaPanel;
import buenetxea.gui.panelak.CrearClientePanel;
import buenetxea.gui.panelak.CrearPropietarioPanel;
import buenetxea.gui.panelak.IntroducirInmueblePanel;
import buenetxea.gui.panelak.LocalizarClientePanel;
import buenetxea.gui.panelak.LocalizarInmueblePanel;
import buenetxea.gui.panelak.SeguimientoPropietarioPanel;
import buenetxea.gui.panelak.VenderInmueblePanel;

import com.swtdesigner.SwingResourceManager;

public class Nagusia extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel;

	private static Nagusia nagusia;

	private VenderInmueblePanel venderInmueblePanel;

	/**
	 * Create the frame
	 */
	public Nagusia() {
		super();

		nagusia = this;

		this.setJMenuBar(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

			final BuenetxeaPanel buenetxeaPanel = new BuenetxeaPanel();
			buenetxeaPanel.setName("presentacion");
			panel.add(buenetxeaPanel, buenetxeaPanel.getName());

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

		final LocalizarInmueblePanel localizadorPanel = new LocalizarInmueblePanel();
		localizadorPanel.setName("localizador");
		panel.add(localizadorPanel, localizadorPanel.getName());

		venderInmueblePanel = new VenderInmueblePanel();
		venderInmueblePanel.setName("venderInmueble");
		panel.add(venderInmueblePanel, venderInmueblePanel.getName());
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
				((CardLayout) panel.getLayout())
						.show(panel, "localizarCliente");
			}
		});
		toolBar.add(localizarClienteButton);
		final GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(panel_1,
				GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE).addGroup(
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 472,
								Short.MAX_VALUE).addContainerGap())
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 492,
						Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING)
				.addGroup(
						groupLayout.createSequentialGroup().addComponent(
								toolBar, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE).addPreferredGap(
								LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE,
										238, Short.MAX_VALUE).addPreferredGap(
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

		final JMenuItem newItemMenuItem_1 = new JMenuItem();
		newItemMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				SeleccionarInmuebleDialog d = new SeleccionarInmuebleDialog();
				d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				d.setLocationRelativeTo(null);
				d.setJabea(venderInmueblePanel);
				d.setVisible(true);
				((CardLayout) panel.getLayout()).show(panel, "venderInmueble");
			}
		});
		newItemMenuItem_1.setText("Vender Inmueble");
		inmuebleMenu.add(newItemMenuItem_1);

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
}
