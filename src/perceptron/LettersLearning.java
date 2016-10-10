package perceptron;

import javafx.util.Pair;

import java.util.Random;

public class LettersLearning {
    public static void main(String[] args) {
        System.out.println("gdsfsf");
        ArtificialNeuron [] neurons=new ArtificialNeuron[100];
        for(int i=0;i<100;i++) {
            neurons[i] = new ArtificialNeuron();
            neurons[i].addInput(3);
        }

        Random rand=new Random(1);
        double sseMax=100000;
        ArtificialNeuron neuronMax=new ArtificialNeuron();

        for(int j=0;j<100;j++) {
            for (int i = 0; i < 3; i++) {
                //neurons[j].addInput(3);
                neurons[j].setInputWeight(i, rand.nextInt());

            }
            neurons[j] = LearningNeuron.learn(neurons[j]);
            if(neurons[j].sse<sseMax){
                sseMax=neurons[j].sse;
                neuronMax=neurons[j];
            }
        }
        System.out.println(sseMax);
        System.out.println(LearningNeuron.test(neuronMax));
        System.out.println(neuronMax.weightsToString());
    }
}
