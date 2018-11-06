package calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.ScriptEngine;

public class Gui extends JFrame{
	JTextField txt;
	
	public Gui() {
		super("It's Calculator");
		setSize(300,270);
		JPanel content = (JPanel) getContentPane();
		content.setLayout(new FlowLayout());
		
		JPanel p = new JPanel();
		this.txt = new JTextField(18);
		txt.setText("None");
		txt.setFont(new Font("돋움", Font.PLAIN, 20));
		txt.setBackground(Color.WHITE);
		txt.setEditable(false);
		p.add(txt);
		content.add(p);

		JButton btn1 = new JButton("1");
		btn1.addActionListener(new CalcAction());
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new CalcAction());
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new CalcAction());
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new CalcAction());
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new CalcAction());
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new CalcAction());
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new CalcAction());
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new CalcAction());
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new CalcAction());
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new CalcAction());
		JButton plusbtn = new JButton("+");
		plusbtn.addActionListener(new CalcAction());
		JButton minusbtn = new JButton("-");
		minusbtn.addActionListener(new CalcAction());
		JButton mulbtn = new JButton("*");
		mulbtn.addActionListener(new CalcAction());
		JButton divbtn = new JButton("/");
		divbtn.addActionListener(new CalcAction());
		JButton equalbtn = new JButton("=");
		equalbtn.addActionListener(new ResultAction());
		JButton cancelbtn = new JButton("C");
		cancelbtn.addActionListener(new CancelAction());
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(4,5,15,15));
		p2.add(btn1);
		p2.add(btn2);
		p2.add(btn3);
		p2.add(plusbtn);
		p2.add(btn4);
		p2.add(btn5);
		p2.add(btn6);
		p2.add(minusbtn);
		p2.add(btn7);
		p2.add(btn8);
		p2.add(btn9);
		p2.add(mulbtn);
		p2.add(cancelbtn);
		p2.add(btn0);
		p2.add(equalbtn);
		p2.add(divbtn);

		content.add(p2);
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//숫자 및 연산자 입력 액션
	private class CalcAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(txt.getText().equals("None"))
				txt.setText("");
			JButton source = (JButton) e.getSource();
			txt.setText(txt.getText() + source.getActionCommand());
		}
	}
	// 취소 액션
	private class CancelAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {	
			txt.setText("None");
		}
	}
	
	// 계산 액션
		private class ResultAction implements ActionListener {
			public void actionPerformed(ActionEvent e) {	
				ScriptEngineManager mgr = new ScriptEngineManager();
			    ScriptEngine engine = mgr.getEngineByName("JavaScript");
			    String foo = txt.getText();
			    try {
					txt.setText(engine.eval(foo).toString());
			    	System.out.println(engine.eval(foo));
				} catch (ScriptException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
}
