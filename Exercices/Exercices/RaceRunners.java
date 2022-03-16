import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class FinishEvent
{
  private Object source;
  public FinishEvent(Object source) { this.source = source; }
  public Object getSource() { return source; }
}

interface FinishListener
{
  void action(FinishEvent e);
}

class Runner
{
  private static Random random = new Random();
  private static int count = 0;

  private int number = count++;
  private double position = 0;

  private FinishListener finishListener;

  public int number() { return number; }
  public double position() { return Math.min(100.0, position); }

  public void addFinishListener(FinishListener l) {
    // only one listener at a time...
    finishListener = l;
  }

  public void turn()
  {
    if (position < 100)
    {
      position += random.nextDouble() * 2.0;
      if (position >= 100)
        if (finishListener != null)
          finishListener.action(new FinishEvent(this));
    }
  }
}  
  
class JRace extends JPanel implements ActionListener
{
  private static Color[] colors = { Color.RED, Color.GREEN, Color.BLUE, 
                                    Color.BLACK, Color.MAGENTA };
  private Runner runners[] = new Runner[10];
  private boolean stop;
  private Timer timer;

  JRace() 
  {
    setBackground(Color.WHITE);
  }

  public Dimension getPreferredSize() 
  { 
    return new Dimension(320, 210); 
  }

  public void actionPerformed(ActionEvent e)
  {
    for (int i = 0; i < runners.length; i++)
      runners[i].turn();
    repaint();
    if (stop) timer.stop();
  }

  public void run()
  {
    stop = false;
    timer = new Timer(40, this);
    timer.start();

    for (int i = 0; i < runners.length; i++)
    {
      runners[i] = new Runner();
      runners[i].addFinishListener(new FinishListener() {
          public void action(FinishEvent e) {
            stop = true;
            System.out.println("Racer " + ((Runner) e.getSource()).number());
          }});
    }
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    for (int i = 0; i < runners.length; i++) 
      if (runners[i] != null)
      {
        g.setColor(colors[i % colors.length]);
        g.fillRect(10, 10 + i * 20, 
                   (int) runners[i].position() * 300 / 100, 10);
      }
  }
}

public class RaceRunners
{
  public static void main(String[] args)
  {
    final JRace race = new JRace();
    JFrame frame = new JFrame("Race");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(race);

    JPanel panel = new JPanel();
    frame.getContentPane().add(panel, BorderLayout.SOUTH);
    
    JButton run = new JButton("Run");
    panel.add(run);

    frame.pack();
    frame.setVisible(true);

    run.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          race.run();
        }});

  }
}
 
