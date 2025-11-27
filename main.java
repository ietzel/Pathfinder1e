import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PongGame extends JPanel implements KeyListener {
    private int ballX = 250;
    private int ballY = 250;
    private int ballXSpeed = 2;
    private int ballYSpeed = 2;
    private int paddle1Y = 200;
    private int paddle2Y = 200;
    private int player1Score = 0;
    private int player2Score = 0;
    private boolean upPressed1 = false;
    private boolean downPressed1 = false;
    private boolean upPressed2 = false;
    private boolean downPressed2 = false;

    public PongGame() {
    JFrame frame = new JFrame("Pong Game");
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(this);
    frame.setVisible(true);
    frame.addKeyListener(this);
    setFocusable(true);
    }

public void paint(Graphics g) {
    super.paint(g);
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, 500, 500);
    g.setColor(Color.WHITE);
    g.fillRect(0, paddle1Y, 10, 100);
    g.fillRect(490, paddle2Y, 10, 100);
    g.fillOval(ballX, ballY, 10, 10);
    g.drawString("Player 1: " + player1Score, 50, 50);
    g.drawString("Player 2: " + player2Score, 400, 50);
}

public void moveBall() {
    ballX += ballXSpeed;
    ballY += ballYSpeed;
    if (ballY < 0 || ballY > 490) {
        ballYSpeed = -ballYSpeed;
    }
    if (ballX < 10) {
        if (ballY > paddle1Y && ballY < paddle1Y + 100) {
            ballXSpeed = -ballXSpeed;
        } else {
            player2Score++;
            ballX = 250;
            ballY = 250;
        }
    }
    if (ballX > 480) {
        if (ballY > paddle2Y && ballY < paddle2Y + 100) {
            ballXSpeed = -ballXSpeed;
        } else {
            player1Score++;
            ballX = 250;
            ballY = 250;
        }
    }
}

public void movePaddles() {
    if (upPressed1) {
        paddle1Y -= 5;
    }
    if (downPressed1) {
        paddle1Y += 5;
    }
    if (upPressed2) {
        paddle2Y -= 5;
    }
    if (downPressed2) {
        paddle2Y += 5;
    }
    if (paddle1Y < 0) {
        paddle1Y = 0;
    }
    if (paddle1Y > 400) {
        paddle1Y = 400;
    }
    if (paddle2Y < 0) {
        paddle2Y = 0;
    }
    if (paddle2Y > 400) {
        paddle2Y = 400;
    }
}

public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP) {
        upPressed2 = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        downPressed2 = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_W) {
        upPressed1 = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_S) {
        downPressed1 = true;
    }
}

public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP) {
        upPressed2 = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        downPressed2 = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_W) {
        upPressed1 = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_S) {
        downPressed1 = false;
    }
}

public void keyTyped(KeyEvent e) {
}

public static void main(String[] args) {
    PongGame game = new PongGame();
    while (true) {
        game.moveBall();
        game.movePaddles();
        game.repaint();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

}
