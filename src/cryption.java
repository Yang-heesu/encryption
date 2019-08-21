import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class cryption extends JPanel{
	public static char alpha_Board[][] = new char[5][5];
	public static boolean Flag = false; //���ڼ� ���
	public static String Check ="";
	
	String decryption_str;
	String encryption_str;
	String key = "";
	String str = "";
	String b_Check="";
	
	JLabel title;
	JButton encryption_btn;
	JButton decryption_btn;
	
	JTable table;
	JButton change_btn;
	
	JLabel key_text;
	JLabel before_text;
	JLabel after_text;
	JTextField key_str;
	JTextField before_str;
	JTextField after_str;
	
	JPanel panel;
	
	cryption() {
		setLayout(null);
		
		encryption_btn = new JButton("��ȣȭ");
		encryption_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.change(panel, new Encryption());
				
			}
		});
		decryption_btn = new JButton("��ȣȭ");
		decryption_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.change(panel, new Decryption());
				
			}
		});
		
		title = new JLabel("���� ���� ġȯ");
		title.setFont(getFont().deriveFont(20.0f));
		
		key_text = new JLabel("����Ű :");
		before_text = new JLabel("�� : ");
		after_text = new JLabel("��ȣ�� : ");
		
		key_str = new JTextField(50);
		before_str = new JTextField(50);
		after_str = new JTextField(50);
	
		table = new JTable(5,5);
		table.setPreferredSize(new Dimension(600, 250));
		for(int i=0; i<5; i++) 
			table.setRowHeight(i, 50);
		table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        
        DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
        // DefaultTableCellHeaderRenderer�� ������ ��� ���ķ� ����
        tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        // ������ ���̺��� ColumnModel�� ������
        TableColumnModel tcmSchedule = table.getColumnModel();
        // �ݺ����� �̿��Ͽ� ���̺��� ��� ���ķ� ����
     	for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
     		tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
     	}
     	table.setDefaultEditor(Object.class, null);
        
        change_btn = new JButton("��ȯ");
        change_btn.setPreferredSize(new Dimension(150, 200));
        
        
        encryption_btn.setBounds(100, 50, 180, 60);
        encryption_btn.setBackground(Color.LIGHT_GRAY);
        
        title.setBounds(370, 50, 100, 50);
        
        decryption_btn.setBounds(520, 50, 180, 60);
        decryption_btn.setBackground(Color.LIGHT_GRAY);
        
        table.setBounds(100,130,600,250);
        
        key_text.setBounds(100,405,100,30);
        key_text.setFont(getFont().deriveFont(15f));
        
        key_str.setBounds(180,400,350,40);
        
        before_text.setBounds(100,465,100,30);
        before_text.setFont(getFont().deriveFont(15f));
        
        before_str.setBounds(180,460,350,40);
        
        after_text.setBounds(100,525,100,30);
        after_text.setFont(getFont().deriveFont(15f));
        
        after_str.setBounds(180,520,350,40);
        
        change_btn.setBounds(570, 400, 130, 160);
        change_btn.setBackground(Color.LIGHT_GRAY);

        add(encryption_btn);
        add(title);
        add(decryption_btn);
        add(table);
        add(key_text);
        add(key_str);
        add(before_text);
        add(before_str);
        add(after_text);
        add(after_str);
        add(change_btn);
	}
	
	String strDecryption(String key, String str, String zCheck) {
		ArrayList<char[]> before = new ArrayList<char[]>(); //�ٲٱ� �� ���ھ�ȣ�� ������ ��
		ArrayList<char[]> after = new ArrayList<char[]>(); //�ٲ� ���� ���ھ�ȣ ������ ��
		int x1 = 0 , x2 = 0 , y1 = 0, y2 = 0; //���� ��ȣ �� ������ ������ ��,�� ��
		String total_str ="";

		int lengthOddFlag = 1;
		
		
		for( int i = 0 ; i < str.length() ; i+=2 )
		{
			char[] tmpArr = new char[2];
			tmpArr[0] = str.charAt(i);
			tmpArr[1] = str.charAt(i+1);
			before.add(tmpArr);
		}
		
		
		for(int i = 0 ; i < before.size() ; i++ )
		{

			char[] tmpArr = new char[2];
			for( int j = 0 ; j < alpha_Board.length ; j++ )
			{
				for( int k = 0 ; k < alpha_Board[j].length ; k++ )
				{
					if(alpha_Board[j][k] == before.get(i)[0])
					{
						x1 = j;
						y1 = k;
					}
					if(alpha_Board[j][k] == before.get(i)[1])
					{
						x2 = j;
						y2 = k;
					}
				}
			}
			
			if(x1==x2) //���� ���� ��� ���� �ٷ� �Ʒ��� ����
			{
				tmpArr[0] = alpha_Board[x1][(y1+4)%5];
				tmpArr[1] = alpha_Board[x2][(y2+4)%5];
			}
			else if(y1==y2) //���� ���� ��� ���� �ٷ� �� �� ����
			{
				tmpArr[0] = alpha_Board[(x1+4)%5][y1];
				tmpArr[1] = alpha_Board[(x2+4)%5][y2];
			}
			else //��, �� �ٸ���� ���� �밢���� �ִ� ��.
			{
				tmpArr[0] = alpha_Board[x2][y1];
				tmpArr[1] = alpha_Board[x1][y2];
			}
			
			after.add(tmpArr);
			
		}
		
		for(int i = 0 ; i < after.size() ; i++) //�ߺ� ���ڿ� ��������
		{
			if(i!=after.size()-1 && after.get(i)[1]=='x' 
					&& after.get(i)[0]==after.get(i+1)[0])
			{	
				total_str += after.get(i)[0];
			}
			else
			{
				total_str += after.get(i)[0]+""+after.get(i)[1];
			}
		}
		
		
		
		for(int i = 0 ; i < zCheck.length() ; i++ )//z��ġ ã�Ƽ� q�� ��������
		{
			if( zCheck.charAt(i) == '1' ) 
				total_str = total_str.substring(0,i)+'z'+total_str.substring(i+1,total_str.length());
		}
		
		if(Flag) total_str = total_str.substring(0,total_str.length()-1);
		
		
		 //����
		for(int i = 0 ; i < total_str.length(); i++)
		{
			if(i%2==lengthOddFlag){
				total_str = total_str.substring(0, i+1)+" "+total_str.substring(i+1, total_str.length());
				i++;
				lengthOddFlag = ++lengthOddFlag%2;
			}
		}
		
		
		return total_str;
	}

	String strEncryption(String key, String str){
		System.out.println("Ű : " + key);
		System.out.println("���� : " + str);
		ArrayList<char[]> before = new ArrayList<char[]>();
		ArrayList<char[]> after = new ArrayList<char[]>();
		int x1 = 0 , x2 = 0 , y1 = 0, y2 = 0;
		String total_str ="";
		
		
		
		for( int i = 0 ; i < str.length() ; i+=2 ) // arraylist ����
		{
			char[] tmpArr = new char[2];
			tmpArr[0] = str.charAt(i);
			try{
				if( str.charAt(i) == str.charAt(i+1)) //���� �ݺ��Ǹ� x�߰�
				{
					tmpArr[1] = 'x';
					i--;
				}else{
					tmpArr[1] = str.charAt(i+1);
				}
			}catch(StringIndexOutOfBoundsException e)
			{
				tmpArr[1] = 'x'; 
				Flag = true;
			}
			before.add(tmpArr);
		}
		
		for(int i = 0 ; i < before.size() ; i++ )
		{
			System.out.print(before.get(i)[0]+""+before.get(i)[1]+" ");
		}
		System.out.println();
		
		for(int i = 0 ; i < before.size() ; i++ )
		{

			char[] tmpArr = new char[2];
			for( int j = 0 ; j < alpha_Board.length ; j++ ) //���ھ�ȣ�� ���� ��ġüũ
			{
				for( int k = 0 ; k < alpha_Board[j].length ; k++ )
				{
					if(alpha_Board[j][k] == before.get(i)[0])
					{
						x1 = j;
						y1 = k;
					}
					if(alpha_Board[j][k] == before.get(i)[1])
					{
						x2 = j;
						y2 = k;
					}
				}
			}
			
			
			if(x1==x2) //���� �������
			{
				tmpArr[0] = alpha_Board[x1][(y1+1)%5];
				tmpArr[1] = alpha_Board[x2][(y2+1)%5];
			}
			else if(y1==y2) //���� ���� ���
			{
				tmpArr[0] = alpha_Board[(x1+1)%5][y1];
				tmpArr[1] = alpha_Board[(x2+1)%5][y2];
			} 
			else //��, �� ��� �ٸ����
			{
				tmpArr[0] = alpha_Board[x2][y1];
				tmpArr[1] = alpha_Board[x1][y2];
			}
			
			after.add(tmpArr);
			
		}
		
		for(int i = 0 ; i < after.size() ; i++)
		{
			total_str += after.get(i)[0]+""+after.get(i)[1]+" ";
		}
		
		
		return total_str;
	}

	void setBoard(String key) {
		String keySet = "";					// �ߺ��� ���ڰ� ���ŵ� ���ڿ��� ������ ���ڿ�.
		boolean dFlag = false;		// ���� �ߺ��� üũ�ϱ� ���� flag ����.
		int key_Length = 0;					// alphabetBoard�� keyForSet�� �ֱ� ���� count����.
		
		key += "abcdefghijklmnopqrstuvwxyz"; 	// Ű�� ��� ���ĺ��� �߰�.

		
		// �ߺ�ó��
		for( int i = 0 ; i < key.length() ; i++ ) 
		{
			for( int j = 0 ; j < keySet.length() ; j++ )
			{
				if(key.charAt(i)==keySet.charAt(j))
				{
					dFlag = true;
					break;
				}
			}
			if(!(dFlag)) keySet += key.charAt(i);
			dFlag = false;
		}
		//�迭�� ����
		for( int i = 0 ; i < alpha_Board.length ; i++ )
		{
			for( int j = 0; j <alpha_Board[i].length ; j++ )
			{
				alpha_Board[i][j] = keySet.charAt(key_Length++);
			}
		}		
		//�迭�� ����
		for( int i = 0 ; i < alpha_Board.length ; i++ )
		{
			for( int j = 0; j <alpha_Board[i].length ; j++ )
			{
				System.out.print(alpha_Board[i][j]+"-");
				table.setValueAt(alpha_Board[i][j], i, j);
			}
			System.out.println();
		}
						
		
	}
}
