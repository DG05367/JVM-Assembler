package Jasmin;

import java.util.*;

public class Instruction{
    String name;

    String label = new String();

    List<String> operands;

    public Instruction(){
        this.name = new String();
        this.operands = new ArrayList<String>();
    }

    public Instruction(String name){
        this.name = name;
        this.operands = new ArrayList<String>();
    }

    public Instruction(String name, String label){
        this.name = name;
        this.label = label;
        this.operands = new ArrayList<String>();
    }

    public boolean hasLabel(){
        return !this.label.equals("");
    }

    public String getLabel(){
        return this.label;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void addOperand(String op){
        operands.add(op);
    }

    public void addOperandPath(String op){
        int index = operands.size() - 1;
        if(index == -1) index = 0;

        if(operands.isEmpty())
        {
            operands.add(op);
        }
        else{
            operands.set(index, operands.get(index) + op);
        }
    }

    public List<String> getOperands(){
        return this.operands;
    }

}