package HW04Figure;

public class Rectangle implements Figures{
 private double width, length;

 public double getWidth() {
  return width;
 }

 public void setWidth(double width) {
  this.width = width;
 }

 public double getLength() {
  return length;
 }

 public void setLength(double length) {
  this.length = length;
 }

 public Rectangle(double width, double length) {
  super();
  this.width = width;
  this.length = length;
 }
 @Override
  public double square() {
   return length * width;
 }
}
