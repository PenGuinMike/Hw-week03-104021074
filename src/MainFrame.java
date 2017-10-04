import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private Container cp;
    private JButton btn1 = new JButton("範例");
    private JButton btn2 = new JButton("加密");
    private JButton btn3 = new JButton("清除");
    private JButton btn5 = new JButton("解密");
    private JButton btn4 = new JButton("離開");
    private JLabel jlb = new JLabel("Key");
    private JPanel jpn1 = new JPanel(new GridLayout(7,1,0,2));
    private JTextArea jtaL = new JTextArea();
    private JTextArea jtaR = new JTextArea();
    private JScrollPane jpnL = new JScrollPane(jtaL);
    private JScrollPane jpnR = new JScrollPane(jtaR);
    private JTextField jtf = new JTextField("csie");
    public MainFrame(){
        init();
    }
    private void init(){
        this.setBounds(800,200,720,720);
        cp=this.getContentPane();cp.setLayout(new BorderLayout(3,1));
//        btnAdd.setSize(75,20);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jlb.setHorizontalAlignment(JLabel.CENTER);
        jpn1.add(btn1);
        jpn1.add(btn2);
        jpn1.add(jlb);
        jpn1.add(jtf);
        jpn1.add(btn3);
        jpn1.add(btn5);
        jpn1.add(btn4);
        cp.add(jpn1,BorderLayout.CENTER);
        cp.add(jpnL,BorderLayout.WEST);
        cp.add(jpnR,BorderLayout.EAST);
        jpnL.setPreferredSize(new Dimension(300,200));
        jpnR.setPreferredSize(new Dimension(300,200));
        jtaL.setLineWrap(true);
        jtaR.setLineWrap(true);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaL.setText("Paddock opened fire from the Mandalay Bay Hotel and Casino on Sunday night, killing at least 59 people and wounding more than 500 others, before turning the gun on himself as police closed in, said officials.\n" +
                        "Sixteen weapons were found in the 32nd-floor hotel room that Paddock checked into last Thursday, Las Vegas Sheriff Joseph Lombardo told reporters.\n" +
                        "A further 18 firearms and thousands of rounds of ammunition were found in his Mesquite home, while explosives were found in the property and car.\n" +
                        "Sheriff Lombardo also said officers found \"some electronic devices\" in the house, which sits in a quiet retirement community.\n" +
                        "David Famiglietti of the New Frontier Armory told the BBC that Paddock had purchased firearms at his store in North Las Vegas in the spring of this year, meeting all state and federal requirements, including an FBI background check.\n" +
                        "However, the shotgun and rifle Paddock bought would not have been \"capable of what we've seen and heard in the video without modification,\" Mr Famiglietti said.");
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                int key = Integer.parseInt();
                char data0 [] = jtf.getText().toCharArray();
                int data0len = data0.length;
                int keysum =0;
                for(int i=0;i<data0len;i++){
                    keysum+=data0[i];
                }
//                System.out.print(Integer.toBinaryString(keysum));

                char data1 [] = jtaL.getText().toCharArray();

                int lenthC = data1.length;
                for(int i=0;i<lenthC;i++){
                    data1[i]^=keysum;
                }
//                int x=101;
//                int z=3;
//                int y=Integer.parseInt(Integer.toBinaryString(x),2);
//                System.out.print(Integer.toBinaryString(x^z));
//                System.out.print(z>>2);
                String str = new String(data1);
                jtaR.setText(str);
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaR.setText("");
                jtaL.setText("");
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp1=jtaL.getText();
                String temp2=jtaR.getText();
                jtaL.setText(temp2);
                jtaR.setText(temp1);
                //jtaR///jtaL
            }
        });
    }
}
