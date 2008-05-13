package buenetxea.gui.panelak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
import javax.swing.table.DefaultTableModel;

import buenetxea.db.ResultSetTableModel;
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
	private ResultSetTableModel tableModel;
	private ResultSetTableModel tableModel2;

	private Kudeatzailea kud;
	private boolean datuaSartua = false;

	/**
	 * Create the panel
	 */
	public SeguimientoPropietarioPanel() {
		super();
		addComponentListener(new ComponentAdapter() {
			public void componentShown(final ComponentEvent arg0) {
				try {
					if (tableModel == null){
						tableModel = new ResultSetTableModel(getQuery());
						System.out.println("tablemodel sortua");
					}
					else{
						tableModel.refresh();
						System.out.println("tablemodel refresh");
					}
					if (tableModel2 == null){
						tableModel2 = new ResultSetTableModel(getQuery2());
						System.out.println("tablemodel2 sortua");
					}
					else{
						tableModel2.refresh();
						System.out.println("tablemodel2 refreah");
					}
					table_1.setModel(tableModel);
					table.setModel(tableModel2);
					System.out.println("tablemodelak esleituta");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			public void componentHidden(final ComponentEvent arg0) {
				table_1.setModel(new DefaultTableModel());
				table.setModel(new DefaultTableModel());
			}
		});

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
			
			JPanel panel_2;
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Búsqueda",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			
			//Visitas realizadas
			JScrollPane scrollPane_1;
			scrollPane_1 = new JScrollPane();
			
			//Cambios propietario
			JScrollPane scrollPane;
			scrollPane = new JScrollPane();

			table_1 = new JTable();
			table_1.setModel(new DefaultTableModel());
			scrollPane_1.setViewportView(table_1);

			table = new JTable();
			table.setModel(new DefaultTableModel());
			scrollPane.setViewportView(table);

			

			JLabel label;
			label = new JLabel();
			label.setText("nº referencia:");
			
			tableModel = new ResultSetTableModel(getQuery());
			tableModel2 = new ResultSetTableModel(getQuery2());
			table_1.setModel(new DefaultTableModel());
			table.setModel(new DefaultTableModel());

			JButton button;
			button = new JButton();
			button.setText("Buscar");

			textField = new JTextField();
			
			button.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					if (!textField.getText().isEmpty()) {
						datuaSartua = true;

						int numReferencia;
						numReferencia = Integer.parseInt(textField.getText());
						try {

							Inmueble inmueble = kud.getInmueble(numReferencia);
							if (inmueble != null) {
								tableModel.setQuery(getQuery());
								tableModel2.setQuery(getQuery2());
								tableModel.refresh();
								tableModel2.refresh();
							} else {
								JOptionPane joptionpane = new JOptionPane(
										"La referencia del inmueble introducida no se encuentra en la base de datos.",
										JOptionPane.ERROR_MESSAGE);
								joptionpane.createDialog(
										"Inmueble no encontrado").setVisible(
										true);
							}
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
				}

			});
			
			final GroupLayout groupLayout_2 = new GroupLayout(
					(JComponent) panel_1);
			groupLayout_2.setHorizontalGroup(groupLayout_2.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout_2.createSequentialGroup().addContainerGap()
							.addComponent(scrollPane_1,
									GroupLayout.DEFAULT_SIZE, 428,
									Short.MAX_VALUE).addContainerGap()));
			groupLayout_2.setVerticalGroup(groupLayout_2.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout_2.createSequentialGroup().addComponent(
							scrollPane_1, GroupLayout.DEFAULT_SIZE, 88,
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
							.addComponent(button).addContainerGap(203,
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
									428, Short.MAX_VALUE).addContainerGap()));
			groupLayout_1.setVerticalGroup(groupLayout_1.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout_1.createSequentialGroup().addComponent(
							scrollPane, GroupLayout.DEFAULT_SIZE, 87,
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
																	464,
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
									129, Short.MAX_VALUE).addPreferredGap(
									LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 128,
									Short.MAX_VALUE).addGap(12, 12, 12)));
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

	private String getQuery() {
		// TODO Auto-generated method stub
		int ref = 0;
		if (datuaSartua)
			ref = Integer.parseInt(textField.getText().trim());
		return "SELECT * FROM rel_visita WHERE fk_inmueble_referencia ="
				+ ref + " GROUP BY fk_cliente_dni";
	}

	private String getQuery2() {
		// TODO Auto-generated method stub
		int ref = 0;
		if (datuaSartua)
			ref = Integer.parseInt(textField.getText().trim());
		return "SELECT * FROM rel_inmueble_propietario WHERE fk_inmueble_referencia ="
				+ ref;
	}
}
