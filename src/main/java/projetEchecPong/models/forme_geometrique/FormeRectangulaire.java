package projetEchecPong.models.forme_geometrique;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;

public class FormeRectangulaire extends Rectangle {
    public FormeRectangulaire(double x, double y, double width, double height) {
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
    }

    public List<Segment> getAllSegments() {
        List<Segment> segments = new ArrayList<Segment>();
        Segment s1 = new Segment(new Point2D(this.getX(), this.getY()),
                new Point2D(this.getX(), this.getY() + this.getHeight()));
        Segment s2 = new Segment(new Point2D(this.getX(), this.getY() + this.getHeight()),
                new Point2D(this.getX() + this.getWidth(), this.getY() + this.getHeight()));
        Segment s3 = new Segment(new Point2D(this.getX() + this.getWidth(), this.getY()),
                new Point2D(this.getX() + this.getWidth(), this.getY() + this.getHeight()));
        Segment s4 = new Segment(new Point2D(this.getX() + this.getWidth(), this.getY()),
                new Point2D(this.getX(), this.getY()));
        segments.addAll(List.of(s1, s2, s3, s4));
        return segments;
    }

    public Point2D getCentreGravite() {
        double x = this.getX() + (this.getWidth() / 2),
                y = this.getY() + (this.getHeight() / 2);
        return new Point2D(x, y);
    }

    public double getMinX() {
        return this.getX();
    }

    public double getMaxX() {
        return this.getX()+this.getWidth();
    }


    public double getMinY() {
        return this.getY();
    }

    public double getMaxY() {
        return this.getY()+this.getHeight();
    }
}
