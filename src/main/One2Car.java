
package main;

public class One2Car {
    public static void main(String[] args) {
           java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
   
    }
    
}
