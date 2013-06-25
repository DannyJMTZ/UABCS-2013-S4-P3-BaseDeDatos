import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class FormFrame extends JFrame implements MouseListener{
	
	private Client client;
	private JTextField txtName;
	private JButton save;
	
	private JLabel query;
	
	public FormFrame(){
		
		this.setLayout( null );
		this.setSize( 500 , 500 );
		this.setTitle( "Form Filling" );
		this.setLocationRelativeTo( null );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		this.client = new Client("mysql");
		
		
		this.txtName = new JTextField();
		this.txtName.setBounds( 50 , 50 , 150 , 50 );
		
		this.save = new JButton("Save");
		this.save.setBounds( 50 , 100 , 100 , 50 );
		this.save.addMouseListener( this );
		
		
		this.add( txtName );
		this.add( save );
		
		this.setVisible( true );
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) { 
		
		ResultSet resultSet = client.getData( this.txtName.getText() );
		
		try {
			
			int y = 150;
			
			while( resultSet.next() ){
				
				this.query = new JLabel( resultSet.getString( "name" ));
				this.query.setBounds( 50 , y += 50 , 100 , 50 );
				this.add( query );
				this.repaint();
				
			}
			
		} catch (SQLException e1) { }
		
	}
	@Override
	public void mouseEntered(MouseEvent e) { }
	@Override
	public void mouseExited(MouseEvent e) { }
	@Override
	public void mousePressed(MouseEvent e) { }
	@Override
	public void mouseReleased(MouseEvent e) { }
	

}
