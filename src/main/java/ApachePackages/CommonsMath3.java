package ApachePackages;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.linear.*;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.FastMath;

public class CommonsMath3 {
    public static void main(String[] args) {

        //DescriptiveStatistics
        DescriptiveStatistics stats = new DescriptiveStatistics();
        stats.addValue(10);
        stats.addValue(20);
        stats.addValue(30);
        System.out.println("Mean : " +stats.getMean());
        System.out.println("Std Deviation : " + stats.getStandardDeviation());

        //FastMath
        System.out.println("FastMath sqrt(2) : " + FastMath.sqrt(2));
        System.out.println("FastMath pow(3,3) : " + FastMath.pow(3,3));

        //RandomDataGenerator
        RandomDataGenerator rand = new RandomDataGenerator();
        System.out.println("Random Gaussian Mean=0, sd=1 : " + rand.nextGaussian(0,1));
        System.out.println("Random Integer Between 1 and 10: " + rand.nextInt(1,10));

        //Complex Number
        Complex c1 = new Complex(1,2);
        Complex c2 = new Complex(3,5);
        Complex sum = c1.add(c2);
        System.out.println("Sum of complex Numbers: " +sum);

        //Matrix Utility

        double[][] data = {{1,2},{3,4}};
        RealMatrix matrix = MatrixUtils.createRealMatrix(data);
        RealMatrix transpose = matrix.transpose();
        System.out.println("Original Matrix: " +matrix);
        System.out.println("Transpose Matrix: " +transpose);
    }
}


