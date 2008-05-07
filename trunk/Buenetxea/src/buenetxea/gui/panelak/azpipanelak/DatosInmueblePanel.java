/*
 * Form.java
 *
 * Created on 16 de abril de 2008, 20:30
 */

package buenetxea.gui.panelak.azpipanelak;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumn;

import buenetxea.objektuak.Inmueble;
import buenetxea.objektuak.Peritaje;
import buenetxea.objektuak.Descripcion;

import com.toedter.calendar.JDateChooser;

/**
 * 
 * @author Torwidev
 */
public class DatosInmueblePanel extends javax.swing.JPanel {

	private JSpinner alturaEdif;
	private JSpinner alturaPiso;
	private JComboBox tipoVenta;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JCheckBox ascensor;
	private javax.swing.JCheckBox desalojo;
	private javax.swing.JCheckBox reformas;
	private javax.swing.JComboBox orientacion;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel23;
	private javax.swing.JLabel jLabel24;
	private javax.swing.JLabel jLabel25;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton2;
	private javax.swing.JRadioButton jRadioButton3;
	private javax.swing.JRadioButton jRadioButton4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane observacionesScroll;
	private javax.swing.JSpinner anosFinca;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;
	private javax.swing.JTextArea observaciones;
	private javax.swing.JTextField m2constr;
	private javax.swing.JTextField tipoSuelo;
	private javax.swing.JTextField m2parcela;
	private javax.swing.JTextField puertas;
	private javax.swing.JTextField ventanas;
	private javax.swing.JTextField muebles;
	private javax.swing.JTextField gastosComun;
	private javax.swing.JTextField perito;
	private javax.swing.JTextField gas;
	private javax.swing.JTextField horaPeritaje;
	private javax.swing.JTextField referencia;
	private javax.swing.JTextField zona;
	private javax.swing.JTextField direccion;
	private javax.swing.JTextField luminoso;
	private javax.swing.JTextField techos;
	private javax.swing.JTextField exterior;
	private javax.swing.JTextField portero;
	private javax.swing.JTextField m2utiles;
	private javax.swing.JTextField calefaccion;
	private javax.swing.JTextField pintura;
	private JDateChooser fechaPeritaje;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Creates new form Form */
	public DatosInmueblePanel() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		fechaPeritaje = new JDateChooser();
		fechaPeritaje.setDateFormatString("d/M/yyyy");
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		fechaPeritaje.setCalendar(cal);
		jPanel1 = new javax.swing.JPanel();
		jLabel20 = new javax.swing.JLabel();
		perito = new javax.swing.JTextField();
		jLabel21 = new javax.swing.JLabel();
		jLabel22 = new javax.swing.JLabel();
		horaPeritaje = new javax.swing.JTextField();
		jRadioButton1 = new javax.swing.JRadioButton("Piso", true);
		jRadioButton2 = new javax.swing.JRadioButton();
		jRadioButton3 = new javax.swing.JRadioButton();
		jRadioButton4 = new javax.swing.JRadioButton();
		buttonGroup1 = new javax.swing.ButtonGroup();
		buttonGroup1.add(jRadioButton1);
		buttonGroup1.add(jRadioButton2);
		buttonGroup1.add(jRadioButton3);
		buttonGroup1.add(jRadioButton4);
		jPanel2 = new javax.swing.JPanel();
		jLabel23 = new javax.swing.JLabel();
		referencia = new javax.swing.JTextField();
		jLabel24 = new javax.swing.JLabel();
		jLabel25 = new javax.swing.JLabel();
		zona = new javax.swing.JTextField();
		direccion = new javax.swing.JTextField();
		jPanel3 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jPanel4 = new javax.swing.JPanel();
		jPanel6 = new javax.swing.JPanel();
		jPanel6.setBorder(new EmptyBorder(0, 0, 0, 0));
		jLabel1 = new javax.swing.JLabel();
		m2constr = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		ascensor = new javax.swing.JCheckBox();
		ascensor.setMargin(new Insets(2, 0, 2, 2));
		ascensor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		gas = new javax.swing.JTextField();
		luminoso = new javax.swing.JTextField();
		techos = new javax.swing.JTextField();
		exterior = new javax.swing.JTextField();
		anosFinca = new javax.swing.JSpinner();
		portero = new javax.swing.JTextField();
		jPanel7 = new javax.swing.JPanel();
		jPanel7.setBorder(new EmptyBorder(0, 0, 0, 0));
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		m2utiles = new javax.swing.JTextField();
		calefaccion = new javax.swing.JTextField();
		jLabel12 = new javax.swing.JLabel();
		pintura = new javax.swing.JTextField();
		tipoSuelo = new javax.swing.JTextField();
		orientacion = new javax.swing.JComboBox();
		desalojo = new javax.swing.JCheckBox();
		desalojo.setMargin(new Insets(2, 0, 2, 2));
		desalojo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		jPanel8 = new javax.swing.JPanel();
		jPanel8.setBorder(new EmptyBorder(0, 0, 0, 0));
		jLabel13 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jLabel16 = new javax.swing.JLabel();
		jLabel17 = new javax.swing.JLabel();
		jLabel18 = new javax.swing.JLabel();
		jLabel19 = new javax.swing.JLabel();
		reformas = new javax.swing.JCheckBox();
		reformas.setMargin(new Insets(2, 0, 2, 2));
		reformas.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		m2parcela = new javax.swing.JTextField();
		puertas = new javax.swing.JTextField();
		ventanas = new javax.swing.JTextField();
		muebles = new javax.swing.JTextField();
		gastosComun = new javax.swing.JTextField();
		jPanel5 = new javax.swing.JPanel();
		observacionesScroll = new javax.swing.JScrollPane();
		observaciones = new javax.swing.JTextArea();

		setBorder(new TitledBorder(new EmptyBorder(0, 0, 0, 0), "",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		jPanel1.setBorder(new TitledBorder(null, "Peritaje",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		jLabel20.setText("Perito");

		jLabel21.setText("Fecha");

		jLabel22.setText("Hora");

		jRadioButton1.setText("Piso");
		jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton1ActionPerformed(evt);
			}
		});

		jRadioButton2.setText("Casa");
		jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton2ActionPerformed(evt);
			}
		});

		jRadioButton3.setText("Local");
		jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton3ActionPerformed(evt);
			}
		});

		jRadioButton4.setText("Parking");

		jPanel2.setBorder(new TitledBorder(null, "Localizaci�n",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		jLabel23.setText("Referencia");

		jLabel24.setText("Zona");

		jLabel25.setText("Direcci�n");

		jPanel3.setBorder(new TitledBorder(null, "Descripci�n",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null } },
				new String[] { "Tipo", "m�", "Descripci�n" }));
		jTable1.setColumnSelectionAllowed(false);
		jTable1.setRowSelectionAllowed(false);
		jScrollPane1.setViewportView(jTable1);
		SelectAllEditor sae = new SelectAllEditor();
		DefaultCellEditor jte1ce = new DefaultCellEditor(sae);
		jte1ce.setClickCountToStart(1);
		TableColumn c1 = jTable1.getColumnModel().getColumn(0);
		TableColumn c2 = jTable1.getColumnModel().getColumn(1);
		TableColumn c3 = jTable1.getColumnModel().getColumn(2);
		c1.setCellEditor(jte1ce);
		c2.setCellEditor(jte1ce);
		c2.setPreferredWidth(7);
		c3.setCellEditor(jte1ce);

		jTable2.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null } },
				new String[] { "Tipo", "m�", "Descripci�n" }));
		jTable2.setColumnSelectionAllowed(false);
		jTable2.setRowSelectionAllowed(false);
		jScrollPane2.setViewportView(jTable2);
		TableColumn c4 = jTable2.getColumnModel().getColumn(0);
		TableColumn c5 = jTable2.getColumnModel().getColumn(1);
		TableColumn c6 = jTable2.getColumnModel().getColumn(2);
		c4.setCellEditor(jte1ce);
		c5.setCellEditor(jte1ce);
		c5.setPreferredWidth(7);
		c6.setCellEditor(jte1ce);

		jPanel4.setBorder(new TitledBorder(null, "General",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		jLabel1.setText("m� constr.");

		jLabel2.setText("Gas");

		jLabel3.setText("Luminoso");

		jLabel4.setText("Techos");

		jLabel5.setText("Exterior");

		jLabel6.setText("A�os Finca");

		jLabel7.setText("Portero");

		ascensor.setText("Ascensor");
		ascensor.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ascensorActionPerformed(evt);
			}
		});

		jLabel8.setText("m� �tiles");

		jLabel9.setText("Calefacci�n");

		jLabel10.setText("Pintura");

		jLabel11.setText("Tipo suelo");

		jLabel12.setText("Orientaci�n");

		orientacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"N", "S", "E", "O", "NE", "NO", "SE", "SO" }));

		desalojo.setText("Desalojo");

		jLabel13.setText("m� parcela");

		jLabel14.setText("Puertas");

		jLabel15.setText("Ventanas");

		jLabel16.setText("Muebles");

		jLabel17.setText("Altura edif. (pisos)");

		jLabel18.setText("Alt. real piso (piso)");

		jLabel19.setText("Gastos comun.");

		reformas.setText("Reformas");

		jPanel5.setBorder(new TitledBorder(null, "Observaciones",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		observaciones.setColumns(20);
		observaciones.setRows(5);
		observacionesScroll.setViewportView(observaciones);

		JLabel ventaLabel;
		ventaLabel = new JLabel();
		ventaLabel.setText("Venta");

		tipoVenta = new JComboBox();
		tipoVenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Exclusiva", "Verde" }));

		alturaPiso = new JSpinner();

		alturaEdif = new JSpinner();

		javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(
				jPanel8);
		jPanel8Layout.setHorizontalGroup(
			jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel8Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(reformas)
						.addGroup(jPanel8Layout.createSequentialGroup()
							.addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jLabel18)
								.addComponent(jLabel19))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(alturaPiso, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
								.addComponent(gastosComun, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
						.addGroup(jPanel8Layout.createSequentialGroup()
							.addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jLabel17)
								.addComponent(jLabel16)
								.addComponent(jLabel15)
								.addComponent(jLabel14)
								.addComponent(jLabel13))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(m2parcela, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
								.addComponent(puertas, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
								.addComponent(ventanas, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
								.addComponent(muebles, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
								.addComponent(alturaEdif, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))))
					.addContainerGap())
		);
		jPanel8Layout.setVerticalGroup(
			jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel8Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel13)
						.addComponent(m2parcela, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel14)
						.addComponent(puertas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel15)
						.addComponent(ventanas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel16)
						.addComponent(muebles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel17)
						.addComponent(alturaEdif, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel18)
						.addComponent(alturaPiso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel19)
						.addComponent(gastosComun, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(reformas)
					.addContainerGap())
		);
		jPanel8.setLayout(jPanel8Layout);

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(
				jPanel7);
		jPanel7Layout.setHorizontalGroup(
			jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel7Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(desalojo)
						.addGroup(jPanel7Layout.createSequentialGroup()
							.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jLabel12)
								.addComponent(jLabel11)
								.addComponent(jLabel10)
								.addComponent(jLabel9)
								.addComponent(jLabel8))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(orientacion, 0, 6, Short.MAX_VALUE)
								.addComponent(tipoSuelo, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
								.addComponent(pintura, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
								.addComponent(calefaccion, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
								.addComponent(m2utiles, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))))
					.addContainerGap())
		);
		jPanel7Layout.setVerticalGroup(
			jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel7Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel8)
						.addComponent(m2utiles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel9)
						.addComponent(calefaccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel10)
						.addComponent(pintura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel11)
						.addComponent(tipoSuelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel12)
						.addComponent(orientacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(desalojo)
					.addGap(59, 59, 59))
		);
		jPanel7.setLayout(jPanel7Layout);

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(
				jPanel6);
		jPanel6Layout.setHorizontalGroup(
			jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel6Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel6Layout.createSequentialGroup()
							.addComponent(jLabel6)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(anosFinca, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel6Layout.createSequentialGroup()
							.addComponent(jLabel7)
							.addGap(20, 20, 20)
							.addComponent(portero, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
						.addComponent(ascensor)
						.addGroup(jPanel6Layout.createSequentialGroup()
							.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(jLabel2)
								.addComponent(jLabel3)
								.addComponent(jLabel5)
								.addComponent(jLabel4)
								.addComponent(jLabel1))
							.addGap(5, 5, 5)
							.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(luminoso, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
								.addComponent(techos, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
								.addComponent(exterior, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
								.addGroup(jPanel6Layout.createSequentialGroup()
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(m2constr, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
										.addComponent(gas, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))))))
					.addContainerGap())
		);
		jPanel6Layout.setVerticalGroup(
			jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel6Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel1)
						.addComponent(m2constr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel2)
						.addComponent(gas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel3)
						.addComponent(luminoso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel4)
						.addComponent(techos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel5)
						.addComponent(exterior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel6)
						.addComponent(anosFinca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel7)
						.addComponent(portero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(ascensor))
		);
		jPanel6.setLayout(jPanel6Layout);

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4Layout.setHorizontalGroup(
			jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup()
					.addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jPanel7, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jPanel8, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
					.addContainerGap())
		);
		jPanel4Layout.setVerticalGroup(
			jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup()
					.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(jPanel8, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
						.addComponent(jPanel7, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
						.addComponent(jPanel6, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
					.addGap(3, 3, 3))
		);
		jPanel4.setLayout(jPanel4Layout);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3Layout.setHorizontalGroup(
			jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
					.addContainerGap())
		);
		jPanel3Layout.setVerticalGroup(
			jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
				.addGroup(jPanel3Layout.createSequentialGroup()
					.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
						.addComponent(jScrollPane2, 0, 0, Short.MAX_VALUE))
					.addContainerGap())
		);
		jPanel3.setLayout(jPanel3Layout);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addComponent(jLabel20)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(perito, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addComponent(jLabel21)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(fechaPeritaje, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
							.addComponent(jLabel22)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(horaPeritaje, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
					.addGap(52, 52, 52)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(jRadioButton2))
						.addComponent(jRadioButton1))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jRadioButton3)
						.addComponent(jRadioButton4))
					.addGap(81, 81, 81))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(jRadioButton4)
							.addComponent(jRadioButton2))
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel20)
								.addComponent(jRadioButton1)
								.addComponent(jRadioButton3)
								.addComponent(perito, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel21)
								.addComponent(fechaPeritaje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel22)
								.addComponent(horaPeritaje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		jPanel1.setLayout(jPanel1Layout);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2Layout.setHorizontalGroup(
			jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(jLabel23)
						.addComponent(ventaLabel))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(referencia, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
						.addComponent(tipoVenta, 0, 109, Short.MAX_VALUE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addComponent(jLabel25)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(direccion, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
						.addGroup(jPanel2Layout.createSequentialGroup()
							.addComponent(jLabel24)
							.addGap(23, 23, 23)
							.addComponent(zona, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)))
					.addContainerGap())
		);
		jPanel2Layout.setVerticalGroup(
			jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel23)
						.addComponent(jLabel24)
						.addComponent(zona, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(referencia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(jLabel25)
						.addComponent(direccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ventaLabel)
						.addComponent(tipoVenta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		jPanel2.setLayout(jPanel2Layout);

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5Layout.setHorizontalGroup(
			jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(observacionesScroll, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
					.addContainerGap())
		);
		jPanel5Layout.setVerticalGroup(
			jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(observacionesScroll, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
		);
		jPanel5.setLayout(jPanel5Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(jPanel5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
						.addComponent(jPanel2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
						.addComponent(jPanel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
						.addComponent(jPanel3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
						.addComponent(jPanel4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		this.setLayout(layout);
	}// </editor-fold>//GEN-END:initComponents

	private void ascensorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jCheckBox1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jCheckBox1ActionPerformed

	private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jRadioButton1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jRadioButton1ActionPerformed

	private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jRadioButton2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jRadioButton2ActionPerformed

	private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jRadioButton3ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jRadioButton3ActionPerformed

	class SelectAllEditor extends JTextField implements FocusListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SelectAllEditor() {
			setBorder(new LineBorder(Color.black));
			addFocusListener(this);
		}

		public void setText(String text) {
			super.setText(text);
			selectAll();
		}

		public void focusGained(FocusEvent e) {
			if (getSelectionStart() == getSelectionEnd())
				selectAll();
		}

		public void focusLost(FocusEvent e) {
		}
	}

	public boolean comprobarDatos() {
		boolean correcto = false;
		if (perito.getText().equals("")) {
			perito.setBorder(new LineBorder(Color.RED));// Debes introducir un
														// perito
		} else if ("kaixo".equals("")) {
			// Debes introducir fecha
		} else {
			correcto = true;
		}
		return correcto;
	}

	public Peritaje generarPeritaje(int peritajeId) {
		Enumeration<AbstractButton> b = buttonGroup1.getElements();
		String tipoInmueble = "";
		while (b.hasMoreElements()) {
			AbstractButton but = b.nextElement();
			if (but.isSelected()) {
				tipoInmueble = but.getText();
			}
		}

		Calendar fecha = fechaPeritaje.getCalendar();
		//fecha.setTime();
		return new Peritaje(peritajeId, fecha, perito.getText(), tipoInmueble,
				(String) tipoVenta.getSelectedItem(), Integer.parseInt(m2constr.getText()), 
				gas.getText(), luminoso.getText(), techos.getText(), exterior.getText(), 
				Integer.parseInt(anosFinca.getValue().toString()), portero.getText(), 
				ascensor.isSelected(), Integer.parseInt(m2utiles.getText()), calefaccion.getText(),
				pintura.getText(), tipoSuelo.getText(), (String) orientacion.getSelectedItem(), 
				desalojo.isSelected(), Integer.parseInt(m2parcela.getText()), 
				puertas.getText(), ventanas.getText(), muebles.getText(), 
				Integer.parseInt(alturaEdif.getValue().toString()), 
				Integer.parseInt(alturaPiso.getValue().toString()), 
				Double.parseDouble(gastosComun.getText()), observaciones.getText());
	}

	public Inmueble generarInmueble() {
		return new Inmueble(Integer.parseInt(referencia.getText()), zona
				.getText(), direccion.getText(), false);
	}

	public Vector<Descripcion> generarDescripciones(int peritajeId) {
		Vector<Descripcion> d = new Vector<Descripcion>();
		for (int i=0; i<jTable1.getRowCount(); i++){
			if (!jTable1.getValueAt(i, 1).toString().equals("") && !jTable1.getValueAt(i, 2).toString().equals("") && !jTable1.getValueAt(i, 3).toString().equals(""))
				d.add(new Descripcion(peritajeId,jTable1.getValueAt(i, 1).toString(),Integer.parseInt(jTable1.getValueAt(i, 2).toString()),jTable1.getValueAt(i, 3).toString()));
			if (!jTable2.getValueAt(i, 1).toString().equals("") && !jTable2.getValueAt(i, 2).toString().equals("") && !jTable2.getValueAt(i, 3).toString().equals(""))
				d.add(new Descripcion(peritajeId,jTable2.getValueAt(i, 1).toString(),Integer.parseInt(jTable2.getValueAt(i, 2).toString()),jTable2.getValueAt(i, 3).toString()));
		}
		return d;
	}

	public static void main(String[] args) {
		DatosInmueblePanel x = new DatosInmueblePanel();
		JFrame y = new JFrame();
		y.add(x);
		y.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		y.setVisible(true);
	}
}
