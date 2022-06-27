package Jasmin;

import java.util.*;

public class Method{
    
    private String methodAccessModifier;

    private boolean isStatic;

    private String methodName;

    private List<String> parametersType;

    private String stack;
    
    private String locals;

    private List<Instruction> instructions;

    //Lista de instruções

    public Method(){
        this.methodAccessModifier = new String();
        this.isStatic = false;
        this.methodName = new String();
        this.parametersType = new ArrayList<String>();
        this.stack = new String();
        this.locals = new String();
        this.instructions = new ArrayList<Instruction>();
    }

    public Method(String methodAccessModifier, boolean isStatic){ 
        this.methodAccessModifier = methodAccessModifier;
        this.isStatic = isStatic;
    }

    public String getMethodAccessModifier() { return methodAccessModifier; }

    public boolean isStatic() { return isStatic; }

    public String getMethodName() { return methodName; }

    public void addParameter(String parameter){

        parametersType.add(parameter);

    }

    public void addInstruction(String instructionName, String doubleDot, String label){
        if(doubleDot.equals(":")){
            instructions.add(new Instruction(instructionName,label));
            return;
        }
        instructions.add(new Instruction(instructionName));
    }

    public void addOperandInst(String op){
        instructions.get(instructions.size() - 1).addOperand(op);
    }

    public void addOperandInstPath(String op){
        instructions.get(instructions.size() - 1).addOperandPath(op);
    }

    public void setMethodAccessModifier(String methodAccessModifier){
        this.methodAccessModifier= methodAccessModifier;
    }

    public void setStatic(boolean isStatic){
        this.isStatic = isStatic;
    }

    public void setMethodName(String methodName){
        this.methodName = methodName;
    }

    public void setStack(String stack){
        this.stack = stack;
    }

    public void setLocals(String locals){
        this.locals = locals;
    }
    
    public String getCodeMethod(){
        var code = new StringBuilder();

        code.append(".method ");

        code.append(this.getMethodAccessModifier()).append(" ");

        if(this.isStatic){

            code.append("static ");

        }

        code.append(this.getMethodName());

        code.append(this.getParametersCode()); 

        code.append(this.getLimitsCode());

        code.append(this.getInstructionsCode());       

        code.append("\n\n");

        code.append(".end method\n");    

        return code.toString();
    }

    private String getParametersCode(){
        var code = new StringBuilder();
        code.append("(");

        for(var pType: parametersType){
            code.append(pType);
        }

        if(!parametersType.isEmpty()){
            if(!parametersType.get(parametersType.size()-1).contains(")")){
                code.append(")");
                code.append("\n");
            }
        }
        else{
            code.append(")");
            code.append("\n");
        }



        return code.toString();
    }

    private String getLimitsCode(){
        var code = new StringBuilder();
        if(!this.locals.equals("")){
            code.append("\t\t.limit ")
                .append("locals ")
                .append(this.locals);
            code.append("\n");
        }

        if(!this.stack.equals("")){
            code.append("\t\t.limit ")
                .append("stack ")
                .append(this.stack);
            code.append("\n");
        }
        code.append("\n\n");
        return code.toString();
    }

    private String getInstructionsCode(){
        var code = new StringBuilder();

        for(var inst: instructions){
            if(inst.hasLabel()){
                code.append("\t")
                    .append(inst.getLabel())
                    .append(":\n");
            }
            code.append("\t\t")
                .append(inst.getName()).append(" ");
            
            if(!(inst.getOperands().isEmpty())){
                for(var op: inst.getOperands()){
                    code.append(op).append(" ");
                }
            }    
            code.append("\n");    
        }
        
        return code.toString();
    }

}