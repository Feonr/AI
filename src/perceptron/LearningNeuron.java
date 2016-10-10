package perceptron;

import java.util.Arrays;

public class LearningNeuron {
    public static int getThreshold() {
        return threshold;
    }

    public static double getLearningRate() {
        return learningRate;
    }

    public static void setThreshold(int threshold) {

        LearningNeuron.threshold = threshold;
    }

    //public static double  ssee=0;
    public static void setLearningRate(double learningRate) {
        LearningNeuron.learningRate = learningRate;
    }

    private static int threshold = 1;

    static double learningRate = 1;
    private static int[][][] trainingData = {
            {{0, 0, 0}, {0}},
            {{0, 1, 0}, {0}},
            {{1, 0, 1}, {0}},
            {{1, 1, 1}, {0}},
            {{1, 0, 0}, {1}},
            {{0, 0, 1}, {0}},
            {{1, 1, 0}, {0}},
            {{0, 1, 1}, {0}},

    };

    private static int activationFunction(double weightedSum) {
        int output = 0;
        if (threshold <= weightedSum) {
            output = 1;
        }
        return output;
    }

    private static double activationFunction2(double weightedSum) {
        return weightedSum;
    }

    public static ArtificialNeuron learn(ArtificialNeuron neuron) {
        // neuron.addInput(3);

        double sse = 0;
        int counter = 0;
        while (counter < (int) (7000 / trainingData.length)) {
            int errorCount = 0;
            // Loop over training data
            for (int i = 0; i < trainingData.length; i++) {
                int targetOutput = trainingData[i][1][0];

//                System.out.println("Starting weights: " + neuron.weightsToString());
                // Calculate weighted input
                double weightedSum = 0;
                for (int ii = 0; ii < trainingData[i][0].length; ii++) {
                    neuron.setInputData(ii, trainingData[i][0][ii]);
                }
                weightedSum = neuron.getMembranePotential();
                // Calculate output
                double output = 0;
                /*if(threshold <= weightedSum){
                    output = 1;
                }*/
                output = activationFunction(weightedSum);
//                System.out.println("Target output: " + targetOutput + ", "
//                        + "Actual Output: " + output);

                // Calculate error
                double error = targetOutput - output;
//                System.out.println("Error " + error);
                sse += error * error;
                // Increase error count for incorrect output
                if (error != 0) {
                    errorCount++;
                }

                // Update weights
                for (int ii = 0; ii < trainingData[i][0].length; ii++) {
                    neuron.addInputWeight(ii, learningRate * error * neuron.getInputData(ii));
                }

//                System.out.println("New weights: " + neuron.weightsToString());

            }

            // If there are no errors, stop
            /*if(errorCount == 0){
                float fwieght[]={0.0f,0.0f};

                System.out.println("Final weights: " + neuron.weightsToString());
                System.out.println(fwieght[0]*0+fwieght[1]*1);
                System.exit(0);

            }*/
            counter++;
        }
        System.out.println("Final weights: " + neuron.weightsToString());
        neuron.sse = sse;
        System.out.println("sse " + neuron.sse);
        System.out.println("mse "+neuron.sse/7000);

        return neuron;
    }

    public static boolean test(ArtificialNeuron neuron) {
        int counter = 0;

        while (counter < (int) (3000 / trainingData.length)) {
            int errorCount = 0;

            for (int i = 0; i < trainingData.length; i++) {
                int targetOutput = trainingData[i][1][0];

                System.out.println("Starting weights: " + neuron.weightsToString());
                // Calculate weighted input
                double weightedSum = 0;
                for (int ii = 0; ii < trainingData[i][0].length; ii++) {
                    neuron.setInputData(ii, trainingData[i][0][ii]);
                }
                weightedSum = neuron.getMembranePotential();
                // Calculate output
                double output = 0;
                /*if(threshold <= weightedSum){
                    output = 1;
                }*/
                output = activationFunction2(weightedSum);


                // Calculate error
                double error = targetOutput - output;

                if (error != 0) {
                    errorCount++;
                }

            }
            if (errorCount == 0) {
                float fwieght[] = {0.0f, 0.0f};
                return true;

            }
        }
        return false;
    }
}