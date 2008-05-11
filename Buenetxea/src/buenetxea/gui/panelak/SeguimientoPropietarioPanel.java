package buenetxea.gui.panelak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.TitledBorder;

import buenetxea.kudeatzaileak.Kudeatzailea;
import buenetxea.objektuak.Inmueble;

public class SeguimientoPropietarioPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textField;
	private JTable table_1;
	private JTable table;

	private Kudeatzailea kud;

	/**
	 * Create the panel
	 */
	public SeguimientoPropietarioPanel() {
		super();

		try {
			kud = Kudeatzailea.getInstance();

			setBorder(new TitledBorder(null, "Seguimiento propietario",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			JPanel panel;
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null,
					"Cambios realizados por el propietarios",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			JPanel panel_1;
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Visitas realizadas",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			JScrollPane scrollPane_1;
			scrollPane_1 = new JScrollPane();

			table_1 = new JTable();
			scrollPane_1.setViewportView(table_1);

			String[] zutabeIzenak = { "Fecha", "Resultado de visitas" };
			Object[][] data = { { new Integer(5), "Resultado bueno" },
					{ new Integer(3), "Resultado fallido" }, };
			table_1 = new JTable(data, zutabeIzenak);
			// scrollPane.setViewportView(table_1);

			JScrollPane scrollPane;
			scrollPane = new JScrollPane();

			table = new JTable();
			scrollPane_1.setViewportView(table);

			String[] zutabeIzenak1 = { "Fecha", "Observaciones", "Nuevo precio" };
			Object[][] data1 = {
					{ new Integer(5), "Resultado bueno", new Integer(10000) },
					{ new Integer(3), "Resultado fallido", new Integer(20000) }, };
			table_1 = new JTable(data1, zutabeIzenak1);
			// scrollPane.setViewportView(table);
			scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, table);

			JPanel panel_2;
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Búsqueda",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			JLabel label;
			label = new JLabel();
			label.setText("nº referencia:");

			JButton button;
			button = new JButton();
			button.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					int numReferencia;
					numReferencia = Integer.parseInt(textField.getText());
					try {
						Inmueble inmueble = kud.getInmueble(numReferencia);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane joptionpane = new JOptionPane(
								"La referencia del inmueble introducida no se encuentra en la base de datos.",
								JOptionPane.ERROR_MESSAGE);
						joptionpane.createDialog("Inmueble no encontrado")
								.setVisible(true);
					}
				}
			});
			button.setText("Buscar");

			textField = new JTextField();
			final GroupLayout groupLayout_2 = new GroupLayout(
					(JComponent) panel_1);
			groupLayout_2.setHorizontalGroup(groupLayout_2.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout_2.createSequentialGroup().addContainerGap()
							.addComponent(scrollPane_1,
									GroupLayout.DEFAULT_SIZE, 382,
									Short.MAX_VALUE).addContainerGap()));
			groupLayout_2.setVerticalGroup(groupLayout_2.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout_2.createSequentialGroup().addComponent(
							scrollPane_1, GroupLayout.DEFAULT_SIZE, 109,
							Short.MAX_VALUE).addContainerGap()));
			panel_1.setLayout(groupLayout_2);
			final GroupLayout groupLayout_3 = new GroupLayout(
					(JComponent) panel_2);
			groupLayout_3.setHorizontalGroup(groupLayout_3.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout_3.createSequentialGroup().addContainerGap()
							.addComponent(label).addPreferredGap(
									LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(textField,
									GroupLayout.PREFERRED_SIZE, 93,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(
									LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button).addContainerGap(157,
									Short.MAX_VALUE)));
			groupLayout_3.setVerticalGroup(groupLayout_3.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout_3.createSequentialGroup().addGroup(
							groupLayout_3.createParallelGroup(
									GroupLayout.Alignment.BASELINE)
									.addComponent(label).addComponent(
											textField,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(button)).addContainerGap(
							GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
			panel_2.setLayout(groupLayout_3);
			final GroupLayout groupLayout_1 = new GroupLayout(
					(JComponent) panel);
			groupLayout_1.setHorizontalGroup(groupLayout_1.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout_1.createSequentialGroup().addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
									382, Short.MAX_VALUE).addContainerGap()));
			groupLayout_1.setVerticalGroup(groupLayout_1.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout_1.createSequentialGroup().addComponent(
							scrollPane, GroupLayout.DEFAULT_SIZE, 109,
							Short.MAX_VALUE).addContainerGap()));
			panel.setLayout(groupLayout_1);
			final GroupLayout groupLayout = new GroupLayout((JComponent) this);
			groupLayout
					.setHorizontalGroup(groupLayout
							.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(
									groupLayout
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.LEADING)
															.addComponent(
																	panel,
																	0,
																	0,
																	Short.MAX_VALUE)
															.addComponent(
																	panel_2,
																	GroupLayout.DEFAULT_SIZE,
																	418,
																	Short.MAX_VALUE)
															.addComponent(
																	panel_1,
																	GroupLayout.Alignment.TRAILING,
																	GroupLayout.PREFERRED_SIZE,
																	0,
																	Short.MAX_VALUE))
											.addContainerGap()));
			groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout.createSequentialGroup().addComponent(panel_2,
							GroupLayout.PREFERRED_SIZE,
							GroupLayout.DEFAULT_SIZE,
							GroupLayout.PREFERRED_SIZE).addPreferredGap(
							LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE,
									150, Short.MAX_VALUE).addPreferredGap(
									LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE,
									GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(12, 12, 12)));
			setLayout(groupLayout);
			//
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

}
