package buenetxea.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;

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

import buenetxea.gui.panelak.VerInmueblePanel;
import buenetxea.kudeatzaileak.Kudeatzailea;

public class Nagusia extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Kudeatzailea kud;

	/**
	 * Create the frame
	 */
	public Nagusia(Kudeatzailea kudeatzailea) {
		super();

		this.kud = kudeatzailea;

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

		JPanel panel;
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
		VerInmueblePanel verInmueblePanel;
		verInmueblePanel = new VerInmueblePanel();
		verInmueblePanel.setName("verInmueblePanel");
		panel.add(verInmueblePanel, verInmueblePanel.getName());
		final JButton peritajeButton = new JButton();
		peritajeButton.setText("Peritaje");
		toolBar.add(peritajeButton);
		this.getContentPane().setLayout(groupLayout);
		this.pack();
		//
	}

}