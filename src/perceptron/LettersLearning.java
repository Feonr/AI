package perceptron;

public class LettersLearning {
    public static void main(String[] args) {
        ArtificialNeuron neuron=new ArtificialNeuron();
        neuron=LearningNeuron.learn(neuron);
    }
}
