import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Encryption extends cryption{
	
	public Encryption() {
		panel = this;
		
		key = key_str.getText();
		key = key.toLowerCase();
		str = before_str.getText();
		str = str.toLowerCase();
		
		
		title.setText("��ȣȭ");
		change_btn.setText("��ȣ�� �����");
		change_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				key = key_str.getText();
				key = key.toLowerCase();
				str = before_str.getText();
				str = str.toLowerCase();
				
				setBoard(key);							//��ȣȭ�� ���� ��ȣ�� ����
					
				for( int i = 0 ; i < str.length() ; i++ ) 
				{
					if(str.charAt(i)==' ') //��������
					{
						str = str.substring(0,i)+str.substring(i+1,str.length());
						b_Check+=10;
					}
					else
					{
						b_Check+=0;
					}
					if(str.charAt(i)=='z') //z�� q�� �ٲ��༭ ó����.
					{
						str = str.substring(0,i)+'q'+str.substring(i+1,str.length());
						Check+=1;
					}
					else 
					{
						Check+=0;
					}
				}
					
				encryption_str = strEncryption(key, str);
				after_str.setText(encryption_str);
				System.out.println("��ȣȭ�� ���ڿ� : " + encryption_str);
				}
		});
	}

}
