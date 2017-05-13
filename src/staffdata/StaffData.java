package staffdata;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StaffData extends JFrame implements WindowListener {
    StaffData(){
        System.out.println("Hello");
        setLayout(null);
        System.out.println("hey");
        JButton addb,updtb,viewb,deleteb;
        addb=new JButton("ADD DETAILS");
        updtb=new JButton("UPDATE DETAILS");
        viewb=new JButton("VIEW DETAILS");
        deleteb=new JButton("DELETE DETAILS");
        addb.setBounds(50,20,150,30);
        updtb.setBounds(50,70,150,30);
        viewb.setBounds(50, 120, 150, 30);
        deleteb.setBounds(50, 170, 150, 30);
        this.add(addb);
        System.out.println("Whatsup");
        System.out.println("Nothing Much");
        this.add(updtb);
        this.add(viewb);
        this.add(deleteb);
        addb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                disposeWin();
                new AddData();
            }
        });
        updtb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                disposeWin();
                new UpdateData();
            }
        
        });
        viewb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                disposeWin();
                new ViewData();
            }
        
        });
        deleteb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                disposeWin();
                new DeleteData();
            }
        
        });
        setSize(280,280);
        setLocation(700,350);
        setTitle("STAFF INFO");
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this);
    }
    void disposeWin(){
        this.dispose();
    }
    @Override
    public void windowOpened(WindowEvent e) {}
    @Override
    public void windowClosing(WindowEvent e) {
        int op=JOptionPane.showConfirmDialog(null, "WANT TO EXIT THE DETAILS WINDOW?", "EXIT WIZARD", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(op==JOptionPane.YES_OPTION)
            setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void windowClosed(WindowEvent e) {}
    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {}

    public static void main(String[] args) {
        new StaffData();
    }
}


class AddData extends JFrame implements WindowListener{
    AddData(){
        JTextField tid,tname,tdob,tdoj,tsal,tno;
         JLabel lid,lname,ldob,ldoj,lsal,lno,dformat,dformatcopy,lgen;
           JButton sub;
           JPanel jp;
        JRadioButton rbm,rbf;
        
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Session s=sf.openSession();
        System.out.println("SESSION OPENED SUCCESSFULLY");
        
        setLayout(null);
        setTitle("DETAILS");
        tid=new JTextField();
        tname=new JTextField();
        tdob=new JTextField();
        tdoj=new JTextField();
        tsal=new JTextField();
        tno=new JTextField();
        lid=new JLabel("ID NUMBER");
        lname=new JLabel("NAME");
        ldob=new JLabel("DATE OF BIRTH");
        ldoj=new JLabel("DATE OF JOINING");
        lsal=new JLabel("SALARY");
        lno=new JLabel("CONTACT NUMBER");
        lgen=new JLabel("GENDER");
        sub=new JButton("SUBMIT");
        dformat=new JLabel("DD/MM/YYYY");
        dformatcopy=new JLabel("DD/MM/YYYY");
        rbm=new JRadioButton("MALE");
        rbf=new JRadioButton("FEMALE");
        jp=new JPanel();
        lid.setBounds(10, 10, 150, 30);
        lname.setBounds(10, 60, 150, 30);
        lgen.setBounds(10,110,150,30);
        ldob.setBounds(10, 160, 150, 30);
        ldoj.setBounds(10, 210, 150, 30);
        lsal.setBounds(10, 260, 150, 30);
        lno.setBounds(10, 310, 150, 30);
        tid.setBounds(190, 10, 150, 30);
        jp.setBounds(185,105,160,80);
        tname.setBounds(190, 60, 150, 30);
        rbm.setBounds(190, 110, 90, 30);
        rbf.setBounds(300, 110, 90, 30);
        tdob.setBounds(190, 160, 150, 30);
        dformat.setBounds(360, 160, 120, 30);
        tdoj.setBounds(190, 210, 150, 30);
        dformatcopy.setBounds(360, 210, 150, 30);
        tsal.setBounds(190, 260, 150, 30);
        tno.setBounds(190, 310, 150, 30);
        sub.setBounds(140, 360, 90, 30);
        dformat.setForeground(Color.red);
        dformatcopy.setForeground(Color.red);
        
        ButtonGroup group = new ButtonGroup();
        group.add(rbm);
        group.add(rbf);
        rbm.setActionCommand("MALE");
        rbf.setActionCommand("FEMALE");
        
        this.add(lid);
        this.add(lname);
        this.add(ldob);
        this.add(ldoj);
        this.add(lsal);
        this.add(lno);
        this.add(tid);
        this.add(tname);
        this.add(tdob);
        this.add(tdoj);
        this.add(tsal);
        this.add(tno);
        this.add(sub);
        this.add(dformat);
        this.add(dformatcopy);
        jp.add(rbm);
        jp.add(rbf);
        this.add(jp);
        this.add(lgen);
        tid.setEditable(false);
        tid.setText("AUTO GENERATE");
        
        sub.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Info i=new Info();
                int dd=i.getId();
               // i.setId(Integer.parseInt(tid.getText()));
                i.setName(tname.getText().toUpperCase(Locale.ROOT));
                String gen=group.getSelection().getActionCommand();
                i.setGender(gen);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date=null;
                
             try{
                 date = formatter.parse(tdob.getText());
                
              //    System.out.println(formatter.format(date));  
               }
               catch(ParseException ex){
                      JOptionPane.showMessageDialog(null, ex);
                   }
                i.setDob(date);
             try{
                 date=formatter.parse(tdoj.getText());
             }
             catch(ParseException ex){
                 JOptionPane.showMessageDialog(null, ex);
                 
                }
             i.setDoj(date);
             i.setSal(Integer.parseInt(tsal.getText()));
             i.setNo(tno.getText());
             int op=JOptionPane.showConfirmDialog(null, "SHALL THE DATA BE ADDED TO DATABASE AS ENTERED", "CONFIRMATION", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                 if(op==JOptionPane.YES_OPTION){
                         s.save(i);
                         Transaction t=s.beginTransaction();
                         t.commit();
                        disposeWin();
                        JOptionPane.showMessageDialog(null, "DATA ADDED TO DATABASE WITH STAFF ID : "+i.getId());
                         new StaffData();
                         s.close();
                         sf.close();
                 }
            }
       });
        setSize(500,450);
        setLocation(650,350);
        setVisible(true);
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this);
        
        
    }
    void disposeWin(){
        this.dispose();
        
    }
    @Override
    public void windowOpened(WindowEvent e) {}
    @Override
    public void windowClosing(WindowEvent e) {
        int op=JOptionPane.showConfirmDialog(null, "WANT TO EXIT THE DETAILS WINDOW?", "EXIT WIZARD", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(op==JOptionPane.YES_OPTION)
            setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void windowClosed(WindowEvent e) {}
    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {}
}

class UpdateData extends JFrame implements WindowListener{
    
    UpdateData(){
        
       Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Session s=sf.openSession();
        System.out.println("SESSION OPENED SUCCESSFULLY");
        int enid=Integer.parseInt(JOptionPane.showInputDialog(null, "ENTER THE ID FOR STAFF PLEASE", "UPDATE", JOptionPane.INFORMATION_MESSAGE));
       
        Object o=s.get(Info.class,enid);
        Info i=(Info) o;
        int did=i.getId();
        
        JTextField tid,tname,tdob,tdoj,tsal,tno,tgen;
        JLabel lid,lname,ldob,ldoj,lsal,lno,dformat,dformatcopy,lgen;
        JButton sub;
        
        setLayout(null);
        setTitle("UPDATE");
        tid=new JTextField();
        tname=new JTextField();
        tdob=new JTextField();
        tdoj=new JTextField();
        tsal=new JTextField();
        tgen=new JTextField();
        tno=new JTextField();
        lid=new JLabel("ID NUMBER");
        lname=new JLabel("NAME");
        ldob=new JLabel("DATE OF BIRTH");
        ldoj=new JLabel("DATE OF JOINING");
        lsal=new JLabel("SALARY");
        lno=new JLabel("CONTACT NUMBER");
        lgen=new JLabel("GENDER");
        sub=new JButton("DONE");
        dformat=new JLabel("DD/MM/YYYY");
        dformatcopy=new JLabel("DD/MM/YYYY");
        lid.setBounds(10, 10, 150, 30);
        lname.setBounds(10, 60, 150, 30);
        lgen.setBounds(10,110,150,30);
        ldob.setBounds(10, 160, 150, 30);
        ldoj.setBounds(10, 210, 150, 30);
        lsal.setBounds(10, 260, 150, 30);
        lno.setBounds(10, 310, 150, 30);
        tid.setBounds(190, 10, 150, 30);
        tname.setBounds(190, 60, 150, 30);
        tgen.setBounds(190, 110, 150, 30);
        tdob.setBounds(190, 160, 150, 30);
        dformat.setBounds(360, 160, 120, 30);
        tdoj.setBounds(190, 210, 150, 30);
        dformatcopy.setBounds(360, 210, 150, 30);
        tsal.setBounds(190, 260, 150, 30);
        tno.setBounds(190, 310, 150, 30);
        sub.setBounds(140, 360, 90, 30);
        dformat.setForeground(Color.red);
        dformatcopy.setForeground(Color.red);
        this.add(lname);
        this.add(lgen);
        this.add(ldob);
        this.add(ldoj);
        this.add(lsal);
        this.add(lno);
        this.add(tid);
        this.add(tname);
        this.add(tgen);
        this.add(tdob);
        this.add(tdoj);
        this.add(tsal);
        this.add(tno);
        this.add(sub);
        this.add(dformat);
        this.add(dformatcopy);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        tid.setText(Integer.toString(i.getId()));
                    tname.setText(i.getName());
                    tgen.setText(i.getGender());
                    tdob.setText(formatter.format(i.getDob()));
                    tdoj.setText(formatter.format(i.getDoj()));
                    tsal.setText(Integer.toString(i.getSal()));
                    tno.setText(i.getNo());
        sub.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    
                i.setId(Integer.parseInt(tid.getText()));
                i.setName(tname.getText().toUpperCase(Locale.ROOT));
                i.setGender(tgen.getText());
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date=null;
                
             try{
                 date = formatter.parse(tdob.getText());
                
              //    System.out.println(formatter.format(date));  
               }
               catch(ParseException ex){
                      JOptionPane.showMessageDialog(null, ex);
                   }
                i.setDob(date);
             try{
                 date=formatter.parse(tdoj.getText());
             }
             catch(ParseException ex){
                 JOptionPane.showMessageDialog(null, ex);
                }
             i.setDoj(date);
             i.setSal(Integer.parseInt(tsal.getText()));
             i.setNo(tno.getText());
            int op=JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO UPDATE STAFF ID :"+did+" WITH THE CURRENT DATA?", "CONFIRMATION", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                 if(op==JOptionPane.YES_OPTION){
                         s.update(i);
                         Transaction t=s.beginTransaction();
                         t.commit();
                         s.close();
                         sf.close();
                         disposeWin();
                         JOptionPane.showMessageDialog(null, "DATA UPDATED IN DATABASE");
                         new StaffData();
                    }
            
            
            
            
            }
       });
        setSize(500,450);
        setLocation(650,350);
        setVisible(true);
        JOptionPane.showMessageDialog(null, "PLEASE EDIT ALL THE REQUIRED VALUES ACCORDING TO NEW DATA AND PRESS THE BUTTON");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this);
    }
    
    void disposeWin(){
        this.dispose();
        //JTable jt=new JTable();
    }
    @Override
    public void windowOpened(WindowEvent e) {}
    @Override
    public void windowClosing(WindowEvent e) {
        int op=JOptionPane.showConfirmDialog(null, "WANT TO EXIT THE DETAILS WINDOW?", "EXIT WIZARD", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(op==JOptionPane.YES_OPTION)
            setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void windowClosed(WindowEvent e) {}
    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {}
}

class ViewData extends JFrame implements WindowListener{
    ViewData(){
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Session s=sf.openSession();
        System.out.println("SESSION OPENED SUCCESSFULLY");
        int enid=Integer.parseInt(JOptionPane.showInputDialog(null, "ENTER THE ID FOR STAFF PLEASE", "UPDATE", JOptionPane.INFORMATION_MESSAGE));
       
        Object o=s.get(Info.class,enid);
        Info i=(Info) o;
        int did=i.getId();
        
        JTextField tid,tname,tdob,tdoj,tsal,tno,tgen;
        JLabel lid,lname,ldob,ldoj,lsal,lno,dformat,dformatcopy,lgen;
        JButton sub;
        
        setLayout(null);
        setTitle("VIEW");
        tid=new JTextField();
        tname=new JTextField();
        tdob=new JTextField();
        tdoj=new JTextField();
        tsal=new JTextField();
        tgen=new JTextField();
        tno=new JTextField();
        lid=new JLabel("ID NUMBER");
        lname=new JLabel("NAME");
        ldob=new JLabel("DATE OF BIRTH");
        ldoj=new JLabel("DATE OF JOINING");
        lsal=new JLabel("SALARY");
        lno=new JLabel("CONTACT NUMBER");
        lgen=new JLabel("GENDER");
        sub=new JButton("DONE");
        dformat=new JLabel("DD/MM/YYYY");
        dformatcopy=new JLabel("DD/MM/YYYY");
        lid.setBounds(10, 10, 150, 30);
        lname.setBounds(10, 60, 150, 30);
        lgen.setBounds(10,110,150,30);
        ldob.setBounds(10, 160, 150, 30);
        ldoj.setBounds(10, 210, 150, 30);
        lsal.setBounds(10, 260, 150, 30);
        lno.setBounds(10, 310, 150, 30);
        tid.setBounds(190, 10, 150, 30);
        tname.setBounds(190, 60, 150, 30);
        tgen.setBounds(190, 110, 150, 30);
        tdob.setBounds(190, 160, 150, 30);
        dformat.setBounds(360, 160, 120, 30);
        tdoj.setBounds(190, 210, 150, 30);
        dformatcopy.setBounds(360, 210, 150, 30);
        tsal.setBounds(190, 260, 150, 30);
        tno.setBounds(190, 310, 150, 30);
        sub.setBounds(140, 360, 90, 30);
        dformat.setForeground(Color.red);
        dformatcopy.setForeground(Color.red);
        tname.setEditable(false);
        tid.setEditable(false);
        tgen.setEditable(false);
        tdob.setEditable(false);
        tdoj.setEditable(false);
        tsal.setEditable(false);
        tno.setEditable(false);
        this.add(lid);
        this.add(lname);
        this.add(lgen);
        this.add(ldob);
        this.add(ldoj);
        this.add(lsal);
        this.add(lno);
        this.add(tid);
        this.add(tname);
        this.add(tgen);
        this.add(tdob);
        this.add(tdoj);
        this.add(tsal);
        this.add(tno);
        this.add(sub);
        this.add(dformat);
        this.add(dformatcopy);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        tid.setText(Integer.toString(i.getId()));
                    tname.setText(i.getName());
                    tgen.setText(i.getGender());
                    tdob.setText(formatter.format(i.getDob()));
                    tdoj.setText(formatter.format(i.getDoj()));
                    tsal.setText(Integer.toString(i.getSal()));
                    tno.setText(i.getNo());
                    
                    
        sub.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    disposeWin();
                    new StaffData();
            }
       });
        setSize(500,450);
        setLocation(650,350);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this);
    }
    
    void disposeWin(){
        this.dispose();
        
    }
    @Override
    public void windowOpened(WindowEvent e) {}
    @Override
    public void windowClosing(WindowEvent e) {
        int op=JOptionPane.showConfirmDialog(null, "WANT TO EXIT THE DETAILS WINDOW?", "EXIT WIZARD", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(op==JOptionPane.YES_OPTION)
            setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void windowClosed(WindowEvent e) {}
    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {}
}

class DeleteData{
    
    DeleteData(){
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Session s=sf.openSession();
        System.out.println("SESSION OPENED SUCCESSFULLY");
        int enid=Integer.parseInt(JOptionPane.showInputDialog(null, "ENTER THE ID FOR STAFF PLEASE", "UPDATE", JOptionPane.INFORMATION_MESSAGE));
       
        Object o=s.get(Info.class,enid);
        Info i=(Info) o;
        int did=i.getId();
        int op=JOptionPane.showConfirmDialog(null, "ARE YOU SURE YOU WANT TO DELETE THE RECORD?", "DELTE", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(op==JOptionPane.YES_OPTION){
            s.delete(i);
            Transaction t = s.beginTransaction();
            t.commit();
            s.close();
           sf.close();
            JOptionPane.showMessageDialog(null, "DELETED FOR STAFF ID : "+did);
            new StaffData();
    }   
    }
}