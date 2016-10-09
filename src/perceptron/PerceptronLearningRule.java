package perceptron;
import java.util.Arrays;
import java.util.Random;

public class PerceptronLearningRule {
    public static void main(String args[]){
        double threshold = 1;
        double learningRate = 0.1;

        double[] weights = {0.0, 0.0,0.0};


        int[][][] trainingData = {
                {{0, 0,0}, {0}},
                {{0, 1,0}, {0}},
                {{1, 0,1}, {0}},
                {{1, 1,1}, {1}},
                {{1, 0,0}, {0}},
                {{0,0 ,1}, {0}},
                {{1, 1,0}, {0}},
                {{0, 1,1}, {0}},

        };
        Random random=new Random(232);

        System.out.println("WEIGHT: FIRST: "+weights[0]+" WEIGHT: SECOND "+weights[1]);

        while(true){
            int errorCount = 0;

            for(int i=0; i < trainingData.length; i++){
                System.out.println("Starting weights: " + Arrays.toString(weights));

                double weightedSum = 0;
                for(int ii=0; ii < trainingData[i][0].length; ii++) {
                    weightedSum += trainingData[i][0][ii] * weights[ii];
                }


                int output = 0;
                if(threshold <= weightedSum){
                    output = 1;
                }

                System.out.println("Target output: " + trainingData[i][1][0] + ", "
                        + "Actual Output: " + output);


                int error = trainingData[i][1][0] - output;


                if(error != 0){
                    errorCount++;
                }


                for(int ii=0; ii < trainingData[i][0].length; ii++) {
                    weights[ii] += (learningRate * error * trainingData[i][0][ii]);

                        System.out.println(ii+"glowny "+i);
                        System.out.println(error + " " + learningRate + " " + trainingData[i][0][ii]);

                }

                System.out.println("New weights: " + Arrays.toString(weights));
                System.out.println();
            }


            if(errorCount == 0){
                float fwieght[]={0.0f,0.0f};
                fwieght[0]=(float)weights[0];
                fwieght[1]=(float)weights[1];
                System.out.println("Final weights: " + Arrays.toString(weights));
                System.out.println(fwieght[0]*0+fwieght[1]*1);
                System.exit(0);

            }
        }
    }
}