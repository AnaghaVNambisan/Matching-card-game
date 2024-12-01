package mooc.vandy.java4android.shapes.logic;

import java.util.Locale;
import mooc.vandy.java4android.shapes.ui.OutputInterface;
import static java.lang.String.format;

/**
 * This is where the logic of this App is centralized for this assignment.
 */
public class Logic implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /*
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     */
    private final OutputInterface mOut;

    /**
     * This is the constructor of this class.
     */
    public Logic(OutputInterface out) {
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    @Override
    public void process() {
        // Get which calculation should be computed.  Do not worry
        // about the specifics of this right now.
        Shapes shapeForCalculations = mOut.getShape();

        // Store the values returned by the User Interface.
        double mLength = mOut.getLength();
        double mWidth = mOut.getWidth();
        double mHeight = mOut.getHeight();
        double mRadius = mOut.getRadius();

        // Determine which calculation to process right now.
        switch (shapeForCalculations) {
            case Box:
                mOut.print("A " + mLength + " by " + mWidth + " by " + mHeight + " box has a volume of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", boxVolume(mLength, mWidth, mHeight)));
                mOut.println();

                mOut.print("A " + mLength + " by " + mWidth + " by " + mHeight + " box has a surface area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", boxSurfaceArea(mLength, mWidth, mHeight)));
                mOut.println();
            case Rectangle:
                mOut.print("A " + mLength + " by " + mWidth + " rectangle has a perimeter of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", rectanglePerimeter(mLength, mWidth)));
                mOut.println();

                mOut.print("A " + mLength + " by " + mWidth + " rectangle has area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", rectangleArea(mLength, mWidth)));
                mOut.println();
                break;
            case Sphere:
                mOut.print("A sphere with radius " + mRadius + " has a volume of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", sphereVolume(mRadius)));
                mOut.println();

                mOut.print("A sphere with radius " + mRadius + " has surface area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", sphereSurfaceArea(mRadius)));
                mOut.println();
            case Circle:
                mOut.print("A circle with radius " + mRadius + " has a perimeter of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", circleCircumference(mRadius)));
                mOut.println();

                mOut.print("A circle with radius " + mRadius + " has area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", circleArea(mRadius)));
                mOut.println();
                break;
            case Triangle:
                mOut.print("A right triangle with base " + mLength + " and height " + mWidth + " has a perimeter of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", rightTrianglePerimeter(mLength, mWidth)));
                mOut.println();

                mOut.print("A right triangle with base " + mLength + " and height " + mWidth + " has area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", rightTriangleArea(mLength, mWidth)));
                mOut.println();
                break;
            default:
                break;
        }
    }

    // Geometry calculation methods

    public static double rectangleArea(double length, double width) {
        return length * width;
    }

    public static double rectanglePerimeter(double length, double width) {
        return 2 * (length + width);
    }

    public static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double circleCircumference(double radius) {
        return 2 * Math.PI * radius;
    }

    public static double rightTriangleArea(double base, double height) {
        return 0.5 * base * height;
    }

    public static double rightTrianglePerimeter(double base, double height) {
        double hypotenuse = Math.sqrt(base * base + height * height);
        return base + height + hypotenuse;
    }

    public static double boxVolume(double length, double width, double depth) {
        return length * width * depth;
    }

    public static double boxSurfaceArea(double length, double width, double depth) {
        return 2 * (length * width + width * depth + depth * length);
    }

    public static double sphereVolume(double radius) {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    public static double sphereSurfaceArea(double radius) {
        return 4 * Math.PI * radius * radius;
    }
}
