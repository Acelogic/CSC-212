//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package npw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import math.Predicates;
import painter.SPainter;
import painter.SPainterADT;
import shapes.SCircle;
import shapes.SPolygon;
import shapes.SRectangle;
import shapes.SSquare;
import utilities.Random;

public class JFramelessPainter extends JPanel implements SPainterADT {
    Double center;
    public Double location = new Double(0.0D, 0.0D);
    String direction = "north";
    public Color color;
    public int brushWidth;
    BufferedImage image;
    Graphics2D gir;
    public int painterHeight;
    public int painterWidth;
    Stack<JFramelessPainter.State> state;
    Container container;
    public JFrame theFrame;
    private Color savedColor;
    Point2D pointSave;
    public double heading;

    public Double getPosition() {
        return new Double(this.location.x, this.location.y);
    }

    public Point spot() {
        return new Point((int)this.location.x, (int)this.location.y);
    }

    public void setPosition(Double p) {
        this.location.setLocation(p.getX(), p.getY());
    }

    public JFramelessPainter(Container c) {
        this.color = Color.black;
        this.brushWidth = 4;
        this.image = null;
        this.gir = null;
        this.state = new Stack();
        this.heading = 0.0D;
        this.container = c;
        this.painterHeight = c.getHeight();
        this.painterWidth = c.getWidth();
        this.setSize(c.getWidth(), c.getHeight());
        c.add(this);
        this.initializeImage2();
    }

    public JFramelessPainter(SPainter f){
        this.color = f.color;
        this.brushWidth = f.brushWidth;
        this.image = f.image();
        this.gir = null;
        this.state = new Stack();
        this.heading = 0.0D;
        this.painterHeight = f.getHeight();
        this.painterWidth = f.getWidth();
        this.setSize(f.getWidth(), f.getHeight());
        f.add(this);
        this.initializeImage2();

    }

    public int canvasHeight() {
        System.out.println("height = " + this.painterHeight);
        return this.painterHeight;
    }

    public int canvasWidth() {
        return this.painterWidth;
    }

    public void redo(Color cc, int h, int w) {
        this.setBackground(Color.red);
        this.container.setBounds(500, 500, 500, 500);
        this.setSize(500, 500);
        this.theFrame.setSize(500, 500);
        this.painterWidth = 500;
        this.painterHeight = 500;
        this.initializeImage();
    }

    public void setVisible(boolean v) {
        this.theFrame.setVisible(v);
    }

    public BufferedImage image() {
        return this.image;
    }

    public JFramelessPainter(String t, int w, int h) {
        this.color = Color.black;
        this.brushWidth = 4;
        this.image = null;
        this.gir = null;
        this.state = new Stack();
        this.heading = 0.0D;
        JFrame jf = new JFrame(t);
        this.theFrame = jf;
        jf.setSize(w, h + 22);
        jf.setVisible(true);
        jf.setAlwaysOnTop(true);
        jf.setDefaultCloseOperation(3);
        Container c = jf.getContentPane();
        this.container = c;
        this.painterHeight = c.getHeight();
        this.painterWidth = c.getWidth();
        this.setSize(c.getWidth(), c.getHeight());
        c.add(this);
        this.initializeImage();
    }

    public JFramelessPainter(String t, int h, int w, String spec) {
        this.color = Color.black;
        this.brushWidth = 4;
        this.image = null;
        this.gir = null;
        this.state = new Stack();
        this.heading = 0.0D;
        JFrame jf = new JFrame(t);
        this.theFrame = jf;
        spec = spec.toUpperCase();
        if (spec.indexOf("S") >= 0) {
            this.theFrame.setUndecorated(true);
            this.theFrame.getRootPane().setWindowDecorationStyle(0);
        } else {
            this.theFrame.setDefaultCloseOperation(3);
        }

        jf.setSize(h, w + 22);
        jf.setVisible(true);
        jf.setAlwaysOnTop(true);
        Container c = jf.getContentPane();
        this.container = c;
        this.painterHeight = c.getHeight();
        this.painterWidth = c.getWidth();
        this.setSize(c.getWidth(), c.getHeight());
        c.add(this);
        this.initializeImage();
        if (spec.indexOf("F") >= 0) {
            this.paintFrame(Color.black, 6);
            this.centerOfScreen();
        }

    }

    public JFramelessPainter(int w, int h) {
        this.color = Color.black;
        this.brushWidth = 4;
        this.image = null;
        this.gir = null;
        this.state = new Stack();
        this.heading = 0.0D;
        JFrame jf = new JFrame("");
        this.theFrame = jf;
        this.theFrame.setUndecorated(true);
        this.theFrame.getRootPane().setWindowDecorationStyle(0);
        jf.setSize(w, h);
        jf.setVisible(true);
        jf.setAlwaysOnTop(true);
        Container c = jf.getContentPane();
        this.container = c;
        this.painterHeight = c.getHeight();
        this.painterWidth = c.getWidth();
        this.setSize(c.getWidth(), c.getHeight());
        c.add(this);
        this.initializeImage();
        this.paintFrame(Color.black, 6);
        this.setBrushWidth(1);
        this.centerOfScreen();
    }

    public void pause() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException var2) {
            Logger.getLogger(JFramelessPainter.class.getName()).log(Level.SEVERE, (String)null, var2);
        }

    }

    public void pause(int ms) {
        try {
            Thread.sleep((long)ms);
        } catch (InterruptedException var3) {
            Logger.getLogger(JFramelessPainter.class.getName()).log(Level.SEVERE, (String)null, var3);
        }

    }

    public void initializeImage() {
        this.establishCenterPoint();
        this.establishImage();
        this.centerOfScreen();
        this.wash();
    }

    public void otherInitializeImage() {
        this.establishCenterPoint();
        this.establishImage();
        this.wash();
    }

    public void centerOfScreen() {
        this.theFrame.setLocationRelativeTo((Component)null);
    }

    public void toFront() {
        this.theFrame.toFront();
    }

    void establishCenterPoint() {
        int w = this.getWidth();
        int h = this.getHeight();
        int xCenter = (int)((double)w / 2.0D);
        int yCenter = (int)((double)h / 2.0D);
        this.center = new Double((double)xCenter, (double)yCenter);
        this.location = new Double((double)xCenter, (double)yCenter);
    }

    void establishImage() {
        int w = this.painterWidth;
        int h = this.painterHeight;
        this.image = new BufferedImage(w, h, 1);
        this.gir = this.image.createGraphics();
    }

    public void finish() {
        Container c = this.theFrame.getContentPane();
        c.add(this);
        this.initializeImage();
    }

    public JFramelessPainter(boolean visible, String t, int h, int w) {
        this.color = Color.black;
        this.brushWidth = 4;
        this.image = null;
        this.gir = null;
        this.state = new Stack();
        this.heading = 0.0D;
        System.out.println("POINT 1 ");
        JFrame jf = new JFrame(t);
        this.theFrame = jf;
        jf.setSize(h, w + 22);
        jf.setVisible(true);
        jf.setAlwaysOnTop(true);
        jf.setDefaultCloseOperation(3);
        Container c = jf.getContentPane();
        this.container = c;
        this.painterHeight = c.getHeight();
        this.painterWidth = c.getWidth();
        this.setSize(c.getWidth(), c.getHeight());
        c.add(this);
        this.initializeImage();
        if (!visible) {
            jf.setVisible(false);
        }

        System.out.println("made it through the constructor ...");
    }

    public void fitToScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.theFrame.setSize(screenSize.width, screenSize.height);
    }

    public JFramelessPainter(String t, int h, int w, int x, int y) {
        this.color = Color.black;
        this.brushWidth = 4;
        this.image = null;
        this.gir = null;
        this.state = new Stack();
        this.heading = 0.0D;
        JFrame jf = new JFrame(t);
        this.theFrame = jf;
        jf.setSize(h + 22, w);
        jf.setLocation(x, y);
        jf.setVisible(true);
        Container c = jf.getContentPane();
        this.container = c;
        this.painterHeight = c.getHeight();
        this.painterWidth = c.getWidth();
        this.setSize(c.getWidth(), c.getHeight());
        c.add(this);
        this.otherInitializeImage();
        System.out.println("x,y=" + x + "," + y);
        this.setScreenLocation(x, y);
    }

    public void end() {
        this.theFrame.dispose();
    }

    public void update(Graphics g) {
        this.paint((Graphics)g);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        if (this.image == null) {
            this.initializeImage();
        }

        g2.drawImage(this.image, 0, 0, this);
    }

    public void initializeImage2() {
        this.establishCenterPoint();
        this.establishImage();
    }

    public java.awt.geom.Rectangle2D.Double getBoundingRectangle() {
        return new java.awt.geom.Rectangle2D.Double(0.0D, 0.0D, (double)this.painterWidth, (double)this.painterHeight);
    }

    public java.awt.geom.Rectangle2D.Double getBoundingSuperRectangle() {
        return new java.awt.geom.Rectangle2D.Double(-500.0D, -500.0D, (double)(this.painterWidth + 500), (double)(this.painterHeight + 500));
    }

    public void setScreenLocation(int x, int y) {
        this.theFrame.setLocation(x, y);
    }

    public void wash() {
        Point p = new Point(0, 0);
        Dimension d = new Dimension(this.getWidth(), this.getHeight());
        Rectangle r = new Rectangle(p, d);
        this.gir.setPaint(Color.white);
        this.gir.fill(r);
        Graphics2D pg = (Graphics2D)this.getGraphics();
        this.update(pg);
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public void setRandomColor() {
        int rv = (int)(Math.random() * 256.0D);
        int gv = (int)(Math.random() * 256.0D);
        int bv = (int)(Math.random() * 256.0D);
        Color c = new Color(rv, gv, bv);
        this.color = c;
    }

    public void setRandomGreenColor() {
        int rv = Random.integer(0, 120);
        int gv = Random.integer(0, 120) + 130;
        int bv = Random.integer(0, 120);
        Color c = new Color(rv, gv, bv);
        this.color = c;
    }

    public void setRandomBlueColor() {
        int rv = Random.integer(0, 120);
        int bv = Random.integer(0, 120) + 130;
        int gv = Random.integer(0, 120);
        Color c = new Color(rv, gv, bv);
        this.color = c;
    }

    public void setRandomRedColor() {
        int bv = Random.integer(0, 120);
        int rv = Random.integer(0, 120) + 130;
        int gv = Random.integer(0, 120);
        Color c = new Color(rv, gv, bv);
        this.color = c;
    }

    public void saveColor() {
        this.savedColor = this.color;
    }

    public void restoreColor() {
        this.color = this.savedColor;
    }

    public void paint(SCircle c) {
        double x = this.location.getX() - c.radius();
        double y = this.location.getY() - c.radius();
        double w = c.diameter();
        double h = c.diameter();
        this.gir.setPaint(this.color);
        this.gir.fillOval((int)x, (int)y, (int)w, (int)h);
        Graphics pg = this.getGraphics();
        this.update(pg);
    }

    public void transfer(JFramelessPainter other) {
        Image image = other.image();
        this.gir.drawImage(image, 0, 0, (ImageObserver)null);
        Graphics pg = this.getGraphics();
        this.update(pg);
    }

    public void paintImage(BufferedImage image) {
        this.gir.drawImage(image, 0, 0, (ImageObserver)null);
        Graphics pg = this.getGraphics();
        this.update(pg);
    }

    public void updateGraphics() {
        Graphics pg = this.getGraphics();
        this.update(pg);
    }

    public void paint(SSquare s) {
        Polygon poly = new Polygon();
        Double p = null;
        this.mlt(s.side() / 2.0D);
        this.mbk(s.side() / 2.0D);
        this.mfd(s.side());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mfd(s.side());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mfd(s.side());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mfd(s.side());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mrt(s.side() / 2.0D);
        this.mfd(s.side() / 2.0D);
        this.gir.setPaint(this.color);
        this.gir.fillPolygon(poly);
        Graphics pg = this.getGraphics();
        this.update(pg);
    }

    public void paintLater(SSquare s) {
        Polygon poly = new Polygon();
        Double p = null;
        this.mlt(s.side() / 2.0D);
        this.mbk(s.side() / 2.0D);
        this.mfd(s.side());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mfd(s.side());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mfd(s.side());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mfd(s.side());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mrt(s.side() / 2.0D);
        this.mfd(s.side() / 2.0D);
        this.gir.setPaint(this.color);
        this.gir.fillPolygon(poly);
    }

    public void paint(SRectangle r) {
        Polygon poly = new Polygon();
        Double p = null;
        this.mlt(r.width() / 2.0D);
        this.mbk(r.height() / 2.0D);
        this.mfd(r.height());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mfd(r.width());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mfd(r.height());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mfd(r.width());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mrt(r.width() / 2.0D);
        this.mfd(r.height() / 2.0D);
        this.gir.setPaint(this.color);
        this.gir.fillPolygon(poly);
        Graphics pg = this.getGraphics();
        this.update(pg);
    }

    public void draw(SCircle c) {
        double x = this.location.getX() - c.radius();
        double y = this.location.getY() - c.radius();
        double w = c.diameter();
        double h = c.diameter();
        this.gir.setPaint(this.color);
        this.gir.drawOval((int)x, (int)y, (int)w, (int)h);
        Graphics pg = this.getGraphics();
        this.update(pg);
    }

    public void setFontSize(int fs) {
        Font f = new Font("Courier", 0, fs);
        this.gir.setFont(f);
    }

    public void draw(String s) {
        FontMetrics fm = this.gir.getFontMetrics();
        double width = (double)fm.stringWidth(s);
        double height = (double)fm.getHeight();
        this.mlt(width / 2.0D);
        this.mbk(height / 2.0D);
        int x = (int)this.location.getX();
        int y = (int)this.location.getY();
        this.gir.setPaint(this.color);
        this.gir.drawString(s, x, y);
        this.mrt(width / 2.0D);
        this.mfd(height / 2.0D);
        Graphics pg = this.getGraphics();
        this.update(pg);
    }

    public void draw(SSquare s) {
        Polygon poly = new Polygon();
        Double p = null;
        this.mlt(s.side() / 2.0D);
        this.mbk(s.side() / 2.0D);
        this.mfd(s.side());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mfd(s.side());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mfd(s.side());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mfd(s.side());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mrt(s.side() / 2.0D);
        this.mfd(s.side() / 2.0D);
        this.gir.setPaint(this.color);
        this.gir.drawPolygon(poly);
        Graphics pg = this.getGraphics();
        this.update(pg);
    }

    public void draw(SPolygon s) {
        if (Predicates.congruent(1, 4, s.degree())) {
            this.tl(360.0D / (double)s.degree() / 4.0D);
        } else if (Predicates.congruent(3, 4, s.degree())) {
            this.tl(360.0D / (double)s.degree() / 4.0D);
            this.tl(180.0D);
        } else if (Predicates.congruent(2, 4, s.degree())) {
            this.tl(360.0D / (double)s.degree() / 2.0D);
        }

        double side = s.side();
        SCircle cc = s.inscribingCircle();
        double radius = cc.radius();
        this.mlt(radius);
        this.mbk(side / 2.0D);
        Polygon poly = new Polygon();
        Double p = null;

        for(int i = 1; i <= s.degree(); ++i) {
            p = this.location;
            poly.addPoint((int)p.x, (int)p.y);
            this.mfd(side);
            this.tr(360.0D / (double)s.degree());
        }

        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.mfd(side / 2.0D);
        this.mrt(radius);
        if (Predicates.congruent(1, 4, s.degree())) {
            this.tr(360.0D / (double)s.degree() / 4.0D);
        } else if (Predicates.congruent(3, 4, s.degree())) {
            this.tr(360.0D / (double)s.degree() / 4.0D);
            this.tr(180.0D);
        } else if (Predicates.congruent(2, 4, s.degree())) {
            this.tr(360.0D / (double)s.degree() / 2.0D);
        }

        this.gir.setPaint(this.color);
        this.gir.drawPolygon(poly);
        Graphics pg = this.getGraphics();
        this.update(pg);
    }

    public Double mapPainterToAWT(Double location) {
        double x = this.center.x + location.x;
        double y = this.center.y = location.y;
        return new Double(x, y);
    }

    public void paint(SPolygon s) {
        new Double(this.location.x, this.location.y);
        new SCircle(8.0D);
        if (Predicates.congruent(1, 4, s.degree())) {
            this.tl(360.0D / (double)s.degree() / 4.0D);
        } else if (Predicates.congruent(3, 4, s.degree())) {
            this.tl(360.0D / (double)s.degree() / 4.0D);
            this.tl(180.0D);
        } else if (Predicates.congruent(2, 4, s.degree())) {
            this.tl(360.0D / (double)s.degree() / 2.0D);
        }

        double side = s.side();
        SCircle cc = s.inscribingCircle();
        double radius = cc.radius();
        this.mlt(radius);
        this.mbk(side / 2.0D);
        Polygon poly = new Polygon();
        Double p = null;

        for(int i = 1; i <= s.degree(); ++i) {
            p = this.location;
            poly.addPoint((int)p.x, (int)p.y);
            this.mfd(side);
            this.tr(360.0D / (double)s.degree());
        }

        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.mfd(side / 2.0D);
        this.mrt(radius);
        if (Predicates.congruent(1, 4, s.degree())) {
            this.tr(360.0D / (double)s.degree() / 4.0D);
        } else if (Predicates.congruent(3, 4, s.degree())) {
            this.tr(360.0D / (double)s.degree() / 4.0D);
            this.tr(180.0D);
        } else if (Predicates.congruent(2, 4, s.degree())) {
            this.tr(360.0D / (double)s.degree() / 2.0D);
        }

        this.gir.setPaint(this.color);
        this.gir.fillPolygon(poly);
        Graphics pg = this.getGraphics();
        this.update(pg);
    }

    public void draw(SRectangle r) {
        Polygon poly = new Polygon();
        Double p = null;
        this.mlt(r.width() / 2.0D);
        this.mbk(r.height() / 2.0D);
        this.mfd(r.height());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mfd(r.width());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mfd(r.height());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mfd(r.width());
        p = this.location;
        poly.addPoint((int)p.x, (int)p.y);
        this.tr();
        this.mrt(r.width() / 2.0D);
        this.mfd(r.height() / 2.0D);
        this.gir.setPaint(this.color);
        this.gir.drawPolygon(poly);
        Graphics pg = this.getGraphics();
        this.update(pg);
    }

    public void move() {
        int w = this.getWidth();
        int h = this.getHeight();
        int x = (int)(Math.random() * (double)w);
        int y = (int)(Math.random() * (double)h);
        this.location.setLocation((double)x, (double)y);
    }

    public void moveWithinNeighborhood(int d) {
        System.out.println("position = " + this.position());
        System.out.println("d = " + d);
        double heading = this.heading();
        double tempHeading = Math.random() * 360.0D;
        this.setHeading(tempHeading);
        double distance = Math.random() * (double)(d + 1);
        System.out.println("distance = " + distance);
        this.mfd(distance);
        this.setHeading(heading);
    }

    public void moveTo(Double p) {
        this.location.setLocation(p.getX(), p.getY());
    }

    public void moveTo(Point p) {
        this.location.setLocation((double)p.x, (double)p.y);
    }

    public void moveToCenter() {
        this.location.setLocation(this.center.getX(), this.center.getY());
    }

    public void faceNorth() {
        this.heading = 0.0D;
    }

    public void drawLineTo(Double p) {
        java.awt.geom.Line2D.Double line = new java.awt.geom.Line2D.Double(this.location, p);
        this.gir.setPaint(this.color);
        this.gir.draw(line);
        Graphics pg = this.getGraphics();
        this.update(pg);
        this.location = p;
    }

    public void drawLineToI(Double p) {
        java.awt.geom.Line2D.Double line = new java.awt.geom.Line2D.Double(this.location, p);
        this.gir.setPaint(this.color);
        this.gir.draw(line);
        Graphics pg = this.getGraphics();
        this.update(pg);
    }

    public void mfd(double d) {
        Double newp = (Double)this.newPosition(this.location, d);
        this.moveTo(newp);
    }

    public void mbk(double d) {
        this.ta();
        this.mfd(d);
        this.ta();
    }

    public void mlt(double d) {
        this.tl();
        this.mfd(d);
        this.tr();
    }

    public void mrt(double d) {
        this.tr();
        this.mfd(d);
        this.tl();
    }

    public void dfd(double d) {
        Double newp = (Double)this.newPosition(this.location, d);
        this.drawLineTo(newp);
    }

    public void dbk(double d) {
        this.ta();
        this.dfd(d);
        this.ta();
    }

    public void tr() {
        this.heading += 90.0D;
        if (this.heading >= 360.0D) {
            this.heading -= 360.0D;
        }

    }

    public void tl() {
        this.heading -= 90.0D;
        if (this.heading < 0.0D) {
            this.heading += 360.0D;
        }

    }

    public void ta() {
        this.tr();
        this.tr();
    }

    public void tr(double d) {
        this.heading += d;
        if (this.heading > 360.0D) {
            this.heading -= 360.0D;
        }

    }

    public void tl(double d) {
        this.heading -= d;
        if (this.heading < 0.0D) {
            this.heading += 360.0D;
        }

    }

    public Double random() {
        int w = this.getWidth();
        int h = this.getHeight();
        double x = Math.random() * (double)w;
        double y = Math.random() * (double)h;
        return new Double(x, y);
    }

    public Double center() {
        return this.center;
    }

    public Double position() {
        return new Double(this.location.x, this.location.y);
    }

    public void setBrushWidth(int w) {
        this.gir.setStroke(new BasicStroke((float)w));
    }

    public void paintFrame(Color c, int w) {
        SRectangle frame = this.frame();
        this.push();
        this.moveToCenter();
        this.setColor(c);
        this.setBrushWidth(w * 2);
        this.draw(frame);
        this.pop();
        this.setBrushWidth(1);
    }

    void push() {
        this.state.push(new JFramelessPainter.State(this.location, this.heading, this.color, this.brushWidth));
    }

    void pop() {
        JFramelessPainter.State s = (JFramelessPainter.State)this.state.pop();
        this.location = s.location;
        this.heading = s.heading;
        this.color = s.color;
        this.brushWidth = s.brushWidth;
    }

    public void setHeading(double d) {
        this.heading = d;
    }

    public SRectangle frame() {
        java.awt.geom.Rectangle2D.Double r = this.getBoundingRectangle();
        return new SRectangle(r.getHeight(), r.getWidth());
    }

    public double heading() {
        return this.heading;
    }

    static double cvtDegToRad(double d) {
        return d * 0.017453292519943295D;
    }

    Point2D newPosition(Point2D position, double distance) {
        double oldx = position.getX();
        double oldy = position.getY();
        double newx = oldx;
        double newy = oldy;
        double deltax = 0.0D;
        double deltay = 0.0D;
        if (this.heading == 360.0D) {
            this.heading = 0.0D;
        }

        if (this.heading == 0.0D) {
            newx = oldx;
            newy = oldy - distance;
        }

        double alpha;
        if (0.0D < this.heading && this.heading < 90.0D) {
            alpha = cvtDegToRad(this.heading);
            deltax = distance * Math.sin(alpha);
            deltay = distance * Math.cos(alpha);
            newx = oldx + deltax;
            newy = oldy - deltay;
        }

        if (this.heading == 90.0D) {
            newx = oldx + distance;
            newy = oldy;
        }

        if (90.0D < this.heading && this.heading < 180.0D) {
            alpha = cvtDegToRad(180.0D - this.heading);
            deltax = distance * Math.sin(alpha);
            deltay = distance * Math.cos(alpha);
            newx = oldx + deltax;
            newy = oldy + deltay;
        }

        if (this.heading == 180.0D) {
            newx = oldx;
            newy = oldy + distance;
        }

        if (180.0D < this.heading && this.heading < 270.0D) {
            alpha = cvtDegToRad(this.heading - 180.0D);
            deltax = distance * Math.sin(alpha);
            deltay = distance * Math.cos(alpha);
            newx = oldx - deltax;
            newy = oldy + deltay;
        }

        if (this.heading == 270.0D) {
            newx = oldx - distance;
            newy = oldy;
        }

        if (270.0D < this.heading && this.heading < 360.0D) {
            alpha = cvtDegToRad(360.0D - this.heading);
            deltax = distance * Math.sin(alpha);
            deltay = distance * Math.cos(alpha);
            newx = oldx - deltax;
            newy = oldy - deltay;
        }

        return new Double(newx, newy);
    }

    public Color paintBrushColor() {
        return this.color;
    }

    class State {
        Double location;
        Color color;
        double heading;
        int brushWidth;

        public State(Double l, double h, Color c, int bw) {
            this.location = l;
            this.color = c;
            this.heading = h;
            this.brushWidth = bw;
        }
    }
}
