package perceptron;
import java.util.ArrayList;
import java.util.List;

public class ArtificialNeuron
{

    private List<Double> Dendrites;
    private List<Double> Synapses;


    public ArtificialNeuron()
    {
        Dendrites = new ArrayList<>(100);
        Synapses = new ArrayList<>(100);
    }


    public double finalizeData(double membranePotential)
    {
        int output = 0;
        if(1 <= membranePotential){//threshold here
            output = 1;
        }
        return membranePotential;
    }


    public int getInputSize()
    {
        return Dendrites.size();
    }


    public void addInput(double value,double weigth)
    {
        Dendrites.add(value);
        Synapses.add(weigth);
    }
    public void addInput()
    {
        Dendrites.add(0.0);
        Synapses.add(0.0);
    }



    public void addInput(int count)
    {
        for(int i = 1; i <= count; i++)
        this.addInput();
    }

    public double getInputData(int index)
    {
        return Dendrites.get(index);
    }


    public void setInputData(int index, double value)
    {
        Dendrites.set(index, value);
    }


    public double getInputWeight(int index)
    {
        return Synapses.get(index);
    }


    public void setInputWeight(int index, double weight)
    {
        Synapses.set(index, weight);
    }
    public void addInputWeight(int index,double addition){
        double beforeValue=Synapses.get(index);
        Synapses.set(index,beforeValue+addition);
    }
    public String weightsToString(){
        String weights=new String();
        for (double item:Synapses) {
            weights+=" "+item;
        }
        return weights;
    }

    public double processCellNode(int index)
    {
        return (Dendrites.get(index)*Synapses.get(index));
    }


    public double getMembranePotential()
    {
        if(getInputSize() == 0)
            return -1;

        double sum = 0;
        for (int i = 0; i < getInputSize(); i++)
        sum+=processCellNode(i);

        return sum;
    }


    public double getOutput()
    {
        if(getInputSize() == 0)
            return -1;

        return finalizeData(getMembranePotential());
    }
}