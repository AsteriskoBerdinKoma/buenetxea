/*
 * Form.java
 *
 * Created on 16 de abril de 2008, 20:30
 */

package buenetxea.gui.panelak.azpipanelak;

import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import buenetxea.objektuak.Tasacion;

/**
 * 
 * @author Torwidev
 */
public class DatosTasacionPanel extends JPanel {

	private JTextField precioIdealVentaTextfield;
	private JTextField precioIdealOpCompraTextfield;
	private JTextField precioVentaTextfield;
	private JTextField precioIdealCompraTextfield;
	private JTextField netoPropietarioTextfield;
	private JTextField ivaTextfield;
	private JTextField precioComisionTextfield;
	private JPanel jPanel1;
	private JLabel llavesLabel;
	private JLabel cartelPublicidadLabel;
	private JRadioButton cartelSi;
	private JRadioButton cartelNo;
	private JRadioButton llavesSi;
	private JRadioButton llavesNo;
	private ButtonGroup cartelGroup;
	private ButtonGroup llavesGroup;

	private JPanel jPanel2;

	private JLabel ivaLabel;

	private JLabel precioVentaLabel;
	private JLabel precioIdealVentaLabel;
	private JLabel precioIdealOpcionCompraLabel;
	private JLabel precioComisionLabel;
	private JLabel netoPropietarioLabel;
	private JLabel precioIdealCompraLabel;
	private JLabel ivaPorcentajeLabel;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form Form
	 * 
	 * @throws ParseException
	 */
	public DatosTasacionPanel() throws ParseException {
		initComponents();
	}

	private void initComponents() throws ParseException {

		setBorder(new TitledBorder(new EmptyBorder(0, 0, 0, 0), "",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		jPanel1 = new JPanel();
		jPanel2 = new JPanel();

		jPanel1.setBorder(new TitledBorder(null, "Información",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		llavesLabel = new JLabel();
		cartelPublicidadLabel = new JLabel();
		cartelSi = new JRadioButton("Sí", true);
		cartelNo = new JRadioButton();
		llavesSi = new JRadioButton("Sí", true);
		llavesNo = new JRadioButton();
		cartelGroup = new ButtonGroup();
		llavesGroup = new ButtonGroup();

		llavesLabel.setText("¿Avisar llaves?");
		cartelPublicidadLabel.setText("¿Cartel publicitario?");
		cartelSi.setText("Sí");
		cartelNo.setText("No");
		llavesSi.setText("Sí");
		llavesNo.setText("No");
		cartelGroup.add(cartelSi);
		cartelGroup.add(cartelNo);
		llavesGroup.add(llavesSi);
		llavesGroup.add(llavesNo);

		jPanel2.setBorder(new TitledBorder(null, "Precios",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		precioVentaLabel = new JLabel();
		precioIdealVentaLabel = new JLabel();
		precioIdealOpcionCompraLabel = new JLabel();
		precioComisionLabel = new JLabel();
		ivaLabel = new JLabel();
		netoPropietarioLabel = new JLabel();
		precioIdealCompraLabel = new JLabel();
		ivaPorcentajeLabel = new JLabel();

		precioVentaLabel.setText("Precio venta");
		precioIdealVentaLabel.setText("Precio ideal venta");
		precioIdealOpcionCompraLabel.setText("Precio ideal opción de compra");
		precioComisionLabel.setText("Precio comisión");
		ivaLabel.setText("IVA");
		ivaPorcentajeLabel.setText("%");
		netoPropietarioLabel.setText("Neto propietario");
		precioIdealCompraLabel.setText("Precio ideal compra");

		precioComisionTextfield = new JTextField("0.0");

		ivaTextfield = new JTextField("0.0");

		netoPropietarioTextfield = new JTextField("0.0");

		precioIdealCompraTextfield = new JTextField("0.0");

		precioVentaTextfield = new JTextField("0.0");

		precioIdealOpCompraTextfield = new JTextField("0.0");

		precioIdealVentaTextfield = new JTextField("0.0");

		JLabel label;
		label = new JLabel();
		label.setText("€");

		JLabel label_1;
		label_1 = new JLabel();
		label_1.setText("€");

		JLabel label_2;
		label_2 = new JLabel();
		label_2.setText("€");

		JLabel label_3;
		label_3 = new JLabel();
		label_3.setText("€");

		JLabel label_3_1;
		label_3_1 = new JLabel();
		label_3_1.setText("€");

		JLabel label_3_2;
		label_3_2 = new JLabel();
		label_3_2.setText("€");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				cartelPublicidadLabel)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				cartelSi)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				cartelNo))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				llavesLabel)
																		.addGap(
																				23,
																				23,
																				23)
																		.addComponent(
																				llavesSi)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				llavesNo)))
										.addContainerGap(281, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addGroup(
						jPanel1Layout.createParallelGroup(
								GroupLayout.Alignment.BASELINE).addComponent(
								llavesLabel).addComponent(llavesSi)
								.addComponent(llavesNo)).addPreferredGap(
						LayoutStyle.ComponentPlacement.RELATED).addGroup(
						jPanel1Layout.createParallelGroup(
								GroupLayout.Alignment.BASELINE).addComponent(
								cartelPublicidadLabel).addComponent(cartelSi)
								.addComponent(cartelNo)).addContainerGap()));
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																netoPropietarioLabel)
														.addComponent(
																precioVentaLabel)
														.addComponent(
																precioComisionLabel)
														.addComponent(ivaLabel))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				ivaTextfield,
																				GroupLayout.PREFERRED_SIZE,
																				64,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				ivaPorcentajeLabel))
														.addComponent(
																precioVentaTextfield,
																GroupLayout.Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE,
																105,
																Short.MAX_VALUE)
														.addComponent(
																precioComisionTextfield,
																GroupLayout.Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE,
																105,
																Short.MAX_VALUE)
														.addComponent(
																netoPropietarioTextfield,
																GroupLayout.DEFAULT_SIZE,
																105,
																Short.MAX_VALUE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								GroupLayout.Alignment.TRAILING)
																						.addGroup(
																								jPanel2Layout
																										.createSequentialGroup()
																										.addGroup(
																												jPanel2Layout
																														.createParallelGroup(
																																GroupLayout.Alignment.LEADING)
																														.addComponent(
																																label_1,
																																GroupLayout.DEFAULT_SIZE,
																																18,
																																Short.MAX_VALUE)
																														.addComponent(
																																label,
																																GroupLayout.DEFAULT_SIZE,
																																18,
																																Short.MAX_VALUE))
																										.addGap(
																												6,
																												6,
																												6)
																										.addGroup(
																												jPanel2Layout
																														.createParallelGroup(
																																GroupLayout.Alignment.TRAILING)
																														.addComponent(
																																precioIdealVentaLabel)
																														.addComponent(
																																precioIdealOpcionCompraLabel)))
																						.addComponent(
																								precioIdealCompraLabel))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								precioIdealCompraTextfield,
																								GroupLayout.DEFAULT_SIZE,
																								70,
																								Short.MAX_VALUE)
																						.addComponent(
																								precioIdealOpCompraTextfield,
																								GroupLayout.DEFAULT_SIZE,
																								70,
																								Short.MAX_VALUE)
																						.addGroup(
																								jPanel2Layout
																										.createSequentialGroup()
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												precioIdealVentaTextfield,
																												GroupLayout.DEFAULT_SIZE,
																												70,
																												Short.MAX_VALUE)))
																		.addGap(
																				10,
																				10,
																				10))
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				label_2)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED,
																				233,
																				Short.MAX_VALUE)))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																GroupLayout.Alignment.TRAILING)
														.addComponent(label_3)
														.addComponent(
																label_3_1,
																GroupLayout.PREFERRED_SIZE,
																6,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																label_3_2,
																GroupLayout.PREFERRED_SIZE,
																6,
																GroupLayout.PREFERRED_SIZE))));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																precioVentaLabel)
														.addComponent(
																precioVentaTextfield,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label)
														.addComponent(
																precioIdealVentaLabel)
														.addComponent(label_3)
														.addComponent(
																precioIdealVentaTextfield,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																precioComisionLabel)
														.addComponent(label_1)
														.addComponent(
																precioIdealOpcionCompraLabel)
														.addComponent(
																precioIdealOpCompraTextfield,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label_3_1)
														.addComponent(
																precioComisionTextfield,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(ivaLabel)
														.addComponent(
																ivaTextfield,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																ivaPorcentajeLabel)
														.addComponent(
																precioIdealCompraLabel)
														.addComponent(
																precioIdealCompraTextfield,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label_3_2))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																netoPropietarioLabel)
														.addComponent(label_2)
														.addComponent(
																netoPropietarioTextfield,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		jPanel2.setLayout(jPanel2Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.TRAILING).addGroup(
				layout.createSequentialGroup().addContainerGap().addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.TRAILING).addComponent(
								jPanel2, GroupLayout.Alignment.LEADING,
								GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
								.addComponent(jPanel1,
										GroupLayout.Alignment.LEADING,
										GroupLayout.DEFAULT_SIZE, 472,
										Short.MAX_VALUE)).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addComponent(jPanel1,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE).addPreferredGap(
						LayoutStyle.ComponentPlacement.RELATED).addComponent(
						jPanel2, GroupLayout.PREFERRED_SIZE, 134,
						GroupLayout.PREFERRED_SIZE).addContainerGap(144,
						Short.MAX_VALUE)));
		this.setLayout(layout);
	}

	public boolean comprobarDatos() {
		boolean correcto = true;
		return correcto;
	}

	public Tasacion generarTasacion(int peritajeId, int refInmueble) {
		return new Tasacion(peritajeId, refInmueble, llavesSi.isSelected(),
				Double.parseDouble(precioVentaTextfield.getText()), Double
						.parseDouble(precioComisionTextfield.getText()), Double
						.parseDouble(ivaTextfield.getText()), Double
						.parseDouble(netoPropietarioTextfield.getText()),
				Double.parseDouble(precioIdealVentaTextfield.getText()), Double
						.parseDouble(precioIdealOpCompraTextfield.getText()),
				Double.parseDouble(precioIdealCompraTextfield.getText()),
				cartelSi.isSelected());
	}
	// public static void main (String[] args){
	// DatosTasacionPanel x=null;
	// try {
	// x = new DatosTasacionPanel();
	// } catch (ParseException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// JFrame y = new JFrame();
	// y.add(x);
	// y.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// y.setVisible(true);
	// }
}
